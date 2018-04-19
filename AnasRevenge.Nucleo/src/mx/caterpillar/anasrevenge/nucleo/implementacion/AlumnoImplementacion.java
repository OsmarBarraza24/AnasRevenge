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
import mx.caterpillar.anasrevenge.nucleo.interfaces.IAlumno;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author osmar
 */
public class AlumnoImplementacion implements IAlumno {

    @Override
    public List<Alumno> getAll() {
        List<Alumno> alumnos = new ArrayList<Alumno>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Alumno> criteria = builder.createQuery(Alumno.class);
            criteria.from(Alumno.class);
            alumnos = session.createQuery(criteria).getResultList();
            session.close();
        } catch (Exception ex) {
            System.out.println("Ocurrió un error al intentar obtener Alumnos. Descripción: " + ex.getMessage());
        }
        return alumnos;
    }

    @Override
    public Alumno getByUID(String uid) {
        Alumno alumno = new Alumno();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Alumno> criteria = builder.createQuery(Alumno.class);
            criteria.from(Alumno.class);
            alumno = (Alumno) session.createCriteria(Alumno.class).add(Restrictions.eq("uid", uid)).list().get(0);
            session.close();
        } catch (Exception e) {
        }
        return alumno;
    }

    @Override
    public void save(Alumno alumno) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(alumno);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al intentar guardad el objeto de tipo usuario");
        }
    }

    @Override
    public void update(Alumno alumno) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(alumno);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al intentar guardad el objeto de tipo usuario");
        }
    }

    @Override
    public void delete(int id) {
        Alumno alumno = new Alumno();
        alumno.setId(id);
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(alumno);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al intentar guardad el objeto de tipo usuario");
        }
    }
}
