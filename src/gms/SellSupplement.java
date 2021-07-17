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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SellSupplement extends JFrame {

	private JPanel contentPane;
	private JTextField suplementIdTextField;
	private JTextField memberIdTextField;
	JDateChooser dateChooser;
	private JTable table;
	private JTextField recordtextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SellSupplement frame = new SellSupplement();
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
	public SellSupplement() {
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
	
	JLabel lblSuppDetails = new JLabel("Supplement Sale Details");
	lblSuppDetails.setForeground(Color.LIGHT_GRAY);
	lblSuppDetails.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 18));
	lblSuppDetails.setBounds(210, 30, 301, 14);
	contentPane.add(lblSuppDetails);
	
	JLabel lblSuppId = new JLabel("Supplement Id:");
	lblSuppId.setForeground(Color.LIGHT_GRAY);
	lblSuppId.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
	lblSuppId.setBounds(26, 146, 154, 14);
	contentPane.add(lblSuppId);
	
	suplementIdTextField = new JTextField();
	suplementIdTextField.setColumns(10);
	suplementIdTextField.setBounds(143, 143, 120, 20);
	contentPane.add(suplementIdTextField);
	
	JLabel lblDate = new JLabel("Date:");
	lblDate.setForeground(Color.LIGHT_GRAY);
	lblDate.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
	lblDate.setBounds(29, 266, 46, 14);
	contentPane.add(lblDate);
	
	dateChooser = new JDateChooser();
	dateChooser.setBounds(143, 260, 120, 20);
	contentPane.add(dateChooser);
	
	
	JButton btnAdd = new JButton("Add");
	btnAdd.setBackground(Color.LIGHT_GRAY);
	btnAdd.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			sellSupplement();	
		}
	});
	btnAdd.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
	btnAdd.setBounds(269, 391, 104, 35);
	contentPane.add(btnAdd);
	
	JButton btnBack = new JButton("Back");
	btnBack.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Supplement s=new Supplement();
			s.setVisible(true);
			dispose();
		}
	});
	btnBack.setBackground(Color.LIGHT_GRAY);
	btnBack.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
	btnBack.setBounds(46, 391, 104, 35);
	contentPane.add(btnBack);
	
	JLabel lblMemberId = new JLabel("Member Id:");
	lblMemberId.setForeground(Color.LIGHT_GRAY);
	lblMemberId.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
	lblMemberId.setBounds(26, 207, 120, 14);
	contentPane.add(lblMemberId);
	
	memberIdTextField = new JTextField();
	memberIdTextField.setColumns(10);
	memberIdTextField.setBounds(143, 204, 120, 20);
	contentPane.add(memberIdTextField);
	Image image =new ImageIcon(this.getClass().getResource("/All1.jpg")).getImage();
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(296, 90, 378, 244);
	contentPane.add(scrollPane);
	
	table = new JTable();
	scrollPane.setViewportView(table);
	
	JLabel lblPreviousRecords = new JLabel("Previous Records");
	lblPreviousRecords.setForeground(Color.LIGHT_GRAY);
	lblPreviousRecords.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 18));
	lblPreviousRecords.setBounds(373, 69, 301, 14);
	contentPane.add(lblPreviousRecords);
	
	JLabel lblRecord = new JLabel("Record Id:");
	lblRecord.setForeground(Color.LIGHT_GRAY);
	lblRecord.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
	lblRecord.setBounds(26, 91, 154, 14);
	contentPane.add(lblRecord);
	
	recordtextField = new JTextField();
	recordtextField.setColumns(10);
	recordtextField.setBounds(143, 88, 120, 20);
	contentPane.add(recordtextField);
	
	
	JLabel picture = new JLabel("");
	picture.setBounds(0, 0, 684, 492);
	contentPane.add(picture);
	picture.setIcon(new ImageIcon(image));
	
	

	}
	
	public void sellSupplement() {
		try{
            //create  the connection object
            Connection con=DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521:orcl","gms","gms");
           
            DateFormat df=new SimpleDateFormat("dd-MM-YYYY");
	        java.util.Date stDate = dateChooser.getDate();
			String sDate=df.format(stDate);			
            
            String supplementSql="insert into sale_records(record_id, supplement_id, member_id, sell_date) values(?,?, ?, TO_DATE(?, 'DD-MM-YYYY'))";
            PreparedStatement pstmt=con.prepareStatement(supplementSql);
            pstmt.setInt(1, Integer.parseInt(recordtextField.getText()));
            pstmt.setInt(2, Integer.parseInt(suplementIdTextField.getText()));            
            pstmt.setInt(3, Integer.parseInt(memberIdTextField.getText()));
            pstmt.setString(4, sDate);

            try {
            int upd=pstmt.executeUpdate();
            if (upd==1) {
            	JOptionPane.showMessageDialog(null, "Row Input Successfully");
            	SupplementReceipt sr=new SupplementReceipt(Integer.parseInt(recordtextField.getText()));// Insert record id 
            	sr.setVisible(true);
            	dispose();
            }
            }catch(Exception e3) {JOptionPane.showMessageDialog(null, "Error Occured");}
           
            con.close();
            
        }
	 	catch(Exception e1){JOptionPane.showMessageDialog(null, e1);}
	

	
}
	
	public void showData() {
		
try {
			
			Connection con=DriverManager.getConnection(
		            "jdbc:oracle:thin:@localhost:1521:orcl","gms","gms");
		 
		Statement stmt=con.createStatement();
   
        ResultSet rs=stmt.executeQuery("select * from gms.sale_records join member using(member_id) join supplement using(supplement_Id)");
        
        ResultSetMetaData rsm=rs.getMetaData();
        int cc=rsm.getColumnCount();;
        
        DefaultTableModel dft =(DefaultTableModel)table.getModel();
        dft.addColumn("Rec Id");
        dft.addColumn("Supp Name");
        dft.addColumn("Price(Rs)");
        dft.addColumn("Member Id");
        dft.addColumn("Date");
        dft.setRowCount(0);
      
        
        while(rs.next()) {
        	Vector v2=new Vector();	
        	for(int i=1;i<=cc;i++) {
        		v2.add(rs.getString("Record_Id"));
        		v2.add(rs.getString("Supplement_Name"));
        		
        		v2.add(rs.getString("Price"));
        		v2.add(rs.getString("Member_ID"));
        		v2.add(rs.getString("Sell_Date"));
        		
        	}
        	
        	dft.addRow(v2);
        	
        }
   
        
}	catch(Exception e){ System.out.println(e);}
		
		

	}
}
