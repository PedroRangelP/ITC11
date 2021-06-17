package shapes;

public abstract class Triangle extends Shape {
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }

    public double getSideC() {
        return sideC;
    }

    @Override
    public double calculateArea() {
        // This is Heron´s fromula to calculate any triangle´s area
        double sumOfDigits = (sideA + sideB + sideC) / 2;
        return Math.sqrt(sumOfDigits * (sumOfDigits - sideA) * (sumOfDigits - sideB) * (sumOfDigits - sideC));
    }

    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }

}