package br.pucrs.engswii.controllers;

import java.util.Map;

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
	public String registerStudentSubject(@RequestBody Map<String, String> request) {
		String studentId = request.get("studentId");
		String subjectId = request.get("subjectId");
		Student student = StudentRegistration.getInstance().getStudentById(studentId);
		Subject subject = SubjectManager.getInstance().getSubject(subjectId);
		if (SubjectManager.getInstance().addStudent(student, subject))
			return "Successful";
		else
			return "Unsuccessful";
	}
}