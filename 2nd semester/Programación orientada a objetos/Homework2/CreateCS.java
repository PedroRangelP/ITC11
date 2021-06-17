public class CreateCS {
    public CS createIAO(boolean firstTime) {
        CS iao = new CS();
        iao.name = "Internet add-ons";

        InternetAddOns sIAO = new InternetAddOns();
        sIAO.firstTime = firstTime;
        iao.addService(sIAO);

        return iao;
    }

    public CS createRA(int yearsSinceReleased) {
        CS ra = new CS();
        ra.name = "Rented Applications";

        RentedApplication sRA = new RentedApplication();
        sRA.yearsSinceReleased = yearsSinceReleased;
        ra.addService(sRA);

        return ra;
    }

    public CS createHA(double usedMb, double downloadedMb) {
        CS ha = new CS();
        ha.name = "Hosted Applications";

        HostedApplication sHA = new HostedApplication();
        sHA.usedMb = usedMb;
        sHA.downloadedMb = downloadedMb;
        ha.addService(sHA);

        return ha;
    }
}