import java.sql.*;
/*
UserRepository class is to DB connection that Validate log in with SELCETing u
username and password from database
 */
public class UserRepository {
    public boolean login(String username, String password) {
        String sql = "SELECT * FROM Users WHERE username = ? AND password = ?";
        // ? will change it with stmt
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username); // change ? to username
            stmt.setString(2, password); // same as username

            ResultSet rs = stmt.executeQuery();
            return rs.next(); // if return row so user exist else catch

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public void adduser(User user){
        String sql = "INSERT INTO Users VALUES (?,?,?,?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, user.getID());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getRole());
            stmt.executeUpdate();
            System.out.println("✅ User added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public User getUserByID(int ID){
        String sql = "SELECT * FROM Users WHERE ID = ?";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, ID);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
