import java.util.Scanner;
import shapes.Circle;
import shapes.EquilateralTriangle;
import shapes.IsoscelesTriangle;
import shapes.Shape;
import shapes.Square;
import shapes.Rectangle;
import shapes.ScaleneTriangle;
import shapes.Tetrahedron;

public class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String selectedOption = preguntarFigura(sc);

        while (!selectedOption.equals("0")) {
            Shape shape = new Square(1);
            boolean volumenInsteadOfPerimeter = false;

            switch (selectedOption) {
            case "1":
                System.out.println("Dame el lado del cuadrado: ");
                double side = sc.nextDouble();
                shape = new Square(side);
                break;

            case "2":
                System.out.println("Dame el radio del círculo");
                double radius = sc.nextDouble();
                shape = new Circle(radius);
                break;

            case "3":
                System.out.println("Dame los lados del rectangulo");
                double rectangleSideA = sc.nextDouble();
                double rectangleSideB = sc.nextDouble();
                shape = new Rectangle(rectangleSideA, rectangleSideB);
                break;

            case "4":
                System.out.println("Elige tipo de triángulo: 1)Equilátero 2)Escaleno 3)Isosceles");
                switch (sc.nextInt()) {
                case 1:
                    System.out.println("Dame el lado:");
                    double sideTriangle = sc.nextDouble();
                    shape = new EquilateralTriangle(sideTriangle);
                    break;

                case 2:
                    System.out.println("Dame los lados:");
                    double triangleSideA = sc.nextDouble();
                    double triangleSideB = sc.nextDouble();
                    double triangleSideC = sc.nextDouble();
                    shape = new ScaleneTriangle(triangleSideA, triangleSideB, triangleSideC);
                    break;
                case 3:
                    System.out.println("Dame la base y el lado igual:");
                    double base = sc.nextDouble();
                    double sides = sc.nextDouble();
                    shape = new IsoscelesTriangle(base, sides);
                    break;
                }
                break;
            case "5":
                System.out.println("Dame la arista del tetraedro");
                double arista = sc.nextDouble();
                shape = new Tetrahedron(arista);
                volumenInsteadOfPerimeter = true;
                break;

            default:
                System.out.println("Dame el lado del cuadrado: ");
                double sideD = sc.nextDouble();
                shape = new Square(sideD);
                break;

            }
            sc.nextLine();
            // We change second option since tetrahedron is a 3D object
            System.out.println(
                    "¿Que deseas calcular? 1) Area 2)" + (volumenInsteadOfPerimeter ? "Volumen" : "Perimetro"));
            volumenInsteadOfPerimeter = false;
            String selectedCalculation = sc.nextLine();
            switch (selectedCalculation) {
            case "1":
                System.out.println("Resultado: " + shape.calculateArea());
                break;

            case "2":
                System.out.println("Resultado: " + shape.calculatePerimeter());
                break;

            }
            selectedOption = preguntarFigura(sc);

        }
        sc.close();

    }

    public static String preguntarFigura(Scanner sc) {
        System.out.println("Elige la figura: 1)Cuadrado 2)Círculo 3)Rectangulo 4) triángulo 5)Tetraedro");
        String selectedOption = "1";
        selectedOption = sc.nextLine();
        return selectedOption;

    }

}