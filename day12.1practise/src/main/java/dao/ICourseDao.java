package dao;

import pojos.Course;

public interface ICourseDao {
	// add new method to insert new course details
	String launchNewCourse(Course transientCourse);

	// add new method to delete a course
	String cancelCourse(int courseId);

	// add a new method to get ONLY course details
	Course getCourseDetails(String title);

	// add a new method to get course + enrolled student details
	Course getCourseNStudentDetails(String title);
	
	// add a new method to get course + enrolled student details : using join fetch
		Course getCourseNStudentDetailsJoinFetch(String title);
}
