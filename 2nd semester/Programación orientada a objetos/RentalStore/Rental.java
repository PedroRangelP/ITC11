public class Rental {
    public String title, releaseDate, classification; 
    public int existingItems;

    public Rental(String title, String releaseDate, String classification, int existingItems) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.classification = classification;
        this.existingItems = existingItems;
    }

    public String newRental() {
        return "Rental details: " + "\n"+title + "\n"+releaseDate + "\n"+classification + "\n"+existingItems;
    }
}