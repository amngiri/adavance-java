package dao;

import pojos.Role;
import pojos.User;

import org.apache.commons.io.FileUtils;
import org.hibernate.*;
import static utils.HibernateUtils.getFactory;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

public class UserDaoImpl implements IUserDao {

	@Override
	public String registerUser(User user) {
		// user : TRANSIENT (not in L1 cache , not in DB, exists only in heap)
		// get hibernate session from SF
		Session session = getFactory().openSession();
		// begin tx
		Transaction tx = session.beginTransaction();// session object created with empty L1 cache
		Session session2 = getFactory().openSession();
		System.out.println(session == session2); // false
		System.out.println("is open " + session.isOpen() + " connected with db cn " + session.isConnected());// t t
		try {
			// Method of Session i/f : public Serializable save(Object o)
			// o : User pojo reference.
			session.save(user);// user : PERSISTENT => pojo ref added in L1 cache BUT not in db
			tx.commit();// Hibernate performs auto dirty checking , @ commit , results in DML : insert
			System.out.println("is open " + session.isOpen() + " connected with db cn " + session.isConnected());// t t

		} catch (RuntimeException e) {
			// rollback tx
			if (tx != null)
				tx.rollback();
			throw e;// re throw the same exception to the caller , so that caller(Tester) , knows
					// something went wrong in the dao layer.
		} finally {
			if (session != null)
				session.close();// L1 cache(persistence ctx) is destroyed , pooled out cn rets to the pool ,
								// closing the session
			System.out.println("is open " + session.isOpen() + " connected with db cn " + session.isConnected());// f f

		}
		// user : DETACHED
		return "User registered with ID " + user.getUserId();
	}

	@Override
	public String registerUserWithGetCurntSession(User user) {

		// user : DETACHED (a pojo ref having non null id , having MATCHING record in
		// DB)
		// get hibernate session from SF
		Session session = getFactory().getCurrentSession();// new session
		// begin tx
		Transaction tx = session.beginTransaction();// session object created with empty L1 cache

		try {
			// Method of Session i/f : public Serializable save(Object o)
			// o : User pojo reference.
			session.update(user);// user : PERSISTENT => pojo ref added in L1
									// cache BUT not updated in db yet

			tx.commit();// Hibernate performs auto dirty checking , @ commit , results in DML : update
			// session is auto closed resulting in L1 cache destroyed , db cn rets to the
			// conn pool
		} catch (RuntimeException e) {
			// rollback tx
			if (tx != null)
				tx.rollback();
			throw e;// re throw the same exception to the caller , so that caller(Tester) , knows
					// something went wrong in the dao layer.
		}
		// user : DETACHED
		return "User registered with ID " + user.getUserId();
	}

	@Override
	public User getUserDetails(int userId) {
		User user = null;// user : null (NA)
		// get session from SF : getCurntSession
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			// retrieve user details : Session API : public <T> T get(Class<T>
			// class,Serializable id) throws HibExc
			user = session.get(User.class, userId);// int --> Integer ---> Serializable
			// user != null , user : PERSISTENT
			user = session.get(User.class, userId);// int --> Integer ---> Serializable
			// user != null , user : PERSISTENT
			user = session.get(User.class, userId);// int --> Integer ---> Serializable
			// user != null , user : PERSISTENT
			tx.commit();// auto dirty chking -- no change , no DMLs , L1 cache destroyed , cn rets to
						// the pool , session closed
		} catch (RuntimeException e) {
			// rollback tx
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return user;// user : DETACHED
	}

