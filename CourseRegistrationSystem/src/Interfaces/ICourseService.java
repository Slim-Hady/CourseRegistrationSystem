package Interfaces;

import Entits.Course;
import java.util.List;

public interface ICourseService {
    void addCourse(Course course);
    Course findCourse(int courseId);
    List<Course> getAllCourses();
    void modifyCourse(Course course);
    void removeCourse(int courseId);
}
