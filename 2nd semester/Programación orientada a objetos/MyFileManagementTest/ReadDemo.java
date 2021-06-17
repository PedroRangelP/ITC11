import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class ReadDemo {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("ReadDemo.java"));
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }
}