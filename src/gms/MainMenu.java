package gms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;

public class MainMenu extends JFrame {
	
	private JPanel contentPane;
	private JTextField idTextField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
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
	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setLayout(null);
		
		
		JButton branchButton = new JButton("Branches & Equipment");
		branchButton.setBackground(Color.LIGHT_GRAY);
		branchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Branch b1=new Branch();
				b1.setVisible(true);
				dispose();
			}
		});
		branchButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		branchButton.setBounds(26, 197, 227, 32);
		contentPane.add(branchButton);
		
		JButton batchButton = new JButton("Batches");
		batchButton.setBackground(Color.LIGHT_GRAY);
		batchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Batch b2 =new Batch();
				b2.setVisible(true);
				dispose();
			}
		});
		batchButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		batchButton.setBounds(26, 250, 227, 32);
		contentPane.add(batchButton);
		
		JButton memberButton = new JButton("Members");
		memberButton.setBackground(Color.LIGHT_GRAY);
		memberButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Member m1=new Member();
				m1.setVisible(true);
				dispose();
			}
		});
		memberButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		memberButton.setBounds(26, 357, 227, 32);
		contentPane.add(memberButton);
		
		JButton trainerButton = new JButton("Trainers & Salaries");
		trainerButton.setBackground(Color.LIGHT_GRAY);
		trainerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Trainer t1=new Trainer();
				t1.setVisible(true);
				dispose();
			}
		});
		trainerButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		trainerButton.setBounds(26, 304, 227, 32);
		contentPane.add(trainerButton);
		
		JButton supplementButton = new JButton("Supplements");
		supplementButton.setBackground(Color.LIGHT_GRAY);
		supplementButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Supplement s1=new Supplement();
				s1.setVisible(true);
				dispose();
			}
		});
		supplementButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		supplementButton.setBounds(426, 196, 227, 32);
		contentPane.add(supplementButton);
		
		JLabel lblNewLabel = new JLabel("Main Menu");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(SystemColor.control);
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 30));
		lblNewLabel.setBounds(245, 37, 198, 60);
		contentPane.add(lblNewLabel);
		
		JButton Adminbtn = new JButton("Admin");
		Adminbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AdminDetail a=new AdminDetail();
				a.setVisible(true);
				dispose();
				
			}
		});
		Adminbtn.setBackground(Color.LIGHT_GRAY);
		Adminbtn.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		Adminbtn.setBounds(426, 250, 227, 32);
		contentPane.add(Adminbtn);
		
		JButton logoutButton = new JButton("Logout");
		logoutButton.setBackground(Color.LIGHT_GRAY);
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l1=new Login();
				l1.setVisible(true);
				dispose();
			
			}
		});
		logoutButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		logoutButton.setBounds(426, 310, 227, 32);
		contentPane.add(logoutButton);
		
		JButton CreditsButton = new JButton("Credits");
		CreditsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Credits cr=new Credits();
				cr.setVisible(true);
				dispose();
			}
		});
		CreditsButton.setBackground(Color.LIGHT_GRAY);
		CreditsButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		CreditsButton.setBounds(426, 363, 227, 32);
		contentPane.add(CreditsButton);
		
		JLabel pictureLable = new JLabel("");
		pictureLable.setBounds(0, 0, 684, 481);
		contentPane.add(pictureLable);
		Image image =new ImageIcon(this.getClass().getResource("/MainMenu.jpg")).getImage();
		pictureLable.setIcon(new ImageIcon(image));
		

	}
}
