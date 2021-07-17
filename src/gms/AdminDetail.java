package gms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AdminDetail extends JFrame {

	private JPanel contentPane;
	private static int adminID;
	private JTextField passwordTextField;
	private JLabel lblAdminId_1;
	private JLabel lblUserName1;
	private JLabel lblPassword1;
	private JLabel lblFirstName1;
	private JLabel lblLastName1;
	private JLabel lblBranchName1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminDetail frame = new AdminDetail();
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
	public AdminDetail() {
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				Login l=new Login();
				adminID=l.adminId;
				System.out.println(adminID);
				showDetails(adminID);
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setLayout(null);
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setForeground(Color.LIGHT_GRAY);
		lblUserName.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblUserName.setBounds(45, 138, 138, 14);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.LIGHT_GRAY);
		lblPassword.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblPassword.setBounds(45, 188, 138, 14);
		contentPane.add(lblPassword);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setForeground(Color.LIGHT_GRAY);
		lblFirstName.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblFirstName.setBounds(45, 238, 138, 14);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setForeground(Color.LIGHT_GRAY);
		lblLastName.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblLastName.setBounds(45, 295, 138, 14);
		contentPane.add(lblLastName);
		
		JLabel lblBranchName = new JLabel("Branch Name:");
		lblBranchName.setForeground(Color.LIGHT_GRAY);
		lblBranchName.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblBranchName.setBounds(45, 351, 138, 14);
		contentPane.add(lblBranchName);
		

		JButton updateButton = new JButton("Update");
		updateButton.setBackground(Color.LIGHT_GRAY);
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatePassword();
			
	
			}
		});
		updateButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		updateButton.setBounds(492, 243, 105, 34);
		contentPane.add(updateButton);
		
		JLabel lblUpdateSupplement = new JLabel("Admin Details");
		lblUpdateSupplement.setForeground(Color.LIGHT_GRAY);
		lblUpdateSupplement.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		lblUpdateSupplement.setBounds(243, 11, 236, 34);
		contentPane.add(lblUpdateSupplement);
		
		JButton backButton = new JButton("Back");
		backButton.setBackground(Color.LIGHT_GRAY);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainMenu m=new MainMenu();
				m.setVisible(true);
				dispose();
		           
				
			}
		});
		backButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		backButton.setBounds(45, 424, 105, 34);
		contentPane.add(backButton);
		Image image =new ImageIcon(this.getClass().getResource("/All1.jpg")).getImage();
		
		passwordTextField = new JTextField();
		passwordTextField.setColumns(10);
		passwordTextField.setBounds(530, 182, 115, 20);
		contentPane.add(passwordTextField);
		
		JLabel lblNewPassword = new JLabel("Change Password:");
		lblNewPassword.setForeground(Color.LIGHT_GRAY);
		lblNewPassword.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblNewPassword.setBounds(392, 185, 138, 14);
		contentPane.add(lblNewPassword);
		
		lblUserName1 = new JLabel("");
		lblUserName1.setForeground(Color.LIGHT_GRAY);
		lblUserName1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblUserName1.setBounds(174, 138, 138, 14);
		contentPane.add(lblUserName1);
		
		lblPassword1 = new JLabel("");
		lblPassword1.setForeground(Color.LIGHT_GRAY);
		lblPassword1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblPassword1.setBounds(174, 188, 138, 14);
		contentPane.add(lblPassword1);
		
		lblFirstName1 = new JLabel("");
		lblFirstName1.setForeground(Color.LIGHT_GRAY);
		lblFirstName1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblFirstName1.setBounds(174, 238, 138, 14);
		contentPane.add(lblFirstName1);
		
		lblLastName1 = new JLabel("");
		lblLastName1.setForeground(Color.LIGHT_GRAY);
		lblLastName1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblLastName1.setBounds(174, 295, 138, 14);
		contentPane.add(lblLastName1);
		
		lblBranchName1 = new JLabel("");
		lblBranchName1.setForeground(Color.LIGHT_GRAY);
		lblBranchName1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblBranchName1.setBounds(174, 351, 138, 14);
		contentPane.add(lblBranchName1);
		
		JLabel lblAdminId = new JLabel("Admin Id:");
		lblAdminId.setForeground(Color.LIGHT_GRAY);
		lblAdminId.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblAdminId.setBounds(45, 82, 138, 14);
		contentPane.add(lblAdminId);
		
		lblAdminId_1 = new JLabel("");
		lblAdminId_1.setForeground(Color.LIGHT_GRAY);
		lblAdminId_1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblAdminId_1.setBounds(174, 82, 138, 14);
		contentPane.add(lblAdminId_1);
		
		JLabel picture = new JLabel("");
		picture.setBounds(0, 0, 684, 492);
		contentPane.add(picture);
		picture.setIcon(new ImageIcon(image));
	}
	
	public void showDetails(int adminid) {
		
		try{
            //create  the connection object
            Connection con=DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521:orcl","gms","gms");
 
		Statement stmt=con.createStatement();

	    ResultSet rs=stmt.executeQuery("select admin_id, username,password,first_name, last_name,branch_name from branch join (select * from admin,person where person.id=admin.admin_id) using (admin_id) where admin_id='"+adminid+"'");
	    while(rs.next()) {
	    	lblAdminId_1.setText(rs.getString("Admin_Id"));
	    	lblUserName1.setText(rs.getString("Username"));
	    	lblPassword1.setText(rs.getString("Password"));
	    	lblFirstName1.setText(rs.getString("First_name"));
	    	lblLastName1.setText(rs.getString("Last_name"));
	    	lblBranchName1.setText(rs.getString("Branch_Name"));
	    	
	    }con.close();
	}
		catch(Exception e){ System.out.println(e);}
		

	}
	
	public void updatePassword(){
		
		
		try{
            Connection con=DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521:orcl","gms","gms");
 
            String passwordSql="Update admin set password=? where admin_id='"+Integer.parseInt(lblAdminId_1.getText())+"'";
            PreparedStatement pstmt1=con.prepareStatement(passwordSql);
            //
            pstmt1.setString(1, passwordTextField.getText());
            
            int upd=pstmt1.executeUpdate();
	    	if(upd==1){
	    		JOptionPane.showMessageDialog(null, "Password Changed Successfully");
	    	}
	    	else {
	    		JOptionPane.showMessageDialog(null, "Error Occured");	    		
	    	}
            
            con.close();      
        }
	 	catch(Exception e1){ JOptionPane.showMessageDialog(null, e1);}
		
	}
}
