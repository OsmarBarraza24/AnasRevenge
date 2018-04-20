/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.caterpillar.anasrevenge.nucleo.interfaces;

import java.util.List;
import mx.caterpillar.anasrevenge.nucleo.entidades.Asistencia;

/**
 *
 * @author jesus
 */
public interface IAsistencia {
    
    public List<Asistencia> getAll();

    public Asistencia getByID(int id);

    public void save(Asistencia asistencia);

    public void update(Asistencia asistencia);

    public void delete(int id);
}
