package Interfaces;
import Entits.*;
public interface IEnrollment {
    void enroll(Student student, Course course);
    void drop(Student student, Course course);
}
