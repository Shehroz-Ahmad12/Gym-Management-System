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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UpdateEquipment extends JFrame {

	private JPanel contentPane;
	
	private JLabel lblManufacturer_1;
	private JComboBox statusComboBox;
	private JLabel lblBranchId_1;
	private JLabel lblStatus_1;
	private JLabel lblPrice_1;
	private JLabel lblEquipmentId_1;
	private JLabel lblEquipmentName_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateEquipment frame = new UpdateEquipment(1);
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
	public UpdateEquipment(int id) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				showDetails(id);
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setLayout(null);
		
		JLabel lblEquipmentName = new JLabel("Equipment Name:");
		lblEquipmentName.setForeground(Color.LIGHT_GRAY);
		lblEquipmentName.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblEquipmentName.setBounds(45, 113, 138, 14);
		contentPane.add(lblEquipmentName);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setForeground(Color.LIGHT_GRAY);
		lblPrice.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblPrice.setBounds(45, 172, 138, 14);
		contentPane.add(lblPrice);
		
		JLabel lblManufacturer = new JLabel("Manufacturer:");
		lblManufacturer.setForeground(Color.LIGHT_GRAY);
		lblManufacturer.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblManufacturer.setBounds(45, 227, 138, 14);
		contentPane.add(lblManufacturer);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setForeground(Color.LIGHT_GRAY);
		lblStatus.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblStatus.setBounds(45, 286, 107, 14);
		contentPane.add(lblStatus);
		
		JLabel lblBranchId = new JLabel("Branch Id:");
		lblBranchId.setForeground(Color.LIGHT_GRAY);
		lblBranchId.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblBranchId.setBounds(45, 343, 138, 14);
		contentPane.add(lblBranchId);
		
		JLabel lblUpdateEquipment = new JLabel("Update Branch Equipment Status");
		lblUpdateEquipment.setForeground(Color.LIGHT_GRAY);
		lblUpdateEquipment.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		lblUpdateEquipment.setBounds(162, 11, 395, 40);
		contentPane.add(lblUpdateEquipment);
		Image image =new ImageIcon(this.getClass().getResource("/All1.jpg")).getImage();
		
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				updateStatus();
		
				
				
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
		
		JLabel lblNewStatus = new JLabel("New Status:");
		lblNewStatus.setForeground(Color.LIGHT_GRAY);
		lblNewStatus.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblNewStatus.setBounds(374, 290, 107, 14);
		contentPane.add(lblNewStatus);
		
		statusComboBox = new JComboBox();
		statusComboBox.setModel(new DefaultComboBoxModel(new String[] {"Active", "Out of Order"}));
		statusComboBox.setBounds(512, 286, 115, 22);
		contentPane.add(statusComboBox);
		
		lblBranchId_1 = new JLabel("?");
		lblBranchId_1.setForeground(Color.LIGHT_GRAY);
		lblBranchId_1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblBranchId_1.setBounds(193, 343, 138, 14);
		contentPane.add(lblBranchId_1);
		
		lblStatus_1 = new JLabel("?");
		lblStatus_1.setForeground(Color.LIGHT_GRAY);
		lblStatus_1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblStatus_1.setBounds(194, 286, 107, 14);
		contentPane.add(lblStatus_1);
		
		lblEquipmentName_1 = new JLabel("?");
		lblEquipmentName_1.setForeground(Color.LIGHT_GRAY);
		lblEquipmentName_1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblEquipmentName_1.setBounds(193, 113, 138, 14);
		contentPane.add(lblEquipmentName_1);
		
		lblPrice_1 = new JLabel("?");
		lblPrice_1.setForeground(Color.LIGHT_GRAY);
		lblPrice_1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblPrice_1.setBounds(193, 172, 138, 14);
		contentPane.add(lblPrice_1);
		
		lblManufacturer_1 = new JLabel("?");
		lblManufacturer_1.setForeground(Color.LIGHT_GRAY);
		lblManufacturer_1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblManufacturer_1.setBounds(193, 227, 138, 14);
		contentPane.add(lblManufacturer_1);
		
		JLabel lblEquipmentId = new JLabel("Equipment Id:");
		lblEquipmentId.setForeground(Color.LIGHT_GRAY);
		lblEquipmentId.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblEquipmentId.setBounds(45, 65, 115, 14);
		contentPane.add(lblEquipmentId);
		
		lblEquipmentId_1 = new JLabel("?");
		lblEquipmentId_1.setForeground(Color.LIGHT_GRAY);
		lblEquipmentId_1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblEquipmentId_1.setBounds(172, 62, 115, 14);
		contentPane.add(lblEquipmentId_1);
		
		
		JLabel picture = new JLabel("");
		picture.setBounds(0, 0, 684, 492);
		contentPane.add(picture);
		picture.setIcon(new ImageIcon(image));
		

	}
	
	
	public void showDetails(int eq_id) {
		try{
            //create  the connection object
            Connection con=DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521:orcl","gms","gms");
 
		Statement stmt=con.createStatement();

	    ResultSet rs=stmt.executeQuery("select * from gms.equipment where equipment_id="+eq_id);
	    while(rs.next()) {
	    	lblEquipmentId_1.setText(rs.getString(1));
	    	lblEquipmentName_1.setText(rs.getString(2));
	    	lblPrice_1.setText(rs.getString(3));
	    	lblManufacturer_1.setText(rs.getString(4));
	    	lblStatus_1.setText(rs.getString(5));
	    	lblBranchId_1.setText(rs.getString(6));
	    	
	    }con.close();
	}
		catch(Exception e){ System.out.println(e);}
		
		
	}
	
	public void updateStatus() {
		
		
		try{
            //create  the connection object
            Connection con=DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521:orcl","gms","gms");
 
            String equipmentSql="Update equipment set status=? where equipment_id='"+Integer.parseInt(lblEquipmentId_1.getText())+"'";
            PreparedStatement pstmt1=con.prepareStatement(equipmentSql);
            //
            pstmt1.setString(1, statusComboBox.getSelectedItem().toString());
            
            pstmt1.executeUpdate();
	    	
            
            con.close();
            Branch b1=new Branch();
            b1.setVisible(true);
            dispose();
            
        }
	 	catch(Exception e1){ System.out.println(e1);}
	

		
	}
}
