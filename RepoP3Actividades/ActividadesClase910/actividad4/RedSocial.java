package RepoP3Actividades.ActividadesClase910.actividad4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class RedSocial {
    private Map<String, List<String>> listaAmigos;

    public RedSocial() {
        listaAmigos = new HashMap<>();
    }

    // Agregar un usuario nuevo
    public void agregarUsuario(Usuario u) {
        if (!listaAmigos.containsKey(u.getId())) {
            listaAmigos.put(u.getId(), new ArrayList<>());
        } else {
            System.out.println("⚠️ El usuario " + u.getNombre() + " ya existe en la red.");
        }
    }

    // Conectar dos usuarios (amistad bidireccional)
    public void conectarUsuarios(String id1, String id2) {
        if (listaAmigos.containsKey(id1) && listaAmigos.containsKey(id2)) {
            listaAmigos.get(id1).add(id2);
            listaAmigos.get(id2).add(id1);
        } else {
            System.out.println("❌ Uno de los usuarios no existe en la red.");
        }
    }

    // Recorrido en profundidad (DFS)
    public void dfs(String inicio) {
        Set<String> visitados = new HashSet<>();
        System.out.print("Recorrido DFS desde " + inicio + ": ");
        dfsRecursivo(inicio, visitados);
        System.out.println();
    }

    private void dfsRecursivo(String actual, Set<String> visitados) {
        visitados.add(actual);
        System.out.print(actual + " ");

        for (String amigo : listaAmigos.get(actual)) {
            if (!visitados.contains(amigo)) {
                dfsRecursivo(amigo, visitados);
            }
        }
    }

    // Recorrido en anchura (BFS)
    public void bfs(String inicio) {
        Set<String> visitados = new HashSet<>();
        Queue<String> cola = new LinkedList<>();

        visitados.add(inicio);
        cola.add(inicio);

        System.out.print("Recorrido BFS desde " + inicio + ": ");
        while (!cola.isEmpty()) {
            String actual = cola.poll();
            System.out.print(actual + " ");

            for (String amigo : listaAmigos.get(actual)) {
                if (!visitados.contains(amigo)) {
                    visitados.add(amigo);
                    cola.add(amigo);
                }
            }
        }
        System.out.println();
    }
}
