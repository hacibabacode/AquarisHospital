

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StuForm extends JFrame {

private JPanel contentPane;
private JTextField txtID;
private JTextField txtName;
private JTextField txtSurname;
private JTable table;


public ArrayList<Patients> getList(){
ArrayList<Patients> patients = new ArrayList<Patients>();
String db_path = "jdbc:mysql://localhost/aquariushospitalsystem?useSSL=false";

try {
Connection con = DriverManager.getConnection(db_path, "root","1998.anil");
Statement st = con.createStatement();
String query = "select * from personal";

ResultSet rs = st.executeQuery(query);

while(rs.next()){
Patients pth = new Patients();
pth.id = rs.getInt("idstudent");
pth.name = rs.getString("name");
pth.surname = rs.getString("surname");

patients.add(pth);

}
con.close();

} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}

return patients;
}




public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
StuForm frame = new StuForm();
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
public StuForm() {
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 429, 390);
contentPane = new JPanel();
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null);

JLabel lblStudentId = new JLabel("Student ID");
lblStudentId.setBounds(10, 23, 64, 14);
contentPane.add(lblStudentId);

txtID = new JTextField();
txtID.setBounds(84, 20, 27, 20);
contentPane.add(txtID);
txtID.setColumns(10);

JLabel lblName = new JLabel("Name");
lblName.setBounds(10, 58, 46, 14);
contentPane.add(lblName);

txtName = new JTextField();
txtName.setBounds(84, 51, 86, 20);
contentPane.add(txtName);
txtName.setColumns(10);

JLabel lblSurname = new JLabel("Surname");
lblSurname.setBounds(10, 83, 64, 14);
contentPane.add(lblSurname);

txtSurname = new JTextField();
txtSurname.setBounds(84, 82, 86, 20);
contentPane.add(txtSurname);
txtSurname.setColumns(10);

JScrollPane scrollPane = new JScrollPane();
scrollPane.setBounds(10, 189, 239, 151);
contentPane.add(scrollPane);

table = new JTable();
scrollPane.setViewportView(table);

final DefaultTableModel model = new DefaultTableModel();
model.setColumnIdentifiers(new String[]{"id","Name","Surname"});

table.setModel(model);

JButton btnSave = new JButton("Save");
btnSave.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {

String db_path = "jdbc:mysql://localhost/aquariushospitalsystem?useSSL=false";
Connection con;
try {

con = DriverManager.getConnection(db_path, "root","1998.anil");
Statement st = con.createStatement();


String query = String.format("insert into personal (idstudent, name, surname) values ('%d','%s','%s')",
Integer.parseInt(txtID.getText()),
txtName.getText(),
txtSurname.getText());
st.executeUpdate(query);
JOptionPane.showMessageDialog(null, "Student Saved");

} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}




}
});
btnSave.setBounds(81, 113, 89, 23);
contentPane.add(btnSave);

JButton btnGetList = new JButton("Get List / Refresh");
btnGetList.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {

final DefaultTableModel model = new DefaultTableModel();
model.setColumnIdentifiers(new String[]{"id","Name","Surname"});

for (Patients s : getList()) {
model.addRow(new String[]{String.valueOf(s.id),
 s.name,
 s.surname});

}
table.setModel(model);
}
});
btnGetList.setBounds(10, 155, 160, 23);
contentPane.add(btnGetList);
}
}