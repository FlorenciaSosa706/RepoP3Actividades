package RepoP3Actividades.ActividadesClase910.actividad4;



public class Main {
    public static void main(String[] args) {
        RedSocial red = new RedSocial();

        // Crear usuarios
        Usuario u1 = new Usuario("U1", "Ana");
        Usuario u2 = new Usuario("U2", "Bruno");
        Usuario u3 = new Usuario("U3", "Carla");
        Usuario u4 = new Usuario("U4", "Diego");
        Usuario u5 = new Usuario("U5", "Elena");

        // Agregar usuarios a la red
        red.agregarUsuario(u1);
        red.agregarUsuario(u2);
        red.agregarUsuario(u3);
        red.agregarUsuario(u4);
        red.agregarUsuario(u5);

        // Conectar usuarios (amistades)
        red.conectarUsuarios("U1", "U2");
        red.conectarUsuarios("U1", "U3");
        red.conectarUsuarios("U2", "U4");
        red.conectarUsuarios("U3", "U5");

        // Mostrar recorridos
        red.dfs("U1");
        red.bfs("U1");
    }
}