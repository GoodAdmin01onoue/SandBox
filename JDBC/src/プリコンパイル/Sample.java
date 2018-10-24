package プリコンパイル;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Sample {

	public static void main(String[] args) {

		int newID[] = { 1, 2, 3, 4, 5 };
		String newName[] = { "高橋", "渡辺", "伊藤", "山本", "中村" };

		String url = "jdbc:mysql://localhost/lesson2018";
		String id = "root";
		String pw = "password";
		Connection cnct = null;
		PreparedStatement pst = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url, id, pw);
			String query = "INSERT INTO person (id,name) VALUES (?,?)";

			 pst = cnct.prepareStatement(query);

			 for (int i = 0; i < newID.length; i++) {
				pst.setInt(1, newID[i]);
				pst.setString(2, newName[i]);
				pst.executeUpdate();
			}

		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (cnct != null)
					cnct.close();
			} catch (Exception ex) {
			}
		}
	}
}
