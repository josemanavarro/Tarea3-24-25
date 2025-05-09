/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package dam.di.enoteca;

import dam.di.enoteca.controlador.ControladorBotellas;
import dam.di.enoteca.controlador.ControladorClientes;
import dam.di.enoteca.controlador.ControladorPedidos;
import dam.di.enoteca.modelo.ModeloBotellas;
import dam.di.enoteca.modelo.ModeloClientes;
import dam.di.enoteca.modelo.ModeloPedidos;
import dam.di.enoteca.modelo.dto.Botella;
import dam.di.enoteca.modelo.dto.Cliente;
import dam.di.enoteca.vista.VistaPrincipalJFrame;
import java.util.List;

/**
 *
 * @author jose
 */
public class Enoteca {
    static private ModeloClientes modeloClientes;
    static private ControladorClientes controladorClientes;
    static private ModeloBotellas modeloBotellas;
    static private ControladorBotellas controladorBotellas;
    static private ModeloPedidos modeloPedidos;
    static private ControladorPedidos controladorPedidos;
    
    public static void main(String[] args) {
        //Iniciamos la lógica de negocio
        inicializarDatos();
        
        //Iniciamos la vista
        VistaPrincipalJFrame vpjf = new VistaPrincipalJFrame(controladorClientes,controladorBotellas,controladorPedidos);
        vpjf.setVisible(true);
    }
    
    private static void inicializarDatos() {
        // Iniciamos modelos y controladores:
        modeloClientes = new ModeloClientes();
        controladorClientes = new ControladorClientes(modeloClientes);
        
        modeloBotellas = new ModeloBotellas();
        controladorBotellas = new ControladorBotellas(modeloBotellas);
        
        modeloPedidos = new ModeloPedidos();
        controladorPedidos = new ControladorPedidos(modeloPedidos);
        
        //Cargamos datos de prueba
        controladorClientes.crearCliente("Laura Bodega", "Calle Uva nº10, Logroño", "laura@vino.es", "600123456");
        controladorClientes.crearCliente("Carlos Viñas", "Avda. del Rioja, 45", "carlos@vino.es", "666777888");

        controladorBotellas.crearBotella("Bodegas Viña Kalimotxo", "Crianza", "Tempranillo", 2019, 8.50);
        controladorBotellas.crearBotella("Bodegas Torres", "Reserva", "Cabernet Sauvignon", 2017, 14.90);
        
            Cliente laura = controladorClientes.buscarClientePorCorreo("laura@vino.es").orElse(null);
            Cliente carlos = controladorClientes.buscarClientePorCorreo("carlos@vino.es").orElse(null);

            List<Botella> botellas = controladorBotellas.listarBotellas();

            if (laura != null && botellas.size() >= 1) {
                controladorPedidos.crearPedido(laura, List.of(botellas.get(0))); // Laura pide una botella
            }

            if (carlos != null && botellas.size() >= 2) {
                controladorPedidos.crearPedido(carlos, List.of(botellas.get(0), botellas.get(1))); // Carlos pide dos botellas
            }
    }

}
