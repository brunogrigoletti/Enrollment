package br.pucrs.engswii.beans;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class Subject implements Serializable {
    @Id
    private String code;
    private String name;
    private String schedule;
    private String course;

    protected Subject() {
    }
    
    public Subject(String code, String name, String schedule, String course) {
        this.code = code;
        this.name = name;
        this.schedule = schedule;
        this.course = course;
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

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Subject [code=" + code + ", name=" + name + ", schedule=" + schedule + ", classCode=" + course + "]";
    }
}