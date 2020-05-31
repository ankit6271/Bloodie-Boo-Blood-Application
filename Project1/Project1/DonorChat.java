package Project1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
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
import java.util.concurrent.ExecutionException;
//use of swing worker here is to apply threads in swing. as swing is not thread safe as a single thread is going
//on for the entire doc program so we need to extends swing worker class which makes it suitable to use threads in this 
//void in that is return type for swing worker overloaded method doinbackground and datainputstream is a parameter which is used in intermediate steps when execute is called to apply thread in that.

public class DonorChat extends SwingWorker<Void,DataInputStream>{ 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame f=new JFrame();
	String get=null;
	ServerSocket ss;
	String s1=null;
	Socket snSocket;
	DataOutputStream dos;
	DataInputStream dis;
	JButton btnNewButton;
	private JPanel contentPane;
	public JTextField textField;
	public JTextArea textArea ;
	public JButton btnNewButton_1;
	public DonorChat() {
		f.setTitle("Donor Chat");
//		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\algorithm\\Project1\\Project1\\Blood.png"));
		f.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\algorithm\\Project1\\Project1\\Blood.png"));
		f.setForeground(Color.RED);
		f.setFont(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(0, 0, 800, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		f.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textArea= new JTextArea();
		textArea.setFont(new Font("Tahoma", Font.BOLD, 20));
		textArea.setBounds(31, 222, 707, 522);
		textArea.setBorder(new LineBorder(Color.RED,2));
		contentPane.add(textArea);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 22));
		textField.setBounds(31, 793, 510, 105);
		textField.setBorder(new LineBorder(Color.RED, 2));
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("Send\r\n");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(602, 820, 125, 47);
		textArea.setBorder(new LineBorder(Color.RED,2));
		contentPane.add(btnNewButton);
			
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
			public void actionPerformed(ActionEvent arg0){
				// TODO Auto-generated method stub
				try {
					ss=new ServerSocket(9995);
				    Socket snSocket=ss.accept();
				    dos=new DataOutputStream(snSocket.getOutputStream());
				    dis=new DataInputStream(snSocket.getInputStream());	
				    execute();//this invokes overloaded method of SwingWorker class ie done and doinbackground
				    System.out.println("close");//this will be printed before doinbackground as doinback is working in background with a separate thread.
				} 
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		f.setVisible(true);
	}
	protected Void doInBackground() throws Exception {
		// TODO Auto-generated method stub
		while(true){
	        String s1=dis.readUTF();
	        System.out.println(s1);
	        if(s1.equals("stop")) {
		    	textArea.append("BLOOD Receiver Says:  "+s1);
		    	return null;
		    } 
		    else {
		    	textArea.append("BLOOD Receiver Says:  "+s1+"\n");
		    }
	        btnNewButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					String f=textField.getText();
					textArea.append("You:   "+f+"\n");
					try {
						dos.writeUTF(f);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
	}
	//this method is called after doinbackground() in background only
	@Override
	protected void done(){
		try {
			System.out.println("close socket");
			ss.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

