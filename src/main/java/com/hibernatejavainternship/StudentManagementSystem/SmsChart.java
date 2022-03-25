package com.hibernatejavainternship.StudentManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;

class SmsChart {

	public static void main(String[] args) {
		ChartFrame c1 = new ChartFrame();
	}

}

class ChartFrame extends JFrame {
	
	JButton btnBack;
	Container c;
	JFrame frame;
	JPanel panx;
	
	ChartFrame() {
		gui();
	}
	
	void gui() {
		frame = new JFrame();
		frame.setSize(750, 550);
		frame.setTitle("Marks Chart");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		c = getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 30));
		c.setBackground(Color.RED);
		
//		String data = DBHandler.chartRnoData();
//		String datarn[] = data.split(" ");
		
//		String dataname[] = DBHandler.chartNameData().split(" ");
		
		String datax[] = DBHandler.chartViewData().split(" ");
		
		DefaultCategoryDataset ds = new DefaultCategoryDataset();

		try {
			for(int i=0; i<datax.length; i+=4) {
				ds.addValue(Integer.parseInt(datax[i+1]), datax[i], "sub1");
			}
	
			for(int i=0; i<datax.length; i+=4) {
				ds.addValue(Integer.parseInt(datax[i+2]), datax[i], "sub2");
			}
	
			for(int i=0; i<datax.length; i+=4) {
				ds.addValue(Integer.parseInt(datax[i+3]), datax[i], "sub3");
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(c, "issue: " +e);
		}
		
//		ds.addValue(87, "John", "S1");
//		ds.addValue(88, "John", "S2");
//		ds.addValue(91, "Bhavesh", "S3");
		
//		for(int i=0; i<datarn.length; i++) {
//			ds.addValue(Integer.parseInt(datarn[i]), "Bhavesh", "S3");
//		}
//		JFreeChart chart = ChartFactory.createBarChart("Bhavesh's Perf", "Subject", "Marks", ds, PlotOrientation.VERTICAL, true, true, true);
		JFreeChart chart = ChartFactory.createBarChart("Student Performance", "Subject", "Marks", ds, PlotOrientation.VERTICAL, true, true, true);
		
		ChartPanel panel = new ChartPanel(chart);
		c.add(panel);
		c.setVisible(true);
		frame.add(c);
		

		
		panx = new JPanel();
		btnBack = new JButton("Back");
		panx.add(btnBack);
		panx.setVisible(true);
		frame.add(panx, BorderLayout.SOUTH);
		
		ActionListener back = ae -> {
//			JOptionPane.showMessageDialog(new JDialog(), datax[1]);
//			JOptionPane.showMessageDialog(new JDialog(), Integer.parseInt(datarn[1]) +" " +dataname[1] +" " +datam1[1] +" " +datam2[1] +" " +datam3[1]);
			MainFrame m1 = new MainFrame();
			frame.dispose();
			
//			for(int i=0; i<datax.length; i++) {
//				JOptionPane.showMessageDialog(new JDialog(), datax[i+0] +" " +datax[i+1]);
//			}
			
//			JOptionPane.showMessageDialog(new JDialog(), datax);
		};
		btnBack.addActionListener(back);
		
		frame.setVisible(true);
	}
}