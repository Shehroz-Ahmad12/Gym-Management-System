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

public class Supplement extends JFrame {

	private JPanel contentPane;
	JTextField dltIdtextField;

	DefaultTableModel model =new DefaultTableModel(); 
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Supplement frame = new Supplement();
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
	public Supplement() {
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
		
		JButton addButton = new JButton("Add Supplement");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddSupplement as1=new AddSupplement();
				as1.setVisible(true);
				dispose();
				
				
			}
		});
		addButton.setForeground(Color.BLACK);
		addButton.setBackground(Color.LIGHT_GRAY);
		addButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		addButton.setBounds(28, 84, 191, 32);
		contentPane.add(addButton);
		
		dltIdtextField = new JTextField();
		dltIdtextField.setBounds(365, 428, 86, 20);
		contentPane.add(dltIdtextField);
		dltIdtextField.setColumns(10);
		
		JButton deleteButton = new JButton("Delete Supplement");
		deleteButton.setBackground(Color.LIGHT_GRAY);
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					deleteSupplement();
					Supplement s1=new Supplement();
		         	s1.setVisible(true);
		         	dispose();
			}
		});
		deleteButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		deleteButton.setBounds(468, 422, 206, 30);
		contentPane.add(deleteButton);
		
		JLabel lblNewLabel = new JLabel("Supplements");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		lblNewLabel.setBounds(268, 11, 159, 43);
		contentPane.add(lblNewLabel);

		

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
		btnBack.setBounds(10, 442, 130, 28);
		contentPane.add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 127, 664, 284);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		Image image =new ImageIcon(this.getClass().getResource("/All1.jpg")).getImage();
		
		JButton sellButton = new JButton("Sell");
		sellButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SellSupplement s1=new SellSupplement();
				s1.setVisible(true);
				dispose();
			}
		});
		sellButton.setForeground(Color.BLACK);
		sellButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		sellButton.setBackground(Color.LIGHT_GRAY);
		sellButton.setBounds(447, 84, 191, 32);
		contentPane.add(sellButton);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setForeground(Color.LIGHT_GRAY);
		lblId.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		lblId.setBounds(317, 416, 38, 43);
		contentPane.add(lblId);
		
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
   
        ResultSet rs=stmt.executeQuery("select * from gms.Supplement order by supplement_id");
        
        ResultSetMetaData rsm=rs.getMetaData();
        int cc=rsm.getColumnCount();;
        
        DefaultTableModel dft =(DefaultTableModel)table.getModel();
        dft.addColumn("Supplement Id");
        dft.addColumn("Supplement Name");
        dft.addColumn("Price(Rs)");
        dft.addColumn("Manufacturer");
        dft.addColumn("Quantity");
        dft.setRowCount(0);
      
        
        while(rs.next()) {
        	Vector v2=new Vector();	
        	for(int i=1;i<=cc;i++) {
        		v2.add(rs.getString("Supplement_Id"));
        		v2.add(rs.getString("Supplement_Name"));
        		v2.add(rs.getString("Price"));
        		v2.add(rs.getString("Manufacturer"));
        		v2.add(rs.getString("Quantity"));
        		v2.add(rs.getString("Admin_Id"));
        		
        	}
        	
        	dft.addRow(v2);
        	
        }
   
        
}	catch(Exception e){ System.out.println(e);}
		
		
		
	}	
	
	public void deleteSupplement() {
		try {
			
			Connection con=DriverManager.getConnection(
		            "jdbc:oracle:thin:@localhost:1521:orcl","gms","gms");
		 
			 String sql="Delete from Supplement where supplement_id="+Integer.parseInt(dltIdtextField.getText());
	         PreparedStatement pstmt=con.prepareStatement(sql);
	         int update= pstmt.executeUpdate();
	         if (update==1) {
	        	 JOptionPane.showMessageDialog(null, "Supplement Deleted Successfully");
	         	}
	         else
	        	 JOptionPane.showMessageDialog(null, "Supplement Does not Exist");
	         con.close();
    }
		catch(Exception e1){ System.out.println(e1);}
	
		
	}
		}

