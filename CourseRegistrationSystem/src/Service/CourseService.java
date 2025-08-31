package Service;

import Entits.Course;
import Interfaces.ICourseRepository;
import java.util.List;

public class CourseService {
    private ICourseRepository courseRepo;

    public CourseService(ICourseRepository courseRepo) {
        this.courseRepo = courseRepo;
    }

    public void addCourse(Course course) {
        if (courseRepo.getCourseById(course.getCourseId()) != null) {
            System.out.println("Course ID already exists!");
            return;
        }
        courseRepo.addCourse(course);
    }

    public Course findCourse(int courseId) {
        return courseRepo.getCourseById(courseId);
    }

    public List<Course> getAllCourses() {
        return courseRepo.getAllCourses();
    }

    public void modifyCourse(Course course) {
        courseRepo.updateCourse(course);
    }

    public void removeCourse(int courseId) {
        courseRepo.deleteCourse(courseId);
    }
}
