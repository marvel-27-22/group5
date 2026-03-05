public class TimetableApp {
    public static void main(String[] args) {
        Timetable mySchedule = new Timetable("MAHIR SAID", "BITZA/7/23/055/T", "BITA");


        mySchedule.addItem(new Lecture("PT821", "OOP Java", "Dr. Salum", "Room 101", "Monday", "08:00", "10:00", 1, true));
        mySchedule.addItem(new Lab("PT823", "Database Lab", "Ms. Fatma", "Lab 2", "Wednesday", "08:00", "11:00", "MySQL"));
        mySchedule.addItem(new Tutorial("PT825", "Communication", "Mr. Ali", "Room 108", "Friday", "10:00", "11:00", "Group A"));
        
        mySchedule.displayWeeklySchedule();
    }
}