package fr.esigelec.jee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;


public class DAO {
	
		private String url ="jdbc:mysql://localhost/stations?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		private String username = "countries";
		private String password = "javaee2020";

		Connection conn = null;
	
 public DAO() {
	 
	 
	}
	
 		public void connect() {
 			try {
 				conn = DriverManager.getConnection(url,username, password);
 			} catch (SQLException ex) {
 				System.out.println("Connection failed");
 				ex.printStackTrace();
		 		}
 				System.out.println("Connection established");;
			}
		public void close() {
			 if (conn != null) {
			 try {
			 conn.close();
			 } catch (SQLException ex) {
			 ex.printStackTrace();
			 }
			 }
			}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DAO A= new DAO();
		A.connect();
		
	}
		
}
