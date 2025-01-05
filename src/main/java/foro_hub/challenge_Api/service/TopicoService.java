package foro_hub.challenge_Api.service;

import foro_hub.challenge_Api.exception.DuplicateTopicoException;
import foro_hub.challenge_Api.exception.TopicoNotFoundException;
import foro_hub.challenge_Api.topico.DatosActualizarTopico;
import foro_hub.challenge_Api.topico.DatosRegistroTopicos;
import foro_hub.challenge_Api.topico.ITopicoRepository;
import foro_hub.challenge_Api.topico.Topico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private ITopicoRepository topicoRepository;

    public Topico registrarTopico(DatosRegistroTopicos datosRegistroTopicos) {
        Optional<Topico> topicoExistente = topicoRepository.findByTituloAndMensaje(datosRegistroTopicos.titulo(), datosRegistroTopicos.mensaje());
        if (topicoExistente.isPresent()) {
            throw new DuplicateTopicoException("El topico tiene el mismo titulo o mensaje que un topico ya creado en ForoHub");
        }
        Topico nuevoTopico = new Topico(datosRegistroTopicos);
        return topicoRepository.save(nuevoTopico);
    }

    public void actualizarTopico(@Valid DatosActualizarTopico datosActualizarTopico) {
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        Optional<Topico> topicoExistente = topicoRepository.findByTituloAndMensaje(datosActualizarTopico.getTitulo(), datosActualizarTopico.getMensaje());
        if (topicoExistente.isPresent() && !topicoExistente.get().getId().equals(datosActualizarTopico.id())) {
            throw new DuplicateTopicoException("El tópico con el mismo título y mensaje ya existe.");
        }
        topico.actualizarDatosTopico(datosActualizarTopico);
    }

    public Topico obtenerTopicoPorId(Long id) {
        return topicoRepository.findById(id).orElseThrow(()->
        new IllegalArgumentException("El topico con ID " + id + " no existe."));
    }

    public void eliminarTopico(Long id) {
        if (!topicoRepository.existsById(id)) {
            throw new TopicoNotFoundException("El tópico con ID " + id + " no existe.");
        }
        topicoRepository.deleteById(id);
    }

}
