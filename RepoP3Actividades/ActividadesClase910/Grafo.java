package RepoP3Actividades.ActividadesClase910;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Grafo {
    private Map<Integer, Almacen> almacenes = new HashMap<>();
    private Map<Integer, List<Integer>> adyacencia = new HashMap<>();

    public void agregarAlmacen(Almacen almacen) {
        almacenes.put(almacen.getId(), almacen);
        adyacencia.putIfAbsent(almacen.getId(), new ArrayList<>());
    }

    public void conectarAlmacenes(int idOrigen, int idDestino) {
        adyacencia.get(idOrigen).add(idDestino);
        adyacencia.get(idDestino).add(idOrigen); // conexión bidireccional
    }

    public void recorridoDFS(int idInicio) {
        Set<Integer> visitados = new HashSet<>();
        System.out.println("Recorrido DFS desde " + almacenes.get(idInicio) + ":");
        dfs(idInicio, visitados);
    }

    private void dfs(int id, Set<Integer> visitados) {
        if (visitados.contains(id)) return;

        visitados.add(id);
        System.out.println("→ " + almacenes.get(id));

        for (int vecino : adyacencia.getOrDefault(id, new ArrayList<>())) {
            dfs(vecino, visitados);
        }
    }

    public void recorridoBFS(int idInicio) {
        Set<Integer> visitados = new HashSet<>();
        Queue<Integer> cola = new LinkedList<>();

        visitados.add(idInicio);
        cola.add(idInicio);

        System.out.println("Recorrido BFS desde " + almacenes.get(idInicio) + ":");

        while (!cola.isEmpty()) {
            int actual = cola.poll();
            System.out.println("→ " + almacenes.get(actual));

            for (int vecino : adyacencia.getOrDefault(actual, new ArrayList<>())) {
                if (!visitados.contains(vecino)) {
                    visitados.add(vecino);
                    cola.add(vecino);
                }
            }
        }
    }
}
