package Entits;

public class Student extends User {
    private String email;
    private double payment;
    public Student() {}
    public Student(int id, String username, String password, String role, String email, double payment) {
        super(id, username, password, role);
        this.email = email;
        this.payment = payment;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + getID() +
                ", username='" + getUsername() + '\'' +
                ", role='" + getRole() + '\'' +
                ", email='" + email + '\'' +
                ", payment=" + payment +
                '}';
    }
}
