package dao;

import pojos.Student;

public interface IStudentDao {
	//add a new method for student admisssion
	String admitNewStudent(String courseName,Student s);
	//add a method to cancel student admission
	String cancelAdmission(String courseTitle,int studentId);
}
