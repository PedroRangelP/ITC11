public class ListaLigada<T extends Comparable<T>> {
    private Nodo<T> inicial;

    public Nodo<T> getInicial() {
        return inicial;
    }

    public void setInicial(Nodo<T> inicial) {
        this.inicial = inicial;
    }

    public boolean estaVacia() {
        return inicial == null;
    }

    public void insertarAlInicio(T elemento) {
        Nodo<T> aInsertar = new Nodo<>(elemento);
        aInsertar.setSiguiente(inicial);
        inicial = aInsertar;
    }

    public void insertarAlUltimo(T elemento) {
        if (estaVacia()) {
            insertarAlInicio(elemento);
        } else {
            Nodo<T> temp = inicial;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(new Nodo<T>(elemento));
        }
    }

    public int contarElementos() {
        if (estaVacia()) {
            return 0;
        } else {
            Nodo<T> temp = inicial;
            int contador = 0;
            while (temp != null) {
                contador++;
                temp = temp.getSiguiente();
            }
            return contador;
        }
    }

    public void quitarElPrimero() {
        if (estaVacia()) {
            System.out.println("No puedes quitar elementos");
        } else {
            inicial = inicial.getSiguiente();
        }
    }

    public void quitarAlFinal() {
        if (estaVacia()) {
            System.out.println("No puedes quitar elementos");
        } else {
            Nodo<T> temp = inicial;
            while (temp.getSiguiente().getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(null);
        }
    }

    public void quitarAlFinalIndice() {
        if (contarElementos() == 0) {
            System.out.println("No puedes borrar");
        } else if (contarElementos() == 1) {
            quitarElPrimero();
        } else {
            Nodo<T> penultimo = encontrarNodoEnIndice(contarElementos() - 2);
            penultimo.setSiguiente(null);
        }
    }

    public Nodo<T> encontrarNodoEnIndice(int indice) {
        if (indice < contarElementos()) {
            Nodo<T> temp = inicial;
            for (int i = 0; i < indice; i++) {
                temp = temp.getSiguiente();
            }
            return temp;
        } else {
            System.out.println("Index out of bounds");
            return null;
        }
    }

    public T encontrarElementoEnElIndice(int indice) {
        return encontrarNodoEnIndice(indice).getElemento();
    }

    public void insertarEnElIndice(int index, T elemento) {
        if (estaVacia())
            insertarAlInicio(elemento);
        else {
            if (index >= contarElementos()) {
                System.out.println("No puedes insertar en ese indice");
                return;
            }
            if (index == contarElementos() - 1) {
                insertarAlUltimo(elemento);
                return;
            }
            if (index == 0) {
                insertarAlInicio(elemento);
                return;
            }
            Nodo<T> anterior = encontrarNodoEnIndice(index - 1);
            Nodo<T> aInsertar = new Nodo<>(elemento);
            aInsertar.setSiguiente(anterior.getSiguiente());
            anterior.setSiguiente(aInsertar);

        }
    }

    public void imprimeLista() {
        if (estaVacia()) {
            System.out.println("Lista vacía");
        } else {
            Nodo<T> temp = inicial;
            while (temp != null) {
                System.out.println("Nodo: " + temp.getElemento().toString());
                temp = temp.getSiguiente();
            }
        }
    }

    private void intercambiar(int index1, int index2) {
        Nodo<T> temp = encontrarNodoEnIndice(index1);
        T tempT = temp.getElemento();
        Nodo<T> temp2 = encontrarNodoEnIndice(index2);
        temp.setElemento(temp2.getElemento());
        temp2.setElemento(tempT);
    }

    public void bubbleSort() {
        for (int i = 0; i < contarElementos() - 1; i++) {
            //System.out.println("---- i = "+i);
            boolean intercambiado = false;
            for (int j = 0; j < contarElementos() - 1; j++) {
                //System.out.println("---- j = "+j);
                if (encontrarElementoEnElIndice(j).compareTo(encontrarElementoEnElIndice(j + 1)) > 0) {
                    //System.out.println("Intecambiado "+encontrarElementoEnElIndice(j)+" y "+encontrarElementoEnElIndice(j+1));
                    intercambiar(j, j + 1);
                    intercambiado = true;
                }
            }
            //System.out.println("No intercambiado " + (!intercambiado));
            if (!intercambiado) {
                break;
            }
        }
    }

    public void selectionSort() {
        for (int i = 0; i < contarElementos() - 1; i++) {
            int smallest = i;
            for (int j = i + 1; j < contarElementos(); j++) {
                if (encontrarElementoEnElIndice(j).compareTo(encontrarElementoEnElIndice(smallest)) < 0) {
                    smallest = j;
                }
            }
            //System.out.println("Intecambiado "+encontrarElementoEnElIndice(i)+" y "+encontrarElementoEnElIndice(smallest));
            intercambiar(i, smallest);
        }
    }

    public void insertionSort() {
        int i = 1;
        while (i < contarElementos()) {
            int j = i;
            while (j > 0 && encontrarElementoEnElIndice(j - 1).compareTo(encontrarElementoEnElIndice(j)) > 0) {
                //System.out.println("Intecambiado "+encontrarElementoEnElIndice(j)+" y "+encontrarElementoEnElIndice(j-1));
                intercambiar(j, j - 1);
                j = j - 1;
            }
            i = i + 1;
        }
    }

    public Nodo<T> mergeSort(Nodo<T> inicio) { 
        Nodo<T> inicioAnterior = inicio;
        int mid = contarElementos()/2; 
        if(inicio.getSiguiente()==null) { 
            return inicio;
        }else { 
            while((mid-1)>0) { 
                inicioAnterior=inicioAnterior.getSiguiente();
                mid--; 
            } 
        } 
        Nodo<T> nuevoInicio = inicioAnterior.getSiguiente();
        inicioAnterior.setSiguiente(null); 
        inicioAnterior=inicio; 
        Nodo<T> temp1 = mergeSort(inicioAnterior); 
        Nodo<T> temp2 = mergeSort(nuevoInicio);
    
        return merge(temp1, temp2); 
    }
    
    private Nodo<T> merge(Nodo<T> a, Nodo<T> b) { 
        Nodo<T> resultado = null;
        if(a==null) { 
            return b; 
        } 
        if(b==null) { 
            return a; 
        }
        if(a.getElemento().compareTo(b.getElemento())>0) { 
            resultado = b;
            resultado.setSiguiente(merge(a, b.getSiguiente())); 
        }else { 
            resultado = a;
            resultado.setSiguiente(merge(a.getSiguiente(), b)); 
        } 
        return resultado; 
    }

    private void preQuickSort(Nodo<T> inicial, int izquierda, int derecha) {
        T pivote = encontrarElementoEnElIndice((derecha + izquierda) / 2);
        int i = izquierda;
        int j = derecha;
        System.out.println("---- i = "+i);
        System.out.println("---- j = "+j);
        while (i <= j) {
            while (encontrarElementoEnElIndice(i).compareTo(pivote) < 0) {
                i++;
                System.out.println("---- i = "+i);
            }
            while (encontrarElementoEnElIndice(j).compareTo(pivote) > 0) {
                j--;
                System.out.println("---- j = "+j);
            }
            if (i <= j) {
                if (i != j) {
                    System.out.println("Intecambiado "+encontrarElementoEnElIndice(i)+" y "+encontrarElementoEnElIndice(j));
                    intercambiar(i, j);
                }
                i++;
                j--;
                System.out.println("---- i = "+i);
                System.out.println("---- j = "+j);
            }
        }
        if (izquierda < j)
            preQuickSort(inicial, izquierda, j);
        if (i < derecha)
            preQuickSort(inicial, i, derecha);
    }

    public void quickSort() {
        preQuickSort(this.inicial, 0, contarElementos() - 1);
    }
}