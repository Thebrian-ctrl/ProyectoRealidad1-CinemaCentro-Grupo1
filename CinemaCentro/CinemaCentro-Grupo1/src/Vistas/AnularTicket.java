/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;


import Modelo.Comprador;
import Modelo.DetalleTicket;
import Modelo.Lugar;
import Modelo.TicketCompra;
import Persistencia.CompradorData;
import Persistencia.DetalleTicketData;
import Persistencia.LugarData;
import Persistencia.TicketCompraData;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class AnularTicket extends javax.swing.JInternalFrame {
    
    

 private TicketCompraData ticketData;
private DetalleTicketData detalleData;
private LugarData lugarData;
private CompradorData compradorData;
private TicketCompra ticketActual;

    public AnularTicket() {
        initComponents();
    inicializar();
    aplicarEstilos();
}

private void inicializar() {
    ticketData = new TicketCompraData();
    detalleData = new DetalleTicketData();
    lugarData = new LugarData();
    compradorData = new CompradorData();
    
    setClosable(true);
    setIconifiable(true);
    setMaximizable(true);
    setResizable(true);
     aplicarEstilos();
    jtaInfoTicket.setEditable(false);
    jtaInfoTicket.setText("Ingrese un ID de ticket y presione 'Buscar'");

    }

   private void aplicarEstilos() {
   
    Color colorPrimario = new Color(41, 128, 185);
    Color colorSecundario = new Color(52, 73, 94);
    Color colorExito = new Color(39, 174, 96);
    Color colorPeligro = new Color(231, 76, 60);
    Color colorAdvertencia = new Color(243, 156, 18);
    
  
    jPanel1.setBackground(Color.WHITE);
    jPanel1.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(colorPeligro, 2),
        BorderFactory.createEmptyBorder(20, 20, 20, 20)
    ));
    
   
    jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 24));
    jLabel1.setForeground(colorPeligro);
    
   
    Font fuenteLabel = new Font("Segoe UI", Font.PLAIN, 14);
    jLabel2.setFont(fuenteLabel);
    jLabel3.setFont(fuenteLabel);
    jLabel4.setFont(fuenteLabel);
    
   
    configurarTextField(jtfIdTicket, colorPrimario);
    configurarTextField(jtaMotivo, colorAdvertencia);
    

    jtaInfoTicket.setFont(new Font("Consolas", Font.PLAIN, 12));
    jtaInfoTicket.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(colorSecundario, 1),
        BorderFactory.createEmptyBorder(10, 10, 10, 10)
    ));
    
 
    configurarBoton(jButtonBuscar, colorPrimario, Color.WHITE);
    configurarBoton(jButtonAnular, colorPeligro, Color.WHITE);
    configurarBoton(jButtonLimpiar, colorSecundario, Color.WHITE);
    configurarBoton(jButtonSalir, new Color(149, 165, 166), Color.WHITE);
    
 
    agregarEfectoHover(jButtonBuscar, colorPrimario, new Color(52, 152, 219));
    agregarEfectoHover(jButtonAnular, colorPeligro, new Color(192, 57, 43));
    agregarEfectoHover(jButtonLimpiar, colorSecundario, new Color(44, 62, 80));
    agregarEfectoHover(jButtonSalir, new Color(149, 165, 166), new Color(127, 140, 141));
}

private void configurarTextField(JTextField textField, Color colorBorde) {
    textField.setFont(new Font("Segoe UI", Font.PLAIN, 13));
    textField.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(colorBorde, 2),
        BorderFactory.createEmptyBorder(5, 10, 5, 10)
    ));
}

private void configurarBoton(JButton boton, Color colorFondo, Color colorTexto) {
    boton.setFont(new Font("Segoe UI", Font.BOLD, 13));
    boton.setBackground(colorFondo);
    boton.setForeground(colorTexto);
    boton.setFocusPainted(false);
    boton.setBorderPainted(false);
    boton.setOpaque(true);
    boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    boton.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(colorFondo.darker(), 1),
        BorderFactory.createEmptyBorder(10, 20, 10, 20)
    ));
}

