package br.pucrs.engswii.controllers;

import org.springframework.web.bind.annotation.RestController;
import br.pucrs.engswii.beans.Student;
import br.pucrs.engswii.beans.StudentRegistrationReply;
import br.pucrs.engswii.beans.Subject;
import br.pucrs.engswii.beans.SubjectManager;
import br.pucrs.engswii.persistance.students.StudentRegistration;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/student")
public class StudentController {
	private StudentRegistration stds;

	@Autowired
    public StudentController(StudentRegistration stds) {
        this.stds=stds;
    }

	@GetMapping("/allstudent")
	public List<Student> getAllStudents() {
		return stds.getStudents();
	}

	@GetMapping("/studentbyid/{regNum}")
	public Student getSudentById(@PathVariable("regNum") String regNum) {
		return stds.getStudentId(regNum);
	}

	@GetMapping("/studentbynamepart/{namePart}")
	public List<Student> getStudentByNamePart(@PathVariable("namePart") String namePart) {
		return stds.getStudentNamePart(namePart);
	}

	@GetMapping("/subjects/{regNum}")
	public String getSubjectByStudent(@PathVariable("regNum") String regNum) {
		return SubjectManager.getInstance().getSubjectClassByStudent(stds.getStudentId(regNum));
	}

	@PutMapping("/update")
	public String updateStudentRecord(@RequestBody Student stdn) {
		return stds.upDateStudent(stdn);
	}
	
	@PostMapping("/register")
	public StudentRegistrationReply registerStudent(@RequestBody Student student) {
		StudentRegistrationReply stdregreply = new StudentRegistrationReply();           
		stds.add(student);
		stdregreply.setName(student.getName());
		stdregreply.setAddress(student.getAddress());
		stdregreply.setRegistrationNumber(student.getRegistrationNumber());
		stdregreply.setRegistrationStatus("Successful");
		return stdregreply;
	}

	@PostMapping("/register/subject")
	public String registerStudentSubject(@RequestBody Map<String, String> request) {
		String studentId = request.get("studentId");
		String subjectId = request.get("subjectId");
		Student student = stds.getStudentId(studentId);
		Subject subject = SubjectManager.getInstance().getSubject(subjectId);
		if (SubjectManager.getInstance().addStudent(student, subject))
			return "Successful";
		else
			return "Unsuccessful";
	}

	@DeleteMapping("/delete/{regdNum}")
	public String deleteStudentRecord(@PathVariable("regdNum") String regdNum) {
		return stds.deleteStudent(regdNum);
	}
}