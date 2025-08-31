package Reposatory;

import Interfaces.IStudentRepository;
import Entits.Student;
import Entits.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {

    @Override
    public void addStudent(Student student) {
        String userSql = "INSERT INTO Users (id, username, password, role) VALUES (?, ?, ?, ?)";
        String studentSql = "INSERT INTO Students (id, email, payment) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement userStmt = conn.prepareStatement(userSql);
                 PreparedStatement studentStmt = conn.prepareStatement(studentSql)) {

                userStmt.setInt(1, student.getID());
                userStmt.setString(2, student.getUsername());
                userStmt.setString(3, student.getPassword());
                userStmt.setString(4, student.getRole());
                userStmt.executeUpdate();

                studentStmt.setInt(1, student.getID());
                studentStmt.setString(2, student.getEmail());
                studentStmt.setDouble(3, student.getPayment());
                studentStmt.executeUpdate();

                conn.commit();
                System.out.println("✅ Student added successfully!");

            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student getStudentById(int id) {
        String sql = "SELECT u.id, u.username, u.password, u.role, s.email, s.payment " +
                "FROM Users u JOIN Students s ON u.id = s.id WHERE u.id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Student(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role"),
                        rs.getString("email"),
                        rs.getDouble("payment")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT u.id, u.username, u.password, u.role, s.email, s.payment " +
                "FROM Users u JOIN Students s ON u.id = s.id";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role"),
                        rs.getString("email"),
                        rs.getDouble("payment")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public void updateStudent(Student student) {
        String sql = "UPDATE Students SET email = ?, payment = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, student.getEmail());
            stmt.setDouble(2, student.getPayment());
            stmt.setInt(3, student.getID());
            int rows = stmt.executeUpdate();
            if (rows > 0) System.out.println("Student updated successfully!");
            else System.out.println("Student not found!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(int id) {
        String sql = "DELETE FROM Students WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) System.out.println("Student deleted successfully!");
            else System.out.println("Student not found!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
