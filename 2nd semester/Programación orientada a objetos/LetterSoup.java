public class LetterSoup{
    public static void main(String[] args){
        int a, b, q, n, size=120;
        String[][] modulo=new String[size+1][size+1];
        
        System.out.print("n=");
        n=Integer.parseInt(System.console().readLine());

        for (a=0; a<=size; a++){
            for (b=0; b<=size; b++){
                q=(a-b)%n;
                if (q==0){
                    modulo[a][b]="()";
                }else if (a==size/2){
                    modulo[a][b]=Integer.toString(b-size/2);
                }else if (b==size/2){
                    modulo[a][b]=Integer.toString(a-size/2);
                }else{
                    modulo[a][b]="";
                }      
            }
        }

        for (b=size; b>=0; b--){
            for (a=0; a<=size; a++){
                System.out.printf("%-6s", modulo[a][b]);
            }
            System.out.println("\n");
        }
    }
}