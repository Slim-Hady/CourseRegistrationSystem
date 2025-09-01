package Service;


import Reposatory.*;
import Entits.*;

import java.util.ArrayList;
import java.util.List;

public class CoursePrerequisiteService {
    private CourseRepository courseRepo;
    private EnrollmentRepository enrollmentRepo;
    private Toplogicalsort topologicalSorter;
    
    public CoursePrerequisiteService() {
        this.courseRepo = new CourseRepository();
        this.enrollmentRepo = new EnrollmentRepository();
        this.topologicalSorter = new Toplogicalsort();
    }

    public boolean canEnrollInCourse(int studentId, int courseId) {
        Course course = courseRepo.getCourseById(courseId);
        if (course == null || !course.hasPrerequisites()) {
            return true;
        }
        for (Integer prereqId : course.getPrerequisites()) {
            if (!hasCompletedCourse(studentId, prereqId)) {
                return false;
            }
        }
        return true;
    }
    private boolean hasCompletedCourse(int studentId, int courseId) {
        Enrollment enrollment = enrollmentRepo.getEnrollment(studentId, courseId);
        return enrollment != null && enrollment.isStatus();
    }

    public List<Course> getRecommendedCourseSequence(int studentId) {
        List<Course> allCourses = courseRepo.getAllCourses();
        
        int maxCourseId = allCourses.stream()
                .mapToInt(Course::getCourseId)
                .max()
                .orElse(0) + 1;
        
        Graph courseGraph = new Graph(maxCourseId);
        
        for (Course course : allCourses) {
            if (course.hasPrerequisites()) {
                for (Integer prereqId : course.getPrerequisites()) {
                    courseGraph.addEdge(prereqId, course.getCourseId());
                }
            }
        }
        
        try {
            List<Integer> topoOrder = topologicalSorter.topologicalSort(courseGraph);
            List<Course> recommendedSequence = new ArrayList<>();
            for (Integer courseId : topoOrder) {
                Course course = courseRepo.getCourseById(courseId);
                if (course != null && !hasCompletedCourse(studentId, courseId)) {
                    recommendedSequence.add(course);
                }
            }
            
            return recommendedSequence;
        } catch (RuntimeException e) {
            System.out.println("Warning: Circular prerequisites detected. Returning unordered course list.");
            return allCourses.stream()
                    .filter(course -> !hasCompletedCourse(studentId, course.getCourseId()))
                    .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        }
    }

    public List<Course> getMissingPrerequisites(int studentId, int courseId) {
        Course course = courseRepo.getCourseById(courseId);
        if (course == null || !course.hasPrerequisites()) {
            return new ArrayList<>();
        }
        
        List<Course> missingPrereqs = new ArrayList<>();
        for (Integer prereqId : course.getPrerequisites()) {
            if (!hasCompletedCourse(studentId, prereqId)) {
                Course prereqCourse = courseRepo.getCourseById(prereqId);
                if (prereqCourse != null) {
                    missingPrereqs.add(prereqCourse);
                }
            }
        }
        
        return missingPrereqs;
    }
}
