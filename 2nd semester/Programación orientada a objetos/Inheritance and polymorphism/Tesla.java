public class Tesla {
    int maxSpeed;
    double time0to60;

    //Overwritte
    public void model() {
        System.out.println("This is a Tesla model");
    }
}

//Overload
class Characteristics {
    void Specs(int speed) {
        System.out.println("Max. speed: " + speed + " km/h");
    }
    void Specs(double time) {
        System.out.println("From 0-60 mph: " + time + "s");
    }
}