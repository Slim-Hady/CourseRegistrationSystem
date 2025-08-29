package Reposatory;
import Interfaces.*;
import Entits.*;
import java.sql.*;

public class CourseRepository implements ICourseRepository {

    @Override
    public void addCourse(Course course) {
        String sql = "INSERT INTO Courses (course_id, name, dr_name, hours, date) VALUES (?,?,?,?,?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, course.getCourseId());
            stmt.setString(2, course.getName());
            stmt.setString(3, course.getDrName());
            stmt.setInt(4, course.getHours());
            stmt.setDate(5, course.getCourseDate());
            stmt.executeUpdate();
            System.out.println("✅ Course added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Course getCourseById(int courseId) {
        String sql = "SELECT * FROM Courses WHERE course_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, courseId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Course(
                        rs.getInt("course_id"),
                        rs.getString("name"),
                        rs.getString("dr_name"),
                        rs.getInt("hours"),
                        rs.getDate("date")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateCourse(Course course) {
        String sql = "UPDATE Courses SET name = ?, dr_name = ?, hours = ?, date = ? WHERE course_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, course.getName());
            stmt.setString(2, course.getDrName());
            stmt.setInt(3, course.getHours());
            stmt.setDate(4, course.getCourseDate());
            stmt.setInt(5, course.getCourseId());
            int rows = stmt.executeUpdate();
            if (rows > 0) System.out.println("✅ Course updated successfully!");
            else System.out.println("⚠️ Course not found!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCourse(int courseId) {
        String sql = "DELETE FROM Courses WHERE course_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, courseId);
            int rows = stmt.executeUpdate();
            if (rows > 0) System.out.println("🗑️ Course deleted successfully!");
            else System.out.println("⚠️ Course not found!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
