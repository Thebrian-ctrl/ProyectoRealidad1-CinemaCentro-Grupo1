/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelo.*;
import Persistencia.*;
import javax.swing.JOptionPane;
import java.time.format.DateTimeFormatter;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author camila biarnes
 */
public class AnularTicket extends javax.swing.JInternalFrame {

    private TicketCompraData ticketData;
    private CompradorData compradorData;
    private LugarData lugarData;
    private DetalleTicketData detalleData;

    private TicketCompra ticketActual;
    private DateTimeFormatter formatter;

    public AnularTicket() {
        initComponents();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        inicializar();
        aplicarEstilos();
    }

    private void inicializar() {

        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        ticketData = new TicketCompraData();
        compradorData = new CompradorData();
        lugarData = new LugarData();
        detalleData = new DetalleTicketData();

        jtaInfoTicket.setEditable(false);
        jButtonAnular.setEnabled(false);

        limpiarCampos();

    }

    private void aplicarEstilos() {
        Color colorPrimario = new Color(41, 128, 185);
        Color colorPeligro = new Color(231, 76, 60);
        Color colorSecundario = new Color(149, 165, 166);

        jPanel1.setBackground(Color.WHITE);
        jPanel1.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(colorPrimario, 2),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 22));
        jLabel1.setForeground(colorPrimario);

        Font fuenteLabel = new Font("Segoe UI", Font.PLAIN, 14);
        jLabel2.setFont(fuenteLabel);
        jLabel3.setFont(new Font("Segoe UI", Font.BOLD, 16));
        jLabel4.setFont(fuenteLabel);

        jtfIdTicket.setFont(fuenteLabel);
        jtaInfoTicket.setFont(new Font("Consolas", Font.PLAIN, 12));
        jtaMotivo.setFont(fuenteLabel);

        configurarBoton(jButtonBuscar, colorPrimario);
        configurarBoton(jButtonAnular, colorPeligro);
        configurarBoton(jButtonLimpiar, colorSecundario);
        configurarBoton(jButtonSalir, new Color(52, 73, 94));
    }

    private void configurarBoton(JButton boton, Color colorFondo) {
        boton.setFont(new Font("Segoe UI", Font.BOLD, 13));
        boton.setBackground(colorFondo);
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setOpaque(true);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfIdTicket = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaInfoTicket = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaMotivo = new javax.swing.JTextField();
        jButtonAnular = new javax.swing.JButton();
        jButtonLimpiar = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ANULAR TICKET DE COMPRA");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("ID TICKET");

        jButtonBuscar.setText("BUSCAR");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("INFORMACION DEL TICKET");

        jScrollPane1.setViewportView(jtaInfoTicket);
        jtaInfoTicket.getAccessibleContext().setAccessibleName("");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("MOTIVO DE ANULACION");

        jScrollPane2.setViewportView(jtaMotivo);

        jButtonAnular.setText("ANULAR");
        jButtonAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnularActionPerformed(evt);
            }
        });

        jButtonLimpiar.setText("LIMPIAR");
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });

        jButtonSalir.setText("SALIR");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jtfIdTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(148, 148, 148)
                .addComponent(jButtonBuscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(220, 220, 220)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(212, 212, 212)
                                .addComponent(jLabel4)
                                .addGap(98, 98, 98))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(63, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAnular)
                .addGap(130, 130, 130)
                .addComponent(jButtonLimpiar)
                .addGap(146, 146, 146)
                .addComponent(jButtonSalir)
                .addGap(112, 112, 112))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfIdTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jButtonBuscar))
                .addGap(33, 33, 33)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalir)
                    .addComponent(jButtonLimpiar)
                    .addComponent(jButtonAnular))
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        try {
            if (jtfIdTicket.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Ingrese el ID del ticket a buscar",
                        "Campo vacío",
                        JOptionPane.WARNING_MESSAGE);
                jtfIdTicket.requestFocus();
                return;
            }

            int id;
            try {
                id = Integer.parseInt(jtfIdTicket.getText().trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this,
                        "El ID debe ser un número válido",
                        "ID inválido",
                        JOptionPane.ERROR_MESSAGE);
                jtfIdTicket.requestFocus();
                return;
            }

            if (id <= 0) {
                JOptionPane.showMessageDialog(this,
                        "El ID debe ser un número positivo",
                        "ID inválido",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            ticketActual = ticketData.buscarTickerporId(id);

            if (ticketActual == null) {
                JOptionPane.showMessageDialog(this,
                        "No se encontró ningún ticket con el ID: " + id,
                        "Ticket no encontrado",
                        JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
                return;
            }

            Comprador comp = null;
            if (ticketActual.getComprador() != null) {
                comp = compradorData.buscarComprador(
                        ticketActual.getComprador().getIdComprador()
                );
            }

            DetalleTicket detalle = null;
            if (ticketActual.getDetalleticket() != null) {
                detalle = detalleData.buscarDetalleTicket(
                        ticketActual.getDetalleticket().getIdDetalleTicket()
                );
            }

            StringBuilder info = new StringBuilder();
            info.append("       INFORMACIÓN DEL TICKET #").append(id).append("\n");
            info.append("═══════════════════════════════════════════════\n\n");

            info.append("📋 DATOS DEL TICKET:\n");
            info.append("   • ID Ticket: #").append(ticketActual.getIdTicket()).append("\n");

            if (ticketActual.getFechaCompra() != null) {
                info.append("   • Fecha Compra: ").append(ticketActual.getFechaCompra()).append("\n");
            }

            if (ticketActual.getFechaFuncion() != null && formatter != null) {
                info.append("   • Fecha Función: ").append(
                        ticketActual.getFechaFuncion().format(formatter)).append("\n");
            }

            info.append("   • Monto Total: $").append(
                    String.format("%.2f", ticketActual.getMonto())).append("\n\n");

            info.append(" COMPRADOR:\n");
            if (comp != null) {
                info.append("   • Nombre: ").append(comp.getNombre()).append("\n");
                info.append("   • DNI: ").append(comp.getDni()).append("\n");
                info.append("   • Medio de Pago: ").append(comp.getMedioDePago()).append("\n\n");
            } else {
                info.append("   • Información no disponible\n\n");
            }

            if (detalle != null && detalle.getFuncion() != null) {
                info.append(" FUNCIÓN:\n");

                if (detalle.getFuncion().getPelicula() != null) {
                    info.append("   • Película: ").append(
                            detalle.getFuncion().getPelicula().getTitulo()).append("\n");
                }

                if (detalle.getFuncion().getSalaProyeccion() != null) {
                    info.append("   • Sala: ").append(
                            detalle.getFuncion().getSalaProyeccion().getNroSala()).append("\n");
                }

                info.append("   • Formato: ").append(
                        detalle.getFuncion().isEs3d() ? "3D" : "2D").append("\n\n");

                if (detalle.getLugar() != null) {
                    info.append(" ASIENTO:\n");
                    info.append("   • Fila: ").append(detalle.getLugar().getFila()).append("\n");
                    info.append("   • Número: ").append(detalle.getLugar().getNum()).append("\n");
                }
            }

            info.append("═══════════════════════════════════════════════\n");

            jtaInfoTicket.setText(info.toString());
            jtaInfoTicket.setCaretPosition(0);
            jButtonAnular.setEnabled(true);

            JOptionPane.showMessageDialog(this,
                    "Ticket encontrado correctamente",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error al buscar el ticket:\n" + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnularActionPerformed
        try {
            if (ticketActual == null) {
                JOptionPane.showMessageDialog(this,
                        "Primero debe buscar un ticket",
                        "Búsqueda requerida",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            String motivo = jtaMotivo.getText().trim();

            if (motivo.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Debe ingresar un motivo para la anulación",
                        "Motivo requerido",
                        JOptionPane.WARNING_MESSAGE);
                jtaMotivo.requestFocus();
                return;
            }

            if (motivo.length() < 10) {
                JOptionPane.showMessageDialog(this,
                        "El motivo debe tener al menos 10 caracteres",
                        "Motivo muy corto",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            int confirmacion = JOptionPane.showConfirmDialog(this,
                    " ADVERTENCIA \n\n"
                    + "¿Está seguro de anular el Ticket #" + ticketActual.getIdTicket() + "?\n\n"
                    + "Esta acción:\n"
                    + "  • Liberará el/los asiento(s) asociado(s)\n"
                    + "  • Eliminará el registro de compra\n"
                    + "  • NO se puede deshacer\n\n"
                    + "Motivo: " + (motivo.length() > 50 ? motivo.substring(0, 50) + "..." : motivo),
                    "Confirmar Anulación",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);

            if (confirmacion != JOptionPane.YES_OPTION) {
                return;
            }

            if (ticketActual.getDetalleticket() != null) {
                DetalleTicket detalle = detalleData.buscarDetalleTicket(
                        ticketActual.getDetalleticket().getIdDetalleTicket()
                );

                if (detalle != null && detalle.getLugar() != null) {
                    lugarData.darAltaLugar(detalle.getLugar().getIdLugar());
                }
            }

            ticketData.anularTicket(ticketActual.getIdTicket());

            JOptionPane.showMessageDialog(this,
                    " TICKET ANULADO EXITOSAMENTE\n\n"
                    + "Ticket #" + ticketActual.getIdTicket() + "\n"
                    + "Monto: $" + String.format("%.2f", ticketActual.getMonto()) + "\n\n"
                    + "El asiento ha sido liberado para nuevas ventas.",
                    "Anulación Exitosa",
                    JOptionPane.INFORMATION_MESSAGE);

            limpiarCampos();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error al anular el ticket:\n" + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButtonAnularActionPerformed

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        int confirmacion = JOptionPane.showConfirmDialog(this,
                "¿Desea limpiar todos los campos?",
                "Confirmar Limpieza",
                JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            limpiarCampos();
            JOptionPane.showMessageDialog(this,
                    "Campos limpiados correctamente",
                    "Información",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        int confirmacion = JOptionPane.showConfirmDialog(this,
                "¿Está seguro que desea salir?",
                "Confirmar Salida",
                JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_jButtonSalirActionPerformed
    private void limpiarCampos() {
        jtfIdTicket.setText("");
        jtaInfoTicket.setText("Ingrese un ID de ticket y presione Buscar.");
        jtaMotivo.setText("");
        ticketActual = null;
        jButtonAnular.setEnabled(false);
        jtfIdTicket.requestFocus();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnular;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jtaInfoTicket;
    private javax.swing.JTextField jtaMotivo;
    private javax.swing.JTextField jtfIdTicket;
    // End of variables declaration//GEN-END:variables
}
