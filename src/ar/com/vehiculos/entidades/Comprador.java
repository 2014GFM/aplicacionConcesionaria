package ar.com.vehiculos.entidades;

import ar.com.base.entidades.Persona;
import ar.com.baseDeDatos.AdministradorDeConexiones;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Comprador extends Persona{
    
    // Declaro atributos privados
    
    private double presupuesto;
    private int idcompradores;

    //Creo setters y getters

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public int getIcompradores() {
        return idcompradores;
    }

    public void setIdcompradores(int idcompradores) {
        this.idcompradores = idcompradores;
    }
    
    // Creo constructor vacio y constructor con parametros

    public Comprador() {
    }

    public Comprador(double presupuesto, int idcompradores, String nombre, String apellido, int numeroDocumento) {
        super(nombre, apellido, numeroDocumento);
        this.idcompradores = idcompradores;
        this.presupuesto = presupuesto;
    }
    
     
    
    public static void insertar(int idcompradores, String nombre, String apellido, int numeroDocumento, double presupuesto) throws Exception{
        //obtengo una conexion
        Connection unaConexion = AdministradorDeConexiones.obtenerConexion();
         
        //armo la sentencia
        String unaInsercion = "insert into compradores values(null,'"+nombre+"','"+apellido+"','"+numeroDocumento+"',"+presupuesto+")";
         
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
    
    public static void actualizar(Comprador c, String parametroACambiar, String nuevoValor) throws Exception{
        //obtengo una conexion
        Connection unaConexion = AdministradorDeConexiones.obtenerConexion();
         
        //armo la sentencia
        String unaActualizacion = "update compradores set "+parametroACambiar+" = '"+nuevoValor+"' where nombre = "+c.getNombre();
         
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
    
    public static void eliminar(Comprador p) throws Exception{
        //obtengo una conexion
        Connection unaConexion = AdministradorDeConexiones.obtenerConexion();

        //armo la sentencia
        String unaEliminacion = "delete from compradores where idcompradores = "+p.getIcompradores();
         
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
        String unaConsulta = "select * from compradores";
        // Creo un objeto de tipo Statement que ejecutara la sentencia
        Statement unaSentencia = unaConexion.createStatement();
        // Ejecuto la senetencia y almaceno el resultado en un objeto de tipo ResulSet
        ResultSet unResultado = unaSentencia.executeQuery(unaConsulta);
        // Recorro el resultado y lo imprimo en consola
        while (unResultado.next()) {
            unResultado.getString("nombre");
            unResultado.getString("apellido");
            unResultado.getString("numeroDocumento");
            unResultado.getString("presupuesto");
        }
        
        // Cierro la sentencia
        unaSentencia.close();
        unaConexion.close();
    }
    
    //Creo metodo toString

    @Override
    public String toString() {
        return super.toString() + ", Presupuesto: " + presupuesto;
    }
    
}
