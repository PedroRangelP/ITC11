public class DeclathlonTest {
    public static void main(String[] args) {
        double p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, Pt;

        System.out.println("----- FIRST DAY -----");
        System.out.print("Performance on 100 meters race (s): ");
        p1 = Double.parseDouble(System.console().readLine());
        p1 = (25.4347 * Math.pow(18 - p1, 1.81));
        System.out.print("Performance on discus throw (m): ");
        p2 = Double.parseDouble(System.console().readLine());
        p2 = (12.91 * Math.pow(p2 - 4, 1.1));
        System.out.print("Performance on pole vault (cm): ");
        p3 = Double.parseDouble(System.console().readLine());
        p3 = (0.2797 * Math.pow(p3 - 100, 1.35));
        System.out.print("Performance on javelin throw (m): ");
        p4 = Double.parseDouble(System.console().readLine());
        p4 = (10.14 * Math.pow(p4 - 7, 1.08));
        System.out.print("Performance on 400 meters race (s): ");
        p5 = Double.parseDouble(System.console().readLine());
        p5 = (1.53775 * Math.pow(82 - p5, 1.81));
        
        System.out.println("----- SECOND DAY -----");
        System.out.print("Performance on 110 meters hurdles (s): ");
        p6 = Double.parseDouble(System.console().readLine());
        p6 = (5.74352 * Math.pow(28.5 - p6, 1.92));
        System.out.print("Performance on long jump (cm): ");
        p7 = Double.parseDouble(System.console().readLine());
        p7 = (0.14354 * Math.pow(p7 - 220, 1.40));
        System.out.print("Performance on shot put (m): ");
        p8 = Double.parseDouble(System.console().readLine());
        p8 = (51.39 * Math.pow(p8 - 1.5, 1.05));
        System.out.print("Performance on high jump (cm): ");
        p9 = Double.parseDouble(System.console().readLine());
        p9 = (0.8465 * Math.pow(p9 - 75, 1.42));
        System.out.print("Performance 1500 meters race (s): ");
        p10 = Double.parseDouble(System.console().readLine());
        p10 = (0.03768 * Math.pow(480 - p10, 1.85));

        Pt = (p1 + p2 + p3 + p4 + p5 + p6 + p7 + p7 + p8 + p9 + p10);
        System.out.println("----- TOTAL POINTS OBTAINED -----");
        System.out.println(Pt);
    }
}