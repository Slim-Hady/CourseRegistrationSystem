# Course Registration System

A Java-based console application for managing course registrations in an educational institution.

## Features

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

## Prerequisites

- Java 8 or higher
- MySQL Database
- MySQL JDBC Driver (mysql-connector-java-9.4.0.jar)

## Database Setup

1. Create a MySQL database named `CourseRegistrationSystem`
2. Update database connection settings in `src/Entits/DBConnection.java`:
   ```java
   static String host = "jdbc:mysql://127.0.0.1:3306/CourseRegistrationSystem";
   static String username = "your_username";
   static String password = "your_password";
   ```
3. Run the SQL script in `Database/schema.sql` to create tables and sample data

## Default Credentials

### Admin Account
- **Username**: admin
- **Password**: admin
- **ID**: 12345
- **Role**: admin

## How to Run

1. Compile the project:
   ```bash
   javac -cp ".:mysql-connector-java-9.4.0/mysql-connector-java-9.4.0.jar" src/Entits/*.java src/Service/*.java src/Reposatory/*.java src/Interfaces/*.java
   ```

2. Run the application:
   ```bash
   java -cp ".:mysql-connector-java-9.4.0/mysql-connector-java-9.4.0.jar:src" Entits.Main
   ```

## Project Structure

```
src/
├── Entits/           # Entity classes (User, Student, Course, Enrollment)
├── Interfaces/       # Interface definitions
├── Reposatory/      # Data access layer
├── Service/         # Business logic layer
└── Database/        # Database schema and sample data
```

## Database Schema

- **Users**: Stores user authentication and role information
- **Students**: Contains student-specific information (email, payment)
- **Courses**: Stores course details (name, doctor, hours, date)
- **Enrollment**: Manages student-course relationships

## Error Handling

The system includes comprehensive error handling for:
- Database connection issues
- Invalid user input
- Course not found scenarios
- Duplicate enrollment attempts
- Authentication failures

## Security Features

- Password-based authentication
- Role-based access control
- Input validation
- SQL injection prevention through prepared statements

## Future Enhancements

- Password hashing
- Session management
- Course capacity limits
- Payment processing
- Grade management
- Course prerequisites
- Student transcripts

## Troubleshooting

### Database Connection Issues
- Verify MySQL service is running
- Check database credentials in DBConnection.java
- Ensure database and tables exist

### Compilation Errors
- Verify Java version compatibility
- Check classpath includes all required dependencies
- Ensure all source files are in correct packages

### Runtime Errors
- Check database connection
- Verify table structure matches entity classes
- Review error messages for specific issues

## Support

For technical support or questions, please refer to the code comments or create an issue in the project repository.
