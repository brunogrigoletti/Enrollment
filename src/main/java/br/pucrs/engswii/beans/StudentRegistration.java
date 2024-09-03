package br.pucrs.engswii.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StudentRegistration {
	private List<Student> studentRecords;
	private static StudentRegistration stdregd = null;

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

	public void add(Student std) {
		Random random = new Random();
        int regNum = 10000 + random.nextInt(90000);
		std.setRegistrationNumber(String.valueOf(regNum));
		studentRecords.add(std);
	}

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

	public List<Student> getStudentRecords() {
		return studentRecords;
	}

	public Student getStudentById(String regNum) {
		for (Student s : studentRecords) {
			if (s.getRegistrationNumber().equalsIgnoreCase(regNum)) {
				return s;
			}
		}
		return null;
	}

	public List<Student> getStudentByNamePart(String namePart) {
		List<Student> matchingStudents = new ArrayList<>();
		for (Student s : studentRecords) {
			if (s.getName().toLowerCase().contains(namePart)) {
				matchingStudents.add(s);
			}
		}
		return matchingStudents;
	}
}