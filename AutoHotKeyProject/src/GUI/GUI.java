package GUI;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
import functions.Functions;

public class GUI extends JFrame implements ActionListener{
	JButton AutComButt;
	JButton AutCorrButt;
	JButton DeleteButt;
	JButton LoadTextButt;
	JButton RunButt;
	JButton TestButt;
	JPanel panel;
	Functions thisfn;
	String keyword;
	String output;
	
	public static void main(String args[]) {
		new GUI();
	}
	public GUI() {
		thisfn=new Functions();
		//mainmenu
		this.setSize(400,400);
		//this is to get the dimensions of the screen to center our frame
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension dim= tk.getScreenSize();
		int xpos=(dim.width/2)-(this.getWidth()/2);
		int ypos=(dim.height/2)-(this.getHeight()/2);
		this.setLocation(xpos, ypos);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Basic Hotkey *SoftWare*");
		panel= new JPanel();
		AutComButt= new JButton("AutoComplete");
		AutCorrButt= new JButton("AutoCorrect");
		DeleteButt= new JButton("DeleteScripts");
		LoadTextButt= new JButton("LoadTextScripts");
		RunButt= new JButton("RunProgramScript");
		TestButt=new JButton ("LoadTestScript");
		MainMenu();
	}
	
	
	public void MainMenu() {
		panel.removeAll();
		this.repaint();
		this.add(panel);	
		panel.add(AutComButt);
		panel.add(AutCorrButt);
		panel.add(DeleteButt);
		panel.add(RunButt);
		panel.add(TestButt);
		panel.add(LoadTextButt);		
		AutComButt.setToolTipText("Add hotkey to auto fill a String");
		AutCorrButt.setToolTipText("Add String that will automatically be replaced by another String");
		DeleteButt.setToolTipText("Delete all scripts in YouHotKeys.ahk file");
		RunButt.setToolTipText("Add hotkey to run any Program/Website");
		TestButt.setToolTipText("Add a script to test whether scripts are successfully working");
		LoadTextButt.setToolTipText("Add Autocorrect Scripts that include common text phrases");
		AutCorrButt.addActionListener(this);
		AutComButt.addActionListener(this);
		DeleteButt.addActionListener(this);
		RunButt.addActionListener(this);
		TestButt.addActionListener(this);
		LoadTextButt.addActionListener(this);
		TestButt.addActionListener(this);
		this.add(panel);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		if (e.getSource()== AutCorrButt) {
			panel.removeAll();
			this.repaint();
			this.add(panel);
			JLabel label=new JLabel("Auto correct your words/use abbreviations without holding back" );
			JLabel label1=new JLabel("Input your Keyword and get the desired output");
			JLabel label2=new JLabel("For example : Keyword=lol and output= Laugh Out Loud");
			panel.add(label);
			panel.add(label1);
			panel.add(label2);
			
			JTextField textfield1=new JTextField("Enter Keyword",10);
			JTextField textfield2=new JTextField("Enter Output",10);
			panel.add(textfield1);
			panel.add(textfield2);
			JButton thisbutt=new JButton("Confirm");
			panel.add(thisbutt);
			JButton back=new JButton("Go Back");
			panel.add(back);
			back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MainMenu();
				}});
			
			thisbutt.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					keyword=textfield1.getText();
					output=textfield2.getText();
					try {
						thisfn.AutoCorrect(keyword, output);
						RepeatingMenu();
					} catch (IOException e1) {
						//this will never happen (hopefully)
					}
				}});	
		}
		if (e.getSource()== AutComButt) {
			panel.removeAll();
			this.repaint();
			this.add(panel);
			JLabel label=new JLabel("Auto complete your words like never before" );
			JLabel label1=new JLabel("Input your Keyword and get the desired output");
			JLabel label2=new JLabel("For example : Keyword=ctrl alt p and output= Laugh Out Loud");
			panel.add(label);
			panel.add(label1);
			panel.add(label2);
			JTextField textfield1=new JTextField("Enter Keyword",10);
			JTextField textfield2=new JTextField("Enter Output",10);
			panel.add(textfield1);
			panel.add(textfield2);
			
			JButton thisbutt=new JButton("Confirm");
			panel.add(thisbutt);
			JButton back=new JButton("Go Back");
			panel.add(back);
			
			back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MainMenu();
				}});
			
			thisbutt.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					keyword=textfield1.getText();
					output=textfield2.getText();
					try {
						thisfn.AutoComplete(keyword, output);
						RepeatingMenu();
					} catch (IOException e1) {
						//this will never happen (hopefully)
					}
				}});	
		}
		if (e.getSource()== DeleteButt) {
			panel.removeAll();
			this.repaint();
			this.add(panel);
			JLabel label=new JLabel("Delete all of the scripts?" );
			panel.add(label);
			JButton thisbutt=new JButton("Confirm");
			panel.add(thisbutt);
			JButton back=new JButton("Go Back");
			panel.add(back);
			
			back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MainMenu();
				}});
			
			thisbutt.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					try {
						thisfn.deleteallscripts();
						RepeatingMenu();
					} catch (IOException e1) {
						//this will never happen (hopefully)
					}
				}});	
		}
		if (e.getSource()== RunButt) {
			panel.removeAll();
			this.repaint();
			this.add(panel);
			JLabel label=new JLabel("Run Programs at the press of simple buttons!" );
			JLabel label1=new JLabel("WEBSITES TOO! (Remember you use the full filepath and URLS)");
			JLabel label2=new JLabel("For example : Keyword=ctrl alt p and program= Http::/www.google.com");
			panel.add(label);
			panel.add(label1);
			panel.add(label2);
			JTextField textfield1=new JTextField("Enter Keys",10);
			JTextField textfield2=new JTextField("Enter Program",10);
			panel.add(textfield1);
			panel.add(textfield2);
			
			JButton thisbutt=new JButton("Confirm");
			panel.add(thisbutt);
			JButton back=new JButton("Go Back");
			panel.add(back);
			
			back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MainMenu();
				}});
			
			thisbutt.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					keyword=textfield1.getText();
					output=textfield2.getText();
					try {
						thisfn.RunProgram(keyword, output);
						RepeatingMenu();
					} catch (IOException e1) {
						//this will never happen (hopefully)
					}
				}});	
		}
		if (e.getSource()== LoadTextButt) {
			panel.removeAll();
			this.repaint();
			this.add(panel);
			JLabel label=new JLabel("Load the Text scripts?" );
			panel.add(label);
			JButton thisbutt=new JButton("Confirm");
			panel.add(thisbutt);
			JButton back=new JButton("Go Back");
			panel.add(back);
			
			back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MainMenu();
				}});
			
			thisbutt.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					try {
						thisfn.loadtextscript();
						RepeatingMenu();
					} catch (IOException e1) {
						//this will never happen (hopefully)
					}
				}});	
		}
		if (e.getSource()== TestButt) {
			panel.removeAll();
			this.repaint();
			this.add(panel);
			JLabel label=new JLabel("Load the Test scripts?" );
			panel.add(label);
			JButton thisbutt=new JButton("Confirm");
			panel.add(thisbutt);
			JButton back=new JButton("Go Back");
			panel.add(back);
			
			back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MainMenu();
				}});
			
			thisbutt.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					try {
						thisfn.LoadScriptTest();
						RepeatingMenu();
					} catch (IOException e1) {
						//this will never happen (hopefully)
					}
				}});	
		}
		this.setVisible(true);
	}
	
	public void RepeatingMenu() {
		panel.removeAll();
		this.repaint();
		this.add(panel);
		JLabel label= new JLabel("Do you want to add more scripts?");
		JButton butt1=new JButton("Yes!");
		JButton butt2=new JButton("No!");
		panel.add(label);
		panel.add(butt1);
		panel.add(butt2);
		butt1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainMenu();
			}});
		butt2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}});
		this.setVisible(true);
	}

}