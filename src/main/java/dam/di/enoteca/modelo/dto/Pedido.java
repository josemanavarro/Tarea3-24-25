/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dam.di.enoteca.modelo.dto;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author jose
 */
public class Pedido {
    private int id;
    private Cliente cliente;
    private LocalDate fecha;
    private List<Botella> botellas;

    public Pedido(int id, Cliente cliente, LocalDate fecha, List<Botella> botellas) {
        this.id = id;
        this.cliente = cliente;
        this.fecha = fecha;
        this.botellas = botellas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<Botella> getBotellas() {
        return botellas;
    }

    public void setBotellas(List<Botella> botellas) {
        this.botellas = botellas;
    }

    public double calcularTotal() {
        return botellas.stream().mapToDouble(Botella::getPrecio).sum();
    }

    @Override
    public String toString() {
        return "Pedido #" + id + " - Cliente: " + cliente.getNombre() + " - Total: " + calcularTotal() + "€";
    }
}

