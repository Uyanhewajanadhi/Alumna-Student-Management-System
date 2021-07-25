package net.stu.mng.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.stu.mng.entity.Student;


public interface StudentRepository extends JpaRepository <Student, Long> {

}
