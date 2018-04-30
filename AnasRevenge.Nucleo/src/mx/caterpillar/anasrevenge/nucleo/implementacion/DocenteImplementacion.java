/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.caterpillar.anasrevenge.nucleo.implementacion;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import mx.caterpillar.anasrevenge.nucleo.entidades.Docente;
import mx.caterpillar.anasrevenge.nucleo.entidades.HibernateUtil;
import mx.caterpillar.anasrevenge.nucleo.interfaces.IDocente;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author osmar
 */
public class DocenteImplementacion implements IDocente{

    @Override
    public List<Docente> getAll() {
        List<Docente> docentes = new ArrayList<Docente>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Docente> criteria = builder.createQuery(Docente.class);
            criteria.from(Docente.class);
            docentes = session.createQuery(criteria).getResultList();
            session.close();
        } catch (Exception ex) {
            System.out.println("Ocurrió un error al intentar obtener registros de docente. Descripción: " + ex.getMessage());
        }
        return docentes;
    }

    @Override
    public Docente getByUID(String uid) {
        Docente docente = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Docente> criteria = builder.createQuery(Docente.class);
            criteria.from(Docente.class);
            docente = (Docente)session.createCriteria(Docente.class).add(Restrictions.eq("uid", uid)).list().get(0);
            session.close();
        } catch (Exception e) {
        }
        return docente;
    }

    @Override
    public void save(Docente docente) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(docente);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al intentar guardad el objeto de tipo docente");
        }
    }

    @Override
    public void update(Docente docente) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(docente);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al intentar guardad el objeto de tipo docente");
        }
    }

    @Override
    public void delete(int id) {
        Docente docente = new Docente();
        docente.setId(id);
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(docente);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al intentar guardad el objeto de tipo docente");
        }
    }
    
}
