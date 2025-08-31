package Entits;

public class Enrollment {
    private int studentId;
    private int courseId;
    private boolean status; // Drop or not 

    public Enrollment(int studentId, int courseId, boolean status) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.status = status;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Enrollment{studentId=" + studentId + ", courseId=" + courseId + ", status=" + status + "}";
    }
}
