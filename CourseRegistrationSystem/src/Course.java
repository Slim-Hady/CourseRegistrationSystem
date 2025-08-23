import java.sql.Date;

public class Course {

      private String CourseID;
      private String DrName;
      private Date Date ;
      private int Hours ;
      private String Name;

     public String getCourseID() {
        return CourseID;
    }

    public void setCourseID(String courseID) {
        this.CourseID = courseID;
    }

    public String getDrName() {
        return DrName;
    }

    public void setDrName(String drName) {
        this.DrName = drName;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date date) {
        this.Date = date;
    }

    public int getHours() {
        return Hours;
    }

    public void setHours(int hours) {
        this.Hours = hours;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

}
