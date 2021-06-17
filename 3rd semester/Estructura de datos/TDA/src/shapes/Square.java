package shapes;

public class Square extends Shape {

    private double side;

    public Square(double side) {
        super();
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }

    @Override
    public double calculatePerimeter() {
        return side * 4;
    }

}