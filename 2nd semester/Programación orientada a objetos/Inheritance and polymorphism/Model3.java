public class Model3 extends Tesla {
    public static void main(String[] args) {
        Tesla t = new Model3();
        Characteristics c = new Characteristics();
        t.maxSpeed = 210;
        t.time0to60 = 3.2;

        // Overwritte
        t.model();

        // Overload
        c.Specs(t.maxSpeed);
        c.Specs(t.time0to60);
    }

    public void model() {
        System.out.println("Tesla Model 3");
    }
}