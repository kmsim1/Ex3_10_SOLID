package ex_3_10;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class CalculatePayMachine extends Frame implements ActionListener, DocumentListener{
	
	private JLabel workingHoursLabel = new JLabel("Working Hours = ", Label.RIGHT);
	private JLabel overTimeHoursLabel = new JLabel("Overtime Hours = " ,Label.RIGHT);
	private JLabel payAmountLabel = new JLabel("Pay Amount = ",Label.RIGHT);
	
	
	private JTextField tWorkingHours = new JTextField();
	private JTextField tOverTimeHours = new JTextField();
	private JTextField tResult = new JTextField();
	
	
	private JButton calcButton = new JButton("Calculate");
	private JButton resetButton = new JButton("Reset");
	private JButton end = new JButton("Stop");
	
	public CalculatePayMachine(){
		super("Payment Calculation");
		this.init();
		this.start();
		this.setSize(500,250);
		
		this.setVisible(true);
	}
	public void init(){
		this.setLayout(new GridLayout(5,1));
		Panel p = new Panel(new BorderLayout());
		p.add("West",workingHoursLabel);
		p.add("Center", tWorkingHours);
		this.add(p);
		
		Panel p1 = new Panel(new BorderLayout());
		p1.add("West",overTimeHoursLabel);
		p1.add("Center", tOverTimeHours);
		this.add(p1);
		
		Panel p2 = new Panel(new FlowLayout(FlowLayout.CENTER));
		p2.add(calcButton);
		this.add(p2);
		
		Panel p3 = new Panel(new BorderLayout());
		p3.add("West",payAmountLabel);
		p3.add("Center", tResult);
		this.add(p3);
		
		Panel p4 = new Panel(new FlowLayout(FlowLayout.CENTER));
		p4.add(resetButton);
		p4.add(end);
		this.add(p4);
		
	}
	public void start(){
		calcButton.addActionListener(this);
		resetButton.addActionListener(this);
		
		tWorkingHours.getDocument().addDocumentListener(this);
		tOverTimeHours.getDocument().addDocumentListener(this);
		end.addActionListener(this);
		
		calcButton.setEnabled(false);
		resetButton.setEnabled(false);
	}
	public boolean isDataEntered(){
		if(tWorkingHours.getText().trim().length() == 0 || tOverTimeHours.getText().trim().length() == 0)
			return false;
		return true;
	}
	@Override
	public void changedUpdate(DocumentEvent e) {
		checkData();
		
	}
	@Override
	public void insertUpdate(DocumentEvent e) {
		checkData();
		
	}
	@Override
	public void removeUpdate(DocumentEvent e) {
		checkData();
		
	}
	private void checkData(){
		calcButton.setEnabled(isDataEntered());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == end){
			System.exit(0);
		}
		
		if(e.getSource() == resetButton){
			tWorkingHours.setText("");
			tOverTimeHours.setText("");
			tWorkingHours.requestFocus();
			tResult.setText("");
			resetButton.setEnabled(false);
			return ;
		}
		
		if(e.getSource() == calcButton){
			int x = 0;
			try{
				x = Integer.parseInt(tWorkingHours.getText().trim());
			}catch(NumberFormatException ex){
				tWorkingHours.setText("");
				tWorkingHours.requestFocus();
				return ;
			}
			int y = 0;
			try{
				y = Integer.parseInt(tOverTimeHours.getText().trim());
			}catch(NumberFormatException ex){
				tOverTimeHours.setText("");
				tOverTimeHours.requestFocus();
				return ;
			}
			
			int payAmount = 0;
			payAmount = 10*x + 15*y;
			
			tResult.setText(String.valueOf(payAmount));
			resetButton.setEnabled(true);
		}
		

	}
	public static void main(String args[]){
		new CalculatePayMachine();
	}
}

