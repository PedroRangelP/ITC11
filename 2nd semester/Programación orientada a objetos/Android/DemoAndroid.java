import java.util.Scanner;

public class DemoAndroid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Android A0973D = new Android();
        int x, y;

        while (A0973D.batteryCheckup() != false || A0973D.temperatureCheckup() != false) {
            System.out.println("\nPOSITION:");
            System.out.print("x: ");
            x = sc.nextInt();
            System.out.print("y: ");
            y = sc.nextInt();
            A0973D.move(x,y);
            System.out.println(A0973D.displayStatus());
        }
    }
}