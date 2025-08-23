public class Enrollment {
     private String StudentID;
     private String CourseID;
     private boolean status; // Drop or Enroll

    public void enroll(){

    }
    public void drop(){

    }
    public String getStatus(){
        String str = "Report";
        return str;
    }
    public void setStatus(boolean status){
        this.status = status;
    }

}
