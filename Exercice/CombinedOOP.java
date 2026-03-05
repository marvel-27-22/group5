import java.util.Arrays;

interface Enrollable {
    void enroll(String courseCode);
    void drop(String courseCode);
    String[] getEnrolledCourses();
    int getCourseCount();
}

interface Gradeable {
    void addGrade(String courseCode, double grade);
    double getGrade(String courseCode);
    double calculateGPA();
    String getAcademicStanding();
}

interface Payable {
    double calculatePay();
    void processPayment();
    String getPaymentDetails();
}

abstract class Person {
    protected String id, name, email, phone, dob;

    public Person(String id, String name, String email, String phone, String dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.dob = dob;
    }

    public abstract String getRole();

    public void displayBasicInfo() {
        System.out.println("ID: " + id + " | Name: " + name + " | Role: " + getRole());
    }

    public void updateContact(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }
}

abstract class UniversityMember extends Person {
    protected String department, joinDate;

    public UniversityMember(String id, String name, String email, String phone, String dob, String dept, String joinDate) {
        super(id, name, email, phone, dob);
        this.department = dept;
        this.joinDate = joinDate;
    }

    public abstract String[] getPrivileges();

    public void displayMemberInfo() {
        displayBasicInfo();
        System.out.println("Dept: " + department + " | Joined: " + joinDate);
    }
}

class Student extends UniversityMember implements Enrollable, Gradeable {
    private String program;
    private int year;
    private String[] courses = new String[10];
    private double[] grades = new double[10];
    private int courseCount = 0;

    public Student(String id, String name, String email, String phone, String dob, String dept, String joinDate, String program, int year) {
        super(id, name, email, phone, dob, dept, joinDate);
        this.program = program;
        this.year = year;
    }

    public void enroll(String code) {
        if (courseCount < 10) courses[courseCount++] = code;
    }

    public void drop(String code) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].equals(code)) {
                courses[i] = courses[courseCount - 1];
                courseCount--;
            }
        }
    }

    public String[] getEnrolledCourses() { return Arrays.copyOf(courses, courseCount); }
    public int getCourseCount() { return courseCount; }

    public void addGrade(String code, double grade) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].equals(code)) grades[i] = grade;
        }
    }

    public double getGrade(String code) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].equals(code)) return grades[i];
        }
        return 0;
    }

    public double calculateGPA() {
        if (courseCount == 0) return 0;
        double sum = 0;
        for (int i = 0; i < courseCount; i++) sum += grades[i];
        return (sum / courseCount) / 25.0; 
    }

    public String getAcademicStanding() {
        return calculateGPA() >= 2.0 ? "Good Standing" : "Probation";
    }

    public String getRole() { return "Student"; }
    public String[] getPrivileges() { return new String[]{"Library", "Lab Access"}; }
}

class Professor extends UniversityMember implements Payable {
    private String rank;
    private double salary;
    private String[] coursesTaught = new String[5];
    private int teachingCount = 0;

    public Professor(String id, String name, String email, String phone, String dob, String dept, String joinDate, String rank, double salary) {
        super(id, name, email, phone, dob, dept, joinDate);
        this.rank = rank;
        this.salary = salary;
    }

    public void assignCourse(String code) { if (teachingCount < 5) coursesTaught[teachingCount++] = code; }

    public double calculatePay() {
        double bonus = rank.equals("Full") ? 500000 : 200000;
        return salary + bonus + (teachingCount * 100000);
    }

    public void processPayment() { System.out.println("Salary paid to " + name); }
    public String getPaymentDetails() { return "Rank: " + rank + " | Pay: TZS " + calculatePay(); }
    public String getRole() { return "Professor"; }
    public String[] getPrivileges() { return new String[]{"Faculty Lounge", "Research Grant"}; }
}

class TeachingAssistant extends UniversityMember implements Enrollable, Gradeable, Payable {
    private double hourlyRate;
    private int hoursWorked;
    private String[] courses = new String[5];
    private double[] grades = new double[5];
    private int courseCount = 0;

