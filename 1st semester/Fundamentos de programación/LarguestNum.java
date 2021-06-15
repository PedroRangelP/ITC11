public class LarguestNum{
    public static void main(String[] args){
        int num, large = Integer.MIN_VALUE, i;

        for (i = 1; i <= 10; i++) {
            System.out.print("Number " + i + ": ");
            num = Integer.parseInt(System.console().readLine());
            if (num > large){
                large = num;
            }  
        }

        System.out.println("The larguest number is: " + large);
    }
}