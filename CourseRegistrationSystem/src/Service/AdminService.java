package Service;

import Entits.Course;
import Entits.Student;
import Reposatory.CourseRepository;
import Reposatory.StudentRepository;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class AdminService {
    private CourseRepository courseRepo;
    private StudentRepository studentRepo;
    private Scanner scanner;

    public AdminService() {
        this.courseRepo = new CourseRepository();
        this.studentRepo = new StudentRepository();
        this.scanner = new Scanner(System.in);
    }

    public void showAdminMenu() {
        while (true) {
            System.out.println("\n=== ADMIN MENU ===");
            System.out.println("1. Add Course");
            System.out.println("2. Delete Course");
            System.out.println("3. Update Course");
            System.out.println("4. View All Courses");
            System.out.println("5. View Student Information");
            System.out.println("6. Logout");
            System.out.print("Choose an option: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        addCourse();
                        break;
                    case 2:
                        deleteCourse();
                        break;
                    case 3:
                        updateCourse();
                        break;
                    case 4:
                        viewAllCourses();
                        break;
                    case 5:
                        viewStudentInfo();
                        break;
                    case 6:
                        System.out.println("Logging out...");
                        return;
                    default:
                        System.out.println("Invalid option!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
    }

    private void addCourse() {
        System.out.println("\n=== ADD COURSE ===");
        try {
            System.out.print("Enter Course ID: ");
            int courseId = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter Course Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Doctor Name: ");
            String drName = scanner.nextLine();
            System.out.print("Enter Hours: ");
            int hours = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter Date (YYYY-MM-DD): ");
            String dateStr = scanner.nextLine();

            Date courseDate = Date.valueOf(dateStr);
            Course course = new Course(courseId, name, drName, hours, courseDate);
            courseRepo.addCourse(course);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void deleteCourse() {
        System.out.println("\n=== DELETE COURSE ===");
        try {
            System.out.print("Enter Course ID to delete: ");
            int courseId = Integer.parseInt(scanner.nextLine());
            courseRepo.deleteCourse(courseId);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void updateCourse() {
        System.out.println("\n=== UPDATE COURSE ===");
        try {
            System.out.print("Enter Course ID to update: ");
            int courseId = Integer.parseInt(scanner.nextLine());

            Course existingCourse = courseRepo.getCourseById(courseId);
            if (existingCourse == null) {
                System.out.println("Course not found!");
                return;
            }

            System.out.println("Current course: " + existingCourse.getName());
            System.out.print("Enter new Course Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new Doctor Name: ");
            String drName = scanner.nextLine();
            System.out.print("Enter new Hours: ");
            int hours = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter new Date (YYYY-MM-DD): ");
            String dateStr = scanner.nextLine();

            Date courseDate = Date.valueOf(dateStr);
            Course updatedCourse = new Course(courseId, name, drName, hours, courseDate);
            courseRepo.updateCourse(updatedCourse);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void viewAllCourses() {
        System.out.println("\n=== ALL COURSES ===");
        List<Course> courses = courseRepo.getAllCourses();
        if (courses.isEmpty()) {
            System.out.println("No courses found.");
        } else {
            for (Course course : courses) {
                System.out.println("ID: " + course.getCourseId() +
                        " | Name: " + course.getName() +
                        " | Doctor: " + course.getDrName() +
                        " | Hours: " + course.getHours() +
                        " | Date: " + course.getCourseDate());
            }
        }
    }

    private void viewStudentInfo() {
        System.out.println("\n=== STUDENT INFORMATION ===");
        List<Student> students = studentRepo.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : students) {
                System.out.println("ID: " + student.getID() +
                        " | Username: " + student.getUsername() +
                        " | Email: " + student.getEmail() +
                        " | Payment: $" + student.getPayment());
            }
        }
    }
}