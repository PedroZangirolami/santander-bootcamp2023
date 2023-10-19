package com.pedro.santanderbootcamp2023.controller;

import com.pedro.santanderbootcamp2023.entities.Musica;
import com.pedro.santanderbootcamp2023.services.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/musica")
public class MusicaControler {

    @Autowired
    private MusicService musicService;

    @GetMapping
    public ResponseEntity<List<Musica>> findAll(){
        List<Musica> musicas = musicService.findAll();
        return ResponseEntity.ok(musicas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Musica> findById(@PathVariable Long id){
        Musica musica = musicService.findById(id);
        return ResponseEntity.ok(musica);
    }

    @GetMapping(value = "/busca")
    public ResponseEntity<List<Musica> > findById(@RequestParam(name = "nome", defaultValue = "") String nome){
        List<Musica>  musicas = musicService.findByNome(nome);
        return ResponseEntity.ok(musicas);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        musicService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Musica> create(@RequestBody Musica musica){
        Musica musicaCriada = musicService.create(musica);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(musicaCriada.getId())
                .toUri();
        return ResponseEntity.created(location).body(musicaCriada);

    }
}
