/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.com.aplicacionConcesionaria.baseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Educacionit
 */
public class AdministradorDeConexiones {


    // Static porque no necesitas crear un objeto para utilizarlo
    public static Connection obtenerConexion() throws Exception
    {
        // Establezco el nombre del driver a utilizar
        String dbDriver = "com.mysql.jdbc.Driver";

        // Establezco la conexion a utilizar contra la base de datos (Ingreso dns y nombre de base de datos.
        String dbConnString = "jdbc:mysql://127.0.0.1/concesionaria"; 

        // Establezco el usuario de la base de datos
        String dbUser = "root";

        // Establezco la contraseña de la base de datos
        String dbPassword = "";

        // Establezco el driver de conexion
        Class.forName(dbDriver).newInstance();

        // Retorna la conexion
        return DriverManager.getConnection(dbConnString, dbUser, dbPassword);
    }

}
