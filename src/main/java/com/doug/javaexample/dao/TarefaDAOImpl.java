package com.doug.javaexample.dao;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.doug.javaexample.entity.Tarefa;

@Repository
public class TarefaDAOImpl implements TarefaDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Tarefa> getTarefas() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Tarefa> cq = cb.createQuery(Tarefa.class);
        Root<Tarefa> root = cq.from(Tarefa.class);
        cq.select(root);
        return session.createQuery(cq).getResultList();
    }

    @Override
    public void saveTarefa(Tarefa tarefa) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(tarefa);
    }

    @Override
    public Tarefa getTarefa(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Tarefa.class, id);
    }

    @Override
    public void deleteTarefa(int id) {
        Session session = sessionFactory.getCurrentSession();
        Tarefa tarefa = session.byId(Tarefa.class).load(id);
        session.delete(tarefa);
    }


    @Override
    public void updateTarefa(Tarefa tarefa) {
        Session session = sessionFactory.getCurrentSession();
        session.update(tarefa);
    }

    @Override
    public List<Tarefa> getTarefasPorProjeto(int projetoId) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Tarefa> cq = cb.createQuery(Tarefa.class);
        Root<Tarefa> root = cq.from(Tarefa.class);
        cq.select(root).where(cb.equal(root.get("projeto"), projetoId));
        return session.createQuery(cq).getResultList();
    }
}
