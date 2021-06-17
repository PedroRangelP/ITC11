public class Main {
    public static void main(String[] args) {
        ListaLigada<Integer> listaLigada = new ListaLigada<>();
        listaLigada.insertarAlInicio(2222);
        listaLigada.insertarAlInicio(800);
        listaLigada.insertarAlInicio(600);
        listaLigada.insertarAlInicio(500);
        listaLigada.insertarAlInicio(400);
        listaLigada.insertarAlInicio(200);
        listaLigada.insertarAlInicio(120);
        listaLigada.insertarAlInicio(100);
        listaLigada.insertarAlInicio(50);
        listaLigada.insertarAlInicio(40);
        listaLigada.insertarAlInicio(20);
        listaLigada.insertarAlInicio(15);
        listaLigada.insertarAlInicio(10);
        
        System.out.println("El elemento 400 se encuentra en el indice " + listaLigada.binarySearch(400));
    }
}