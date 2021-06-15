import java.util.Scanner;
import java.io.*;

public class DrugTest{
    public static void main (String[] args) throws Exception{
        Scanner sc1 = new Scanner(new File("groups.txt")), sc2 = new Scanner(new File("results.txt"));
        String groupsContent="", resultsContent="";
        int positive1=0, negative1=0, no1=0, positive2=0, negative2=0, no2=0;

        while (sc1.hasNext()) {
			groupsContent += sc1.nextLine() + "\n";
        }
        while (sc2.hasNext()) {
			resultsContent += sc2.nextLine() + "\n";
        }

        String[] results = resultsContent.split("\n"), groups = groupsContent.split("\n");

        for (int i=0; i<groups.length; i++){
            switch (groups[i]){
                case "group 1":
                    switch (results[i]){
                        case "positive effect": positive1++; break;
                        case "negative effect": negative1++; break;
                        case "no effect": no1++; break;
                    }
                    break;
                case "group 2":
                    switch (results[i]){
                        case "positive effect": positive2++; break;
                        case "negative effect": negative2++; break;
                        case "no effect": no2++; break;
                    } 
                    break;   
            }
        }

        System.out.println("Group 1 results:");
        System.out.print("Positive effect: "+positive1*2+"%\n");
        System.out.print("Negative effect: "+negative1*2+"%\n");
        System.out.print("No effect: "+no1*2+"%\n");

        System.out.println("\nGroup 2 results:");
        System.out.print("Positive effect: "+positive2*2+"%\n");
        System.out.print("Negative effect: "+negative2*2+"%\n");
        System.out.print("No effect: "+no2*2+"%\n");
        
    }
}