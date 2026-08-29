package in.mecw.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import in.mecw.task.Teacher;


public class TeacherDao {
	 private EntityManagerFactory emf;
     public TeacherDao(EntityManagerFactory emf) {
 		this.emf=emf;
 	} 
     public Teacher addTeacher(Teacher t) {
 		EntityManager em=emf.createEntityManager();
 	EntityTransaction et=em.getTransaction();
 		et.begin();
 		em.persist(t);
 		et.commit();
 		return t;
 			
 	}
 	public Teacher updateTeacher(Teacher t) {
 		EntityManager em=emf.createEntityManager();
 		EntityTransaction et=em.getTransaction();
 		et.begin();
 		t =em.merge(t);
 		et.commit();
 		return t;
 		
 	}
 	public void deleteTeacher(Teacher t) {
 		EntityManager em=emf.createEntityManager();
 		EntityTransaction et=em.getTransaction();
 		et.begin();
 		em.merge(t);
 		em.remove(t);
 		et.commit();
 	}	
 		public Teacher findTeacherId (int id) {
 			EntityManager em=emf.createEntityManager();
 			return em.find(Teacher.class,id);
 		}
 		public List<Teacher> findAllTeacher(){
 			EntityManager em=emf.createEntityManager();
 			TypedQuery<Teacher> result=em.createQuery("select t from Teacher t" ,Teacher.class);
 		    return result.getResultList();
 		}



}
