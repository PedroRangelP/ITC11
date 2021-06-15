public class WhileNumbers {
    public static void main(String[] args) {
        int a, b;
        int low, high;
        System.out.print("Enter the first number: ");
        a = Integer.parseInt(System.console().readLine());
        System.out.print("Enter the second number: ");
        b = Integer.parseInt(System.console().readLine());

        low =(a > b)?b:a;
        high = (a > b)?a:b;

        while (low <= high){
            System.out.println(a);
            a++;
        }        
    }
}