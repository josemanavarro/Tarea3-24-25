/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dam.di.enoteca.modelo;

import dam.di.enoteca.modelo.dto.Botella;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jose
 */
public class ModeloBotellas {
    private List<Botella> botellas;

    public ModeloBotellas() {
        this.botellas = new ArrayList<>();
    }

    public void agregarBotella(Botella botella) {
        botellas.add(botella);
    }

    public List<Botella> obtenerBotellas() {
        return botellas;
    }

    public List<Botella> buscarPorUva(String uva) {
        return botellas.stream()
                .filter(b -> b.getUva().equalsIgnoreCase(uva))
                .toList();
    }

    public boolean eliminarBotella(Botella botella) {
        return botellas.remove(botella);
    }
}
