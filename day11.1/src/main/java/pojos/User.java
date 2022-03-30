package pojos;

import java.time.LocalDate;
import javax.persistence.*;//all JPA annotations

/*
 * userId (PK) ,name,email,password,confirmPassword,role(enum), regAmount;
	 LocalDate/Date regDate;
	 byte[] image;
 */
@Entity //mandatory
@Table(name = "users_tbl")
//Is it mandatory as per hibernate/JPA specs to make POJO class Serializable  ? NO
//BUT data type of PK (simple / Composite) MUST be Serializable
public class User {
	@Id //mandatory => PK constraint : user supplied.
	@GeneratedValue(strategy = GenerationType.IDENTITY)//=> auto increment 
	@Column(name = "user_id")
	private Integer userId;
	@Column(length = 30) //varchar(30)
	private String name;
	@Column(length = 30,unique = true) //varchar(30) , unique constraint
	private String email;
	@Column(length = 20)//varchar(20)
	private String password;
	@Transient
	private String confirmPassword;
	@Enumerated(EnumType.STRING) // varchar => enum constant name
	@Column(name="role",length = 20)
	private Role userRole;
	@Column(name="reg_amount")
	private double regAmount;
	@Column(name="reg_date") //def column type : date
	private LocalDate regDate;
	@Lob //column : longblob
	private byte[] image;
	public User() {
		System.out.println("in user ctor");
	}
	public User(String name, String email, String password, String confirmPassword, Role userRole, double regAmount,
			LocalDate regDate) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.userRole = userRole;
		this.regAmount = regAmount;
		this.regDate = regDate;
	}
	//add overloaded ctor : to test constructor expresssion
	public User(String name, String email, double regAmount, LocalDate regDate) {
		super();
		this.name = name;
		this.email = email;
		this.regAmount = regAmount;
		this.regDate = regDate;
	}
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public Role getUserRole() {
		return userRole;
	}
	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}
	public double getRegAmount() {
		return regAmount;
	}
	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}
	public LocalDate getRegDate() {
		return regDate;
	}
	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", confirmPassword=" + confirmPassword + ", userRole=" + userRole + ", regAmount=" + regAmount
				+ ", regDate=" + regDate + "]";
	}
	
	

}
