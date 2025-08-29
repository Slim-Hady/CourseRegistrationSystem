package Entits;

import Service.*;
import Reposatory.*;
import Interfaces.*;
import java.sql.Date;
import Interfaces.*;

public class Main {
    public static void main(String[] args) {
        ICourseRepository courseRepository = new CourseRepository();
        CourseService courseService = new CourseService(courseRepository);

        // Create new course
        Course c1 = new Course(101, "Algorithms", "Dr. Smith", 3, Date.valueOf("2025-09-01"));
        courseService.addCourse(c1);

        // Read
        Course fetched = courseService.findCourse(101);
        if (fetched != null)
            System.out.println("📘 Course Fetched: " + fetched.getName() + " by " + fetched.getDrName());

        // Update
        c1.setDrName("Dr. Johnson");
        courseService.updateCourse(c1);

        // Delete
        courseService.deleteCourse(101);
    }
}
