import java.text.DecimalFormat;
import java.util.*;

public class JMDSS {
    public static double shoelace(Point[] points, int n) {
        double area = 0;

        int j = n-1;
        for (int i=0; i<n; i++) {
            area += (points[i].x+points[j].x) * (points[j].y-points[i].y);
            j = i;
        }

        return Math.abs(area/2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Point[] points = new Point[n];

        for (int i=0; i<n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            points[i] = new Point(x, y);
        }
        sc.close();

        DecimalFormat decimal = new DecimalFormat("####0.00");
        System.out.println(decimal.format(shoelace(points, n)));

    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}