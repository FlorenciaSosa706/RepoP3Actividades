package RepoP3Actividades.ActividadesClase910.actividad3;



public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        // Crear almacenes
        Almacen a1 = new Almacen("A", "Central");
        Almacen a2 = new Almacen("B", "Norte");
        Almacen a3 = new Almacen("C", "Sur");
        Almacen a4 = new Almacen("D", "Este");

        // Agregar almacenes al grafo
        grafo.agregarAlmacen(a1);
        grafo.agregarAlmacen(a2);
        grafo.agregarAlmacen(a3);
        grafo.agregarAlmacen(a4);

        // Conectar almacenes
        grafo.conectarAlmacenes("A", "B");
        grafo.conectarAlmacenes("A", "C");
        grafo.conectarAlmacenes("B", "D");

        // Mostrar recorridos
        grafo.dfs("A");
        grafo.bfs("A");
    }
}