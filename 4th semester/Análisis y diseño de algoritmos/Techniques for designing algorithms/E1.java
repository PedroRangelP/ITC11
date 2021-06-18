import java.util.*;

public class E1 {
    public static int longestSubsequence(String s1, String s2) {
        if (s1.length() <= 0 || s2.length() <= 0) {
            return 0;
        } else {
            if (s1.charAt(0) == s2.charAt(0))
                return 1 + longestSubsequence(s1.substring(1), s2.substring(1));
            else
                return Math.max(longestSubsequence(s1.substring(1), s2), longestSubsequence(s1, s2.substring(1)));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        sc.close();

        System.out.println(longestSubsequence(s1, s2));
    }
}