package torres;

public class TorresDeHanoi {
    
    public static void torresDeHanoi(int pisos) {
        moverPiezas(pisos, 3, 1);
    }

    public static void moverPiezas(int pisos, int dondeQuieroMiTorre, int procedencia) {
        //Caso base
        if(pisos==1) {
            System.out.println("Mover aro "+pisos+" de torre "+procedencia+" a torre "+dondeQuieroMiTorre);
        }
        else {
            //Mando los demas discos a donde no estorben
            moverPiezas(pisos-1, (6-procedencia-dondeQuieroMiTorre), procedencia);
            System.out.println("Mover aro "+pisos+" de torre "+procedencia+" a torre "+dondeQuieroMiTorre);
            //mando ultimo disco a la torre que este libre
            moverPiezas(pisos-1, dondeQuieroMiTorre, (6-procedencia-dondeQuieroMiTorre));
        }
    }

    public static double calcularPasos(int pisos) {
        //Se usa la formula para calcular los pasos (2^discos)-1
        return (Math.pow(2, pisos)-1);
    }
}