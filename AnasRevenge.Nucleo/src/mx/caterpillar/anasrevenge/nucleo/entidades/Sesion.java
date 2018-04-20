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
    @ManyToMany(cascade = { CascadeType.PERSIST })
    @JoinTable(
        name = "rel_sesion_alumno", 
        joinColumns = { @JoinColumn(name = "idAlumno") }, 
        inverseJoinColumns = { @JoinColumn(name = "idSesion") }
    )
    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    /**
     * @param alumnos the alumnos to set
     */
    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
    private int id;
    private Date horaEntrada;
    private Date horaSalida;
    private Docente docente;
    private Clase clase;
    private List<Alumno> alumnos;

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
     * @return the horaSalida
     */
    public Date getHoraSalida() {
        return horaSalida;
    }

    /**
     * @param horaSalida the horaSalida to set
     */
    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
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
