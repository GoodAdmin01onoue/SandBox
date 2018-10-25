package トランザクション;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class trans {

	public static void main(String[] args) throws SQLException {

		int newID[] = { 11, 12, 13, 14};
		String newName[] = { "佐々木", "斎藤", "山口", "松本"};

		String url = "jdbc:mysql://localhost/lesson2018";
		String id = "root";
		String pw = "password";
		Connection cnct = null;
		PreparedStatement pst = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url, id, pw);

			//トランザクション開始
			cnct.setAutoCommit(false);
			String query = "INSERT INTO human (id,name) VALUES (?,?)";


			pst = cnct.prepareStatement(query);

			for (int i = 0; i < newID.length; i++) {
				pst.setInt(1, newID[i]);
				pst.setString(2, newName[i]);
				pst.executeUpdate();
			}
			//for文を実行したらcommitする。
			cnct.commit();
			System.out.println("コミットしました。");
			System.out.println("helloworld");
			System.out.println("いえーい");
			System.out.println("a");


		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();

			cnct.rollback();
			System.out.println("ロールバックしました。");

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
