public class Avl<T extends Comparable<T>> {
    private Nodo<T> raiz;

    public Nodo<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo<T> raiz) {
        this.raiz = raiz;
    }

    private Nodo<T> rotacionSimpleALaDerecha(Nodo<T> nodo) {
        Nodo<T> temp = nodo.getIzquierdo();
        nodo.setIzquierdo(temp.getDerecho());
        temp.setDerecho(nodo);
        nodo.setAltura();
        return temp;
    }

    private int max(int a, int b) {
        if (a>b) {
            return a;
        }else {
            return b;
        }
    }

}