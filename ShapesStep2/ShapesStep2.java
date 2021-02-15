import java.util.ArrayList;
public class ShapesStep2
{
    public static void main(String[] args)
    {
        ArrayList<Shape> list = new ArrayList<Shape>();

        for (int i = 1; i < 5; i++)
        {
            list.add(new Circle(i));
            list.add(new Rectangle(5-i, i));
            list.add(new RightTriangle(i, 5-i));
        }

        for (Shape s: list)
        {
            System.out.println(s);
        }
    }
}

abstract class Shape
{
    // SHAPE CONSTRUCTORS
    public Shape()
    {
        this(0, 0, 0, 0, "white");
    }

    public Shape(double length, double width)
    {
        this(length, width, 0, 0, "white");
    }

    public Shape(double length, double width, double x, double y, String color)
    {
        this.length = length;
        this.width = width;
        this.x = x;
        this.y = y;
        this.color = color;
    }

    // SHAPE FIELDS + GET/SET METHODS
    private double x;
    public double getX() { return x; }
    public void setX(double x) { this.x = x; }

    private double y;
    public double getY() { return y; }
    public void setY(double y) { this.y = y; }

    private double length;
    public double getLength() { return length; }
    public void setLength(double length) { this.length = length; }

    private double width;
    public double getWidth() { return width; }
    public void setWidth(double width) { this.width = width; }

    private String color;
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    // SHAPE CALCULATE METHODS
    public abstract double calcArea();
    public abstract double calcPerimeter();

    // SHAPE TOSTRING METHOD
    public String toString()
    {
        return String.format("Length = %.1f\nWidth = %.1f\nArea = %.1f\nPerimeter = %.1f\nCoordinates = (%.1f, %.1f)\n", length, width, calcArea(), calcPerimeter(), x, y);
    }
}

class Rectangle extends Shape
{
    // RECTANGLE CONSTRUCTORS
    public Rectangle()
    {
        this(0, 0, 0, 0, "white");
    }

    public Rectangle(double length, double width)
    {
        this(length, width, 0, 0, "white");
    }

    public Rectangle(double length, double width, double x, double y, String color)
    {
        super(length, width, x, y, color);
    }

    // RECTANGLE CALCULATE METHODS
    public double calcArea() { return getLength() * getWidth(); }
    public double calcPerimeter() { return 2 * getLength() +  2 * getWidth(); }

    // RECTANGLE TOSTRING METHOD
    public String toString()
    {
        return String.format("Rectangle:\n%s", super.toString());
    }
}

class RightTriangle extends Shape
{
    // RIGHT TRIANGLE CONSTRUCTORS
    public RightTriangle()
    {
        this(0, 0, 0, 0, "white");
    }

    public RightTriangle(double length, double width)
    {
        this(length, width, 0, 0, "white");
    }

    public RightTriangle(double length, double width, double x, double y, String color)
    {
        super(length, width, x, y, color);
        setHypo();
    }

    // RIGHT TRIANGLE FIELD + GET/SET METHOD
    private double hypo;
    public double getHypo() { return hypo; }
    public void setHypo() { hypo = Math.sqrt(Math.pow(getLength(), 2) + Math.pow(getWidth(), 2)); }
    
    // RIGHT TRIANGLE CALCULATE METHODS
    public double calcArea() { return getLength() * getWidth() / 2; }
    public double calcPerimeter() { return getHypo() + getLength() + getWidth(); }

    // RIGHT TRIANGLE TOSTRING
    public String toString()
    {
        return String.format("Right Triangle:\n%sHypotenuse = %.1f\n", super.toString(), hypo);
    }
}

class Circle extends Shape
{
    // CIRCLE CONSTRUCTORS
    public Circle()
    {
        this(0, 0, 0, "white");
    }

    public Circle(double radius)
    {
        this(radius, 0, 0, "white");
    }

    public Circle(double radius, double x, double y, String color)
    {
        super(radius * 2, radius * 2, x, y, color);
        this.radius = radius;
    }

    // CIRCLE FIELD + SET/GET METHODS
    private double radius;
    public double getRadius() { return radius; }
    public void setRadius(double radius) { this.radius = radius; }

    // CIRCLE CALCULATE METHODS
    public double calcArea() { return Math.PI * Math.pow(radius, 2); }
    public double calcPerimeter() { return 2 * Math.PI * radius; }

    // CIRCLE TOSTRING METHOD
    public String toString()
    {
        return String.format("Circle:\n%sRadius = %.1f\n", super.toString(), radius);
    }
}