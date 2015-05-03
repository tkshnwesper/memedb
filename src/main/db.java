package main;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class db {
	Statement st;
	Connection connection;
	
	private String dbPath() {
		File classPath = new File(db.class.getResource("db.class").getPath());
		File iPath = classPath.getParentFile().getParentFile();
		String p1 = iPath.getPath().replace(File.separatorChar, '/');
		String path = p1 + "/db/meme.db.";
		return path;
	}
	
	private void dbInit() throws SQLException {
		connection = DriverManager.getConnection("jdbc:sqlite:" + dbPath());
		st = connection.createStatement();
		st.setQueryTimeout(30);

	}
	
	public void close() {
		try {
			if(connection != null) {
				connection.close();
			} 
		} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	
	public ResultSet query(String q) {
		ResultSet rs = null;
		try {
			rs = st.executeQuery(q);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public void destructiveQuery(String q) {
		try {
			st.executeUpdate(q);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public db() {
		try {
			dbInit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
