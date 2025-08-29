package Entits;
import Interfaces.*;

import java.sql.Date;

public class Course {
    private int courseId;
    private String drName;
    private Date courseDate;
    private int hours;
    private String name;

    public Course(int courseId, String name, String drName, int hours, Date courseDate) {
        this.courseId = courseId;
        this.name = name;
        this.drName = drName;
        this.hours = hours;
        this.courseDate = courseDate;
    }

    public int getCourseId() { return courseId; }
    public void setCourseId(int courseId) { this.courseId = courseId; }

    public String getDrName() { return drName; }
    public void setDrName(String drName) { this.drName = drName; }

    public Date getCourseDate() { return courseDate; }
    public void setCourseDate(Date courseDate) { this.courseDate = courseDate; }

    public int getHours() { return hours; }
    public void setHours(int hours) { this.hours = hours; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
