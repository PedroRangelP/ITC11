public class Sensor {
    public int steps;

    public void addStep() {
        steps++;
    }

    public boolean checkup() {
        return true;
    }

    public String displayStatus() {
        return "Steps: " + steps;
    }
}