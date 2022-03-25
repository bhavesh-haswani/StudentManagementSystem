package com.hibernatejavainternship.StudentManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SmsUpdate {
	public static void main(String[] args) {
		UpdateFrame u1 = new UpdateFrame();
	}
}

class UpdateFrame extends JFrame {
	JLabel lblRno, lblName, lblM1, lblM2, lblM3;
	JTextField txtRno, txtName, txtM1, txtM2, txtM3;
	JButton btnSave, btnBack;
	Container c;
	
	UpdateFrame() {
		setSize(400, 650);
		setTitle("Update St.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		c = getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 10));
		
		lblRno = new JLabel("enter rno:");
		lblName = new JLabel("enter name:");
		lblM1 = new JLabel("enter sub marks m1:");
		lblM2 = new JLabel("enter sub marks m2:");
		lblM3 = new JLabel("enter sub marks m3:");
		
		txtRno = new JTextField(10);
		txtName = new JTextField(10);
		txtM1 = new JTextField(10);
		txtM2 = new JTextField(10);
		txtM3 = new JTextField(10);
		
		btnSave = new JButton("Save");
		btnBack = new JButton("Back");
		
		Font f = new Font("Calibri", Font.BOLD, 30);
		
		lblRno.setFont(f);
		lblName.setFont(f);
		lblM1.setFont(f);
		lblM2.setFont(f);
		lblM3.setFont(f);
		
		txtRno.setFont(f);
		txtName.setFont(f);
		txtM1.setFont(f);
		txtM2.setFont(f);
		txtM3.setFont(f);
		
		btnSave.setFont(f);
		btnBack.setFont(f);
				
		c.add(lblRno);
		c.add(txtRno);
		
		c.add(lblName);
		c.add(txtName);
		
		c.add(lblM1);
		c.add(txtM1);
		
		c.add(lblM2);
		c.add(txtM2);
		
		c.add(lblM3);
		c.add(txtM3);
		
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
				
				if(txtName.getText().equals("")) {
			        throw new IncompleteNameException("Name field empty");
			    }
				String name = txtName.getText();
//				if(name.matches("^[a-zA-Z]*$")==false) {
//				if(name.matches("^[[a-zA-Z]\\s+]*$")==false) {
//				if(name.matches("^[a-zA-Z_]*$")==false) {
				if(name.matches("^[a-zA-Z]*$")==false) {
					throw new NumberInNameException("Name contains number"); 
				} else if (name.matches("^[a-zA-Z]{1}$")) {
					throw new MinimumInNameException("Name contains less than 2 chars"); 
				}
				
				if(txtM1.getText().equals("")) {
			        throw new IncompleteM1Exception("M1 field empty");
			    }
				String strM1 = txtM1.getText();
				if(strM1.matches("^[0-9]*$")==false){
			    	throw new CharInM1Exception("M1 contains character");
			    }
				int m1 = Integer.parseInt(txtM1.getText());
				if((m1<0||m1>100)) {
					throw new MarksOutOfRangeExceptionM1("Marks out of range");
				}
				
				if(txtM2.getText().equals("")) {
					throw new IncompleteM2Exception("M2 field empty");
				}
				String strM2 = txtM2.getText();
			    if(strM2.matches("^[0-9]*$")==false){
			    	throw new CharInM2Exception("M2 contains character");
			    }
				int m2 = Integer.parseInt(txtM2.getText());
				if((m2<0||m2>100)) {
					throw new MarksOutOfRangeExceptionM2("Marks out of range");
				}
				
				if(txtM3.getText().equals("")) {
					throw new IncompleteM3Exception("M3 field empty");
				}
				String strM3 = txtM3.getText();
			    if(strM3.matches("^[0-9]*$")==false){
			    	throw new CharInM3Exception("M3 contains character");
			    }
				int m3 = Integer.parseInt(txtM3.getText());
				if((m3<0||m3>100)) {
					throw new MarksOutOfRangeExceptionM3("Marks out of range");
				}
				
				DBHandler.updateStudent(rno, name, m1, m2, m3);
				
				
			}
			catch(IncompleteRnoException e) {
				JOptionPane.showMessageDialog(c, "Enter Rno", "Warning", JOptionPane.WARNING_MESSAGE);
				txtRno.requestFocus();
			}
			catch(CharInRnoException e) {
				JOptionPane.showMessageDialog(c, "Rno. should contain +ve integers only", "Error", JOptionPane.ERROR_MESSAGE);
				txtRno.setText("");
				txtRno.requestFocus();
			}
			catch(NegativeRnoException e) {
				JOptionPane.showMessageDialog(c, "Rno. should be positive", "Error", JOptionPane.ERROR_MESSAGE);
				txtRno.setText("");
				txtRno.requestFocus();
			}
			catch(IncompleteNameException e) {
				JOptionPane.showMessageDialog(c, "Enter Name", "Warning", JOptionPane.WARNING_MESSAGE);
				txtName.requestFocus();
			}
			catch(IncompleteM1Exception e) {
				JOptionPane.showMessageDialog(c, "Enter M1", "Warning", JOptionPane.WARNING_MESSAGE);
				txtM1.requestFocus();
			}
			catch(CharInM1Exception e) {
				JOptionPane.showMessageDialog(c, "M1 should contain +ve integers only", "Error", JOptionPane.ERROR_MESSAGE);
				txtM1.setText("");
				txtM1.requestFocus();
			}
			catch(CharInM2Exception e) {
				JOptionPane.showMessageDialog(c, "M2 should contain +ve integers only", "Error", JOptionPane.ERROR_MESSAGE);
				txtM2.setText("");
				txtM2.requestFocus();
			}
			catch(CharInM3Exception e) {
				JOptionPane.showMessageDialog(c, "M3 should contain +ve integers only", "Error", JOptionPane.ERROR_MESSAGE);
				txtM3.setText("");
				txtM3.requestFocus();
			}
			catch(IncompleteM2Exception e) {
				JOptionPane.showMessageDialog(c, "Enter M2", "Warning", JOptionPane.WARNING_MESSAGE);
				txtM2.requestFocus();
			}
			catch(IncompleteM3Exception e) {
				JOptionPane.showMessageDialog(c, "Enter M3", "Warning", JOptionPane.WARNING_MESSAGE);
				txtM3.requestFocus();
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(c, "issue: " +e, "Error", JOptionPane.ERROR_MESSAGE);
			}
			catch(NumberInNameException e) {
				JOptionPane.showMessageDialog(c, "Name should contain characters only", "Error", JOptionPane.ERROR_MESSAGE);
				txtName.setText("");
				txtName.requestFocus();
			}
			catch(MinimumInNameException e) {
				JOptionPane.showMessageDialog(c, "Name should contain atleast 2 characters", "Error", JOptionPane.ERROR_MESSAGE);
				txtName.setText("");
				txtName.requestFocus();
			}
			catch(MarksOutOfRangeExceptionM1 e) {
				JOptionPane.showMessageDialog(c, "Marks m1 out of range", "Error", JOptionPane.ERROR_MESSAGE);
				txtM1.setText("");
				txtM1.requestFocus();
			}
			catch(MarksOutOfRangeExceptionM2 e) {
				JOptionPane.showMessageDialog(c, "Marks m2 out of range", "Error", JOptionPane.ERROR_MESSAGE);
				txtM2.setText("");
				txtM2.requestFocus();
			}
			catch(MarksOutOfRangeExceptionM3 e) {
				JOptionPane.showMessageDialog(c, "Marks m3 out of range", "Error", JOptionPane.ERROR_MESSAGE);
				txtM3.setText("");
				txtM3.requestFocus();
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(c, "issue: " +e);
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
/*
class NegativeRnoException extends Exception {
	String msg;
	NegativeRnoException(String msg) {
		this.msg = msg;
	}
}

class NumberInNameException extends Exception {
	String msg;
	NumberInNameException(String msg) {
		this.msg = msg;
	}
}

class MarksOutOfRangeExceptionM1 extends Exception {
	String msg;
	MarksOutOfRangeExceptionM1(String msg) {
		this.msg = msg;
	}
}
class MarksOutOfRangeExceptionM2 extends Exception {
	String msg;
	MarksOutOfRangeExceptionM2(String msg) {
		this.msg = msg;
	}
}
class MarksOutOfRangeExceptionM3 extends Exception {
	String msg;
	MarksOutOfRangeExceptionM3(String msg) {
		this.msg = msg;
	}
}*/