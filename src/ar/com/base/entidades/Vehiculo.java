package ar.com.base.entidades;

public abstract class Vehiculo {
    
    // Declaro atributos privados
    
    private int alto;
    private int ancho;
    private int largo;
    
    //Creo setters y getters
    
    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }
    
    // Creo constructor vacio y constructor con parametros

    public Vehiculo() {
    }
    public Vehiculo(int alto, int ancho, int largo) {
        this.alto = alto;
        this.ancho = ancho;
        this.largo = largo;
    }
    
    //Creo metodo toString

    @Override
    public String toString() {
        return ", Alto: " + alto + ", Ancho: " + ancho + ", Largo: " + largo;
    }
    
}
