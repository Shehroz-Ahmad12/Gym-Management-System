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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AddBatch extends JFrame {

	private JPanel contentPane;
	private JTextField IdTextField;
	private JTextField nameTextField;
	private JTextField startTimeTextField;
	private JTextField endTimeTextField;
	private JTextField branchIdTextField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBatch frame = new AddBatch();
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
	public AddBatch() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setLayout(null);
		
		IdTextField = new JTextField();
		IdTextField.setBounds(183, 87, 115, 20);
		contentPane.add(IdTextField);
		IdTextField.setColumns(10);
		
		JLabel lblBatchId = new JLabel("Batch Id:");
		lblBatchId.setForeground(Color.LIGHT_GRAY);
		lblBatchId.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblBatchId.setBounds(45, 90, 115, 14);
		contentPane.add(lblBatchId);
		
		JLabel lbBatchName = new JLabel("Batch Name:");
		lbBatchName.setForeground(Color.LIGHT_GRAY);
		lbBatchName.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lbBatchName.setBounds(45, 138, 138, 14);
		contentPane.add(lbBatchName);
		
		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		nameTextField.setBounds(183, 135, 115, 20);
		contentPane.add(nameTextField);
		
		JLabel lblStartingTime = new JLabel("Starting Time:");
		lblStartingTime.setForeground(Color.LIGHT_GRAY);
		lblStartingTime.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblStartingTime.setBounds(45, 188, 138, 14);
		contentPane.add(lblStartingTime);
		
		startTimeTextField = new JTextField();
		startTimeTextField.setColumns(10);
		startTimeTextField.setBounds(183, 185, 115, 20);
		contentPane.add(startTimeTextField);
		
		JLabel lblEndingTime = new JLabel("Ending Time:");
		lblEndingTime.setForeground(Color.LIGHT_GRAY);
		lblEndingTime.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblEndingTime.setBounds(45, 238, 138, 14);
		contentPane.add(lblEndingTime);
		
		endTimeTextField = new JTextField();
		endTimeTextField.setColumns(10);
		endTimeTextField.setBounds(183, 235, 115, 20);
		contentPane.add(endTimeTextField);
		
		JLabel lblBranchId = new JLabel("Branch Id:");
		lblBranchId.setForeground(Color.LIGHT_GRAY);
		lblBranchId.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblBranchId.setBounds(45, 295, 138, 14);
		contentPane.add(lblBranchId);
		
		branchIdTextField = new JTextField();
		branchIdTextField.setColumns(10);
		branchIdTextField.setBounds(183, 292, 115, 20);
		contentPane.add(branchIdTextField);
		
		JButton addButton = new JButton("Add");
		addButton.setBackground(Color.LIGHT_GRAY);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				addBatch();
				Batch b1= new Batch();
	            b1.setVisible(true);
	            dispose();

	
			}
		});
		addButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		addButton.setBounds(286, 424, 115, 34);
		contentPane.add(addButton);
		
		JLabel lblAddSupplement = new JLabel("Add Batch");
		lblAddSupplement.setForeground(Color.LIGHT_GRAY);
		lblAddSupplement.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		lblAddSupplement.setBounds(281, 11, 138, 34);
		contentPane.add(lblAddSupplement);
		
		JButton backButton = new JButton("Back");
		backButton.setBackground(Color.LIGHT_GRAY);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Batch b1= new Batch();
	            b1.setVisible(true);
	            dispose();
	            
				
			}
		});
		backButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		backButton.setBounds(45, 424, 115, 34);
		contentPane.add(backButton);

		
		JLabel picture = new JLabel("");
		picture.setBounds(0, 0, 684, 492);
		contentPane.add(picture);
		Image image =new ImageIcon(this.getClass().getResource("/All1.jpg")).getImage();
		picture.setIcon(new ImageIcon(image));
		
	}
	
	public void addBatch() {
		

		try{
            //create  the connection object
            Connection con=DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521:orcl","gms","gms");
 
            
            String batchSql="insert into batch(batch_id, batch_name, starting_time, end_time, branch_id) values(?, ?, ?, ?, ?)";
            PreparedStatement pstmt=con.prepareStatement(batchSql);
            pstmt.setInt(1, Integer.parseInt(IdTextField.getText()));
            pstmt.setString(2, nameTextField.getText());
            pstmt.setString(3, startTimeTextField.getText());
            pstmt.setString(4, endTimeTextField.getText());
            pstmt.setInt(5, Integer.parseInt(branchIdTextField.getText()));
            
            int upd=pstmt.executeUpdate();
            if (upd==1)
            	JOptionPane.showMessageDialog(null, "Batch inserted Successfully");
            else
            	JOptionPane.showMessageDialog(null, "Error Occured");
            con.close();
            }
	 	catch(Exception e1){JOptionPane.showMessageDialog(null, e1);}
		
	}

}
