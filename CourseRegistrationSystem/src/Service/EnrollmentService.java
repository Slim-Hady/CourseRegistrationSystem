package Service;

import Entits.Enrollment;
import Interfaces.IEnrollmentRepository;
import Reposatory.EnrollmentRepository;

import java.util.List;

public class EnrollmentService {
    private IEnrollmentRepository enrollmentRepository = new EnrollmentRepository();

    public void enrollStudentInCourse(Enrollment enrollment) {
        enrollmentRepository.enrollStudent(enrollment);
    }

    public Enrollment getEnrollment(int studentId, int courseId) {
        return enrollmentRepository.getEnrollment(studentId, courseId);
    }

    public List<Enrollment> getEnrollmentsByStudent(int studentId) {
        return enrollmentRepository.getEnrollmentsByStudent(studentId);
    }

    public List<Enrollment> getEnrollmentsByCourse(int courseId) {
        return enrollmentRepository.getEnrollmentsByCourse(courseId);
    }

    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.getAllEnrollments();
    }

    public void updateEnrollment(Enrollment enrollment) {
        enrollmentRepository.updateEnrollment(enrollment);
    }

    public void deleteEnrollment(int studentId, int courseId) {
        enrollmentRepository.deleteEnrollment(studentId, courseId);
    }
}
