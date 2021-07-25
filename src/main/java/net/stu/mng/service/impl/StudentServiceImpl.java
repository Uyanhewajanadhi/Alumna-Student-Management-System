package net.stu.mng.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.stu.mng.entity.Student;
import net.stu.mng.service.StudentService;
import net.stu.mng.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	private StudentRepository studentRepository;
	
	public StudentServiceImpl(net.stu.mng.repository.StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}


	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	
	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	
	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}
	
	
	@Override
	public Student getStudentById(Long Id) {
		return studentRepository.findById(Id).get();
	}
	
	@Override
	public void deleteStudentById(Long Id) {
		studentRepository.deleteById(Id);
	}
	
	
}
