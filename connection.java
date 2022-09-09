
import java.sql.*;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import sun.security.util.Password;




public class connection {
	
	 static Connection Con;
	 static Statement Stat;
	
	public static boolean personalenter(String id,String password) {
		ResultSet Rs =null;
		
		try {	
			Con = (Connection) DriverManager.getConnection
					("jdbc:mysql://localhost:3306/aquariushospitalsystem?useSSL=false&serverTimezone=Turkey","root","1998.anil");
			
			Stat = (Statement)Con.createStatement();
			Rs=Stat.executeQuery("select * from personaýnformation where personalid='"+id+"' and password='"+password+"'");
			
			while(Rs.next()) {
				String currentid;
				String currentpassword;
				currentid=Rs.getString("personalid");
				
				currentpassword=Rs.getString("password");
				if(id.equals(currentid)&&password.equals(currentpassword)) {
				return true;}
				
				
				
				else {
					System.out.println("a");
				return false;
				
				}
			
			
			
			}} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
			
			
		}
		return false;
		
		
	}
	
	public static void forgetpass(String sql_ask ) {
		
		
		
			try {
				Con = (Connection) DriverManager.getConnection
						("jdbc:mysql://localhost:3306/aquariushospitalsystem?useSSL=false&serverTimezone=Turkey","root","1998.anil");
				Stat = (Statement)Con.createStatement();
				Stat.executeUpdate(sql_ask);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(null,"Wrong");
				
				
			}
			
		}
		
	
	
	public static void ekle(String sql_ask) {
		
		try {
			Con = (Connection) DriverManager.getConnection
					("jdbc:mysql://localhost:3306/aquariushospitaltsystem?useSSL=false&serverTimezone=Turkey","root","1998.anil");
			Stat = (Statement)Con.createStatement();
			Stat.executeUpdate(sql_ask);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void update(String sql_sorgu) {
		try {
			Stat.executeUpdate(sql_sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void sil(String sql_sorgu) {
		try {
			Stat.executeUpdate(sql_sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static ResultSet sorgula(String sql_sorgu) {
		ResultSet Rs = null;		
		try {			
			Rs = Stat.executeQuery(sql_sorgu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Rs;
	}

	public static ResultSet showFreeAppt(String doctor, String day, String month, String year) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		try {
			Con = (Connection) DriverManager.getConnection
					("jdbc:mysql://localhost:3306/aquariushospitalsystem?useSSL=false&serverTimezone=Turkey","root","1998.anil");
			Stat = (Statement)Con.createStatement();
			rs=Stat.executeQuery("select * from doctorAppt where doctor='"+doctor+"' and day='"+day+"' and month='"+month+
					"' and year='"+year+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}

}
