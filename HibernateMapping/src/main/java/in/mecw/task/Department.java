package in.mecw.task;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="department")
public class Department {
	@Id
	@Column(name="department_id")
	private int departmentId;
	@Column(name="department_name",unique=true,nullable=false)
	private String departmentNmame;
	private String location;
	
	@OneToMany(mappedBy="dept",cascade=CascadeType.ALL)
	
    private List<Course> coures;
    
	public List<Course> getCoures() {
		return coures;
	}
	public void setCoures(List<Course> coures) {
		this.coures = coures;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentNmame() {
		return departmentNmame;
	}
	public void setDepartmentNmame(String departmentNmame) {
		this.departmentNmame = departmentNmame;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
		
	
}
	
	


