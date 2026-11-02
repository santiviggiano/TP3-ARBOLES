
public class NodoArbol {
    int dato;
    NodoArbol izquierdo;
    NodoArbol derecho;

    public NodoArbol(int dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }

    public NodoArbol(int dato, NodoArbol izquierdo, NodoArbol derecho) {
        this.dato = dato;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }
}
