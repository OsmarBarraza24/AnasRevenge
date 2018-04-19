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
import mx.caterpillar.anasrevenge.nucleo.entidades.HibernateUtil;
import mx.caterpillar.anasrevenge.nucleo.entidades.Sesion;
import mx.caterpillar.anasrevenge.nucleo.interfaces.ISesion;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author osmar
 */
public class SesionImplementacion implements ISesion {

    @Override
    public List<Sesion> getAll() {
        List<Sesion> sesiones = new ArrayList<Sesion>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Sesion> criteria = builder.createQuery(Sesion.class);
            criteria.from(Sesion.class);
            sesiones = session.createQuery(criteria).getResultList();
            session.close();
        } catch (Exception ex) {
            System.out.println("Ocurrió un error al intentar obtener Alumnos. Descripción: " + ex.getMessage());
        }
        return sesiones;
    }

    @Override
    public Sesion getByUID(String uid) {
        Sesion sesion = new Sesion();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Alumno> criteria = builder.createQuery(Alumno.class);
            criteria.from(Sesion.class);
            sesion = (Sesion) session.createCriteria(Sesion.class).add(Restrictions.eq("uid", uid)).list().get(0);
            session.close();
        } catch (Exception e) {
        }
        return sesion;
    }

    @Override
    public void save(Sesion sesion) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(sesion);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al intentar guardad el objeto de tipo usuario");
        }
    }

    @Override
    public void update(Sesion sesion) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(sesion);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al intentar guardad el objeto de tipo usuario");
        }
    }

    @Override
    public void delete(int id) {
        Sesion sesion = new Sesion();
        sesion.setId(id);
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(sesion);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al intentar guardad el objeto de tipo usuario");
        }
    }

}
