package RepoP3Actividades.ActividadesClase910.actividad3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Grafo {
    // Lista de adyacencia (almacén -> lista de almacenes conectados)
    private Map<String, List<String>> listaAdyacencia;

    public Grafo() {
        listaAdyacencia = new HashMap<>();
    }

    // Agregar un almacén al grafo
    public void agregarAlmacen(Almacen a) {
        if (!listaAdyacencia.containsKey(a.getId())) {
            listaAdyacencia.put(a.getId(), new ArrayList<>());
        } else {
            System.out.println("⚠️ El almacén " + a.getNombre() + " ya existe en la red.");
        }
    }

    // Conectar dos almacenes (ruta bidireccional)
    public void conectarAlmacenes(String id1, String id2) {
        if (listaAdyacencia.containsKey(id1) && listaAdyacencia.containsKey(id2)) {
            listaAdyacencia.get(id1).add(id2);
            listaAdyacencia.get(id2).add(id1);
        } else {
            System.out.println("❌ Uno de los almacenes no existe en la red.");
        }
    }

    // Recorrido en profundidad (DFS)
    public void dfs(String inicio) {
        Set<String> visitados = new HashSet<>();
        System.out.print("Recorrido DFS: ");
        dfsRecursivo(inicio, visitados);
        System.out.println();
    }

    private void dfsRecursivo(String actual, Set<String> visitados) {
        visitados.add(actual);
        System.out.print(actual + " ");

        for (String vecino : listaAdyacencia.get(actual)) {
            if (!visitados.contains(vecino)) {
                dfsRecursivo(vecino, visitados);
            }
        }
    }

    // Recorrido en anchura (BFS)
    public void bfs(String inicio) {
        Set<String> visitados = new HashSet<>();
        Queue<String> cola = new LinkedList<>();

        visitados.add(inicio);
        cola.add(inicio);

        System.out.print("Recorrido BFS: ");
        while (!cola.isEmpty()) {
            String actual = cola.poll();
            System.out.print(actual + " ");

            for (String vecino : listaAdyacencia.get(actual)) {
                if (!visitados.contains(vecino)) {
                    visitados.add(vecino);
                    cola.add(vecino);
                }
            }
        }
        System.out.println();
    }
}