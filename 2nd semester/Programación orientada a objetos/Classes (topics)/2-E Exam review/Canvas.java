public class Canvas {
	private IElement[] elements;
	private int counter;
	
	public Canvas() {
		elements = new IElement[100];
		counter = 0;
	}
	
	public void addElement(IElement e) {
		elements[counter] = e;
		counter++;
	}
}