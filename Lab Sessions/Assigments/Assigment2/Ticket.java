import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Ticket {
    private String ticketId;
    private String passengerName;
    private String passengerPhone;
    private Route route;
    private String travelDate;
    private String travelTime;
    private boolean isStudentTicket;
    private int seatNumber;
    private String bookingTime;

    public Ticket(String passengerName, String passengerPhone, Route route, 
                  String travelDate, String travelTime, boolean isStudentTicket, int seatNumber) {
        this.passengerName = passengerName;
        this.passengerPhone = passengerPhone;
        this.route = route;
        this.travelDate = travelDate;
        this.travelTime = travelTime;
        this.isStudentTicket = isStudentTicket;
        this.seatNumber = seatNumber;
        this.ticketId = generateTicketId();
        this.bookingTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    private String generateTicketId() {
        String datePart = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        int randomNum = new Random().nextInt(9000) + 1000;
        return "TKT-" + datePart + "-" + randomNum;
    }

    public void printTicket() {
        double base = route.getBaseFare();
        double total = route.calculateFare(isStudentTicket);
        double discount = base - total;

        System.out.println("\n    ┌─────────────────────────────────────────┐");
        System.out.println("    │     ZANZIBAR BUS TICKET                 │");
        System.out.println("    │     ═══════════════════                 │");
        System.out.println("    ├─────────────────────────────────────────┤");
        System.out.printf("    │  Ticket No: %-28s│\n", ticketId);
        System.out.printf("    │  Passenger: %-28s│\n", passengerName);
        System.out.printf("    │  Phone: %-32s│\n", passengerPhone);
        System.out.printf("    │  Student: %-30s│\n", (isStudentTicket ? "YES (20% Discount)" : "NO"));
        System.out.println("    ├─────────────────────────────────────────┤");
        System.out.printf("    │  FROM: %-33s│\n", route.getStartPoint());
        System.out.printf("    │  TO: %-35s│\n", route.getEndPoint());
        String via = String.join(" → ", route.getStops());
        System.out.printf("    │  VIA: %-34s│\n", (via.length() > 30 ? via.substring(0, 27) + "..." : via));
        System.out.println("    │                                         │");
        System.out.printf("    │  Date: %-33s│\n", travelDate);
        System.out.printf("    │  Time: %-33s│\n", travelTime);
        System.out.printf("    │  Seat: %-33s│\n", seatNumber);
        System.out.println("    ├─────────────────────────────────────────┤");
        System.out.printf("    │  Base Fare: TSh %-24.0f│\n", base);
        System.out.printf("    │  Discount:  TSh %-24.0f│\n", discount);
        System.out.printf("    │  TOTAL:     TSh %-24.0f│\n", total);
        System.out.println("    └─────────────────────────────────────────┘");
    }

    public String getTicketId() { return ticketId; }
}