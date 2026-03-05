import java.util.ArrayList;
import java.util.Scanner;

public class BookingSystem {
    private ArrayList<Route> routes = new ArrayList<>();
    private ArrayList<Ticket> bookings = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        BookingSystem bs = new BookingSystem();
        bs.initData();
        bs.run();
    }

    private void initData() {
        Route r1 = new Route("R01", "Bububu", "Darajani", 8.5, 1000, 30);
        r1.addStop("Mtoni"); r1.addStop("Saateni");
        
        Route r2 = new Route("R02", "Darajani", "Chwaka", 28.0, 2500, 60);
        r2.addStop("Mwanakwerekwe"); r2.addStop("Tunguu"); r2.addStop("Dunga");
        
        Route r3 = new Route("R03", "Darajani", "Nungwi", 56.0, 4000, 120);
        Route r4 = new Route("R04", "Darajani", "Paje", 42.0, 3000, 80);
        Route r5 = new Route("R05", "Fuoni", "Darajani", 6.0, 800, 20);

        routes.add(r1); routes.add(r2); routes.add(r3); routes.add(r4); routes.add(r5);
    }

    public void run() {
        while (true) {
            System.out.println("\n--- ZANZIBAR DALADALA BOOKING ---");
            System.out.println("1. View Routes\n2. Book Ticket\n3. My Bookings\n4. Cancel Booking\n5. Exit");
            System.out.print("Select: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    for (Route r : routes) System.out.println(r.getRouteInfo());
                    break;
                case 2:
                    bookTicket();
                    break;
                case 3:
                    for (Ticket t : bookings) t.printTicket();
                    break;
                case 4:
                    System.out.print("Enter Ticket ID to cancel: ");
                    String id = scanner.nextLine();
                    bookings.removeIf(t -> t.getTicketId().equals(id));
                    System.out.println("Cancelled.");
                    break;
                case 5:
                    return;
            }
        }
    }

    private void bookTicket() {
        System.out.println("Select Route Index (0 to " + (routes.size()-1) + "):");
        int idx = scanner.nextInt(); scanner.nextLine();
        
        System.out.print("Passenger Name: "); String name = scanner.nextLine();
        System.out.print("Are you a Student? (true/false): "); boolean isStudent = scanner.nextBoolean();
        
        Ticket t = new Ticket(name, "0771234567", routes.get(idx), "2026-02-27", "07:30 AM", isStudent, 12);
        bookings.add(t);
        t.printTicket();
    }
}