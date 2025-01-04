package foro_hub.challenge_Api.topico;

import java.time.LocalDateTime;

public record DatosListadoTopicos(
         String titulo,
         String mensaje,
         LocalDateTime fecha,
         String status,
         String autor,
         String curso

) {
    public DatosListadoTopicos(Topico topico) {
        this(topico.getTitulo(), topico.getMensaje(), topico.getFecha(), topico.getStatus(), topico.getAutor(), topico.getCurso());
    }
}
