import java.util.Scanner;
import java.io.File;

public class SecretCode {
	public static void main(String[] args) {
        System.out.print("Write the text to see the secret code: ");
        String text = System.console().readLine();
        String[] words = text.split(" ");
        int amount = words.length, i;
        int[] codes = new int[amount]
        
        System.out.println("The secret code is:");
        for (i=0; i<amount; i++){
            codes[i] = getCode(words[i]);
            System.out.print(getCode(words[i])+" ");
        }
        
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