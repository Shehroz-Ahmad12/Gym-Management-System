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
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class AddEquipment extends JFrame {

	private JPanel contentPane;
	private JTextField equipIdTextField;
	private JTextField manufacturerTextField;
	private JTextField equipNameTextField;
	private JTextField priceTextField;
	private JComboBox statusComboBox;
	private JTextField branchIdTextField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEquipment frame = new AddEquipment();
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
	public AddEquipment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setLayout(null);
		
		equipIdTextField = new JTextField();
		equipIdTextField.setBounds(183, 87, 115, 20);
		contentPane.add(equipIdTextField);
		equipIdTextField.setColumns(10);
		
		JLabel lblEquipmentId = new JLabel("Equipment Id:");
		lblEquipmentId.setForeground(Color.LIGHT_GRAY);
		lblEquipmentId.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblEquipmentId.setBounds(45, 90, 115, 14);
		contentPane.add(lblEquipmentId);
		
		JLabel lblEquipmentName = new JLabel("Equipment Name:");
		lblEquipmentName.setForeground(Color.LIGHT_GRAY);
		lblEquipmentName.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblEquipmentName.setBounds(45, 138, 138, 14);
		contentPane.add(lblEquipmentName);
		
		equipNameTextField = new JTextField();
		equipNameTextField.setColumns(10);
		equipNameTextField.setBounds(183, 135, 115, 20);
		contentPane.add(equipNameTextField);
		
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
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setForeground(Color.LIGHT_GRAY);
		lblStatus.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblStatus.setBounds(45, 295, 138, 14);
		contentPane.add(lblStatus);
		
		statusComboBox = new JComboBox();
		statusComboBox.setBackground(Color.LIGHT_GRAY);
		statusComboBox.setModel(new DefaultComboBoxModel(new String[] {"Active", "Out of Order"}));
		statusComboBox.setBounds(183, 282, 115, 22);
		contentPane.add(statusComboBox);
		
		JLabel lblBranchId = new JLabel("Branch Id:");
		lblBranchId.setForeground(Color.LIGHT_GRAY);
		lblBranchId.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblBranchId.setBounds(45, 351, 138, 14);
		contentPane.add(lblBranchId);
		
		branchIdTextField = new JTextField();
		branchIdTextField.setColumns(10);
		branchIdTextField.setBounds(183, 348, 115, 20);
		contentPane.add(branchIdTextField);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				addEquipment();
	            Branch b1=new Branch();
	            b1.setVisible(true);
	            dispose();
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		btnNewButton.setBounds(261, 427, 115, 34);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(Color.LIGHT_GRAY);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Branch b1=new Branch();
	            b1.setVisible(true);
	            dispose();
	           
				
			}
		});
		btnBack.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		btnBack.setBounds(67, 427, 115, 34);
		contentPane.add(btnBack);
		
		JLabel lblAddEquipmentTo = new JLabel("Add Equipment to Branch");
		lblAddEquipmentTo.setForeground(Color.LIGHT_GRAY);
		lblAddEquipmentTo.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		lblAddEquipmentTo.setBounds(216, 11, 291, 40);
		contentPane.add(lblAddEquipmentTo);
		
		JLabel picture = new JLabel("");
		picture.setBounds(0, 0, 684, 492);
		contentPane.add(picture);
		Image image =new ImageIcon(this.getClass().getResource("/All1.jpg")).getImage();
		picture.setIcon(new ImageIcon(image));
		
		
	}
	
	public void addEquipment() {

		try{
            //create  the connection object
            Connection con=DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521:orcl","gms","gms");
 
            
            String equipmentSql="insert into equipment(equipment_id, equipment_name, price, manufacturer, status, branch_id) values(?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt1=con.prepareStatement(equipmentSql);
            pstmt1.setInt(1, Integer.parseInt(equipIdTextField.getText()));
            pstmt1.setString(2, equipNameTextField.getText());
            pstmt1.setInt(3, Integer.parseInt(priceTextField.getText()));
            pstmt1.setString(4, manufacturerTextField.getText());
            pstmt1.setString(5, statusComboBox.getSelectedItem().toString());
            pstmt1.setInt(6, Integer.parseInt(branchIdTextField.getText()));
	      
            int upd=pstmt1.executeUpdate();
            if (upd==1) {
            	JOptionPane.showMessageDialog(null, "Equipment Inserted Successfully");
            }
            else {
            	JOptionPane.showMessageDialog(null, "Error Occurred");
            }
                   
            con.close();   
        }
	 	catch(Exception e1){ System.out.println(e1);
	 		JOptionPane.showMessageDialog(null, e1);
	 	}
		
	}

}
