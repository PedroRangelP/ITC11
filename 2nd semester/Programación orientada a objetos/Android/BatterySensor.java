public class BatterySensor extends Sensor {
    public int maxCapacity;
    public int currentCapacity;
    public int stepsToDecrease1;
    public int minCapacity;
    public int initialCpacity;

    public BatterySensor(int maxCapacity, int minCapacity, int initialCpacity, int stepsToDecrease1) {
        this.maxCapacity = maxCapacity;
        this.minCapacity = minCapacity;
        this.initialCpacity = initialCpacity;
        this.stepsToDecrease1 = stepsToDecrease1;
        this.currentCapacity = initialCpacity;
    }

    public void diminishCapacity() {
        currentCapacity--;
    }

    public void recharge() {
        currentCapacity = maxCapacity;
    }

    public void addStep() {
        super.addStep();
        if (stepsToDecrease1 % steps == 0)
            diminishCapacity();
    }

    public boolean checkup() {
        return currentCapacity > minCapacity;
    }

    public String displayStatus() {
        return super.displayStatus() + "\nCurrent capacity: " + currentCapacity;
    }
}