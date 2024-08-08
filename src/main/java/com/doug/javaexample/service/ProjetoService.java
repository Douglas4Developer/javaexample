package com.doug.javaexample.service;

import java.util.List;
import com.doug.javaexample.entity.Projeto;

public interface ProjetoService {

    List<Projeto> getProjetos();

    void saveProjeto(Projeto projeto);

    Projeto getProjeto(int id);

    void deleteProjeto(int id);

    void updateProjeto(Projeto projeto);

    boolean hasTarefas(int projetoId);
}
