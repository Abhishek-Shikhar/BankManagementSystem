package max;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class SignUpThree extends JFrame implements ActionListener{
	
	JRadioButton sacc, cacc, fdacc, rdacc;
	JCheckBox c1,c2,c3,c4,c5,c6,c7;
	JButton submit, cancel;
	String formno;
		
	SignUpThree(String formno){
		this.formno = formno;
		setLayout(null);
		
		setTitle("NEW ACCOUNT APPLICATION FORM-PAGE:3");
		
		JLabel accd = new JLabel("Account Details: Page-3");
		accd.setFont(new Font("Raleway", Font.BOLD, 26));
		accd.setBounds(130, 20, 400, 70);
		add(accd);
		
		JLabel actype = new JLabel("Account Type:");
		actype.setFont(new Font("Raleway",Font.BOLD,16));
		actype.setBounds(70, 90, 150, 30);
		add(actype);
		
		sacc = new JRadioButton("Saving Account");
		sacc.setFont(new Font("Raleway",Font.BOLD,12));
		sacc.setBounds(70, 120, 180, 25);
		add(sacc);
		
		cacc = new JRadioButton("Current Account");
		cacc.setFont(new Font("Raleway",Font.BOLD,12));
		cacc.setBounds(290,120,180,25);
		add(cacc);
		
		fdacc = new JRadioButton("Fixed Deposit Account");
		fdacc.setFont(new Font("Raleway",Font.BOLD,12));
		fdacc.setBounds(70,150, 210, 25);
		add(fdacc);
		
		rdacc = new JRadioButton("Recurring Deposit Account");
		rdacc.setFont(new Font("Raleway",Font.BOLD,12));
		rdacc.setBounds(290, 150, 230, 25);
		add(rdacc);
		
		ButtonGroup groupaccount = new ButtonGroup();
		groupaccount.add(sacc);
		groupaccount.add(cacc);
		groupaccount.add(fdacc);
		groupaccount.add(rdacc);
		
		JLabel card = new JLabel("Card Number:");
		card.setFont(new Font("Raleway",Font.BOLD,16));
		card.setBounds(70, 190, 150, 25);
		add(card);
		
		JLabel number = new JLabel("XXXX-XXXX-XXXX-8528");
		number.setFont(new Font("Raleway",Font.BOLD,14));
		number.setBounds(250, 190, 200, 25);
		add(number);
		
		JLabel carddetail = new JLabel("Your 16 digit card no:");
		carddetail.setFont(new Font("Raleway",Font.BOLD,10));
		carddetail.setBounds(70, 210, 200, 15);
		add(carddetail);
		
		JLabel pin = new JLabel("PIN:");
		pin.setFont(new Font("Raleway",Font.BOLD,16));
		pin.setBounds(70, 230, 100, 25);
		add(pin);
		
		JLabel pnumber = new JLabel("XXXX");
		pnumber.setFont(new Font("Raleway",Font.BOLD,16));
		pnumber.setBounds(250, 230, 100, 25);
		add(pnumber);
		
		JLabel pindetail = new JLabel("Your 4 digit password:");
		pindetail.setFont(new Font("Raleway",Font.BOLD,10));
		pindetail.setBounds(70, 250, 200, 15);
		add(pindetail);
		
		JLabel services = new JLabel("Services required:");
		services.setFont(new Font("Raleway",Font.BOLD,16));
		services.setBounds(70, 270, 150, 25);
		add(services);
		
		c1 = new JCheckBox("ATM Card");
		c1.setFont(new Font("Raleway",Font.BOLD,14));
		c1.setBounds(70, 300, 150, 25);
		add(c1);
		
		c2 = new JCheckBox("Internet Banking");
		c2.setFont(new Font("Raleway",Font.BOLD,14));
		c2.setBounds(290, 300, 200, 25);
		add(c2);
		
		c3 = new JCheckBox("Mobile Banking");
		c3.setFont(new Font("Raleway",Font.BOLD,14));
		c3.setBounds(70, 330, 200, 25);
		add(c3);
		
		c4 = new JCheckBox("Email & SMS");
		c4.setFont(new  Font("Raleway",Font.BOLD,14));
		c4.setBounds(290, 330, 200, 25);
		add(c4);
		
		c5 = new JCheckBox("Cheque Box");
		c5.setFont(new Font("Raleway",Font.BOLD,14));
		c5.setBounds(70, 360, 200, 25);
		add(c5);
		
		c6 = new JCheckBox("E-Statement");
		c6.setFont(new Font("Raleway",Font.BOLD,14));
		c6.setBounds(290, 360, 200, 25);
		add(c6);
		
		c7 = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge.");
		c7.setFont(new Font("Raleway",Font.BOLD,10));
		c7.setBounds(70, 410, 510, 25);
		add(c7);
        
        submit = new JButton("Submit");
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.setFont(new Font("Raleway",Font.BOLD,14));
		submit.setBounds(140, 440, 100, 25);
		submit.addActionListener(this);
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font("Raleway",Font.BOLD,14));
		cancel.setBounds(330, 440, 100, 25);
		cancel.addActionListener(this);
        add(cancel);
		
		
		setSize(600,600);
		setLocation(350,40);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()== submit) {
			String accountType = null;
			
			if(sacc.isSelected()) {
				accountType = "Saving Account";
				
			}else if(cacc.isSelected()) {
				accountType = "Current Account";
				
			}else if (fdacc.isSelected()) {
				accountType = "Fixed Deposit Account";
				
			}else if (rdacc.isSelected()) {
				accountType = "Recurring Deposit Account";
			}
			
			Random random = new Random();
			String cardnumber = ""+Math.abs((random.nextLong() % 90000000L)+ 5040936000000000L);
			String pinnumber = ""+Math.abs((random.nextLong() % 9000L)+ 1000L);
			
			String facility ="";
			if(c1.isSelected()) {
				facility = facility + "ATM Card";
			
			}else if(c2.isSelected()) {
				facility = facility + "Internet Banking";
				
			}else if(c3.isSelected()) {
				facility = facility + "Mobile Banking";
				
			}else if(c4.isSelected()) {
				facility = facility + "Email & SMS";
				
			}else if(c5.isSelected()) {
				facility = facility + "Cheque Box";
				
			}else if(c6.isSelected()) {
				facility = facility + "E-Statement";	
			}
			
			try {
				if(accountType.equals("")) {
					JOptionPane.showMessageDialog(null, "Account type is required");
					
				}else {
					Conn conn = new Conn();
					String query1 = "insert into signUpThree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
				    String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
					conn.s.executeUpdate(query1);
					conn.s.executeUpdate(query2);
					
				JOptionPane.showMessageDialog(null, "Card Number"+ cardnumber +"\n Pin:"+ pinnumber);
				
				setVisible(false);
				new Deposit(pinnumber).setVisible(false);
				}
				
			}catch(Exception e) {
				System.out.println(e);
				
			}		
		}else if (ae.getSource()== cancel) {
		
			setVisible(false);
			new Login().setVisible(true);
		}		
	}
	public static void main(String[] args) {
		
     new SignUpThree("");
	}
}
