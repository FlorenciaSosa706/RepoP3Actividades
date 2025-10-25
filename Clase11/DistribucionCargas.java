package Clase11;
import java.util.ArrayList;
import java.util.List;

public class DistribucionCargas {

    static class Paquete {
        String nombre;
        int peso;

        Paquete(String nombre, int peso) {
            this.nombre = nombre;
            this.peso = peso;
        }
    }

    static class Camion {
        String nombre;
        int cargaTotal;
        List<Paquete> paquetesAsignados;

        Camion(String nombre) {
            this.nombre = nombre;
            this.cargaTotal = 0;
            this.paquetesAsignados = new ArrayList<>();
        }

        void asignarPaquete(Paquete p) {
            paquetesAsignados.add(p);
            cargaTotal += p.peso;
        }
    }

    public static void main(String[] args) {
        List<Paquete> paquetes = new ArrayList<>();
        paquetes.add(new Paquete("Paquete A", 10));
        paquetes.add(new Paquete("Paquete B", 7));
        paquetes.add(new Paquete("Paquete C", 4));
        paquetes.add(new Paquete("Paquete D", 6));
        paquetes.add(new Paquete("Paquete E", 3));
        paquetes.add(new Paquete("Paquete F", 9));

        List<Camion> camiones = new ArrayList<>();
        camiones.add(new Camion("Camión 1"));
        camiones.add(new Camion("Camión 2"));
        camiones.add(new Camion("Camión 3"));

        paquetes.sort((p1, p2) -> p2.peso - p1.peso);

        for (Paquete p : paquetes) {
            Camion menosCargado = camiones.get(0);
            for (Camion c : camiones) {
                if (c.cargaTotal < menosCargado.cargaTotal) {
                    menosCargado = c;
                }
            }
            menosCargado.asignarPaquete(p);
        }

        for (Camion c : camiones) {
            System.out.println("\n" + c.nombre + " transporta:");
            for (Paquete p : c.paquetesAsignados) {
                System.out.println("  - " + p.nombre + " (" + p.peso + " kg)");
            }
            System.out.println("Carga total: " + c.cargaTotal + " kg");
        }
    }
}
