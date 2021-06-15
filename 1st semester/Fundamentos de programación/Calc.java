public class Calc{
	public static void main (String [] args) {
		char operator;
        /*int a, b, c, d, ;*/double a, b, c = 0;
		
        /*a= Integer.parseInt (System.console().readLine());*/a = Double.parseDouble(System.console().readLine());
        operator = System.console().readLine().charAt(0);
		
        do{
		    switch(operator) {
		
		    /*case 1: '+';*/case '+':
			    System.out.println("Addition");
			    /*b= Integer.parseInt (System.console().readLine());*/b = Double.parseDouble(System.console().readLine());
			    c= a+b;
			    break;

		    /*case 2: '-';*/case '-':
			    System.out.println("Substraction");
			    /*b= Integer.parseInt (System.console().readLine());*/b = Double.parseDouble(System.console().readLine());
			    c= a-b;
			    break;

		    /*case 3: '*';*/case '*':
			    System.out.println("Multiplication");
			    /*b= Integer.parseInt (System.console().readLine());*/b = Double.parseDouble(System.console().readLine());
			    c= a*b;
			    break;

		    /*case 4: '%';*/case '/':
			    System.out.println("Division");
			    /*b= Integer.parseInt (System.console().readLine());*/b = Double.parseDouble(System.console().readLine());
			    /*c= a%b;*/c = a/b;
			    break;
	
		    }
            
            a=c;

	    }while (operator != '=');

        /*System.out.println("a");*/System.out.println(a);
	}
}