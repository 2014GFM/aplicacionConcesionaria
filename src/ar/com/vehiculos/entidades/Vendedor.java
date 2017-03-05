package ar.com.vehiculos.entidades;

import ar.com.base.entidades.Persona;
import ar.com.baseDeDatos.AdministradorDeConexiones;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Vendedor extends Persona{
    
    // Declaro atributos privados
    
    private int cantAutosVendidos, idvendedores;
    
    //Creo setters y getters

    public int getCantAutosVendidos() {
        return cantAutosVendidos;
    }

    public void setCantAutosVendidos(int cantAutosVendidos) {
        this.cantAutosVendidos = cantAutosVendidos;
    }

    public int getIdvendedores() {
        return idvendedores;
    }

    public void setIdvendedores(int idvendedores) {
        this.idvendedores = idvendedores;
    }
    
    // Creo constructor vacio y constructor con parametros

    public Vendedor() {
    }

    public Vendedor(int cantAutosVendidos, int idvendedores, String nombre, String apellido, int numeroDocumento) {
        super(nombre, apellido, numeroDocumento);
        this.idvendedores = idvendedores;
        this.cantAutosVendidos = cantAutosVendidos;
    }
    
    public static void insertar(int idvendedores, String nombre, String apellido, int numeroDocumento, int cantAutosVendidos) throws Exception{
        //obtengo una conexion
        Connection unaConexion = AdministradorDeConexiones.obtenerConexion();
         
        //armo la sentencia
        String unaInsercion = "insert into vendedores values(null,'"+nombre+"','"+apellido+"','"+numeroDocumento+"',"+cantAutosVendidos+")";
         
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
    
    public static void actualizar(Vendedor c, String parametroACambiar, String nuevoValor) throws Exception{
        //obtengo una conexion
        Connection unaConexion = AdministradorDeConexiones.obtenerConexion();
         
        //armo la sentencia
        String unaActualizacion = "update vendedores set "+parametroACambiar+" = '"+nuevoValor+"' where nombre = "+c.getNombre();
         
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
    
    public static void eliminar(Vendedor p) throws Exception{
        //obtengo una conexion
        Connection unaConexion = AdministradorDeConexiones.obtenerConexion();
         
        //armo la sentencia
        String unaEliminacion = "delete from vendedores where idvendedores = "+p.getIdvendedores();
         
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
        String unaConsulta = "select * from vendedores";
        // Creo un objeto de tipo Statement que ejecutara la sentencia
        Statement unaSentencia = unaConexion.createStatement();
        // Ejecuto la senetencia y almaceno el resultado en un objeto de tipo ResulSet
        ResultSet unResultado = unaSentencia.executeQuery(unaConsulta);
        // Recorro el resultado y lo imprimo en consola
        while (unResultado.next()) {
            unResultado.getString("nombre");
            unResultado.getString("apellido");
            unResultado.getString("numeroDocumento");
            unResultado.getString("cantAutosVendidos");
        }
        
        // Cierro la sentencia
        unaSentencia.close();
        unaConexion.close();
    }
    
    //Creo metodo toString

    @Override
    public String toString() {
        return super.toString() + ", Cantidad de Autos Vendidos: " + cantAutosVendidos;
    }
    
}
