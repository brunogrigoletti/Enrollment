package br.pucrs.engswii.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import br.pucrs.engswii.beans.Student;
import br.pucrs.engswii.beans.StudentRegistration;
import br.pucrs.engswii.beans.SubjectManager;

@RestController
public class StudentRetrieveController {
	@GetMapping("/student/allstudent")
	public List<Student> getAllStudents() {
		return StudentRegistration.getInstance().getStudentRecords();
	}

	@GetMapping("/student/studentbyid/{regNum}")
	public Student getSudentById(@PathVariable("regNum") String regNum) {
		return StudentRegistration.getInstance().getStudentById(regNum);
	}

	@GetMapping("/student/studentbynamepart/{namePart}")
	public List<Student> getStudentByNamePart(@PathVariable("namePart") String namePart) {
		return StudentRegistration.getInstance().getStudentByNamePart(namePart);
	}

	@GetMapping("/student/subjects/{regNum}")
	public String getSubjectByStudent(@PathVariable("regNum") String regNum) {
		return SubjectManager.getInstance().getSubjectClassByStudent(StudentRegistration.getInstance().getStudentById(regNum));
	}
}