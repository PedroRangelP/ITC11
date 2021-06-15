public class Bank {
    public static void main(String[] args) {
        double amount, rest;
        String hundreds = "", tens = "", units = "", special = "";
        System.out.print("Write the amount of dollars to convert in text:\n$");
        amount = Double.parseDouble(System.console().readLine());

        if (amount < 1000.0 && amount > 0){
            hundreds = Double.toString(Math.round((amount / 100) - ((amount % 100) / 100)));
            rest = Math.round(amount % 100);
        
            switch (hundreds){
                case "1.0": hundreds = ("one hundred and "); break;
                case "2.0": hundreds = ("two hundred and "); break;
                case "3.0": hundreds = ("three hundred and "); break;
                case "4.0": hundreds = ("four hundred and "); break;
                case "5.0": hundreds = ("five hundred and "); break;
                case "6.0": hundreds = ("six hundred and "); break;
                case "7.0": hundreds = ("seven hundred and "); break;
                case "8.0": hundreds = ("eight hundred and "); break;
                case "9.0": hundreds = ("nine hundred and "); break;
                case "0.0": hundreds = (""); break;
            }

            if (rest == 11.0){
                special = "eleven";
            }else if (rest == 12.0){
                special = "twelve";
            }else if (rest == 13.0){
                special = "thirteen";
            }else if (rest == 14.0){
                special = "fourteen";
            }else if (rest == 15.0){
                special = "fifteen";
            }else if (rest == 16.0){
                special = "sixteen";
            }else if (rest == 17.0){
                special = "seventeen";
            }else if (rest == 18.0){
                special = "eighteen";
            }else if (rest == 19.0){
                special = "nineteen";
            }else{
                tens = Double.toString(Math.round((rest / 10) - ((rest % 10) / 10)));
                units = Double.toString(Math.round(rest % 10));
                switch (tens){
                    case "2.0": tens = ("twenty-"); break;
                    case "3.0": tens = ("thirty-"); break;
                    case "4.0": tens = ("fourty-"); break;
                    case "5.0": tens = ("fifty-"); break;
                    case "6.0": tens = ("sixty-"); break;
                    case "7.0": tens = ("seventy-"); break;
                    case "8.0": tens = ("eighty-"); break;
                    case "9.0": tens = ("ninety-"); break;
                    case "0.0": tens = (""); break;
                }

                switch (units){
                    case "1.0": units = ("one"); break;
                    case "2.0": units = ("two"); break;
                    case "3.0": units = ("three"); break;
                    case "4.0": units = ("four"); break;
                    case "5.0": units = ("five"); break;
                    case "6.0": units = ("six"); break;
                    case "7.0": units = ("seven"); break;
                    case "8.0": units = ("eight"); break;
                    case "9.0": units = ("nine"); break;
                    case "0.0": units = (""); break;
                }
            }
  
            System.out.println("Result: " + hundreds + special + tens + units + " dollars");   
        }else if (amount == 0){
            System.out.println("Result: cero dollars");
        }else{
            System.out.println("You can write only up to 3 digits");
        }      
    }
}