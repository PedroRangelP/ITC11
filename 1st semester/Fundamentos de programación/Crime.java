public class Crime {
    public static void main(String[] args) {
        double lc, br, hb, cs, bi, wr, pd, cp, sumEv, cI;

        System.out.println("Evaluate the following factors in a scale from '-2' (very low) to '+2' (very high).");
        System.out.print("\nLevel of crime: ");
        lc = Double.parseDouble(System.console().readLine());
        System.out.print("Worried about being robbed: ");
        br = Double.parseDouble(System.console().readLine());
        System.out.print("Worried about your home being broken: ");
        hb = Double.parseDouble(System.console().readLine());
        System.out.print("Worried about your car being stolen: ");
        cs = Double.parseDouble(System.console().readLine());
        System.out.print("Worried about being insulted: ");
        bi = Double.parseDouble(System.console().readLine());
        System.out.print("Worried about racism (skin, ethnic, religion...): ");
        wr = Double.parseDouble(System.console().readLine());
        System.out.print("Problems with drugs in your community: ");
        pd = Double.parseDouble(System.console().readLine());
        System.out.print("Ccorruption problems: ");
        cp = Double.parseDouble(System.console().readLine());

        sumEv = lc + br + hb + cs + bi + wr + pd + cp;
        cI = (sumEv + 16) * (100/32);

        System.out.println("\nCrime Index:");
        if (cI < 20){
            System.out.println("Very low");
        }else if (cI >=20 && cI <40){
            System.out.println("Low");
        }else if (cI >=40 && cI <60){
            System.out.println("Moderate");
        }else if (cI >=60 && cI <80){
            System.out.println("High");
        }else{
            System.out.println("Very high");
        }        
    }
}