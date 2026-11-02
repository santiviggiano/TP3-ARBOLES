public class Main {

    public static void main(String[] args) {
        ArbolBinarioBusqueda a = new ArbolBinarioBusqueda();
        int[] valores = {50, 30, 70, 20, 40, 60, 80, 10, 25, 65, 90};
        for (int v : valores) {
            a.insertar(v);
        }

        System.out.println("=== Recorridos sobre el árbol de ejemplo ===");
        System.out.print("inorder:           ");
        a.inorder();
        System.out.print("preorder:          ");
        a.preorder();
        System.out.print("postorder:         ");
        a.postorder();
        System.out.print("recorridoPorNiveles: ");
        a.recorridoPorNiveles();

        System.out.println("\n=== Operaciones básicas ===");
        System.out.println("esVacio (false): " + a.esVacio());
        System.out.println("cantidadNodos (11): " + a.cantidadNodos());
        System.out.println("pertenece(65) (true): " + a.pertenece(65));
        System.out.println("pertenece(66) (false): " + a.pertenece(66));
        a.insertar(50); 
        a.insertar(25); 
        System.out.println("cantidadNodos tras insertar repetidos (11): " + a.cantidadNodos());
        System.out.println("árbol vacío: esVacio (true) = " + new ArbolBinarioBusqueda().esVacio()
                + ", cantidadNodos (0) = " + new ArbolBinarioBusqueda().cantidadNodos());
        System.out.print("recorridoPorNiveles de árbol vacío (línea vacía): ");
        new ArbolBinarioBusqueda().recorridoPorNiveles();

        System.out.println("\n=== Parte 4 sobre el árbol de ejemplo ===");
        System.out.println("altura (4): " + UtilizacionArbol.altura(a));
        System.out.println("contarHojas (5: 10,25,40,65,90): " + UtilizacionArbol.contarHojas(a));
        System.out.println("sumaNodos (540): " + UtilizacionArbol.sumaNodos(a));
        ArbolBinarioBusqueda vacio = new ArbolBinarioBusqueda();
        System.out.println("vacío -> altura (0), hojas (0), suma (0): "
                + UtilizacionArbol.altura(vacio) + ", "
                + UtilizacionArbol.contarHojas(vacio) + ", "
                + UtilizacionArbol.sumaNodos(vacio));
        ArbolBinarioBusqueda uno = new ArbolBinarioBusqueda();
        uno.insertar(7);
        System.out.println("un solo nodo -> altura (1), hojas (1): "
                + UtilizacionArbol.altura(uno) + ", " + UtilizacionArbol.contarHojas(uno));

        System.out.println("\n=== Degeneración: insertar 1..n en orden creciente ===");
        ArbolBinarioBusqueda lista = new ArbolBinarioBusqueda();
        int n = 1000;
        for (int i = 1; i <= n; i++) {
            lista.insertar(i);
        }
        System.out.println("n = " + n + " -> altura (se espera " + n + "): " + UtilizacionArbol.altura(lista));
        System.out.println("hojas (se espera 1): " + UtilizacionArbol.contarHojas(lista));

        System.out.println("\n=== esABB ===");
        System.out.println("árbol de ejemplo (true): " + UtilizacionArbol.esABB(a.getRaiz()));
        System.out.println("árbol vacío (true): " + UtilizacionArbol.esABB(null));

       
        NodoArbol malo = new NodoArbol(10,
                new NodoArbol(5, null, new NodoArbol(15)),
                null);
        System.out.println("contraejemplo 10 -> 5 -> (der) 15 (false): " + UtilizacionArbol.esABB(malo));

        NodoArbol malo2 = new NodoArbol(10,
                null,
                new NodoArbol(20, new NodoArbol(3), null));
        System.out.println("contraejemplo espejado 10 -> 20 -> (izq) 3 (false): " + UtilizacionArbol.esABB(malo2));

        NodoArbol repetido = new NodoArbol(10, new NodoArbol(10), null);
        System.out.println("repetido 10 con hijo izq 10 (false): " + UtilizacionArbol.esABB(repetido));

        NodoArbol extremos = new NodoArbol(0,
                new NodoArbol(Integer.MIN_VALUE),
                new NodoArbol(Integer.MAX_VALUE));
        System.out.println("extremos MIN/MAX válidos (true): " + UtilizacionArbol.esABB(extremos));

        NodoArbol bueno = new NodoArbol(10,
                new NodoArbol(5, new NodoArbol(2), new NodoArbol(8)),
                new NodoArbol(15));
        System.out.println("armado a mano válido (true): " + UtilizacionArbol.esABB(bueno));

        System.out.println("\nVerificación ingenua (sólo hijos directos) sobre el contraejemplo, "
                + "que DEBERÍA dar false pero da: " + esABBIngenuo(malo));
    }

    
    private static boolean esABBIngenuo(NodoArbol n) {
        if (n == null) {
            return true;
        }
        if (n.izquierdo != null && n.izquierdo.dato >= n.dato) {
            return false;
        }
        if (n.derecho != null && n.derecho.dato <= n.dato) {
            return false;
        }
        return esABBIngenuo(n.izquierdo) && esABBIngenuo(n.derecho);
    }
}
