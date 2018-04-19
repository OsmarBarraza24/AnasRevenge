/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.caterpillar.anasrevenge.nucleo.interfaces;

import java.util.List;
import mx.caterpillar.anasrevenge.nucleo.entidades.Docente;

/**
 *
 * @author osmar
 */
public interface IDocente {

    public List<Docente> getAll();

    public Docente getByUID(String uid);

    public void save(Docente docente);

    public void update(Docente docente);

    public void delete(int id);
}
