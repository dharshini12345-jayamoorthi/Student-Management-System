package in.mecw.task;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Course {
	@Id
	private int courseId;
	private String courseNmae;
	private int duration;
	@ManyToOne
	
	private Department dept;
	
	
	@OneToMany(mappedBy="course")
	private List<Student> student;
	
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseNmae() {
		return courseNmae;
	}
	public void setCourseNmae(String courseNmae) {
		this.courseNmae = courseNmae;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Course(){
		super();
		this.courseId = courseId;
		this.courseNmae = courseNmae;
		this.duration = duration;
	}
	

}
	
