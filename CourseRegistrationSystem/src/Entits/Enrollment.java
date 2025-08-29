package Entits;
import Interfaces.*;

public class Enrollment {
     private String StudentID;
     private String CourseID;
     private boolean status; // Drop or Enroll

    public Enrollment(String studentID, String courseID, boolean status) {
        StudentID = studentID;
        CourseID = courseID;
        this.status = status;
    }

    public String getStudentID() {
        return StudentID;
    }

    public String getCourseID() {
        return CourseID;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public void setCourseID(String courseID) {
        CourseID = courseID;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "StudentID='" + StudentID + '\'' +
                ", CourseID='" + CourseID + '\'' +
                ", status=" + status +
                '}';
    }

}
