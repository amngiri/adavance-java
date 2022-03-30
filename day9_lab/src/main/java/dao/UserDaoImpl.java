package dao;

import pojos.User;
import org.hibernate.*;
import static utils.HibernateUtils.getFactory;

public class UserDaoImpl implements IUserDao {

	@Override
	public String registerUser(User user) {
		// get hibernate session from SF
		Session session = getFactory().openSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			//Method of Session i/f : public Serializable save(Object o) 
			//o : User pojo reference.
			session.save(user);
			tx.commit();//changes in the object layer will be synchronized to DB (DML : insert)
		} catch (RuntimeException e) {
			// rollback tx
			if (tx != null)
				tx.rollback();
			throw e;// re throw the same exception to the caler , so that caller(Tester) , knows
					// something went wrong in the dao layer.
		} finally {
			if(session != null)
				session.close();//pooled out cn rets to the pool.
		}
		return "User registered with ID "+user.getUserId();
	}

}
