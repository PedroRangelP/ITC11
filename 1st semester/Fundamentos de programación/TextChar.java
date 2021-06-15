public class TextChar{
    public static void main(String [] args){
        String text;
        int i, v=0, w=1;
        char[] letters;
        
        System.out.println("Write the text below:");
        text = System.console().readLine();
        letters = text.toLowerCase().toCharArray();
        /*System.out.print("Position: ");
        int position;
        position = Integer.parseInt(System.console().readLine());
        System.out.println("The letter in position "+position+" is: "+letters[position-1]);*/
        int length = text.length();
        for (i=0; i<length; i++){
            switch (letters[i]){
                case 'a': 
                case 'e': 
                case 'i': 
                case 'o': 
                case 'u': 
                    v++; break;
                case ' ': w++; break;
            }
        }
        System.out.println("\nNumber of vowels: "+v);
        System.out.println("Number of words: "+w);
    }
}