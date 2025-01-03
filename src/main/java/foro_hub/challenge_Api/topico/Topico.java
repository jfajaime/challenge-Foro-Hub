package foro_hub.challenge_Api.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name="topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fecha;
    private String status;
    private String autor;
    private String curso;
    private String respuesta;

    public Topico(DatosRegistroTopicos datosRegistroTopico) {
        this.titulo= datosRegistroTopico.titulo();
        this.mensaje= datosRegistroTopico.mensaje();
        this.fecha = datosRegistroTopico.fecha();
        this.status = datosRegistroTopico.status();
        this.autor= datosRegistroTopico.autor();
        this.curso= datosRegistroTopico.curso();
        this.respuesta= datosRegistroTopico.respuesta();
    }
}
