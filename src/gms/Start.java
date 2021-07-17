package gms;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Start {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start window = new Start();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Start() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.BLACK);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 520, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JButton start = new JButton("Start");
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login lg=new Login();
				lg.setVisible(true);
				frame.dispose();
			}
		});
		start.setBackground(Color.LIGHT_GRAY);
		start.setForeground(new Color(51, 51, 51));
		start.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		start.setBounds(148, 360, 179, 54);
		frame.getContentPane().add(start);
		
		JLabel lblNewLabel = new JLabel("Gym Management System");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 24));
		lblNewLabel.setBounds(84, 60, 353, 47);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblGms = new JLabel("(GMS)");
		lblGms.setForeground(Color.LIGHT_GRAY);
		lblGms.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		lblGms.setBounds(207, 94, 67, 47);
		frame.getContentPane().add(lblGms);
		
		JLabel lblMadeBy = new JLabel("Made By");
		lblMadeBy.setForeground(Color.LIGHT_GRAY);
		lblMadeBy.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		lblMadeBy.setBounds(191, 177, 109, 47);
		frame.getContentPane().add(lblMadeBy);
		
		JLabel lblShehrozAhmad = new JLabel("Shehroz Ahmad");
		lblShehrozAhmad.setForeground(Color.LIGHT_GRAY);
		lblShehrozAhmad.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		lblShehrozAhmad.setBounds(148, 223, 189, 47);
		frame.getContentPane().add(lblShehrozAhmad);
		
		JLabel lblSpbcs = new JLabel("SP19-BCS-032");
		lblSpbcs.setForeground(Color.LIGHT_GRAY);
		lblSpbcs.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		lblSpbcs.setBounds(162, 268, 175, 47);
		frame.getContentPane().add(lblSpbcs);
		
		JLabel picture = new JLabel("");
		picture.setBounds(0, 0, 684, 511);
		frame.getContentPane().add(picture);
		Image image =new ImageIcon(this.getClass().getResource("/All1.jpg")).getImage();
		picture.setIcon(new ImageIcon(image));
		
	}
}
