package com.hibernatejavainternship.StudentManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SmsDelete {

	public static void main(String[] args) {
		DeleteFrame c1 = new DeleteFrame();
	}

}

class DeleteFrame extends JFrame {
	
	JLabel lblRno;
	JTextField txtRno;
	JButton btnSave, btnBack;
	Container c;
	
	DeleteFrame() {
		setSize(400, 550);
		setTitle("Delete St.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		c = getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 10));
		
		lblRno = new JLabel("enter rno:");
		txtRno = new JTextField(10);
		btnSave = new JButton("Save");
		btnBack = new JButton("Back");
		
		Font f = new Font("Calibri", Font.BOLD, 30);
		
		lblRno.setFont(f);
		txtRno.setFont(f);
		btnSave.setFont(f);
		btnBack.setFont(f);
		
		c.add(lblRno);
		c.add(txtRno);
		c.add(btnSave);
		c.add(btnBack);
		
		ActionListener a1 = ae -> {
			try {
				if(txtRno.getText().equals("")) {
					throw new IncompleteRnoException("Rno field empty");
				}
				String strRno = txtRno.getText();
				if(strRno.matches("^[0-9]*$")==false){
			    	throw new CharInRnoException("Rno. contains character");
			    }
				int rno = Integer.parseInt(txtRno.getText());
				if(rno<1) {
					throw new NegativeRnoException("Zero or Negative Rno"); 
				}
				DBHandler.deleteStudent(rno);
				txtRno.setText("");
				txtRno.requestFocus();
			}
			catch(IncompleteRnoException e) {
				JOptionPane.showMessageDialog(c, "Empty field: Please enter Rno.", "Warning", JOptionPane.WARNING_MESSAGE);
				txtRno.requestFocus();
			}
			catch(CharInRnoException e) {
				JOptionPane.showMessageDialog(c, "Rno. should contain +ve integers only", "Error", JOptionPane.ERROR_MESSAGE);
				txtRno.setText("");
				txtRno.requestFocus();
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(c, "issue: " +e, "Error", JOptionPane.ERROR_MESSAGE);
//				txtRno.setText("");
				txtRno.requestFocus();
			}
		};
		btnSave.addActionListener(a1);

		ActionListener a2 = ae -> {
			MainFrame ma1 = new MainFrame();
			dispose();
		};
		btnBack.addActionListener(a2);
		
		setVisible(true);
	}
}


