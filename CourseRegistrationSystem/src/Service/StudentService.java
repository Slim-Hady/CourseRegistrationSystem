package Service;

import Interfaces.IStudentRepository;
import Entits.Student;

import java.util.List;

public class StudentService {
    private final IStudentRepository studentRepo;

    public StudentService(IStudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    public void addStudent(Student student) {
        if (student.getUsername() == null || student.getUsername().isEmpty() ||
                student.getPassword() == null || student.getPassword().isEmpty() ||
                student.getEmail() == null || student.getEmail().isEmpty()) {
            System.out.println("Fields cannot be empty");
            return;
        }
        studentRepo.addStudent(student);
    }

    public Student getStudentById(int id) {
        return studentRepo.getStudentById(id);
    }

    public List<Student> getAllStudents() {
        return studentRepo.getAllStudents();
    }

    public void updateStudent(Student student) {
        studentRepo.updateStudent(student);
    }

    public void deleteStudent(int id) {
        studentRepo.deleteStudent(id);
    }
}
