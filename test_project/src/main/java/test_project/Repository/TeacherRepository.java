package test_project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test_project.Entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer>{

}
