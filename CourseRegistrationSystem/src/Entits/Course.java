package Entits;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Course {
    private int courseId;
    private String drName;
    private Date courseDate;
    private int hours;
    private String name;
    private List<Integer> prerequisites; 

    public Course() {
        this.prerequisites = new ArrayList<>();
    }

    public Course(int courseId, String name, String drName, int hours, Date courseDate) {
        this.courseId = courseId;
        this.name = name;
        this.drName = drName;
        this.hours = hours;
        this.courseDate = courseDate;
        this.prerequisites = new ArrayList<>();
    }

    public Course(int courseId, String name, String drName, int hours, Date courseDate, List<Integer> prerequisites) {
        this.courseId = courseId;
        this.name = name;
        this.drName = drName;
        this.hours = hours;
        this.courseDate = courseDate;
        this.prerequisites = prerequisites != null ? prerequisites : new ArrayList<>();
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

    public List<Integer> getPrerequisites() { return prerequisites; }
    public void setPrerequisites(List<Integer> prerequisites) { this.prerequisites = prerequisites; }

    public void addPrerequisite(int courseId) {
        if (!prerequisites.contains(courseId)) {
            prerequisites.add(courseId);
        }
    }

    public boolean hasPrerequisites() {
        return !prerequisites.isEmpty();
    }
}