	@Override
	public List<User> getAllUserDetails() {
		List<User> users = null;
		String jpql = "select u from User u";
		// get session from SF : getCurntSession
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			users = session.createQuery(jpql, User.class).getResultList();// users : list of PERSISTENT pojos
			users.forEach(u -> u.setRegAmount(u.getRegAmount() - 50));// state of PERSISTENT entities is getting
																		// modified.
//			session.clear();//state of all entities : DETACHED
			tx.commit();// Hibernate performs auto dirty chking => state is dirty => update query is
						// fired to sync state of L1 cache with that of the DB
		} catch (RuntimeException e) {
			// rollback tx
			if (tx != null)
				tx.rollback();
			throw e;
		}
		users.forEach(u -> u.setRegAmount(u.getRegAmount() - 50));// updating the state of DETACHED pojos --> since no
																	// session , no L1 cache --> DOES NOT propagate
																	// changes to DB
		return users;// users : list of DETACHED pojos
	}

	@Override
	public List<User> getSelectedUserDetails(LocalDate beginDate, LocalDate endDate, Role userRole) {
		List<User> users = null;
		String jpql = "select u from User u where u.regDate between :start_date and :end_date and u.userRole=:role";
		// get session from SF : getCurntSession
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			users = session.createQuery(jpql, User.class).setParameter("start_date", beginDate)
					.setParameter("end_date", endDate).setParameter("role", userRole).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			// rollback tx
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return users;
	}

	@Override
	public List<String> getSelectedUserNames(LocalDate beginDate, LocalDate endDate, Role userRole) {

		String jpql = "select u.name from User u where u.regDate between :start_date and :end_date and u.userRole=:role";
		List<String> names = null;
		// get session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			names = session.createQuery(jpql, String.class).setParameter("start_date", beginDate)
					.setParameter("end_date", endDate).setParameter("role", userRole).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return names;
	}

	@Override
	public List<User> getSomeUserDetails(LocalDate beginDate, LocalDate endDate, Role userRole) {
		List<User> users = null;
		// name, String email, double regAmount, LocalDate regDate
		String jpql = "select new pojos.User(name,email,regAmount,regDate) from User u where u.regDate between :start_date and :end_date and u.userRole=:role";
		// get session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			users = session.createQuery(jpql, User.class).setParameter("start_date", beginDate)
					.setParameter("end_date", endDate).setParameter("role", userRole).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return users;
	}

	@Override
	public String unsubscribeUser(int userId) {
		String mesg = "User un subscription failed : invalid user id";
		// get session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			// how to get persistent user ref from user id ?
			User user = session.get(User.class, userId);
			if (user != null) {
				// valid user id
				session.delete(user);// marked for removal , user : REMOVED
				mesg = "User un subscription succeeded";
			}
			tx.commit(); // delete query , session closed , user : TRANSIENT
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}// after method rets : are there any candidates for GC ? YES --user object

	@Override
	public String saveImage(String email, String fileName) throws Exception {
		String mesg = "saving image failed ...";
		String jpql = "select u from User u where u.email=:em";

		// get session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			User user = session.createQuery(jpql, User.class).setParameter("em", email).getSingleResult();
			// => valid user id (o.w hibernate throws NoResultExc)
			// user : PERSISTENT
			// validate file : create file cls instace n use exists ....
			File file = new File(fileName);
			if (file.exists() && file.isFile() && file.canRead()) {
				// valid file , continue to set image
				user.setImage(FileUtils.readFileToByteArray(file));
				mesg = "Saving image in db successful";

			} else
				mesg = "saving image failed : invalid file name";
			tx.commit();// auto dirty chking by hibernate ---> update query
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public String restoreImage(int userId, String fileName) throws Exception {
		String mesg = "restoring image failed ...";
		// get session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			// get user details from user id
			User user = session.get(User.class, userId);
			if (user != null) {
				//valid user id , user : PERSISTENT
				byte[] imageData=user.getImage();
				FileUtils.writeByteArrayToFile(new File(fileName), imageData);
				mesg="image restored successfully from db...";
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public String updateRegAmount(LocalDate date,double dis) {
		String jpql="update User u set u.regAmount=u.regAmount-:disc where u.regDate < :dt";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			int i=session.createQuery(jpql).setParameter("disc", dis).setParameter("dt", date).executeUpdate();
			tx.commit();
			if(i>0)
			return "Update succesfull";
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return "Update unsuccesfull";
	}

	@Override
	public String deleteUser(LocalDate date,Role userRole) {
		String jpql="delete from User u where u.regDate > :dt and u.userRole=:customer";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
		    int i=session.createQuery(jpql).setParameter("dt", date).setParameter("customer", userRole).executeUpdate();
			tx.commit();
			if(i>0)
			return "deletion succesfull";
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return "deletion unsuccesfull";
	}

}
