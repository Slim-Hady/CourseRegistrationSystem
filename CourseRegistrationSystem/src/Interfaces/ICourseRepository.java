package Interfaces;

import Entits.Course;

import java.util.ArrayList;
import java.util.List;

public interface ICourseRepository {
    void addCourse(Course course);
    Course getCourseById(int courseId);
    ArrayList<Course> getAllCourses();
    void updateCourse(Course course);
    void deleteCourse(int courseId);
}
