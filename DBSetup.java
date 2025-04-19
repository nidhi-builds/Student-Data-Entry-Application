import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBSetup {

    public static void initializeDatabase() {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root"; // replace with your MySQL username
        String password = "Nidhi*2907"; // replace with your MySQL password

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            // Step 1: Create database if not exists
            String createDB = "CREATE DATABASE IF NOT EXISTS student_db1";
            stmt.executeUpdate(createDB);

            // Step 2: Connect to the new DB
            String dbUrl = "jdbc:mysql://localhost:3306/student_db1";
            try (Connection dbConn = DriverManager.getConnection(dbUrl, user, password);
                 Statement dbStmt = dbConn.createStatement()) {

                // Step 3: Create table if not exists
                String createTable = "CREATE TABLE IF NOT EXISTS students ("
                        + "id INT PRIMARY KEY, "
                        + "name VARCHAR(50), "
                        + "email VARCHAR(100))";
                dbStmt.executeUpdate(createTable);
                System.out.println("Database and table ready.");

            } catch (SQLException e) {
                System.out.println("Error creating table: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Error connecting to MySQL: " + e.getMessage());
        }
    }
}

