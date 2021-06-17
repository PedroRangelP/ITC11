public class BasicElement extends Element {
    public double upperLeft;
    public double lowerRight;
    public String basicColor;
    public double basicArea;


    public void calculateArea(double upperLeft, double lowerRight) {
        this.upperLeft = upperLeft;
        this.lowerRight = lowerRight;

        double width, height;
        height = upperLeft-lowerRight;
        width = lowerRight-upperLeft;
        this.basicArea = height*width;
    }

}