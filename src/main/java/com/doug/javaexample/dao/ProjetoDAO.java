package com.doug.javaexample.dao;
import java.util.List;
import com.doug.javaexample.entity.Projeto;

public interface ProjetoDAO {

    List<Projeto> getProjetos();

    void saveProjeto(Projeto projeto);

    Projeto getProjeto(int id);

    void deleteProjeto(int id);


    void updateProjeto(Projeto projeto);
}
