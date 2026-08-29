package in.mecw.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import in.mecw.task.Course;
import in.mecw.task.Department;

public class DepartmentDao {
	private EntityManagerFactory emf;
	public DepartmentDao(EntityManagerFactory emf) {
		this.emf=emf;
	}
	public Department addDepartment(Department dept) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(dept);
		et.commit();
		return dept;
	}
	public Department updateDept(Department dept) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		dept=em.merge(dept);
		et.commit();
		return dept;
	}
	public void deleteDept(Department dept) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.merge(dept);
		em.remove(dept);
		et.commit();
	}
	public Department findDeptById(int id) {
		EntityManager em=emf.createEntityManager();
		return em.find(Department.class,id);
	}
	public List<Department>findAllDepartmrnt(){
		EntityManager em=emf.createEntityManager();
		TypedQuery<Department>result=em.createQuery("select d from Department d",Department.class);
		return result.getResultList();
}
	
	public List<Course>findAllCourseInDept(int deptId){
		EntityManager em=emf.createEntityManager();
		TypedQuery<Course> result=em.createQuery("select d.courses from Department d where d.departmentId=:deptId",Course.class);
		result.setParameter("deptId", deptId);
		return result.getResultList();
	}
}

