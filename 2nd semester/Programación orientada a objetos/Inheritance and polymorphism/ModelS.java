public class ModelS extends Tesla {
    public static void main(String[] args) {
        Tesla t = new ModelS();
        Characteristics c = new Characteristics();
        t.maxSpeed = 250;
        t.time0to60 = 2.4;
        
        // Overwritte
        t.model();

        // Overload
        c.Specs(t.maxSpeed);
        c.Specs(t.time0to60);
    }

    public void model() {
        System.out.println("Tesla Model S");
    }
}