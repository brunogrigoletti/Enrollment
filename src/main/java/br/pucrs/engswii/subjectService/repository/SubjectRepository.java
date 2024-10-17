package br.pucrs.engswii.subjectService.repository;

import java.util.List;

import br.pucrs.engswii.studentService.entity.Student;
import br.pucrs.engswii.subjectService.entity.Subject;

public interface SubjectRepository {
    boolean add(String code, String name, String schedule, String classCode);
    boolean addStudent(Student std, Subject sub);
    boolean deleteSubject(String code);
    List<Subject> getSubjects();
    Subject getSubjectId(String id);
    List<Student> getStudentsByClass(String classCode);
}