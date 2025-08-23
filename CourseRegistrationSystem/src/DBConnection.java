import java.sql.*;

public class DBConnection {
    public static void main(String[] args) {
        String host = "jdbc:mysql://127.0.0.1:3306";
        String username = "root";
        String password = "3050417";
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