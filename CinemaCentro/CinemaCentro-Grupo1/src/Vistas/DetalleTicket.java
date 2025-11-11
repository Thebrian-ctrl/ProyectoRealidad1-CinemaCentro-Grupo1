/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelo.Funcion;
import Modelo.Lugar;
import Persistencia.DetalleTicketData;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import Persistencia.FuncionData;
import Persistencia.LugarData;
import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 *
 * @author Usuario
 */
public class DetalleTicket extends javax.swing.JInternalFrame {

 
    public DetalleTicket() {
        initComponents();

        SpinnerNumberModel nm = new SpinnerNumberModel();
        nm.setMaximum(10);
        nm.setMinimum(0);
        nm.setStepSize(1);
        jSpinnerCantidad.setModel(nm);
        diseñodticket();
    }

    DetalleTicket(Funcion funcionSeleccionada, Lugar lugarPrincipal, int cantidad, double subtotal) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
private void diseñodticket() {
  
    Color colorPrimario = new Color(52, 152, 219);     
    Color colorSecundario = new Color(149, 165, 166);   
    Color colorExito = new Color(46, 204, 113);        
    Color colorPeligro = new Color(231, 76, 60);        
    Color colorAdvertencia = new Color(241, 196, 15);  
    
  
    jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 22));
    jLabel1.setForeground(colorPrimario);

    jLabel2.setFont(new Font("Segoe UI", Font.BOLD, 18));
    jLabel2.setForeground(colorSecundario);
    
  
    Font fuenteLabel = new Font("Segoe UI", Font.PLAIN, 13);
    jLabel3.setFont(fuenteLabel);
    jLabel4.setFont(fuenteLabel);
    jLabel5.setFont(fuenteLabel);
    jLabel6.setFont(fuenteLabel);
    jLabel7.setFont(fuenteLabel);
    
  
    jTextField1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
    jTextField1.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(colorPrimario, 1),
        BorderFactory.createEmptyBorder(5, 10, 5, 10)
    ));
    

    jTextFieldSubtotal.setFont(new Font("Segoe UI", Font.BOLD, 14));
    jTextFieldSubtotal.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(colorExito, 2),
        BorderFactory.createEmptyBorder(5, 10, 5, 10)
    ));
    

    jComboBoxFuncion.setFont(fuenteLabel);
    jComboBoxFuncion.setBorder(BorderFactory.createLineBorder(colorPrimario, 1));
    
    jComboBoxLugar.setFont(fuenteLabel);
    jComboBoxLugar.setBorder(BorderFactory.createLineBorder(colorPrimario, 1));
    

    jSpinnerCantidad.setFont(fuenteLabel);
    

    configurarBotonDetalle(jButtonBuscar, colorPrimario, Color.WHITE);
    configurarBotonDetalle(jButtonNuevo, colorSecundario, Color.WHITE);
    configurarBotonDetalle(jButtonGuardar, colorExito, Color.WHITE);
    configurarBotonDetalle(jButtonActualizar, colorAdvertencia, Color.WHITE);
    configurarBotonDetalle(jButtonEliminar, colorPeligro, Color.WHITE);
    
 
    agregarEfectoHoverDetalle(jButtonBuscar, colorPrimario);
    agregarEfectoHoverDetalle(jButtonNuevo, colorSecundario);
    agregarEfectoHoverDetalle(jButtonGuardar, colorExito);
    agregarEfectoHoverDetalle(jButtonActualizar, colorAdvertencia);
    agregarEfectoHoverDetalle(jButtonEliminar, colorPeligro);
}

private void configurarBotonDetalle(JButton boton, Color colorFondo, Color colorTexto) {
    boton.setFont(new Font("Segoe UI", Font.BOLD, 12));
    boton.setBackground(colorFondo);
    boton.setForeground(colorTexto);
    boton.setFocusPainted(false);
    boton.setBorderPainted(false);
    boton.setOpaque(true);
    boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    boton.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(colorFondo.darker(), 1),
        BorderFactory.createEmptyBorder(8, 15, 8, 15)
    ));
}

