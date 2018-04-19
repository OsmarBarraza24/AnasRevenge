/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.caterpillar.anasrevenge.nucleo.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import mx.caterpillar.anasrevenge.nucle.enumeradores.Sexo;

/**
 *
 * @author osmar
 */
@Entity
public class Alumno {
    private int id;
    private String uid;
    private String matricula;
    private String nombre;
    private Sexo sexo;
    private String apellidoPaterno;
    private String appellidoMaterno;
    private String grupo;

    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the nombre
     */
     
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidoPaterno
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * @param apellidoPaterno the apellidoPaterno to set
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * @return the appellidoMaterno
     */
    public String getAppellidoMaterno() {
        return appellidoMaterno;
    }

    /**
     * @param appellidoMaterno the appellidoMaterno to set
     */
    public void setAppellidoMaterno(String appellidoMaterno) {
        this.appellidoMaterno = appellidoMaterno;
    }

    /**
     * @return the grupo
     */
    public String getGrupo() {
        return grupo;
    }

    /**
     * @param grupo the grupo to set
     */
    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    /**
     * @return the sexo
     */
    public Sexo getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

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
     * @return the uid
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid the uid to set
     */
    public void setUid(String uid) {
        this.uid = uid;
    }
    
}
