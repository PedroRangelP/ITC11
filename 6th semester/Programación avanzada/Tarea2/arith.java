import java.util.Scanner;
public class arith{
    public static void main (String[] args){
        Scanner sc= new Scanner(System.in);
        /*String exp= sc.nextLine();
        expresion(exp);*/
        int n = sc.nextInt();
        sc.nextLine();
        String[] ops= new String[n];
        for(int i=0; i<n; i++){
            ops[i]= sc.nextLine();
        }
        for(int j=0; j<n; j++){
            expresion(ops[j]);
        }
    }

    public static void expresion (String exp){
        char operando= what(exp);
        switch (operando){
            case '+':
                suma(exp);
                break;
            case '-':
                resta(exp);
                break;
            case '*':
                multi(exp);
                break;
            default:
                System.out.println("Expresion no valida");
                break;
        }
    }

    public static char what (String a){
        char express='a';
        for(int i=0; i<a.length(); i++){
            switch(a.charAt(i)){
                case '+':
                    express='+';
                    break;
                case '-':
                    express='-';
                    break;
                case '*':
                    express='*';
                    break;
                default:
                    break;
            }
        }
        
        return express;
    }

    public static void suma (String exp){
        String[] nums= exp.split("\\+");
        int uno= Integer.parseInt(nums[0]);
        int dos= Integer.parseInt(nums[1]);
        int result= uno+dos;
        String resultado= String.valueOf(result);
        printSumaResta(nums, "+", resultado);
    }

    public static void resta (String exp){
        String[] nums= exp.split("\\-");
        int uno= Integer.parseInt(nums[0]);
        int dos= Integer.parseInt(nums[1]);
        int result= uno-dos;
        String resultado= String.valueOf(result);
        printSumaResta(nums, "-", resultado);
    }

    public static void multi (String exp){
        String[] nums= exp.split("\\*");
        int uno= Integer.parseInt(nums[0]);
        int dos= Integer.parseInt(nums[1]);
        int result= uno*dos;
        String resultado= String.valueOf(result);

        int maxChars = 0;
        int maxLines =0;
        String deus= "*"+nums[1];
        
        if(nums[0].length()>= deus.length()){
            if(resultado.length()<=nums[0].length()){
                maxChars=nums[0].length();
            }else{
                maxChars=resultado.length();
            }
        }else{
            if(resultado.length()<=deus.length()){
                maxChars=deus.length();
            }else{
                maxChars=resultado.length();
            }
        }

        if(nums[1].length() != 1){
            maxLines = deus.length();
        }else{
            maxLines = resultado.length();
        }

        String guion="-";
        for(int j=0; j<maxLines-1;j++){
            guion+="-";
        }

        printHorizontal(nums[0], maxChars);
        printHorizontal(deus, maxChars);
        printHorizontal(guion, maxChars);
        if(nums[1].length()!=1){
            int counter=0;
            for(int i=nums[1].length()-1;i>=0;i--){
                int digit= Character.getNumericValue(nums[1].charAt(i));
                int multiply = digit*uno;
                String n= String.valueOf(multiply);
                for (int x=0; x<counter; x++){
                    n+=" ";
                }
                counter++;
                printHorizontal(n, maxChars);
            }
            guion="-";
            for(int z=0; z<resultado.length()-1;z++){
                guion+="-";
            }
            printHorizontal(guion, maxChars);
        }
        printHorizontal(resultado, maxChars);

    }
    
    public static void printSumaResta (String[] nums, String op, String resultado){
        int maxChars = 0;
        int maxLines =0;
        
        String dos =op+nums[1];
        if(nums[0].length()>= dos.length()){
            if(resultado.length()<=nums[0].length()){
                maxChars=nums[0].length();
            }else{
                maxChars=resultado.length();
            }
        }else{
            if(resultado.length()<=dos.length()){
                maxChars=dos.length();
            }else{
                maxChars=resultado.length();
            }
        }

        if(resultado.length()<=dos.length()){
            maxLines = dos.length();
        }else{
            maxLines = resultado.length();
        }

        String guion="-";
        for(int j=0; j<maxLines-1;j++){
            guion+="-";
        }

        printHorizontal(nums[0], maxChars);
        printHorizontal(dos, maxChars);
        printHorizontal(guion, maxChars);
        printHorizontal(resultado, maxChars);

    }

    public static void printHorizontal (String line, int max){
        int spaces=0;
        if(line.length()>=max){
            System.out.println(line);
        }else{
            spaces= max-line.length();
            for(int i=0; i<spaces; i++){
                System.out.print(" ");
            }
            System.out.println(line);
        }
        
    }

}