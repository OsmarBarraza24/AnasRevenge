/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.caterpillar.anasrevenge.nucleo.entidades;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.*;

/**
 *
 * @author osmar
 */
@Entity
public class Sesion {

    /**
     * @return the alumnos
     */
    @ManyToMany(cascade = { CascadeType.MERGE })
    @JoinTable(
        name = "rel_asistencia_sesion", 
        joinColumns = { @JoinColumn(name = "idSesion") }, 
        inverseJoinColumns = { @JoinColumn(name = "idAsistencia") }
    )
    public List<Asistencia> getAsistencias() {
        return asistencia;
    }

    /**
     * @param alumnos the alumnos to set
     */
    public void setAsistencias(List<Asistencia> asistencia) {
        this.asistencia = asistencia;
    }
    private int id;
    private Date horaEntrada;
    private Docente docente;
    private Clase clase;
    private List<Asistencia> asistencia;

    /**
     * @return the id
     */
   @Id  
   @GeneratedValue 
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the horaEntrada
     */
    public Date getHoraEntrada() {
        return horaEntrada;
    }

    /**
     * @param horaEntrada the horaEntrada to set
     */
    public void setHoraEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    /**
     * @return the docente
     */
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idDocente")
    public Docente getDocente() {
        return docente;
    }

    /**
     * @param docente the docente to set
     */
    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    /**
     * @return the clase
     */
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idClase")
    public Clase getClase() {
        return clase;
    }

    /**
     * @param clase the clase to set
     */
    public void setClase(Clase clase) {
        this.clase = clase;
    }

    /**
     * @return the alumnos
     */
}
