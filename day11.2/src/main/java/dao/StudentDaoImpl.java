package dao;

import pojos.Course;
import pojos.Student;
import static utils.HibernateUtils.getFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDaoImpl implements IStudentDao {

	@Override
	public String admitNewStudent(String courseName, Student s) {
		String jpql = "select c from Course c where c.title=:name";
		String mesg = "student admission failed";
		// get session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			// get PERSISTENT Course POJO from the course name
			Course c = session.createQuery(jpql, Course.class).
					setParameter("name", courseName).getSingleResult();
			//=>valid course name(title)
			s.setChosenCourse(c);//which link are we establishing here ?  s -->c
			//add student ref in the course
			c.getStudents().add(s);//which link are we establishing here ? c--->s 
			session.persist(s);
			tx.commit();
			mesg = "student admission successful";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

}
