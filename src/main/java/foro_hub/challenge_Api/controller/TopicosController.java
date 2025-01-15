package foro_hub.challenge_Api.controller;

import foro_hub.challenge_Api.service.TopicoService;
import foro_hub.challenge_Api.topico.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topico")
@SecurityRequirement(name = "bearer-key")
public class TopicosController {
    @Autowired
    private ITopicoRepository topicoRepository;
    @Autowired
    private TopicoService topicoService;

//    @Autowired
//    private Topico topico;

    @PostMapping
    public ResponseEntity registarTopico(@RequestBody @Valid DatosRegistroTopicos datosRegistroTopico, UriComponentsBuilder uri) {
        Topico topico = new Topico(datosRegistroTopico);
        topicoService.registrarTopico(datosRegistroTopico);//La API no debe permitir el registro de tópicos duplicados (con el mismo título y mensaje).
        DatosRespuestaTopico drto = new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(),
                topico.getFecha(), topico.getStatus(), topico.getAutor(), topico.getCurso(), topico.getRespuesta());
        System.out.println(drto);
        URI url = uri.path("/topico/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(drto);
    }

    @GetMapping
    public ResponseEntity< Page<DatosListadoTopicos>> listadoTopicos(@PageableDefault(size = 10, sort = "fecha", direction = Sort.Direction.ASC) Pageable paginacion) {
        return ResponseEntity.ok(topicoRepository.findByStatusTrue(paginacion).map(DatosListadoTopicos::new));
//        return topicoRepository.findAll(paginacion).map(DatosListadoTopicos::new);
    }

    @GetMapping("/buscar")
    public Page<DatosListadoTopicos> buscarTopico(@RequestParam String curso, @RequestParam Integer anio,
            @PageableDefault(size = 10, sort = "fecha", direction = Sort.Direction.DESC) Pageable pageable) {
        return topicoRepository.findByCursoAndFechaYear(curso, anio, pageable).map(DatosListadoTopicos::new);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
        topicoService.actualizarTopico(datosActualizarTopico);
        return ResponseEntity.ok(datosActualizarTopico);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> obtenerTopicoPorId(@PathVariable Long id) {
        Topico topico = topicoService.obtenerTopicoPorId(id);
        return ResponseEntity.ok(topico);
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Topico> eliminarTopico(@PathVariable Long id) {
//        topicoService.eliminarTopico(id);
//        return ResponseEntity.noContent().build();
//    }
    //analizar el borrado logico
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity DesactivarStatus(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        topico.statusTopico();
        return ResponseEntity.noContent().build();
    }
}
