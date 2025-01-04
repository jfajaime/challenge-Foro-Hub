package foro_hub.challenge_Api.controller;

import foro_hub.challenge_Api.service.TopicoService;
import foro_hub.challenge_Api.topico.DatosListadoTopicos;
import foro_hub.challenge_Api.topico.DatosRegistroTopicos;
import foro_hub.challenge_Api.topico.ITopicoRepository;
import foro_hub.challenge_Api.topico.Topico;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topico")
public class TopicosController {
    @Autowired
    private ITopicoRepository topicoRepository;
    @Autowired
    private TopicoService topicoService;
    @PostMapping
    public void registarTopico(@RequestBody @Valid DatosRegistroTopicos datosRegistroTopico) {
        System.out.println(datosRegistroTopico + "sout en topicosController");
        topicoService.registrarTopico(datosRegistroTopico);//La API no debe permitir el registro de tópicos duplicados (con el mismo título y mensaje).
    }

    @GetMapping
    public Page<DatosListadoTopicos> listadoTopicos(@PageableDefault(size = 10, sort = "fecha", direction = Sort.Direction.ASC) Pageable paginacion) {
        return topicoRepository.findAll(paginacion).map(DatosListadoTopicos::new);
    }

    @GetMapping("/buscar")
    public Page<DatosListadoTopicos> buscarTopico(
            @RequestParam String curso,
            @RequestParam Integer anio,
            @PageableDefault(size = 10, sort = "fecha", direction = Sort.Direction.DESC) Pageable pageable) {
        return topicoRepository.findByCursoAndFechaYear(curso, anio, pageable).map(DatosListadoTopicos::new);
    }
    }


