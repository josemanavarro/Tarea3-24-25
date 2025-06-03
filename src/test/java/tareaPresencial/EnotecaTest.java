/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareaPresencial;

import dam.di.enoteca.modelo.ModeloClientes;
import dam.di.enoteca.modelo.dto.Cliente;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jose
 */
public class EnotecaTest {
    @Test
    void nuevoClienteSuccessfully() {
        ModeloClientes mc = new ModeloClientes();        
        Cliente test = new Cliente("Tipo del test","Dirección falsa","test@test","000111222");
        mc.agregarCliente(test);        
        assertEquals(1, mc.obtenerClientes().size());
        assertTrue(mc.obtenerClientes().contains(test));
    }
    
    @Test
    void borrarClienteUnSuccessfully(){
        ModeloClientes mc = new ModeloClientes();        
        Cliente test = new Cliente("Tipo del test","Dirección falsa","test@test","000111222");
        mc.agregarCliente(test);     
        assertEquals(1, mc.obtenerClientes().size());
        Exception exception = assertThrows(Exception.class, () -> {
            mc.eliminarCliente(null);
        });
        assertEquals("EL correo a eliminar no puede ser nulo ni vacío.", exception.getMessage());
        // After a failed deletion attempt the list should remain unchanged
        assertEquals(1, mc.obtenerClientes().size());
    }

    @Test
    void nuevoClienteUnSuccessfully(){
        ModeloClientes mc = new ModeloClientes();
        Cliente invalido = new Cliente("", "", null, "");
        Exception exception = assertThrows(Exception.class, () -> {
            mc.agregarCliente(invalido);
        });
        assertEquals("El cliente no puede ser nulo ni vacío.", exception.getMessage());
    }
    
}
