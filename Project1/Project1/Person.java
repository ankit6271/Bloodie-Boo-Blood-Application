package Project1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.border.LineBorder;

public class Person extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String texttodonor=null;
	String s=null;
	Net n;
	int actionOn;
	String personId=null;
	String ip=null;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel_3;
	JLabel l2=new JLabel();
	
	public Person() {
		JLabel lr = new JLabel(new ImageIcon("Project1\\brave1.png"));
        lr.setBounds(0, 0, 700, 450);
        getContentPane().add(lr);
        
		setForeground(Color.LIGHT_GRAY);
		setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\algorithm\\Project1\\Project1\\Blood.png"));
//		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\algorithm\\Project1\\Project1\\Blood.png"));
//		setIconImage(Toolkit.getDefaultToolkit().getImage(Person.class.getResource("E:/algorithm/Project1/Project1/Blood.png?")));
		setTitle("Chat\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 1000);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new LineBorder(Color.RED, 3));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setBounds(187, 33, 522, 47);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub	
				personId=textField.getText();
			}		
		});
		
		JLabel lblNewLabel = new JLabel("ID of Person");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(28, 31, 147, 44);
		contentPane.add(lblNewLabel);

		l2.setFont(new Font("Aroma", Font.BOLD, 15));
		l2.setForeground(Color.RED);
		l2.setBounds(472, 115, 97, 50);
		contentPane.add(l2);
		
		JButton btnNewButton = new JButton("Enter\r\n");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBounds(612, 107, 97, 25);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				 try {
					 
					 DataToGetIpAdd add=new DataToGetIpAdd (personId);
					 ip=add.getIp();
					 n=new Net(ip);
					 l2.setText("Connected To Donor with IpAddress="+ip);
				 } 
				 catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				 }				
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(706, 181, 2, 2);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel_1 = new JLabel("You");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(28, 200, 70, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Donor\r\n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(455, 200, 110, 39);
		contentPane.add(lblNewLabel_2);
		
		JLabel l=new JLabel();
		l.setFont(new Font("Aroma", Font.BOLD, 17));
		l.setForeground(Color.RED);
		l.setBounds(45, 892, 100, 39);
		contentPane.add(l);
		
		textField_1 = new JTextField();
		textField_1.setBounds(12, 248, 339, 47);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				texttodonor=textField_1.getText();
				textField_1.setActionCommand("1");
				ActionEvent e=(ActionEvent) textField_1.getAction();
				actionOn=Integer.parseInt(e.getActionCommand());
			}
		});
		
		textField_2 = new JTextField();
		textField_2.setBounds(405, 311, 339, 53);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(12, 379, 339, 53);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		textField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				texttodonor=textField_3.getText();
				textField_3.setActionCommand("3");
				ActionEvent e=(ActionEvent) textField_3.getAction();
				actionOn=Integer.parseInt(e.getActionCommand());
			}
			
		});
		
		textField_4 = new JTextField();
		textField_4.setBounds(405, 446, 339, 58);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(12, 527, 339, 58);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		textField_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				// TODO Auto-generated method stub
				texttodonor=textField_5.getText();
				textField_5.setActionCommand("5");
				ActionEvent e=(ActionEvent) textField_5.getAction();
				actionOn=Integer.parseInt(e.getActionCommand());
			}
		});
		
		textField_6 = new JTextField();
		textField_6.setBounds(405, 600, 339, 58);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(12, 687, 339, 53);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		textField_7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				texttodonor=textField_7.getText();
				textField_7.setActionCommand("7");
				ActionEvent e=(ActionEvent) textField_7.getAction();
				actionOn=Integer.parseInt(e.getActionCommand());
			}
		});
		
		textField_8 = new JTextField();
		textField_8.setBounds(405, 759, 339, 53);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		btnNewButton_1 = new JButton("Send");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		btnNewButton_1.setBounds(254, 862, 97, 25);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					s=n.toSend(texttodonor);
					if(s.equals("Stop")) {
						n.connectionClose();
					}
					else {
						switch(actionOn) {
						case 1:	
							System.out.println(s);
							textField_2.setText(s);
							textField_2.setText(s);
							textField_1.setEditable(false);
							break;
						case 3:	
							textField_4.setText(s);
							textField_3.setEditable(false);
							break;
						case 5:	
							textField_6.setText(s);
							textField_5.setEditable(false);
							break;
						case 7:	
							textField_8.setText(s);
							textField_7.setEditable(false);
							break;
						}	
					}
				} 
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		btnNewButton_2 = new JButton("Stop");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		btnNewButton_2.setBounds(42, 862, 97, 25);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String stop=(String) e.getSource();
				try {
					s=n.toSend(stop);
					l.setText("Stopped");
				} 
				catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		lblNewLabel_3 = new JLabel("@Bloodie Blu");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_3.setBounds(639, 915, 131, 38);
		contentPane.add(lblNewLabel_3);

		contentPane.add(textField_2);
		setVisible(true);
	}
}

