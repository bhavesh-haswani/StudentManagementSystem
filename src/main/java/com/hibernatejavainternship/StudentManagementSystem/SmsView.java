package com.hibernatejavainternship.StudentManagementSystem;

import javax.swing.*;

//import software.DbHandler;

import java.awt.*;
import java.awt.event.*;

public class SmsView {

	public static void main(String[] args) {
		ViewFrame v1 = new ViewFrame();

	}

}

class ViewFrame extends JFrame {
	
	JTextArea taData;
	JButton btnBack;
	JScrollPane scroll;
	Container c;
	
	ViewFrame() {
		setSize(700, 450);
		setTitle("View St.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		c = getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 10));
		
		taData = new JTextArea(10, 35);
		scroll = new JScrollPane(taData);
		scroll = new JScrollPane(taData, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		taData.setEditable(false);
		btnBack = new JButton("Back");
		
		Font f = new Font("Calibri", Font.BOLD, 20);
		
		Font fb = new Font("Calibri", Font.BOLD, 30);
		
		taData.setFont(f);
		btnBack.setFont(fb);
		
//		c.add(taData);
		c.add(scroll);
		c.add(btnBack);
		
		taData.setText(DBHandler.viewStudent());
		
		ActionListener a1 = ae -> {
			MainFrame mv1 = new MainFrame();
			dispose();
		};
		btnBack.addActionListener(a1);
		
		setVisible(true);
	}
}

