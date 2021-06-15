import java.util.Scanner;
public class onp {
    public static void main (String args[]){
        Scanner sc= new Scanner(System.in);
        int expressions = sc.nextInt();
        sc.nextLine();
        String[] ec= new String [expressions];
        for (int i=0; i<ec.length;i++){
            ec[i]= sc.nextLine();
        }

        stacc(ec);
        
    }

    public static void stacc (String[] exp){
        for(int j=0;j<exp.length; j++){
            String ans="";
            String stack="";
            String last= "";
            for(int i=0 ; i<exp[j].length(); i++){
                switch (exp[j].charAt(i)){
                    case '(': 
                        break;
                    case '+':
                        stack+= exp[j].charAt(i);
                        last= stack;
                        break;
                    case '-':
                        stack+= exp[j].charAt(i);
                        last= stack;
                        break;
                    case '/':
                        stack+= exp[j].charAt(i);
                        last= stack;
                        break;
                    case '*':
                        stack+= exp[j].charAt(i);
                        last= stack;
                        break;
                    case '^':
                        stack+= exp[j].charAt(i);
                        last= stack;
                        break;
                    case ')':
                        //System.out.println(stack.charAt(last)+" index:"+last);
                        ans+= stack.charAt(stack.length()-1);
                        System.out.println("ANS = "+ans);
                        last= stack.substring(0, stack.length()-1);
                        System.out.println("LAST = "+last);
                        stack=last;
                        System.out.println("STACK = "+stack);
                        break;
                    default:
                        ans+=exp[j].charAt(i);
                        break;
                }
            }
            System.out.println(ans);
        }
       
    }
}