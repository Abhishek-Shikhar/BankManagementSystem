package max;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Deposit extends JFrame implements ActionListener{
	
	JTextField amount;
	JButton deposit, back;
	String pinnumber;
	
	Deposit(String pinnumber){
		this.pinnumber = pinnumber;
			
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atmimages.jpg"));
		Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 600, 600);
		add(image);
		
		JLabel text = new JLabel("Enter the amount you want to deposit.");
		text.setForeground(Color.BLACK);
		text.setFont(new Font("Raleway", Font.BOLD, 10));
		text.setBounds(165, 220, 250, 13);
		image.add(text);
		
		JLabel rtext = new JLabel("Rs.");
		rtext.setForeground(Color.BLACK);
		rtext.setFont(new Font("Raleway", Font.BOLD, 10));
		rtext.setBounds(150, 240, 50, 13);
		image.add(rtext);
		
		amount = new JTextField();
		amount.setFont(new Font("Raleway", Font.BOLD, 10));
		amount.setBounds(165, 240, 180, 15);
		image.add(amount);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(258, 307, 110, 13);
		deposit.addActionListener(this);
		image.add(deposit);
		
		back = new JButton("Back");
		back.setBounds(258, 324, 110, 13);
		back.addActionListener(this);
		image.add(back);
		
		
		setSize(600, 600);
		setLocation(350, 50);
		setUndecorated(true);
		setVisible(true);	
		
	}	
	public void actionPerformed(ActionEvent ae) {
	if(ae.getSource() == deposit) {
		
		String number =amount.getText(); 
			Date date = new Date();
			
		if(number.equals("")) {
			JOptionPane.showMessageDialog(null, "please enter amount you want to deposit");
		}
		else {			
			try {
			Conn conn =new Conn();
			String query = " insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+number+"')";
		
			conn.s.executeUpdate(query);
		       JOptionPane.showMessageDialog(null, "Rs "+number+" Deposited Successfully");
		       setVisible(false);
		     new Transactions(pinnumber).setVisible(true);
			}	
			catch (Exception e) {
				System.out.println(e);
			}
	}
		}
		else if(ae.getSource()== back)
	{   setVisible(false);
		
	    new Transactions(pinnumber).setVisible(true);
	}
	}
    public static void main(String args[]) {
		new Deposit("");
	}
}