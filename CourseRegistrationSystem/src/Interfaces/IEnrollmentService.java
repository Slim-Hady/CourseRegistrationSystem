package Interfaces;

import Entits.Enrollment;
import java.util.List;

public interface IEnrollmentService {
    void enrollStudentInCourse(Enrollment enrollment);
    Enrollment getEnrollment(int studentId, int courseId);
    List<Enrollment> getEnrollmentsByStudent(int studentId);
    List<Enrollment> getEnrollmentsByCourse(int courseId);
    List<Enrollment> getAllEnrollments();
    void updateEnrollment(Enrollment enrollment);
    void deleteEnrollment(int studentId, int courseId);
}
