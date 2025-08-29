package Entits;
import Interfaces.*;

public class Student extends User{
      private String Email;
      private double Payment;

      public String getEmail() {
        return Email;
      }

      public void setEmail(String email) {
        Email = email;
      }

      public double getPayment() {
        return Payment;
      }

      public void setPayment(double payment) {
        Payment = payment;
      }

      public void veiwdetails(){
        System.out.println("Student ID: " + this.ID);
        System.out.println("Student Name: " + this.username);
        System.out.println("Student Password: " + this.password);
        System.out.println("Student Email: " + this.Email);
        System.out.println("Student Payment: " + this.Payment);
      }

}
