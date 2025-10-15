package RepoP3Actividades;

public class Actividad1Clase11 {
    
}


/*                         [Inicio: Solicitud recibida]
                                   │
                 ┌─────────────────┼─────────────────┐
                 │                                   │
        [Tráfico normal]                    [Tráfico sospechoso]
                 │                                   │
         [Permitir acceso]                 ┌─────────┴─────────┐
                                           │                   │
                                  [Intento de login masivo]  [Inyección SQL]
                                           │                   │
                               [Activar CAPTCHA o bloquear IP] [Filtrar entrada o alertar admin]
 */