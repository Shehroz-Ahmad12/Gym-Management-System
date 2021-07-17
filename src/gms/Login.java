package gms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;
	public static int adminId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 418);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Username = new JLabel("Username:");
		Username.setForeground(new Color(204, 204, 204));
		Username.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		Username.setBounds(60, 186, 117, 34);
		contentPane.add(Username);
		
		JLabel Password = new JLabel("Password:");
		Password.setBackground(new Color(255, 255, 255));
		Password.setForeground(new Color(204, 204, 204));
		Password.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		Password.setBounds(60, 231, 106, 34);
		contentPane.add(Password);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(176, 239, 190, 20);
		contentPane.add(passwordField);
		
		
		usernameField = new JTextField();
		usernameField.setBounds(176, 194, 190, 20);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		JButton loginButton = new JButton("Login");
		loginButton.setBackground(Color.LIGHT_GRAY);
		loginButton.setForeground(Color.BLACK);
		loginButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				 try{
			          
			            //create  the connection object
			            Connection con=DriverManager.getConnection(
			            "jdbc:oracle:thin:@localhost:1521:orcl","gms","gms");
			 
			            String password=new String(passwordField.getPassword());
			            String sql= "Select * from admin where username='"+usernameField.getText()+"'and password='"+password+"'" ;
			            PreparedStatement ps = con.prepareStatement(sql);
			            ResultSet rs=ps.executeQuery();
			            if (rs.next()) {
			            	adminId=rs.getInt("admin_Id");
			            	System.out.println("Login Successfull");
			            	JOptionPane.showMessageDialog(null, "Login Succesfull");
			            	MainMenu mn=new MainMenu();
			            	mn.setVisible(true);
			            	dispose();
			            }else {
			            	JOptionPane.showMessageDialog(null, "Invalid Username and Password");
			            	
			            	System.out.println("Invalid Username and Password");
			            }
			            
			                     con.close();
			        }
				 	catch(Exception e1){ System.out.println(e1);}
			
			
			
			}
		});
		loginButton.setBounds(159, 306, 106, 34);
		contentPane.add(loginButton);
		
		JLabel AdminLogin = new JLabel("Admin Login");
		AdminLogin.setHorizontalAlignment(SwingConstants.CENTER);
		AdminLogin.setForeground(new Color(204, 204, 204));
		AdminLogin.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 18));
		AdminLogin.setBounds(123, 96, 179, 57);
		contentPane.add(AdminLogin);
		Image image =new ImageIcon(this.getClass().getResource("/Login123.jpg")).getImage();
		
		
		JLabel picture = new JLabel("");
		picture.setBounds(0, -26, 444, 430);
		contentPane.add(picture);
		picture.setIcon(new ImageIcon(image));
		

	}
}
