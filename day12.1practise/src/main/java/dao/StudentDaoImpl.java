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
			Course c = session.createQuery(jpql, Course.class).setParameter("name", courseName).getSingleResult();
			// =>valid course name(title) => course exists!
			// c : PERSISTENT
			c.addStudent(s);// modifying state of persistent entity
			// session.persist(s); no longer required : since added cascading !
			tx.commit();// hib auto dirty chking : due to cascading --insertion of a rec in students
						// tbale
			mesg = "student admission successful";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public String cancelAdmission(String courseTitle, int studentId) {
		String mesg = "Cancelling admission failed";
		String jpql = "select c from Course c where c.title=:name";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			// get PERSISTENT Course POJO from the course name
			Course c = session.createQuery(jpql, Course.class).
					setParameter("name", courseTitle).getSingleResult();
			// =>valid course name(title) => course exists!
			// c : PERSISTENT
			// get student from it's id
			Student s = session.get(Student.class, studentId);
			if (s != null) {
				c.removeStudent(s);
				mesg = "Cancelled admission for student " + s.getName();
			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

}
