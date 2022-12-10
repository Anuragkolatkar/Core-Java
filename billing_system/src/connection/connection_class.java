package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class connection_class {
	Connection cm;
	Statement stm;

	public connection_class() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cm = DriverManager.getConnection("Jdbc:mysql://localhost:3306/billing", "root", "");
			stm = cm.createStatement();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static void main(String[] args) {
		new connection_class();
	}

}
