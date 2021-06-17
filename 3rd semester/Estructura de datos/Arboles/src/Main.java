public class Main {
    public static void main(String[] args) {
        Arbol<Integer> arbol = new Arbol<>();
        arbol.insertar(9);
        arbol.insertar(5);
        arbol.insertar(15);
        arbol.insertar(13);
        arbol.insertar(12);
        arbol.insertar(14);
        arbol.insertar(17);
        arbol.insertar(16);
        ArbolPrinter<Integer> arbolPrinter = new ArbolPrinter<>();
        arbolPrinter.printNodo(arbol.getRaiz());
        arbol.recorreEnOrden();
        System.out.println("--------------------");
        arbol.recorreEnPreOrden();
        System.out.println("--------------------");
        arbol.recorreEnPosOrden();
    }
}