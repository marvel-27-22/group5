public class Rectangle {

    private double length;
    private double width;
    private String color;
    private boolean isFilled;

    public Rectangle() {
        this.length = 1.0;
        this.width = 1.0;
        this.color = "white";
        this.isFilled = false;
    }

    public Rectangle(double length, double width) {
        this();
        setLength(length);
        setWidth(width);
    }

    public Rectangle(double length, double width, String color, boolean isFilled) {
        setLength(length);
        setWidth(width);
        this.color = color;
        this.isFilled = isFilled;
    }

    public double getLength() { 
        return length;
     }
    public double getWidth() {
         return width; 
        }
    public String getColor() { 
        return color; 
    }
    public boolean isFilled() {
         return isFilled; 
        }

    public void setLength(double length) {
        if (length > 0) {
            this.length = length;
        }
    }

    public void setWidth(double width) {
        if (width > 0) {
            this.width = width;
        }
    }

    public void setColor(String color) { this.color = color; }
    public void setFilled(boolean isFilled) { this.isFilled = isFilled; }

    public double calculateArea() {
        return length * width;
    }

    public double calculatePerimeter() {
        return 2 * (length + width);
    }

    public double calculateDiagonal() {
        return Math.sqrt(Math.pow(length, 2) + Math.pow(width, 2));
    }

    public boolean isSquare() {
        return length == width;
    }

    public void resize(double factor) {
        if (factor > 0) {
            this.length *= factor;
            this.width *= factor;
        }
    }

    public String compare(Rectangle other) {
        double thisArea = this.calculateArea();
        double otherArea = other.calculateArea();

        if (thisArea > otherArea) return "larger";
        if (thisArea < otherArea) return "smaller";
        return "equal";
    }

    public void displayInfo() {
        System.out.println("Rectangle [" + color + ", Filled: " + isFilled + "]");
        System.out.println("Dimensions: " + length + " x " + width);
        System.out.println("Area: " + calculateArea());
        System.out.println("Perimeter: " + calculatePerimeter());
        System.out.println("Diagonal: " + String.format("%.2f", calculateDiagonal()));
        System.out.println("Square: " + isSquare());
        System.out.println("---------------------------");
    }

    public static void main(String[] args) {
        System.out.println("=== Rectangle Geometry Exercise ===\n");

        Rectangle rect1 = new Rectangle();
        Rectangle rect2 = new Rectangle(10, 5);
        Rectangle rect3 = new Rectangle(7, 7, "blue", true);

        rect1.displayInfo();
        rect2.displayInfo();
        rect3.displayInfo();

        System.out.println("Is rect1 a square? " + rect1.isSquare());
        System.out.println("Is rect2 a square? " + rect2.isSquare());
        System.out.println("Is rect3 a square? " + rect3.isSquare());

        System.out.println("\nComparing rect1 to rect2: rect1 is " + rect1.compare(rect2));

        System.out.println("\nResizing rect1 by factor of 3...");
        rect1.resize(3);
        rect1.displayInfo();

        double totalArea = rect1.calculateArea() + rect2.calculateArea() + rect3.calculateArea();
        System.out.println("Total area of all rectangles: " + totalArea);

        System.out.println("\n=== Exercise Complete ===");
    }
}