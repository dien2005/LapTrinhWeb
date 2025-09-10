package duonghao.hht.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLConnection {
	private final String serverName = "DUONGHAO-LOQ";

	private final String dbName = "LapTrinhWeb";

	private final String portNumber = "1433";

	private final String instance = "";

	private final String userID = "sa";

	private final String password = "kimdien2005";

	public Connection getConnection() throws Exception {
		String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName
				+ ";encrypt=true;trustServerCertificate=true;";

		if (instance == null || instance.trim().isEmpty())

			url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "; databaseName=" + dbName;

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		return DriverManager.getConnection(url, userID, password);
	}

}
