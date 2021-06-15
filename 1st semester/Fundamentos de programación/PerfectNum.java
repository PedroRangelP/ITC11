import java.util.Scanner;

public class PerfectNum{
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Number: ");
        int num = sc.nextInt();
        System.out.printf("The perfect numbers between 1-%d are:\n", num);
        for (int i=1; i<=num; i++){
            boolean result = perfectNum(i);
            if (result){
                System.out.println(i);
            }
        }
    }
	
	public static boolean perfectNum(int number){
        int sum=0;
        for (int i=1; i<number; i++){
            if (number%i==0){
                sum+=i;
            }
        }
        return sum==number;   
	}
}