package RegisterLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConManager {
	// instanca same klase
		private static ConManager instance = null;

		// vrijednosti koje smo izabrali prilikom instalacije MySQL Servera
		private static final String USERNAME = "root";
		private static final String PASSWORD = "";
		// localhost//imeBazeNaKojuSeSpajamo
		private static final String CONN_STRING = "jdbc:mysql://localhost/registerinfo?useSSL=false&useLegacyTimedateCode=false&serverTimezone=UTC";

		// connection object
		private Connection connection = null;

		// privatni konstruktor - klasa moze biti instancirana samo unutar sebe
		private ConManager() {

		}

		// provjeriti da li je instanca null, instancirati i vratiti ili samo vratiti
		public static ConManager getInstance() {
			if (instance == null) {
				instance = new ConManager();
			}
			return instance;
		}

		private boolean openConnection() {
			try {
				connection = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
				System.out.println("Yeeeeeeeees");
				return true;
			} catch (SQLException e) {
				System.err.println(e);
				return false;
			}
		}

		public Connection getConnection() {
			if (connection == null) {
				if (openConnection()) {
					
					return connection;
				} else {
					return null;
				}
			}
			return connection;
		}

		public void close() {
			
			try {
				connection.close();
				connection = null;
			} catch (Exception e) {
			}
		}
}
