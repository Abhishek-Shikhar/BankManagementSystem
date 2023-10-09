package max;

import java.awt.*;
 
import java.awt.event.*;
import javax.swing.*;

public class PinChange extends JFrame implements ActionListener{
	
	JPasswordField pin, repin;
	JButton change, back;
	String pinnumber;
	
	PinChange(String pinnumber){
		this.pinnumber = pinnumber;
		setLayout(null);
					
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atmimages.jpg"));
		Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 600, 600);
		add(image);
		
		JLabel text = new JLabel("Change Your Pin");
		text.setForeground(Color.BLACK);
		text.setFont(new Font("Raleway",Font.BOLD, 12));
		text.setBounds(200, 210, 200, 15);
		image.add(text);
		
		JLabel pintext = new JLabel("New Pin:");
		pintext.setForeground(Color.BLACK);
		pintext.setFont(new Font("Raleway",Font.BOLD, 10));
		pintext.setBounds(145, 230, 100, 15);
		image.add(pintext);
		
		pin = new JPasswordField();
		pin.setFont(new Font("Raleway",Font.BOLD, 12));
		pin.setBounds(240, 230, 120, 15);
		image.add(pin);
		
		JLabel repintext = new JLabel("Re-Enter New Pin:");
		repintext.setForeground(Color.BLACK);
		repintext.setFont(new Font("Raleway",Font.BOLD, 10));
		repintext.setBounds(145, 250, 100, 15);
		image.add(repintext);
		
		repin = new JPasswordField();
		repin.setFont(new Font("Raleway",Font.BOLD, 10));
		repin.setBounds(240, 250, 120, 15);
		image.add(repin);
		
		change = new JButton("CHANGE");
		change.setBounds(258, 307, 110, 13);
		change.setFont(new Font("Raleway",Font.BOLD, 10));
		change.addActionListener(this);
		image.add(change);
		
		back = new JButton("BACK");
		back.setBounds(258, 324, 110, 13);
		back.setFont(new Font("Raleway",Font.BOLD, 10));
		back.addActionListener(this);
		image.add(back);
		
		
		setSize(600, 550);
		setLocation(350, 40);
		setUndecorated(true);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == change) {
			try {
				String npin = pin.getText();
				String rpin = repin.getText();
			
				if(!npin.equals(rpin)) {
					JOptionPane.showMessageDialog(null, "Enterd pin does not matched");
					return;
				}
				if(npin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter new PIN");
					return;					
				} 
				if(rpin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
					return;	
				}
				
				Conn conn = new Conn();
				String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
				String query2 = "update login set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"'";
				String query3 = "update signupthree set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"'";
				
				conn.s.executeUpdate(query1);
				conn.s.executeUpdate(query2);
				conn.s.executeUpdate(query3);
			
				JOptionPane.showMessageDialog(null, "PIN changed successfully");
				setVisible(false);
				new Transactions(rpin).setVisible(true);
				
			}catch(Exception e) {
				System.out.println(e);
			}		
		}else {
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}		
	}
	public static void main(String args[]) {
		new PinChange("").setVisible(true);
	}
}
