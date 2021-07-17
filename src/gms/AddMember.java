package gms;
import java.util.*;
import java.sql.*;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent; 

public class AddMember extends JFrame {


	
	private JPanel contentPane;
	private JTextField idTextField;
	private JTextField firstnameTextField;
	private JTextField lastnameTextField;
	private JTextField ageTextField;
	private JTextField contactTextField;
	private JTextField weightTextField;
	private JTextField heightTextField;
	private JTextField buildingTextField;
	private JTextField sectorTextField;
	private JTextField streetTextField;
	private JTextField cityTextField;
	private JTextField batchIdTextField;
	private JComboBox planComboBox;
	private JComboBox packageComboBox;
	private JDateChooser dateChooser;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
			
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					AddMember frame = new AddMember();
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
	public AddMember() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				setPackages();
				setPlans();
			}
		});
		
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
		lblId.setBounds(42, 47, 46, 14);
		contentPane.add(lblId);
		
		idTextField = new JTextField();
		idTextField.setBounds(133, 44, 120, 20);
		contentPane.add(idTextField);
		idTextField.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setForeground(Color.LIGHT_GRAY);
		lblFirstName.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblFirstName.setBounds(42, 90, 81, 14);
		contentPane.add(lblFirstName);
		
		firstnameTextField = new JTextField();
		firstnameTextField.setColumns(10);
		firstnameTextField.setBounds(133, 87, 120, 20);
		contentPane.add(firstnameTextField);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setForeground(Color.LIGHT_GRAY);
		lblLastName.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblLastName.setBounds(364, 90, 80, 14);
		contentPane.add(lblLastName);
		
		lastnameTextField = new JTextField();
		lastnameTextField.setColumns(10);
		lastnameTextField.setBounds(484, 87, 120, 20);
		contentPane.add(lastnameTextField);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setForeground(Color.LIGHT_GRAY);
		lblAge.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblAge.setBounds(42, 132, 81, 14);
		contentPane.add(lblAge);
		
		ageTextField = new JTextField();
		ageTextField.setColumns(10);
		ageTextField.setBounds(133, 129, 120, 20);
		contentPane.add(ageTextField);
		
		JLabel lblContactno = new JLabel("Contact No.:");
		lblContactno.setForeground(Color.LIGHT_GRAY);
		lblContactno.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblContactno.setBounds(364, 132, 97, 14);
		contentPane.add(lblContactno);
		
		contactTextField = new JTextField();
		contactTextField.setColumns(10);
		contactTextField.setBounds(484, 129, 120, 20);
		contentPane.add(contactTextField);
		
		weightTextField = new JTextField();
		weightTextField.setColumns(10);
		weightTextField.setBounds(133, 305, 120, 20);
		contentPane.add(weightTextField);
		
		heightTextField = new JTextField();
		heightTextField.setColumns(10);
		heightTextField.setBounds(484, 305, 120, 20);
		contentPane.add(heightTextField);
		
		JLabel lblWeight = new JLabel("Weight:");
		lblWeight.setForeground(Color.LIGHT_GRAY);
		lblWeight.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblWeight.setBounds(42, 308, 81, 14);
		contentPane.add(lblWeight);
		
		JLabel lblHeight = new JLabel("Height:");
		lblHeight.setForeground(Color.LIGHT_GRAY);
		lblHeight.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblHeight.setBounds(363, 308, 81, 14);
		contentPane.add(lblHeight);
		
		packageComboBox = new JComboBox();
		packageComboBox.setBackground(SystemColor.window);
		packageComboBox.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 10));
		setPackages();
		packageComboBox.setBounds(178, 348, 81, 21);
		contentPane.add(packageComboBox);
		
		JLabel lblSelectPackage = new JLabel("Select Package:");
		lblSelectPackage.setForeground(Color.LIGHT_GRAY);
		lblSelectPackage.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblSelectPackage.setBounds(42, 351, 126, 14);
		contentPane.add(lblSelectPackage);
		
		JLabel lblSelectPlan = new JLabel("Select Plan:");
		lblSelectPlan.setForeground(Color.LIGHT_GRAY);
		lblSelectPlan.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblSelectPlan.setBounds(364, 351, 126, 14);
		contentPane.add(lblSelectPlan);
		
		planComboBox = new JComboBox();
		planComboBox.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 10));
		setPlans();
		planComboBox.setBounds(484, 347, 104, 22);
		contentPane.add(planComboBox);
		
		JLabel lblAddressDetails = new JLabel("Address Details:");
		lblAddressDetails.setForeground(Color.LIGHT_GRAY);
		lblAddressDetails.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblAddressDetails.setBounds(42, 172, 120, 14);
		contentPane.add(lblAddressDetails);
		
		JLabel lblBuilding = new JLabel("Building:");
		lblBuilding.setForeground(Color.LIGHT_GRAY);
		lblBuilding.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblBuilding.setBounds(42, 200, 81, 14);
		contentPane.add(lblBuilding);
		
		buildingTextField = new JTextField();
		buildingTextField.setColumns(10);
		buildingTextField.setBounds(133, 197, 120, 20);
		contentPane.add(buildingTextField);
		
		JLabel lblSector = new JLabel("Sector:");
		lblSector.setForeground(Color.LIGHT_GRAY);
		lblSector.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblSector.setBounds(42, 239, 81, 14);
		contentPane.add(lblSector);
		
		sectorTextField = new JTextField();
		sectorTextField.setColumns(10);
		sectorTextField.setBounds(133, 236, 120, 20);
		contentPane.add(sectorTextField);
		
		JLabel lblStreet = new JLabel("Street:");
		lblStreet.setForeground(Color.LIGHT_GRAY);
		lblStreet.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblStreet.setBounds(364, 200, 81, 14);
		contentPane.add(lblStreet);
		
		streetTextField = new JTextField();
		streetTextField.setColumns(10);
		streetTextField.setBounds(484, 197, 120, 20);
		contentPane.add(streetTextField);
		
		cityTextField = new JTextField();
		cityTextField.setColumns(10);
		cityTextField.setBounds(484, 236, 120, 20);
		contentPane.add(cityTextField);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setForeground(Color.LIGHT_GRAY);
		lblCity.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblCity.setBounds(364, 236, 81, 14);
		contentPane.add(lblCity);
		
		JLabel lblMemberDetails = new JLabel("Member Details:");
		lblMemberDetails.setForeground(Color.LIGHT_GRAY);
		lblMemberDetails.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblMemberDetails.setBounds(42, 280, 120, 14);
		contentPane.add(lblMemberDetails);
		
		JLabel lblStartDateOf = new JLabel("Package Start Date");
		lblStartDateOf.setForeground(Color.LIGHT_GRAY);
		lblStartDateOf.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblStartDateOf.setBounds(42, 396, 133, 14);
		contentPane.add(lblStartDateOf);
		
		JLabel lblBatchId = new JLabel("Batch Id:");
		lblBatchId.setForeground(Color.LIGHT_GRAY);
		lblBatchId.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblBatchId.setBounds(364, 396, 81, 14);
		contentPane.add(lblBatchId);
		
		batchIdTextField = new JTextField();
		batchIdTextField.setColumns(10);
		batchIdTextField.setBounds(484, 393, 120, 20);
		contentPane.add(batchIdTextField);
		
		
		JLabel lblAddMember = new JLabel("Add Member");
		lblAddMember.setForeground(Color.LIGHT_GRAY);
		lblAddMember.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		lblAddMember.setBounds(275, 11, 168, 14);
		contentPane.add(lblAddMember);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(188, 390, 111, 20);
		contentPane.add(dateChooser);
				
		JButton addMemberButton = new JButton("Add");
		addMemberButton.setBackground(Color.LIGHT_GRAY);
		addMemberButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
					addAddress();  
				    addPerson();
				    addMember();
				    addPackage();
				    MemberReceipt mr=new MemberReceipt(Integer.parseInt(idTextField.getText()));
				    mr.setVisible(true);
				    dispose();
			}     
		       
		});
		
		addMemberButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		addMemberButton.setBounds(275, 439, 105, 31);
		contentPane.add(addMemberButton);
		Image image =new ImageIcon(this.getClass().getResource("/All1.jpg")).getImage();
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Member m1=new Member();
				m1.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		btnBack.setBackground(Color.LIGHT_GRAY);
		btnBack.setBounds(42, 439, 105, 31);
		contentPane.add(btnBack);
		
		JLabel picture = new JLabel("");
		picture.setBounds(0, 0, 684, 492);
		contentPane.add(picture);
		picture.setIcon(new ImageIcon(image));
	
	}
	
	
	
	public void setPackages() {
		try {
			
			Connection con=DriverManager.getConnection(
		            "jdbc:oracle:thin:@localhost:1521:orcl","gms","gms");
		 
		Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select package_name from gms.Package order by package_id");
        int i=0;
        String[] packages =  new String[10];
        
       
        while (rs.next()) {
        	packages[i]=rs.getString(1);
        	i++;
        	
        }
        packageComboBox.setModel(new DefaultComboBoxModel(packages)); 
        
        
		}catch(Exception e) {System.out.println(e);
		}

		
	}
	
	public void setPlans() {
		try {
			
			Connection con=DriverManager.getConnection(
		            "jdbc:oracle:thin:@localhost:1521:orcl","gms","gms");
		 
		Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select plan_name from gms.Plan order by plan_id");
        int i=0;
        String[] plans = new String[10];
        
       
        while (rs.next()) {
        	plans[i]=rs.getString(1);
        	i++;
        	
        }
        
        planComboBox.setModel(new DefaultComboBoxModel(plans)); 
        
        
		}catch(Exception e) {System.out.println(e);
		}

	}
	
	public void addAddress() {
		
		try {

		Connection con=DriverManager.getConnection(
		            "jdbc:oracle:thin:@localhost:1521:orcl","gms","gms");
		 
		
		String addressSql="insert into Address(building, street, sector, city) values(?, ?, ?, ?)";
      	PreparedStatement pstmt1=con.prepareStatement(addressSql);
        pstmt1.setString(1, buildingTextField.getText());
        pstmt1.setString(2, streetTextField.getText());
        pstmt1.setString(3, sectorTextField.getText());
        pstmt1.setString(4, cityTextField.getText());
        
        
        int upd=pstmt1.executeUpdate() ;
        if(upd==1) {
        	//JOptionPane.showMessageDialog(null, "Address Input Successfully");
        	System.out.println("Address Input");
        	
        }
        else {
        	JOptionPane.showMessageDialog(null, "Error in address");
        	
        }
        con.close();
		}catch(Exception e) {System.out.println(e);}
        
		
	}
	
	public void addPerson() {
		
		try {
			Connection con=DriverManager.getConnection(
		            "jdbc:oracle:thin:@localhost:1521:orcl","gms","gms");
		
			
		String personSql="insert into Person(id, first_name, last_name, age, contact, building) values(?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt2=con.prepareStatement(personSql);
        pstmt2.setInt(1, Integer.parseInt(idTextField.getText()));
        pstmt2.setString(2, firstnameTextField.getText());
        pstmt2.setString(3, lastnameTextField.getText());
        pstmt2.setInt(4, Integer.parseInt(ageTextField.getText()));
        pstmt2.setString(5, contactTextField.getText());
        pstmt2.setString(6, buildingTextField.getText());
 		int upd=pstmt2.executeUpdate();
 		
 		 if(upd==1) {
         //	JOptionPane.showMessageDialog(null, "Person Input Successfully");
         	System.out.println("Person input succesfully");
         	
 		 }
         else {
         	JOptionPane.showMessageDialog(null, "Error in person");
         }
 		 
 		con.close();
        
	}catch(Exception e) {System.out.println(e);}
	}
	
	public void addMember() {
		
		try {
			Connection con=DriverManager.getConnection(
		            "jdbc:oracle:thin:@localhost:1521:orcl","gms","gms");
		
     	String memberSql="insert into Member(Member_id, weight, height, batch_id, plan_id) values(?, ?, ?, ?, ?)";
        PreparedStatement pstmt3=con.prepareStatement(memberSql);
        pstmt3.setInt(1, Integer.parseInt(idTextField.getText()));
        pstmt3.setString(2, weightTextField.getText());
        pstmt3.setString(3, heightTextField.getText());
        pstmt3.setInt(4, Integer.parseInt(batchIdTextField.getText()));    
            
        String plan=planComboBox.getSelectedItem().toString();
        System.out.println(plan);
        String planSql="Select plan_id from plan where plan_name='"+plan+"'";
        PreparedStatement planstmnt = con.prepareStatement(planSql);
        ResultSet rs=planstmnt.executeQuery();
        int plan_id = 0;
        if (rs.next()) {
        	plan_id=rs.getInt(1);
        
        }
        System.out.print(plan_id);
            
            
         pstmt3.setInt(5, plan_id); // Change plan id by fetching data from tables
        int upd= pstmt3.executeUpdate();
        if(upd==1) {
        	//JOptionPane.showMessageDialog(null, "Member Input Successfully");
        	System.out.println("Member input");
        }
        else {
        	JOptionPane.showMessageDialog(null, "Error occur in member details");
        	
        }
        con.close();
		}catch(Exception e) {System.out.println(e);}
	}
	
	public void addPackage() {

        DateFormat df=new SimpleDateFormat("dd-MM-YYYY");
        java.util.Date stDate = dateChooser.getDate();
		 String startDate=df.format(stDate);
		 
		 try {
			 Connection con=DriverManager.getConnection(
			            "jdbc:oracle:thin:@localhost:1521:orcl","gms","gms");
			
			String packagesSql="insert into Membership(Member_id, Package_id, start_date, status) values(?, ?, To_Date(?, 'DD-MM-YYYY'), 'Active')";
	        PreparedStatement pstmt4=con.prepareStatement(packagesSql);
	        String packageName=packageComboBox.getSelectedItem().toString();
	        String packageSql="Select package_id from package where package_name='"+packageName+"'";
	        PreparedStatement packagestmnt = con.prepareStatement(packageSql);
           ResultSet rs1=packagestmnt.executeQuery();
           int package_id = 0;
           if (rs1.next()) {
        	   package_id=rs1.getInt("package_id");
           
           }
            
           pstmt4.setInt(1, Integer.parseInt(idTextField.getText()));
           pstmt4.setInt(2, package_id);
	       pstmt4.setString(3, startDate);    				            
	       int upd=pstmt4.executeUpdate();
	       
	       try {
	       if (upd==1) {
           	JOptionPane.showMessageDialog(null, "Member Added Successfully");
           	con.close();
	       }
           }catch(Exception e3) {JOptionPane.showMessageDialog(null, "Error Occured");}
       
	       
	       
		 }catch(Exception e) {System.out.println(e);}
		
	}
	
}


