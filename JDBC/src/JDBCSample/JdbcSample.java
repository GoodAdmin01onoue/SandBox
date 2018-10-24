package JDBCSample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcSample {

	public static void main(String[] args) {

		Connection conn = null;
		ResultSet rs = null;
		Statement st = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost/lesson2018";
			String id = "root";
			String pass = "password";
			conn = DriverManager.getConnection(url, id, pass);

			// ステートメント
			st = conn.createStatement();

			String sql = "SELECT * FROM item";

			rs = st.executeQuery(sql);

			while (rs.next()) {
				// itemテーブルのidsをget
				int ids = rs.getInt(1);
				String name = rs.getString("name");
				int price = rs.getInt(3);
				System.out.println(ids + name + price );
			}

		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
			}
		}
	}
}
