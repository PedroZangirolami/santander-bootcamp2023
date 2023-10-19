package com.pedro.santanderbootcamp2023.repositories;

import com.pedro.santanderbootcamp2023.entities.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicRepository extends JpaRepository<Musica, Long> {

    @Query(value = "SELECT m FROM Musica m WHERE m.nome LIKE CONCAT('%', :nome, '%')")
    List<Musica> findByNome(@Param("nome") String nome);
}
