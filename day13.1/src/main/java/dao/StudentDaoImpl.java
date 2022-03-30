package dao;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Address;
import pojos.AdharCard;
import pojos.Course;
import pojos.EducationalQualifications;
import pojos.Project;
import pojos.Student;

public class StudentDaoImpl implements IStudentDao {

	@Override
	public String launchNewProject(Project transientProject) {
		Session session = getFactory().getCurrentSession();
		String msg="cant launch project";
		Transaction tx=session.beginTransaction();
		try {
			session.persist(transientProject);
			tx.commit();
			msg= "project launched";
		}catch (RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
			throw e;
			
		}
		return msg;
	}

	

	@Override
	public String addStudentToProject(String mail, String title) {
		String jpql1="select s from Student s where s.email=:em";
		String jpql2="select p from Project p where p.projectTitle=:ptitle";
		Session session = getFactory().getCurrentSession();
		String msg="cant add student to project";
		Transaction tx=session.beginTransaction();
		try {
			
			Student s=session.createQuery(jpql1,Student.class).setParameter("em", mail).getSingleResult();
			Project p=session.createQuery(jpql2,Project.class).setParameter("ptitle", title).getSingleResult();
			p.addStudent(s);
			tx.commit();
			msg="Student added to the project";
		}catch (RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
			throw e;
			
		}
		return msg;
	}


	@Override
	public String removeStudentToProject(String mail, String title) {
		String jpql1="select s from Student s where s.email=:em";
		String jpql2="select p from Project p where p.projectTitle=:ptitle";
		Session session = getFactory().getCurrentSession();
		String msg="cant remove student from project";
		Transaction tx=session.beginTransaction();
		try {
			
			Student s=session.createQuery(jpql1,Student.class).setParameter("em", mail).getSingleResult();
			Project p=session.createQuery(jpql2,Project.class).setParameter("ptitle", title).getSingleResult();
			p.removeStudent(s);
			tx.commit();
			msg="Student removed the project";
		}catch (RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
			throw e;
			
		}
		return msg;
	}


	@Override
	public Set<Student> DisplayAllStudentWorkingInProject(String title) {
		String jpql="select p from Project p join fetch p.students where p.projectTitle=:name";
		//String jpql="select p from Project p join fetch p.students s join fetch s.hobbies where p.projectTitle=:name";
		//(to fetch hobbies of a student working a department by getting project titile )
		Project p=null;
		Set<Student> studentsname=new HashSet<>();
		Session session = getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			p =session.createQuery(jpql,Project.class).setParameter("name", title).getSingleResult();
			studentsname=p.getStudents();
			//studentsname.forEach(h->h.getHobbies().size()); (calling hoobies to get rid of lazy initilization)
			tx.commit();
		}catch (RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
			throw e;
			
		}
		return studentsname;
	}



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
		} catch (RuntimeException e) 
		{
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
			Course c = session.createQuery(jpql, Course.class).setParameter("name", courseTitle).getSingleResult();
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

	@Override
	public String linkAdharCard(int studentId, AdharCard card) {
		String mesg = "Linking adhar card failed!!!!!";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			// get persistent student ref from its id
			Student s = session.get(Student.class, studentId);
			if (s != null) {
				// s : PERSISTENT
				s.setCard(card);
				mesg = "Linking adhar card successful";
			}
			tx.commit();// update
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return mesg;
	}

	@Override
	public List<String> getStudentNamesByAdharCardCreationDate(LocalDate start1, LocalDate end1) {
		List<String> names=null;
		String jpql="select s.name from Student s where s.card.creationDate between :start and :end";

		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			names=session.createQuery(jpql, String.class).
					setParameter("start",start1).
					setParameter("end",end1).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return names;
	}

	@Override
	public String insertCompleteStudentDetails(String email, Address a, AdharCard card, List<String> hobbies,
			List<EducationalQualifications> qualifications) {
		String mesg="Insertion of complete details failed...";
		String jpql="select s from Student s where s.email=:em";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			//get persistent student ref : email (jpql)
			Student s=session.createQuery(jpql, Student.class).setParameter("em", email).getSingleResult();//select
			//=> s : PERSISTENT
			//link student's address, address ---> student
			//first link adr --> student 
			a.setStudent(s);//comment this line : try it out in the lab : id generation exc.
			session.persist(a);
			//link adhar card
			s.setCard(card);
			//link hobbies 
			s.setHobbies(hobbies);
			//link edu qualifications
			s.setQualifications(qualifications);			
			tx.commit();//sql : insert : adr , hobbies, qualifications , update : student
			mesg="Insertion of complete details successful";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}
	

}
