package com.doug.javaexample.dao;
import java.util.List;
import com.doug.javaexample.entity.Tarefa;

public interface TarefaDAO {

    List<Tarefa> getTarefas();

    void saveTarefa(Tarefa tarefa);

    Tarefa getTarefa(int id);

    void deleteTarefa(int id);

    void updateTarefa(Tarefa tarefa);

    List<Tarefa> getTarefasPorProjeto(int projetoId);


}
