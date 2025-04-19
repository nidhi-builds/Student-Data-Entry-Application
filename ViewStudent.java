import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewStudent {
    public static void viewStudent() {
        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            System.out.println("---- Student List ----");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id")
                        + ", Name: " + rs.getString("name")
                        + ", Email: " + rs.getString("email"));
            }

            conn.close();
        } catch (Exception e) {
            System.out.println("Error retrieving student records: " + e.getMessage());
        }
    }
}

