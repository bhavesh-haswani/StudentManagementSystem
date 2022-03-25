package com.hibernatejavainternship.StudentManagementSystem;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Student {
	@Id
	private int rno;
	private String name;
	private int m1;
	private int m2;
	private int m3;
	
	public Student() {
		
	}
	public Student(int rno, String name, int m1, int m2, int m3) {
		this.rno = rno;
		this.name = name;
		this.m1 = m1;
		this.m2 = m2;
		this.m3 = m3;
	}	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getM1() {
		return m1;
	}
	public void setM1(int m1) {
		this.m1 = m1;
	}
	public int getM2() {
		return m2;
	}
	public void setM2(int m2) {
		this.m2 = m2;
	}
	public int getM3() {
		return m3;
	}
	public void setM3(int m3) {
		this.m3 = m3;
	}
	@Override
	public String toString() {
		return "rno=" +rno +" name=" +name +" m1=" +m1 +" m2=" +m2 +" m3=" +m3;
	}
	
}
