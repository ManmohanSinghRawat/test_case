package test_project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test_project.Entity.Classroom;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Integer>{
	
	Classroom findByCid(int cid);

}
