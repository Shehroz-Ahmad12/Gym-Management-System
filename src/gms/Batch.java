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
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.AbstractButton;
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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Batch extends JFrame {

	private JPanel contentPane;
	JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Batch frame = new Batch();
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
	public Batch() {
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

	JButton addButton = new JButton("Add Batch");
	addButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			AddBatch ab1=new AddBatch();
			ab1.setVisible(true);
			dispose();
			
			
		}
	});
	addButton.setForeground(Color.BLACK);
	addButton.setBackground(Color.LIGHT_GRAY);
	addButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
	addButton.setBounds(25, 84, 191, 32);
	contentPane.add(addButton);
	
	JLabel lblMain = new JLabel("Batch and Branches");
	lblMain.setForeground(Color.LIGHT_GRAY);
	lblMain.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
	lblMain.setBounds(240, 23, 265, 43);
	contentPane.add(lblMain);

	

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
	scrollPane.setBounds(10, 127, 664, 277);
	contentPane.add(scrollPane);
	
	table = new JTable();
	scrollPane.setViewportView(table);
	Image image =new ImageIcon(this.getClass().getResource("/All1.jpg")).getImage();
	
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

    ResultSet rs=stmt.executeQuery("select * from Batch join Branch using (Branch_Id) order by batch_id");
    
    
    ResultSetMetaData rsm=rs.getMetaData();
    int cc=rsm.getColumnCount();;
    
    DefaultTableModel dft =(DefaultTableModel)table.getModel();
    dft.addColumn("Batch Id");
    dft.addColumn("Batch Name");
    dft.addColumn("Start Time");
    dft.addColumn("End Time");
    dft.addColumn("Branch Name");
    dft.setRowCount(0);
  
    
    while(rs.next()) {
    	
    	Vector v2=new Vector();	
    	for(int i=1;i<=cc;i++) {
    		v2.add(rs.getString("Batch_Id"));
    		v2.add(rs.getString("Batch_Name"));
    		v2.add(rs.getString("Starting_time"));
    		v2.add(rs.getString("End_time"));
    		v2.add(rs.getString("Branch_Name"));
    	}
    	
    	dft.addRow(v2);
    	
    }

    
}	catch(Exception e){ System.out.println(e);}
	
	
	
}
	}


