public class Vehicle {
    public String brand;
    public String color;
    public boolean autopilot;
    public String tireSize, torque;
    private Report report;

    public void setReport(Report r) {
        report = r;
    }

    public boolean checkup() { 
        boolean res;
        res = report.time60mph < 3;
        res &= report.autopilotWorking;
        res &= report.maxSpeed > 100;

        return res;
    }

    public double timeMaxSpeed() {
        double time;
        time = report.maxSpeed*report.time60mph/60;

        return time;
    }
}