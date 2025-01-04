package foro_hub.challenge_Api.topico;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotNull
        Long id,
        String titulo,
        String mensaje,
        String curso
) {
    public String getTitulo() {
        return titulo;
    }


    public String getMensaje() {
        return mensaje;
    }
}
