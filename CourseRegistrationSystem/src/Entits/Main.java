package Entits;

import Service.*;
import Reposatory.*;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static AuthService authService = new AuthService();
    private static StudentService studentService = new StudentService(new StudentRepository());
    private static AdminService adminService = new AdminService();

    public static void main(String[] args) {
        System.out.println("Welcome to Course Registration System ");
        while (true) {
            showMainMenu();
        }
    }

    private static void showMainMenu() {
        System.out.println("\n=== MAIN MENU ===");
        System.out.println("1. Login");
        System.out.println("2. Sign Up");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");

        try {
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    handleLogin();
                    break;
                case 2:
                    handleSignup();
                    break;
                case 3:
                    System.out.println("Thank you for using Course Registration System!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option! Please choose 1, 2, or 3.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number!");
        }
    }

    private static void handleLogin() {
        User user = authService.login();
        if (user != null) {
            if ("admin".equals(user.getRole())) {
                System.out.println("Logged in as Administrator");
                adminService.showAdminMenu();
            } else if ("student".equals(user.getRole())) {
                System.out.println("Logged in as Student");
                studentService.showStudentMenu(user.getID());
            } else {
                System.out.println("Unknown user role: " + user.getRole());
            }
        }
    }

    private static void handleSignup() {
        boolean success = authService.signup();
        if (success) {
            System.out.println("You can now login with your new account!");
        }
    }
}