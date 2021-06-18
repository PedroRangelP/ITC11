import java.util.*;

public class C19 {
    public static int substringX(String point) {
        int start = point.indexOf("(") + 1;
        int end = point.indexOf(",");

        return Integer.parseInt(point.substring(start, end));
    }

    public static int substringY(String point) {
        int start = point.indexOf(",") + 1;
        int end = point.indexOf(")");

        return Integer.parseInt(point.substring(start, end));
    }

    public static int orientation(Point p, Point q, Point r)
    {
        int orientation = (q.y - p.y)*(r.x - q.x) - (q.x - p.x)*(r.y - q.y);
        
        if (orientation==0)
            return 0;
        
        return (orientation>0) ? 1 : 2;
    }

    public static void jarvis(Point[] points, int n) {
        int leftmost = 0;
        for (int i=1; i<n; i++) {
            if (points[i].x<points[leftmost].x)
                leftmost = i;
        }

        int p = leftmost, q;
        ArrayList<String> convexHull = new ArrayList<String>();

        do {
            convexHull.add("(" + points[p].x + "," + points[p].y + ")");
            q = (p+1) % n;

            for (int r=0; r<n; r++) {
                if (orientation(points[p], points[q], points[r])==2)
                    q = r; 
            }

            p = q;
        }while (p!=leftmost);

        Collections.sort(convexHull);

        for (String point : convexHull)
            System.out.println(point);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Point[] points = new Point[4*n];

        for (int i=0; i<2*n; i++) {
            String point = sc.next();

            points[i] = new Point(substringX(point), substringY(point));
        }
        sc.close();

        for (int i=0; i<2*n; i+=2) {
            int length = points[i+1].x - points[i].x;

            points[i+(2*n)] = new Point(points[i+1].x - length, points[i+1].y);
            points[i+(2*n)+1] = new Point(points[i].x + length, points[i].y);
        }

        jarvis(points, 4*n);
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