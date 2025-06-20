/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package dam.di.enoteca.vista;

import dam.di.enoteca.controlador.ControladorClientes;
import dam.di.enoteca.modelo.dto.Cliente;
import java.awt.Frame;
import java.util.List;
import java.io.InputStream;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author jose
 */
public class JPanelClientes extends javax.swing.JPanel {

    private ControladorClientes controladorClientes;
    private DefaultTableModel modeloTabla;
    
    /**
     * Creates new form JPanelClientes
     */
    public JPanelClientes(ControladorClientes controladorClientes) {
        this.controladorClientes = controladorClientes;
        this.modeloTabla = new DefaultTableModel(new String[]{"Nombre", "Dirección", "Correo", "Teléfono"}, 0);
        initComponents();
        cargarClientes();
    }
    
    private void cargarClientes() {
        modeloTabla.setRowCount(0); // Limpia la tabla
        List<Cliente> lista = controladorClientes.listarClientes();
        for (Cliente c : lista) {
            Object[] fila = {
                c.getNombre(),
                c.getDireccion(),
                c.getCorreo(),
                c.getTelefono()
            };
            modeloTabla.addRow(fila);
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
        tablaClientes = new javax.swing.JTable();
        jButtonAnadirCliente = new javax.swing.JButton();
        jButtonImprimir = new javax.swing.JButton();
        jButtonBorrarCliente = new javax.swing.JButton();

        tablaClientes.setModel(this.modeloTabla);
        jScrollPane1.setViewportView(tablaClientes);

        jButtonAnadirCliente.setText("Añadir Cliente");
        jButtonAnadirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnadirClienteActionPerformed(evt);
            }
        });

        jButtonImprimir.setText("Imprimir listado");
        jButtonImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImprimirActionPerformed(evt);
            }
        });

        jButtonBorrarCliente.setText("Borrar Cliente");
        jButtonBorrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jButtonAnadirCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonImprimir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(jButtonBorrarCliente)
                .addGap(58, 58, 58))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAnadirCliente)
                    .addComponent(jButtonImprimir)
                    .addComponent(jButtonBorrarCliente))
                .addGap(0, 19, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAnadirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnadirClienteActionPerformed
        NuevoClienteJDialog dialogo = new NuevoClienteJDialog((Frame) SwingUtilities.getWindowAncestor(this),true);
        dialogo.setVisible(true);
        Cliente nuevo = dialogo.getClienteCreado();

        if (nuevo != null) {
            controladorClientes.crearCliente(
                    nuevo.getNombre(),
                    nuevo.getDireccion(),
                    nuevo.getCorreo(),
                    nuevo.getTelefono()
            );
            cargarClientes();
        }
    }//GEN-LAST:event_jButtonAnadirClienteActionPerformed

    private void jButtonBorrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarClienteActionPerformed
        int filaSeleccionada = tablaClientes.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un cliente para eliminar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Confirmación
        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Seguro que quieres eliminar al cliente seleccionado?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION
        );

        if (confirmacion != JOptionPane.YES_OPTION) {
            return;
        }

        // Obtener el correo de la fila seleccionada (asumimos que está en la columna 2)
        String correo = (String) modeloTabla.getValueAt(filaSeleccionada, 2);

        boolean eliminado = controladorClientes.eliminarClientePorCorreo(correo);

        if (eliminado) {
            modeloTabla.removeRow(filaSeleccionada);
            JOptionPane.showMessageDialog(this, "Cliente eliminado correctamente.");
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo eliminar el cliente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonBorrarClienteActionPerformed

    private void jButtonImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImprimirActionPerformed
        try {
            List<Cliente> datos = controladorClientes.listarClientes();
            JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(datos);
            InputStream is = getClass().getResourceAsStream("/clientes.jrxml");
            JasperReport reporte = JasperCompileManager.compileReport(is);
            JasperPrint print = JasperFillManager.fillReport(reporte, new HashMap<>(), ds);
            JasperExportManager.exportReportToPdfFile(print, "clientes.pdf");
            JOptionPane.showMessageDialog(this, "Informe generado en clientes.pdf");
        } catch (JRException e) {
            JOptionPane.showMessageDialog(this, "Error generando informe: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonImprimirActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnadirCliente;
    private javax.swing.JButton jButtonImprimir;
    private javax.swing.JButton jButtonBorrarCliente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaClientes;
    // End of variables declaration//GEN-END:variables
}
