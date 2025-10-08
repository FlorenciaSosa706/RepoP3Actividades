package RepoP3Actividades.ActividadesClase910;

public class Main2 {
    public static void main(String[] args) {
        RedSocial red = new RedSocial();

        red.agregarUsuario(new Usuario(0, "--> Ana"));
        red.agregarUsuario(new Usuario(1, "--> Bruno"));
        red.agregarUsuario(new Usuario(2, "--> Carla"));
        red.agregarUsuario(new Usuario(3, "--> Diego"));
        red.agregarUsuario(new Usuario(4, "--> Elena"));

        red.conectarAmigos(0, 1);
        red.conectarAmigos(0, 2);
        red.conectarAmigos(1, 3);
        red.conectarAmigos(2, 4);

        red.recorridoDFS(0);
        System.out.println();
        red.recorridoBFS(0);
    }
}

