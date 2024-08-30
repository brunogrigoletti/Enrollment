package br.pucrs.engswii.controllers;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.pucrs.engswii.beans.Student;
import br.pucrs.engswii.beans.StudentRegistration;

@RestController
public class StudentUpdateController {
	@PutMapping("/update/student")
	public String updateStudentRecord(@RequestBody Student stdn) {
		return StudentRegistration.getInstance().upDateStudent(stdn);
	}
}