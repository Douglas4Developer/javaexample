package com.doug.javaexample.service;
import java.util.List;
import com.doug.javaexample.entity.Tarefa;

public interface TarefaService {

    List<Tarefa> getTarefas();

    void saveTarefa(Tarefa tarefa);

    Tarefa getTarefa(int id);

    void deleteTarefa(int id);

    void updateTarefa(Tarefa tarefa);

    List<Tarefa> getTarefasPorProjeto(int projetoId);
}
