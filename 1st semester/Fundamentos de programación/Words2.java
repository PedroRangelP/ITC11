public class Words2{
    public static void main(String[] args){
        int length = Integer.MAX_VALUE, longest = 0;
        String word, longestW = "";

        System.out.println("Write any word until a 'empty word' is added and see which one was the longest:");
        while (length != 0){
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