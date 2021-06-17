public class TelephonePerCall extends Service {
    public double costPerCall;
    public int calls;

    public double calculateCost() {
        return costPerCall * calls;
    }
}