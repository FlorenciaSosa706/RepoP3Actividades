package Clase11;

public class Main {
    public static void main(String[] args) {
        RedDeViajes red = new RedDeViajes();

        // Crear destinos
        Destino d1 = new Destino("Buenos Aires");
        Destino d2 = new Destino("Córdoba");
        Destino d3 = new Destino("Rosario");
        Destino d4 = new Destino("Mendoza");
        Destino d5 = new Destino("Salta");

        // Agregar destinos
        red.agregarDestino(d1);
        red.agregarDestino(d2);
        red.agregarDestino(d3);
        red.agregarDestino(d4);
        red.agregarDestino(d5);

        // Agregar rutas con precios
        red.agregarRuta("Buenos Aires", "Córdoba", 500);
        red.agregarRuta("Buenos Aires", "Rosario", 300);
        red.agregarRuta("Rosario", "Córdoba", 200);
        red.agregarRuta("Córdoba", "Mendoza", 400);
        red.agregarRuta("Mendoza", "Salta", 700);

        // Mostrar mapa (opcional)
        red.mostrarMapa();

        // Buscar camino más barato
        red.buscarCaminoMasBarato("Buenos Aires", "Salta");
    }
}
