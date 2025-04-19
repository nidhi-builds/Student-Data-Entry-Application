import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateStudent {
    public static void updateStudent() {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Student ID to Update: ");
            int id = sc.nextInt();
            sc.nextLine();  // Consume newline

            System.out.print("Enter New Name: ");
            String name = sc.nextLine();
            System.out.print("Enter New Email: ");
            String email = sc.nextLine();

            Connection conn = DBConnection.getConnection();
            String query = "UPDATE students SET name = ?, email = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setInt(3, id);

            int rows = pstmt.executeUpdate();
            if (rows > 0)
                System.out.println("Student updated successfully!");
            else
                System.out.println("Student ID not found.");

            conn.close();
        } catch (Exception e) {
            System.out.println("Error updating student: " + e.getMessage());
        }
    }
}
