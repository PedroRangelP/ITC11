public class InternetConnection extends Service {
	public double basePrice;
	public double baseMb;
	public double costPerMb;
	public String media;
	public double usedMb;
	
	public double calculateCost() {
		if (usedMb <= baseMb)
			return basePrice;
		else
			return basePrice + (usedMb-baseMb)*costPerMb;
	}
}