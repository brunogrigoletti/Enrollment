package br.pucrs.engswii.controllers;

import org.springframework.web.bind.annotation.RestController;

import br.pucrs.engswii.persistance.students.StudentRegistration;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class StudentDeleteController {
	@DeleteMapping("/delete/student/{regdNum}")
	public String deleteStudentRecord(@PathVariable("regdNum") String regdNum) {
		return StudentRegistration.getInstance().deleteStudent(regdNum);
	}
}