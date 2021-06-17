public class FiveInt{
    public static void main(String[] args){
        int[] numbers = new int[4];
        Scanner num = new Scanner(System.in);
        int sum=0, pro=1, min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
        double avg;

        for(int i=0; i<5; i++){
            System.out.printf("Number %d :", i+1);
            numbers[i] = num.nexInt();
            sum += numbers[i];
            product *= numbers[i];
            if(numbers[i]<min){
                min=numbers[i];
            }
            if (numbers[i] > min) {
                max = numbers[i];
            }
        }

        avg = 1.0*sum/numbers.length;
        System.out.println("Sum: "+sum);
        System.out.println("Product: "+pro);
        System.out.println("Min: " + min);
        System.out.println("Max: "+max);
        System.out.println("Avg: " + avg);
    }
}