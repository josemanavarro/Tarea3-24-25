/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dam.di.enoteca.controlador;

import dam.di.enoteca.modelo.ModeloClientes;
import dam.di.enoteca.modelo.dto.Cliente;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;

/**
 *
 * @author jose
 */
public class ControladorClientes {
    private ModeloClientes modeloClientes;
    

    public ControladorClientes(ModeloClientes modeloClientes) {
        this.modeloClientes = modeloClientes;
    }

    public void crearCliente(String nombre, String direccion, String correo, String telefono) {
        Cliente cliente = new Cliente(nombre, direccion, correo, telefono);
        modeloClientes.agregarCliente(cliente);
    }

    public List<Cliente> listarClientes() {
        return modeloClientes.obtenerClientes();
    }

    public Optional<Cliente> buscarClientePorCorreo(String correo) {
        return modeloClientes.buscarPorCorreo(correo);
    }

    public boolean eliminarClientePorCorreo(String correo) {
        boolean borrado = false;
        try{
            borrado = modeloClientes.eliminarCliente(correo);
        } catch (IllegalArgumentException e) {
            muestraError(e.getMessage());
        }        
        return borrado;
    }

    private void muestraError(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
