public class Calculator{
    public static void main(String[] args){
        double num1, num2;
        String operator;
        char op;

        System.out.println("POCKET CALCULATOR");
        num1 = Double.parseDouble(System.console().readLine());
        do{
            operator = System.console().readLine();
            op = operator.charAt(0);

            switch (op){
                case '+':
                    num2 = Double.parseDouble(System.console().readLine());
                    num1 += num2;
                    System.out.println("\n"+num1);
                    break;
                case '-':
                    num2 = Double.parseDouble(System.console().readLine());
                    num1 -= num2;
                    System.out.println("\n"+num1);
                    break;
                case '*':
                    num2 = Double.parseDouble(System.console().readLine());
                    num1 *= num2;
                    System.out.println("\n"+num1);
                    break;
                case '/':
                    num2 = Double.parseDouble(System.console().readLine());
                    num1 /= num2;
                    System.out.println("\n"+num1);
                    break;
                case '=':
                    System.out.println("--------------------\n" + num1);
                    break;
                default:
                    System.out.println("Operator not supported");
                    break;
            }
        }while (op != '=');    
    }
}
