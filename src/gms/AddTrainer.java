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

public class AddTrainer extends JFrame {

	private JPanel contentPane;
	private JTextField expTextField;
	private JTextField batchIdTextField;
	private JTextField contactTextField;
	private JTextField ageTextField;
	private JTextField cityTextField;
	private JTextField sectorTextField;
	private JTextField streetTextField;
	private JTextField buildingTextField;
	private JTextField firstnameTextField;
	private JTextField lastnameTextField;
	private JTextField idTextField;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTrainer frame = new AddTrainer();
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
	public AddTrainer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setLayout(null);
		JLabel lblId = new JLabel("ID:");
		lblId.setForeground(Color.LIGHT_GRAY);
		lblId.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblId.setBounds(46, 89, 46, 14);
		contentPane.add(lblId);
		
		idTextField = new JTextField();
		idTextField.setBounds(137, 86, 120, 20);
		contentPane.add(idTextField);
		idTextField.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setForeground(Color.LIGHT_GRAY);
		lblFirstName.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblFirstName.setBounds(46, 132, 81, 14);
		contentPane.add(lblFirstName);
		
		firstnameTextField = new JTextField();
		firstnameTextField.setColumns(10);
		firstnameTextField.setBounds(137, 129, 120, 20);
		contentPane.add(firstnameTextField);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setForeground(Color.LIGHT_GRAY);
		lblLastName.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblLastName.setBounds(368, 132, 80, 14);
		contentPane.add(lblLastName);
		
		lastnameTextField = new JTextField();
		lastnameTextField.setColumns(10);
		lastnameTextField.setBounds(488, 129, 120, 20);
		contentPane.add(lastnameTextField);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setForeground(Color.LIGHT_GRAY);
		lblAge.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblAge.setBounds(46, 174, 81, 14);
		contentPane.add(lblAge);
		
		ageTextField = new JTextField();
		ageTextField.setColumns(10);
		ageTextField.setBounds(137, 171, 120, 20);
		contentPane.add(ageTextField);
		
		JLabel lblContactno = new JLabel("Contact No.:");
		lblContactno.setForeground(Color.LIGHT_GRAY);
		lblContactno.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblContactno.setBounds(368, 174, 97, 14);
		contentPane.add(lblContactno);
		

		JLabel lblAddressDetails = new JLabel("Address Details:");
		lblAddressDetails.setForeground(Color.LIGHT_GRAY);
		lblAddressDetails.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblAddressDetails.setBounds(46, 214, 120, 14);
		contentPane.add(lblAddressDetails);
		
		JLabel lblBuilding = new JLabel("Building:");
		lblBuilding.setForeground(Color.LIGHT_GRAY);
		lblBuilding.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblBuilding.setBounds(46, 242, 81, 14);
		contentPane.add(lblBuilding);
		
		buildingTextField = new JTextField();
		buildingTextField.setColumns(10);
		buildingTextField.setBounds(137, 239, 120, 20);
		contentPane.add(buildingTextField);
		
		JLabel lblSector = new JLabel("Sector:");
		lblSector.setForeground(Color.LIGHT_GRAY);
		lblSector.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblSector.setBounds(46, 281, 81, 14);
		contentPane.add(lblSector);
		
		sectorTextField = new JTextField();
		sectorTextField.setColumns(10);
		sectorTextField.setBounds(137, 278, 120, 20);
		contentPane.add(sectorTextField);
		
		JLabel lblStreet = new JLabel("Street:");
		lblStreet.setForeground(Color.LIGHT_GRAY);
		lblStreet.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblStreet.setBounds(368, 242, 81, 14);
		contentPane.add(lblStreet);
		
		streetTextField = new JTextField();
		streetTextField.setColumns(10);
		streetTextField.setBounds(488, 239, 120, 20);
		contentPane.add(streetTextField);
		
		cityTextField = new JTextField();
		cityTextField.setColumns(10);
		cityTextField.setBounds(488, 278, 120, 20);
		contentPane.add(cityTextField);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setForeground(Color.LIGHT_GRAY);
		lblCity.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblCity.setBounds(368, 281, 81, 14);
		contentPane.add(lblCity);
		
		JLabel lblTrainerDetails = new JLabel("Trainer Details:");
		lblTrainerDetails.setForeground(Color.LIGHT_GRAY);
		lblTrainerDetails.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblTrainerDetails.setBounds(46, 322, 120, 14);
		contentPane.add(lblTrainerDetails);
		
		contactTextField = new JTextField();
		contactTextField.setColumns(10);
		contactTextField.setBounds(488, 171, 120, 20);
		contentPane.add(contactTextField);
		
