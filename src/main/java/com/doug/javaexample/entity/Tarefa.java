package com.doug.javaexample.entity;

import javax.persistence.*;

@Entity
@Table(name = "tarefa")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "prioridade")
    private String prioridade;

    @Column(name = "estimativa_horas")
    private int estimativaHoras;

    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;

    // Getters e setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public int getEstimativaHoras() {
        return estimativaHoras;
    }

    public void setEstimativaHoras(int estimativaHoras) {
        this.estimativaHoras = estimativaHoras;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }
}
