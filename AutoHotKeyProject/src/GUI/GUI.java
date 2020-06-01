package GUI;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import functions.Functions;
public class GUI implements ActionListener {
	JFrame frame;
	JPanel panel;
	JButton button;
	int count=0;
	JLabel label;
	
	
	public GUI() {
		frame=new JFrame();
		
		button=new JButton("Click ME!");
		button .addActionListener(this);
		
		label=new JLabel("Number of clicks:" + count);
		
		panel=new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
		panel.setLayout(new GridLayout(0,1));
		panel.add(button);
		panel.add(label);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("GUIPRACTICE");
		frame.pack();
		frame.setVisible(true);
		
		
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		count++;
		label.setText("Number of clicks:" + count);
	}
	
	public static void main(String[] args) {
		new GUI();
	}


}
