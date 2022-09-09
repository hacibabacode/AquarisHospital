import java.awt.BorderLayout;
import java.awt.EventQueue;
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
 
public class addAmountFrame extends JFrame {
 
             private JPanel contentPane;
             private JTextField txtAmount;
             private JTextField txtBankNum;
 
             /**
             * Launch the application.
             */
             public static void main(String[] args) {
                           EventQueue.invokeLater(new Runnable() {
                                        public void run() {
                                                     try {
                                                                  addAmountFrame frame = new addAmountFrame();
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
             public addAmountFrame() {
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
                          
                           txtAmount = new JTextField();
                           txtAmount.setFont(new Font("Dialog", Font.PLAIN, 14));
                           txtAmount.setBounds(270, 104, 155, 30);
                           panel.add(txtAmount);
                           txtAmount.setColumns(10);
                          
                           txtBankNum = new JTextField();
                           txtBankNum.setFont(new Font("Dialog", Font.PLAIN, 14));
                           txtBankNum.setBounds(270, 159, 155, 30);
                           panel.add(txtBankNum);
                           txtBankNum.setColumns(10);
                          
                           JButton Addbtn = new JButton("ADD");
                           Addbtn.setFont(new Font("Dialog", Font.BOLD, 14));
                           Addbtn.setBounds(201, 220, 165, 49);
                           panel.add(Addbtn);
                          
                           JLabel LabelAmount = new JLabel("QUANTITY :");
                           LabelAmount.setHorizontalAlignment(SwingConstants.CENTER);
                           LabelAmount.setFont(new Font("Dialog", Font.BOLD, 14));
                           LabelAmount.setBounds(135, 103, 123, 30);
                           panel.add(LabelAmount);
                          
                           JLabel LabelBankNum = new JLabel("BANK NUMBER :");
                           LabelBankNum.setHorizontalAlignment(SwingConstants.CENTER);
                           LabelBankNum.setFont(new Font("Dialog", Font.BOLD, 14));
                           LabelBankNum.setBounds(135, 158, 123, 30);
                           panel.add(LabelBankNum);
             }
 
}