package Reposatory;
import Interfaces.*;
import Entits.*;
import java.sql.*;

import java.sql.*;
/*
UserRepository class is to DB connection that Validate log in with SELCETing u
username and password from database
 */
public class UserRepository implements IUserRepository {
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
            System.out.println("User added successfully!");

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
    public User getUserByUsername(String username){
        String sql = "SELECT * FROM Users WHERE username = ?";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, username);

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
    public void updateUser(User user) {
        String sql = "UPDATE Users SET username = ?, password = ?, role = ? WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getRole());
            stmt.setInt(4, user.getID());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("User updated successfully!");
            } else {
                System.out.println("User with ID " + user.getID() + " not found.");
            }

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Cannot update: Username or ID already exists for another user.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int ID) {
        String sql = "DELETE FROM Users WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, ID);
            int rows = stmt.executeUpdate();

            if (rows > 0) {
                System.out.println("User deleted successfully");
            } else {
                System.out.println("No user found with ID: " + ID);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
