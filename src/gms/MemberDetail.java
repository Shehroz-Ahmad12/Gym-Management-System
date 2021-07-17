package gms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import javax.swing.JTextPane;
import java.awt.TextArea;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;



public class MemberDetail extends JFrame {

	private JPanel contentPane;
	JLabel lblId_1;
	JLabel lblFirstName_1;
	JLabel lblAge_1;
	JLabel lblLastName_1;
	JLabel lblContactno_1;
	JLabel lblHeight_1;
	JLabel lblWeight_1;
	JLabel lblPackage_1;
	JLabel lblPlan_1;
	JLabel lblPackageStatus_1;
	JComboBox comboBox;
	JComboBox statuscomboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberDetail frame = new MemberDetail(1001);
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
	
	
	public MemberDetail(int id) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				setPlan();
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
		
		
		JLabel lblId = new JLabel("ID:");
		lblId.setForeground(Color.LIGHT_GRAY);
		lblId.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblId.setBounds(42, 47, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setForeground(Color.LIGHT_GRAY);
		lblFirstName.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblFirstName.setBounds(42, 90, 81, 14);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setForeground(Color.LIGHT_GRAY);
		lblLastName.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblLastName.setBounds(364, 90, 80, 14);
		contentPane.add(lblLastName);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setForeground(Color.LIGHT_GRAY);
		lblAge.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblAge.setBounds(42, 132, 81, 14);
		contentPane.add(lblAge);
		
		JLabel lblContactno = new JLabel("Contact No.:");
		lblContactno.setForeground(Color.LIGHT_GRAY);
		lblContactno.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblContactno.setBounds(364, 132, 97, 14);
		contentPane.add(lblContactno);
		
		JLabel lblWeight = new JLabel("Weight:");
		lblWeight.setForeground(Color.LIGHT_GRAY);
		lblWeight.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblWeight.setBounds(42, 222, 81, 14);
		contentPane.add(lblWeight);
		
		JLabel lblHeight = new JLabel("Height:");
		lblHeight.setForeground(Color.LIGHT_GRAY);
		lblHeight.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblHeight.setBounds(364, 222, 81, 14);
		contentPane.add(lblHeight);
		
		JLabel lblPackageStatus = new JLabel("Current Package Status:");
		lblPackageStatus.setForeground(Color.LIGHT_GRAY);
		lblPackageStatus.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblPackageStatus.setBounds(42, 310, 191, 14);
		contentPane.add(lblPackageStatus);
		
		JLabel lblPlan = new JLabel("Plan:");
		lblPlan.setForeground(Color.LIGHT_GRAY);
		lblPlan.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblPlan.setBounds(364, 267, 126, 14);
		contentPane.add(lblPlan);
		
		JLabel lblMemberDetails = new JLabel("Member Details:");
		lblMemberDetails.setForeground(Color.LIGHT_GRAY);
		lblMemberDetails.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblMemberDetails.setBounds(42, 194, 120, 14);
		contentPane.add(lblMemberDetails);
		
		
		JLabel lblAddMember = new JLabel("Member Details");
		lblAddMember.setForeground(Color.LIGHT_GRAY);
		lblAddMember.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		lblAddMember.setBounds(275, 11, 186, 14);
		contentPane.add(lblAddMember);
		
		
		
		
		
		JButton updateStatusButton = new JButton("Update Status");
		updateStatusButton.setBackground(Color.LIGHT_GRAY);
		updateStatusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatePackageStatus();
			
			
			}       
		});
		
		updateStatusButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		updateStatusButton.setBounds(67, 382, 149, 31);
		contentPane.add(updateStatusButton);
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
		
		lblId_1 = new JLabel("");
		lblId_1.setForeground(Color.LIGHT_GRAY);
		lblId_1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblId_1.setBounds(133, 47, 46, 14);
		contentPane.add(lblId_1);
		
		lblFirstName_1 = new JLabel("");
		lblFirstName_1.setForeground(Color.LIGHT_GRAY);
		lblFirstName_1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblFirstName_1.setBounds(133, 90, 81, 14);
		contentPane.add(lblFirstName_1);
		
		lblAge_1 = new JLabel("");
		lblAge_1.setForeground(Color.LIGHT_GRAY);
		lblAge_1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblAge_1.setBounds(133, 132, 81, 14);
		contentPane.add(lblAge_1);
		
		lblLastName_1 = new JLabel("");
		lblLastName_1.setForeground(Color.LIGHT_GRAY);
		lblLastName_1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblLastName_1.setBounds(484, 90, 80, 14);
		contentPane.add(lblLastName_1);
		
		lblContactno_1 = new JLabel("");
		lblContactno_1.setForeground(Color.LIGHT_GRAY);
		lblContactno_1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblContactno_1.setBounds(471, 132, 173, 14);
		contentPane.add(lblContactno_1);
		
		lblHeight_1 = new JLabel("");
		lblHeight_1.setForeground(Color.LIGHT_GRAY);
		lblHeight_1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblHeight_1.setBounds(455, 222, 81, 14);
		contentPane.add(lblHeight_1);
		
		lblWeight_1 = new JLabel("");
		lblWeight_1.setForeground(Color.LIGHT_GRAY);
		lblWeight_1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblWeight_1.setBounds(133, 222, 81, 14);
		contentPane.add(lblWeight_1);
		
		lblPackageStatus_1 = new JLabel("");
		lblPackageStatus_1.setForeground(Color.LIGHT_GRAY);
		lblPackageStatus_1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblPackageStatus_1.setBounds(254, 310, 126, 14);
		contentPane.add(lblPackageStatus_1);
		
		lblPlan_1 = new JLabel("");
		lblPlan_1.setForeground(Color.LIGHT_GRAY);
		lblPlan_1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblPlan_1.setBounds(468, 267, 126, 14);
		contentPane.add(lblPlan_1);
		
		JLabel lblNewStatus = new JLabel("Package Status:");
		lblNewStatus.setForeground(Color.LIGHT_GRAY);
		lblNewStatus.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblNewStatus.setBounds(42, 353, 126, 14);
		contentPane.add(lblNewStatus);
		
		JLabel lblSelectPlan = new JLabel("Select Plan:");
		lblSelectPlan.setForeground(Color.LIGHT_GRAY);
		lblSelectPlan.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblSelectPlan.setBounds(360, 349, 126, 14);
		contentPane.add(lblSelectPlan);
		
		comboBox = new JComboBox();
		comboBox.setBackground(Color.LIGHT_GRAY);
		comboBox.setBounds(467, 345, 97, 22);
		contentPane.add(comboBox);
		
		statuscomboBox = new JComboBox();
		statuscomboBox.setBackground(Color.LIGHT_GRAY);
		statuscomboBox.setModel(new DefaultComboBoxModel(new String[] {"Active", "Expired"}));
		statuscomboBox.setBounds(194, 349, 67, 22);
		contentPane.add(statuscomboBox);
		
		lblPackage_1 = new JLabel("");
		lblPackage_1.setForeground(Color.LIGHT_GRAY);
		lblPackage_1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblPackage_1.setBounds(184, 267, 126, 14);
		contentPane.add(lblPackage_1);
		
		JLabel lblPackage = new JLabel("Package:");
		lblPackage.setForeground(Color.LIGHT_GRAY);
		lblPackage.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblPackage.setBounds(42, 267, 126, 14);
		contentPane.add(lblPackage);
		
		JButton btnUpdatePlan = new JButton("Update Plan");
		btnUpdatePlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatePlan();
			}
		});
		btnUpdatePlan.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		btnUpdatePlan.setBackground(Color.LIGHT_GRAY);
		btnUpdatePlan.setBounds(438, 383, 126, 31);
		contentPane.add(btnUpdatePlan);
		
		JLabel picture = new JLabel("");
		picture.setBounds(0, 0, 684, 492);
		contentPane.add(picture);
		picture.setIcon(new ImageIcon(image));
			
		
		
	}
	
	public void showDetails(int member_Id) {

		try{
            //create  the connection object
            Connection con=DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521:orcl","gms","gms");
 
		Statement stmt=con.createStatement();

	    ResultSet rs=stmt.executeQuery("select * from plan join (select * from member,person where person.id=member.member_id) using (plan_id) join membership using (member_id) join package using (package_id) where member_id='"+member_Id+"'");
	    while(rs.next()) {
	    	lblId_1.setText(rs.getString("Member_Id"));
	    	lblFirstName_1.setText(rs.getString("First_name"));
	    	lblLastName_1.setText(rs.getString("Last_name"));
	    	lblAge_1.setText(rs.getString("Age"));
	    	lblContactno_1.setText(rs.getString("Contact"));
	    	lblWeight_1.setText(rs.getString("Weight"));
	    	lblHeight_1.setText(rs.getString("Height"));
	    	lblPackage_1.setText(rs.getString("Package_Name"));
	    	lblPackageStatus_1.setText(rs.getString("Status"));
	    	lblPlan_1.setText(rs.getString("Plan_Name"));
	    	
	    	
	    }con.close();
	}
		catch(Exception e){ System.out.println(e);}

		
	}
	
	public void updatePlan() {
		
		try {
			Connection con=DriverManager.getConnection(
		            "jdbc:oracle:thin:@localhost:1521:orcl","gms","gms");
		
		String plan=comboBox.getSelectedItem().toString();
        System.out.println(plan);
        String planSql="Select plan_id from plan where plan_name='"+plan+"'";
        PreparedStatement planstmnt = con.prepareStatement(planSql);
        ResultSet rs=planstmnt.executeQuery();
        int plan_id = 0;
        if (rs.next()) {
        	plan_id=rs.getInt(1);
        }
        System.out.print(plan_id);
        String newplanSql="Update member set plan_id=? where member_id='"+Integer.parseInt(lblId_1.getText())+"'";
        PreparedStatement pstmt=con.prepareStatement(newplanSql);
        //
        pstmt.setInt(1, plan_id);
        
        int upd=pstmt.executeUpdate();
    	if(upd==1) {
        	JOptionPane.showMessageDialog(null, "Plan Changed Successfully");
        	System.out.println("Plan Changed Successfully");
        }
        else {
        	JOptionPane.showMessageDialog(null, "Error occured");
        	
        }
        con.close();
		}catch(Exception e) {System.out.println(e);}

		
	}
	public void setPlan() {
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
        
        comboBox.setModel(new DefaultComboBoxModel(plans)); 
        
        
		}catch(Exception e) {System.out.println(e);
		}


	}
	public void updatePackageStatus() {
		try{
            //create  the connection object
            Connection con=DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521:orcl","gms","gms");
 
            String statusSql="Update membership set status=? where member_id='"+Integer.parseInt(lblId_1.getText())+"'";
            PreparedStatement pstmt1=con.prepareStatement(statusSql);
            //
            pstmt1.setString(1, statuscomboBox.getSelectedItem().toString());
            
            int upd=pstmt1.executeUpdate();
	    	if (upd==1) {
	    		JOptionPane.showMessageDialog(null, "Package Status Changed");
	    	}
            
            con.close();
           
        }
	 	catch(Exception e1){ System.out.println(e1);}
	

	}
}
