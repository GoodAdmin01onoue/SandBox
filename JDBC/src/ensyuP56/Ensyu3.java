package ensyuP56;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ensyu3 {

	public static void main(String[] args) {
		Connection conn = null;
		ResultSet rs3 = null;
		Statement st = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost/companydb";
			String id = "root";
			String pass = "password";
			conn = DriverManager.getConnection(url, id, pass);

			// ステートメント
			st = conn.createStatement();
			//問3
			String sql3 = "SELECT NAME,TEL FROM addrbk";

			rs3 = st.executeQuery(sql3);

			//問1用
			while (rs3.next()) {

				String addname = rs3.getString("NAME");
				String addtel = rs3.getString("TEL");

			System.out.println(addname + addtel );
			}

		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs3 != null)
					rs3.close();
				if (st != null)
					st.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
			}
		}
	}

}
