package com.foroAlura.api.controller;

import com.foroAlura.api.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoRepository topicoRepository;
    public TopicoController(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }
    @PostMapping
    @Transactional
    public ResponseEntity<LeerTopico> guardarTopico(@RequestBody @Valid RegistroTopico dt, UriComponentsBuilder uriBuilder){
        Topico tp = topicoRepository.save(new Topico(dt));
        LeerTopico leerTopico = new LeerTopico(tp.getId(), tp.getTitulo(), tp.getMensaje(),tp.getFecha_creacion(),tp.getAutor(),tp.getEstatus(),tp.getCurso());
        URI ur = uriBuilder.path("/topicos/{id}").buildAndExpand(tp.getId()).toUri();
        return ResponseEntity.created(ur).body(leerTopico);

    }
    @PutMapping
    @Transactional
    public ResponseEntity<String> actualizarTopico(@RequestBody @Valid ActualizarTopico actualizarTopico){
        Topico tp = topicoRepository.getReferenceById(actualizarTopico.id());
        tp.actualizarTopico(actualizarTopico);
        return ResponseEntity.accepted().build();
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> eliminarTopico(@PathVariable Long id){
        Topico tp = topicoRepository.getReferenceById(id);
        topicoRepository.delete(tp);
        return ResponseEntity.noContent().build();
    }
    @GetMapping
    public ResponseEntity <Page<ListadoTopicos>> listadoTopico(@PageableDefault(size = 4) Pageable paginacion){
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(ListadoTopicos::new));
    }
    @GetMapping("/{id}")
    public ResponseEntity<LeerTopico> leerTopico(@PathVariable Long id){

        Topico tp = topicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new LeerTopico(tp.getId(),tp.getTitulo(), tp.getMensaje(),tp.getFecha_creacion(),tp.getAutor(),tp.getEstatus(),tp.getCurso()));
    }

}
