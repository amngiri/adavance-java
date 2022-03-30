package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//Student : many side of the asso , child side , owning side (will contain later FK ---> referencing to PK of courses table)
@Entity
@Table(name = "students_tbl")
public class Student extends BaseEntity {
	@Column(length = 20)
	private String name; 
	@Column(length = 20, unique = true)
	private String email;
	// what should be the additional prop for mapping a bi-dir association , so that
	// one can find out chosen course's details from student?
	// Course 1<---- *Student
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_id", nullable = false) // => NOT NULL constraint
	private Course chosenCourse;
	// Entity ---> Value type
	@Embedded // OPTIONAL , added only for understanding
	private AdharCard card;
	// one to many mapping (collection of basic types : String) between
	// Entity(Student) ----> Hobbies(basic value type)
	@ElementCollection // Mandatory for configuring collection of basic value types
	@CollectionTable(name = "student_hobbies",joinColumns = @JoinColumn(name="student_id"))
	@Column(length = 100)
	private List<String> hobbies = new ArrayList<>();
	//entity 1--->* value type , collection of embeddables
	@ElementCollection //MANDATORY
	@CollectionTable(name="student_qualifications",joinColumns = @JoinColumn(name="student_id"))
	private List<EducationalQualifications> qualifications=new ArrayList<>();

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

	public AdharCard getCard() {
		return card;
	}

	public void setCard(AdharCard card) {
		this.card = card;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}
	

	public List<EducationalQualifications> getQualifications() {
		return qualifications;
	}

	public void setQualifications(List<EducationalQualifications> qualifications) {
		this.qualifications = qualifications;
	}

	@Override
	public String toString() {
		return "Student ID " + getId() + "[name=" + name + ", email=" + email + "]";
	}

	// for correct n efficient working of hashing alog, in a hashset : override
	// hashCode n equals (BOTH parts of the contract)
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

}
