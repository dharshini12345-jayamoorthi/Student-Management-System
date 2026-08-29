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
	public class AddressDao {

		private EntityManagerFactory emf;
		public AddressDao(EntityManagerFactory emf) {
			this.emf=emf;
		}
		
		public String addAddress(Address adr) {
			EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
			et.begin();
			em.persist(adr);
			et.commit();
			return "record Inserted";
				
		}
		public Address updateAddress(Address adr) {
			EntityManager em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			et.begin();
			adr=em.merge(adr);
			et.commit();
			return adr;
			
		}
		
		public void deleteAddress(Address adr) {
			EntityManager em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			et.begin();
			em.merge(adr);
			em.remove(adr);
			et.commit();
		}	
		
		public List<Student> findAllStudentInAdr(int adrId){
			EntityManager em=emf.createEntityManager();
			TypedQuery<Student> result=em.createQuery("select A.Student from Address A where A addressId=:adrId",Student.class);
			result.setParameter("adrId",adrId);
			return result.getResultList();
		}

}
