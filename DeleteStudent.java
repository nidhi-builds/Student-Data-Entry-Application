import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteStudent {
    public static void deleteStudent() {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Student ID to Delete: ");
            int id = sc.nextInt();

            Connection conn = DBConnection.getConnection();
            String query = "DELETE FROM students WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);

            int rows = pstmt.executeUpdate();
            if (rows > 0)
                System.out.println("Student deleted successfully!");
            else
                System.out.println("Student ID not found.");

            conn.close();
        } catch (Exception e) {
            System.out.println("Error deleting student: " + e.getMessage());
        }
    }
}
