package Project1;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.JFrame.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
public class SignUp {
	String userid="";
	String emailid="";
	String password="";
	String newpassword="";
	
    public SignUp(){
        JFrame f =new JFrame("Anny");
        //f.setGlassPane(glassPane);
        JLabel lr=new JLabel(new ImageIcon("Project1\\brave1.png"));
        lr.setBounds(0,0,700,450);

        JTextField j1=new JTextField();
        j1.setBounds(400, 350, 180, 50);
        j1.addActionListener(new ActionListener(){
            public void actionPerformed( ActionEvent e){
               userid=j1.getText().toLowerCase();
               System.out.println(userid);
            }
        });
        JTextField j2=new JTextField();
        j2.setBounds(400, 430, 180, 50);
        j2.addActionListener(new ActionListener(){
            public void actionPerformed( ActionEvent e){
               emailid=j2.getText().toLowerCase();
               System.out.println(emailid);
            }
        });
        JTextField j3=new JTextField();
        j3.setBounds(400,510,180,50);
        j3.addActionListener(new ActionListener(){
            public void actionPerformed( ActionEvent e){
               password=j3.getText().toLowerCase();
               System.out.println(password);
            }
        });


        JTextField j4=new JTextField();
        j4.setBounds(400,590,180,50);
        j4.addActionListener(new ActionListener(){
            public void actionPerformed( ActionEvent e){
               newpassword=j4.getText().toLowerCase();
               System.out.println(newpassword);
            }
        });

        JLabel l1=new JLabel("USER ID");
        l1.setFont(new Font("Courier", Font.BOLD,17));
        l1.setBounds(200, 350, 180, 50);

        JLabel l2=new JLabel("EMAIL ID");
        l2.setFont(new Font("Courier", Font.BOLD,17));
        l2.setBounds(200, 430, 180, 50);
        
        JLabel l3=new JLabel("PASSWORD");
        l3.setFont(new Font("Courier", Font.BOLD,17));
        l3.setBounds(200,510,180,50);

        JLabel l4=new JLabel("RE-ENTER PASSWORD");
        l4.setFont(new Font("Courier", Font.BOLD,17));
        l4.setBounds(200,590,180,50);
        
        JLabel l5=new JLabel("@BLOODIE BOO");
        l5.setForeground(Color.BLACK);
        l5.setBounds(540,800,180,50);
        l5.setFont(new Font("Courier", Font.BOLD, 15));
        
        JLabel l6=new JLabel();
        l6.setForeground(Color.BLACK);
        l6.setBounds(30,2,220,50);
        

        JButton b=new JButton("SIGN UP");
        b.setBackground(new Color(255,87,34));
        b.setBounds(250, 670, 200, 50);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	if(password.equals(newpassword) && userid!=null && emailid!=null) {
					try {
						DataForSignup sn = new DataForSignup(userid, emailid, password);
						if(sn.getN()==1) {
							l6.setText("NOW LOGIN WITH REQUIRED FIELDS");
	            			System.out.println("DATA ENTERED SUCCESFULLY FOR SIGNUP");
	            		}
	            		else {
	            			l6.setText("Duplicate value entered");
	            			System.out.println("Duplicate value entered");
	            		}
					} 
					catch (Exception e1) {
						System.out.println(e1);
					}
            	}
            	else {
            		l6.setText("PASSWORD NOT MATCHED");
            	}
            }
        });

        JButton s=new JButton("LOG IN");
        s.setBorder(new TitledBorder("ALREADY A MEMBER"));
        s.setBackground(new Color(255,87,34));
        s.setBounds(250, 740,200,50);
        s.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	new LogIn();
            }
        });

        f.add(lr);
        f.add(j1);
        f.add(j2);
        f.add(j3);
        f.add(j4);
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(l5);
        f.add(l6);
        f.add(b);
        f.add(s);
        f.setSize(700,900);
        f.setLayout(null);
        f.setVisible(true);
        f.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\algorithm\\Project1\\Project1\\Blood.png"));
//        f.setIconImage(Toolkit.getDefaultToolkit().getImage(Person.class.getResource("E:/algorithm/Project1/Project1/Blood.png")));
    }
}