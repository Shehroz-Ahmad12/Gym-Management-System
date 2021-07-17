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
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Salary extends JFrame {

	private JPanel contentPane;
	JTable table;
	private JTextField searchtextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Salary frame = new Salary();
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
	public Salary() {
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
		scrollPane.setBounds(10, 117, 664, 304);
		contentPane.add(scrollPane);
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Salaries Data");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		lblNewLabel.setBounds(260, 11, 172, 30);
		contentPane.add(lblNewLabel);
		
		JButton btnAddSalary = new JButton("Add New Salary");
		btnAddSalary.setBackground(Color.LIGHT_GRAY);
		btnAddSalary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddSalary ad1=new AddSalary();
				ad1.setVisible(true);
				dispose();
				
			}
		});
		btnAddSalary.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		btnAddSalary.setBounds(28, 76, 172, 30);
		contentPane.add(btnAddSalary);
		
		JButton btnSalaries = new JButton("Search");
		btnSalaries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(searchtextField.getText());
				SalaryReceipt s=new SalaryReceipt(id);
				s.setVisible(true);
				dispose();
			}
		});
		btnSalaries.setBackground(Color.LIGHT_GRAY);
		btnSalaries.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		btnSalaries.setBounds(511, 76, 152, 30);
		contentPane.add(btnSalaries);
		
		searchtextField = new JTextField();
		searchtextField.setBounds(415, 81, 86, 20);
		contentPane.add(searchtextField);
		searchtextField.setColumns(10);
		Image image =new ImageIcon(this.getClass().getResource("/All1.jpg")).getImage();
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Trainer t=new Trainer();
				t.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		btnBack.setBackground(Color.LIGHT_GRAY);
		btnBack.setBounds(20, 440, 152, 30);
		contentPane.add(btnBack);
		
		
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
   
        ResultSet rs=stmt.executeQuery("select * from (select * from trainer,person where person.id=trainer.trainer_id) join salary using (trainer_id) order by salary_id");
        
        ResultSetMetaData rsm=rs.getMetaData();
        int cc=rsm.getColumnCount();;
        
        
		DefaultTableModel dft =(DefaultTableModel)table.getModel();
        dft.addColumn("Salary Id");
        dft.addColumn("Date");
        dft.addColumn("Amount(Rs)");
        dft.addColumn("Trainer Id");

        dft.addColumn("First Name");
        dft.addColumn("Last Name");
        
        dft.setRowCount(0);
      
        
        while(rs.next()) {
        	Vector v2=new Vector();	
        	for(int i=1;i<=cc;i++) {
        		v2.add(rs.getString("Salary_Id"));
        		v2.add(rs.getString("Salary_Date"));
        		v2.add(rs.getString("Amount"));
        		v2.add(rs.getString("Trainer_Id"));
        		v2.add(rs.getString("First_Name"));
        		v2.add(rs.getString("Last_Name"));
        		
        	}
        	
        	dft.addRow(v2);
        	
        }
   
        
}	catch(Exception e){ System.out.println(e);}
		
		
		
	}	
	

}
