/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dam.di.enoteca.controlador;

import dam.di.enoteca.modelo.ModeloBotellas;
import dam.di.enoteca.modelo.dto.Botella;
import java.util.List;

/**
 *
 * @author jose
 */
public class ControladorBotellas {
    private ModeloBotellas modeloBotellas;

    public ControladorBotellas(ModeloBotellas modeloBotellas) {
        this.modeloBotellas = modeloBotellas;
    }

    public void crearBotella(String bodega, String tipo, String uva, int año, double precio) {
        Botella botella = new Botella(bodega, tipo, uva, año, precio);
        modeloBotellas.agregarBotella(botella);
    }

    public List<Botella> listarBotellas() {
        return modeloBotellas.obtenerBotellas();
    }

    public List<Botella> buscarPorUva(String uva) {
        return modeloBotellas.buscarPorUva(uva);
    }

    public boolean eliminarBotella(Botella botella) {
        return modeloBotellas.eliminarBotella(botella);
    }
}