public class SmallestNum{
    public static void main(String[] args){
        int num, small = Integer.MAX_VALUE, i;

        for (i = 1; i <= 10; i++) {
            System.out.print("Number " + i + ": ");
            num = Integer.parseInt(System.console().readLine());
            if (num < small){
                small = num;
            }  
        }

        System.out.println("The smallest number is: " + small);
    }
}