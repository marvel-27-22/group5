class CircleBasic {
    private double radius = 1.0;
    private String color = "red";

    public CircleBasic() {}

    public CircleBasic(double radius) {
        this.radius = radius;
    }

    public CircleBasic(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle[radius=" + radius + ", color=" + color + "]";
    }
}

class Cylinder extends CircleBasic {
    private double height = 1.0;

    public Cylinder() {
        super();
    }

    public Cylinder(double radius) {
        super(radius);
    }

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public Cylinder(double radius, double height, String color) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return getArea() * height;
    }

    @Override
    public String toString() {
        return "Cylinder[" + super.toString() + ", height=" + height + "]";
    }
}

public class Lab1_CircleCylinder {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("  Lab 1: Circle and Cylinder Hierarchy");
        System.out.println("========================================\n");

        System.out.println("--- Section 1: Basic Object Creation ---");
        CircleBasic c1 = new CircleBasic(5.0, "blue");
        System.out.println("Circle: " + c1);
        System.out.println("Area: " + c1.getArea());

        Cylinder cy1 = new Cylinder(5.0, 10.0, "green");
        System.out.println("\nCylinder: " + cy1);
        System.out.println("Base Area: " + cy1.getArea());
        System.out.println("Volume: " + cy1.getVolume());

        System.out.println("\n--- Section 2: Upcasting ---");
        CircleBasic c2 = new Cylinder(3.0, 7.0, "yellow");
        System.out.println("c2 is a: " + c2.getClass().getSimpleName());
        System.out.println("c2.toString(): " + c2);
        System.out.println("c2.getArea(): " + c2.getArea());
        System.out.println("c2.getRadius(): " + c2.getRadius());

        System.out.println("\n--- Section 3: Downcasting ---");
        CircleBasic c3 = new Cylinder(4.0, 8.0, "purple");
        Cylinder cy2 = (Cylinder) c3;
        System.out.println("After downcast: " + cy2);
        System.out.println("Now we can call getVolume(): " + cy2.getVolume());

        System.out.println("\n--- Section 4: instanceof Operator ---");
        CircleBasic[] shapes = {
            new CircleBasic(2.0, "red"),
            new Cylinder(3.0, 5.0, "blue"),
            new CircleBasic(4.0, "green"),
            new Cylinder(1.0, 10.0, "orange")
        };

        for (CircleBasic shape : shapes) {
            System.out.println(shape);
            if (shape instanceof Cylinder) {
                Cylinder temp = (Cylinder) shape;
                System.out.println("  -> This is a Cylinder! Volume = " + temp.getVolume());
            } else {
                System.out.println("  -> This is just a Circle. Area = " + shape.getArea());
            }
        }

        System.out.println("\n========================================");
        System.out.println("  End of Lab 1");
        System.out.println("========================================");
    }
}