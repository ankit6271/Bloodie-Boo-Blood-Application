
package Project1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollBar;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DonorChat extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String get=null;
	DataOutputStream dos;
	DataInputStream dis;
	JButton btnNewButton;
	private JPanel contentPane;
	public JTextField textField;
	public JTextArea textArea ;
	public JButton btnNewButton_1;
	public DonorChat() {
		setTitle("Donor Chat");
//		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\algorithm\\Project1\\Project1\\Blood.png"));
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\algorithm\\Project1\\Project1\\Blood.png"));
		setForeground(Color.RED);
		setFont(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textArea= new JTextArea();
		textArea.setFont(new Font("Tahoma", Font.BOLD, 17));
		textArea.setBounds(31, 222, 707, 522);
		contentPane.add(textArea);
		textArea.setEditable(true);
		
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 17));
		textField.setBounds(31, 793, 510, 105);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("Send\r\n");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(602, 820, 125, 47);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String st="";
				st=textField.getText();
				try {
					dos.writeUTF(st);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.print("excption in btnnewbutton");
				}
				textArea.setText("you"+st);
			}
			
		});
		
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(717, 222, 21, 522);
		contentPane.add(scrollBar);
		
		btnNewButton_1 = new JButton("CONNECT TO SERVER");
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 29));
		btnNewButton_1.setBounds(31, 60, 707, 86);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					ServerSocket ss=new ServerSocket(9999);
				    Socket snSocket=ss.accept();
				    dos=new DataOutputStream(snSocket.getOutputStream());
				    dis=new DataInputStream(snSocket.getInputStream());
				    String s1="";
					while(!s1.equals("stop")){
				        s1=dis.readUTF();
					    textArea.append(s1);
					    System.out.println(s1);
				        }
//					textArea.setText("Client Want to Stop:"+s1);
				
				    ss.close();
				}
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		setVisible(true);
	
}}
	
