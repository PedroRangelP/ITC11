public class Cells {
    public static void main(String[] args) {
         int a, b, c, t, p;

        System.out.print("Wich is the value of 'a'? ");
        a = Integer.parseInt(System.console().readLine());
        System.out.print("Wich is the value of 'b'? ");
        b = Integer.parseInt(System.console().readLine());
        System.out.print("Wich is the value of 'c'? ");
        c = Integer.parseInt(System.console().readLine());
        System.out.print("In wich day do you want to predict the cell population? ");
        t = Integer.parseInt(System.console().readLine());

        p = (a*(t*t)) + (b*t) + c;

        System.out.println("\nCell population: " + p);
    }
}