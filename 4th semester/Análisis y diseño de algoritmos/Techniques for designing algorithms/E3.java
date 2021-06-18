import java.util.*;

public class E3 {
    public static Boolean isPossibleSum(int[] numbers, int n, int sum) {
        if (n == 0 && sum > 0)
            return false;
        if (sum == 0)
            return true;
        if (numbers[n-1] > sum)
            return isPossibleSum(numbers, n-1, sum);
        else
            return isPossibleSum(numbers, n-1, sum-numbers[n-1]) || isPossibleSum(numbers, n-1, sum);
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