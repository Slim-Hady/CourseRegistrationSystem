package Reposatory;

import Entits.Student;
import Entits.Course;
import Entits.Enrollment;

import java.util.List;

public class ReportRepository {

    private final StudentRepository studentRepo;
    private final CourseRepository courseRepo;
    private final EnrollmentRepository enrollmentRepo;

    public ReportRepository(StudentRepository studentRepo, CourseRepository courseRepo, EnrollmentRepository enrollmentRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
        this.enrollmentRepo = enrollmentRepo;
    }

    public Student getStudent(int studentId) {
        return studentRepo.getStudentById(studentId);
    }

    public Course getCourse(int courseId) {
        return courseRepo.getCourseById(courseId);
    }

    public List<Enrollment> getEnrollmentsByStudent(int studentId) {
        return enrollmentRepo.getEnrollmentsByStudent(studentId);
    }

    public List<Enrollment> getEnrollmentsByCourse(int courseId) {
        return enrollmentRepo.getEnrollmentsByCourse(courseId);
    }

    public List<Course> getAllCourses() {
        return courseRepo.getAllCourses();
    }
}
