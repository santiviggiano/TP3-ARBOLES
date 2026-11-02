
public class ColaNodos {

    private final NodoArbol[] datos;
    private int frente;
    private int cantidad;

    public ColaNodos(int capacidad) {
        datos = new NodoArbol[capacidad];
        frente = 0;
        cantidad = 0;
    }

    public void encolar(NodoArbol nodo) {
        if (cantidad == datos.length) {
            throw new RuntimeException("La cola está llena");
        }
        datos[(frente + cantidad) % datos.length] = nodo;
        cantidad++;
    }

    public NodoArbol desencolar() {
        if (esVacia()) {
            throw new RuntimeException("La cola está vacía");
        }
        NodoArbol nodo = datos[frente];
        datos[frente] = null;
        frente = (frente + 1) % datos.length;
        cantidad--;
        return nodo;
    }

    public boolean esVacia() {
        return cantidad == 0;
    }
}
