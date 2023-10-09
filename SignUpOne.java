package max;

import javax.swing.*; 

import java.awt.*;
import java.util.*;

import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

public class SignUpOne extends JFrame implements ActionListener {

	long random;
	JTextField nameTextField, fNameTextField, dobTextField, eMailTextField, addrTextField, ctTextField,stTextField, cntTextField, pcTextField;
	JButton next;
	JRadioButton male, female, other, others, married, unmarried;
	JDateChooser dateChooser;
	
	SignUpOne(){
		setLayout(null);
		
		setTitle("AUTOMATED TELER MACHINE");
		
		Random ran=new Random();
		long random =Math.abs((ran.nextLong()% 9000L)+1000L);
		
		JLabel formno=new JLabel("Application Form No: "+random);
		formno.setFont(new Font("Raleway", Font.BOLD, 26));
		formno.setBounds(130, 20, 400, 70);
		add(formno);
		
		JLabel personalDetails = new JLabel("Page 1:- Personal Details");
		personalDetails.setFont(new Font("Raleway", Font.BOLD, 12));
		personalDetails.setBounds(220, 40, 400, 100);
		add(personalDetails);
		
		JLabel name=new JLabel("Name: ");
		name.setFont(new Font("Raleway", Font.BOLD,16));
		name.setBounds(80, 70, 400, 130);
		add(name);
		
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		nameTextField.setBounds(210, 125, 300, 25);
		add(nameTextField);
		
		JLabel fName= new JLabel("Father's Name:");
		fName.setFont(new Font("Raleway", Font.BOLD, 16));
		fName.setBounds(80, 70, 400, 190);
		add(fName);
		
		fNameTextField =new JTextField();
		fNameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		fNameTextField.setBounds(210, 155, 300, 25);
		add(fNameTextField);
		
		JLabel dob=new JLabel("Date of Birth:");
		dob.setFont(new Font("Raleway", Font.BOLD, 16));
		dob.setBounds(80, 70, 400, 250);
		add(dob);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(210, 185, 300, 25);
		dateChooser.setForeground(new Color(105, 105, 105));
		add(dateChooser);
		
		JLabel gender=new JLabel("Gender:");
		gender.setFont(new Font("Raleway",Font.BOLD,16));
		gender.setBounds(80, 70, 100, 315);
		add(gender);
		
		male = new JRadioButton("Male");
		male.setBounds(210, 210, 80, 30);
		male.setBackground(Color.WHITE);
		add(male);
		
		female = new JRadioButton("Female");
		female.setBounds(310, 210, 100, 30);
		female.setBackground(Color.WHITE);
		add(female);
		
		other = new JRadioButton("Other");
		other.setBounds(430, 210, 80, 30);
		other.setBackground(Color.WHITE);
		add(other);
		
		ButtonGroup gendergroup = new ButtonGroup();
		gendergroup.add(male);
		gendergroup.add(female);
		gendergroup.add(other);
		
		JLabel eMail=new JLabel("Email:");
		eMail.setFont(new Font("Raleway", Font.BOLD, 16));
		eMail.setBounds(80, 70, 400, 370);
		add(eMail);
		
	    eMailTextField= new JTextField();
		eMailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		eMailTextField.setBounds(210, 245, 300, 25);
		add(eMailTextField);
		
		JLabel mStatus=new JLabel("Marital Status:");
		mStatus.setFont(new Font("Raleway", Font.BOLD, 16));
		mStatus.setBounds(80, 70, 400, 430);
		add(mStatus);
		
		married = new JRadioButton("Married");
		married.setBounds(210, 270, 80, 30);
		married.setBackground(Color.WHITE);
		add(married);
		
		unmarried = new JRadioButton("Unmarried");
		unmarried.setBounds(310, 270, 100, 30);
		unmarried.setBackground(Color.WHITE);
		add(unmarried);
		
		others = new JRadioButton("Other");
		others.setBounds(430, 270, 180, 30);
		others.setBackground(Color.WHITE);
		add(others);
		
		ButtonGroup mStatusgroup = new ButtonGroup();
		mStatusgroup.add(married);
		mStatusgroup.add(unmarried);;
		mStatusgroup.add(others);
		
		JLabel addr=new JLabel("Address:");
		addr.setFont(new Font("Raleway",Font.BOLD, 16));
		addr.setBounds(80, 70, 400, 490);
		add(addr);
		
		addrTextField = new JTextField();
		addrTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		addrTextField.setBounds(210, 305, 300, 25);
		add(addrTextField);
		
		JLabel ct =new JLabel("City:");
		ct.setFont(new Font("Raleway", Font.BOLD, 16));
		ct.setBounds(80, 70, 400, 550);
		add(ct);
		
		ctTextField = new JTextField();
		ctTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		ctTextField.setBounds(210, 335, 300, 25);
		add(ctTextField);
		
		JLabel st=new JLabel("State:");
		st.setFont(new Font("Raleway",Font.BOLD, 16));
		st.setBounds(80, 70, 400, 610);
		add(st);
		
		stTextField = new JTextField();
		stTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		stTextField.setBounds(210, 365, 300, 25);
		add(stTextField);
		
		JLabel cnt=new JLabel("Country:");
		cnt.setFont(new Font("Raleway", Font.BOLD, 16));
		cnt.setBounds(80, 70, 400, 670);
		add(cnt);
		
		cntTextField = new JTextField();
		cntTextField.setFont(new Font("Raleway",Font.BOLD,14));
		cntTextField.setBounds(210, 395, 300, 25);
		add(cntTextField);
		
		JLabel pc =new JLabel("Pin Code:");
		pc.setFont(new Font("Raleway",Font.BOLD, 16));
		pc.setBounds(80, 70, 400, 730);
		add(pc);
		
		pcTextField = new JTextField();
		pcTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		pcTextField.setBounds(210, 425, 300, 25);
		add(pcTextField);
		
		next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Raleway", Font.BOLD, 14));
		next.setBounds(430, 460, 80, 25);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(600, 600);
		setLocation(350, 40);
		setVisible(true);	
	}
	public void actionPerformed(ActionEvent ae){
		String formno= " "+random; 
		String name = nameTextField.getText();
		String fName = fNameTextField.getText();
		String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
		
		String gender = null;
		if (male.isSelected()) {
			gender = "Male";
		}else if (female.isSelected()) {
			gender = "Female";
		}else if (other.isSelected()) {
			gender = "Other";
		}
		String eMail = eMailTextField.getText();
		
		String marrital = null;
		if(married.isSelected()) {
			marrital = "Married";
		}else if (unmarried.isSelected()) {
			marrital = "Unmarried";
		}else if (others.isSelected()) {
			marrital = "Others";
		}
		String addr = addrTextField.getText();
		String ct = ctTextField.getText();
		String st = stTextField.getText();
		String cnt = cntTextField.getText();
		String pc = pcTextField.getText();
		
		try {
			if(name.equals("")) {
				JOptionPane.showMessageDialog(null, "Name is Required");
			}else
			{
				Conn c = new Conn();
				String query = "insert into signup values('"+formno+"', '"+name+"', '"+fName+"', '"+dob+"', '"+gender+"', '"+eMail+"', '"+marrital+"', '"+addr+"', '"+ct+"', '"+st+"', '"+cnt+"', '"+pc+"')";
			    c.s.executeUpdate(query);
			    
			    setVisible(false);
			    new SignUpTwo(formno).setVisible(true);
			}
		}catch (Exception e){
			System.out.println(e);
		}
	}
	public static void main(String[] args) {
		new SignUpOne();
	}	
}
