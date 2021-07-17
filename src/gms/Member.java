package gms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Member extends JFrame {

	private JPanel contentPane;
	JLabel lblCount;
	private JTable table;
	private JTextField dlttextField;
	private JTextField detTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Member frame = new Member();
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
	public Member() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				showData();
				totalMembers();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(51, 51, 51));
		
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 116, 664, 281);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton addButton = new JButton("Add Member");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddMember ad1= new AddMember();
				ad1.setVisible(true);
				dispose();
				
			}
		});
		addButton.setForeground(Color.BLACK);
		addButton.setBackground(Color.LIGHT_GRAY);
		addButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		addButton.setBounds(10, 73, 145, 32);
		contentPane.add(addButton);
		
		dlttextField = new JTextField();
		dlttextField.setBounds(413, 446, 86, 20);
		contentPane.add(dlttextField);
		dlttextField.setColumns(10);
		
		JButton deleteButton = new JButton("Delete Member");
		deleteButton.setBackground(Color.LIGHT_GRAY);
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				deleteMember();
						
			}
		});
		deleteButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		deleteButton.setBounds(509, 440, 172, 30);
		contentPane.add(deleteButton);
		
		JButton detailsButton = new JButton("Member Details");
		detailsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(detTextField.getText());
				MemberDetail md= new MemberDetail(id);
				md.setVisible(true);
				dispose();
			
			}
		});
		detailsButton.setBackground(Color.LIGHT_GRAY);
		detailsButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		detailsButton.setBounds(509, 73, 165, 32);
		contentPane.add(detailsButton);
		
		JLabel lblNewLabel = new JLabel("Members");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		lblNewLabel.setBounds(287, 11, 110, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblTotal = new JLabel("Total Members:");
		lblTotal.setForeground(Color.LIGHT_GRAY);
		lblTotal.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		lblTotal.setBounds(398, 408, 130, 32);
		contentPane.add(lblTotal);
		
		lblCount = new JLabel("");
		lblCount.setForeground(Color.LIGHT_GRAY);
		lblCount.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		lblCount.setBounds(525, 408, 130, 32);
		contentPane.add(lblCount);
		

		JButton btnBack = new JButton("Back");
		btnBack.setBackground(Color.LIGHT_GRAY);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu m1=new MainMenu();
				m1.setVisible(true);
				dispose();
				
			}
		});
		btnBack.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		btnBack.setBounds(10, 441, 130, 28);
		contentPane.add(btnBack);
		
		
		JLabel lblId = new JLabel("Id:");
		lblId.setForeground(Color.LIGHT_GRAY);
		lblId.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		lblId.setBounds(359, 439, 38, 32);
		contentPane.add(lblId);
		Image image =new ImageIcon(this.getClass().getResource("/All1.jpg")).getImage();
		
		detTextField = new JTextField();
		detTextField.setBounds(413, 80, 86, 20);
		contentPane.add(detTextField);
		detTextField.setColumns(10);
		
		JLabel lblId_1 = new JLabel("Id:");
		lblId_1.setForeground(Color.LIGHT_GRAY);
		lblId_1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		lblId_1.setBounds(370, 73, 27, 32);
		contentPane.add(lblId_1);
		
		JLabel picture = new JLabel("");
		picture.setBounds(0, 0, 684, 492);
		contentPane.add(picture);
		picture.setIcon(new ImageIcon(image));
		

		
	}
	
	

	
	private void showData() {
		
try {
			
			Connection con=DriverManager.getConnection(
		            "jdbc:oracle:thin:@localhost:1521:orcl","gms","gms");
		 
		Statement stmt=con.createStatement();
   
        ResultSet rs=stmt.executeQuery("select * from gms.Member, Person, plan where  person.id=member.member_id and plan.plan_id=member.plan_id order by member_id");
        
        ResultSetMetaData rsm=rs.getMetaData();
        int cc=rsm.getColumnCount();
        
        DefaultTableModel dft =(DefaultTableModel)table.getModel();
        dft.addColumn("Id");
        dft.addColumn("First_Name");
        dft.addColumn("Last_Name");
        dft.addColumn("Contact");
        dft.addColumn("Plan Name");
        dft.addColumn("Batch Id");
        
        
        dft.setRowCount(0);
      
        
        while(rs.next()) {
        	Vector v2=new Vector();	
        	for(int i=1;i<=cc;i++) {
        		
        		v2.add(rs.getString("Member_Id"));
        		v2.add(rs.getString("First_Name"));
        		v2.add(rs.getString("Last_Name"));
        		v2.add(rs.getString("Contact"));
        		v2.add(rs.getString("Plan_Name"));
        		v2.add(rs.getString("Batch_Id"));
        		
        	}
        	
        	dft.addRow(v2);
        	
        }
        
        
}	catch(Exception e){ System.out.println(e);}
		
		
		
	}	
	
	
	public void totalMembers() {
		
		try {
		Connection con=DriverManager.getConnection(
	            "jdbc:oracle:thin:@localhost:1521:orcl","gms","gms");
	 
	Statement stmt=con.createStatement();

		ResultSet rs1=stmt.executeQuery("Select count(member_id) from Member");
        
		while(rs1.next()){
        	lblCount.setText(rs1.getString(1));
        }
   	}catch(Exception e){System.out.println(e);}
	
}
	
	public void deleteMember() {
		try {
			
			Connection con=DriverManager.getConnection(
		            "jdbc:oracle:thin:@localhost:1521:orcl","gms","gms");
			
			
			String address="Select building from person where person.id="+Integer.parseInt(dlttextField.getText()); 
		   	Statement stmt=con.createStatement();
		    ResultSet rs=stmt.executeQuery(address);
		    String building="";
		    while(rs.next()) {
		    	building=rs.getString(1);
		    }
			String dltAdd="Delete from address where building='"+building+"'";
		    
		    
			 String sql="Delete from person where id="+Integer.parseInt(dlttextField.getText());
			 
			 PreparedStatement pstmt=con.prepareStatement(sql);
			 PreparedStatement pstmt1=con.prepareStatement(dltAdd);
			   
	         
	         int update= pstmt.executeUpdate();
	         if (update==1) {
	        	 pstmt1.executeUpdate();
	        	 JOptionPane.showMessageDialog(null, "Member Deleted Successfully");
	        	 Member m=new Member();
	        	 m.setVisible(true);
	        	 dispose();
	         }else
	        	 JOptionPane.showMessageDialog(null, "Unsuccessfull");
	         con.close();
    }
		catch(Exception e1){JOptionPane.showMessageDialog(null, e1);}
		
}}
