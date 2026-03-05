public abstract class ScheduleItem {
    protected String courseCode, courseName, instructor, venue, dayOfWeek, startTime, endTime;

    public ScheduleItem(String code, String name, String instructor, String venue, String day, String start, String end) {
        this.courseCode = code;
        this.courseName = name;
        this.instructor = instructor;
        this.venue = venue;
        this.dayOfWeek = day;
        this.startTime = start;
        this.endTime = end;
    }

    public abstract int getDuration(); 
    public abstract String getItemType();

    public String getDayOfWeek() { return dayOfWeek; }
    public String getStartTime() { return startTime; }
    public String getCourseCode() { return courseCode; }
    public String getVenue() { return venue; }

    @Override
    public String toString() {
        return String.format("%s: %s (%s) at %s", getItemType(), courseCode, courseName, venue);
    }
}

