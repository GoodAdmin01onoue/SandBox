package ensyuP56;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ensyu1 {

	public static void main(String[] args) {


		Connection conn = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
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
			//問1
			String sql1 = "SELECT * FROM addrbk WHERE ID = 5";
			//問2
			String sql2 = "SELECT NAME,AGE FROM addrbk WHERE ID = 1";
			//問3
			String sql3 = "SELECT NAME,TEL FROM addrbk";

			rs1 = st.executeQuery(sql1);
			rs2 = st.executeQuery(sql2);
			rs3 = st.executeQuery(sql3);

			//問1用
			while (rs1.next()) {

				int addid = rs1.getInt(1);
				String addname = rs1.getString("NAME");
				String addgender = rs1.getString("GENDER");
				int addage = rs1.getInt(4);
				String adddept = rs1.getString("DEPT");
				String addaddress = rs1.getString("ADDRESS");
				String addtel = rs1.getString("TEL");

			System.out.println(addid + addname + addgender + addage + adddept + addaddress + addtel );
			}

		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs1 != null)
					rs1.close();
				if (rs2 != null)
					rs2.close();
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
