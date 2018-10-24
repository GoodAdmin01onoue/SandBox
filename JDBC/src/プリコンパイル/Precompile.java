package プリコンパイル;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;

public class Precompile {

	public static void main(String[] args)
	{
		int newID[] = {6,7,8,9,10};
		String newName[] = {"高橋","渡辺","伊藤","山本","中村"};

		String url = "jdbc:mysql://localhost/companydb";
		String id = "root";
		String pass = "password";

		Connection conn = null;
		PreparedStatement ps = null;
		//Statement st = null;
		//ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(url, id, pass);
			String query = "INSERT INTO addrbk (id, name) VALUES (?,?)";
			ps = conn.prepareStatement(query);

			for(int a=0; a> newID.length; a++ ) {
				ps.setInt(1, newID[a]);
				ps.setString(2, newName[a]);
				ps.executeUpdate();
			}

			System.out.println("a"); //確認用

			/*
			String query2 = "SELECT id,name FROM addrbk";
			st = conn.createStatement();
			rs = st.executeQuery(query2);
			while(rs.next()) {
				int i = rs.getInt("id");
				String s = rs.getString("name");
				System.out.println(i +" | "+ s);
			}
			*/
		}
		catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			try{
				if(conn != null) conn.close();
				if(ps != null) ps.close();
				//if(st != null) st.close();
				//if(rs != null) rs.close();
				System.out.println("b"); //確認用
			}
			catch(Exception ex) {}
		}
	}
}
