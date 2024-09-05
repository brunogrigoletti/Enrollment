package br.pucrs.engswii.persistance.students;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import br.pucrs.engswii.beans.Student;

@Repository
@Primary
public class StudentRegistration implements StudentRepository {
	private List<Student> studentRecords;
	private static StudentRegistration stdregd = null;
	private StudentJpaItfRep repository;

    @Autowired
    public StudentRegistration(StudentJpaItfRep repository) {
        this.repository = repository;
    }

	private StudentRegistration(){
		studentRecords = new ArrayList<Student>();
	}

	public static StudentRegistration getInstance() {
		if(stdregd == null) {
			stdregd = new StudentRegistration();
			return stdregd;
		}
		else {
			return stdregd;
		}
	}

	@Override
	public void add(Student std) {
		Random random = new Random();
        int regNum = 10000 + random.nextInt(90000);
		std.setRegistrationNumber(String.valueOf(regNum));
		studentRecords.add(std);
	}

	@Override
	public String upDateStudent(Student std) {
		for(int i=0; i<studentRecords.size(); i++)
		{
			Student stdn = studentRecords.get(i);
			if(stdn.getRegistrationNumber().equals(std.getRegistrationNumber())) {
				studentRecords.set(i, std);
				return "Update successful";
			}
		}
		return "Update un-successful";
	}

	@Override
	public String deleteStudent(String registrationNumber) {
		for(int i=0; i<studentRecords.size(); i++)
		{
			Student stdn = studentRecords.get(i);
			if(stdn.getRegistrationNumber().equals(registrationNumber)){
				studentRecords.remove(i);
				return "Delete successful";
			}
		}
		return "Delete un-successful";
	}

	@Override
	public List<Student> getStudents() {
		return studentRecords;
	}

	@Override
	public Student getStudentId(String regNum) {
		for (Student s : studentRecords) {
			if (s.getRegistrationNumber().equalsIgnoreCase(regNum)) {
				return s;
			}
		}
		return null;
	}

	@Override
	public List<Student> getStudentNamePart(String namePart) {
		List<Student> matchingStudents = new ArrayList<>();
		for (Student s : studentRecords) {
			if (s.getName().toLowerCase().contains(namePart)) {
				matchingStudents.add(s);
			}
		}
		return matchingStudents;
	}
}