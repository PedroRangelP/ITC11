public class InversePrint{
    public static void main(String [] args){
        int n, i, j;
        int[] numbers;

        System.out.print("Amount of numbers to read: ");
        n = Integer.parseInt(System.console().readLine());
        numbers = new int[n];

        for (i=0; i<n; i++){
            System.out.print("Number "+(i+1)+": ");
            numbers[i] = Integer.parseInt(System.console().readLine());
        }

        for (j=n; j>0; j--){
            System.out.println(numbers[j-1]);
        }
    }
}