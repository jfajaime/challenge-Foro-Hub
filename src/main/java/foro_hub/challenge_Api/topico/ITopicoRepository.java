package foro_hub.challenge_Api.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ITopicoRepository extends JpaRepository<Topico, Long> {
    Optional<Topico> findByTituloAndMensaje(String titulo, String mensaje);

    @Query("select t from Topico t where t.curso = :curso and year(t.fecha) = :anio")
    Page<Topico> findByCursoAndFechaYear(String curso, Integer anio, Pageable pageable);

    Page<Topico> findByStatusTrue(Pageable paginacion);
}
