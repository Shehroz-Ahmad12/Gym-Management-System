package gms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Credits extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Credits frame = new Credits();
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
	public Credits() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		lblNewLabel.setBounds(100, 106, 93, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblRegNo = new JLabel("Reg. no:");
		lblRegNo.setForeground(Color.LIGHT_GRAY);
		lblRegNo.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		lblRegNo.setBounds(100, 156, 93, 33);
		contentPane.add(lblRegNo);
		
		JLabel lblClass = new JLabel("Class:");
		lblClass.setForeground(Color.LIGHT_GRAY);
		lblClass.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		lblClass.setBounds(100, 200, 93, 33);
		contentPane.add(lblClass);
		
		JLabel lblCourse = new JLabel("Course:");
		lblCourse.setForeground(Color.LIGHT_GRAY);
		lblCourse.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		lblCourse.setBounds(100, 244, 93, 33);
		contentPane.add(lblCourse);
		
		JLabel lblProjectName = new JLabel("Project Name:");
		lblProjectName.setForeground(Color.LIGHT_GRAY);
		lblProjectName.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		lblProjectName.setBounds(100, 288, 120, 33);
		contentPane.add(lblProjectName);
		
		JLabel lblCredits = new JLabel("CREDITS");
		lblCredits.setForeground(Color.LIGHT_GRAY);
		lblCredits.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		lblCredits.setBounds(288, 11, 141, 33);
		contentPane.add(lblCredits);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu m=new MainMenu();
				m.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		btnNewButton.setBounds(48, 419, 105, 33);
		contentPane.add(btnNewButton);
		
		JLabel lblShehrozAhmad = new JLabel("Shehroz Ahmad");
		lblShehrozAhmad.setForeground(Color.LIGHT_GRAY);
		lblShehrozAhmad.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		lblShehrozAhmad.setBounds(273, 106, 214, 33);
		contentPane.add(lblShehrozAhmad);
		
		JLabel lblSpbcs = new JLabel("SP19-BCS-032");
		lblSpbcs.setForeground(Color.LIGHT_GRAY);
		lblSpbcs.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		lblSpbcs.setBounds(273, 156, 214, 33);
		contentPane.add(lblSpbcs);
		
		JLabel lblBcsa = new JLabel("BCS-4A");
		lblBcsa.setForeground(Color.LIGHT_GRAY);
		lblBcsa.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		lblBcsa.setBounds(273, 200, 214, 33);
		contentPane.add(lblBcsa);
		
		JLabel lblDatabaseSystem = new JLabel("Database System");
		lblDatabaseSystem.setForeground(Color.LIGHT_GRAY);
		lblDatabaseSystem.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		lblDatabaseSystem.setBounds(273, 244, 214, 33);
		contentPane.add(lblDatabaseSystem);
		
		JLabel lblGymManagementSystem = new JLabel("Gym Management System");
		lblGymManagementSystem.setForeground(Color.LIGHT_GRAY);
		lblGymManagementSystem.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		lblGymManagementSystem.setBounds(273, 288, 214, 33);
		contentPane.add(lblGymManagementSystem);
		
	
		JLabel picture = new JLabel("");
		picture.setBounds(0, 0, 684, 492);
		contentPane.add(picture);
		Image image =new ImageIcon(this.getClass().getResource("/All1.jpg")).getImage();
		picture.setIcon(new ImageIcon(image));
		
	
	
	
	}
}
