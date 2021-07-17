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

public class MemberReceipt extends JFrame {

	private JPanel contentPane;
	private int id;
	private String firstName;
	private String lastName;
	private int age;
	private String contactNo;
	private String building;
	private String street;
	private String sector;
	private String city;
	private String packageName;
	private String packageAmount;
	private String startDate;
	private String planName;
	private String planDuration;
	private int batchId;
	private String trainer;
	private String branchName;
		
	TextArea textArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberReceipt frame = new MemberReceipt(1001);
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
	
	public MemberReceipt() {
		
	}
	public MemberReceipt(int id) {
		this.id=id;
		addWindowListener(new WindowAdapter() {
			
			
			@Override
			public void windowOpened(WindowEvent e) {
				setText(id);
				
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
				
				Member m1=new Member();
				m1.setVisible(true);
				dispose();
			}
		});
		
		btnBack.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		btnBack.setBounds(56, 425, 110, 31);
		btnBack.setBackground(Color.LIGHT_GRAY);
		contentPane.add(btnBack);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		btnPrint.setBounds(504, 429, 110, 31);
		btnPrint.setBackground(Color.LIGHT_GRAY);
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
   
        ResultSet rs=stmt.executeQuery("select * from plan join (select * from member,person where person.id=member.member_id) using (plan_id) join membership using (member_id) join package using (package_id) join address using(building) join batch using(batch_id) join branch using(branch_Id) where member_id='"+id+"'");
        while(rs.next()) {
        	id=rs.getInt("Member_id");
        	firstName=rs.getString("First_Name");
        	lastName=rs.getString("Last_Name");
        	age=rs.getInt("Age");
        	contactNo=rs.getString("Contact");
        	building=rs.getString("Building");
        	street=rs.getString("Street");
        	sector=rs.getString("Sector");
        	city=rs.getString("City");
        	packageName=rs.getString("Package_Name");
        	packageAmount=rs.getString("Price");
        	startDate=(rs.getDate("Start_Date")).toString();
        	planName=rs.getString("Plan_Name");
        	planDuration=rs.getString("Duration");
        	packageAmount=rs.getString("Price");
        	batchId=rs.getInt("Batch_Id");
        	branchName=rs.getString("Branch_Name");
        }
		
		}
		catch(Exception e) {System.out.println(e);}
		
		this.id=id;
		textArea.setText("\t\r\n***********************************************************************************************\r\n\t\t\t\t\tReceipt\r\n************************************************************************************************");
		textArea.setText(textArea.getText()+"\n\n\n\tMember Details: ");
		textArea.setText(textArea.getText()+"\n\n\tMember ID: "+id);
		textArea.setText(textArea.getText()+"\n\tFirst Name: "+ firstName);
		textArea.setText(textArea.getText()+"\t\tLast Name: "+ lastName);
		textArea.setText(textArea.getText()+"\n\tAge: "+ age);
		textArea.setText(textArea.getText()+"\t\tContact No.: "+ contactNo);
		textArea.setText(textArea.getText()+"\n\n\tAddress Details:");
		textArea.setText(textArea.getText()+"\n\tBuilding: "+ building);
		textArea.setText(textArea.getText()+"\t\tStreet: "+ street);
		textArea.setText(textArea.getText()+"\n\tSector: "+ sector);
		textArea.setText(textArea.getText()+"\t\tCity: "+ city);
		textArea.setText(textArea.getText()+"\n\n\tPlan Name: "+ planName);
		textArea.setText(textArea.getText()+"\t\tDuration: "+ planDuration);
		textArea.setText(textArea.getText()+"\n\n\tPackage Name: "+ packageName);
		textArea.setText(textArea.getText()+"\t\tPrice: "+packageAmount);
		textArea.setText(textArea.getText()+"\t\tDate: "+startDate);
		textArea.setText(textArea.getText()+"\n\n\tBatch Id: "+batchId);
		textArea.setText(textArea.getText()+"\n\tBranch: "+branchName);
		textArea.setText(textArea.getText()+"");
	
		
		
		
		
	}

}
