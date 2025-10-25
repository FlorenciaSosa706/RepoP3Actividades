package RepoP3Actividades.ActividadesClase910.actividad3;

public class Almacen {
    private String id;
    private String nombre;

    public Almacen(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre + " (ID: " + id + ")";
    }
}