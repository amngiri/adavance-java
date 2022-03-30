package pojos;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

//embeddable value type : UDT 
@Embeddable
public class EducationalQualifications {
	//type (enum), year , % marks
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private EduType type;
	private int year;
	private int marks;
	public EducationalQualifications() {
		// TODO Auto-generated constructor stub
	}
	public EducationalQualifications(EduType type, int year, int marks) {
		super();
		this.type = type;
		this.year = year;
		this.marks = marks;
	}
	public EduType getType() {
		return type;
	}
	public void setType(EduType type) {
		this.type = type;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "EducationalQualifications [type=" + type + ", year=" + year + ", marks=" + marks + "]";
	}
	
	

}
