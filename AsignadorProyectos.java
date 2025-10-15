import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AsignadorProyectos {

    public static List<List<Integer>> asignarProyectos(List<Integer> proyectos, int empleados) {
        // Ordenar los proyectos de mayor a menor duración (LPT)
        proyectos.sort(Collections.reverseOrder());

        // Inicializar cargas y asignaciones
        int[] carga = new int[empleados];
        List<List<Integer>> asignacion = new ArrayList<>();
        for (int i = 0; i < empleados; i++) {
            asignacion.add(new ArrayList<>());
        }

        // Asignar cada proyecto al empleado con menor carga actual
        for (int tiempo : proyectos) {
            int idx = indiceMinimo(carga);
            carga[idx] += tiempo;
            asignacion.get(idx).add(tiempo);
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
        List<Integer> proyectos = Arrays.asList(4, 2, 7, 3, 5, 8, 6);
        int empleados = 3;

        List<List<Integer>> resultado = asignarProyectos(proyectos, empleados);

        for (int i = 0; i < resultado.size(); i++) {
            System.out.println("Empleado " + (i + 1) + ": " + resultado.get(i));
        }
    }
}
