package br.pucrs.engswii.beans;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class Student implements Serializable {
	@Id
    private String rn;
    private String name;
    private String address;

	protected Student() {
    }
    
	public Student(String rn, String name, String address) {
		this.rn = rn;
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRn() {
		return rn;
	}
	
	public void setRn(String rn) {
		this.rn = rn;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", address=" + address + ", registrationNumber=" + rn + "]";
	}
}