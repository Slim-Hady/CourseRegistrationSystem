package Service;

import Entits.Student;
import Entits.User;
import Reposatory.AuthRepository;
import Reposatory.StudentRepository;
import java.util.Scanner;

public class AuthService {
    private AuthRepository authRepo;
    private StudentRepository studentRepo;
    private Scanner scanner;

    public AuthService() {
        this.authRepo = new AuthRepository();
        this.studentRepo = new StudentRepository();
        this.scanner = new Scanner(System.in);
    }

    public User login() {
        System.out.println("\n=== LOGIN ===");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        
        User user = authRepo.findByUsernameAndPassword(username, password);
        if (user != null) {
            System.out.println("Login successful! Welcome " + user.getUsername());
            return user;
        } else {
            System.out.println("Invalid username or password!");
            return null;
        }
    }

    public boolean signup() {
        System.out.println("\n=== SIGN UP ===");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        
        int newId = (int)(Math.random() * 90000) + 10000;

        Student student = new Student(newId, username, password, "student", email, 0.0);
        
        if (authRepo.registerUser(student)) {
            studentRepo.addStudent(student);
            System.out.println("Registration successful! Your ID is: " + newId);
            return true;
        } else {
            System.out.println("Registration failed!");
            return false;
        }
    }
}