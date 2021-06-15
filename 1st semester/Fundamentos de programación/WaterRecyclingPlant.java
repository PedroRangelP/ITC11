public class WaterRecyclingPlant {
    public static void main(String[] args) {
        boolean a,b,c,d,e,f,g,v,w,x,y,z;
        
        System.out.print("Is gate A open? ");
        a = Boolean.parseBoolean(System.console().readLine());
        System.out.print("Is gate B open? ");
        b = Boolean.parseBoolean(System.console().readLine());
        System.out.print("Is gate C open? ");
        c = Boolean.parseBoolean(System.console().readLine());
        System.out.print("Is gate D open? ");
        d = Boolean.parseBoolean(System.console().readLine());
        System.out.print("Is gate E open? ");
        e = Boolean.parseBoolean(System.console().readLine());
        System.out.print("Is gate F open? ");
        f = Boolean.parseBoolean(System.console().readLine());
        System.out.print("Is gate G open? ");
        g = Boolean.parseBoolean(System.console().readLine());

        v = (a == true) & (d == true) & (g == true);
        w = (a == true) & (d == true) & (g == false);
        x = ((a == true) & (d == false)) | ((b == true) & (c == true) & (e == true));
        y = ((b == true) & (c == true) & (e == false)) | ((b == true) & (c == false) & (f == true));
        z = (b == true) & (c == false) & (f == false);

        System.out.println("----- OUTPUTS -----");
        System.out.println("-V: " + v);
        System.out.println("-W: " + w);
        System.out.println("-X: " + x);
        System.out.println("-Y: " + y);
        System.out.println("-Z: " + z);
    }
}