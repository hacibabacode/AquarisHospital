import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class deleteApptFrame extends JFrame {

private JPanel contentPane;
private JTable table;

/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
	deleteApptFrame frame = new deleteApptFrame();
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
public deleteApptFrame() {
	setTitle("AQUARIUS APPOINTMENT SYSTEM");
	setBackground(new Color(230, 230, 250));
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 800, 650);
contentPane = new JPanel();
contentPane.setBackground(new Color(230, 230, 250));
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null);

JButton btnNewButton = new JButton("DELETE");
btnNewButton.setFont(new Font("Dialog", Font.BOLD, 14));
btnNewButton.setBounds(413, 562, 165, 35);
contentPane.add(btnNewButton);

JButton btnNewButton_1 = new JButton("BACK");
btnNewButton_1.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		
		mainFrame ma = new mainFrame();
		ma.setVisible(true);
		dispose();
	}
});
btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 14));
btnNewButton_1.setBounds(609, 562, 165, 35);
contentPane.add(btnNewButton_1);

table = new JTable();
table.setBounds(6, 6, 788, 547);
contentPane.add(table);
}
}