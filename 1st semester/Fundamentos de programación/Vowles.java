public class Vowles{
    public static void main (String[]args){

        String text; 
        int length, count, i;
        int wordCount = 1;
        char[] letters;

        System.out.println("Please write a text");
        text=System.console().readLine();
        letters = text.toLowerCase().toCharArray();

        length=text.length();
        System.out.println("The length of the word is: " + length);

        count = 0;

        for (i=0; i<length ; i++) {
            if (letters[i] == 'a' | letters[i] == 'e'| letters[i] == 'i'| letters[i] == 'o' | letters [i] == 'u') {
            count++;
            }
        }

        for (i = 0; i < length; i++) {
            if (letters[i] == ' ') {
                wordCount++;
            } 
        }

        System.out.println("The numbers of vawles are "+ count); 
        System.out.println("Word count is = " + wordCount); 
    }
}