private void agregarEfectoHoverDetalle(JButton boton, Color colorBase) {
    Color colorHover = colorBase.brighter();
    boton.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            boton.setBackground(colorHover);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            boton.setBackground(colorBase);
        }
    });
}
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxFuncion = new javax.swing.JComboBox<>();
        jComboBoxLugar = new javax.swing.JComboBox<>();
        jSpinnerCantidad = new javax.swing.JSpinner();
        jTextFieldSubtotal = new javax.swing.JTextField();
        jButtonEliminar = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();
        jButtonActualizar = new javax.swing.JButton();
        jButtonNuevo = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel1.setText("Gestion de Detalle Ticket");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel2.setText("Detalles:");

        jLabel3.setText("Buscar por id:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jLabel4.setText("Funcion:");

        jLabel5.setText("Lugar:");

        jLabel6.setText("Cantidad:");

        jLabel7.setText("Subtotal:");

        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jButtonActualizar.setText("Actualizar");
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });

        jButtonNuevo.setText("Nuevo");
        jButtonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(19, 19, 19))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSpinnerCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldSubtotal)
                        .addComponent(jComboBoxLugar, javax.swing.GroupLayout.Alignment.TRAILING, 0, 99, Short.MAX_VALUE)
                        .addComponent(jComboBoxFuncion, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(119, 119, 119))
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonNuevo)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonBuscar)
                        .addGap(54, 54, 54))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addComponent(jButtonActualizar)
                        .addGap(92, 92, 92)
                        .addComponent(jButtonGuardar)
                        .addGap(93, 93, 93)
                        .addComponent(jButtonEliminar)
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscar))
                .addGap(53, 53, 53)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxFuncion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxLugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEliminar)
                    .addComponent(jButtonGuardar)
                    .addComponent(jButtonActualizar)
                    .addComponent(jButtonNuevo))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButtonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevoActionPerformed


 limpiarCampos();
    jTextField1.setEnabled(false); 
    JOptionPane.showMessageDialog(this, 
        "Para crear un nuevo detalle de ticket, use la pantalla de Compra de Tickets");

    }//GEN-LAST:event_jButtonNuevoActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        // TODO add your handling code here:
    DetalleTicketData dticket = new DetalleTicketData();
    
    try {
       
        if (jTextField1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un ID para buscar el detalle ticket.");
            return;
        }
        
        int id = Integer.parseInt(jTextField1.getText());
        
        Modelo.DetalleTicket detalle = dticket.buscarDetalleTicket(id);
        
        if (detalle != null) {
        
            FuncionData funcionData = new FuncionData();
            Modelo.Funcion funcion = funcionData.buscarFuncion(detalle.getFuncion().getIdFuncion());
            
            if (funcion != null) {
                jComboBoxFuncion.removeAllItems();
                jComboBoxFuncion.addItem(funcion.getPelicula().getTitulo() + " - " + 
                    funcion.getHoraInicio());
            }
            
          
            LugarData lugarData = new LugarData();
            Modelo.Lugar lugar = lugarData.buscarLugarPorId(detalle.getLugar().getIdLugar());
            
            if (lugar != null) {
                jComboBoxLugar.removeAllItems();
                jComboBoxLugar.addItem("Fila " + lugar.getFila() + " - Asiento " + lugar.getNum());
            }
            
            jSpinnerCantidad.setValue(detalle.getCantidad());
            jTextFieldSubtotal.setText(String.valueOf(detalle.getSubtotal()));
            
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró ningún detalle de ticket con ese ID.");
            limpiarCampos();
        }
        
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "El campo ID debe contener solo números.");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al buscar el detalle de ticket: " + e.getMessage());
    }

    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        // TODO add your handling code here:
        try {
      
        if (jComboBoxFuncion.getSelectedIndex() < 0 || jComboBoxLugar.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar función y lugar");
            return;
        }
        
        if (jTextFieldSubtotal.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El subtotal no puede estar vacío");
            return;
        }
        
   
        JOptionPane.showMessageDialog(this, 
            "Para guardar un nuevo detalle, use la pantalla de Compra de Tickets.\n" +
            "Esta pantalla es principalmente para consultas y modificaciones.");
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al guardar: " + e.getMessage());
    }

        
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed
        // TODO add your handling code here:
        
         try {
        if (jTextField1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Primero busque un detalle por ID");
            return;
        }
        
        int id = Integer.parseInt(jTextField1.getText());
        
        if (jTextFieldSubtotal.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El subtotal no puede estar vacío");
            return;
        }
        
      
        DetalleTicketData dticket = new DetalleTicketData();
        Modelo.DetalleTicket detalle = dticket.buscarDetalleTicket(id);
        
        if (detalle != null) {
          
            detalle.setCantidad((Integer) jSpinnerCantidad.getValue());
            detalle.setSubtotal(Double.parseDouble(jTextFieldSubtotal.getText()));
            
          
            dticket.actualizarDetalleTicket(detalle);
            
            JOptionPane.showMessageDialog(this, "Detalle actualizado correctamente");
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró el detalle a actualizar");
        }
        
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Verifique que los campos numéricos sean válidos");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al actualizar: " + e.getMessage());
    }

    }//GEN-LAST:event_jButtonActualizarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        // TODO add your handling code here:
        
         try {
        if (jTextField1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un ID para eliminar");
            return;
        }
        
        int id = Integer.parseInt(jTextField1.getText());
        
        int confirmacion = JOptionPane.showConfirmDialog(this,
            "¿Está seguro de eliminar este detalle?\n" +
            "ADVERTENCIA: Esto puede afectar tickets de compra asociados.",
            "Confirmar eliminación",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE);
        
        if (confirmacion == JOptionPane.YES_OPTION) {
            DetalleTicketData dticket = new DetalleTicketData();
            dticket.eliminarDetalleTicket(id);
            limpiarCampos();
        }
        
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "El ID debe ser numérico");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al eliminar: " + e.getMessage());
    }

    }//GEN-LAST:event_jButtonEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonNuevo;
    private javax.swing.JComboBox<String> jComboBoxFuncion;
    private javax.swing.JComboBox<String> jComboBoxLugar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSpinner jSpinnerCantidad;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextFieldSubtotal;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        jTextField1.setText("");
        jComboBoxFuncion.setSelectedIndex(-1);
        jComboBoxLugar.setSelectedIndex(-1);
        jSpinnerCantidad.setValue(0);
        jTextFieldSubtotal.setText("");
    }

}
