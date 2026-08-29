package in.mecw.task;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Student {
	@Id
	private int studentId;
	private String nme;
	private String email;
	private long phone;
	private int age;
	@OneToOne
	private Address address;
	
	@ManyToOne
	 private Course course;
	@ManyToMany
	private List<Teacher> techer;
	
	
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getNme() {
		return nme;
	}
	public void setNme(String nme) {
		this.nme = nme;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
}
