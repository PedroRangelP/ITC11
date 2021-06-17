public class Main {

    public static void main(String[] args) {
        ListaLigada<Integer> listaLigada = new ListaLigada<>();
        listaLigada.insertarAlUltimo(20);
        listaLigada.insertarAlUltimo(25);
        listaLigada.insertarAlUltimo(30);
        listaLigada.insertarAlUltimo(35);
        listaLigada.imprimeLista();
        listaLigada.busquedaBinaria(35);
    }

}