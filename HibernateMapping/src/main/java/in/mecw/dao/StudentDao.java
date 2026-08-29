package in.mecw.dao;


	import java.util.List;

	import javax.persistence.EntityManager;
	import javax.persistence.EntityManagerFactory;
	import javax.persistence.EntityTransaction;
	import javax.persistence.TypedQuery;

	import in.mecw.task.Address;
	import in.mecw.task.Course;
	import in.mecw.task.Department;
	import in.mecw.task.Student;

public class StudentDao {
		private EntityManagerFactory emf;
		public StudentDao(EntityManagerFactory emf) {
			this.emf=emf;
		}
		public String addStudent(Student std) {
			EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
			et.begin();
			em.persist(std);
			et.commit();
			return "record Inserted";
				
		}
		public Student updatestd(Student std) {
			EntityManager em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			et.begin();
			std=em.merge(std);
			et.commit();
			return std;
			
		}
		public void deleteStudent(Student std) {
			EntityManager em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			et.begin();
			em.merge(std);
			em.remove(std);
			et.commit();
		}	
		public Student findStudentId (int id) {
			EntityManager em=emf.createEntityManager();
			return em.find(Student.class,id);
		}
		public List<Student> findAllstudent(){
			EntityManager em=emf.createEntityManager();
			TypedQuery<Student> result=em.createQuery("select s from Student s" ,Student.class);
		    return result.getResultList();
		}
		public List<Student> findAllStudentIn(int studentId){
			EntityManager em=emf.createEntityManager();
			TypedQuery<Student> result=em.createQuery("select s.Teacher from Student s where s.studentId=:studenytId",Student.class);
			result.setParameter("studentId",studentId);
			return result.getResultList();
		}
	     public Course findStudentCourse(int studentid) {
			EntityManager em=emf.createEntityManager();
			TypedQuery<Course> result=em.createQuery("select s.course from Student s where s.studentId=:studenytId",Course.class);
			result.setParameter("studentId",studentid);
			return result.getSingleResult();
		}
	     public Department findStudentDepartment(int studentid) {
	 		EntityManager em=emf.createEntityManager();
	 		TypedQuery<Department> result=em.createQuery("select s.course.dept from Student s where s.studentId=:studenytId",Department.class);
	 		result.setParameter("studentId",studentid);
	 		return result.getSingleResult();
	 	}  
	     public Address findStudentAdress(int studentid) {
	  		EntityManager em=emf.createEntityManager();
	  		TypedQuery<Address> result=em.createQuery("select s.address from Student s where s.studentId=:studenytId",Address.class);
	  		result.setParameter("studentId",studentid);
	  		return result.getSingleResult();
	  	}  
	}