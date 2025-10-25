package Clase11;
import java.util.ArrayList;
import java.util.List;

public class AsignacionProyectos {
    
    static class Proyecto {
        String nombre;
        int horas;

        Proyecto(String nombre, int horas) {
            this.nombre = nombre;
            this.horas = horas;
        }
    }

    static class Empleado {
        String nombre;
        int cargaTrabajo;
        List<Proyecto> proyectosAsignados;

        Empleado(String nombre) {
            this.nombre = nombre;
            this.cargaTrabajo = 0;
            this.proyectosAsignados = new ArrayList<>();
        }

        void asignarProyecto(Proyecto p) {
            proyectosAsignados.add(p);
            cargaTrabajo += p.horas;
        }
    }

    public static void main(String[] args) {
        List<Proyecto> proyectos = new ArrayList<>();
        proyectos.add(new Proyecto("Proyecto A", 10));
        proyectos.add(new Proyecto("Proyecto B", 5));
        proyectos.add(new Proyecto("Proyecto C", 7));
        proyectos.add(new Proyecto("Proyecto D", 3));
        proyectos.add(new Proyecto("Proyecto E", 8));

        List<Empleado> empleados = new ArrayList<>();
        empleados.add(new Empleado("Empleado 1"));
        empleados.add(new Empleado("Empleado 2"));
        empleados.add(new Empleado("Empleado 3"));

        proyectos.sort((p1, p2) -> p2.horas - p1.horas);

        for (Proyecto p : proyectos) {
            Empleado menosCargado = empleados.get(0);
            for (Empleado e : empleados) {
                if (e.cargaTrabajo < menosCargado.cargaTrabajo) {
                    menosCargado = e;
                }
            }
            menosCargado.asignarProyecto(p);
        }

        for (Empleado e : empleados) {
            System.out.println("\n" + e.nombre + " tiene asignados:");
            for (Proyecto p : e.proyectosAsignados) {
                System.out.println("  - " + p.nombre + " (" + p.horas + " horas)");
            }
            System.out.println("Carga total: " + e.cargaTrabajo + " horas");
        }
    }
}
