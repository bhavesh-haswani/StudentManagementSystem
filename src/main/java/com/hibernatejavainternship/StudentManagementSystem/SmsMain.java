package com.hibernatejavainternship.StudentManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SmsMain {
	public static void main(String[] args) {
		MainFrame m1 = new MainFrame();
	}
}

class MainFrame extends JFrame {
	
	JButton btnAdd, btnView, btnUpdate, btnDelete, btnCharts;
	Container c;
//	JFrame fr;
	
	MainFrame() {
		setSize(400, 400);
		setTitle("Student Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
//		fr = new JFrame();
		
		c = getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 40));
		
		btnAdd = new JButton("Add");
		btnView = new JButton("View");
		btnUpdate = new JButton("Update");
		btnDelete = new JButton("Delete");
		btnCharts = new JButton("Charts");
		
		Font f = new Font("Calibri", Font.BOLD, 30);
		btnAdd.setFont(f);
		btnView.setFont(f);
		btnUpdate.setFont(f);
		btnDelete.setFont(f);
		btnCharts.setFont(f);
		
		c.add(btnAdd);
		c.add(btnView);
		c.add(btnUpdate);
		c.add(btnDelete);
		c.add(btnCharts);
		
		ActionListener a1 = ae -> {
			AddFrame am1 = new AddFrame();
			dispose();
		};
		btnAdd.addActionListener(a1);
		
		ActionListener a2 = ae -> {
			ViewFrame vm1 = new ViewFrame();
			dispose();
		};
		btnView.addActionListener(a2);
		
		ActionListener a3 = ae -> {
			UpdateFrame um1 = new UpdateFrame();
			dispose();
		};
		btnUpdate.addActionListener(a3);
		
		ActionListener a4 = ae -> {
			DeleteFrame dm1 = new DeleteFrame();
			dispose();
		};
		btnDelete.addActionListener(a4);
		
		ActionListener a5 = ae -> {
			ChartFrame cm1 = new ChartFrame();
			dispose();
		};
		btnCharts.addActionListener(a5);
		
		setVisible(true);
	}
}