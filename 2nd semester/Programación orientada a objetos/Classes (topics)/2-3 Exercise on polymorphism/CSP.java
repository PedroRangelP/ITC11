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
}