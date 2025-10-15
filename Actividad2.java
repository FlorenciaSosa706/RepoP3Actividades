//Sosa Florencia
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Actividad2 {
    private Map<Integer, List<Integer>> graph = new HashMap<>();

    public Actividad2() {
        // Construcción del grafo
        graph.put(0, Arrays.asList(1, 2, 3));
        graph.put(1, Arrays.asList(4));
        graph.put(2, Arrays.asList(5));
        graph.put(3, Arrays.asList(6));
        graph.put(4, Arrays.asList(7, 8));
        graph.put(5, new ArrayList<>());
        graph.put(6, new ArrayList<>());
        graph.put(7, new ArrayList<>());
        graph.put(8, new ArrayList<>());
    }

    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        System.out.print("Recorrido BFS desde el nodo " + start + ": ");

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        Actividad2 g = new Actividad2();
        g.bfs(0);
    }
}

