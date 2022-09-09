import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class amountFrame extends JFrame {

private JPanel contentPane;

/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
amountFrame frame = new amountFrame();
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
public amountFrame() {
	setTitle("AQUARIUS APPOINTMENT SYSTEM");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 560, 400);
contentPane = new JPanel();
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null);

JPanel panel = new JPanel();
panel.setBackground(new Color(230, 230, 250));
panel.setBounds(0, 0, 560, 378);
contentPane.add(panel);
panel.setLayout(null);

JLabel txtAmount = new JLabel("YOUR AMOUNT :");
txtAmount.setHorizontalAlignment(SwingConstants.CENTER);
txtAmount.setFont(new Font("Dialog", Font.BOLD, 14));
txtAmount.setBounds(84, 102, 148, 30);
panel.add(txtAmount);

JButton btnAddAmount = new JButton("ADD AMOUNT");
btnAddAmount.setFont(new Font("Dialog", Font.BOLD, 14));
btnAddAmount.setBounds(84, 205, 165, 35);
panel.add(btnAddAmount);

JButton btnBack = new JButton("BACK");
btnBack.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		
		mainFrame mai = new mainFrame();
		mai.setVisible(true);
		dispose();
	}
});
btnBack.setFont(new Font("Dialog", Font.BOLD, 14));
btnBack.setBounds(292, 205, 165, 35);
panel.add(btnBack);
JLabel ammountLabel = new JLabel("");
ammountLabel.setFont(new Font("Dialog", Font.BOLD, 14));
ammountLabel.setBounds(244, 102, 118, 30);
panel.add(ammountLabel);
}
}