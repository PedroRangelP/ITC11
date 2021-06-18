import java.util.*;

public class E4 {
    public static Boolean isPossibleSum(int[] numbers, int n, int sum) {
        Boolean[][] table = new Boolean[n+1][sum+1];

        for (int i=0; i<n+1; i++)
            table[i][0] = true;
        for (int j=1; j<sum+1; j++)
            table[0][j] = false;
        for (int i=1; i<n+1; i++) {
            for (int j=1; j<sum+1; j++) {
                if (numbers[i-1] > j)
                    table[i][j] = table[i-1][j];
                else
                    table[i][j] = (table[i-1][j-numbers[i-1]] || table[i-1][j]);
            }
        }

        return table[n][sum];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        for (int i=0; i<n; i++)
            numbers[i] = sc.nextInt();
        int sum = sc.nextInt();
        sc.close();

        if (isPossibleSum(numbers, n, sum))
            System.out.println("True");
        else
            System.out.println("False");
    }
}