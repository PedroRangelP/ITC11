import java.util.*;

public class CIAS {
    public static int substringX(String point) {
        int start = point.indexOf("(")+1;
        int end = point.indexOf(",");

        return Integer.parseInt(point.substring(start, end));
    }

    public static int substringY(String point) {
        int start = point.indexOf(",")+1;
        int end = point.indexOf(")");

        return Integer.parseInt(point.substring(start, end));
    }

    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Point[] points = new Point[2*n];*/

        /*for (int i=0; i<2*n; i++) {

        }
            input.add(sc.next());
        sc.close();
        Collections.sort(input);

        for (String point : input)
            points[i] = new Point(substringX(point), substringY(point));

        for (int i=0; i<2*n; i++) {
            String point = sc.next();
            points[i] = new Point(substringX(point), substringY(point));
        }*/


    }
}

/*class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}*/