    public TeachingAssistant(String id, String name, String email, String phone, String dob, String dept, String joinDate, double rate) {
        super(id, name, email, phone, dob, dept, joinDate);
        this.hourlyRate = rate;
    }

    public void setHours(int h) { this.hoursWorked = h; }
    public void enroll(String c) { if (courseCount < 5) courses[courseCount++] = c; }
    public void drop(String c) { courseCount--; }
    public String[] getEnrolledCourses() { return courses; }
    public int getCourseCount() { return courseCount; }
    public void addGrade(String c, double g) { grades[0] = g; }
    public double getGrade(String c) { return grades[0]; }
    public double calculateGPA() { return 4.0; }
    public String getAcademicStanding() { return "Excellent"; }
    public double calculatePay() { return hourlyRate * hoursWorked; }
    public void processPayment() { System.out.println("TA Stipend processed"); }
    public String getPaymentDetails() { return "Hours: " + hoursWorked + " | Pay: " + calculatePay(); }
    public String getRole() { return "Teaching Assistant"; }
    public String[] getPrivileges() { return new String[]{"Grading Access"}; }
}

class Course {
    private String code, name;
    private Professor instructor;
    private Student[] enrolled;
    private int count = 0;

    public Course(String code, String name, int credits, Professor instructor, int max) {
        this.code = code;
        this.name = name;
        this.instructor = instructor;
        this.enrolled = new Student[max];
    }

    public void addStudent(Student s) {
        if (count < enrolled.length) enrolled[count++] = s;
    }

    public void displayCourseInfo() {
        System.out.println("Course: " + code + " | " + name + " | Instructor: " + instructor.name);
    }
}

class University {
    private UniversityMember[] members;
    private Course[] courses;
    private int mCount = 0, cCount = 0;

    public University(String name, int mSize, int cSize) {
        members = new UniversityMember[mSize];
        courses = new Course[cSize];
    }

    public void addMember(UniversityMember m) { members[mCount++] = m; }
    public void addCourse(Course c) { courses[cCount++] = c; }

    public double getTotalPayroll() {
        double total = 0;
        for (int i = 0; i < mCount; i++) {
            if (members[i] instanceof Payable) total += ((Payable) members[i]).calculatePay();
        }
        return total;
    }

    public void displayStatistics() {
        System.out.println("Total Members: " + mCount);
        System.out.println("Total Courses: " + cCount);
        System.out.println("Total Payroll: TZS " + getTotalPayroll());
    }
}

public class CombinedOOP {
    public static void main(String[] args) {
        System.out.println("=== UNIVERSITY SYSTEM TEST ===\n");

        University suza = new University("SUZA", 50, 20);
        Professor p1 = new Professor("P001", "Dr. Amina", "a@suza.tz", "077", "1980", "CS", "2010", "Full", 3000000);
        Student s1 = new Student("S001", "Fatma", "f@suza.tz", "071", "2002", "CS", "2022", "BSc CS", 2);
        TeachingAssistant ta1 = new TeachingAssistant("T001", "Omar", "o@suza.tz", "071", "1998", "CS", "2023", 15000);
        ta1.setHours(40);

        Course oop = new Course("PT821", "OOP", 3, p1, 40);
        
        suza.addMember(p1);
        suza.addMember(s1);
        suza.addMember(ta1);
        suza.addCourse(oop);

        s1.enroll("PT821");
        s1.addGrade("PT821", 85.0);
        oop.addStudent(s1);

        System.out.println("--- Member Check ---");
        s1.displayMemberInfo();
        System.out.println("GPA: " + s1.calculateGPA());
        
        System.out.println("\n--- Payroll Check ---");
        System.out.println(p1.getPaymentDetails());
        System.out.println(ta1.getPaymentDetails());
        
        System.out.println("\n--- University Stats ---");
        suza.displayStatistics();
    }
}