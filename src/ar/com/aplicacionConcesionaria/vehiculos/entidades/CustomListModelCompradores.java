/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.aplicacionConcesionaria.vehiculos.entidades;

import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author Daiana
 */
public class CustomListModelCompradores extends AbstractListModel{
 
    private ArrayList<Comprador> lista = new ArrayList<>();
    
    @Override
    public int getSize() {
        return lista.size();
    }
 
    @Override
    public Object getElementAt(int index) {
        Comprador p = lista.get(index);
        return p.getNombre();
    }
    public void agregarPersona(Comprador p){
        lista.add(p);
        this.fireIntervalAdded(this, getSize(), getSize()+1);
    }
    public void agregarPersonaDB(Comprador p, int idautos, String nombre, String apellido, int numeroDocumento, double presupuesto) throws Exception{
        Comprador.insertar(idautos, nombre, apellido, numeroDocumento, presupuesto);
        lista.add(p);
        this.fireIntervalAdded(this, getSize(), getSize()+1);
    }
    public void eliminarPersona(Comprador p, int index0) throws Exception{
        Comprador.eliminar(p);
        lista.remove(index0);
        this.fireIntervalRemoved(index0, getSize(), getSize()+1);
    }
    public Comprador getPersona(int index){
        return lista.get(index);
    }
}