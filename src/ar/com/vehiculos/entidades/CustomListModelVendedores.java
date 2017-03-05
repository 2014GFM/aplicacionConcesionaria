/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.vehiculos.entidades;

import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author Daiana
 */
public class CustomListModelVendedores extends AbstractListModel{
 
    private ArrayList<Vendedor> lista = new ArrayList<>();
    
    @Override
    public int getSize() {
        return lista.size();
    }
 
    @Override
    public Object getElementAt(int index) {
        Vendedor p = lista.get(index);
        return p.getNombre();
    }
    public void agregarPersona(Vendedor p){
        lista.add(p);
        this.fireIntervalAdded(this, getSize(), getSize()+1);
    }
    public void agregarPersonaDB(Vendedor p, int idvendedores, String nombre, String apellido, int numeroDocumento, int cantAutosVendidos) throws Exception{
        Vendedor.insertar(idvendedores, nombre, apellido, numeroDocumento, cantAutosVendidos);
        lista.add(p);
        this.fireIntervalAdded(this, getSize(), getSize()+1);
    }
    public void eliminarPersona(Vendedor p, int index0) throws Exception {
        Vendedor.eliminar(p);
        lista.remove(index0);
        this.fireIntervalRemoved(index0, getSize(), getSize()+1);
    }
    public Vendedor getPersona(int index){
        return lista.get(index);
    }
}
