public class Exercise3 {
    public static int combinations(String expression, int n) {
        int res = 0;
        int or = 0;
        int and = 0;

        for (int i=0; i<expression.length(); i++){
            if(expression.substring(i,i+1).equals("|"))
                or +=1;
            
            if(expression.substring(i,i+1).equals("&"))
                and +=1;
        }

        if(or==n-1)
            res += Math.pow(2, n) -1;
        else
            res += Math.pow(2, (n-and)) - 1;

        if (and >= 1)
            res += 1;

        return res;
    }

    public static void main(String[] args) {
        String expression1 = "a&b";
        String expression2 = "a|b";
        String expression3 = "a&b&c";
        String expression4 = "a|b|c";
        String expression5 = "a&b|c";
        System.out.println("Combinations: " + combinations(expression4, 3));
    }

    
    
}