private void agregarEfectoHover(JButton boton, Color colorNormal, Color colorHover) {
    boton.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            boton.setBackground(colorHover);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            boton.setBackground(colorNormal);
        }
    });
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
      if (jtfIdTicket.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this,
                "Por favor ingrese el ID del ticket",
                "Campo vacío",
                JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    try {
    
        int idTicket = Integer.parseInt(jtfIdTicket.getText().trim());
        
    
        ticketActual = ticketData.buscarTickerporId(idTicket);
        
   
        if (ticketActual == null) {
            JOptionPane.showMessageDialog(this,
                    "No se encontró ningún ticket con el ID " + idTicket,
                    "Ticket no encontrado",
                    JOptionPane.ERROR_MESSAGE);
            jtaInfoTicket.setText("No se encontró el ticket #" + idTicket);
            return;
        }
        
      
        Comprador comp = compradorData.buscarCompradorPorId(
                ticketActual.getComprador().getIdComprador());
        
    
        StringBuilder info = new StringBuilder();
        info.append("         INFORMACIÓN DEL TICKET\n");
        info.append("═══════════════════════════════════════════\n\n");
        info.append("Ticket #").append(ticketActual.getIdTicket()).append("\n\n");
        info.append("Comprador: ").append(comp != null ? comp.getNombre() : "N/A").append("\n");
        info.append("DNI: ").append(comp != null ? comp.getDni() : "N/A").append("\n\n");
        info.append("Fecha Compra: ").append(ticketActual.getFechaCompra()).append("\n");
        info.append("Fecha Función: ").append(ticketActual.getFechaFuncion()).append("\n");
        info.append("Monto: $").append(String.format("%.2f", ticketActual.getMonto())).append("\n\n");
        
    
        if (ticketActual.getDetalleticket() != null) {
            DetalleTicket detalle = detalleData.buscarDetalleTicket(
                    ticketActual.getDetalleticket().getIdDetalleTicket());
            
            if (detalle != null && detalle.getLugar() != null) {
                info.append("Asiento: Fila ").append(detalle.getLugar().getFila())
                    .append(" - Número ").append(detalle.getLugar().getNum()).append("\n");
            }
        }
        

        info.append("Presione 'Anular' para eliminar este ticket\n");
        info.append("═══════════════════════════════════════════");
        
        jtaInfoTicket.setText(info.toString());
        
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this,
                "El ID ingresado no es válido.\n" +
                "Por favor ingrese solo números.",
                "Error de formato",
                JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
                "Error al buscar el ticket: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnularActionPerformed
       if (ticketActual == null) {
        JOptionPane.showMessageDialog(this,
                "Primero debe buscar un ticket usando el botón 'Buscar'",
                "Sin ticket seleccionado",
                JOptionPane.WARNING_MESSAGE);
        return;
    }
    
 
    if (jtaMotivo.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this,
                "Por favor ingrese el motivo de la anulación",
                "Motivo vacío",
                JOptionPane.WARNING_MESSAGE);
        return;
    }
    
   
    if (jtaMotivo.getText().trim().length() < 10) {
        JOptionPane.showMessageDialog(this,
                "El motivo debe tener al menos 10 caracteres",
                "Motivo muy corto",
                JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    try {
     
        Comprador comp = compradorData.buscarCompradorPorId(
                ticketActual.getComprador().getIdComprador());
        
    
        StringBuilder confirmacion = new StringBuilder();
        confirmacion.append("Va a ANULAR el siguiente ticket:\n\n");
        confirmacion.append("Ticket #").append(ticketActual.getIdTicket()).append("\n");
        confirmacion.append("Comprador: ").append(comp != null ? comp.getNombre() : "N/A").append("\n");
        confirmacion.append("Fecha Función: ").append(ticketActual.getFechaFuncion()).append("\n");
        confirmacion.append("Monto: $").append(String.format("%.2f", ticketActual.getMonto())).append("\n");
        confirmacion.append("═══════════════════════════════════════════\n\n");
        confirmacion.append("Motivo: ").append(jtaMotivo.getText().trim()).append("\n\n");
        confirmacion.append("⚠️ ESTA ACCIÓN NO SE PUEDE DESHACER ⚠️\n\n");
        confirmacion.append("Los asientos serán liberados automáticamente.\n\n");
        confirmacion.append("¿Está seguro de anular este ticket?");
        
        int opcion = JOptionPane.showConfirmDialog(this,
                confirmacion.toString(),
                "Confirmar Anulación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
        
        if (opcion != JOptionPane.YES_OPTION) {
            return;
        }
        
     
        if (ticketActual.getDetalleticket() != null) {
            DetalleTicket detalle = detalleData.buscarDetalleTicket(
                    ticketActual.getDetalleticket().getIdDetalleTicket());
            
            if (detalle != null && detalle.getLugar() != null) {
           
                Lugar lugar = lugarData.buscarLugarPorId(detalle.getLugar().getIdLugar());
                if (lugar != null) {
                    lugar.setEstado(true);
                    lugarData.actualizarLugar(lugar);
                }
            }
        }
        
   
        ticketData.anularTicket(ticketActual.getIdTicket());
        
     
        JOptionPane.showMessageDialog(this,
                " Ticket anulado exitosamente!\n\n" +
                "Ticket #" + ticketActual.getIdTicket() + " ha sido eliminado.\n" +
                "Motivo: " + jtaMotivo.getText().trim() + "\n\n" +
                "Los asientos han sido liberados y están disponibles.",
                "Anulación Exitosa",
                JOptionPane.INFORMATION_MESSAGE);
        
    
        limpiarFormulario();
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
                "❌ Error al anular el ticket:\n" + e.getMessage() + "\n\n" +
                "Por favor, intente nuevamente o contacte al administrador.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }

    }//GEN-LAST:event_jButtonAnularActionPerformed

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        int opcion = JOptionPane.showConfirmDialog(this,
            "¿Desea limpiar todos los campos?",
            "Confirmar Limpieza",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
    
    if (opcion == JOptionPane.YES_OPTION) {
        limpiarFormulario();
        JOptionPane.showMessageDialog(this,
                "Formulario limpiado correctamente",
                "Información",
                JOptionPane.INFORMATION_MESSAGE);
    }
        
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
       int confirmacion = JOptionPane.showConfirmDialog(this,
            "¿Está seguro que desea salir?",
            "Confirmar Salida",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
    
    if (confirmacion == JOptionPane.YES_OPTION) {
        this.dispose();
    }//GEN-LAST:event_jButtonSalirActionPerformed
    }
    
    private void limpiarFormulario() {
    jtfIdTicket.setText("");
    jtaMotivo.setText("");
    jtaInfoTicket.setText("Ingrese un ID de ticket y presione 'Buscar'");
    ticketActual = null;
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
