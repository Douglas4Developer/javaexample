package com.doug.javaexample.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.doug.javaexample.dao.ProjetoDAO;
import com.doug.javaexample.entity.Projeto;

@Service
public class ProjetoServiceImpl implements ProjetoService {

    @Autowired
    private ProjetoDAO projetoDAO;

    @Override
    @Transactional
    public List<Projeto> getProjetos() {
        return projetoDAO.getProjetos();
    }

    @Override
    @Transactional
    public void saveProjeto(Projeto projeto) {
        projetoDAO.saveProjeto(projeto);
    }

    @Override
    @Transactional
    public Projeto getProjeto(int id) {
        return projetoDAO.getProjeto(id);
    }

    @Override
    @Transactional
    public void deleteProjeto(int id) {
        projetoDAO.deleteProjeto(id);
    }

    @Override
    @Transactional
    public void updateProjeto(Projeto projeto) {
        projetoDAO.updateProjeto(projeto);
    }

}
