public class Hailstone{
    public static void main(String[] args){
        int num;
        System.out.print("Write a number: ");
        num = Integer.parseInt(System.console().readLine());
        System.out.print("The sequence for number " + num + " is: ");

        while (num != 1){
            if (num % 2 == 0){
                num = num / 2;
            }else{
                num = num * 3 + 1;
            }

            System.out.print(num + ", ");
        }
    }
}