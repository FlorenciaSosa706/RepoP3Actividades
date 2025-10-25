package Clase11;

public class Ruta {
    private String destino;
    private int precio;

    public Ruta(String destino, int precio) {
        this.destino = destino;
        this.precio = precio;
    }

    public String getDestino() {
        return destino;
    }

    public int getPrecio() {
        return precio;
    }
}