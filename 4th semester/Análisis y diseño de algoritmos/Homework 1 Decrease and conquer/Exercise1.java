public class Exercise1 {
    public static int waysToJump(int n) {
        if (n == 0)
            return 0;

        if (n == 1)
            return 1;

        if (n == 2)
            return 2;

        else {
            int jumps1m = waysToJump(n - 1);
            int jumps2m = waysToJump(n - 2);

            return jumps1m + jumps2m;
        }
    }

    public static void main(String[] args) {
        for (int n = 1; n < 10; n++) {
            System.out.println("n: " + n + " --> ways: " + waysToJump(n));
        }
    }
}