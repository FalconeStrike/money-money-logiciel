
import java.sql.*;

public class Methodes {

	static void connectionBdd() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_bancaire", "root",
					"ondine");
			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery("SELECT * FROM Banque");
			while (rs.next()) {
				rs.getString(2);
				System.out.println(rs.getString(2));
			}
			;
			conn.close();
		} catch (SQLException e) {
			System.out.println("Class not found");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
		}
	}

}
