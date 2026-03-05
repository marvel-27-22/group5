public class Course {

    private String courseCode;
    private String courseName;
    private String instructorName;
    private int creditHours;
    private int maxCapacity;
    private int enrolledStudents;
    private boolean isActive;

    public Course() {
        this.enrolledStudents = 0;
        this.isActive = true;
    }

    public Course(String courseCode, String courseName, int creditHours, int maxCapacity) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        setCreditHours(creditHours);
        setMaxCapacity(maxCapacity);
        this.enrolledStudents = 0;
        this.isActive = true;
    }

    public String getCourseCode() {
         return courseCode;
         }
    public String getCourseName() { 
        return courseName; 
    }
    public String getInstructorName() {
         return instructorName;
         }
    public int getCreditHours() { 
        return creditHours;
     }
    public int getMaxCapacity() { 
        return maxCapacity; 
    }
    public int getEnrolledStudents() {
         return enrolledStudents;
         }
    public boolean isIsActive() {
         return isActive; 
        }

    public void setCourseCode(String courseCode) { 
        this.courseCode = courseCode; 
    }
    public void setCourseName(String courseName) { 
        this.courseName = courseName; 
    }
    
    public void setCreditHours(int creditHours) {
        if (creditHours >= 1 && creditHours <= 6) {
            this.creditHours = creditHours;
        }
    }

    public void setMaxCapacity(int maxCapacity) {
        if (maxCapacity > 0) {
            this.maxCapacity = maxCapacity;
        }
    }

    public void assignInstructor(String name) {
        this.instructorName = name;
    }

    public boolean enrollStudent() {
        if (enrolledStudents < maxCapacity) {
            enrolledStudents++;
            return true;
        }
        return false;
    }

    public void dropStudent() {
        if (enrolledStudents > 0) {
            enrolledStudents--;
        }
    }

    public int getAvailableSeats() {
        return maxCapacity - enrolledStudents;
    }

    public boolean isFull() {
        return enrolledStudents >= maxCapacity;
    }

    public void cancelCourse() {
        if (enrolledStudents == 0) {
            isActive = false;
        }
    }

    public void displayCourseInfo() {
        System.out.println("Course: " + courseCode + " - " + courseName);
        System.out.println("Instructor: " + instructorName);
        System.out.println("Credits: " + creditHours);
        System.out.println("Enrollment: " + enrolledStudents + "/" + maxCapacity);
        System.out.println("Status: " + (isActive ? "Active" : "Inactive"));
        System.out.println("---------------------------");
    }

    public static void main(String[] args) {
        System.out.println("=== University Course Exercise ===\n");

        Course course1 = new Course("PT821", "Object-Oriented Programming", 3, 40);
        Course course2 = new Course("PT822", "Database Systems", 3, 35);

        course1.assignInstructor("Dr. Smith");
        course2.assignInstructor("Prof. Jones");

        for (int i = 0; i < 38; i++) {
            course1.enrollStudent();
        }

        course1.displayCourseInfo();

        System.out.println("Available seats in course1: " + course1.getAvailableSeats());

        for (int i = 0; i < 5; i++) {
            boolean success = course1.enrollStudent();
            if (!success) {
                System.out.println("Failed to enroll student " + (i + 1) + ": Course is full.");
            }
        }

        System.out.println("Is course1 full? " + course1.isFull());

        course1.dropStudent();
        course1.dropStudent();
        course1.dropStudent();

        course1.displayCourseInfo();
        course2.displayCourseInfo();

        System.out.println("\n=== Exercise Complete ===");
    }
}