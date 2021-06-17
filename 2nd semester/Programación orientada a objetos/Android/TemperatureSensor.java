public class TemperatureSensor extends Sensor {
    public int maxTemperature;
    public int currentTemperature;
    public int initialTemperature;
    public int stepsToIncrease1;

    public TemperatureSensor(int maxTemperature, int initialTemperature, int stepsToIncrease1) {
        this.maxTemperature = maxTemperature;
        this.initialTemperature = initialTemperature;
        this.stepsToIncrease1 = stepsToIncrease1;
        this.currentTemperature = initialTemperature;
    }

    public void increaseTemperature() {
        currentTemperature++;
    }
    
    public void coolDown() {
        currentTemperature = initialTemperature;
    }

    public void addStep() {
        super.addStep();
        if (steps % stepsToIncrease1 == 0)
            increaseTemperature();
    }

    public boolean checkup() {
        return currentTemperature < maxTemperature;
    }

    public String displayStatus() {
        return super.displayStatus() + "\nCurrent temperature: " + currentTemperature;
    }
}