public class SumaDeNumeros{
    public int sumaDeNumerosConsecutivos(int numeroMaximo){
        int resultado=0;
        for(int i=0; i<=numeroMaximo; i++){
            resultado+=i;
        }
        return resultado;
    }

    public static int sumaDeConsecutivosRecursiva(int numeroMaximo){
        if(numeroMaximo==1){
            return 1;
        }else{
            return numeroMaximo + sumaDeConsecutivosRecursiva(numeroMaximo);
        }
    }
}