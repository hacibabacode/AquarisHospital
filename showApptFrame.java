import java.awt.BorderLayout;
import java.awt.EventQueue;
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
 
public class showApptFrame extends JFrame {
 
             private JPanel contentPane;
             private JTable table;
 
             /**
             * Launch the application.
             */
             public static void main(String[] args) {
                           EventQueue.invokeLater(new Runnable() {
                                        public void run() {
                                                     try {
                                                    	 showApptFrame frame = new showApptFrame();
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
             public showApptFrame() {
             	setTitle("AQUARIUS APPOINTMENT SYSTEM");
                           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                           setBounds(100, 100, 800, 650);
                           contentPane = new JPanel();
                           contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                           setContentPane(contentPane);
                           contentPane.setLayout(null);
                          
                           JPanel panel = new JPanel();
                           panel.setBackground(new Color(230, 230, 250));
                           panel.setBounds(0, 0, 800, 650);
                           contentPane.add(panel);
                           panel.setLayout(null);
                          
                           table = new JTable();
                           table.setBounds(6, 6, 788, 513);
                           panel.add(table);
                          
                           JButton Backbtn = new JButton("BACK");
                           Backbtn.addActionListener(new ActionListener() {
                           	public void actionPerformed(ActionEvent e) {
                           		
                           		mainFrame ma = new mainFrame();
                        		ma.setVisible(true);
                        		dispose();
                           	}
                           });
                           Backbtn.setFont(new Font("Dialog", Font.BOLD, 14));
                           Backbtn.setBounds(574, 544, 150, 53);
                           panel.add(Backbtn);
             }
}