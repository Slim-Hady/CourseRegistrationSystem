package Interfaces;

import Entits.Enrollment;
import java.util.List;

public interface IEnrollmentRepository {
    void enrollStudent(Enrollment enrollment);
    Enrollment getEnrollment(int studentId, int courseId);
    List<Enrollment> getEnrollmentsByStudent(int studentId);
    List<Enrollment> getEnrollmentsByCourse(int courseId);
    List<Enrollment> getAllEnrollments();
    void updateEnrollment(Enrollment enrollment);
    void deleteEnrollment(int studentId, int courseId);
}
