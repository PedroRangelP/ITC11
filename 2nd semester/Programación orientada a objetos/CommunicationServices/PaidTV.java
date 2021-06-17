public class PaidTV extends Service {
    public double basePrice;
    public int channels;
    public double costPerChannel;

    public double calculateCost() {
        return basePrice + costPerChannel * channels;
    }
}