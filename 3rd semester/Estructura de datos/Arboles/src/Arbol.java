public class Arbol<T extends Comparable<T>>{
    private Nodo<T> raiz;

    public Nodo<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo<T> raiz) {
        this.raiz = raiz;
    }

    public void insertar(T elemento) {
        if(raiz==null) {
            raiz = new Nodo<>(elemento);
        }else {
            insertarRecursivo(raiz, elemento);
        }
    }

    public Nodo<T> insertarRecursivo(Nodo<T> raiz, T elemento) {
        if(raiz==null) {
            raiz = new Nodo<>(elemento);
            return raiz;
        }else {
            if(elemento.compareTo(raiz.getElemento())>0) {
                raiz.setDerecho(insertarRecursivo(raiz.getDerecho(), elemento));
            }
            if(elemento.compareTo(raiz.getElemento())<0) {
                raiz.setIzquierdo(insertarRecursivo(raiz.getIzquierdo(), elemento));
            }
        }
        return raiz;
    }
    public void recorreEnOrden() {
        recorreEnOrden(raiz);
    }

    private void recorreEnOrden(Nodo <T> nodo) {
        if (nodo!=null) {
            recorreEnOrden(nodo.getIzquierdo());
            System.out.println("Nodo: "+nodo.getElemento());
            recorreEnOrden(nodo.getDerecho());
        }
    }

    public void recorreEnPreOrden() {
        recorreEnPreOrden(raiz);
    }

    private void recorreEnPreOrden(Nodo<T> nodo) {
        if (nodo != null) {
            System.out.println("Nodo: " + nodo.getElemento());
            recorreEnPreOrden(nodo.getIzquierdo());
            recorreEnPreOrden(nodo.getDerecho());
        }
    }

    public void recorreEnPosOrden() {
        recorreEnPosOrden(raiz);
    }

    private void recorreEnPosOrden(Nodo<T> nodo) {
        if (nodo != null) {
            recorreEnPosOrden(nodo.getIzquierdo());
            recorreEnPosOrden(nodo.getDerecho());
            System.out.println("Nodo: " + nodo.getElemento());
        }
    }

}