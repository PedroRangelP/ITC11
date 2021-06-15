import java.util.Scanner;

public class Biologist{
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Animal 1: ");
        String animal1 = sc.next();
        System.out.print("Animal 2: ");
        String animal2 = sc.next();

        System.out.print("New name: ");
        int length1 = animal1.length(), length2 = animal2.length();
        String newName = animal1.substring(0, length1/2) + animal2.substring(length2/2);
        sc.close();
    }
}