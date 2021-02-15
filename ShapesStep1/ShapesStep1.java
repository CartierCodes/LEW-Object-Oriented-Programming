public class ShapesStep1
{
    public static void main(String[] args)
    {
        System.out.println("The program is running\n");

        Rectangle newRectangle = new Rectangle(2, 4);
        System.out.println("Rectangle:\nLength = " + newRectangle.getLength());
        System.out.println("Width = " + newRectangle.getWidth());
        System.out.println("Area = " + newRectangle.calcArea());
        System.out.println("Perimeter = " + newRectangle.calcPerimeter());
        System.out.println("Coordinates = (" + newRectangle.getX() + ", " + newRectangle.getY() + ")\n");
    }
}

abstract class Shape
{
    // SHAPE CONSTRUCTORS
    public Shape()
    {
        this(0, 0, 0, 0);
    }

    public Shape(double length, double width)
    {
        this(length, width, 0, 0);
    }

    public Shape(double length, double width, double x, double y)
    {
        this.length = length;
        this.width = width;
        this.x = x;
        this.y = y;
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

    // SHAPE CALCULATE METHODS
    public abstract double calcArea();
    public abstract double calcPerimeter();
}

class Rectangle extends Shape
{
    // RECTANGLE CONSTRUCTORS
    public Rectangle()
    {
        this(0, 0, 0, 0);
    }

    public Rectangle(double length, double width)
    {
        this(length, width, 0, 0);
    }

    public Rectangle(double length, double width, double x, double y)
    {
        super(length, width, x, y);
    }

    // RECTANGLE CALCULATE METHODS
    public double calcArea() { return getLength() * getWidth(); }
    public double calcPerimeter() { return 2 * getLength() +  2 * getWidth(); }
}