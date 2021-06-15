public class GuessGame {
    public static void main(String[] args) {
        int num, i, user = 0;
        System.out.println("Guess the number between 1-100. You have 8 attempts to guess.");
        num = (int)(Math.random() * 100);

        for (i = 1; i <= 8; i++){
            System.out.print("Attempt " + i + ": ");
            user = Integer.parseInt(System.console().readLine());
            if (user < num && i < 8){
                System.out.println("The number is higher.");
            }else if (user > num && i < 8){
                System.out.println("The number is lower.");
            }else if (user == num){
                System.out.println("You win!");
                i = 9;
            }else if (i == 8 && user != num){
                System.out.println("You lose. The number was " + num + ".");
            } 
        }            
    }
}