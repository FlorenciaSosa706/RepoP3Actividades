import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DistribucionCargas {

    public static List<List<Integer>> asignarPaquetes(List<Integer> paquetes, int camiones) {
        // Ordenar los paquetes de mayor a menor peso
        paquetes.sort(Collections.reverseOrder());

        // Inicializar cargas y asignaciones
        int[] carga = new int[camiones];
        List<List<Integer>> asignacion = new ArrayList<>();
        for (int i = 0; i < camiones; i++) {
            asignacion.add(new ArrayList<>());
        }

        // Asignar cada paquete al camión con menor carga actual
        for (int peso : paquetes) {
            int idx = indiceMinimo(carga);
            carga[idx] += peso;
            asignacion.get(idx).add(peso);
        }

        return asignacion;
    }

    private static int indiceMinimo(int[] carga) {
        int min = carga[0], idx = 0;
        for (int i = 1; i < carga.length; i++) {
            if (carga[i] < min) {
                min = carga[i];
                idx = i;
            }
        }
        return idx;
    }

    // Ejemplo de uso
    public static void main(String[] args) {
        List<Integer> paquetes = Arrays.asList(10, 5, 8, 3, 7, 6, 4);
        int camiones = 3;

        List<List<Integer>> resultado = asignarPaquetes(paquetes, camiones);

        for (int i = 0; i < resultado.size(); i++) {
            System.out.println("Camión " + (i + 1) + ": " + resultado.get(i));
        }
    }
}
