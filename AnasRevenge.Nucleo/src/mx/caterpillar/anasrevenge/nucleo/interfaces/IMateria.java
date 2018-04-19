/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.caterpillar.anasrevenge.nucleo.interfaces;

import java.util.List;
import mx.caterpillar.anasrevenge.nucleo.entidades.Clase;

/**
 *
 * @author osmar
 */
public interface IMateria {

    public List<Clase> getAll();

    public Clase getByUID(String uid);

    public void save(Clase clase);

    public void update(Clase clase);

    public void delete(int id);
}
