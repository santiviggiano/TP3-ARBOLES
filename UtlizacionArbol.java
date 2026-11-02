
public class UtilizacionArbol {

  
    public static int altura(ArbolBinarioBusqueda a) {
        return alturaRec(a.getRaiz());
    }

    private static int alturaRec(NodoArbol nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 + Math.max(alturaRec(nodo.izquierdo), alturaRec(nodo.derecho));
    }

 
    public static int contarHojas(ArbolBinarioBusqueda a) {
        return contarHojasRec(a.getRaiz());
    }

    private static int contarHojasRec(NodoArbol nodo) {
        if (nodo == null) {
            return 0;
        }
        if (nodo.izquierdo == null && nodo.derecho == null) {
            return 1;
        }
        return contarHojasRec(nodo.izquierdo) + contarHojasRec(nodo.derecho);
    }

    // ---------- sumaNodos ----------
    // Suma de todos los valores. Complejidad: O(n).
    public static int sumaNodos(ArbolBinarioBusqueda a) {
        return sumaRec(a.getRaiz());
    }

    private static int sumaRec(NodoArbol nodo) {
        if (nodo == null) {
            return 0;
        }
        return nodo.dato + sumaRec(nodo.izquierdo) + sumaRec(nodo.derecho);
    }

    public static boolean esABB(NodoArbol raiz) {
        return esABBRec(raiz, null, null);
    }

    private static boolean esABBRec(NodoArbol nodo, Integer minimo, Integer maximo) {
        if (nodo == null) {
            return true;
        }
        if (minimo != null && nodo.dato <= minimo) {
            return false;
        }
        if (maximo != null && nodo.dato >= maximo) {
            return false;
        }
        return esABBRec(nodo.izquierdo, minimo, nodo.dato)
                && esABBRec(nodo.derecho, nodo.dato, maximo);
    }
}
