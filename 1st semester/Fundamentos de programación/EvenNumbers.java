public class EvenNumbers {
    public static void main(String[] args) {
        int num, i;
        System.out.print("Write a number: ");
        num = Integer.parseInt(System.console().readLine());

        for (i = 2; i <= num; i += 2){
            System.out.println(i);
        }            
    }
}