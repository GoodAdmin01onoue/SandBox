package ensyuP56;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ensyu2 {

	public static void main(String[] args) {
		Connection conn = null;
		ResultSet rs2 = null;

		Statement st = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost/companydb";
			String id = "root";
			String pass = "password";
			conn = DriverManager.getConnection(url, id, pass);

			// ステートメント
			st = conn.createStatement();
			//問2
			String sql2 = "SELECT NAME,AGE FROM addrbk WHERE ID = 1";

			rs2 = st.executeQuery(sql2);

			while (rs2.next()) {

				String addname = rs2.getString("NAME");
				int addage = rs2.getInt(2);

			System.out.println(addname +  addage);
			}

		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs2 != null)
					rs2.close();
				if (st != null)
					st.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
			}
		}

	}

}
