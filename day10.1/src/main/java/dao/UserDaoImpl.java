package dao;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Role;
import pojos.User;

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
		// user : TRANSIENT (not in L1 cache , not in DB, exists only in heap)
		// get hibernate session from SF
		Session session = getFactory().getCurrentSession();// new session
		// begin tx
		Transaction tx = session.beginTransaction();// session object created with empty L1 cache
		Session session2 = getFactory().getCurrentSession();// existing session
		System.out.println(session == session2); // true
		System.out.println("is open " + session.isOpen() + " connected with db cn " + session.isConnected());// t t
		try {
			// Method of Session i/f : public Serializable save(Object o)
			// o : User pojo reference.
			session.save(user);// user : PERSISTENT => pojo ref added in L1 cache BUT not in db
			tx.commit();// Hibernate performs auto dirty checking , @ commit , results in DML : insert
			// session is auto closed resulting in L1 cache destroyed , db cn rets to the
			// conn pool
			System.out.println("is open " + session.isOpen() + " connected with db cn " + session.isConnected());// f f

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
			user = session.get(User.class, userId);// int --> Integer ---> Serializable /thus line is written 3 times
													// because
			// it shows that if at first time user is get then 2nd and 3rd time it will take
			// data from the L1 cache
			// but if user is not get and return null then second time it will do the whole
			// process
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
	public User AuthenticateUser(String email, String password) {
		User user = null;
		String status;
		String jpql="select u from User u where u.email=:mail and u.password=:pass ";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
              user=session.createQuery(jpql,User.class).setParameter("mail", email).setParameter("pass", password).getSingleResult();
              
              tx.commit();
		} catch (RuntimeException e) {

			if (tx != null) {
				tx.rollback();
				throw e;

			}
		}
		if(user!=null)
        {
      	   status="Login successfull";
      	   return user;
        }

		return null;
	}

	@Override
	public User UpdatePassword(int userId, String newPassword) {
		User user = null;

		Session session = getFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();
		try {

			user = session.get(User.class, userId);
			if(user!=null)
			user.setPassword(newPassword);
			tx.commit();
			return user;
		} catch (RuntimeException e) {

			if (tx != null) {
				tx.rollback();
				throw e;

			}
			return user;
	}

	}

	@Override
	public List<User> getCustomerByDate(LocalDate date,Role rl) {
		List<User> users=null;
		String jpql="select u from User u where u.userRole=:role and u.regDate>:dt order by u.regAmount";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
		users=session.createQuery(jpql, User.class).setParameter("role",rl).setParameter("dt", date).getResultList();	
		tx.commit();
		} catch (RuntimeException e) {

			if (tx != null) {
				tx.rollback();
				throw e;

			}
		

	}
		return users;
	}
}
