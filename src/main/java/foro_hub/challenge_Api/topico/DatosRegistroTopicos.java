package foro_hub.challenge_Api.topico;

import java.time.LocalDateTime;

public record DatosRegistroTopicos(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fecha,
        String status,
        String autor,
        String curso,
        String respuesta
) {
}
