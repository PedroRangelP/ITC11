public class HostedApplication extends CloudService {
    public double usedMb;
    public double downloadedMb;
    public double costPerMb;
    public double totalDisk;
    public double totalDownload;
    public double baseDiskMb = 100;
    public double baseDownloadMb = 1000;
    public double priceDiskMb = basePrice * 0.01;
    public double priceDownloadMb = basePrice * 0.02;

    public double calculateCost() {
        basePrice = 13499.99;

        if (usedMb <= baseDiskMb) {
            totalDisk = priceDiskMb;
        }else {
            costPerMb = (basePrice * 0.005) / 100;
            totalDisk = priceDiskMb + (usedMb - baseDiskMb) * costPerMb;
        }

        if (downloadedMb <= baseDownloadMb) {
            totalDownload = priceDownloadMb;
        }else {
            costPerMb = (basePrice * 0.01) / 1000;
            totalDownload = priceDownloadMb + (downloadedMb - baseDownloadMb) * costPerMb;
        }
        
        return totalDisk + totalDownload;

    }
}