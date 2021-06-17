public class Dish {
    public String name;
    public int price;
    private Ingredient[] ingredients;

    public String newDish() {
        return "Name: " + name + "\nPrice: "+price;
    } 
    
    public Int calculateCalories() {
        int calories = 0;
        for (int i=0; i<ingredients.lenght; i++) {
            calories += ingredients.calories;
        }
        
        return calories;
    }
}