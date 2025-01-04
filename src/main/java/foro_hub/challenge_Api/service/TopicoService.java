package foro_hub.challenge_Api.service;

import foro_hub.challenge_Api.exception.DuplicateTopicoException;
import foro_hub.challenge_Api.topico.DatosRegistroTopicos;
import foro_hub.challenge_Api.topico.ITopicoRepository;
import foro_hub.challenge_Api.topico.Topico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
