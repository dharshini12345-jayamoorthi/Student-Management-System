package in.mecw.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;

import in.mecw.dao.CourseDao;
import in.mecw.dao.DepartmentDao;
import in.mecw.dao.StudentDao;
import in.mecw.dao.TeacherDao;
import in.mecw.task.Course;
import in.mecw.task.Department;
import in.mecw.task.Student;
import in.mecw.task.Teacher;

public class ApplicationDriver {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
//		DepartmentDao deptDao=new DepartmentDao(emf);
//	Department d=new Department();
//		d.setDepartmentId(1);
//		d.setDepartmentNmame("CSE");
//		List<Course> course=new ArrayList<Course>();
//		Course c1=new Course(1,"JAVA",5);
//		Course c2=new Course(2,"AIDS",5);
//		Course c3=new Course(3,"OOPS",5);
//		course.add(c1);
//		course.add(c2);
//		course.add(c3);
//		d.setCoures(course);
//		deptDao.addDepartment(d);
//		
		StudentDao StudentDao=new StudentDao(emf);
		Student s=new Student();
		s.setAge(20);
		s.setNme("dev");
		s.setEmail("dharshut@1244");
		s.setPhone(2456787);
		s.setStudentId(12);
		StudentDao.addStudent(s);
		
		
		in.mecw.dao.TeacherDao TeacherDao=new TeacherDao(emf);
		Teacher t=new Teacher();
	    t.setEmail("dharshu@1455");
		t.setName("dev");
		t.setSpecialization("java");
		t.setTeacherId(34);
		TeacherDao.addTeacher(t);
		
		CourseDao CourseDao=new CourseDao(emf);
		Course crs=new Course();
		crs.setCourseId(2);
		crs.setCourseNmae("dev");
		crs.setDuration(3);
		CourseDao.addCourse(crs);
		
		
		
//		
		
		
		
		
	}

}
