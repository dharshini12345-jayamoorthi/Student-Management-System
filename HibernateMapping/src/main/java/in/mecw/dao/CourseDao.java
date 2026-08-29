package in.mecw.dao;


	import java.util.List;

	import javax.persistence.EntityManager;
	import javax.persistence.EntityManagerFactory;
	import javax.persistence.EntityTransaction;
	import javax.persistence.TypedQuery;


import in.mecw.task.Course;
	import in.mecw.task.Department;

	public class CourseDao {
	        private EntityManagerFactory emf;
	        public CourseDao(EntityManagerFactory emf) {
	    		this.emf=emf;
	    	} 
	        public Course addCourse(Course crs) {
	    		EntityManager em=emf.createEntityManager();
	    	EntityTransaction et=em.getTransaction();
	    		et.begin();
	    		em.persist(crs);
	    		et.commit();
	    		return crs;
	    			
	    	}
	    	public Course updateCourse(Course crs) {
	    		EntityManager em=emf.createEntityManager();
	    		EntityTransaction et=em.getTransaction();
	    		et.begin();
	    		crs =em.merge(crs);
	    		et.commit();
	    		return crs;
	    		
	    	}
	    	public void deleteCourse(Course crs) {
	    		EntityManager em=emf.createEntityManager();
	    		EntityTransaction et=em.getTransaction();
	    		et.begin();
	    		em.merge(crs);
	    		em.remove(crs);
	    		et.commit();
	    	}	
	    		public Course findcrsId (int id) {
	    			EntityManager em=emf.createEntityManager();
	    			return em.find(Course.class,id);
	    		}
	    		public List<Course> findAllcrs(){
	    			EntityManager em=emf.createEntityManager();
	    			TypedQuery<Course> result=em.createQuery("select c from Course c" ,Course.class);
	    		    return result.getResultList();
	    		}
	    		public List<Course> findAllStudentInCourse(int courseId){
	    			EntityManager em=emf.createEntityManager();
	    			TypedQuery<Course> result=em.createQuery("select c.student from Course c where c.courseId=:crsId",Course.class);
	    			result.setParameter("courseId",courseId);
	    			return result.getResultList();
	    		}
	}


