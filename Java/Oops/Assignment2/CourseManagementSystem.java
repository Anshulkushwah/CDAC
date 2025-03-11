// Base class Course
class Course {
    String courseCode;
    String courseName;
    int credits;

    // Constructor
    public Course(String courseCode, String courseName, int credits) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
    }

    // Method to display course information (common for all courses)
    public void displayCourseInfo() {
        System.out.println("Course Code: " + courseCode);
        System.out.println("Course Name: " + courseName);
        System.out.println("Credits: " + credits);
    }

    // Method to determine the mode of delivery (to be overridden in subclasses)
    public void deliveryMode() {
        System.out.println("Mode of Delivery: Not specified.");
    }
}

// Subclass OnlineCourse that extends Course
class OnlineCourse extends Course {
    String platform;

    // Constructor
    public OnlineCourse(String courseCode, String courseName, int credits, String platform) {
        super(courseCode, courseName, credits);
        this.platform = platform;
    }

    // Override method to display course information (including platform)
    @Override
    public void displayCourseInfo() {
        super.displayCourseInfo();
        System.out.println("Platform: " + platform);
    }

    // Override method to specify that the course is delivered online
    @Override
    public void deliveryMode() {
        System.out.println("Mode of Delivery: Online, via " + platform + ".");
    }
}

// Subclass OnCampusCourse that extends Course
class OnCampusCourse extends Course {
    String classroomNumber;

    // Constructor
    public OnCampusCourse(String courseCode, String courseName, int credits, String classroomNumber) {
        super(courseCode, courseName, credits);
        this.classroomNumber = classroomNumber;
    }

    // Override method to display course information (including classroom number)
    @Override
    public void displayCourseInfo() {
        super.displayCourseInfo();
        System.out.println("Classroom Number: " + classroomNumber);
    }

    // Override method to specify that the course is delivered on-campus
    @Override
    public void deliveryMode() {
        System.out.println("Mode of Delivery: On-campus, in classroom " + classroomNumber + ".");
    }
}

// Main class to test the implementation
public class CourseManagementSystem {
    public static void main(String[] args) {
        // Create instances of OnlineCourse and OnCampusCourse
        OnlineCourse onlineCourse = new OnlineCourse("CS101", "Introduction to Computer Science", 3, "Zoom");
        OnCampusCourse onCampusCourse = new OnCampusCourse("BIO202", "Biology 101", 4, "Room 301");

        // Display course information and delivery mode for each course
        System.out.println("Online Course Info:");
        onlineCourse.displayCourseInfo();
        onlineCourse.deliveryMode();
        
        System.out.println("\nOn-Campus Course Info:");
        onCampusCourse.displayCourseInfo();
        onCampusCourse.deliveryMode();
    }
}
