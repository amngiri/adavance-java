package dao;

import pojos.Course;

public interface ICourseDao {
	//add new method to insert new course details
	String launchNewCourse(Course transientCourse);
}
