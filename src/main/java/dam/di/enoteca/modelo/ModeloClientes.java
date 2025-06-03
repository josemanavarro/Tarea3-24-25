/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dam.di.enoteca.modelo;

import dam.di.enoteca.modelo.dto.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/**
 *
 * @author jose
 */
public class ModeloClientes {
    private final List<Cliente> clientes;

    public ModeloClientes() {
        this.clientes = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente) {
        if (cliente == null
                || cliente.getNombre() == null || cliente.getNombre().trim().isEmpty()
                || cliente.getDireccion() == null || cliente.getDireccion().trim().isEmpty()
                || cliente.getCorreo() == null || cliente.getCorreo().trim().isEmpty()
                || cliente.getTelefono() == null || cliente.getTelefono().trim().isEmpty()) {
            throw new IllegalArgumentException("El cliente no puede ser nulo ni vacío.");
        } else {
            clientes.add(cliente);
        }
    }
        
    public List<Cliente> obtenerClientes() {
        return clientes;
    }

    public Optional<Cliente> buscarPorCorreo(String correo) {
        return clientes.stream()
                .filter(c -> c.getCorreo().equalsIgnoreCase(correo))
                .findFirst();
    }

    public boolean eliminarCliente(String correo) {
        boolean borrado = false;
        if (correo == null || correo.trim().isEmpty()) {
            throw new IllegalArgumentException("EL correo a eliminar no puede ser nulo ni vacío.");
        } else {
            borrado = clientes.removeIf(c -> c.getCorreo().equalsIgnoreCase(correo));
            if (!borrado) {
                throw new IllegalArgumentException("El cliente " + correo + " no existe en la lista.");
            }
        }
        return borrado;
    }
}