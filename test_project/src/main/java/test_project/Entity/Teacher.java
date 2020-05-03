package test_project.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "t")
public class Teacher {
	
	@Id private int tid;
	@NotEmpty private String name;
	
	@ManyToMany(targetEntity = Classroom.class, cascade = CascadeType.ALL)
	@JoinTable(	name = "teacher_classroom", 
				joinColumns = { @JoinColumn(name = "tid") },
				inverseJoinColumns = { @JoinColumn(name="cid") }
			  )
	private List<Classroom> cl_list;
	
	public Teacher() {}
	
	public Teacher(int tid, String name) {
		this.tid = tid;
		this.name  = name;
	}

	public int gettId() {
		return tid;
	}

	public void settId(int tid) {
		this.tid = tid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}