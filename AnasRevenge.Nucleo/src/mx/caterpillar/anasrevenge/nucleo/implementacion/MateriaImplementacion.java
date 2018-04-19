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
import mx.caterpillar.anasrevenge.nucleo.entidades.Alumno;
import mx.caterpillar.anasrevenge.nucleo.entidades.Clase;
import mx.caterpillar.anasrevenge.nucleo.entidades.HibernateUtil;
import mx.caterpillar.anasrevenge.nucleo.interfaces.IMateria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author osmar
 */
public class MateriaImplementacion implements IMateria {

    @Override
    public List<Clase> getAll() {
        List<Clase> clases = new ArrayList<Clase>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Clase> criteria = builder.createQuery(Clase.class);
            criteria.from(Clase.class);
            clases = session.createQuery(criteria).getResultList();
            session.close();
        } catch (Exception ex) {
            System.out.println("Ocurrió un error al intentar obtener Alumnos. Descripción: " + ex.getMessage());
        }
        return clases;
    }

    @Override
    public Clase getByUID(String uid) {
        Clase clase = new Clase();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Clase> criteria = builder.createQuery(Clase.class);
            criteria.from(Clase.class);
            clase = (Clase) session.createCriteria(Clase.class).add(Restrictions.eq("uid", uid)).list().get(0);
            session.close();
        } catch (Exception e) {
        }
        return clase;
    }

    @Override
    public void save(Clase clase) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(clase);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al intentar guardad el objeto de tipo clase");
        }
    }

    @Override
    public void update(Clase clase) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(clase);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al intentar guardad el objeto de tipo clase");
        }
    }

    @Override
    public void delete(int id) {
        Clase clase = new Clase();
        clase.setId(id);
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(clase);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al intentar guardad el objeto de tipo clase");
        }
    }

}
