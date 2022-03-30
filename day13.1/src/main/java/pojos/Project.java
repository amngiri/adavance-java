package pojos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "projects_tbl")
public class Project extends BaseEntity {
	@Column(length = 100, unique = true,name="project_title")
	private String projectTitle;
	@Column(length = 100)
	private String technology;
	@Column(name="completion_date")
	private LocalDate completionDate;
	// many -to -many : uni dir
	// Project *----->* Student
	@ManyToMany // mandatory
	@JoinTable(name = "projects_students", 
	joinColumns = @JoinColumn(name = "project_id"), 
	inverseJoinColumns = @JoinColumn(name = "student_id"))
	private Set<Student> students = new HashSet<>();

	public Project() {
		// TODO Auto-generated constructor stub
	}

	public Project(String projectTitle, String technology, LocalDate completionDate) {
		super();
		this.projectTitle = projectTitle;
		this.technology = technology;
		this.completionDate = completionDate;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public LocalDate getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(LocalDate completionDate) {
		this.completionDate = completionDate;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public void addStudent(Student s)
	{
		students.add(s);
	}
	public void removeStudent(Student s)
	{
		students.remove(s);
	}

	@Override
	public String toString() {
		return "Project ID " + getId() + "[projectTitle=" + projectTitle + ", technology=" + technology
				+ ", completionDate=" + completionDate + "]";
	}

}
