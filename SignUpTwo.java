package max;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class SignUpTwo extends JFrame implements ActionListener{

	//long random;
	JTextField  panTextField,aadharTextField;
	JButton next;
	JRadioButton yes, no,eyes,eno ;
	JComboBox  religion, vcategory,incom ,education,occupation ;
	String formno;
	
	SignUpTwo(String formno){
		this.formno =formno;
		setLayout(null);
		
		setTitle("NEW ACCOUNT APPLICATION FORM-PAGE:2");
		
		Random ran = new Random();
		long random = Math.abs((ran.nextLong()% 9000L)+1000L);
		
		JLabel additionalDetails = new JLabel("Additional Details:Page-2");
		additionalDetails.setFont(new Font("Raleway", Font.BOLD, 26));
		additionalDetails.setBounds(130, 20, 400, 70);
		add(additionalDetails);
		
		JLabel rName = new JLabel("Religion:");
		rName.setFont(new Font("Raleway", Font.BOLD, 16));
		rName.setBounds(70, 75, 400, 130);
		add(rName);
		
		String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Others"};
		religion = new JComboBox(valReligion);
		religion.setBounds(230, 130, 300, 25);
		add(religion);
		
		JLabel category = new JLabel("Category:");
		category.setFont(new Font("Raleway", Font.BOLD, 16));
		category.setBounds(70, 80, 400, 190);
		add(category);
		
		String valCategory[] = {"Gen", "OBC", "SC", "ST", "Others"};
		vcategory = new JComboBox(valCategory);
		vcategory.setBounds(230, 165, 300, 25);
		add(vcategory);
		
		JLabel income = new JLabel("Income:");
		income.setFont(new Font("Raleway",Font.BOLD, 16));
		income.setBounds(70, 80, 400, 250);
		add(income);
		
		String valIncome[] = {"<50,000", "<150,000", "<300,000", "<600,000", "<1,000,000","<Above"};
		incom = new JComboBox(valIncome);
		incom.setBounds(230, 195, 300, 25);
		add(incom);
				
		JLabel qualf = new JLabel("Qulification:");
		qualf.setFont(new Font("Raleway", Font.BOLD, 16));
		qualf.setBounds(70, 80, 100, 315);
		add(qualf);
		
		String valEducation[] = {"Non-Graduate", "Graduate", "Post-Graduate","Doctrate","Others"};
		education = new JComboBox(valEducation);
		education.setBounds(230, 225, 300, 25);
		add(education);
		
		JLabel occup = new JLabel("Occupation:");
		occup.setFont(new Font("Raleway", Font.BOLD, 16));
		occup.setBounds(70, 80, 400, 370);
		add(occup);
		
		String occupationValues[] = {"Student","Self-Employee","Govt-Empolyee","Businessman","Retired","Other"};
		occupation = new JComboBox(occupationValues);
		occupation.setBounds(230, 255, 300, 25);
		add(occupation);
		
	    JLabel pan = new JLabel("Pan Card No:");
	    pan.setFont(new Font("Raleway", Font.BOLD, 16));
	    pan.setBounds(70, 80, 400, 430);
	    add(pan);
	    
	    panTextField = new JTextField();
	    panTextField.setFont(new Font("Raleway", Font.BOLD, 16));
	    panTextField.setBounds(230, 285, 300, 25);
	    add(panTextField);
	  
		JLabel aadhar = new JLabel("Aadhar No:");
		aadhar.setFont(new Font("Raleway",Font.BOLD, 16));
		aadhar.setBounds(70, 80, 400, 490);
	    add(aadhar);
	    
	    aadharTextField = new JTextField();
	    aadharTextField.setFont(new Font("Raleway", Font.BOLD, 16));
	    aadharTextField.setBounds(230, 315, 300, 25);
	    add(aadharTextField);
	    
	    JLabel sctzn = new JLabel("Senior Citizen:");
	    sctzn.setFont(new Font("Raleway", Font.BOLD, 16));
	    sctzn.setBounds(70, 80, 400, 550);
	    add(sctzn);
	    
	    yes = new JRadioButton("Yes");
	    yes.setBounds(230, 348, 100, 16);
	    yes.setBackground(Color.WHITE);
	    add(yes);
	    
	    no = new JRadioButton("No");
	    no.setBounds(330, 348, 100, 16);
	    no.setBackground(Color.WHITE);
	    add(no);
	    
	    ButtonGroup sctzngroup = new ButtonGroup();
	    sctzngroup.add(yes);
	    sctzngroup.add(no);
	     
	    JLabel exacc = new JLabel("Exisiting Account");
	    exacc.setFont(new Font("Raleway", Font.BOLD, 16));
	    exacc.setBounds(70, 80, 400, 610);
	    add(exacc);
	    
	    eyes = new JRadioButton("Yes");
	    eyes.setBounds(230, 380, 100, 16);
	    eyes.setBackground(Color.WHITE);
	    add(eyes);
	    
	    eno = new JRadioButton("No");
	    eno.setBounds(330, 380, 100, 16);
	    eno.setBackground(Color.WHITE);
	    add(eno);
	    
	    ButtonGroup exaccgroup = new ButtonGroup();
	    exaccgroup.add(eyes);
	    exaccgroup.add(eno);
	    
	    next = new JButton("Next");
	    next.setBackground(Color.BLACK);
	    next.setForeground(Color.WHITE);
	    next.setFont(new Font("Raleway", Font.BOLD, 16));
	    next.setBounds(440, 420, 80, 25);
	    next.addActionListener(this);
	    add(next);
	    
		getContentPane().setBackground(Color.WHITE);
		setSize(600,600);
		setLocation(350,40);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae) {
		//String formno = "" + random;
		String sreligion = (String) religion.getSelectedItem();
		String scategory = (String) vcategory.getSelectedItem();
		String sincom = (String) incom.getSelectedItem();
		String seducation = (String) education.getSelectedItem();
		String soccupation = (String) occupation.getSelectedItem();
		
		String seniorcitizen = null;
		if(yes.isSelected()) {
			seniorcitizen ="Yes";
		}else if(no.isSelected()) {
			seniorcitizen = "No";
		}
		
		String existingaccount = null;
		if(eyes.isSelected()) {
			existingaccount = "Yes";
		}else if(eno.isSelected()) {
			existingaccount = "No";
		}
		
		String pan = panTextField.getText();
		String aadhar = aadharTextField.getText();
		
		try {
			Conn c = new Conn();
			String query = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincom+"','"+seducation+"','"+soccupation+"','"+pan+"','"+aadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
			c.s.executeUpdate(query);
			
			setVisible(false);
			new SignUpThree(formno).setVisible(true);
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		
		new SignUpTwo("");

	}
}
