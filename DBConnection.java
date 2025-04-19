import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/student_db";
        String user = "root"; // replace with your MySQL username
        String password = "your_password"; // replace with your MySQL password

        return DriverManager.getConnection(url, user, password);
    }
}
