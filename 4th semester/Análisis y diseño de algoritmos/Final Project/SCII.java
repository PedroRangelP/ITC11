import java.util.*;

public class SCII {
    public static boolean share(int[] bags, int n, int candies) {
        Boolean[][] table = new Boolean[n+1][candies+1];

        for (int i=0; i<n+1; i++)
            table[i][0] = true;
        for (int j=1; j<candies+1; j++)
            table[0][j] = false;
        for (int i=1; i<n+1; i++) {
            for (int j=1; j<candies+1; j++) {
                if (bags[i-1] > j)
                    table[i][j] = table[i-1][j];
                else
                    table[i][j] = (table[i-1][j-bags[i-1]] || table[i-1][j]);
            }
        }

        return table[n][candies];
    }

    public static boolean canShare(int[] bags, int n) {
        int candies = candies(bags, n);

        if (candies%2!=0)
            return false;
        else
            return share(bags, n, candies/2);
    }

    public static int candies(int[] bags, int n) {
        int candies = 0;
        for (int i=0; i<n; i++)
            candies += bags[i];
        
        return candies;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] bags = new int[n];

        for (int i=0; i<n; i++){
            String temp = sc.next();
            bags[i] = Integer.parseInt(temp);
        }
        sc.close();

        if (canShare(bags, n))
            System.out.println("True");
        else
            System.out.println("False");
    }
}