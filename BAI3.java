
package labtuan5;
abstract class Shape {
    protected String color;
    protected boolean filled;

    public Shape() {
        this.color = "red";
        this.filled = true;
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public abstract double getArea();
    public abstract double getPerimeter();
    public abstract String toString();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Shape s = (Shape) obj;
        return filled == s.filled && color.equals(s.color);
    }
}

class Circle extends Shape {
    private double radius;

    public Circle() {
        super();
        this.radius = 0;
    }

    public Circle(double radius) {
        super();
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Hinh tron [radius=" + radius + ", color=" + color + ", filled=" + filled + "]";
    }
}

class Rectangle extends Shape {
    private double width;
    private double length;

    public Rectangle() {
        super();
        this.width = 0;
        this.length = 0;
    }

    public Rectangle(double width, double length) {
        super();
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public String toString() {
        return "Hinh chu nhat [width=" + width + ", length=" + length + ", color=" + color + ", filled=" + filled + "]";
    }
}

class Square extends Rectangle {
    public Square() {
        super();
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }

    @Override
    public void setWidth(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    @Override
    public void setLength(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    @Override
    public String toString() {
        return "Hinh vuong [side=" + getSide() + ", color=" + color + ", filled=" + filled + "]";
    }
}

public class BAI3{
    public static void main(String[] args) {
        Circle c = new Circle(5, "blue", true);
        Rectangle r = new Rectangle(4, 6, "green", false);
        Square s = new Square(3, "yellow", true);

        System.out.println("Thong tin hinh tron:");
        System.out.println(c.toString());

        System.out.println("Thong tin hinh chu nhat:");
        System.out.println(r.toString());

        System.out.println("Thong tin hinh vuong:");
        System.out.println(s.toString());

        System.out.println("Kiem tra equals:");
        System.out.println("Circle va Rectangle co bang nhau khong? " + c.equals(r));
        System.out.println("Rectangle va Square co bang nhau khong? " + r.equals(s));
    }
}
