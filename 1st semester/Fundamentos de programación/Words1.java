public class Words1{
    public static void main(String[] args){
        int length, longest = 0, i;
        String word, longestW = "";

        System.out.println("Write 10 words and see which one was the longest:");
        for (i = 1; i <= 10; i++){
            System.out.print("Word " + i + ": ");
            word = System.console().readLine();
            length = word.length();
            
            if (length > longest){
                longest = length;
                longestW = word;
            }
        }
        
        System.out.println("The longest word was " + longestW);
    }
}