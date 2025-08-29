import java.sql.*;

public class DBConnection {
    static String host = "jdbc:mysql://127.0.0.1:3306/CourseRegistrationSystem";
    static String username = "root";
    static String password = "3050417";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(host, username, password);
    }
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(host, username, password);
            System.out.println("Connected to MySQL database");
        } catch (SQLException e) {
            System.out.println("Failed to connect to MySQL database");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load JDBC driver");
            e.printStackTrace();
        }

    }

}