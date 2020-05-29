package Project1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JWindow;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class DataBaseAfterLogIn {
	String blood=null;
	String arrayfortabledata[][];
	String column[]= {"ID","Name","Contact number","City"};
	DataBaseAfterLogIn(String bloodgroup) throws Exception{
		blood=bloodgroup;
	 	JFrame frmDataEntries = new JFrame();
	 	frmDataEntries.setTitle("Data Entries");
      	JPanel panel = new JPanel();
      	panel.setBorder(BorderFactory.createTitledBorder( BorderFactory.createEtchedBorder(), "Blood Donor Details", TitledBorder.CENTER, TitledBorder.TOP));
      	panel.setBounds(20,20,740,910);
      	
		DataToGetDatabaseEntry d=new DataToGetDatabaseEntry(blood);
		arrayfortabledata=d.getArray();
		JTable x=new JTable(arrayfortabledata,column);
		x.setBounds(20,20,740,930);
		x.setBorder(new LineBorder(Color.RED,3));
		x.setRowHeight(100);
		
	    JTable table = new JTable(arrayfortabledata, column);
	    
	    JScrollPane scrollpane=new JScrollPane(table);
	    scrollpane.setViewportView(table);
	    scrollpane.setBounds(25, 13, 735, 668);
	    
	    JButton button = new JButton("WANT TO CHAT WITH SOMEONE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Person();
			}
		});
		button.setBounds(284, 780, 223, 50);
		button.setBorder(new LineBorder(Color.RED,2));
		frmDataEntries.getContentPane().add(scrollpane);
		frmDataEntries.getContentPane().add(button);
		frmDataEntries.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(740, 680, -706, 1);
		frmDataEntries.getContentPane().add(scrollPane);
		frmDataEntries.setBounds(0,0, 800, 1000);
		frmDataEntries.setVisible(true);
		frmDataEntries.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDataEntries.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\algorithm\\Project1\\Project1\\Blood.png"));
	}
}