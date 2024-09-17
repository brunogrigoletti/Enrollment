package br.pucrs.engswii.persistance.students;

import java.util.List;
import br.pucrs.engswii.beans.Student;
import br.pucrs.engswii.beans.Subject;

public interface StudentRepository {
    boolean add(Student std);
    boolean addSubject(Student std, Subject sub);
    String updateStudent(Student std);
    String deleteStudent(String registrationNumber);
    List<Student> getStudents();
    Student getStudentId(String id);
    List<Student> getStudentNamePart(String namePart);
    List<Subject> getSubjectsByStudent(String regNum);
}