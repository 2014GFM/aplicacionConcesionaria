package ar.com.vehiculos.entidades;

import java.sql.Connection;
import ar.com.base.entidades.Vehiculo;
import ar.com.baseDeDatos.AdministradorDeConexiones;
import java.sql.ResultSet;
import java.sql.Statement;

public class Auto extends Vehiculo{
    
    // Declaro atributos privados
    
    private String marca;
    private String modelo;
    private String color; 
    private float precio;
    private int idautos;

    //Creo setters y getters

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getIdautos() {
        return idautos;
    }

    public void setIdautos(int idautos) {
        this.idautos = idautos;
    }
    
    // Creo constructor vacio y constructor con parametros

    public Auto() {
    }

    public Auto(int idautos, String marca, String modelo, String color, int alto, int ancho, int largo, float precio) {
        super(alto, ancho, largo);
        this.idautos = idautos;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
    }
    
    public static void insertar(int idautos, String marca, String modelo, String color, int alto, int ancho, int largo, float precio) throws Exception{
        //obtengo una conexion
        Connection unaConexion = AdministradorDeConexiones.obtenerConexion();
         
        //armo la sentencia
        String unaInsercion = "insert into autos values(null,'"+marca+"','"+modelo+"','"+color+"','"+alto+"','"+ancho+"','"+largo+"',"+precio+")";
         
        //creo un objeto de tipo Statement q ejecutara la sentencia de insercion
        Statement unaSentencia = unaConexion.createStatement();
        
        //ejecuto la sentencia de insercion
        unaSentencia.execute(unaInsercion);
        
        //cierro la conexion
        unaSentencia.close();
        unaConexion.close();
        
        //informo q hice la insercion
        System.out.println("Insercion OK!!");
    }
    
    public static void actualizar(Auto c,String parametroACambiar,String nuevoValor) throws Exception{
        //obtengo una conexion
        Connection unaConexion = AdministradorDeConexiones.obtenerConexion();
         
        //armo la sentencia
        String unaActualizacion = "update autos set "+parametroACambiar+" = '"+nuevoValor+"' where idautos = "+ c.getIdautos();
         
        //creo un objeto de tipo Statement q ejecutara la sentencia de insercion
        Statement unaSentencia = unaConexion.createStatement();
        
        //ejecuto la sentencia de insercion
        unaSentencia.execute(unaActualizacion);
        
        //cierro la conexion
        unaSentencia.close();
        unaConexion.close();
        
        //informo q hice la actualizacion
        System.out.println("Actualizacion OK!!");
    }
    
    public static void eliminar(Auto p) throws Exception {
        //obtengo una conexion
        Connection unaConexion = AdministradorDeConexiones.obtenerConexion();
         
        //armo la sentencia
        String unaEliminacion = "delete from autos where idautos = "+ p.getIdautos();
         
        //creo un objeto de tipo Statement q ejecutara la sentencia de insercion
        Statement unaSentencia = unaConexion.createStatement();
        
        //ejecuto la sentencia de insercion
        unaSentencia.execute(unaEliminacion);
        
        //cierro la conexion
        unaSentencia.close();
        unaConexion.close();
        
        //informo q hice la insercion
        System.out.println("Eliminacion OK!!");
    }
    
    public static void obtenerTodos() throws Exception{
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
            
            String marca = unResultado.getString("marca");
            String modelo = unResultado.getString("modelo");
            String color = unResultado.getString("color");
            int alto = unResultado.getInt("alto");
            int ancho = unResultado.getInt("ancho");
            int largo = unResultado.getInt("largo");
            float precio = unResultado.getInt("precio");
        }
        
        // Cierro la sentencia
        unaSentencia.close();
        unaConexion.close();
    }
    
    //Creo metodo toString

    @Override
    public String toString() {
        return "Marca: " + marca + ", Modelo: " + modelo + ", Color: " + color + super.toString() + ", Precio: " + precio;
    }
    
}
