/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.aplicacionConcesionaria.vehiculos.ventanas;

import ar.com.aplicacionConcesionaria.baseDeDatos.AdministradorDeConexiones;
import ar.com.aplicacionConcesionaria.vehiculos.entidades.Auto;
import ar.com.aplicacionConcesionaria.vehiculos.entidades.CustomListModelAutos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Daiana
 */
public final class autosVentana extends javax.swing.JInternalFrame {

    /**
     * Creates new form autosVentana
     */
    // Creo lista para mostrar
    CustomListModelAutos list_model = new CustomListModelAutos();
    public autosVentana() throws Exception {
        initComponents();
        
        // Seteo list para cargar por defecto
        llenarListaDeAutos();
        
        // Desabilito botones guardar y eliminar
        btn_guardar.setEnabled(false);
        btn_eliminar.setEnabled(false);
        
        // Elimino todos los item del combobox
        combo_marca.removeAllItems();
        combo_modelo.removeAllItems();
        combo_color.removeAllItems();
       
        // Completo box de marcas, modelos, colores
        cargasMarcas();
        cargasModelos();
        cargasColores();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_listadoAutos = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_alto = new javax.swing.JTextField();
        txt_ancho = new javax.swing.JTextField();
        txt_largo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        combo_marca = new javax.swing.JComboBox<>();
        combo_modelo = new javax.swing.JComboBox<>();
        combo_color = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txt_precio = new javax.swing.JTextField();
        btn_nuevo = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_cerrar = new javax.swing.JButton();

        jButton1.setText("jButton1");

        jToggleButton1.setText("jToggleButton1");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Listado de autos");

        list_listadoAutos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        list_listadoAutos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                list_listadoAutosValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(list_listadoAutos);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Dimensiones");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel3.setText("Alto");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel4.setText("Ancho");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel5.setText("Largo");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel6.setText("cm");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel7.setText("cm");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel8.setText("cm");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel9.setText("Marca");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel10.setText("Modelo");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel11.setText("Color");

        combo_marca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        combo_modelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        combo_color.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel12.setText("Precio");

        btn_nuevo.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btn_nuevo.setText("Nuevo");
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });

        btn_guardar.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        btn_eliminar.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btn_eliminar.setText("Eliminar");
        btn_eliminar.setMaximumSize(new java.awt.Dimension(80, 31));
        btn_eliminar.setMinimumSize(new java.awt.Dimension(80, 31));
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        btn_cerrar.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btn_cerrar.setText("Cerrar");
        btn_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel10))
                                    .addGap(18, 18, 18))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3))
                                    .addGap(20, 20, 20)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(combo_modelo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(combo_color, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_alto, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                            .addComponent(txt_largo, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                            .addComponent(txt_ancho))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(0, 42, Short.MAX_VALUE))
                                    .addComponent(combo_marca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(29, 29, 29))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(128, 128, 128)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_alto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_ancho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_largo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(combo_marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combo_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combo_color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void llenarListaDeAutos() throws Exception{
        // Obtengo una conexion
        Connection unaConexion = AdministradorDeConexiones.obtenerConexion();
        // Armo la query
        String unaConsulta = "select * from autos";
        // Creo un objeto de tipo Statement que ejecutara la sentencia
        Statement unaSentencia = unaConexion.createStatement();
        // Ejecuto la senetencia y almaceno el resultado en un objeto de tipo ResulSet
        ResultSet unResultado = unaSentencia.executeQuery(unaConsulta);
        // Recorro el resultado y lo imprimo en consola
        while (unResultado.next()) {
            int idautos = unResultado.getInt("idautos");
            String marca = unResultado.getString("marca");
            String modelo = unResultado.getString("modelo");
            String color = unResultado.getString("color");
            int alto = unResultado.getInt("alto");
            int ancho = unResultado.getInt("ancho");
            int largo = unResultado.getInt("largo");
            int precio = unResultado.getInt("precio");
            
            Auto unAuto = new Auto(idautos, marca, modelo, color, alto, ancho, largo, precio);
            list_model.agregarAuto(unAuto);
        }
        
        // Cierro la sentencia
        unaSentencia.close();
        unaConexion.close();

        list_listadoAutos.setModel(list_model);
    }
    
    public void cargasMarcas(){
        //Proceso de lectura de marcas
        try {
            //creo un objeto File que representa el archivo a leer
            File entrada = new File("src\\ar\\com\\aplicacionConcesionaria\\vehiculos\\recursos\\marcas.txt");
            
            try ( //creo el stream de lectura
                FileReader lector = new FileReader(entrada)) {
                BufferedReader br = new BufferedReader(lector);
                
                // Algoritmo de lectura
                String lineaLeida = "";
                boolean b = false;
                
                while (!b) {
                    lineaLeida = br.readLine();
                    if(lineaLeida != null){
                        combo_marca.addItem(lineaLeida);
                    }
                    else{
                        b = true;
                    }
                }
            }
            
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Archivo no encontrado", "Alerta", JOptionPane.WARNING_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error de lectura", "Alerta", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void cargasColores(){
        // Proceso de lectura de colores
        try {
            //creo un objeto File que representa el archivo a leer
            File entrada = new File("src\\ar\\com\\aplicacionConcesionaria\\vehiculos\\recursos\\color.txt");

            try ( //creo el stream de lectura
                    FileReader lector = new FileReader(entrada)) {
                BufferedReader br = new BufferedReader(lector);
                
                // Algoritmo de lectura
                String lineaLeida = "";
                boolean b = false;
                
                while (!b) {
                    lineaLeida = br.readLine();
                    if(lineaLeida != null){
                        combo_color.addItem(lineaLeida);
                    }
                    else{
                        b = true;
                    }
                }
            }
            
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Archivo no encontrado", "Alerta", JOptionPane.WARNING_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error de lectura", "Alerta", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void cargasModelos(){
        // Proceso de lectura de modelos
        try {
            //creo un objeto File que representa el archivo a leer
            File entrada = new File("src\\ar\\com\\aplicacionConcesionaria\\vehiculos\\recursos\\modelos.txt");

            try ( //creo el stream de lectura
                    FileReader lector = new FileReader(entrada)) {
                BufferedReader br = new BufferedReader(lector);
                
                // Algoritmo de lectura
                String lineaLeida = "";
                boolean b = false;
                
                while (!b) {
                    lineaLeida = br.readLine();
                    if(lineaLeida != null){
                        combo_modelo.addItem(lineaLeida);
                    }
                    else{
                        b = true;
                    }
                }
            }
            
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Archivo no encontrado", "Alerta", JOptionPane.WARNING_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error de lectura", "Alerta", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void btn_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrarActionPerformed
        this.hide();
    }//GEN-LAST:event_btn_cerrarActionPerformed

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        //Limpio area de textos al precionar boton nuevo
        txt_alto.setText(null);
        txt_ancho.setText(null);
        txt_largo.setText(null);
        txt_precio.setText(null);
        
        //Al presionar boton nuevo pasa a desabilitarse
        btn_nuevo.setEnabled(false);
        
        //Al presionar boton nuevo se habilita boton guardar
        btn_guardar.setEnabled(true);
        
        //Al presionar boton nuevo el foco se pone en alto
        txt_alto.requestFocus();
    }//GEN-LAST:event_btn_nuevoActionPerformed
       
    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        //Tomo valor de caja de texto
        String ingresoAlto = txt_alto.getText();
        String ingresoAncho = txt_ancho.getText();
        String ingresoLargo = txt_largo.getText();
        String ingresoPrecio = txt_precio.getText();
        String marca = (String) combo_marca.getSelectedItem();
        String modelo = (String) combo_modelo.getSelectedItem();
        String color = (String) combo_color.getSelectedItem();
        int idautos = 0;
        
        //Valido que no este vacio
        if(ingresoAlto.isEmpty()){
            // Si alto esta vacio muestro caja de dialogo
            JOptionPane.showMessageDialog(null, "El alto no puede estar vacio", "Alerta", JOptionPane.WARNING_MESSAGE);
            // Pongo el foco en alto
            txt_alto.requestFocus();
        }
        //Valido que dato ingresado sea numero
        else if(!ingresoAlto.matches("[0-9]*")){
            // Si alto no es numero muestro caja de dialogo
            JOptionPane.showMessageDialog(null, "La altura debe ser un numero entero", "Alerta", JOptionPane.WARNING_MESSAGE);
            // Pongo el foco en alto
            txt_alto.requestFocus();
            // Limpio caja de texto
            txt_alto.setText(null);
        }
        else if(ingresoAncho.isEmpty()){
            JOptionPane.showMessageDialog(null, "El ancho no puede estar vacio", "Alerta", JOptionPane.WARNING_MESSAGE);
            txt_ancho.requestFocus();
        }
        else if(!ingresoAncho.matches("[0-9]*")){
            JOptionPane.showMessageDialog(null, "El ancho debe ser un numero entero", "Alerta", JOptionPane.WARNING_MESSAGE);
            txt_ancho.requestFocus();
            txt_ancho.setText(null);
        }
        else if(ingresoLargo.isEmpty()){
            JOptionPane.showMessageDialog(null, "El largo no puede estar vacio", "Alerta", JOptionPane.WARNING_MESSAGE);
            txt_largo.requestFocus();
        }
        else if(!ingresoLargo.matches("[0-9]*")){
            JOptionPane.showMessageDialog(null, "El largo debe ser un numero entero", "Alerta", JOptionPane.WARNING_MESSAGE);
            txt_largo.requestFocus();
            txt_largo.setText(null);
        }
        else if(ingresoPrecio.isEmpty()){
            JOptionPane.showMessageDialog(null, "El precio no puede estar vacio", "Alerta", JOptionPane.WARNING_MESSAGE);
            txt_precio.requestFocus();
        }
        else if(!ingresoPrecio.matches("[0.0-9.9]*")){
            JOptionPane.showMessageDialog(null, "El precio debe ser un numero con decimales", "Alerta", JOptionPane.WARNING_MESSAGE);
            txt_precio.requestFocus();
            txt_precio.setText(null);
        }
        // Valido que seleccione una opcion del combobox
        else if(combo_marca.getSelectedIndex()== 0){
            JOptionPane.showMessageDialog(null, "Debe seleccionar una marca", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
        else if(combo_modelo.getSelectedIndex()== 0){
            JOptionPane.showMessageDialog(null, "Debe seleccionar un modelo", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
        else if(combo_color.getSelectedIndex()== 0){
            JOptionPane.showMessageDialog(null, "Debe seleccionar un color", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
        else{
            //Si todo esta completo: guardo, habilito boton nuevo y desabilito boton guardar
            JOptionPane.showMessageDialog(null, "El auto ha sido guardado");
            
            btn_nuevo.setEnabled(true);
            btn_guardar.setEnabled(false);
            
            // Parseo alto, ancho, largo y precio
            int alto = Integer.parseInt(ingresoAlto);
            int ancho = Integer.parseInt(ingresoAncho);
            int largo = Integer.parseInt(ingresoLargo);
            float precio = Integer.parseInt(ingresoPrecio);    
            
            // Limpio cajas de textos
            txt_alto.setText(null);
            txt_ancho.setText(null);
            txt_largo.setText(null);
            txt_precio.setText(null);
            
            // Actualizo vista de comboBox
            combo_marca.removeAllItems();
            cargasMarcas();
            combo_modelo.removeAllItems();
            cargasModelos();
            combo_color.removeAllItems();
            cargasColores();
            
            // Instancio un nuevo auto
            Auto p = new Auto();
            p.setIdautos(idautos);
            p.setMarca(marca);
            p.setModelo(modelo);
            p.setColor(color);
            p.setAlto(alto);
            p.setAncho(ancho);
            p.setLargo(largo);
            p.setPrecio(precio);
            try {
                list_model.agregarAutoDB(p, idautos, marca, modelo, color, alto, ancho, largo, precio);
            } catch (Exception ex) {
                Logger.getLogger(autosVentana.class.getName()).log(Level.SEVERE, null, ex);
            }
        }          
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed

        // Elimino auto
        
        int selection = list_listadoAutos.getSelectedIndex();
        int resp = JOptionPane.showConfirmDialog(null, "Desea eliminar el auto seleccionado?", "Elija una opcion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (selection!=-1 && resp == 0) {
            try {
                Auto p = list_model.getAuto(selection);                
                list_model.eliminarAuto(p, selection);
                btn_eliminar.setEnabled(false);
                JOptionPane.showMessageDialog(null, "El auto ha sido eliminado");
                txt_alto.setText(null);
                txt_ancho.setText(null);
                txt_largo.setText(null);
                combo_marca.removeAllItems();
                cargasMarcas();
                combo_modelo.removeAllItems();
                cargasModelos();
                combo_color.removeAllItems();
                cargasColores();
                txt_precio.setText(null);
                btn_guardar.setEnabled(false);
            } catch (Exception ex) {
                Logger.getLogger(autosVentana.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void list_listadoAutosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_list_listadoAutosValueChanged
        
        // Selecciono y muestro datos de auto guardado
        int selection = list_listadoAutos.getSelectedIndex();
        if (selection!=-1) {            
            Auto p = list_model.getAuto(selection);
            combo_marca.setSelectedItem(p.getMarca());
            combo_modelo.setSelectedItem(p.getModelo());
            combo_color.setSelectedItem(p.getColor());
            txt_alto.setText(Integer.toString(p.getAlto()));
            txt_ancho.setText(Integer.toString(p.getAncho()));
            txt_largo.setText(Integer.toString(p.getLargo()));
            txt_precio.setText(Double.toString(p.getPrecio()));
            
            // Habilito boton eliminar
            btn_eliminar.setEnabled(true);
        }
    }//GEN-LAST:event_list_listadoAutosValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cerrar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JComboBox<String> combo_color;
    private javax.swing.JComboBox<String> combo_marca;
    private javax.swing.JComboBox<String> combo_modelo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JList<String> list_listadoAutos;
    private javax.swing.JTextField txt_alto;
    private javax.swing.JTextField txt_ancho;
    private javax.swing.JTextField txt_largo;
    private javax.swing.JTextField txt_precio;
    // End of variables declaration//GEN-END:variables
}
