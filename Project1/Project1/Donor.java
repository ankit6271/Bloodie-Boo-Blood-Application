package Project1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import Project2.DonorChat;
import Project2.Net;
public class Donor {
	String name=null;
	String contactnumber=null;
	String city=null;
	String bloodgroup=null;
	public Donor() {
		JFrame f = new JFrame("Anny");
        JLabel lr = new JLabel(new ImageIcon("Project1\\brave1.png"));
        lr.setBounds(0, 0, 700, 450);
        
        JTextField l5=new JTextField("              "+"Your blood can give a life to someone.");
        l5.setFont(new Font("Courier", Font.BOLD, 16));
        l5.setForeground(Color.BLACK);
        l5.setBounds(4,2,700,20);
        l5.setBorder(new LineBorder(Color.BLACK, 2));
        
        JTextField p1 = new JTextField();
        p1.setBounds(400, 350, 180, 50);
        p1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name = p1.getText();
                System.out.println(name);
            }
        });

        JTextField p2 = new JTextField();
        p2.setBounds(400, 430, 180, 50);
        p2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 contactnumber= p2.getText();
                System.out.println(contactnumber);
            }
        });
        
        JTextField p3 = new JTextField();
        p3.setBounds(400, 510, 180, 50);
        p3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 city= p3.getText();
                System.out.println(city);
            }
        });
        
        String a[]= {"A+","A-","B+","B-","O+","O-","AB+","AB-"};
        JComboBox<String> c=new JComboBox<String>(a);
        c.setBounds(400, 590, 200,50);
        c.setFont(new Font("Arial Black", Font.PLAIN, 15));
        c.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					bloodgroup=String.valueOf(c.getSelectedItem());
			}
        });
        
        JLabel l1 = new JLabel("Name");
        l1.setFont(new Font("Courier", Font.BOLD, 19));
        l1.setBounds(200, 350, 180, 50);

        JLabel l2 = new JLabel("Contact Number");
        l2.setFont(new Font("Courier", Font.BOLD, 19));
        l2.setBounds(200, 430, 180, 50);
        
        JLabel l7 = new JLabel("City");
        l7.setFont(new Font("Courier", Font.BOLD, 19));
        l7.setBounds(200, 510, 180, 50);
        
        JLabel l6 = new JLabel("Blood Group");
        l6.setFont(new Font("Courier", Font.BOLD, 19));
        l6.setBounds(200, 590, 180, 50);
        
        JLabel l3 = new JLabel();
        l3.setForeground(Color.BLACK);
        l3.setBounds(275, 705, 220, 50);
        l3.setFont(new Font("Arial Black", Font.PLAIN, 14));

        JLabel l4=new JLabel();
        l4.setForeground(Color.BLACK);
        l4.setBounds(30,20,180,400);

        JButton b = new JButton("ENTER");
        b.setBackground(new Color(255, 87, 34));
        b.setBounds(250, 670, 200, 50);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (city==null||contactnumber==null||name==null||bloodgroup==null) {
                    l3.setText("ENTRIES MISSING..");
                }
                else if (city!=null && contactnumber != null && name!=null && bloodgroup!=null) {
                    try {
                        Data2 d = new Data2(city,contactnumber ,name,bloodgroup);
                        if(d.getN()==1) {
                        	l5.setEnabled(false);
							l4.setText("DATA UPLODED THANKS FOR YOUR SUPPORT..."+"\n"+"You soon will be contacted by our team...");
	            			System.out.println("DATA ENTERED SUCCESFULLY FOR SIGNUP FOR DONORS");
	            		}
	            		else {
	            			l3.setText("Duplicate value entered");
	            			System.out.println("Duplicate value entered");
	            		}
					} 
                    catch (Exception e1) {
						System.out.println(e1);
					}
                }
            }
        });
        
        JButton b2 = new JButton("MY ENTRIES ALREADY EXIST");
        b2.setBackground(Color.RED);
        b2.setBounds(250, 750, 200, 50);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DonorChat();
            }
        });
        f.add(p1);
        f.add(p2);
        f.add(p3);
        f.add(c);
        f.add(b2);
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(l6);
        f.add(l7);
        f.add(lr);
        f.add(l5);
        f.add(b);
        f.setLayout(null);
        f.setVisible(true);
        f.setSize(700, 900);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\algorithm\\Project1\\Project1\\Blood.png"));
//        f.setIconImage(Toolkit.getDefaultToolkit().getImage(Person.class.getResource("/Project1/Blood.png")));
	}
}
