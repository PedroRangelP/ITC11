public class Videogame extends Rental {
    public String difficultyLevel, consoleType;
    public int numPlayers;

    public String newRental() {
        return super.newRental() + "\n"difficultyLevel + "\n"+numPlayers + "\n"+consoleType;
    }
}