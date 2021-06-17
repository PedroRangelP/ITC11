public class DemoCS {
    public static void main(String[] args) {
        boolean firstTime = false;
        int yearsSinceReleased = 2;
        double usedMb = 5658.4;
        double downloadedMb = 3458.32;
        
        CreateCS createCS = new CreateCS();
        CS iao = createCS.createIAO(firstTime);
        CS ra = createCS.createRA(yearsSinceReleased);
        CS ha = createCS.createHA(usedMb, downloadedMb);

        double iaoCost = Math.round(iao.calculateCost() * 100);
        double raCost = Math.round(ra.calculateCost() * 100);
        double haCost = Math.round(ha.calculateCost() * 100);

        System.out.println("TOTAL PAYMENT:");
        System.out.println("Internet add-ons:     $" + iaoCost/100);
        System.out.println("Rented applications:  $" + raCost / 100);
        System.out.println("Hosted applications:  $" + haCost / 100);
    }
}