/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dam.di.enoteca.vista;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author jose
 */
public class VentanaAcercaDe extends JDialog {

    public VentanaAcercaDe(JFrame parent) {
        super(parent, "Acerca de", true);
        setSize(350, 200);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        JTextArea info = new JTextArea();        
        info.setText("Aplicación de Gestión de Enoteca\nVersión: 1.0\nAutor: 2º DAM\nAsignatura: Desarrollo de Interfaces\nTArea presencial 3ª evaluación");
        info.setEditable(false);
        info.setFont(new Font("Monospaced", Font.PLAIN, 14));
        info.setBackground(getBackground());

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> dispose());

        add(info, BorderLayout.CENTER);
        add(btnCerrar, BorderLayout.SOUTH);
    }
}
