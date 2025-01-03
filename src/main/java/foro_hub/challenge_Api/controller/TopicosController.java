package foro_hub.challenge_Api.controller;

import foro_hub.challenge_Api.topico.DatosRegistroTopicos;
import foro_hub.challenge_Api.topico.ITopicoRepository;
import foro_hub.challenge_Api.topico.Topico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topico")
public class TopicosController {
    @Autowired
    private ITopicoRepository topicoRepository;
    @PostMapping
    public void registarTopico(@RequestBody DatosRegistroTopicos datosRegistroTopico) {
        System.out.println(datosRegistroTopico);
        topicoRepository.save(new Topico(datosRegistroTopico));
    }
}
