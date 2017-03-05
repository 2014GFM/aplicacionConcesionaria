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
public class CustomListModelAutos extends AbstractListModel{
 
    private ArrayList<Auto> lista = new ArrayList<>();
    
    @Override
    public int getSize() {
        return lista.size();
    }
 
    @Override
    public Object getElementAt(int index) {
        Auto p = lista.get(index);
        return p.getMarca();
    }
    public void agregarAuto(Auto p) {
        lista.add(p);
        this.fireIntervalAdded(this, getSize(), getSize()+1);
    }
    public void agregarAutoDB(Auto p, int idautos, String marca, String modelo, String color, int alto, int ancho, int largo, float precio) throws Exception{
        Auto.insertar(idautos, marca, modelo, color, alto, ancho, largo, precio);
        lista.add(p);
        this.fireIntervalAdded(this, getSize(), getSize()+1);
    }
    public void eliminarAuto(Auto p, int index0) throws Exception{
        Auto.eliminar(p);
        lista.remove(index0);
        this.fireIntervalRemoved(index0, getSize(), getSize()+1);
    }
    public Auto getAuto(int index){
        return lista.get(index);
    }
}
