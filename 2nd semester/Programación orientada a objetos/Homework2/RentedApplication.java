public class RentedApplication extends CloudService {
    public int yearsSinceReleased;
    public double price;

    public double calculateCost() {
        basePrice = 16754.08;

        if (yearsSinceReleased <= 1)
            return basePrice * 0.01;
        else if (yearsSinceReleased <= 3)
            return basePrice * 0.009;
        else
            return basePrice * 0.008;
    }
}