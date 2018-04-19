/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.caterpillar.anasrevenge.nucleo.interfaces;

import java.util.List;
import mx.caterpillar.anasrevenge.nucleo.entidades.Sesion;

/**
 *
 * @author osmar
 */
public interface ISesion {

    public List<Sesion> getAll();

    public Sesion getByUID(String uid);

    public void save(Sesion sesion);

    public void update(Sesion sesion);

    public void delete(int id);
}
