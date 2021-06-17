public class Fibonacci{
    public int serieDeFibonacci(int numeroMaximo){
        int resultado=0;
        for(int i=3; i<=numeroMaximo; i++){
            resultado=(i-1)+(i-2);
        }
        return resultado;
    }

    public static int serieDeFibonacciRecursiva(int numeroMaximo){
        if(numeroMaximo==0)
            return 0;
        else if(numeroMaximo==1)
            return 1;
        else
            return serieDeFibonacciRecursiva(numeroMaximo-1)+serieDeFibonacciRecursiva(numeroMaximo+2);
    }
}