# CourseRegistrationSystem

    CourseRegistrationSystem/
    ├── src/
    │   ├── Entits/
    │   │   ├── Admin.java
    │   │   ├── Authntication.java
    │   │   ├── Course.java
    │   │   ├── DBConnection.java
    │   │   ├── Enrollment.java
    │   │   ├── Graph.java
    │   │   ├── Main.java
    │   │   ├── ReportGenrator.java
    │   │   ├── Student.java
    │   │   ├── Toplogicalsort.java
    │   │   └── User.java
    │   │
    │   ├── Interfaces/
    │   │   ├── IAdminService.java
    │   │   ├── IAuth.java
    │   │   ├── ICourseRepository.java
    │   │   ├── ICourseService.java
    │   │   ├── IEnrollment.java
    │   │   ├── IEnrollmentRepository.java
    │   │   ├── IEnrollmentService.java
    │   │   ├── IReportGenerator.java
    │   │   ├── IReportGenrator.java
    │   │   ├── IStudentRepository.java
    │   │   ├── IStudentService.java
    │   │   └── IUserRepository.java
    │   │
    │   ├── Reposatory/
    │   │   ├── AdminRepository.java
    │   │   ├── AuthRepository.java
    │   │   ├── CourseRepository.java
    │   │   ├── EnrollmentRepository.java
    │   │   ├── ReportRepository.java
    │   │   ├── ReportRepositoryR.java
    │   │   ├── StudentRepository.java
    │   │   └── UserRepository.java
    │   │
    │   └── Service/
    │       ├── AdminService.java
    │       ├── AuthService.java
    │       ├── CourseService.java
    │       ├── EnrollmentService.java
    │       ├── ReportService.java
    │       ├── StudentService.java
    │       └── UserService.java
    │
    ├── Database/
    │   └── schema.sql
    │
    ├── mysql-connectojdbcr-j-9.4.0/


# Use case diagrame : 
<img width="723" height="768" alt="use case drawio" src="https://github.com/user-attachments/assets/1045ffc1-0a39-4e9d-9bd6-7ceb031ab0ec" />

# EERD : 
<img width="850" height="782" alt="EERD" src="https://github.com/user-attachments/assets/aa189e58-635e-41aa-84ca-ddf71ebad119" />

# Class diagrame :
<img width="1200" height="1500" alt="Class diagram drawio" src="https://github.com/user-attachments/assets/f8495a5e-97dc-46b9-a87d-c33c9329214c" />

# Tools :

Java - MySQL - JDBC - OOP - SOLID - Design Pattren (DAO) - Graph - topological sort - Git

# Features

### Authentication
- **Login**: Students and administrators can log in with their credentials
- **Sign Up**: New students can register for accounts
- **Role-based Access**: Different menus for students and administrators

### Student Features
- **Add Course**: Enroll in available courses
- **Drop Course**: Remove course enrollments
- **View Enrollments**: See all currently enrolled courses
- **View Available Courses**: Browse all available courses

### Admin Features
- **Add Course**: Create new courses with details
- **Delete Course**: Remove courses from the system
- **Update Course**: Modify existing course information
- **View Courses**: See all courses in the system
- **View Student Information**: Access student details and payment information




