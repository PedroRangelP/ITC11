public class CS {
    public String name;
    public CloudService[] cloudServices;
    private int count;

    public CS() {
        cloudServices = new CloudService[10];
    }

    public void addService(CloudService cs) {
        cloudServices[count] = cs;
        count++;
    }

    public double calculateCost() {
        double cost = 0;
        for (int i=0; i<count; i++) {
            cost += cloudServices[i].calculateCost();
        }
        return cost;
    }
}