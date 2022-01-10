
package connection;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBExample {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"
		String dbUrl = "jdbc:mysql://localhost:3306/sakila"; // Database Username
		//String dbUrl1 = "jdbc:mysql://localhost:3306/sakila";
		
		String username = "root";
//Database Password
		String password = "root"; // Query to Execute
		//String query = "SELECT * FROM customer;";
		String query="select * from actor where first_name='Nick';";
//Load mysql jdbc driver
		Class.forName("com.mysql.jdbc.Driver");
//Create Connection to DB
		Connection con = DriverManager.getConnection(dbUrl, username, password);
//Create Statement Object
		Statement stmt = con.createStatement();
// Execute the SQL Query. Store results in ResultSet
		ResultSet rs = stmt.executeQuery(query);
// While Loop to iterate through all data and print results
		while (rs.next()) {
			/*
			 * String mem_number = rs.getString(1); String fullName = rs.getString(2);
			 * String DOB = rs.getString(4); String Address = rs.getString(5);
			 * System.out.println(mem_number + " " + fullName + " " + DOB);
			 * System.out.println("*********************"); System.out.println(Address);
			 */
			String actorId=rs.getString(1);
			String fistName=rs.getString(2);
			System.out.println(actorId+ " "+fistName);
			System.out.println("*********************");
			
		
		}
// closing DB Connection
		con.close();
	}
}
