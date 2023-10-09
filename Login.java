package max;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener{
	JButton login, signup, clear;
	JTextField cardTextField;
	JPasswordField pinTextField;

	Login() {
		
		setLayout(null);
		
		setTitle("AUTOMATED TELER MACHINE");
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bank.jpg"));
		Image i2= i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
		JLabel label =new JLabel(i3);
        label.setBounds(60, 10, 50, 80);
		add(label);
		
		JLabel text =new JLabel("Welcome To ATM");
		text.setFont(new Font("Osword", Font.BOLD, 34));
		text.setBounds(130, 40, 300, 40);
		add(text);
		
		JLabel cardNo = new JLabel ("Card No:");
		cardNo.setFont(new Font("Raleway", Font.BOLD, 24));
		cardNo.setBounds(130, 100, 200, 100);
		add(cardNo);
		
		cardTextField =new JTextField();
		cardTextField.setBounds(250, 135, 250, 30);
		cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
		add(cardTextField);
		
		JLabel pinnumber = new JLabel("Pin No:");
		pinnumber.setFont(new Font("Raleway", Font.BOLD, 24));
		pinnumber.setBounds(130, 150, 100, 150);
		add(pinnumber);
		
		pinTextField = new JPasswordField();
		pinTextField.setBounds(250, 210, 250, 30 );
		pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
		add(pinTextField);
		
	    login = new JButton("SIGN IN");
		login.setBounds(250, 300, 100, 30);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		add(login);
		
	    clear = new JButton("CLEAR");
		clear.setBounds(250, 350, 250, 30);
		clear.setBackground(Color.BLACK);
		clear.setForeground(Color.WHITE);
		clear.addActionListener(this);
		add(clear);
		
		signup = new JButton("SIGN UP");
		signup.setBounds(400, 300, 100, 30);
		signup.setBackground(Color.BLACK);
		signup.setForeground(Color.WHITE);
		signup.addActionListener(this);
		add(signup);
		
			
		getContentPane().setBackground(Color.white);
		
		setSize(700, 500);
		setVisible(true);
		setLocation(300, 100);
	}
	    public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()== clear) {
			cardTextField.setText("");
			pinTextField.setText("");
			
		}
		else if(ae.getSource()== login) {
			Conn conn = new Conn();
			String cardnumber = cardTextField.getText();
			String pinnumber = pinTextField.getText();
			String query ="select * from login where cardnumber ='"+cardnumber+"' and pinnumber = '"+pinnumber+"'";
				try {
					ResultSet rs = conn.s.executeQuery(query);
					if(rs.next()) {
						setVisible(false);
						new Transactions(pinnumber).setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
					}
					}catch(Exception e) {
						System.out.println(e);
					}
		}
		else if (ae.getSource()  == signup) {
			setVisible(false);
			new SignUpOne().setVisible(true);
			}
		}

	    public static void main(String[] args) {
		new Login();
	}
}
