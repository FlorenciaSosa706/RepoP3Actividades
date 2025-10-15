//Sosa Florencia
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Actividad1 {
    private Map<Integer, List<Integer>> graph = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();

    public Actividad1() {
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

    public void dfs(int node) {
        if (visited.contains(node)) return;

        visited.add(node);
        System.out.print(node + " ");

        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            dfs(neighbor);
        }
    }

    public static void main(String[] args) {
        Actividad1 g = new Actividad1();
        System.out.print("Recorrido DFS desde el nodo 0: ");
        g.dfs(0);
    }
}
