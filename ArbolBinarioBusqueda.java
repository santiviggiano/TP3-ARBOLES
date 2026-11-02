
public class ArbolBinarioBusqueda {

    private NodoArbol raiz;

    public ArbolBinarioBusqueda() {
        raiz = null;
    }

    
    public NodoArbol getRaiz() {
        return raiz;
    }

    
    public void insertar(int x) {
        raiz = insertarRec(raiz, x);
    }

    private NodoArbol insertarRec(NodoArbol nodo, int x) {
        if (nodo == null) {
            return new NodoArbol(x);
        }
        if (x < nodo.dato) {
            nodo.izquierdo = insertarRec(nodo.izquierdo, x);
        } else if (x > nodo.dato) {
            nodo.derecho = insertarRec(nodo.derecho, x);
        }
        return nodo;
    }

    
    public boolean pertenece(int x) {
        return perteneceRec(raiz, x);
    }

    private boolean perteneceRec(NodoArbol nodo, int x) {
        if (nodo == null) {
            return false;
        }
        if (x == nodo.dato) {
            return true;
        }
        if (x < nodo.dato) {
            return perteneceRec(nodo.izquierdo, x);
        }
        return perteneceRec(nodo.derecho, x);
    }

    
    public boolean esVacio() {
        return raiz == null;
    }

    public int cantidadNodos() {
        return cantidadRec(raiz);
    }

    private int cantidadRec(NodoArbol nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 + cantidadRec(nodo.izquierdo) + cantidadRec(nodo.derecho);
    }

    

    public void inorder() {
        inorderRec(raiz);
        System.out.println();
    }

    private void inorderRec(NodoArbol nodo) {
        if (nodo == null) {
            return;
        }
        inorderRec(nodo.izquierdo);
        System.out.print(nodo.dato + " ");
        inorderRec(nodo.derecho);
    }

    public void preorder() {
        preorderRec(raiz);
        System.out.println();
    }

    private void preorderRec(NodoArbol nodo) {
        if (nodo == null) {
            return;
        }
        System.out.print(nodo.dato + " ");
        preorderRec(nodo.izquierdo);
        preorderRec(nodo.derecho);
    }

    public void postorder() {
        postorderRec(raiz);
        System.out.println();
    }

    private void postorderRec(NodoArbol nodo) {
        if (nodo == null) {
            return;
        }
        postorderRec(nodo.izquierdo);
        postorderRec(nodo.derecho);
        System.out.print(nodo.dato + " ");
    }

  
    public void recorridoPorNiveles() {
        if (raiz != null) {
            ColaNodos cola = new ColaNodos(cantidadNodos());
            cola.encolar(raiz);
            while (!cola.esVacia()) {
                NodoArbol actual = cola.desencolar();
                System.out.print(actual.dato + " ");
                if (actual.izquierdo != null) {
                    cola.encolar(actual.izquierdo);
                }
                if (actual.derecho != null) {
                    cola.encolar(actual.derecho);
                }
            }
        }
        System.out.println();
    }
}
