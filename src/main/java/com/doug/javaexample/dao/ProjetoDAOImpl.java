package com.doug.javaexample.dao;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.doug.javaexample.entity.Projeto;

@Repository
public class ProjetoDAOImpl implements ProjetoDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Projeto> getProjetos() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Projeto> cq = cb.createQuery(Projeto.class);
        Root<Projeto> root = cq.from(Projeto.class);
        cq.select(root);
        return session.createQuery(cq).getResultList();
    }

    @Override
    public void saveProjeto(Projeto projeto) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(projeto);
    }

    @Override
    public Projeto getProjeto(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Projeto.class, id);
    }

    @Override
    public void deleteProjeto(int id) {
        Session session = sessionFactory.getCurrentSession();
        Projeto projeto = session.byId(Projeto.class).load(id);
        session.delete(projeto);
    }

    @Override
    public void updateProjeto(Projeto projeto) {
        Session session = sessionFactory.getCurrentSession();
        session.update(projeto);
    }
}
