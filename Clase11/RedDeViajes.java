package Clase11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


public class RedDeViajes {
    // Estructura: destino -> lista de conexiones (otro destino y su costo)
    private Map<String, List<Ruta>> mapa;

    public RedDeViajes() {
        mapa = new HashMap<>();
    }

    // Agregar un destino nuevo
    public void agregarDestino(Destino d) {
        if (!mapa.containsKey(d.getNombre())) {
            mapa.put(d.getNombre(), new ArrayList<>());
        } else {
            System.out.println("⚠️ El destino " + d.getNombre() + " ya existe.");
        }
    }

    // Conectar dos destinos con un precio (bidireccional)
    public void agregarRuta(String origen, String destino, int precio) {
        if (mapa.containsKey(origen) && mapa.containsKey(destino)) {
            mapa.get(origen).add(new Ruta(destino, precio));
            mapa.get(destino).add(new Ruta(origen, precio)); // ida y vuelta
        } else {
            System.out.println("❌ Uno de los destinos no existe.");
        }
    }

    // Mostrar las rutas desde cada destino (solo para comprobar)
    public void mostrarMapa() {
        for (String destino : mapa.keySet()) {
            System.out.print(destino + " -> ");
            for (Ruta r : mapa.get(destino)) {
                System.out.print(r.getDestino() + "($" + r.getPrecio() + ") ");
            }
            System.out.println();
        }
    }

    // Método para encontrar el camino más barato usando Dijkstra
    public void buscarCaminoMasBarato(String origen, String destinoFinal) {
        Map<String, Integer> costos = new HashMap<>();
        Map<String, String> anteriores = new HashMap<>();
        PriorityQueue<Ruta> cola = new PriorityQueue<>(Comparator.comparingInt(Ruta::getPrecio));

        for (String d : mapa.keySet()) {
            costos.put(d, Integer.MAX_VALUE); // todos infinito al inicio
        }

        costos.put(origen, 0);
        cola.add(new Ruta(origen, 0));

        while (!cola.isEmpty()) {
            Ruta actual = cola.poll();
            String nodoActual = actual.getDestino();

            for (Ruta vecino : mapa.get(nodoActual)) {
                int nuevoCosto = costos.get(nodoActual) + vecino.getPrecio();
                if (nuevoCosto < costos.get(vecino.getDestino())) {
                    costos.put(vecino.getDestino(), nuevoCosto);
                    anteriores.put(vecino.getDestino(), nodoActual);
                    cola.add(new Ruta(vecino.getDestino(), nuevoCosto));
                }
            }
        }

        // Mostrar el resultado
        if (costos.get(destinoFinal) == Integer.MAX_VALUE) {
            System.out.println("No hay ruta desde " + origen + " hasta " + destinoFinal);
        } else {
            System.out.println("\n🧭 Camino más barato de " + origen + " a " + destinoFinal + ":");
            mostrarCamino(origen, destinoFinal, anteriores);
            System.out.println("💰 Costo total: $" + costos.get(destinoFinal));
        }
    }

    // Muestra el camino reconstruyendo con el mapa de anteriores
    private void mostrarCamino(String origen, String destino, Map<String, String> anteriores) {
        List<String> camino = new ArrayList<>();
        String actual = destino;

        while (actual != null) {
            camino.add(actual);
            actual = anteriores.get(actual);
        }

        Collections.reverse(camino);
        System.out.println(String.join(" -> ", camino));
    }
}