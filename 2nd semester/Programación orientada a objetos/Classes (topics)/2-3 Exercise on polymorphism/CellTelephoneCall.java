public class CellTelephoneCall extends Service {
	public double costPerMinute;
	public int minutes;
	
	public double calculateCost() {
		return costPerMinute*minutes;
	}
}