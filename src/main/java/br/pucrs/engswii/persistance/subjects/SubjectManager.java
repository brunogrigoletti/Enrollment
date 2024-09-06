package br.pucrs.engswii.persistance.subjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import br.pucrs.engswii.beans.Student;
import br.pucrs.engswii.beans.Subject;

public class SubjectManager implements SubjectRepository {
    private static SubjectJpaItfRep repository;
    private List<String> subCodes;
    private List<Subject> subjects;
    private List<String> stdCodes;
    private List<Map<Student,String>> students;

    @Autowired
    public SubjectManager(SubjectJpaItfRep repository) {
        this.repository = repository;
        this.subCodes = new ArrayList<>();
        this.stdCodes = new ArrayList<>();
        this.subjects = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    @Override
    public boolean add(String code, String name, String schedule, String classCode) {
        if (subCodes.contains(code)) {
            return false;
        }
        Subject subject = new Subject(code, name, schedule, classCode);
        subjects.add(subject);
        subCodes.add(code);
        repository.save(subject);
        return true;
    }

    @Override
    public boolean addStudent(Student std, Subject sub) {
        if (stdCodes.contains(std.getRegistrationNumber())) {
            return false;
        }
        Map<Student, String> studentMap = new HashMap<>();
        studentMap.put(std, sub.getCourse());
        students.add(studentMap);
        stdCodes.add(std.getRegistrationNumber());
        return true;
    }

    @Override
    public Subject getSubjectId(String code) {
        List<Subject> subj = repository.findAll();
        for (Subject subject : subj) {
            if (subject.getCode().equalsIgnoreCase(code)) {
                return subject;
            }
        }
        return null;
    }

    @Override
    public boolean deleteSubject(String code) {
        Subject subject = getSubjectId(code);
        if (subject != null) {
            subjects.remove(subject);
            stdCodes.remove(code);
            return true;
        }
        return false;
    }

    @Override
    public List<Subject> getSubjects() {
        List<Subject> subj = repository.findAll();
        if (subj.size() == 0) {
            return new ArrayList<Subject>();
        }
        else {
            return subj.stream().toList();
        }    
    }

    @Override
    public String getSubjectClassStudent(Student student) {
        for (Map<Student, String> map : students) {
            if (map.containsKey(student)) {
                return map.get(student);
            }
        }
        return null;
    }

    @Override
    public List<Student> getStudentsByClass(String classCode) {
        List<Student> studentsInClass = new ArrayList<>();
        for (Map<Student, String> map : students) {
            for (Map.Entry<Student, String> entry : map.entrySet()) {
                if (entry.getValue().equals(classCode)) {
                    studentsInClass.add(entry.getKey());
                }
            }
        }
        return studentsInClass;
    }
}