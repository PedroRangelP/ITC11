public class ReadNumbers{
    public static void main(String [] args){
        int n, position, i;
        int[] numbers;

        System.out.print("Amount of numbers to read: ");
        n = Integer.parseInt(System.console().readLine());
        numbers = new int[n];

        for (i=0; i<n; i++){
            System.out.print("Number "+(i+1)+": ");
            numbers[i] = Integer.parseInt(System.console().readLine());
        }

        System.out.print("Position: ");
        position = Integer.parseInt(System.console().readLine());
        System.out.println("The  number is "+numbers[position-1]);
    }
}