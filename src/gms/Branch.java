package gms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

public class Branch extends JFrame {

	private JPanel contentPane;
	private JTextField dlttextField;
	private JTable table;
	private JTextField updateTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Branch frame = new Branch();
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
	public Branch() {
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
		
		JButton addButton = new JButton("Add Equipment");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				AddEquipment ae1= new AddEquipment();
				ae1.setVisible(true);
				dispose();
			}
			
		});
		addButton.setForeground(Color.BLACK);
		addButton.setBackground(Color.LIGHT_GRAY);
		addButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		addButton.setBounds(10, 71, 176, 32);
		contentPane.add(addButton);
		
		
		JButton updButton = new JButton("Equipment Details");
		updButton.setBackground(Color.LIGHT_GRAY);
		updButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(updateTextField.getText());
				UpdateEquipment ue=new UpdateEquipment(id);
				ue.setVisible(true);
				dispose();
			}
		});
		updButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		updButton.setBounds(513, 74, 161, 28);
		contentPane.add(updButton);
		
		JLabel lblNewLabel = new JLabel("Branch & Equipment");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		lblNewLabel.setBounds(235, 11, 249, 43);
		contentPane.add(lblNewLabel);
		
		JButton btnDeleteEquipment = new JButton("Delete Equipment");
		btnDeleteEquipment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteEquipment();
				Branch b=new Branch();
				b.setVisible(true);
				dispose();
			}
		});
		btnDeleteEquipment.setBackground(Color.LIGHT_GRAY);
		btnDeleteEquipment.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		btnDeleteEquipment.setBounds(462, 442, 212, 28);
		contentPane.add(btnDeleteEquipment);
		
		dlttextField = new JTextField();
		dlttextField.setBounds(366, 447, 86, 20);
		contentPane.add(dlttextField);
		dlttextField.setColumns(10);
		
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
		btnBack.setBounds(10, 442, 114, 28);
		contentPane.add(btnBack);
		


		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 116, 664, 304);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		Image image =new ImageIcon(this.getClass().getResource("/All1.jpg")).getImage();
		
		updateTextField = new JTextField();
		updateTextField.setBounds(417, 78, 86, 20);
		contentPane.add(updateTextField);
		updateTextField.setColumns(10);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setForeground(Color.LIGHT_GRAY);
		lblId.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		lblId.setBounds(372, 66, 35, 43);
		contentPane.add(lblId);
		
		JLabel lblId_1 = new JLabel("Id:");
		lblId_1.setForeground(Color.LIGHT_GRAY);
		lblId_1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		lblId_1.setBounds(315, 437, 41, 39);
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
	   
	        ResultSet rs=stmt.executeQuery("select * from branch join equipment using (branch_id) order by branch_id");
	        
	        ResultSetMetaData rsm=rs.getMetaData();
	        int cc=rsm.getColumnCount();
	        
	        DefaultTableModel dft =(DefaultTableModel)table.getModel();
	        dft.addColumn("Branch Id");
	        dft.addColumn("Branch Name");
	        dft.addColumn("Equipment Id");
	        dft.addColumn("Equipment Name");
	        dft.addColumn("Status");
	        dft.setRowCount(0);
	      
	        
	        while(rs.next()) {
	        	Vector v=new Vector();	
	        	for(int i=1;i<=cc;i++) {
	        		v.add(rs.getString("Branch_Id"));
	        		v.add(rs.getString("Branch_Name"));
	        		v.add(rs.getString("Equipment_Id"));
	        		v.add(rs.getString("Equipment_Name"));
	        		v.add(rs.getString("Status"));
	        	}
	        	
	        	dft.addRow(v);
	        	
	        }
	   
        
		}catch(Exception e){ System.out.println(e);}
		
				
	}
	
	

	public void deleteEquipment() {
		try {
			
			Connection con=DriverManager.getConnection(
		            "jdbc:oracle:thin:@localhost:1521:orcl","gms","gms");
		 
			 String sql="Delete from Equipment where Equipment.Equipment_id="+Integer.parseInt(dlttextField.getText());
	         PreparedStatement pstmt=con.prepareStatement(sql);
	         int update= pstmt.executeUpdate();
	         if (update==1) {
	        	 JOptionPane.showMessageDialog(null, "Equipment Deleted Successfully");
	         	}
	         else
	        	 JOptionPane.showMessageDialog(null, "Unsuccessfull");
	         con.close();
    }
		catch(Exception e1){ JOptionPane.showMessageDialog(null, e1);}
	
	}

}        