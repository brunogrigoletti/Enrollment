package br.pucrs.engswii.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import br.pucrs.engswii.beans.Student;
import br.pucrs.engswii.beans.SubjectManager;
import br.pucrs.engswii.persistance.students.StudentRegistration;

@RestController
public class StudentRetrieveController {
	@GetMapping("/student/allstudent")
	public List<Student> getAllStudents() {
		return StudentRegistration.getInstance().getStudents();
	}

	@GetMapping("/student/studentbyid/{regNum}")
	public Student getSudentById(@PathVariable("regNum") String regNum) {
		return StudentRegistration.getInstance().getStudentId(regNum);
	}

	@GetMapping("/student/studentbynamepart/{namePart}")
	public List<Student> getStudentByNamePart(@PathVariable("namePart") String namePart) {
		return StudentRegistration.getInstance().getStudentNamePart(namePart);
	}

	@GetMapping("/student/subjects/{regNum}")
	public String getSubjectByStudent(@PathVariable("regNum") String regNum) {
		return SubjectManager.getInstance().getSubjectClassByStudent(StudentRegistration.getInstance().getStudentId(regNum));
	}
}