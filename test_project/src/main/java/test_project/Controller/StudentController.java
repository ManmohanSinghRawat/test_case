package test_project.Controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import test_project.Entity.Classroom;
import test_project.Entity.Student;
import test_project.Repository.ClassroomRepository;
import test_project.Repository.StudentRepository;


@RestController
public class StudentController {
	
		@Autowired
		StudentRepository sr;
		
		@Autowired
		ClassroomRepository cr;

		@RequestMapping(value="/addstudent" , method = RequestMethod.GET , produces="application/json")
		public Object addStudent(@RequestParam int sid, @RequestParam String name, @RequestParam int cid)
		{
			
			if(cr.findByCid(cid) != null)
			{
				Student s =new Student(sid, name);
				Classroom c = cr.findByCid(cid);
				c.addStudent(s);
				sr.save(s); 
				cr.save(c);
				return ResponseEntity.ok(new String("ok"));
			}
			else
			{
				System.out.println("s1");
				Student s =new Student(sid, name);
				Classroom c = new Classroom();
				c.setCid(cid);
				List<Student> li = new ArrayList<Student>();
				li.add(s);
				c.setSt_list(li);
				sr.save(s); 
				cr.save(c);
				return ResponseEntity.ok(new String("ok"));
			}
//			return ResponseEntity.ok(new String("class id not present !"));
		}
		
		@RequestMapping(value="/getclass" , method = RequestMethod.GET , produces="application/json")
		public Object getClass(@RequestParam int cid)
		{
			if(cr.findByCid(cid) != null)
				return  cr.findByCid(cid).getSt_list();
			else
				return ResponseEntity.ok(new String("class id not present !"));
		}
			
}
