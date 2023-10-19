package com.pedro.santanderbootcamp2023.services;

import com.pedro.santanderbootcamp2023.entities.Musica;
import com.pedro.santanderbootcamp2023.repositories.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicService {

    @Autowired
    private MusicRepository musicRepository;

    public List<Musica> findAll(){
        return musicRepository.findAll();
    }

    public Musica findById(Long id){
        return musicRepository.findById(id).orElseThrow(NoSuchFieldError::new);
    }

    public List<Musica>  findByNome(String nome){
        List<Musica> musicas = musicRepository.findByNome(nome);
        return musicas;
    }

    public Musica create(Musica musica){
        if (!findByNome(musica.getNome()).isEmpty()) {
            throw new IllegalArgumentException("Essa musica já está cadastra");
        }
        return musicRepository.save(musica);
    }

    public void delete(Long id){
        musicRepository.deleteById(id);
    }
}
