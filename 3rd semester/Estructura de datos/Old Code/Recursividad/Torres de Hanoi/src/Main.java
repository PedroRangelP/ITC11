import torres.TorresDeHanoi;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pisos;
        double pasos;

        System.out.print("Numero de aros: ");
        pisos = sc.nextInt();
        System.out.println("--------------------");
        TorresDeHanoi.torresDeHanoi(pisos);
        pasos = TorresDeHanoi.calcularPasos(pisos);
        System.out.println("--------------------\nTotal de pasos: " + pasos);
        
    }
}