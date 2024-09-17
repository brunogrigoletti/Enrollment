package br.pucrs.engswii.persistance.subjects;

import java.util.List;
import br.pucrs.engswii.beans.Student;
import br.pucrs.engswii.beans.Subject;

public interface SubjectRepository {
    boolean add(String code, String name, String schedule, String classCode);
    boolean deleteSubject(String code);
    List<Subject> getSubjects();
    Subject getSubjectId(String id);
    List<Student> getStudentsByClass(String classCode);
}