		JLabel lblExperience = new JLabel("Experience:");
		lblExperience.setForeground(Color.LIGHT_GRAY);
		lblExperience.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblExperience.setBounds(46, 363, 97, 14);
		contentPane.add(lblExperience);
		
		expTextField = new JTextField();
		expTextField.setColumns(10);
		expTextField.setBounds(137, 360, 120, 20);
		contentPane.add(expTextField);
		
		JLabel lblBatchId = new JLabel("Batch Id:");
		lblBatchId.setForeground(Color.LIGHT_GRAY);
		lblBatchId.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblBatchId.setBounds(368, 363, 81, 14);
		contentPane.add(lblBatchId);
		
		batchIdTextField = new JTextField();
		batchIdTextField.setColumns(10);
		batchIdTextField.setBounds(488, 357, 120, 20);
		contentPane.add(batchIdTextField);
		
		JLabel lblMain = new JLabel("Add Trainer");
		lblMain.setForeground(Color.LIGHT_GRAY);
		lblMain.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		lblMain.setBounds(273, 11, 175, 20);
		contentPane.add(lblMain);
		
		JButton addButton = new JButton("Add");
		addButton.setBackground(Color.LIGHT_GRAY);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
		            //create  the connection object
		            Connection con=DriverManager.getConnection(
		            "jdbc:oracle:thin:@localhost:1521:orcl","gms","gms");
		            
		            addAddress(con);
		            addPerson(con);
		            addTrainer(con);
		            con.close();
		     
		            Trainer t1=new Trainer();
		            t1.setVisible(true);
		            dispose();
		            
		        }
			 	catch(Exception e1){ System.out.println(e1);}
		
			}
		});
		addButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		addButton.setBounds(295, 424, 104, 34);
		contentPane.add(addButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(Color.LIGHT_GRAY);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Trainer t1=new Trainer();
	            t1.setVisible(true);
	            dispose();
	            
				
			}
		});
		btnBack.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		btnBack.setBounds(46, 424, 104, 34);
		contentPane.add(btnBack);
		
		JLabel picture = new JLabel("");
		picture.setBounds(0, 0, 684, 492);
		contentPane.add(picture);
		Image image =new ImageIcon(this.getClass().getResource("/All1.jpg")).getImage();
		picture.setIcon(new ImageIcon(image));
		
	}
	
	
	public void addAddress(Connection con) {
		
		try {
		String addressSql="insert into Address(building, street, sector, city) values(?, ?, ?, ?)";
      	PreparedStatement pstmt=con.prepareStatement(addressSql);
        pstmt.setString(1, buildingTextField.getText());
        pstmt.setString(2, streetTextField.getText());
        pstmt.setString(3, sectorTextField.getText());
        pstmt.setString(4, cityTextField.getText());
        int upd=pstmt.executeUpdate();
		if(upd==1) {
		}else {
			JOptionPane.showMessageDialog(null, "Error Occured in Address");
		}
		}catch(Exception e) {System.out.println(e);}
        
	}
	public void addPerson(Connection con) {
		
		try {
		String personSql="insert into Person(id, first_name, last_name, age, contact, building) values(?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt=con.prepareStatement(personSql);
        pstmt.setInt(1, Integer.parseInt(idTextField.getText()));
        pstmt.setString(2, firstnameTextField.getText());
        pstmt.setString(3, lastnameTextField.getText());
        pstmt.setInt(4, Integer.parseInt(ageTextField.getText()));
        pstmt.setString(5, contactTextField.getText());
        pstmt.setString(6, buildingTextField.getText());
        int upd=pstmt.executeUpdate();
		if (upd==1) {
		}
		else {
			JOptionPane.showMessageDialog(null, "Error Occured in Person Details");
		}
		
		
		}
	 	catch(Exception e){ System.out.println(e);}
	
		
	}
	public void addTrainer(Connection con) {
		try {
		String trainerSql="insert into Trainer(Trainer_id, experience,  batch_id) values(?, ?, ?)";
      	PreparedStatement pstmt=con.prepareStatement(trainerSql);
        pstmt.setInt(1, Integer.parseInt(idTextField.getText()));
        pstmt.setString(2, expTextField.getText());
        pstmt.setInt(3, Integer.parseInt(batchIdTextField.getText()));
        int upd=pstmt.executeUpdate();
		if(upd==1) {
			JOptionPane.showMessageDialog(null, "Trainer Added Successfully");
		}
		}
	 	catch(Exception e){ 			
	 		JOptionPane.showMessageDialog(null, "Error Occured in Trainer Details"+e);
	 		System.out.println(e);
	 	}
		
	}

}
