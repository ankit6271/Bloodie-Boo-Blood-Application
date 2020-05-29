package Project1;
import java.awt.*;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.JFrame.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
public class LogIn {
    public String password=null;
    public String text=null;
    public String checkloginid="";
    public String checkpassword="";

    public LogIn() {
        JFrame f = new JFrame("Anny");
        JLabel lr = new JLabel(new ImageIcon("Project1\\brave1.png"));
        lr.setBounds(0, 0, 700, 450);

        JTextField j = new JTextField();
        j.setBounds(400, 350, 180, 50);
        j.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text = j.getText();
                System.out.println(text);
            }
        });

        JPasswordField p = new JPasswordField();
        p.setBounds(400, 430, 180, 50);
        p.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                password = String.valueOf(p.getPassword());
                System.out.println(password);
            }
        });
        
        JLabel l1 = new JLabel("LOGIN");
        l1.setFont(new Font("Courier", Font.BOLD, 19));
        l1.setBounds(200, 350, 180, 50);

        JLabel l2 = new JLabel("PASSWORD");
        l2.setFont(new Font("Courier", Font.BOLD, 19));
        l2.setBounds(200, 430, 180, 50);

        JLabel l3 = new JLabel();
        l3.setForeground(Color.BLACK);
        l3.setBounds(260, 485, 220, 50);
        l3.setFont(new Font("Arial Black", Font.PLAIN, 14));

        JLabel l4=new JLabel();
        l4.setForeground(Color.BLACK);
        l4.setBounds(30,2,180,50);
        
        JLabel l5=new JLabel("@BLOODIE BOO");
        l5.setForeground(Color.BLACK);
        l5.setBounds(540,800,180,50);
        l5.setFont(new Font("Courier", Font.BOLD, 15));
        

        JButton b = new JButton("LOGIN");
        b.setBackground(new Color(255, 87, 34));
        b.setBounds(250, 530, 200, 50);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (password==null||text==null) {
                    l3.setText("ENTRIES MISSING..");
                }
                else if (password!=null && text != null) {
                    l3.setText("LOGGING IN.........");
                    try {
                        Data d = new Data(text);
                        checkloginid=d.getLoginid();
                        checkpassword=d.getPassword();
                        if(checkloginid.equals(text) && checkpassword.equals(password)){
                            l4.setText("ACCESSEED");

                            //new window open
                            new LogInAfter();


                        }
                        else{
                            System.out.print("INVALID ID PASSWORD");
                            l4.setText("INVALID ACCESS");
                        }
                    } 
                    catch (Exception e1) {
                        System.out.println("may be connection not established");
                    }
                }
            }
        });

        JButton s=new JButton("SIGN UP");
        s.setBorder(new TitledBorder("DON'T HAVE A ACCOUNT"));
        s.setBackground(new Color(255,87,34));
        s.setBounds(250, 630,200,50);
        s.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	new SignUp();

            }
        });

        f.add(j);
        f.add(p);
        f.add(l1);
        f.add(lr);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(l5);
        f.add(b);
        f.add(s);
        f.setSize(700,900);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.setIconImage(Toolkit.getDefaultToolkit().getImage(Person.class.getResource("/Project1/Blood.png")));
        f.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\algorithm\\Project1\\Project1\\Blood.png"));
    }
}