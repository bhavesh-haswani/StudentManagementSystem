package com.hibernatejavainternship.StudentManagementSystem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.*;

import javax.swing.*;

public class DBHandler 
{
    /*public static void main( String[] args )
    {
//    	Student stu = new Student();
//    	stu.setRno(102);
//    	stu.setName("Bhavesh");
//    	stu.setM1(97);
//    	stu.setM2(97);
//    	stu.setM3(97);
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
    	
    	SessionFactory sf = con.buildSessionFactory();
    	
    	Session session = sf.openSession();
    	
    	Transaction tx = session.beginTransaction();
    	
//    	session.save(stu);
    	
    	tx.commit();
    }*/
	
	public static void addStudent(int rno, String name, int m1, int m2, int m3) {
		Student stux = new Student(rno, name, m1, m2, m3);
		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
    	SessionFactory sf = con.buildSessionFactory();
    	Session session = null;
    	Transaction tx = null;
    	try {
	    	session = sf.openSession();
	    	tx = session.beginTransaction();
	    	
	    	Student stu = (Student)session.get(Student.class, rno);
	    	if(stu!=null) {
	    		JOptionPane.showMessageDialog(new JDialog(), "Roll no. not available", "Error", JOptionPane.ERROR_MESSAGE);
	    	}
	    	else {
		    	session.save(stux);
		    	tx.commit();
		    	JOptionPane.showMessageDialog(new JDialog(), "Record Added");
	    	}
    	}
    	catch(Exception e) {
    		JOptionPane.showMessageDialog(new JDialog(), "issue: " +e, "Error", JOptionPane.ERROR_MESSAGE);
    		tx.rollback();
    	}
    	finally {
    		session.close();
    	}
    	
	}
	
	public static String viewStudent() {
		String data = "";
		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
    	SessionFactory sf = con.buildSessionFactory();
    	Session session = null;
    	Transaction tx = null;
    	try {
	    	session = sf.openSession();
	    	List<Student> stu = new ArrayList<Student>();
	    	stu = session.createQuery("from Student").list();
	    	for(Student i: stu)
	    		data = data +"rno= " +i.getRno() +" name= " +i.getName() +" m1= " +i.getM1() +" m2= " +i.getM2() +" m3= " +i.getM3() +"\n";
    	}
    	catch(Exception e) {
    		JOptionPane.showMessageDialog(new JDialog(), "issue: " +e, "Error", JOptionPane.ERROR_MESSAGE);
    	}
    	finally {
    		session.close();
    	}
    	return data;
	}
	
	public static void updateStudent(int rno, String name, int m1, int m2, int m3) {
		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
    	SessionFactory sf = con.buildSessionFactory();
    	Session session = null;
    	Transaction tx = null;
    	try {
	    	session = sf.openSession();
	    	tx = session.beginTransaction();
	    	Student stu = (Student)session.get(Student.class, rno);
	    	if(stu!=null) {   		
//	    		Student stux = new Student(rno, name, m1, m2, m3);
	    		stu.setName(name);
	    		stu.setM1(m1);
	    		stu.setM2(m2);
	    		stu.setM3(m3);
	    		session.save(stu);
	    		tx.commit();
	    		JOptionPane.showMessageDialog(new JDialog(), "Record updated");
	    	}
	    	else {
	    		JOptionPane.showMessageDialog(new JDialog(), "Rno. " +rno +" does not exist");
	    	}
    	}
    	catch(Exception e) {
    		JOptionPane.showMessageDialog(new JDialog(), "issue: " +e, "Error", JOptionPane.ERROR_MESSAGE);
    		tx.rollback();
    	}
    	finally {
    		session.close();
    	}
	}
	
	public static void deleteStudent(int rno) {
		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
    	SessionFactory sf = con.buildSessionFactory();
    	Session session = null;
    	Transaction tx = null;
    	try {
	    	session = sf.openSession();
	    	tx = session.beginTransaction();
	    	
	    	Student stu = (Student)session.get(Student.class, rno);
	    	if(stu!=null) {
	    		session.delete(stu);
	    		tx.commit();
	    		JOptionPane.showMessageDialog(new JDialog(), "Record deleted");
	    	}
	    	else {
	    		JOptionPane.showMessageDialog(new JDialog(), "Rno " +rno +" does not exist");
	    	}
	    	
    	}
    	catch(Exception e) {
    		JOptionPane.showMessageDialog(new JDialog(), "issue: " +e, "Error", JOptionPane.ERROR_MESSAGE);
    		tx.rollback();
    	}
    	finally {
    		session.close();
    	}
	}
	
	public static String chartViewData() {
		String data = "";
		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = null;
		Transaction tx = null;
		try {
			session = sf.openSession();
			List<Student> stu = new ArrayList<Student>();
			stu = session.createQuery("from Student").list();
			for(Student i: stu)
				data = data +i.getName() +" " +i.getM1() +" " +i.getM2() +" " +i.getM3() +" ";
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(new JDialog(), "issue: " +e, "Error", JOptionPane.ERROR_MESSAGE);
		}
		finally {
			session.close();
		}
		return data;
	}
}
