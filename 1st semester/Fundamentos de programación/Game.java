public class Game{
    public static void main (String[]args){
        int number, guess=0, guessesTaken=0; //Te faltaba inicializar las variables

        number= (int)(Math.random()*100);
        //System.out.println(number);

        System.out.print("Welcome. I have a number. Your job is to guess it.");


        while (guessesTaken <8) {
            System.out.println("Well, I have a number between 0 and 100."); //Creo que esto debería estar fuera del while para que no se este mostrando en cada paso
            guess=Integer.parseInt(System.console().readLine());

            guessesTaken=guessesTaken + 1;


            if (guess < number) {
                System.out.println("Your guess is too close, but the number is higher");
            }
            else if (guess > number) {
                System.out.println("Your guess is too close, but the number is lower.");
            }
            else if (guess == number) {
                break;
            }
        }

        if (guess == number){
            System.out.println("Congrats! You guessed in " + guessesTaken + " guesses!");
        }

        if (guess != number) {
            System.out.println("Sorry. But, the number I was thinking of was " + number); 
        }
    }
}