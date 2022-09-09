import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Window.Type;

public class frame1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame1 frame = new frame1();
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
	public frame1() {
		setTitle("AQUARIUS APPOINTMENT SYSTEM");
		setBackground(new Color(230, 230, 250));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton logBut = new JButton("LOG IN");
		logBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				loginFrame log = new loginFrame();
				log.setVisible(true);
				dispose();
			
			}
		});
		
		logBut.setFont(new Font("Dialog", Font.BOLD, 14));

		logBut.setBounds(161, 50, 133, 56);
		contentPane.add(logBut);
		
		JButton signBut = new JButton("SIGN IN\n");
		signBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				signFrame s = new signFrame();
				s.setVisible(true);
				dispose();
				
			}
		});
		signBut.setFont(new Font("Dialog", Font.BOLD, 14));
		signBut.setBounds(161, 144, 133, 56);
		contentPane.add(signBut);
	}
}
