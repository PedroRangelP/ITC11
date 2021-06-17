//import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ListaLigada<Integer> listaLigada = new ListaLigada<>();
        /*Random random = new Random();

        for (int i = 0; i < 5; i++) {
            listaLigada.insertarAlInicio(random.nextInt(100));
        }*/

        listaLigada.insertarAlInicio(50);
        listaLigada.insertarAlUltimo(3);
        listaLigada.insertarAlUltimo(10);
        listaLigada.insertarAlUltimo(69);
        listaLigada.insertarAlUltimo(96);
        listaLigada.insertarAlUltimo(6);
        listaLigada.insertarAlUltimo(1);

        listaLigada.imprimeLista();

        //System.out.println("-----Bubble Sort-----"); listaLigada.bubbleSort(); listaLigada.imprimeLista();
        //System.out.println("-----Selection Sort-----"); listaLigada.selectionSort(); listaLigada.imprimeLista();
        //System.out.println("-----Insertion Sort-----"); listaLigada.insertionSort(); listaLigada.imprimeLista();
        //System.out.println("-----Merge Sort-----"); listaLigada.mergeSort(listaLigada.getInicial()); listaLigada.imprimeLista();
        System.out.println("-----Quick Sort-----"); listaLigada.quickSort(); listaLigada.imprimeLista();
    }
}