package Service;
import Reposatory.*;
import Interfaces.*;
import Entits.*;

import java.sql.*;

public class CourseService {
    private ICourseRepository courseRepo;

    public CourseService(ICourseRepository courseRepo) {
        this.courseRepo = courseRepo;
    }

    public void addCourse(Course course) {
        if (courseRepo.getCourseById(course.getCourseId()) != null) {
            System.out.println("⚠️ Course ID already exists!");
            return;
        }
        courseRepo.addCourse(course);
    }

    public Course findCourse(int courseId) {
        return courseRepo.getCourseById(courseId);
    }

    public void updateCourse(Course course) {
        courseRepo.updateCourse(course);
    }

    public void deleteCourse(int courseId) {
        courseRepo.deleteCourse(courseId);
    }
}
