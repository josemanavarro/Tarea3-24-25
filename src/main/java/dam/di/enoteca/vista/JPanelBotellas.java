/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package dam.di.enoteca.vista;

import dam.di.enoteca.controlador.ControladorBotellas;
import dam.di.enoteca.modelo.dto.Botella;
import java.awt.Frame;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jose
 */
public class JPanelBotellas extends javax.swing.JPanel {
    
    private ControladorBotellas controlador;
    private DefaultTableModel modelo;
    
    /**
     * Creates new form JPanelBotellas
     * @param controlador
     */
    public JPanelBotellas(ControladorBotellas controlador) {
        this.controlador = controlador;
        String[] columnas = { "Bodega", "Tipo", "Uva", "Año", "Precio (€)" };
        modelo = new DefaultTableModel(columnas, 0);
        
        initComponents();
        cargarBotellas();
        
    }

    private void cargarBotellas() {
        modelo.setRowCount(0);
        List<Botella> lista = controlador.listarBotellas();
        for (Botella b : lista) {
            modelo.addRow(new Object[] {
                    b.getBodega(),
                    b.getTipo(),
                    b.getUva(),
                    b.getAño(),
                    b.getPrecio()
            });
        }
    }


    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBotellas = new javax.swing.JTable();
        jButtonAnadir = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();

        jTableBotellas.setModel(this.modelo);
        jScrollPane1.setViewportView(jTableBotellas);

        jButtonAnadir.setText("Añadir botella");
        jButtonAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnadirActionPerformed(evt);
            }
        });

        jButtonEliminar.setText("Eliminar botella");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonAnadir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonEliminar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAnadir)
                    .addComponent(jButtonEliminar))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnadirActionPerformed
        NuevaBotellaJDialog dialogo = new NuevaBotellaJDialog((Frame) SwingUtilities.getWindowAncestor(this),true);
        dialogo.setVisible(true);
        Botella nueva = dialogo.getBotellaCreada();

        if (nueva != null) {
            controlador.crearBotella(
                    nueva.getBodega(),
                    nueva.getTipo(),
                    nueva.getUva(),
                    nueva.getAño(),
                    nueva.getPrecio()
            );
            cargarBotellas();
        }
    }//GEN-LAST:event_jButtonAnadirActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
                    int fila = jTableBotellas.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(this, "Selecciona una botella para eliminar.");
                return;
            }

            int confirmar = JOptionPane.showConfirmDialog(
                    this,
                    "¿Seguro que quieres eliminar esta botella?",
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirmar != JOptionPane.YES_OPTION) return;

            String bodega = (String) modelo.getValueAt(fila, 0);
            String tipo = (String) modelo.getValueAt(fila, 1);
            String uva = (String) modelo.getValueAt(fila, 2);
            int año = Integer.parseInt(modelo.getValueAt(fila, 3).toString());
            double precio = Double.parseDouble(modelo.getValueAt(fila, 4).toString());

            // Creamos una instancia igual para eliminarla (se usa equals en la lista)
            Botella botella = new Botella(bodega, tipo, uva, año, precio);
            controlador.eliminarBotella(botella);
            cargarBotellas();
    }//GEN-LAST:event_jButtonEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnadir;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableBotellas;
    // End of variables declaration//GEN-END:variables
}
