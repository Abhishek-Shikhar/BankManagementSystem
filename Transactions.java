package max;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Transactions extends JFrame implements ActionListener{
	
	JButton deposit, withdrawl, fastcash, ministatement, pinchange, balanceenquiry, exit;
	String pinnumber;
	
	Transactions(String pinnumber){
		this.pinnumber = pinnumber;
		
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atmimages.jpg"));
		Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 600, 600);
		add(image);
		
		JLabel text = new JLabel ("Please Select Your Transactions");
		text.setBounds(165, 240, 250, 15);
		text.setForeground(Color.BLACK);
		text.setFont(new Font("Raleway", Font.BOLD, 12));
		image.add(text);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(140, 273, 100, 13);
		deposit.setFont(new Font("Raleway", Font.BOLD, 10));
		deposit.addActionListener(this);
		image.add(deposit);
		
		withdrawl =new JButton("Cash Withdrawl");
		withdrawl.setBounds(258, 273, 110, 13);
		withdrawl.setFont(new Font("Raleway", Font.BOLD, 10));
		withdrawl.addActionListener(this);
		image.add(withdrawl);
		
		fastcash = new JButton("Fast Cash");
		fastcash.setBounds(140, 290, 100, 13);
		fastcash.setFont(new Font("Raleway", Font.BOLD, 10));
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		ministatement = new JButton("Mini Statement");
		ministatement.setBounds(258, 290, 110, 13);
		ministatement.setFont(new Font("Raleway", Font.BOLD, 10));
		ministatement.addActionListener(this);
		image.add(ministatement);
		
		pinchange = new JButton("Pin Change");
		pinchange.setBounds(140, 307, 100, 13);
		pinchange.setFont(new Font("Raleway", Font.BOLD, 10));
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		balanceenquiry = new JButton("Balance Enquiry");
		balanceenquiry.setBounds(258, 307, 110, 13);
		balanceenquiry.setFont(new Font("Raleway", Font.BOLD, 9));
		balanceenquiry.addActionListener(this);
		balanceenquiry.addActionListener(this);
		image.add(balanceenquiry);
		
		exit = new JButton("Exit");
		exit.setBounds(258, 324, 110, 13);
		exit.setFont(new Font("Raleway", Font.BOLD, 10));
		exit.addActionListener(this);
		image.add(exit);
		
		
		setSize(600, 600);
		setLocation(350, 100);
		setUndecorated(true);
		setVisible(true);
	}
	
    public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==exit) {
			System.exit(0);
			
		}else if(ae.getSource() == deposit) {
			setVisible(false);
			new Deposit(pinnumber).setVisible(true);			
		}
		else if(ae.getSource()== withdrawl) {
			setVisible(false);
			new Withdrawl(pinnumber).setVisible(true);
		}else if (ae.getSource()==fastcash) {
			setVisible(false);
			new FastCash(pinnumber).setVisible(true);
		}else if (ae.getSource()== pinchange) {
			setVisible(false);
			new PinChange(pinnumber).setVisible(true);
		}else if (ae.getSource()== balanceenquiry) {
			setVisible(false);
			new BalanceEnquiry(pinnumber).setVisible(true);
		}else if (ae.getSource()== ministatement) {
			new MiniStatement(pinnumber).setVisible(true);
		}
			}

	public static void main(String[] args) {
		new Transactions("");

	}	
}