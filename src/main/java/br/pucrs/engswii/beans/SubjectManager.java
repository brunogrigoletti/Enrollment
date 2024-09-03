package br.pucrs.engswii.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubjectManager {
    private List<String> subCodes;
    private List<Subject> subjects;
    private List<String> stdCodes;
    private List<Map<Student,String>> students;
    private String registrationStatus;
    private static SubjectManager sm = null;

    public SubjectManager() {
        this.subCodes = new ArrayList<>();
        this.stdCodes = new ArrayList<>();
        this.subjects = new ArrayList<>();
        this.students = new ArrayList<>();
        this.registrationStatus = null;
    }

    public static SubjectManager getInstance() {
		if(sm==null) {
			sm = new SubjectManager();
			return sm;
		}
		else {
			return sm;
		}
	}

    public boolean addStudent(Student std, Subject sub) {
        if (stdCodes.contains(std.getRegistrationNumber())) {
            return false;
        }
        Map<Student, String> studentMap = new HashMap<>();
        studentMap.put(std, sub.getClassCode());
        students.add(studentMap);
        stdCodes.add(std.getRegistrationNumber());
        return true;
    }

    public boolean addSubject(String code, String name, String schedule, String classCode) {
        if (subCodes.contains(code)) {
            return false;
        }
        Subject subject = new Subject(code, name, schedule, classCode);
        subjects.add(subject);
        subCodes.add(code);
        return true;
    }

    public Subject getSubject(String code) {
        for (Subject subject : subjects) {
            if (subject.getCode().equalsIgnoreCase(code)) {
                return subject;
            }
        }
        return null;
    }

    public boolean removeSubject(String code) {
        Subject subject = getSubject(code);
        if (subject != null) {
            subjects.remove(subject);
            stdCodes.remove(code);
            return true;
        }
        return false;
    }

    public String getRegistrationStatus() {
        return this.registrationStatus;
    }

    public void setRegistrationStatus(String regStat) {
        this.registrationStatus = regStat;
    }

    public List<Subject> getAllSubjects() {
        return subjects;
    }

    public String getSubjectClassByStudent(Student student) {
        for (Map<Student, String> map : students) {
            if (map.containsKey(student)) {
                return map.get(student);
            }
        }
        return null;
    }

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