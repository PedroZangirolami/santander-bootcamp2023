package com.pedro.santanderbootcamp2023.repositories;

import com.pedro.santanderbootcamp2023.entities.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository extends JpaRepository<Musica, Long> {
}
