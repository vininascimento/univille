package com.schoolofnet.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CalcController implements ActionListener {

	private static JTextField num1 = new JTextField(30);
	private static JTextField num2 = new JTextField(30);
	private static JComboBox op = new JComboBox();
	
	public CalcController(JComboBox op, JTextField num1, JTextField num2) {
		this.op = op;
		this.num1 = num1;
		this.num2 = num2;
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Float result = (float) 0;
		Float num1 = this.num1.getText() == null ?  (float) 0 : Float.parseFloat(this.num1.getText());
		Float num2 = this.num2.getText() == null ? (float) 0 : Float.parseFloat(this.num2.getText());
		
		String op = this.op.getSelectedItem().toString();
		
		switch(op){
			case "+" : 
				result = num1 + num2;
			break;
			case "-" : 
				result = num1 - num2;
			break;
			case "*" : 
				result = num1 * num2;
			break;
			case "/" : 
				result = num1 / num2;
			break;
			default:
				System.out.println("Invalid Option");
		}
		System.out.println(result);
		JOptionPane.showMessageDialog(null, result.toString());
	}

}
