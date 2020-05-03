package test_project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import test_project.Entity.Teacher;
import test_project.Repository.TeacherRepository;

@Controller
public class TeacherController {

	@Autowired TeacherRepository tr;

	@RequestMapping(value="/addteacher" , method = RequestMethod.POST , produces = "application/json", consumes = "application/json")
	public Object addStudent(@RequestBody Teacher t)
	{
		tr.save(t);
		return ResponseEntity.ok(new String("ok"));
	}
}
