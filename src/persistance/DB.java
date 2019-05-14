package persistance;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

	public static Connection connection=null;
	
	private DB() {

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/soundex_levenshtein_contacts?serverTimezone=UTC", "root", "");
		}
		catch(Exception e){
			e.printStackTrace();
		}
			
	}
	
	public static Connection getConection() {
		if(connection==null) {
			new DB();
		}
		return connection;
	}

}
