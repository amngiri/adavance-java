package dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import pojos.Address;
import pojos.AdharCard;
import pojos.EducationalQualifications;
import pojos.Project;
import pojos.Student;

public interface IStudentDao {
	// add a new method for student admisssion
	String admitNewStudent(String courseName, Student s);

	// add a method to cancel student admission
	String cancelAdmission(String courseTitle, int studentId);

	// add a method to link adhar card details
	String linkAdharCard(int studentId, AdharCard card);

	// add a method to get student name by adhar card creation date
	List<String> getStudentNamesByAdharCardCreationDate(LocalDate start, LocalDate end);

	// add a method to populate COMPLETE details of the existing student
	String insertCompleteStudentDetails(String email, Address a, AdharCard card, List<String> hobbies,
			List<EducationalQualifications> qualifications);
	//launching a new project
     String launchNewProject(Project transientProject);
     //add student to the project
     String addStudentToProject(String mail, String title);
     //removing student from a project
     String removeStudentToProject(String mail, String title);
     Set<Student> DisplayAllStudentWorkingInProject(String title);
}
