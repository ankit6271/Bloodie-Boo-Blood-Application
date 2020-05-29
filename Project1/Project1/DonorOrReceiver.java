package Project1;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

public class DonorOrReceiver {
	public String s="";
	int x;
	public DonorOrReceiver() {
		JFrame f = new JFrame("Anny");
        JLabel lr = new JLabel(new ImageIcon("Project1\\brave1.png"));
        lr.setBounds(0, 0, 700, 450);
        
        JRadioButton b1=new JRadioButton("ARE YOU A DONOR?");
        b1.setFont(new  Font("Arial,",Font.BOLD,16));
        b1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e){
        		x=1;
        		s=b1.getText();
        		System.out.println(s);
        	}
        });
        		
        JRadioButton b2=new JRadioButton("ARE YOU A RECEIVER?");
        b2.setFont(new  Font("Arial",Font.BOLD,16));
        b2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e){
        		x=2;
        		s=b2.getText();
        		System.out.println(s);
        	}
        });

        ButtonGroup a=new ButtonGroup();
        a.add(b1);
        a.add(b2);
        
        JLabel l=new JLabel("          ");
        
        JButton b=new JButton("Selected");
        b.setBorder(new LineBorder(Color.RED,4));
        b.setPreferredSize(new Dimension(80,40));
        b.setBackground(Color.WHITE);
        b.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e){
        		if(x==1 ||x==2) {
	        		if(s.equals("ARE YOU A RECEIVER?")) {
	        			new LogIn();
	        		}
	        		else {
	        			new Donor();
	        		}
        		}
        		else {
        			l.setText("Value not selected");
        			l.setBorder(new LineBorder(Color.RED,4));
        			System.out.println("reselect donor or receiver");
        		}
        	}
        });
        
        JLabel l1=new JLabel("                ");
        f.add(lr);
        f.add(b1);
        f.add(l);
        f.add(b2);
        f.add(l1);
        f.add(b);
        f.setVisible(true);
        f.setLayout(new FlowLayout());
        f.setSize(700,900);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\algorithm\\Project1\\Project1\\Blood.png"));
//        f.setIconImage(Toolkit.getDefaultToolkit().getImage(Person.class.getResource("E:/algorithm/Project1/Project1/Blood.png")));
	}

}
