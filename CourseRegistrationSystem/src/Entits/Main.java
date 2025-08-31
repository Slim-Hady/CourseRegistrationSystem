package Entits;

import Service.*;
import Reposatory.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Services
        StudentService studentService = new StudentService(new StudentRepository());
        CourseService courseService = new CourseService(new CourseRepository());
        EnrollmentService enrollmentService = new EnrollmentService();

        // ✅ طلاب جدد (ID مختلف كل مرة)
        Student student1 = new Student();
        student1.setID(30001);
        student1.setUsername("omar");
        student1.setPassword("omar123");
        student1.setRole("student");
        student1.setEmail("omar@example.com");
        student1.setPayment(1000.0);
        studentService.addStudent(student1);

        Student student2 = new Student();
        student2.setID(30002);
        student2.setUsername("sara");
        student2.setPassword("sara123");
        student2.setRole("student");
        student2.setEmail("sara@example.com");
        student2.setPayment(1500.0);
        studentService.addStudent(student2);

        // ✅ كورسات جديدة
        Course course1 = new Course(201, "Machine Learning", "Dr. Ali", 3, java.sql.Date.valueOf("2025-10-01"));
        Course course2 = new Course(202, "Operating Systems", "Dr. Mona", 4, java.sql.Date.valueOf("2025-10-05"));
        courseService.addCourse(course1);
        courseService.addCourse(course2);

        // ✅ Enrollments جديدة
        enrollmentService.enrollStudentInCourse(new Enrollment(30001, 201, true));
        enrollmentService.enrollStudentInCourse(new Enrollment(30001, 202, true));
        enrollmentService.enrollStudentInCourse(new Enrollment(30002, 201, false));

        // ✅ عرض البيانات
        System.out.println("\n--- Students ---");
        List<Student> students = studentService.getAllStudents();
        for (Student s : students) {
            System.out.println(s);
        }

        System.out.println("\n--- Courses ---");
        List<Course> courses = courseService.getAllCourses();
        for (Course c : courses) {
            System.out.println(c);
        }

        System.out.println("\n--- Enrollments ---");
        List<Enrollment> enrollments = enrollmentService.getEnrollmentsByStudent(30001);
        for (Enrollment e : enrollments) {
            System.out.println("Student " + e.getStudentId() + " -> Course " + e.getCourseId() + " | Status: " + e.isStatus());
        }
    }
}
