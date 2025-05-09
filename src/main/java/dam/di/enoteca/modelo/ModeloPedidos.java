/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dam.di.enoteca.modelo;

import dam.di.enoteca.modelo.dto.Pedido;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author jose
 */
public class ModeloPedidos {

    private List<Pedido> pedidos;
    private int siguienteId;

    public ModeloPedidos() {
        this.pedidos = new ArrayList<>();
        this.siguienteId = 1;
    }

    public Pedido agregarPedido(Pedido pedido) {
        pedido.setId(siguienteId++);
        pedidos.add(pedido);
        return pedido;
    }

    public List<Pedido> obtenerPedidos() {
        return pedidos;
    }

    public Optional<Pedido> buscarPorId(int id) {
        return pedidos.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
    }

    public boolean eliminarPedido(int id) {
        return pedidos.removeIf(p -> p.getId() == id);
    }
}