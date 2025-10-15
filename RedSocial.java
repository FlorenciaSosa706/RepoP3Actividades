
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class RedSocial {
    private Map<Integer, Usuario> usuarios = new HashMap<>();
    private Map<Integer, List<Integer>> amistades = new HashMap<>();

    public void agregarUsuario(Usuario usuario) {
        usuarios.put(usuario.getId(), usuario);
        amistades.putIfAbsent(usuario.getId(), new ArrayList<>());
    }

    public void conectarAmigos(int id1, int id2) {
        amistades.get(id1).add(id2);
        amistades.get(id2).add(id1); // relación bidireccional
    }

    public void recorridoDFS(int idInicio) {
        Set<Integer> visitados = new HashSet<>();
        System.out.println("Recorrido DFS desde " + usuarios.get(idInicio) + ":");
        dfs(idInicio, visitados);
    }

    private void dfs(int id, Set<Integer> visitados) {
        if (visitados.contains(id)) return;

        visitados.add(id);
        System.out.println("→ " + usuarios.get(id));

        for (int amigo : amistades.getOrDefault(id, new ArrayList<>())) {
            dfs(amigo, visitados);
        }
    }

    public void recorridoBFS(int idInicio) {
        Set<Integer> visitados = new HashSet<>();
        Queue<Integer> cola = new LinkedList<>();

        visitados.add(idInicio);
        cola.add(idInicio);

        System.out.println("Recorrido BFS desde " + usuarios.get(idInicio) + ":");

        while (!cola.isEmpty()) {
            int actual = cola.poll();
            System.out.println("→ " + usuarios.get(actual));

            for (int amigo : amistades.getOrDefault(actual, new ArrayList<>())) {
                if (!visitados.contains(amigo)) {
                    visitados.add(amigo);
                    cola.add(amigo);
                }
            }
        }
    }
}

