package vn.duonghao.config;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;

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

//	public static void main(String[] args) {
//
//		String sqlInsert = "INSERT INTO Users VALUES(?, ?, ?)";
//		String selectAll = "SELECT * FROM Users";
//
//		try (Connection conn = new SQLConnection().getConnection()) {
//			// insert GiaoVien
//			try (PreparedStatement stmt = conn.prepareStatement(sqlInsert)) {
//				stmt.setInt(1, 9);
//				stmt.setString(2, "Nguyen Kim Dien");
//				stmt.setString(3, "tp.ThuDuc");
//				stmt.executeUpdate();
//			}
//
//			// select all GiaoVien
//			try (PreparedStatement stmt = conn.prepareStatement(selectAll); ResultSet rs = stmt.executeQuery()) {
//
//				while (rs.next()) {
//					System.out.println(rs.getInt("ID") + " " + rs.getString("Name") + " " + rs.getString("Address"));
//				}
//			}
//
//		} catch (Exception e) {
//			System.out.println(e);
//
//		}
//
//	}
}