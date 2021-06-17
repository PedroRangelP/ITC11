public class CSP {
	public String name;
	public Service[] services;
	private int count;
	
	public CSP() {
		services = new Service[10];
	}
	
	public void addService(Service s) {
		services[count] = s;
		count++;
    }

    public double calculateCost() {
        double cost = 0;
        int i;
        for (i=0; i<count; i++) {
            cost += services[i].calculateCost();   
        }

        return cost;
    }
}