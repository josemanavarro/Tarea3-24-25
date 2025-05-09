/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dam.di.enoteca.vista;

import dam.di.enoteca.controlador.ControladorPedidos;
import dam.di.enoteca.modelo.dto.Pedido;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jose
 */
public class JPanelPedidos extends JPanel {

    private ControladorPedidos controlador;
    private JTable tabla;
    private DefaultTableModel modelo;
    
    public JPanelPedidos(ControladorPedidos controladorPedidos) {
        this.controlador = controladorPedidos;
        initComponents();
        cargarPedidos();
    }
    
    private void initComponents() {
        setLayout(new BorderLayout());

        String[] columnas = { "ID", "Cliente", "Fecha", "Total (€)" };
        modelo = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);

        JPanel panelBotones = new JPanel();
        JButton btnNuevo = new JButton("Nuevo Pedido");

        panelBotones.add(btnNuevo);

        add(scroll, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        btnNuevo.addActionListener(e -> {
            cargarPedidos();
        });
    }

    private void cargarPedidos() {
        modelo.setRowCount(0);
        List<Pedido> pedidos = controlador.listarPedidos();

        for (Pedido p : pedidos) {
            modelo.addRow(new Object[] {
                    p.getId(),
                    p.getCliente().getNombre(),
                    p.getFecha(),
                    String.format("%.2f", p.calcularTotal())
            });
        }
    }
    
}
