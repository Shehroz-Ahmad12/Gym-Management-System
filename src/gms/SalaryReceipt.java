package gms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SalaryReceipt extends JFrame {

	private JPanel contentPane;
	private int trainerId;
	private String firstName;
	private String lastName;
	private int age;
	private String contactNo;
	
	private int salaryId;
	private int amount;
	private String salaryDate;
	private String batchName;
	private String branchName;
		
	TextArea textArea;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalaryReceipt frame = new SalaryReceipt(1);
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
	
	public SalaryReceipt() {
		
	}
	public SalaryReceipt(int salaryId) {
		this.salaryId=salaryId;
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				setText(salaryId);
				
			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setLayout(null);
		
		textArea = new TextArea();
		textArea.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		textArea.setBounds(69, 10, 545, 399);
		contentPane.add(textArea);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Salary as=new Salary();
				as.setVisible(true);
				dispose();
			}
		});
		btnBack.setBackground(Color.LIGHT_GRAY);
		btnBack.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		btnBack.setBounds(56, 425, 110, 31);
		contentPane.add(btnBack);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.setBackground(Color.LIGHT_GRAY);
		btnPrint.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		btnPrint.setBounds(504, 429, 110, 31);
		contentPane.add(btnPrint);
		
		JLabel picture = new JLabel("");
		picture.setBounds(0, 0, 684, 492);
		contentPane.add(picture);
		Image image =new ImageIcon(this.getClass().getResource("/All1.jpg")).getImage();
		picture.setIcon(new ImageIcon(image));
		
		
}

	
	

	public void setText(int salaryId) {
		
		try {
			Connection con=DriverManager.getConnection(
		            "jdbc:oracle:thin:@localhost:1521:orcl","gms","gms");
		 
		Statement stmt=con.createStatement();
   
        ResultSet rs=stmt.executeQuery("select * from salary join (select * from trainer, person where person.id=trainer.trainer_id) using(trainer_id) where salary_id='"+salaryId+"'");
        while(rs.next()) {
        	//salaryId=rs.getInt("Salary_id");
        	firstName=rs.getString("First_Name");
        	lastName=rs.getString("Last_Name");
        	age=rs.getInt("Age");
        	contactNo=rs.getString("Contact");
        	trainerId=rs.getInt("trainer_Id");
        	amount=rs.getInt("Amount");
        	salaryDate=(rs.getString("Salary_Date")).toString();
        
        }
		
		}
		catch(Exception e) {System.out.println(e);}
		
		textArea.setText("\t\r\n***********************************************************************************************\r\n\t\t\t\t\tReceipt\r\n************************************************************************************************");
		
		
		textArea.setText(textArea.getText()+"\n\n\tSalary Details: ");
		textArea.setText(textArea.getText()+"\n\tSalary Id: "+salaryId);		
		textArea.setText(textArea.getText()+"\n\tAmount(Rs): "+amount);
		textArea.setText(textArea.getText()+"\n\tDate: "+salaryDate);
		
		textArea.setText(textArea.getText()+"\n\n\n\tTrainer Details: ");
		textArea.setText(textArea.getText()+"\n\n\tTrainer ID: "+trainerId);
		textArea.setText(textArea.getText()+"\n\tFirst Name: "+firstName);
		textArea.setText(textArea.getText()+"\t\tLast Name: "+lastName);
		textArea.setText(textArea.getText()+"\n\tAge: "+age);
		textArea.setText(textArea.getText()+"\t\tContact No.: "+contactNo);
		textArea.setText(textArea.getText()+"");
	
		
		
		
		
	}
}
