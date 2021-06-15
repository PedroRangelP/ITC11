import java.util.Scanner;
import java.io.File;

public class CountLetters {
	public static void main(String[] args) {
        System.out.print("Write the text to see the secret code: ");
        String text = System.console().readLine();
		System.out.println(getCode(text));
	}
	
	public static int getCode(String word) {
		word = word.toLowerCase();
		int count = 0;
		for (char letter : word.toCharArray()) {
			count += letter - 'a';
		}
		
		return count;
	}
}