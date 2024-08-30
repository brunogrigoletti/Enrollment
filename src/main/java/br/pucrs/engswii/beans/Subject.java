package br.pucrs.engswii.beans;

public class Subject {
    private String code;
    private String name;
    private String schedule;
    private String classCode;

    public Subject(String code, String name, String schedule, String classCode) {
        this.code = code;
        this.name = name;
        this.schedule = schedule;
        this.classCode = classCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    @Override
    public String toString() {
        return "Subject [code=" + code + ", name=" + name + ", schedule=" + schedule + ", classCode=" + classCode + "]";
    }
}