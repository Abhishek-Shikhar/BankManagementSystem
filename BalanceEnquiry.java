package max;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
	
	JButton back;
	String pinnumber;
	
	BalanceEnquiry(String pinnumber){
		this.pinnumber = pinnumber;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atmimages.jpg"));
		Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 600, 600);
		add(image);
		
		back = new JButton("Back");
		back.setBounds(258, 324, 110, 13);
		back.setFont(new Font("Raleway",Font.BOLD, 10));
		back.addActionListener(this);
		image.add(back);
		
		Conn c= new Conn();
		int balance = 0;
		try {
			ResultSet rs = c.s.executeQuery("select * from bank where pin=  '"+pinnumber+"'");
		
		while (rs.next()) {
			if(rs.getString("type").equals("Deposit")) {
				balance += Integer.parseInt(rs.getString("amount"));					
			}
			else {
				balance -= Integer.parseInt(rs.getString("amount"));
			}
		}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		JLabel text = new JLabel("Your current acount balance is Rs " + balance );
		text.setForeground(Color.BLACK);
		text.setBounds(150, 220,200, 15);
		text.setFont(new Font("Raleway",Font.BOLD, 10));
		image.add(text);
		
		setSize(600, 550);
		setLocation(350, 40);
		setUndecorated(true);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Transactions(pinnumber).setVisible(true);
		
	}
	public static void main(String args[]) {
		new BalanceEnquiry("");

	}
}
