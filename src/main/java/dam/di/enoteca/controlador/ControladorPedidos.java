/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dam.di.enoteca.controlador;

import dam.di.enoteca.modelo.ModeloPedidos;
import dam.di.enoteca.modelo.dto.Botella;
import dam.di.enoteca.modelo.dto.Cliente;
import dam.di.enoteca.modelo.dto.Pedido;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author jose
 */
public class ControladorPedidos {
    private ModeloPedidos modeloPedidos;

    public ControladorPedidos(ModeloPedidos modeloPedidos) {
        this.modeloPedidos = modeloPedidos;
    }

    public Pedido crearPedido(Cliente cliente, List<Botella> botellas) {
        Pedido pedido = new Pedido(0, cliente, LocalDate.now(), botellas);
        return modeloPedidos.agregarPedido(pedido);
    }

    public List<Pedido> listarPedidos() {
        return modeloPedidos.obtenerPedidos();
    }

    public Optional<Pedido> buscarPedidoPorId(int id) {
        return modeloPedidos.buscarPorId(id);
    }

    public boolean eliminarPedido(int id) {
        return modeloPedidos.eliminarPedido(id);
    }
}
