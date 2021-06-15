public class CandyMachine {
    public static void main(String[] args) {
        int c1, c2, c5, c10, totalC, selection, number, change, total = 0;

        System.out.println("-------------------------");
        final Object[][] list = { { "", "PRODUCT", "PRICE" }, { "1", "Chips", "$8" }, { "2", "Chocolate", "$12" },
                { "3", "Soda", "$9" }, { "4", "Candies", "$6" }, { "5", "Chewing gum", "$4" } };
        for (final Object[] table : list) {
            System.out.format("%-15s%-15s%-15s\n", table);
        }

        System.out.println("-------------------------\nInsert the number of coins of each value:");
        System.out.print("$1: ");
        c1 = Integer.parseInt(System.console().readLine());
        System.out.print("$2: ");
        c2 = Integer.parseInt(System.console().readLine());
        System.out.print("$5: ");
        c5 = Integer.parseInt(System.console().readLine());
        System.out.print("$10: ");
        c10 = Integer.parseInt(System.console().readLine());
        totalC = ((c1*1) + (c2*2) + (c5*5) + (c10*10));

        System.out.print("-------------------------\nEnter the number of your selection: ");
        selection = Integer.parseInt(System.console().readLine());
        System.out.print("How many do you want? ");
        number = Integer.parseInt(System.console().readLine());
        System.out.println("-------------------------");
      
        switch (selection) {
            case 1: total = (8*number); break;
            case 2: total = (12*number); break;
            case 3: total = (9*number); break;
            case 4: total = (6*number); break;
            case 5: total = (4*number); break;
            default: System.out.println("ERROR - Wrong selection"); break;
        }

        if (total <= totalC) {
            change = (totalC-total);
            System.out.println("Thanks for your purchase!\nYour change: $" + change);
        }else{
            System.out.println("ERROR - Insufficient money");
        }   
    }
}