package br.pucrs.engswii.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.pucrs.engswii.beans.*;

@RestController
public class StudentRegistrationController {
	@PostMapping("/register/student")
	public StudentRegistrationReply registerStudent(@RequestBody Student student) {
		StudentRegistrationReply stdregreply = new StudentRegistrationReply();           
		StudentRegistration.getInstance().add(student);
		stdregreply.setName(student.getName());
		stdregreply.setAddress(student.getAddress());
		stdregreply.setRegistrationNumber(student.getRegistrationNumber());
		stdregreply.setRegistrationStatus("Successful");
		return stdregreply;
	}

	@PostMapping("/register/student/subject")
	public String registerStudentSubject(@RequestBody Student student, @RequestBody Subject subject) {
		if (SubjectManager.getInstance().addStudent(student, subject))
			return "Successful";
		else
			return "Unsuccessful";
	}
}