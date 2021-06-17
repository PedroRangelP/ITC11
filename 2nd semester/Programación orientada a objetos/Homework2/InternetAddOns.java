public class InternetAddOns extends CloudService {
    public boolean firstTime;
    public double price;

    public double calculateCost() {
        basePrice = 15989.41;

        if (firstTime == true)
            return basePrice * 0.2;
        else
            return basePrice * 0.1;
    }
}