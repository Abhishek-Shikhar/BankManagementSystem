package max;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
	
	JButton rsfive, rsten, rstwenty, rsfourty, rsfifty, rstenth, back, exit, withdrawl;
	String pinnumber;
	
	FastCash(String pinnumber){
		this.pinnumber = pinnumber;
		
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atmimages.jpg"));
		Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 600, 600);
		add(image);
		
		JLabel text = new JLabel ("Select withdrawl amount");
		text.setBounds(180, 240, 250, 15);
		text.setForeground(Color.BLACK);
		text.setFont(new Font("Raleway", Font.BOLD, 12));
		image.add(text);
		
		rsfive = new JButton("Rs 500");
		rsfive.setBounds(140, 273, 100, 13);
		rsfive.addActionListener(this);
		image.add(rsfive);
		
		rsten =new JButton("Rs 1000");
		rsten.setBounds(258, 273, 110, 13);
		rsten.addActionListener(this);
		image.add(rsten);
		
		rstwenty = new JButton("Rs 2000");
		rstwenty.setBounds(140, 290, 100, 13);
		rstwenty.addActionListener(this);
		image.add(rstwenty);
		
		rsfourty = new JButton("Rs 4000");
		rsfourty.setBounds(258, 290, 110, 13);
		rsfourty.addActionListener(this);
		image.add(rsfourty);
		
		rsfifty = new JButton("Rs 5000");
		rsfifty.setBounds(140, 307, 100, 13);
		rsfifty.addActionListener(this);
		image.add(rsfifty);
		
		rstenth = new JButton("Rs 10000");
		rstenth.setBounds(258, 307, 110, 13);
		rstenth.addActionListener(this);
		image.add(rstenth);
		
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
		    if(ae.getSource()== exit) {
		    setVisible(false);
		new Transactions(pinnumber).setVisible(true);
						
		}else {
			String amount = ((JButton)ae.getSource()).getText().substring(3);
			
			Conn c= new Conn();
			try {
				ResultSet rs = c.s.executeQuery("select * from bank where pin =  '"+pinnumber+"'");
			int balance = 0;
			while (rs.next()) {
				if(rs.getString("type").equals("Deposit")) {
					balance += Integer.parseInt(rs.getString("amount"));					
				}
				else {
					balance -= Integer.parseInt(rs.getString("amount"));
				}
			}
			if (ae.getSource()!= exit && balance < Integer.parseInt(amount)) {
				JOptionPane.showMessageDialog(null, "Insufficient Balance");
				return;
			}
			    Date date = new Date();
			String query = "insert into bank values('"+pinnumber+"','"+date+"','withdrawl','"+amount+"')";
			c.s.executeUpdate(query);
			
			JOptionPane.showMessageDialog(null, "RS "+amount+ " Debited Successfully");
			    setVisible(false);
			new Transactions(pinnumber).setVisible(true);
			
			}catch (Exception e) {
					System.out.println(e);
				}
			}
		}
	    public static void main(String[] args) {
		new FastCash("");
	}	
}