package foro_hub.challenge_Api.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistroTopicos(
        Long id,
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
//        @NotNull
        LocalDateTime fecha,
        @NotBlank
        String status,
        @NotBlank
        String autor,
        @NotBlank
        String curso,
        @NotBlank
        String respuesta
) {
}
