package Project1;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.JFrame.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
public class LogInAfter {
	String bloodgroup="";
	public LogInAfter() {
	        JFrame f = new JFrame("Main");
	        JLabel lr = new JLabel(new ImageIcon("Project1\\brave1.png"));
	        lr.setBounds(0, 20, 700, 450);
	        
	        JTextField l5=new JTextField("      "+"रक�?तदान की राह पर," + "निकला पूरा देश," + "सारे जग में भेज दो," +"भारत का सन�?देश");
	        l5.setFont(new Font("Courier", Font.BOLD, 18));
	        l5.setForeground(Color.BLACK);
	        l5.setBounds(4,2,700,30);
	        l5.setBorder(new LineBorder(Color.BLACK, 2));
	        
	        JLabel l1 = new JLabel("Blood YOU NEED BEING PROVIDED BY US");
	        l1.setFont(new Font("Courier", Font.BOLD, 22));
	        l1.setBounds(130, 460, 600, 50);
	        l1.setForeground(Color.BLACK);

	        JLabel l2 = new JLabel("Select Blood Group");
	        l2.setFont(new Font("Courier", Font.BOLD, 20));
	        l2.setBounds(100, 630, 380, 50);
	        
	        String a[]= {"A+","A-","B+","B-","O+","O-","AB+","AB-"};
	        JComboBox<String> c=new JComboBox<String>(a);
	        c.setBounds(460, 630, 200,50);
	        c.setFont(new Font("Arial Black", Font.PLAIN, 15));
	        c.addActionListener(new ActionListener() {
	        	@Override
				public void actionPerformed(ActionEvent e) {
	        			bloodgroup=String.valueOf(c.getSelectedItem());
	        			try {
							new DataBaseAfterLogIn(bloodgroup);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
	        });
	        
//	        JButton b=new JButton("CLICK TO GET DETAILS");
//	        b.setBounds(125,730,500,50);
//	        b.setBorder(new LineBorder(Color.ORANGE,3));
//	        b.addActionListener(new ActionListener() {
//	        	@Override
//				public void actionPerformed(ActionEvent e) {
//	        		if(bloodgroup!=null) {
//	        			try {
//							new DataBaseAfterLogIn(bloodgroup);
//						} 
//	        			catch (Exception e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
//	        		}	
//				}
//	        });
	        
	        JLabel l4=new JLabel("@BLOODIE BOO");
	        l4.setForeground(Color.BLACK);
	        l4.setBounds(650,900,180,50);
	        l4.setFont(new Font("Courier", Font.BOLD, 15));
	        
	        f.add(c);
	        f.add(lr);
	        f.add(l1);
	        f.add(lr);
	        f.add(l2);
	        f.add(l4);
	        f.add(l5);
//	        f.add(b);
	        f.setSize(800,1000);
	        f.setLayout(null);
	        f.setVisible(true);
	        f.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\algorithm\\Project1\\Project1\\Blood.png"));
//	        f.setIconImage(Toolkit.getDefaultToolkit().getImage(Person.class.getResource("E:/algorithm/Project1/Project1/Blood.png")));
	    }
}

