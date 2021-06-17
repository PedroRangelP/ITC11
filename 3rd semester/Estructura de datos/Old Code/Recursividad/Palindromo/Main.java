import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String palabra;
        System.out.print("Palabra: ");
        palabra = sc.next();
        System.out.print("Palindromo: " + esPalindromo(palabra));
    }

    public static boolean esPalindromo(String palabra) {
        int lenght = palabra.length();

        if (lenght==1)
            return esPalindromo(palabra.substring(1, lenght-1));
        else
            return false;
    }
}