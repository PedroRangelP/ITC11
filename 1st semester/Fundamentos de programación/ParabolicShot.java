public class ParabolicShot {
    public static void main(String[] args) {
        double V0, aD, aR, xf, yf, xMax, yMax, tMax, x, y, t, g = 9.81, i = 0;
        char again = 'y';

        System.out.println("PARABOLIC SHOT CALCULATOR");
        do{
            System.out.print("\nEnter the initial speed [m/s^2]: ");
            V0 = Double.parseDouble(System.console().readLine());
            System.out.print("Enter the direction [°]: ");
            aD = Double.parseDouble(System.console().readLine());
            aR = Math.toRadians(aD); 
            /*System.out.println(V0 * Math.sin(aR));
            System.out.println(V0 * Math.cos(aR));*/
            t = (V0 * Math.sin(aR) / g) * 2;
            tMax = V0 * Math.sin(aR) / g;
            xf = V0 * Math.cos(aR) * t;
            xMax = V0 * Math.cos(aR) * tMax;
            yf = (V0 * Math.sin(aR) * t) - g * Math.pow(t, 2) / 2;
            yMax = (V0 * Math.sin(aR) * tMax) - g * Math.pow(tMax, 2) / 2;
            
            System.out.println("\nPosition (x, y) every second after the object is launched:");
            final Object[][] list = { { "t [s]", "x [m]", "y [m]" } };
            for (final Object[] heading : list) {
                System.out.format("%-10s%-10s%-10s\n", heading);
            }
            while (i <= t){
                x = V0 * Math.cos(aR) * i;
                y = (V0 * Math.sin(aR) * i) - g * Math.pow(i, 2) / 2;
                final Object[][] listData = { { Math.round(i*10)/10d, Math.round(x*100)/100d, Math.round(y*100)/100d } };
                for (final Object[] data : listData) {
                    System.out.format("%-10s%-10s%-10s\n", data);
                }
                i += 0.1;
            }
            System.out.println("\nPosition of the maximun height: (" + Math.round(xMax*100)/100d + ", " + Math.round(yMax*100)/100d + ")m");
            System.out.println("Time to fall again: " + Math.round(t*100)/100d + "s");
            System.out.println("Final position: (" + Math.round(xf*100)/100d + ", " + Math.round(yf*100)/100d + ")m");

            System.out.print("\nTo execute the program again enter 'y'. To exit the code enter any key. ");
            again = System.console().readLine().charAt(0);
            i = 0;
        }while (again == 'y' | again == 'Y');
    }
}