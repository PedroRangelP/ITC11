public class Group implements IElement {
	private BasicElement[] elements;
	private int counter;
	
	public Group() {
		elements = new BasicElement[100];
		counter = 0;
	}
	
	public void addElement(BasicElement be) {
		elements[counter] = be;
		counter++;
	}
	
	public double getArea() {
		double area;
		area = 0;
		for (int i=0; i < counter; i++) {
			area += elements[i].getArea();
		}
		return area;
	}
	
	public String getColor() {
		String color;
		color = elements[0].getColor();
		for (int i=1; i < counter; i++) {
			if (!color.equals(elements[i].getColor()))
				return "Multiple";
		}
		
		return color;
	}
}



