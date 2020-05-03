package test_project.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test_project.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {


}
