public class NumbersEvenOdd{
    public static void main(String [] args){
        int num, n, i, j=0, k=0;
        int[] even;
        int[] odd;

        System.out.print("Amount of numbers to read: ");
        n = Integer.parseInt(System.console().readLine());
        even = new int[n];
        odd = new int[n];

        for (i=0; i<n; i++){
            System.out.print("Number "+(i+1)+": ");
            num = Integer.parseInt(System.console().readLine());
            if (num%2 == 0){
                even[j]=num;
                j+=1; 
            }else{
                odd[k]=num;
                k+=1;
            }
        }

        System.out.println("Even numbers:");
        for (i=0; i<j; i++){
            System.out.println(even[i]);
        }
        System.out.println("Odd numbers:");
        for (i=0; i<k; i++){
            System.out.println(odd[i]);
        }
    }
}