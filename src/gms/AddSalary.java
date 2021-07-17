package gms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class AddSalary extends JFrame {

	private JPanel contentPane;
	private JTextField amountTextField;
	private JTextField trainerIdTextField;
	private JDateChooser dateChooser;
	private JTextField salaryIdTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSalary frame = new AddSalary();
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
	public AddSalary() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 700, 520);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setBackground(new Color(51, 51, 51));
	contentPane.setLayout(null);
	JLabel lblSalaryId = new JLabel("ID:");
	lblSalaryId.setForeground(Color.LIGHT_GRAY);
	lblSalaryId.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
	lblSalaryId.setBounds(46, 89, 46, 14);
	contentPane.add(lblSalaryId);
	
	salaryIdTextField = new JTextField();
	salaryIdTextField.setBounds(137, 86, 120, 20);
	contentPane.add(salaryIdTextField);
	salaryIdTextField.setColumns(10);
	
	JLabel lblAddSalaryDetails = new JLabel("Add Salary Details");
	lblAddSalaryDetails.setForeground(Color.LIGHT_GRAY);
	lblAddSalaryDetails.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 18));
	lblAddSalaryDetails.setBounds(247, 26, 212, 14);
	contentPane.add(lblAddSalaryDetails);
	
	JLabel lblAmount = new JLabel("Amount(Rs):");
	lblAmount.setForeground(Color.LIGHT_GRAY);
	lblAmount.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
	lblAmount.setBounds(46, 146, 94, 14);
	contentPane.add(lblAmount);
	
	amountTextField = new JTextField();
	amountTextField.setColumns(10);
	amountTextField.setBounds(137, 143, 120, 20);
	contentPane.add(amountTextField);
	
	JLabel lblDate = new JLabel("Date:");
	lblDate.setForeground(Color.LIGHT_GRAY);
	lblDate.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
	lblDate.setBounds(46, 210, 46, 14);
	contentPane.add(lblDate);
	
	dateChooser = new JDateChooser();
	dateChooser.setBounds(137, 204, 120, 20);
	contentPane.add(dateChooser);
	
	
	JButton btnAdd = new JButton("Add");
	btnAdd.setBackground(Color.LIGHT_GRAY);
	btnAdd.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			addSalary();
			
					
		}
	});
	btnAdd.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
	btnAdd.setBounds(278, 365, 104, 35);
	contentPane.add(btnAdd);
	
	JButton btnBack = new JButton("Back");
	btnBack.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Salary s=new Salary();
			s.setVisible(true);
			dispose();
		}
	});
	btnBack.setBackground(Color.LIGHT_GRAY);
	btnBack.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
	btnBack.setBounds(62, 365, 104, 35);
	contentPane.add(btnBack);
	
	JLabel lblTrainerId = new JLabel("Trainer Id:");
	lblTrainerId.setForeground(Color.LIGHT_GRAY);
	lblTrainerId.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
	lblTrainerId.setBounds(46, 264, 120, 14);
	contentPane.add(lblTrainerId);
	
	trainerIdTextField = new JTextField();
	trainerIdTextField.setColumns(10);
	trainerIdTextField.setBounds(137, 261, 120, 20);
	contentPane.add(trainerIdTextField);
	Image image =new ImageIcon(this.getClass().getResource("/All1.jpg")).getImage();
	
	
	JLabel picture = new JLabel("");
	picture.setBounds(0, 0, 684, 492);
	contentPane.add(picture);
	picture.setIcon(new ImageIcon(image));
	
	
	}
	
	
	public void addSalary() {
		
		
		 DateFormat df=new SimpleDateFormat("dd-MM-YYYY");
         java.util.Date sDate = dateChooser.getDate();
		 String salaryDate=df.format(sDate);
		 System.out.println(salaryDate);
		
		try{
            //create  the connection object
            Connection con=DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521:orcl","gms","gms");
 
            
            
            
            String salarySql="insert into salary(salary_id, amount, salary_date, trainer_Id) values(?, ?, TO_DATE(?, 'DD-MM-YYYY'), ?)";
            PreparedStatement pstmt1=con.prepareStatement(salarySql);
            pstmt1.setInt(1, Integer.parseInt(salaryIdTextField.getText()));
            pstmt1.setInt(2, Integer.parseInt(amountTextField.getText()));
            pstmt1.setString(3, salaryDate);
            pstmt1.setInt(4, Integer.parseInt(trainerIdTextField.getText()));
            
            try {
            int upd=pstmt1.executeUpdate();
            
            if (upd==1) {
            	JOptionPane.showMessageDialog(null, "Row Input Successfully");
            	SalaryReceipt s=new SalaryReceipt(Integer.parseInt(salaryIdTextField.getText())); // Insert Salary Id
            	s.setVisible(true);
            	dispose();}
            
            }catch(Exception e3) {System.out.println(e3);
            	JOptionPane.showMessageDialog(null, e3);}
           
            con.close();
            
            
        }
	 	catch(Exception e1){ System.out.println(e1);}
	

		

	}
}
