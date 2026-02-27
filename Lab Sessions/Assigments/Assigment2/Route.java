import java.util.ArrayList;

public class Route {
    private String routeId;
    private String startPoint;
    private String endPoint;
    private double distance;
    private double baseFare;
    private int estimatedTime;
    private ArrayList<String> stops;

    public Route(String routeId, String startPoint, String endPoint, double distance, double baseFare, int estimatedTime) {
        this.routeId = routeId;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.distance = distance;
        this.baseFare = baseFare;
        this.estimatedTime = estimatedTime;
        this.stops = new ArrayList<>();
    }

    public void addStop(String stop) {
        stops.add(stop);
    }

    public double calculateFare(boolean isStudent) {
        if (isStudent) {
            return baseFare * 0.8; // 20% discount
        }
        return baseFare;
    }

    public String getRouteInfo() {
        return String.format("[%s] %s to %s (%.1f km) - TSh %.0f", 
            routeId, startPoint, endPoint, distance, baseFare);
    }

    // Getters
    public String getStartPoint() { return startPoint; }
    public String getEndPoint() { return endPoint; }
    public double getBaseFare() { return baseFare; }
    public ArrayList<String> getStops() { return stops; }
}
