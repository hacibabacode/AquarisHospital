import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

public class ForgetPassFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nameTxtField;
	private JTextField surnameTxtField;
	private JTextField idTextField;
	private JPasswordField newPassPassField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgetPassFrame frame = new ForgetPassFrame();
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
	public ForgetPassFrame() {
		setTitle("AQUARIUS APPOINTMENT SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nameTxtField = new JTextField();
		nameTxtField.setFont(new Font("Dialog", Font.PLAIN, 14));
		nameTxtField.setBounds(242, 59, 155, 31);
		contentPane.add(nameTxtField);
		nameTxtField.setColumns(10);
		
		JLabel nameLabel = new JLabel("NAME :");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setToolTipText("");
		nameLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		nameLabel.setBounds(103, 59, 127, 31);
		contentPane.add(nameLabel);
		
		surnameTxtField = new JTextField();
		surnameTxtField.setFont(new Font("Dialog", Font.PLAIN, 14));
		surnameTxtField.setBounds(242, 102, 155, 31);
		contentPane.add(surnameTxtField);
		surnameTxtField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("SURNAME :");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(103, 102, 127, 31);
		contentPane.add(lblNewLabel);
		
		idTextField = new JTextField();
		idTextField.setFont(new Font("Dialog", Font.PLAIN, 14));
		idTextField.setBounds(242, 146, 155, 31);
		contentPane.add(idTextField);
		idTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("PERSONAL ID :");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(103, 145, 127, 31);
		contentPane.add(lblNewLabel_1);
		
		newPassPassField = new JPasswordField();
		newPassPassField.setBounds(242, 189, 155, 31);
		contentPane.add(newPassPassField);
		
		JLabel newPassLabel = new JLabel("NEW PASWORD :");
		newPassLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		newPassLabel.setHorizontalAlignment(SwingConstants.CENTER);
		newPassLabel.setBounds(103, 188, 127, 31);
		contentPane.add(newPassLabel);
		
		JButton saveButton = new JButton("SAVE");
		
		saveButton.setFont(new Font("Dialog", Font.BOLD, 14));
		saveButton.setBounds(187, 240, 138, 49);
		contentPane.add(saveButton);
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sql_ask,name,surname,id,newpass;
				name=nameTxtField.getText();
				surname=surnameTxtField.getText();
				id=idTextField.getText();
				newpass=String.valueOf(newPassPassField.getPassword());
				
				sql_ask="UPDATE personalInformation SET password='"+ newpass+"'  WHERE name = '"+name+"' and "+"  surname="+"'"+surname+"'and"+" personalid='"+
				id+"'";
				
					System.out.println(sql_ask);
					connection.forgetpass(sql_ask);
					dispose();
					loginFrame frame=new loginFrame();
					frame.setVisible(true);
				
				
				
						
					}
		
				
					
				
				
				
			
		
	});
}
}
