package br.pucrs.engswii.beans;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class Student implements Serializable {
	@Id
    String rn;
    String name;
    String address;

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

	public String getRegistrationNumber() {
		return rn;
	}
	
	public void setRegistrationNumber(String registrationNumber) {
		this.rn = rn;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", address=" + address + ", registrationNumber=" + rn + "]";
	}
}