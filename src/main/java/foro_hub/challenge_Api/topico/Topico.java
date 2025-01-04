//package foro_hub.challenge_Api.topico;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.EqualsAndHashCode;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import java.time.LocalDateTime;
//
//@Table(name="topicos")
//@Entity(name = "Topico")
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode(of = "id")
//public class Topico {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String titulo;
//    private String mensaje;
//    private LocalDateTime fecha;
//    private String status;
//    private String autor;
//    private String curso;
//    private String respuesta;
//
//    public Topico(DatosRegistroTopicos datosRegistroTopico) {
//        this.titulo= datosRegistroTopico.titulo();
//        this.mensaje= datosRegistroTopico.mensaje();
//        this.fecha = datosRegistroTopico.fecha();
//        this.status = datosRegistroTopico.status();
//        this.autor= datosRegistroTopico.autor();
//        this.curso= datosRegistroTopico.curso();
//        this.respuesta= datosRegistroTopico.respuesta();
//    }
//
//}
package foro_hub.challenge_Api.topico;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

//no me funciona lombock me canse de buscar la solucion
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
@Table(name = "topicos")
@Entity(name = "Topico")
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

    @PrePersist//Agrega la fecha instantanea
    protected void onCreate() {
        this.fecha = LocalDateTime.now();
    }

    public Topico(DatosRegistroTopicos datosRegistroTopico) {
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.fecha = datosRegistroTopico.fecha();
        this.status = datosRegistroTopico.status();
        this.autor = datosRegistroTopico.autor();
        this.curso = datosRegistroTopico.curso();
        this.respuesta = datosRegistroTopico.respuesta();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Topico(Long id, String titulo, String mensaje, LocalDateTime fecha, String status, String autor, String curso, String respuesta) {
        this.id = id;
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.status = status;
        this.autor = autor;
        this.curso = curso;
        this.respuesta = respuesta;
    }

    public Topico() {
    }

    public void actualizarDatosTopico(DatosActualizarTopico datosActualizarTopico) {
        if (datosActualizarTopico.titulo() != null) {
        this.titulo= datosActualizarTopico.titulo();
        }
        if (datosActualizarTopico.mensaje() != null) {
        this.mensaje= datosActualizarTopico.mensaje();
        }
        if (datosActualizarTopico.curso() != null) {
        this.curso= datosActualizarTopico.curso();
        }

    }
}
