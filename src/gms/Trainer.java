package gms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Trainer extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField dltTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Trainer frame = new Trainer();
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
	public Trainer() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				showData();
			
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
		scrollPane.setBounds(10, 117, 664, 294);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Trainers");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		lblNewLabel.setBounds(292, 11, 113, 30);
		contentPane.add(lblNewLabel);
		
		JButton btnAddTrainer = new JButton("Add Trainer");
		btnAddTrainer.setBackground(Color.LIGHT_GRAY);
		btnAddTrainer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddTrainer at1=new AddTrainer();
				at1.setVisible(true);
				dispose();
			}
		});
		btnAddTrainer.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		btnAddTrainer.setBounds(28, 76, 152, 30);
		contentPane.add(btnAddTrainer);
		
		JButton btnSalaries = new JButton("Salaries");
		btnSalaries.setBackground(Color.LIGHT_GRAY);
		btnSalaries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Salary s1=new Salary();
				s1.setVisible(true);
				dispose();
			}
		});
		btnSalaries.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		btnSalaries.setBounds(509, 76, 152, 30);
		contentPane.add(btnSalaries);
		
		JButton btnDeleteTrainer = new JButton("Delete Trainer");
		btnDeleteTrainer.setBackground(Color.LIGHT_GRAY);
		btnDeleteTrainer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				deleteTrainer();
				Trainer t=new Trainer();
				t.setVisible(true);
				dispose();
		
				
				
				
				
				
			}
		});
		btnDeleteTrainer.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		btnDeleteTrainer.setBounds(509, 440, 169, 30);
		contentPane.add(btnDeleteTrainer);
		
		dltTextField = new JTextField();
		dltTextField.setBounds(409, 446, 86, 20);
		contentPane.add(dltTextField);
		dltTextField.setColumns(10);
		
		

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
		btnBack.setBounds(10, 441, 113, 28);
		contentPane.add(btnBack);
		Image image =new ImageIcon(this.getClass().getResource("/All1.jpg")).getImage();
		
		JLabel lblId = new JLabel("Id:");
		lblId.setForeground(Color.LIGHT_GRAY);
		lblId.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		lblId.setBounds(358, 440, 47, 30);
		contentPane.add(lblId);
		
		JLabel picture = new JLabel("");
		picture.setBounds(0, 0, 684, 492);
		contentPane.add(picture);
		picture.setIcon(new ImageIcon(image));
		

			}
	public void deleteTrainer() {
		try {
			
			Connection con=DriverManager.getConnection(
		            "jdbc:oracle:thin:@localhost:1521:orcl","gms","gms");
		 

	        String address="Select building from person where person.id="+Integer.parseInt(dltTextField.getText()); 
		   	Statement stmt=con.createStatement();
		    ResultSet rs=stmt.executeQuery(address);
		    String building="";
		    while(rs.next()) {
		    	building=rs.getString(1);
		    }
			String dltAdd="Delete from address where building='"+building+"'";
		    
		    String sql="Delete from person where person.id="+Integer.parseInt(dltTextField.getText());
			    
			
		    PreparedStatement pstmt=con.prepareStatement(sql);
		    PreparedStatement pstmt1=con.prepareStatement(dltAdd);
		    
	         int update= pstmt.executeUpdate();
	         if (update==1) {
	        	 pstmt1.executeUpdate();
	        	 JOptionPane.showMessageDialog(null, "Trainer Deleted Successfully");}
	         else
	        	 JOptionPane.showMessageDialog(null, "Unsuccessfull");
	         con.close();
    }
 	catch(Exception e1){ System.out.println(e1);}

	}
	
	public void showData() {
try {
			
			Connection con=DriverManager.getConnection(
		            "jdbc:oracle:thin:@localhost:1521:orcl","gms","gms");
		 
		Statement stmt=con.createStatement();
   
        ResultSet rs=stmt.executeQuery("select * from trainer, person, batch where batch.batch_id=trainer.batch_Id and person.id=trainer.trainer_id order by trainer_id");
        
        ResultSetMetaData rsm=rs.getMetaData();
        int cc=rsm.getColumnCount();
        
        DefaultTableModel dft =(DefaultTableModel)table.getModel();
        dft.addColumn("Id");
        dft.addColumn("First Name");
        dft.addColumn("Last Name");
        dft.addColumn("Batch Id");
        dft.addColumn("Experience");
        
        
        
        dft.setRowCount(0);
      
        
        while(rs.next()) {
        	Vector v2=new Vector();	
        	for(int i=1;i<=cc;i++) {
        		
        		v2.add(rs.getString("Trainer_Id"));
        		v2.add(rs.getString("First_Name"));
        		v2.add(rs.getString("Last_Name"));
        		v2.add(rs.getString("Batch_Id"));
        		v2.add(rs.getString("Experience"));
        	}
        	
        	dft.addRow(v2);
        	
        }
        
        
}	catch(Exception e){ System.out.println(e);}
		

	}
}
