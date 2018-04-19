/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.caterpillar.anasrevenge.nucleo.interfaces;

import java.util.List;
import mx.caterpillar.anasrevenge.nucleo.entidades.Alumno;

/**
 *
 * @author osmar
 */
public interface IAlumno {

    public List<Alumno> getAll();

    public Alumno getByUID(String uid);

    public void save(Alumno alumno);

    public void update(Alumno alumno);

    public void delete(int id);
}
