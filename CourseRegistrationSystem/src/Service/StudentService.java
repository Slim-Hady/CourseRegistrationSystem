package Service;

import Entits.Course;
import Entits.DBConnection;
import Entits.Enrollment;
import Entits.Student;
import Interfaces.IStudentRepository;
import Reposatory.CourseRepository;
import Reposatory.EnrollmentRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;

public class StudentService {
    private final IStudentRepository studentRepo;
    private CourseRepository courseRepo;
    private EnrollmentRepository enrollmentRepo;
    private Scanner scanner;

    public StudentService(IStudentRepository studentRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo = new CourseRepository();
        this.enrollmentRepo = new EnrollmentRepository();
        this.scanner = new Scanner(System.in);
    }

    public void addStudent(Student student) {
        if (student.getUsername() == null || student.getUsername().isEmpty() ||
                student.getPassword() == null || student.getPassword().isEmpty() ||
                student.getEmail() == null || student.getEmail().isEmpty()) {
            System.out.println("Fields cannot be empty");
            return;
        }
        studentRepo.addStudent(student);
    }

    public Student getStudentById(int id) {
        return studentRepo.getStudentById(id);
    }

    public List<Student> getAllStudents() {
        return studentRepo.getAllStudents();
    }

    public void updateStudent(Student student) {
        studentRepo.updateStudent(student);
    }

    public void deleteStudent(int id) {
        studentRepo.deleteStudent(id);
    }

    public void showStudentMenu(int studentId) {
        while (true) {
            System.out.println("\n=== STUDENT MENU ===");
            System.out.println("1. Add Course");
            System.out.println("2. Drop Course");
            System.out.println("3. View My Enrollments");
            System.out.println("4. View Available Courses");
            System.out.println("5. Logout");
            System.out.print("Choose an option: ");
            
            int choice = Integer.parseInt(scanner.nextLine());
            
            switch (choice) {
                case 1:
                    addCourse(studentId);
                    break;
                case 2:
                    dropCourse(studentId);
                    break;
                case 3:
                    viewMyEnrollments(studentId);
                    break;
                case 4:
                    viewAvailableCourses();
                    break;
                case 5:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private void addCourse(int studentId) {
        System.out.println("\n=== ADD COURSE ===");
        viewAvailableCourses();

        System.out.print("Enter Course ID to enroll: ");
        int courseId = Integer.parseInt(scanner.nextLine());

        Course course = courseRepo.getCourseById(courseId);
        if (course == null) {
            System.out.println("Course not found!");
            return;
        }
        Enrollment existing = enrollmentRepo.getEnrollment(studentId, courseId);
        if (existing != null) {
            System.out.println("You are already enrolled in this course!");
            return;
        }

        if (!ensureStudentExists(studentId)) {
            System.out.println(" Cannot create student record. Please contact administrator.");
            return;
        }

        try {
            Enrollment enrollment = new Enrollment(studentId, courseId, true);
            enrollmentRepo.enrollStudent(enrollment);
            System.out.println("Successfully enrolled in " + course.getName());
        } catch (Exception e) {
            System.out.println("Error enrolling in course: " + e.getMessage());
        }
    }
    private boolean ensureStudentExists(int studentId) {
        try {
            String checkSql = "SELECT id FROM Students WHERE id = ?";
            try (Connection conn = DBConnection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(checkSql)) {
                stmt.setInt(1, studentId);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    return true;
                }
            }
            
            String userSql = "SELECT username FROM Users WHERE id = ?";
            String insertSql = "INSERT INTO Students (id, email, payment) VALUES (?, ?, ?)";
            
            try (Connection conn = DBConnection.getConnection();
                 PreparedStatement userStmt = conn.prepareStatement(userSql);
                 PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
                
                userStmt.setInt(1, studentId);
                ResultSet rs = userStmt.executeQuery();
                
                if (rs.next()) {
                    String username = rs.getString("username");
                    
                    insertStmt.setInt(1, studentId);
                    insertStmt.setString(2, username + "@email.com");
                    insertStmt.setDouble(3, 0.0);
                    insertStmt.executeUpdate();
                    
                    System.out.println(" Created missing student record for user ID: " + studentId);
                    return true;
                } else {
                    System.out.println("User not found in Users table");
                    return false;
                }
            }
        } catch (Exception e) {
            System.out.println(" Error ensuring student exists: " + e.getMessage());
            return false;
        }
    }

    private void dropCourse(int studentId) {
        System.out.println("\n=== DROP COURSE ===");
        viewMyEnrollments(studentId);
        
        System.out.print("Enter Course ID to drop: ");
        int courseId = Integer.parseInt(scanner.nextLine());
        
        Enrollment enrollment = enrollmentRepo.getEnrollment(studentId, courseId);
        if (enrollment == null) {
            System.out.println(" You are not enrolled in this course!");
            return;
        }
        
        enrollmentRepo.deleteEnrollment(studentId, courseId);
        System.out.println(" Successfully dropped the course");
    }

    private void viewMyEnrollments(int studentId) {
        System.out.println("\n=== MY ENROLLMENTS ===");
        List<Enrollment> enrollments = enrollmentRepo.getEnrollmentsByStudent(studentId);
        
        if (enrollments.isEmpty()) {
            System.out.println("You are not enrolled in any courses.");
        } else {
            for (Enrollment enrollment : enrollments) {
                Course course = courseRepo.getCourseById(enrollment.getCourseId());
                if (course != null) {
                    String status = enrollment.isStatus() ? "Active" : "Dropped";
                    System.out.println("Course: " + course.getName() + 
                                     " (ID: " + enrollment.getCourseId() + ")" +
                                     " | Status: " + status);
                } else {
                    System.out.println("Course ID: " + enrollment.getCourseId() + " (Course not found) | Status: " + 
                                     (enrollment.isStatus() ? "Active" : "Dropped"));
                }
            }
        }
    }

    private void viewAvailableCourses() {
        System.out.println("\n=== AVAILABLE COURSES ===");
        List<Course> courses = courseRepo.getAllCourses();
        
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
        } else {
            for (Course course : courses) {
                if (course.getCourseId() > 0 && course.getName() != null && course.getDrName() != null) {
                    System.out.println("ID: " + course.getCourseId() + 
                                     " | Name: " + course.getName() + 
                                     " | Doctor: " + course.getDrName() + 
                                     " | Hours: " + course.getHours() + 
                                     " | Date: " + course.getCourseDate());
                }
            }
        }
    }
}
