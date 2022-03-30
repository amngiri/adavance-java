package pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//Student : many side of the asso , child side , owning side (will contain later FK ---> referencing to PK of courses table)
@Entity
@Table(name="students_tbl")
public class Student extends BaseEntity {
	@Column(length = 20)
	private String name;
	@Column(length = 20,unique = true)
	private String email;
	// what should be the additional prop for mapping a bi-dir association , so that
	// one can find out chosen course's details from student?
	//Course 1<---- *Student
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course chosenCourse;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Course getChosenCourse() {
		return chosenCourse;
	}

	public void setChosenCourse(Course chosenCourse) {
		this.chosenCourse = chosenCourse;
	}

	@Override
	public String toString() {
		return "Student ID " + getId() + "[name=" + name + ", email=" + email + "]";
	}

}
