public class Group extends Element {
    private BasicElement[] basicElements;
    public double groupArea;
    public String groupColor;


    public void addElement() {
        basicElements = new BasicElement[100];
    }

    public void calculateArea() {
        double area = 0;
        for (int i=0; i<basicElements.length; i++) {
            area += basicElements[i].basicArea;
        }

        this.groupArea = area;
    }

    public void calculateColor() {
        String color = basicElements[0].basicColor;
        for (int i=1; i<basicElements.length; i++) {
            if (color == basicElements[i].basicColor){
                this.groupColor = color;
            } else {
                this.groupColor = "multiple";
                break;
            }
        }
    }
}