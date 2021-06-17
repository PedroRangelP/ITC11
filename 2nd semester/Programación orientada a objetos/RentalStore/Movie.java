public class Movie extends Rental {
    public String type, director;

    public String newRental() {
        return super.newRental() + "\n"type + "\n"+director;
    }
}