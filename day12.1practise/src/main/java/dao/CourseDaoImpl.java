package dao;

import static utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Course;

public class CourseDaoImpl implements ICourseDao {

	@Override
	public String launchNewCourse(Course transientCourse) {
		// get session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			session.persist(transientCourse);// transientCourse : persistent
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return "Launched new course with ID " + transientCourse.getId();
	}

	@Override
	public String cancelCourse(int courseId) {
		String mesg = "Cancelling course failed....";
		// get session from SF
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			// get course from course id
			Course c = session.get(Course.class, courseId);
			if (c != null) {
				session.delete(c);// c : REMOVED : it;s only marked for removal
				mesg = "Course cancelled ....";
			}
			tx.commit();// associated child recs(student) n then parent rec will be deleted due to
						// cascading.
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public Course getCourseDetails(String title) {
		Course c = null;
		String jpql = "select c from Course c where c.title=:name";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			c = session.createQuery(jpql, Course.class).setParameter("name",title).getSingleResult();
			//c : PERSISTENT
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return c;// c : DETACHED
	}
	@Override
	public Course getCourseNStudentDetails(String title) {
		Course c = null;
		String jpql = "select c from Course c where c.title=:name";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			c = session.createQuery(jpql, Course.class).setParameter("name",title).getSingleResult();
			//c : PERSISTENT
			c.getStudents().size();//trying to access un fetched data , from within session ctx --results into an additional query fired on students table
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return c;// c : DETACHED
	}
	@Override
	public Course getCourseNStudentDetailsJoinFetch(String title) {
		Course c = null;
		String jpql = "select c from Course c left outer join fetch c.students where c.title=:name";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			c = session.createQuery(jpql, Course.class).setParameter("name",title).getSingleResult();
			//c : PERSISTENT
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return c;// c : DETACHED
	}

}
