package Interfaces;

import Entits.Student;
import java.util.List;

public interface IStudentRepository {
    void addStudent(Student student);
    Student getStudentById(int id);
    List<Student> getAllStudents();
    void updateStudent(Student student);
    void deleteStudent(int id);
}
