/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dam.di.enoteca.modelo.dto;

/**
 *
 * @author jose
 */
public class Botella {
    private String bodega;
    private String tipo;   // joven, roble, crianza, etc.
    private String uva;    // Merlot, Syrah, etc.
    private int año;
    private double precio;

    public Botella(String bodega, String tipo, String uva, int año, double precio) {
        this.bodega = bodega;
        this.tipo = tipo;
        this.uva = uva;
        this.año = año;
        this.precio = precio;
    }

    public String getBodega() {
        return bodega;
    }

    public void setBodega(String bodega) {
        this.bodega = bodega;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUva() {
        return uva;
    }

    public void setUva(String uva) {
        this.uva = uva;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return bodega + " - " + tipo + " (" + año + ") [" + uva + "] - " + precio + "€";
    }
}