package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DB_connection {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection conn;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url = "jdbc:sqlserver://DESKTOP-VQ2LU6L\\\\SQLEXPRESS:1433;databaseName=FPL_DaoTao;user=sa;password=yenlhph19202";
		conn = DriverManager.getConnection(url);
		if(conn != null) {
			System.out.println("ket noi thanh cong");
		}
		
		
	}
	
	
	public Connection connect () throws ClassNotFoundException, SQLException {
		Connection conn;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url = "jdbc:sqlserver://DESKTOP-VQ2LU6L\\\\SQLEXPRESS:1433;databaseName=FPL_DaoTao;user=sa;password=yenlhph19202";
		conn = DriverManager.getConnection(url);
		if(conn != null) {
//			System.out.println("ket noi thanh cong");
			return conn;
		}else {
			JOptionPane.showMessageDialog(null, "Ket noi that bai");
		}
		return null;
	}
}