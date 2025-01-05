package foro_hub.challenge_Api.topico;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
         Long id,
         String titulo,
         String mensaje,
         LocalDateTime fecha,
         Boolean status,
         String autor,
         String curso,
         String respuesta
) {
    public DatosRespuestaTopico(Long id, String titulo, String mensaje, LocalDateTime fecha, Boolean status,
                                String autor, String curso, String respuesta) {
        this.id = id;
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.status = status;
        this.autor = autor;
        this.curso = curso;
        this.respuesta = respuesta;
    }
}
