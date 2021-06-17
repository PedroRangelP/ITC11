package shapes;

public class Tetrahedron extends Shape {
  //A tetrahedron is a 3D equilateral triangle
  private Triangle face;
  public Tetrahedron(double side){
    //we instance a triangle with the same size in each side 
    face = new ScaleneTriangle(side, side, side);
  }

  @Override
	public double calculateArea() {
    return face.calculateArea()*4;
  }

	@Override
	public double calculatePerimeter() {
    //Calculates volume instead of perimeter
		return Math.sqrt(2)*Math.pow(face.getSideA(), 3) / 12;
	}
}