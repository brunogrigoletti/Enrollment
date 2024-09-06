package br.pucrs.engswii.persistance.students;

import java.util.List;
import br.pucrs.engswii.beans.Student;

public interface StudentRepository {
    void add(Student std);
    String updateStudent(Student std);
    String deleteStudent(String registrationNumber);
    List<Student> getStudents();
    Student getStudentId(String id);
    List<Student> getStudentNamePart(String namePart);
}