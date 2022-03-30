package pojos;
//courses  Table columns : id,title, start_date , end_date , fees , capacity

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//Course : one side of the asso,parent side , inverse side
@Entity
@Table(name="courses_tbl")
public class Course extends BaseEntity {
	@Column(length = 30,unique = true)
	private String title;
	@Column(name="start_date")
	private LocalDate startDate;
	@Column(name="end_date")
	private LocalDate endDate;
	private double fees;
	private int capacity;
	// if u want to establish one ---> many association(HAS-A) between course n student , do u
	// need to add any additional property ? YES 
	//Course 1 -----> * Student
	@OneToMany(mappedBy = "chosenCourse")
	private List<Student> students=new ArrayList<>();//ALWAYS init collection to empty collection.

	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Course(String title, LocalDate startDate, LocalDate endDate, double fees, int capacity) {
		super();
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fees = fees;
		this.capacity = capacity;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
//TIP : NEVER ADD association fields(eg : students) in toString
	@Override
	public String toString() {
		return "Course Id " + getId() + "[title=" + title + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", fees=" + fees + ", capacity=" + capacity + "]";
	}

}
