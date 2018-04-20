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
import mx.caterpillar.anasrevenge.nucleo.entidades.Asistencia;
import mx.caterpillar.anasrevenge.nucleo.entidades.HibernateUtil;
import mx.caterpillar.anasrevenge.nucleo.interfaces.IAsistencia;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author jesus
 */
public class AsistenciaImplementacion implements IAsistencia{

    @Override
    public List<Asistencia> getAll() {
        List<Asistencia> asistencia = new ArrayList<Asistencia>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Asistencia> criteria = builder.createQuery(Asistencia.class);
            criteria.from(Asistencia.class);
            asistencia = session.createQuery(criteria).getResultList();
            session.close();
        } catch (Exception ex) {
            System.out.println("Ocurrió un error al intentar obtener Alumnos. Descripción: " + ex.getMessage());
        }
        return asistencia;
    }

    @Override
    public Asistencia getByID(int id) {
        Asistencia asistencia = new Asistencia();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Asistencia> criteria = builder.createQuery(Asistencia.class);
            criteria.from(Asistencia.class);
            asistencia = (Asistencia) session.createCriteria(Alumno.class).add(Restrictions.eq("id", id)).list().get(0);
            session.close();
        } catch (Exception e) {
        }
        return asistencia;
    }

    @Override
    public void save(Asistencia asistencia) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(asistencia);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al intentar guardad el objeto de tipo asistencia");
        }
    }

    @Override
    public void update(Asistencia asistencia) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(asistencia);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al intentar guardad el objeto de tipo usuario");
        }
    }

    @Override
    public void delete(int id) {
        Asistencia asistencia = new Asistencia();
        asistencia.setId(id);
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(asistencia);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al intentar guardad el objeto de tipo usuario");
        }
    }
    
}
