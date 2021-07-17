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
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class AddSupplement extends JFrame {

	private JPanel contentPane;
	private JTextField suppIdTextField;
	private JTextField supNameTextField;
	private JTextField priceTextField;
	private JTextField manufacturerTextField;
	private JTextField quantityTextField;
	private JTextField adminIdTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSupplement frame = new AddSupplement();
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
	public AddSupplement() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setLayout(null);
		
		suppIdTextField = new JTextField();
		suppIdTextField.setBounds(183, 87, 115, 20);
		contentPane.add(suppIdTextField);
		suppIdTextField.setColumns(10);
		
		JLabel lblId = new JLabel("Supplement Id:");
		lblId.setForeground(Color.LIGHT_GRAY);
		lblId.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblId.setBounds(45, 90, 115, 14);
		contentPane.add(lblId);
		
		JLabel lblSupplementName = new JLabel("Supplement Name:");
		lblSupplementName.setForeground(Color.LIGHT_GRAY);
		lblSupplementName.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblSupplementName.setBounds(45, 138, 138, 14);
		contentPane.add(lblSupplementName);
		
		supNameTextField = new JTextField();
		supNameTextField.setColumns(10);
		supNameTextField.setBounds(183, 135, 115, 20);
		contentPane.add(supNameTextField);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setForeground(Color.LIGHT_GRAY);
		lblPrice.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblPrice.setBounds(45, 188, 138, 14);
		contentPane.add(lblPrice);
		
		priceTextField = new JTextField();
		priceTextField.setColumns(10);
		priceTextField.setBounds(183, 185, 115, 20);
		contentPane.add(priceTextField);
		
		JLabel lblManufacturer = new JLabel("Manufacturer:");
		lblManufacturer.setForeground(Color.LIGHT_GRAY);
		lblManufacturer.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblManufacturer.setBounds(45, 238, 138, 14);
		contentPane.add(lblManufacturer);
		
		manufacturerTextField = new JTextField();
		manufacturerTextField.setColumns(10);
		manufacturerTextField.setBounds(183, 235, 115, 20);
		contentPane.add(manufacturerTextField);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setForeground(Color.LIGHT_GRAY);
		lblQuantity.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblQuantity.setBounds(45, 295, 138, 14);
		contentPane.add(lblQuantity);
		
		quantityTextField = new JTextField();
		quantityTextField.setColumns(10);
		quantityTextField.setBounds(183, 292, 115, 20);
		contentPane.add(quantityTextField);
		
		JLabel lblAdminId = new JLabel("Admin Id:");
		lblAdminId.setForeground(Color.LIGHT_GRAY);
		lblAdminId.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblAdminId.setBounds(45, 351, 138, 14);
		contentPane.add(lblAdminId);
		
		adminIdTextField = new JTextField();
		adminIdTextField.setColumns(10);
		adminIdTextField.setBounds(183, 348, 115, 20);
		contentPane.add(adminIdTextField);
		
		JButton addButton = new JButton("Add");
		addButton.setBackground(Color.LIGHT_GRAY);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						addSupplement();
						 
			            Supplement s1=new Supplement();
			            s1.setVisible(true);
			            dispose();
			           
	
			}
		});
		addButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		addButton.setBounds(286, 424, 105, 34);
		contentPane.add(addButton);
		
		JLabel lblAddSupplement = new JLabel("Add Supplement");
		lblAddSupplement.setForeground(Color.LIGHT_GRAY);
		lblAddSupplement.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		lblAddSupplement.setBounds(243, 11, 183, 34);
		contentPane.add(lblAddSupplement);
		
		JButton backButton = new JButton("Back");
		backButton.setBackground(Color.LIGHT_GRAY);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				 Supplement s1=new Supplement();
		         s1.setVisible(true);
		         dispose();
		           
				
			}
		});
		backButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		backButton.setBounds(45, 424, 105, 34);
		contentPane.add(backButton);
		
		JLabel picture = new JLabel("");
		picture.setBounds(0, 0, 684, 492);
		contentPane.add(picture);
		Image image =new ImageIcon(this.getClass().getResource("/All1.jpg")).getImage();
		picture.setIcon(new ImageIcon(image));
		
		
				
	}
	
	public void addSupplement() {

		try{
            //create  the connection object
            Connection con=DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521:orcl","gms","gms");
 
            
            String supplementSql="insert into supplement(supplement_id, supplement_name, price, manufacturer, quantity, admin_id) values(?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt=con.prepareStatement(supplementSql);
            pstmt.setInt(1, Integer.parseInt(suppIdTextField.getText()));
            pstmt.setString(2, supNameTextField.getText());
            pstmt.setInt(3, Integer.parseInt(priceTextField.getText()));
            pstmt.setString(4, manufacturerTextField.getText());
            pstmt.setInt(5, Integer.parseInt(quantityTextField.getText()));
            pstmt.setInt(6, Integer.parseInt(adminIdTextField.getText()));
            try {
            int upd=pstmt.executeUpdate();
            if (upd==1)
            	JOptionPane.showMessageDialog(null, "Supplement Added Successfully");
            
            }catch(Exception e3) {JOptionPane.showMessageDialog(null, "Error Occured");}
           
            con.close();
            
        }
	 	catch(Exception e1){JOptionPane.showMessageDialog(null, e1); }
	

	}

}
