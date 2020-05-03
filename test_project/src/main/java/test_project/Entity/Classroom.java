package test_project.Entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name = "c")
public class Classroom {
	
	@Id
	@NumberFormat(pattern = "/\b*/")
	private int cid;	
	
	@OneToMany(cascade = CascadeType.MERGE, targetEntity = Student.class)
	List<Student> st_list;
	
	public Classroom() {}
	
	public Classroom(int cid) {
		this.cid = cid;
		st_list = null;
	}

	public void setCid(int id)
	{
		this.cid = id;
	}

	public int getCid() {
		return cid;
	}

	public List<Student> getSt_list() {
		return st_list;
	}

	public void setSt_list(List<Student> st_list) {
		this.st_list = st_list;
	}

	public void addStudent(Student s) {
		this.st_list.add(s);
	}

}
