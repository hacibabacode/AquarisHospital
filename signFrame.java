import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.sql.*;

public class signFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tf_name;
	private JTextField tf_surname;
	private JTextField tf_id;
	private JPasswordField passwordField;
	private JTextField bankNoTxt;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signFrame frame = new signFrame();
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
	public signFrame() {
		setTitle("AQUARIUS APPOINTMENT SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 460);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nameLbl = new JLabel("NAME :");
		nameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		nameLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		nameLbl.setBounds(6, 24, 147, 35);
		contentPane.add(nameLbl);
		
		JLabel surLbl = new JLabel("SURNAME :\n");
		surLbl.setHorizontalAlignment(SwingConstants.CENTER);
		surLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		surLbl.setBounds(6, 71, 147, 35);
		contentPane.add(surLbl);
		
		JLabel idLbl = new JLabel("PERSONAL ID :");
		idLbl.setHorizontalAlignment(SwingConstants.CENTER);
		idLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		idLbl.setBounds(6, 118, 147, 35);
		contentPane.add(idLbl);
		
		tf_name = new JTextField();
		tf_name.setFont(new Font("Dialog", Font.PLAIN, 14));
		tf_name.setBounds(165, 27, 168, 30);
		contentPane.add(tf_name);
		tf_name.setColumns(10);
		
		tf_surname = new JTextField();
		tf_surname.setFont(new Font("Dialog", Font.PLAIN, 14));
		tf_surname.setBounds(165, 74, 168, 30);
		contentPane.add(tf_surname);
		tf_surname.setColumns(10);
		
		tf_id = new JTextField();
		tf_id.setFont(new Font("Dialog", Font.PLAIN, 14));
		tf_id.setBounds(165, 121, 168, 30);
		contentPane.add(tf_id);
		tf_id.setColumns(10);
		
		JLabel passLbl = new JLabel("PASSWORD :");
		passLbl.setHorizontalAlignment(SwingConstants.CENTER);
		passLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		passLbl.setBounds(16, 171, 137, 35);
		contentPane.add(passLbl);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Dialog", Font.PLAIN, 14));
		passwordField.setBounds(165, 174, 168, 30);
		contentPane.add(passwordField);
		
		JLabel genLbl = new JLabel("GENDER :");
		genLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		genLbl.setHorizontalAlignment(SwingConstants.CENTER);
		genLbl.setBounds(6, 218, 147, 35);
		contentPane.add(genLbl);
		
		JLabel bankLbl = new JLabel("BANK NUMBER :");
		bankLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		bankLbl.setHorizontalAlignment(SwingConstants.CENTER);
		bankLbl.setBounds(24, 265, 129, 35);
		contentPane.add(bankLbl);
		
		bankNoTxt = new JTextField();
		bankNoTxt.setFont(new Font("Dialog", Font.PLAIN, 14));
		bankNoTxt.setBounds(165, 268, 168, 30);
		contentPane.add(bankNoTxt);
		bankNoTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("SIGN UP");
		
				
		
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 14));
		btnNewButton.setBounds(123, 340, 130, 45);
		contentPane.add(btnNewButton);
		
		JRadioButton rdbtnFemale = new JRadioButton("FEMALE");
		rdbtnFemale.setFont(new Font("Dialog", Font.BOLD, 14));
		rdbtnFemale.setBounds(160, 224, 114, 23);
		contentPane.add(rdbtnFemale);
		
		JRadioButton rdbtnMale = new JRadioButton("MALE");
		rdbtnMale.setFont(new Font("Dialog", Font.BOLD, 14));
		rdbtnMale.setBounds(271, 224, 96, 23);
		contentPane.add(rdbtnMale);
		ButtonGroup gender = new ButtonGroup();
        gender.add(rdbtnMale);
        gender.add(rdbtnFemale);
        btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				


                 String gender ="";
                 if(rdbtnMale.isSelected()){
                 gender="Male";
                 }
                 else if(rdbtnFemale.isSelected()){
                 gender="Female";
                 }
				String name,surname,password,sql_ask,
				id,bankno;
				
				name=tf_name.getText();
				surname=tf_surname.getText();
				password=(passwordField.getText());
				id=(tf_id.getText());
				bankno=(bankNoTxt.getText());
				sql_ask="insert into personalİnformation (personalid,name,surname,password,gender,bankNo) VALUES "
						+ "("+"'"+id+"',"+"'"+name+"',"+"'"+surname+"',"+"'"+password+"',"+"'"+gender+"',"+"'"+bankno+"'"+")";
				System.out.println(sql_ask);
				connection.ekle(sql_ask);
				 
				loginFrame log = new loginFrame();
				log.setVisible(true);
				dispose();
				
			}

			
		});
        
	}
}
