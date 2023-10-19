package com.pedro.santanderbootcamp2023.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String ano;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Estilo> estilos;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Compositor> compositores;

    public Musica() {}

    public Musica(Integer id, String nome, String ano) {
        this.id = id;
        this.nome = nome;
        this.ano = ano;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public List<Estilo> getEstilos() {
        return estilos;
    }

    public void setEstilos(List<Estilo> estilos) {
        this.estilos = estilos;
    }

    public List<Compositor> getCompositores() {
        return compositores;
    }

    public void setCompositores(List<Compositor> compositores) {
        this.compositores = compositores;
    }
}
