package com.pedro.santanderbootcamp2023.services;

import com.pedro.santanderbootcamp2023.entities.Musica;
import com.pedro.santanderbootcamp2023.repositories.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService {

    @Autowired
    private MusicRepository musicRepository;

    public List<Musica> findAll(){
        return musicRepository.findAll();
    }

    public Musica create(Musica musica){
        return musicRepository.save(musica);
    }
}
