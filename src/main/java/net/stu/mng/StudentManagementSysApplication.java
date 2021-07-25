package net.stu.mng;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.stu.mng.entity.Student;
import net.stu.mng.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSysApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSysApplication.class, args);
	}
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public void run(String... args) throws Exception{
		/*
		 * Student student1 = new Student("Janadhi","Uyanhewa","jay@gmail.com");
		 * studentRepository.save(student1);
		 * 
		 * Student student2 = new Student("Hasanga","Mendis","hasanga@hotmail.com");
		 * studentRepository.save(student2);
		 * 
		 * Student student3 = new Student("Anne","Perera","annePerera@gmail.com");
		 * studentRepository.save(student3);
		 */

	}
}
