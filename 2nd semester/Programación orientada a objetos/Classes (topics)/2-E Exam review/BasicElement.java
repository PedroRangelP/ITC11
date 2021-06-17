public class BasicElement implements IElement {
	private int upperLeftX, upperLeftY;
	private int lowerRightX, lowerRightY;
	private String color;
	
	public double getArea() {
		double area;
		area = (upperLeftX - lowerRightX) * (upperLeftY - lowerRightY);
		return Math.abs(area);
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	//Getters and setters for all the attributes
}