public class IDCardPrinter {
    public void printIDCard(Student s) {
        if (!validate(s)) {
            System.out.println("Error: Student data is incomplete.");
            return;
        }

        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║     STATE UNIVERSITY OF ZANZIBAR         ║");
        System.out.println("║            STUDENT ID CARD               ║");
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.printf("║  [PHOTO]   Name: %-24s║\n", s.getFullName());
        System.out.printf("║            Reg: %-25s║\n", s.getRegistrationNumber());
        System.out.printf("║            Program: %-21s║\n", s.getProgram());
        System.out.printf("║            Year: %-24s║\n", s.getYearOfStudy());
        System.out.printf("║            ID: %-26s║\n", s.generateIDNumber());
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.printf("║  Valid Until: %-27s║\n", s.calculateExpiryDate());
        System.out.println("╚══════════════════════════════════════════╝");
    }

    private boolean validate(Student s) {
        return s.getRegistrationNumber() != null && !s.getRegistrationNumber().isEmpty() &&
               s.getFullName() != null && !s.getFullName().isEmpty();
    }
}