public class Regular extends Dish {
    public String category;

    public String newDish() {
        return super.newDish() + "\nCategory: "+category;
    }
}