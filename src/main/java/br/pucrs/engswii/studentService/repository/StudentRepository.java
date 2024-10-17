package br.pucrs.engswii.studentService.repository;

import java.util.List;

import br.pucrs.engswii.studentService.entity.Student;
import br.pucrs.engswii.subjectService.entity.Subject;

public interface StudentRepository {
    boolean add(Student std);
    String updateStudent(Student std);
    String deleteStudent(String registrationNumber);
    List<Student> getStudents();
    Student getStudentId(String id);
    List<Student> getStudentNamePart(String namePart);
    List<Subject> getSubjectsByStudent(String regNum);
}