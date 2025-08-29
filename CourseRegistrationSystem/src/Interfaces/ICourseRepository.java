package Interfaces;
import Entits.*;
public interface ICourseRepository {
    void addCourse(Course course);
    Course getCourseById(int courseId);
    void updateCourse(Course course);
    void deleteCourse(int courseId);
}
