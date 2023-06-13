package com.students.crud.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

import com.students.crud.entity.Student;
import com.students.crud.services.StudentServices;




@Controller
public class StudentController  {
	
	StudentServices ss ;
	
	
	public StudentController(StudentServices ss) {
		super();
		this.ss = ss;
	}



	@GetMapping("/")
	public String home() {
	    return "index"; 
	}
	
	
	
	@GetMapping("/reg")
	public String add() {
		return "register";
	}
	@GetMapping("/updateI")
	public String update() {
		return "updateInfo";
	}
	@GetMapping("/viewI")
	public String view() {
		return "viewInfo";
	}
	@GetMapping("/showI")
	public String showTable() {
		return "showInfo";
	}
	
	@GetMapping("/remove")
	public String remove() {
		return "remove";
	}
	
	@GetMapping("/showOneData")
	public String showOneData() {
		return "showOneData";
	}
	
	
	@GetMapping("/showAll")
	String getAllStudents(Model model){
		List<Student> slist=ss.getAllStudents();
		model.addAttribute("students", slist);
		return "showAll";
	}
	
	@PostMapping("/regStud")
	public String addStudent(@RequestParam("id") String kodId,
			   @RequestParam("name") String name, @RequestParam("branch") String branch ) {
		Student s= new Student(kodId,name,branch);
		ss.addStudent(s);
		return "index";
	}
   @PutMapping("/updateStud")	
   public String updateStudent(@RequestParam("id") String kodId,
		   @RequestParam("name") String name, @RequestParam("branch") String branch)
   {
	 Student st = ss.getStudent(kodId);
	 st.setName(name);
	 st.setBranch(branch);
	 ss.updateStudent(st);
	  return "index"; 
   }
	@DeleteMapping("/deleteStud")
	public String deleteStudent(@RequestParam("id") String KodId) {
		ss.deleteStudent(KodId);
		return "index"; 
	}
	
@GetMapping("/showOneStudent")
public String getSudentt(@RequestParam("sid") String kodId, Model model ) {
		try {
		Student st= ss.getStudent(kodId);
		model.addAttribute("student", st);
		return "showOneData";}
		catch (Exception e) {
			return "redirect:/";
		}
	}
	
	 
	
	
 }
