import java.util.Scanner;

public class Students{
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);  
        System.out.print("Number of students: ");
        int num = sc.nextInt();

        String[] list = new String[num];
        System.out.println("Enter the name of the students:");
        for (int i=0; i<num; i++){
            list[i] = sc.next();
        }

        System.out.print("Letter to search: ");
        char letter = sc.next().toLowerCase().charAt(0);
        for (int i=0; i<num; i++){
            char first = list[i].toLowerCase().charAt(0);
            if (letter==first){
                System.out.println(list[i]);
            }
        } 
	}
}
