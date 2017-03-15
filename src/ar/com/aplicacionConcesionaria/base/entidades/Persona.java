package ar.com.aplicacionConcesionaria.base.entidades;

public abstract class Persona {
    
    // Declaro atributos privados
    
    private String nombre;
    private String apellido;
    private int numeroDocumento;
    
    //Creo setters y getters
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(int numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
    
    // Creo constructor vacio y constructor con parametros

    public Persona() {
    }

    public Persona(String nombre, String apellido, int numeroDocumento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroDocumento = numeroDocumento;
    }
    
    //Creo metodo toString

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Apellido: " + apellido + ", Numero de Documento: " + numeroDocumento;
    }    
}
