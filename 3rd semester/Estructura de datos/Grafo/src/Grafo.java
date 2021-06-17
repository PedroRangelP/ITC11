import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Grafo<T extends Comparable<T>> {
    private List<Vertice<T>> vertices;
    private Queue<Vertice<T>> queue;
    private Stack<Vertice<T>> stack;

    public Grafo() {
        vertices = new ArrayList<>();
        queue = new LinkedList<>();
        stack = new Stack<>();
    }

    public void addVertice(T elemento) {
        boolean encontrado = false;
        for(Vertice<T> vertice : vertices) {
            if(vertice.getElemento().compareTo(elemento) == 0){
                encontrado = true;
            }
        }

        if(!encontrado) {
            vertices.add(new Vertice<>(elemento));
        }
    }

    public void addArista(T elemento1, T elemento2) {
        Vertice<T> temp1 = null;
        Vertice<T> temp2 = null;
        for(Vertice<T> vertice : vertices) {
            if(vertice.getElemento().compareTo(elemento1) == 0) {
                temp1 = vertice;
            }
        }

        for (Vertice<T> vertice : vertices) {
            if (vertice.getElemento().compareTo(elemento2) == 0) {
                temp2 = vertice;
            }
        }

        if(temp1!=null && temp2!=null) {
            Arista<T> arista = new Arista<>(temp1, temp2);
            temp1.addArista(arista);
            temp2.addArista(arista);
        }
    }

    public void reiniciarVisitas() {
        for(Vertice<T> vertice : vertices) {
            vertice.setVisitado(false);
        }
    }

    public void recorrerEnProfundidad() {
        if(vertices.get(0) == null) {
            System.out.println("El grafo está vacío");
        }else {
            stack.add(vertices.get(0));
            while(stack.size()>0) {
                Vertice<T> verticeAVisitar = stack.pop();
                if(verticeAVisitar.isVisitado()==false) {
                    System.out.println(verticeAVisitar.getElemento());
                }
                verticeAVisitar.setVisitado(true);

                List<Arista<T>> aristasAVisitar = verticeAVisitar.getAristas();
                for (Arista<T> arista : aristasAVisitar) {
                    if(!arista.getV1().isVisitado()) {
                        stack.add(arista.getV1());
                    }
                    if(!arista.getV2().isVisitado()) {
                        stack.add(arista.getV2());
                    }
                }
            }
        }
    }
}
