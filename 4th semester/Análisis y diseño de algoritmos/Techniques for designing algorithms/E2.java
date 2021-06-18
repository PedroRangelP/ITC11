import java.util.*;

public class E2 {
    public static int longestSubsequence(String s1, String s2) {
        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();
        int table[][] = new int[s1.length()+1][s2.length()+1];
        
        for (int i=0; i<s1.length()+1; i++)
            table[i][0] = 0;
        for (int j=0; j<s2.length()+1; j++)
            table[0][j] = 0;
        for (int i=1; i<s1.length()+1; i++) {
            for (int j=1; j<s2.length()+1; j++) {
                if (cs1[i-1] == cs2[j-1])
                    table[i][j] = 1 + table[i-1][j-1];
                else
                    table[i][j] = Math.max(table[i-1][j], table[i][j-1]);
            }
        }

        return table[s1.length()][s2.length()]; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        sc.close();

        System.out.println(longestSubsequence(s1, s2));
    }
}