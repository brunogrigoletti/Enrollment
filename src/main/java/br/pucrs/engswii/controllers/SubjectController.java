package br.pucrs.engswii.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.pucrs.engswii.beans.Student;
import br.pucrs.engswii.beans.Subject;
import br.pucrs.engswii.beans.SubjectManager;

@RestController
@RequestMapping("/subject")
public class SubjectController {

	@PostMapping("/register")
	public String registerSubject(@RequestBody Subject subject) {
		if (SubjectManager.getInstance().addSubject(subject.getCode(), subject.getName(), subject.getSchedule(), subject.getClassCode()))
			return "Successful";
		else
			return "Unsuccessful";
	}

	@GetMapping("/allsubjects")
	public List<Subject> getAllSubjects() {
		return SubjectManager.getInstance().getAllSubjects();
	}

	@GetMapping("/student/{classCode}")
	public List<Student> getStudentsByClass(@PathVariable("classCode") String classCode) {
		return SubjectManager.getInstance().getStudentsByClass(classCode);
	}
}