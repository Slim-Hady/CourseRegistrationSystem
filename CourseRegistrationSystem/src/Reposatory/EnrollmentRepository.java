package Reposatory;

import Interfaces.IEnrollmentRepository;
import Entits.Enrollment;
import Entits.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentRepository implements IEnrollmentRepository {

    @Override
    public void enrollStudent(Enrollment enrollment) {
        String sql = "INSERT INTO Enrollment (student_id, course_id, status) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, enrollment.getStudentId());
            stmt.setInt(2, enrollment.getCourseId());
            stmt.setBoolean(3, enrollment.isStatus());
            stmt.executeUpdate();
            System.out.println("Student enrolled in course successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Enrollment getEnrollment(int studentId, int courseId) {
        String sql = "SELECT * FROM Enrollment WHERE student_id = ? AND course_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, studentId);
            stmt.setInt(2, courseId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Enrollment(
                        rs.getInt("student_id"),
                        rs.getInt("course_id"),
                        rs.getBoolean("status")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Enrollment> getEnrollmentsByStudent(int studentId) {
        List<Enrollment> enrollments = new ArrayList<>();
        String sql = "SELECT * FROM Enrollment WHERE student_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, studentId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                enrollments.add(new Enrollment(
                        rs.getInt("student_id"),
                        rs.getInt("course_id"),
                        rs.getBoolean("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enrollments;
    }

    @Override
    public List<Enrollment> getEnrollmentsByCourse(int courseId) {
        List<Enrollment> enrollments = new ArrayList<>();
        String sql = "SELECT * FROM Enrollment WHERE course_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, courseId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                enrollments.add(new Enrollment(
                        rs.getInt("student_id"),
                        rs.getInt("course_id"),
                        rs.getBoolean("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enrollments;
    }

    @Override
    public void updateEnrollment(Enrollment enrollment) {
        String sql = "UPDATE Enrollment SET status = ? WHERE student_id = ? AND course_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setBoolean(1, enrollment.isStatus());
            stmt.setInt(2, enrollment.getStudentId());
            stmt.setInt(3, enrollment.getCourseId());
            int rows = stmt.executeUpdate();
            if (rows > 0) System.out.println("Enrollment updated successfully!");
            else System.out.println("Enrollment not found!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEnrollment(int studentId, int courseId) {
        String sql = "DELETE FROM Enrollment WHERE student_id = ? AND course_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, studentId);
            stmt.setInt(2, courseId);
            int rows = stmt.executeUpdate();
            if (rows > 0) System.out.println("Enrollment deleted successfully!");
            else System.out.println("Enrollment not found!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Enrollment> getAllEnrollments() {
        List<Enrollment> enrollments = new ArrayList<>();
        String sql = "SELECT * FROM Enrollment";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                enrollments.add(new Enrollment(
                        rs.getInt("student_id"),
                        rs.getInt("course_id"),
                        rs.getBoolean("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enrollments;
    }

}
