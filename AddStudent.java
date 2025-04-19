import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AddStudent {
    public static void addStudent() {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();
            sc.nextLine();  // Consume newline
            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Student Email: ");
            String email = sc.nextLine();

            Connection conn = DBConnection.getConnection();
            String query = "INSERT INTO students (id, name, email) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, email);

            pstmt.executeUpdate();
            System.out.println("Student added successfully!");

            conn.close();
        } catch (Exception e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }
}
