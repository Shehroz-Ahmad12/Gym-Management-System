package gms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SupplementReceipt extends JFrame {

	private JPanel contentPane;
	private int recordId;
	private int memberId;
	private String firstName;
	private String lastName;
	private int supplementId;
	private String supplementName;
	private int price;
	private String manufacturer;
	private String sellDate;
	TextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupplementReceipt frame = new SupplementReceipt(1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SupplementReceipt(int recordId) {
		this.recordId=recordId;
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				setText(recordId);
				
			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SellSupplement s1=new SellSupplement();
				s1.setVisible(true);
				dispose();
			}
		});
		
		btnBack.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		btnBack.setBounds(56, 425, 110, 31);
		contentPane.add(btnBack);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		btnPrint.setBounds(504, 429, 110, 31);
		contentPane.add(btnPrint);
		
		
		textArea = new TextArea();
		textArea.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		textArea.setBounds(69, 10, 545, 399);
		contentPane.add(textArea);
		
		JLabel picture = new JLabel("");
		picture.setBounds(0, 0, 684, 492);
		contentPane.add(picture);
		Image image =new ImageIcon(this.getClass().getResource("/All1.jpg")).getImage();
		picture.setIcon(new ImageIcon(image));
		
		
}

	
	

	public void setText(int id) {
		
		try {
			Connection con=DriverManager.getConnection(
		            "jdbc:oracle:thin:@localhost:1521:orcl","gms","gms");
		 
		Statement stmt=con.createStatement();
   
        ResultSet rs=stmt.executeQuery("select * from sale_records join (select * from person,member where member.member_Id=person.id) using (member_id) join supplement using (supplement_id) where record_id='"+recordId+"'");
        while(rs.next()) {
        	recordId=rs.getInt("Record_Id");
        	memberId=rs.getInt("Member_Id");
        	firstName=rs.getString("First_Name");
        	lastName=rs.getString("Last_Name");
        	supplementId=rs.getInt("Supplement_Id");
        	supplementName=rs.getString("Supplement_Name");
        	manufacturer=rs.getString("manufacturer");
        	price=rs.getInt("Price");
        	sellDate=rs.getString("sell_Date").toString();
        	
        
        }
		
		}
		catch(Exception e) {System.out.println(e);}
		
		textArea.setText("\t\r\n***********************************************************************************************\r\n\t\t\t\t\tReceipt\r\n************************************************************************************************");
		textArea.setText(textArea.getText()+"\n\n\n\tRecord Id: "+recordId);
		textArea.setText(textArea.getText()+"\n\tDate: "+sellDate);
		textArea.setText(textArea.getText()+"\n\n\n\tMember Details: ");
		textArea.setText(textArea.getText()+"\n\n\tMember ID: "+memberId);
		textArea.setText(textArea.getText()+"\n\tFirst Name: "+firstName);
		textArea.setText(textArea.getText()+"\n\tLast Name: "+lastName);

		textArea.setText(textArea.getText()+"\n\n\tSupplement Details: ");
		textArea.setText(textArea.getText()+"\n\tSupplement Id: "+supplementName);
		textArea.setText(textArea.getText()+"\n\tSupplement Name: "+supplementName);
		textArea.setText(textArea.getText()+"\n\tManufacturer: "+manufacturer);
		textArea.setText(textArea.getText()+"\n\tPrice: "+price);
		textArea.setText(textArea.getText()+"");
	
		
		
		
		
	}


}
