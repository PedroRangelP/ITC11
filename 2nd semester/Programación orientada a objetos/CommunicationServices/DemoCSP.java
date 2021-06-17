public class DemoCSP {
    public static void main(String[] args) {
        CSPFactory factory = new CSPFactory();
        //Client data
        double attUsedMb = 103.45;
        int attChannels = 10;
        //ATT&T Object
        CSP att = factory.createATT(attUsedMb, attChannels);
        //Call the method to calculate the total cost
        double attCost = Math.round(att.calculateCost() * 100);
        System.out.println("AT&T total income: $" + attCost/100);

        String axtelMedia = "Optic Fiber";
        double axtelUsedMb = 34.6;
        CSP axtel = factory.createAxtel(axtelMedia, axtelUsedMb);
        double axtelCost = Math.round(axtel.calculateCost() * 100);
        System.out.println("Axtel total income: $" + axtelCost/100);

        int infinitumCalls = 34;
        double infinitumUsedMb = 56.24;
        int infinitumCellMins = 18;
        CSP infinitum = factory.createInfinitum(infinitumCalls, infinitumUsedMb, infinitumCellMins);
        double infinitumCost = Math.round(infinitum.calculateCost()*100);
        System.out.println("Infinitum total income: $" + infinitumCost/100);


    }
}