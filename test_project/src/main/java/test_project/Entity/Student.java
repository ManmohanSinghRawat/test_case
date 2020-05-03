package test_project.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "s")
public class Student {

	@Id private int stid;
	@NotEmpty private String name;	
	
	public Student() {}
	
	public Student(int sid, String name) {
		this.stid = sid;
		this.name = name;
	}


	public void setStid(int stid)
	{
		this.stid = stid;
	}
	
	
	public void setName(String name)
	{
		this.name = name;
	}

	public int getStid() {
		return stid;
	}

	public String getName() {
		return name;
	}
	
}

