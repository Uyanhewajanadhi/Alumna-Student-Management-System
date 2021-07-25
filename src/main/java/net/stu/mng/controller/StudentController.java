package net.stu.mng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import net.stu.mng.entity.Student;
import net.stu.mng.service.StudentService;

@Controller
public class StudentController {
	
	private StudentService studentService;

	//Since we use constructor based dependency injection,
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	//handler method to handle list students and return mode and view
	@GetMapping("/students")
	public String listStudent(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";	
	}
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		
		//create student object to hold Student form data
		Student student= new Student();
		model.addAttribute("student",student);
		return "create_student";
		
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
		
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student",studentService.getStudentById(id));
		return "edit_student";
	}
	
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id,
			@ModelAttribute("student") Student student,
			Model model) {
		
		//get Student from database by id
		Student exisitingStudent= studentService.getStudentById(id);
		exisitingStudent.setId(id);
		exisitingStudent.setFirstName(student.getFirstName());
		exisitingStudent.setLastName(student.getLastName());
		exisitingStudent.setEmail(student.getEmail());
		
		
		//save updated student details
		studentService.updateStudent(exisitingStudent);
		return "redirect:/students";
		
	}

	
	//handle method to delete student request
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		System.out.println(">>> "+ id);
		 studentService.deleteStudentById(id);
		 return "redirect:/students";
		
	}

}
