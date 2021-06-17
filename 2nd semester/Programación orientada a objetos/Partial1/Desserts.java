public class Desserts extends Dish {
    public boolean glutenFree, lactoseFree;

    public String newDish() {
        return super.newDish() + "\nGluten free: "+glutenFree + "\nLactose free: "+lactoseFree;
    }
}