public class SoulMate {
    public static void main(String[] args) {
        boolean r1, r2, r3, r4, r5, r6, r7, r8, r9, r10;
        int p = 0;
        System.out.println("SOUL MATE TEST");
        System.out.println("Instructions: Answer each question with 'true' or 'false'\n---------------------------------------------------------");
        System.out.println("1. Do you like dance?");
        r1 = Boolean.parseBoolean(System.console().readLine());
        if (r1 != true){
            p += 10;
        }
        System.out.println("2. Do you like listen to music?");
        r2 = Boolean.parseBoolean(System.console().readLine());
        if (r2 == true){
            p += 10;
        }
        System.out.println("3. Do you play some instrument?");
        r3 = Boolean.parseBoolean(System.console().readLine());
        if (r3 == true){
            p += 10;
        }
        System.out.println("4. Do you like dogs or horses?");
        r4 = Boolean.parseBoolean(System.console().readLine());
        if (r4 == true){
            p += 10;
        }
        System.out.println("5. Do you like travel?");
        r5 = Boolean.parseBoolean(System.console().readLine());
        if (r5 == true){
            p += 10;
        }
        System.out.println("6. Do you like to go out at the weekend?");
        r6 = Boolean.parseBoolean(System.console().readLine());
        if (r6 == true){
            p += 10;
        }
        System.out.println("7. Do you practice any sport?");
        r7 = Boolean.parseBoolean(System.console().readLine());
        if (r7 != true){
            p += 10;
        }
        System.out.println("8. Are you a organized person?");
        r8 = Boolean.parseBoolean(System.console().readLine());
        if (r8 != true){
            p += 10;
        }
        System.out.println("9. Do you like blue color?");
        r9 = Boolean.parseBoolean(System.console().readLine());
        if (r9 == true){
            p += 10;
        }
        System.out.println("10. Do you consider yourself lazy?");
        r10 = Boolean.parseBoolean(System.console().readLine());
        if (r10 != true){
            p += 10;
        }

        System.out.print("---------------------------------------------------------\nYou're " + p + "% compatible with me");
        if (p == 100){
            System.out.println(", you're my soul mate!");
        }
    }
}