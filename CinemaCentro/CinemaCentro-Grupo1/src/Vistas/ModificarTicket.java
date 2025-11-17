/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelo.*;
import Persistencia.*;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.ZoneId;

/**
 *
 * @author camila biarnes
 */
public class ModificarTicket extends javax.swing.JInternalFrame {

    private TicketCompraData ticketData;
    private CompradorData compradorData;
    private TicketCompra ticketActual;

    public ModificarTicket() {
        initComponents();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        ticketData = new TicketCompraData();
        compradorData = new CompradorData();
        AreaInfo.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfIdTicket = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        AreaInfo = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jtfMonto = new javax.swing.JTextField();
        jFecha = new com.toedter.calendar.JDateChooser();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("MODIFICAR TICKET");

        jtfIdTicket.setText("ID TICKET");

        jLabel3.setText("INFORMACION ACTUAL");

        jLabel4.setText("NUEVA FECHA FUNCION");

        jLabel5.setText("NUEVO MONTO");

        jbBuscar.setText("BUSCAR");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jbModificar.setText("MODIFICAR");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jbCancelar.setText("CANCELAR");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(jtfIdTicket)
                                        .addGap(99, 99, 99)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(73, 73, 73))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jbModificar)
                                        .addGap(84, 84, 84)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbCancelar)
                                    .addComponent(jbBuscar)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(50, 50, 50))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addGap(74, 74, 74)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(47, 47, 47)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jtfMonto)
                                    .addComponent(AreaInfo)
                                    .addComponent(jFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))))))
                .addContainerGap(186, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfIdTicket)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(AreaInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtfMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCancelar)
                    .addComponent(jbModificar))
                .addGap(172, 172, 172))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
         try {
            if (jTextField1.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese un ID de ticket");
                return;
            }

            int id = Integer.parseInt(jTextField1.getText());
            ticketActual = ticketData.buscarTickerporId(id);

            if (ticketActual == null) {
                JOptionPane.showMessageDialog(this, "No se encontró el ticket");
                return;
            }

            Comprador comp = compradorData.buscarCompradorPorId(
                    ticketActual.getComprador().getIdComprador()
            );

            StringBuilder info = new StringBuilder();

            info.append("  INFORMACIÓN DEL TICKET\n");
            info.append("ID: #").append(ticketActual.getIdTicket()).append("\n");
            info.append("Comprador: ").append(comp != null ? comp.getNombre() : "N/A").append("\n");
            info.append("Fecha Compra: ").append(ticketActual.getFechaCompra()).append("\n");
            info.append("Fecha Función: ").append(ticketActual.getFechaFuncion()).append("\n");
            info.append("Monto: $").append(String.format("%.2f", ticketActual.getMonto())).append("\n");

            AreaInfo.setText(info.toString());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID inválido");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
     try {
            if (ticketActual == null) {
                JOptionPane.showMessageDialog(this, "Primero busque un ticket");
                return;
            }

            if (jFecha.getDate() == null || jtfMonto.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Complete todos los campos");
                return;
            }

            LocalDate nuevaFecha = jFecha.getDate().toInstant()
                    .atZone(ZoneId.systemDefault()).toLocalDate();
            double nuevoMonto = Double.parseDouble(jtfMonto.getText());

            int confirm = JOptionPane.showConfirmDialog(this,
                    "¿Confirma la modificación del ticket?",
                    "Confirmar",
                    JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                ticketData.modificarTicket(
                        ticketActual.getIdTicket(),
                        nuevaFecha,
                        nuevoMonto
                );

                limpiar();
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Monto inválido");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }

    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        this.dispose();

    }//GEN-LAST:event_jbCancelarActionPerformed

    private void limpiar() {
        jtfIdTicket.setText("");
        AreaInfo.setText("");
        jFecha.setDate(null);
        jtfMonto.setText("");
        ticketActual = null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AreaInfo;
    private com.toedter.calendar.JDateChooser jFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JLabel jtfIdTicket;
    private javax.swing.JTextField jtfMonto;
    // End of variables declaration//GEN-END:variables
}
