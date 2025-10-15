

public class Main {
    public static void main(String[] args) {
        Grafo red = new Grafo();

        red.agregarAlmacen(new Almacen(0, "--> Central"));
        red.agregarAlmacen(new Almacen(1, "--> Norte"));
        red.agregarAlmacen(new Almacen(2, "--> Sur"));
        red.agregarAlmacen(new Almacen(3, "--> Este"));
        red.agregarAlmacen(new Almacen(4, "--> Oeste"));

        red.conectarAlmacenes(0, 1);
        red.conectarAlmacenes(0, 2);
        red.conectarAlmacenes(1, 3);
        red.conectarAlmacenes(2, 4);

        red.recorridoDFS(0);
        System.out.println();
        red.recorridoBFS(0);
    }
}

