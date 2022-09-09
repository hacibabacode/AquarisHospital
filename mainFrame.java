import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;

public class mainFrame extends JFrame {

private JPanel contentPane;

/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
mainFrame frame = new mainFrame();
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
public mainFrame() {
setTitle("AQUARIUS APPOINTMENT SYSTEM");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 560, 395);
contentPane = new JPanel();
contentPane.setBackground(new Color(230, 230, 250));
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null);

JButton btnNewButton = new JButton("ADD APPOINTMENT");
btnNewButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
	
	takeApptFrame app = new takeApptFrame();
	app.setVisible(true);
	dispose();
	
	
}
});
btnNewButton.setFont(new Font("Dialog", Font.BOLD, 14));
btnNewButton.setBounds(166, 87, 217, 36);
contentPane.add(btnNewButton);

JButton btnNewButton_1 = new JButton("SHOW APPOINTMENT");
btnNewButton_1.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		
		showApptFrame show = new showApptFrame();
		show.setVisible(true);
		dispose();
	}
});
btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 14));
btnNewButton_1.setBounds(166, 135, 217, 36);
contentPane.add(btnNewButton_1);

JButton btnNewButton_2 = new JButton("DELETE APPOINTMENT");
btnNewButton_2.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		
		deleteApptFrame del = new deleteApptFrame();
		del.setVisible(true);
		dispose();
	}
});
btnNewButton_2.setFont(new Font("Dialog", Font.BOLD, 14));
btnNewButton_2.setBounds(166, 183, 217, 38);
contentPane.add(btnNewButton_2);

JButton btnNewButton_3 = new JButton("AMOUNT OPERATION");
btnNewButton_3.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent e) {
	
	amountFrame amo = new amountFrame();
	amo.setVisible(true);
	dispose();
}
});
btnNewButton_3.setFont(new Font("Dialog", Font.BOLD, 14));
btnNewButton_3.setBounds(166, 233, 217, 38);
contentPane.add(btnNewButton_3);

JButton btnNewButton_4 = new JButton("EXIT");
btnNewButton_4.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		
		
		System.exit(0);
	}
});
btnNewButton_4.setFont(new Font("Dialog", Font.BOLD, 14));
btnNewButton_4.setBounds(227, 298, 95, 36);
contentPane.add(btnNewButton_4);

JLabel Welcome = new JLabel("WELCOME TO AQUARIUS HOSPITAL");
Welcome.setFont(new Font("Dialog", Font.BOLD, 14));
Welcome.setBounds(141, 26, 285, 27);
contentPane.add(Welcome);
}
}