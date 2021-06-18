import java.util.*;

public class SCI {
    public static boolean share(int[] bags, int n, int candies) {
        if (n==0 && candies>0)
            return false;
        if (candies==0)
            return true;
        if (bags[n-1]>candies)
            return share(bags, n-1, candies);
        else
            return share(bags, n-1, candies-bags[n-1]) || share(bags, n-1, candies);
    }

    public static boolean canShare(int[] bags, int n) {
        int candies = candies(bags, n);

        if (candies%2!=0)
            return false;
        else
            return share(bags, n, candies/2);
    }

    public static int candies(int[] bags, int n) {
        if (n<=0)
            return 0;
        else 
            return candies(bags, n-1) + bags[n-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] bags = new int[n];

        for (int i=0; i<n; i++)
            bags[i] = sc.nextInt();
        sc.close();

        if (canShare(bags, n))
            System.out.println("True");
        else
            System.out.println("False");
    }
}