import java.io.*;
import java.util.Scanner;
import java.io.File;

public class WriteIntoFile {
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("prueba.txt"));
		String content = "";
        
        
		while (sc.hasNext()) {
			content += sc.nextLine() + "\n";
		}
		
        for (int i=0; i<5; i++){
            content += System.console().readLine().toLowerCase() + "\n";
        }

        String[] lines = content.split("\n");
        
        FileWriter fw = new FileWriter(new File("prueba.txt"));
        for (String word : lines) {
			fw.write(word + "\n");
		}
		fw.close();
	}
}
