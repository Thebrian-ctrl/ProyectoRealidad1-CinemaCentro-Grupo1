/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelo.Comprador;
import Modelo.TicketCompra;
import Persistencia.CompradorData;
import Persistencia.TicketCompraData;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.time.LocalDate;
import java.time.ZoneId;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class ModificarTicket extends javax.swing.JInternalFrame {

    private TicketCompraData ticketData;
    private CompradorData compradorData;
    private TicketCompra ticketActual;

    public ModificarTicket() {
        initComponents();
        aplicarEstilos();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        ticketData = new TicketCompraData();
        compradorData = new CompradorData();
        AreaInfo.setEditable(false);
    }

    private void aplicarEstilos() {
   
    Color colorPrimario = new Color(41, 128, 185);
    Color colorSecundario = new Color(52, 73, 94);
    Color colorExito = new Color(39, 174, 96);
    Color colorPeligro = new Color(231, 76, 60);
    Color colorAdvertencia = new Color(243, 156, 18);
    
  
    jPanel1.setBackground(Color.WHITE);
    jPanel1.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(colorPrimario, 2),
        BorderFactory.createEmptyBorder(20, 20, 20, 20)
    ));
    
   
    jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 24));
    jLabel1.setForeground(colorPrimario);
    
  
    Font fuenteLabel = new Font("Segoe UI", Font.PLAIN, 14);
    jtfIdTicket.setFont(fuenteLabel);
    jLabel3.setFont(fuenteLabel);
    jLabel4.setFont(fuenteLabel);
    jLabel5.setFont(fuenteLabel);
    
  
    configurarTextField(jTextField1, colorPrimario);
    configurarTextField(AreaInfo, colorSecundario);
    configurarTextField(jtfMonto, colorPrimario);
    
   
    jFecha.setFont(fuenteLabel);
    jFecha.setBorder(BorderFactory.createLineBorder(colorPrimario, 2));
    
   
    configurarBoton(jbBuscar, colorPrimario, Color.WHITE);
    configurarBoton(jbModificar, colorExito, Color.WHITE);
    configurarBoton(jbCancelar, colorPeligro, Color.WHITE);
    
  
    agregarEfectoHover(jbBuscar, colorPrimario, new Color(52, 152, 219));
    agregarEfectoHover(jbModificar, colorExito, new Color(46, 204, 113));
    agregarEfectoHover(jbCancelar, colorPeligro, new Color(192, 57, 43));
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

        AreaInfo.setEditable(false);
        AreaInfo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

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
                                .addGap(26, 26, 26)
                                .addComponent(jtfIdTicket)
                                .addGap(99, 99, 99)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73)
                                .addComponent(jbBuscar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(jLabel5)))
                                .addGap(47, 47, 47)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jtfMonto)
                                        .addComponent(jFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                                    .addComponent(AreaInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(274, 274, 274)
                        .addComponent(jbModificar)
                        .addGap(95, 95, 95)
                        .addComponent(jbCancelar)))
                .addContainerGap(175, Short.MAX_VALUE))
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
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AreaInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfMonto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(75, 75, 75)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbModificar)
                    .addComponent(jbCancelar))
                .addGap(81, 81, 81))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
      if (ticketActual == null) {
        JOptionPane.showMessageDialog(this,
                "Primero debe buscar un ticket usando el botón 'Buscar'",
                "Sin ticket seleccionado",
                JOptionPane.WARNING_MESSAGE);
        return;
    }
    

    if (jFecha.getDate() == null) {
        JOptionPane.showMessageDialog(this,
                "Por favor seleccione una nueva fecha para la función",
                "Fecha no seleccionada",
                JOptionPane.WARNING_MESSAGE);
        return;
    }
    
  
    if (jtfMonto.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this,
                "Por favor ingrese el nuevo monto",
                "Monto vacío",
                JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    try {
      
        double nuevoMonto = Double.parseDouble(jtfMonto.getText().trim());
        
    
        if (nuevoMonto <= 0) {
            JOptionPane.showMessageDialog(this,
                    "El monto debe ser mayor a cero",
                    "Monto inválido",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
  
        LocalDate nuevaFecha = jFecha.getDate().toInstant()
                .atZone(ZoneId.systemDefault()).toLocalDate();
        
       
        if (nuevaFecha.isBefore(LocalDate.now())) {
            int opcion = JOptionPane.showConfirmDialog(this,
                    "La fecha seleccionada es anterior a hoy.\n" +
                    "¿Está seguro de continuar?",
                    "Fecha en el pasado",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);
            
            if (opcion != JOptionPane.YES_OPTION) {
                return;
            }
        }
        
 
        StringBuilder resumen = new StringBuilder();
        resumen.append("Va a modificar el ticket #").append(ticketActual.getIdTicket()).append("\n\n");
        resumen.append("DATOS ACTUALES:\n");
        resumen.append("  Fecha Función: ").append(ticketActual.getFechaFuncion()).append("\n");
        resumen.append("  Monto: $").append(String.format("%.2f", ticketActual.getMonto())).append("\n\n");
        resumen.append("NUEVOS DATOS:\n");
        resumen.append("  Fecha Función: ").append(nuevaFecha).append("\n");
        resumen.append("  Monto: $").append(String.format("%.2f", nuevoMonto)).append("\n\n");
        resumen.append("¿Confirma la modificación?");
        
        int confirmacion = JOptionPane.showConfirmDialog(this,
                resumen.toString(),
                "Confirmar Modificación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        
        if (confirmacion != JOptionPane.YES_OPTION) {
            return;
        }
        
   
        ticketData.modificarTicket(
                ticketActual.getIdTicket(),
                nuevaFecha,
                nuevoMonto
        );
        
      
        JOptionPane.showMessageDialog(this,
                " Ticket modificado exitosamente!\n\n" +
                "Ticket #" + ticketActual.getIdTicket() + "\n" +
                "Nueva fecha: " + nuevaFecha + "\n" +
                "Nuevo monto: $" + String.format("%.2f", nuevoMonto),
                "Modificación Exitosa",
                JOptionPane.INFORMATION_MESSAGE);
        
      
        limpiar();
        
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this,
                "El monto ingresado no es válido.\n" +
                "Por favor ingrese solo números (ejemplo: 5000.00)",
                "Error de formato",
                JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
                " Error al modificar el ticket:\n" + e.getMessage() + "\n\n" +
                "Por favor, intente nuevamente o contacte al administrador.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
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
