package com.doug.javaexample.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doug.javaexample.dao.TarefaDAO;
import com.doug.javaexample.entity.Tarefa;

@Service
public class TarefaServiceImpl implements TarefaService {

    @Autowired
    private TarefaDAO tarefaDAO;

    @Override
    @Transactional
    public List<Tarefa> getTarefas() {
        return tarefaDAO.getTarefas();
    }

    @Override
    @Transactional
    public void saveTarefa(Tarefa tarefa) {
        tarefaDAO.saveTarefa(tarefa);
    }

    @Override
    @Transactional
    public Tarefa getTarefa(int id) {
        return tarefaDAO.getTarefa(id);
    }

    @Override
    @Transactional
    public void deleteTarefa(int id) {
        tarefaDAO.deleteTarefa(id);
    }

    @Override
    @Transactional
    public void updateTarefa(Tarefa tarefa) {
        tarefaDAO.updateTarefa(tarefa);
    }

    @Override
    @Transactional
    public List<Tarefa> getTarefasPorProjeto(int projetoId) {
        return tarefaDAO.getTarefasPorProjeto(projetoId);
    }

}

