public class Main {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle();
        v1.brand = "Tesla Model S";
        v1.color = "Blue";
        v1.tireSize = "19 in";
        v1.torque = "660 N/m";
        v1.autopilot = true;

        Report r1 = new Report();
        r1.time60mph = 2.5;
        r1.autopilotWorking = true;
        r1.maxSpeed = 155;
        v1.setReport(r1);
        boolean result1 = v1.checkup();
        double time1 = v1.timeMaxSpeed();

        Vehicle v2 = new Vehicle();
        v2.brand = "Tesla Model X";
        v2.color = "White";
        v2.tireSize = "22 in";
        v2.torque = "659 N/m";
        v2.autopilot = true;

        Report r2 = new Report();
        r2.time60mph = 2.9;
        r2.autopilotWorking = false;
        r2.maxSpeed = 155;
        v2.setReport(r2);
        boolean result2 = v2.checkup();
        double time2 = v2.timeMaxSpeed();


        System.out.println(v1.brand);
        System.out.println("Report checkup: " + result1 + "\nTime to reach max speed: " + time1);
        System.out.println(v2.brand);
        System.out.println("Report checkup: " + result2 + "\nTime to reach max speed: " + time2);
    }
}