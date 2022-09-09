import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import com.toedter.calendar.JCalendar;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import com.toedter.calendar.JDateChooser;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class takeApptFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model=new DefaultTableModel();
	Object [] columns= {"DOCTOR","DAY","MONTH","YEAR","TIME"};
	Object [] row=new Object[20];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					takeApptFrame frame = new takeApptFrame();
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
	public takeApptFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DEPARTMENT :");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(27, 52, 120, 30);
		contentPane.add(lblNewLabel);
		
		JComboBox deptCombo = new JComboBox();
		
		deptCombo.setModel(new DefaultComboBoxModel(new String[] {"General Surgery", "Cardiology", "Orthopedics", "Physical Therapy", "Psychiatry"}));
		deptCombo.setFont(new Font("Dialog", Font.BOLD, 13));
		deptCombo.setBounds(171, 54, 155, 30);
		contentPane.add(deptCombo);
		
		JLabel lblDoctor = new JLabel("DOCTOR :");
		lblDoctor.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctor.setFont(new Font("Dialog", Font.BOLD, 14));
		lblDoctor.setBounds(27, 108, 120, 30);
		contentPane.add(lblDoctor);
		
		JComboBox drCombo = new JComboBox();
		drCombo.setBounds(171, 110, 155, 30);
		contentPane.add(drCombo);
		
		JButton showButton = new JButton("SHOW FREE APPOINTMENT");
		
		showButton.setFont(new Font("Dialog", Font.BOLD, 14));
		showButton.setBounds(57, 150, 252, 72);
		contentPane.add(showButton);
		
		table = new JTable();
		model.setColumnIdentifiers(columns);
		table.setBounds(60, 242, 788, 327);
		//contentPane.add(table);
		
		
		JButton btnNewButton = new JButton("COMPLETE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				dispose();
				mainFrame mf = new mainFrame();
				mf.setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 14));
		btnNewButton.setBounds(637, 581, 145, 41);
		contentPane.add(btnNewButton);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(472, 56, 192, 26);
		contentPane.add(dateChooser);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 234, 776, 335);
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(table);
		deptCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(deptCombo.getSelectedItem().equals("General Surgery")) {
					
					drCombo.removeAllItems();
					
					drCombo.addItem("Ares Yamaha");
					
					drCombo.addItem("Esma Aydın");
					
					drCombo.addItem("Rüveyda Cumbur");
					
				}
				else if(deptCombo.getSelectedItem().equals("Cardiology")) {
					
					drCombo.removeAllItems();
					
					drCombo.addItem("Atakan Güvencan Polat");
					
					drCombo.addItem("Esin Şahin");
					
					drCombo.addItem("Deniz Atasoy");
					
					
					
				}
				else if(deptCombo.getSelectedItem().equals("Orthopedics")) {
					drCombo.removeAllItems();
					
					drCombo.addItem("Gökcan Ulutaş");
					
					drCombo.addItem("Bartu Çoban");
					
					drCombo.addItem("Aslı Çakıcı");
					
				}
				else if(deptCombo.getSelectedItem().equals("Physical Therapy")) {
					
					drCombo.removeAllItems();
					
					drCombo.addItem("Melih Cansın Ercan");
					
					drCombo.addItem("Ayşenur Aydın");
					
					drCombo.addItem("Erol Egemen");
					
				}
				else if(deptCombo.getSelectedItem().equals("Psychiatry")) {
					drCombo.removeAllItems();
					
					drCombo.addItem("Edam Çevik");
					
					drCombo.addItem("Beyza Mutlu");
					
					drCombo.addItem("Sedat Ziyade");
					
				}
				
			}
		});
		showButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String doctor=String.valueOf(drCombo.getSelectedItem());
				DateFormat dayformat=new  SimpleDateFormat("dd");
				String day=dayformat.format(dateChooser.getDate());
				DateFormat monthformat=new SimpleDateFormat("MM");
				String month=monthformat.format(dateChooser.getDate());
				DateFormat yearformat=new SimpleDateFormat("yyyy");
				String year=yearformat.format(dateChooser.getDate());
				
				ResultSet rs=connection.showFreeAppt(doctor, day, month, year);
				
				model.setRowCount(0);
				try {
					while(rs.next()) {
						row[0]=rs.getString("doctor");
						row[1]=rs.getString("day");
						row[2]=rs.getString("month");
						row[3]=rs.getString("year");
						row[4]=rs.getString("apptTime");
						model.addRow(row);
					}
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				table.setModel(model);
				
				
			}
		});
	}
}
