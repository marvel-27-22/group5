public class Student {
    private String registrationNumber;
    private String fullName;
    private String program;
    private int yearOfStudy;
    private String dateOfBirth;
    private String gender;
    private String nationality;
    private String phoneNumber;
    private String emailAddress;
    private String photoPath;

    public Student(String registrationNumber, String fullName, String program, int yearOfStudy, 
                   String dateOfBirth, String gender, String nationality, String phoneNumber, 
                   String emailAddress, String photoPath) {
        this.registrationNumber = registrationNumber;
        this.fullName = fullName;
        this.program = program;
        this.yearOfStudy = yearOfStudy;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.nationality = nationality;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.photoPath = photoPath;
    }

    public String getRegistrationNumber() { return registrationNumber; }
    public void setRegistrationNumber(String rn) { this.registrationNumber = rn; }

    public String getFullName() { return fullName; }
    public void setFullName(String fn) { this.fullName = fn; }

    public String getProgram() { return program; }
    public void setProgram(String p) { this.program = p; }

    public int getYearOfStudy() { return yearOfStudy; }
    public void setYearOfStudy(int y) { this.yearOfStudy = y; }

    public String getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(String dob) { this.dateOfBirth = dob; }

    public String getGender() { return gender; }
    public void setGender(String g) { this.gender = g; }

    public String getNationality() { return nationality; }
    public void setNationality(String n) { this.nationality = n; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String pn) { this.phoneNumber = pn; }

    public String getEmailAddress() { return emailAddress; }
    public void setEmailAddress(String ea) { this.emailAddress = ea; }

    public String getPhotoPath() { return photoPath; }
    public void setPhotoPath(String pp) { this.photoPath = pp; }

    public String generateIDNumber() {
        String lastFour = registrationNumber.length() >= 4 ? 
                          registrationNumber.substring(registrationNumber.length() - 4) : 
                          registrationNumber;
        return "SUZA-" + program.toUpperCase() + "-" + yearOfStudy + "-" + lastFour;
    }

    public String calculateExpiryDate() {
        int startYear = 2024; 
        int duration = (program.equalsIgnoreCase("BITA") || program.equalsIgnoreCase("BCS")) ? 4 : 2;
        return "June " + (startYear + duration);
    }

    @Override
    public String toString() {
        return "Student: " + fullName + " (" + registrationNumber + ")";
    }
}