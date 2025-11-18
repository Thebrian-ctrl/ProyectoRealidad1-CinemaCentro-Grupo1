/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelo.Funcion;
import Modelo.Lugar;
import Persistencia.DetalleTicketData;
import Persistencia.FuncionData;
import Persistencia.LugarData;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import java.util.List;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextField;


public class VistaDetalleTicket extends javax.swing.JInternalFrame {
    
 private DetalleTicketData detalleData;
    private FuncionData funcionData;
    private LugarData lugarData;
    
    private List<Funcion> funciones;
    private List<Lugar> lugares;
    
    private Funcion funcionSeleccionada;
    private Lugar lugarSeleccionado;

 
    public VistaDetalleTicket() {
        initComponents();
         inicializar();
         aplicarEstilos ();
         setClosable(true);
    setIconifiable(true);
    setMaximizable(true);
    setResizable(true);
    }
    private void aplicarEstilos() {
  
    Color colorPrimario = new Color(41, 128, 185);    
    Color colorSecundario = new Color(52, 73, 94);     
    Color colorExito = new Color(39, 174, 96);         
    Color colorPeligro = new Color(231, 76, 60);       
    Color colorAdvertencia = new Color(243, 156, 18);   
    Color colorInfo = new Color(52, 152, 219);          
    Color colorMorado = new Color(155, 89, 182);       
    
 
    jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 24));
    jLabel1.setForeground(colorPrimario);
    
  
    Font fuenteLabel = new Font("Segoe UI", Font.PLAIN, 14);
    jLabel2.setFont(fuenteLabel);
    jLabel3.setFont(fuenteLabel);
    jLabel4.setFont(fuenteLabel);
    jLabel5.setFont(fuenteLabel);
    jLabel6.setFont(fuenteLabel);
    jLabel7.setFont(fuenteLabel);
    
   
    configurarTextField(jTextField1, colorSecundario);
    configurarTextField(jTextFieldSubtotal, colorExito);
    

    configurarComboBox(jComboBoxFuncion, colorPrimario);
    configurarComboBox(jComboBoxLugar, colorInfo);
    
   
    jSpinnerCantidad.setFont(fuenteLabel);
    ((JSpinner.DefaultEditor) jSpinnerCantidad.getEditor()).getTextField().setBorder(
        BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(colorAdvertencia, 2),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        )
    );
    ((JSpinner.DefaultEditor) jSpinnerCantidad.getEditor()).getTextField().setFont(fuenteLabel);
    

    configurarBoton(jButtonNuevo, colorInfo, Color.WHITE);
    configurarBoton(jButtonGuardar, colorExito, Color.WHITE);
    configurarBoton(jButtonBuscar, colorPrimario, Color.WHITE);
    configurarBoton(jButtonActualizar, colorAdvertencia, Color.WHITE);
    configurarBoton(jButtonEliminar, colorPeligro, Color.WHITE);
    configurarBoton(jButtonSalir, colorSecundario, Color.WHITE);
    

    agregarEfectoHover(jButtonNuevo, colorInfo, new Color(41, 128, 185));
    agregarEfectoHover(jButtonGuardar, colorExito, new Color(46, 204, 113));
    agregarEfectoHover(jButtonBuscar, colorPrimario, new Color(52, 152, 219));
    agregarEfectoHover(jButtonActualizar, colorAdvertencia, new Color(211, 84, 0));
    agregarEfectoHover(jButtonEliminar, colorPeligro, new Color(192, 57, 43));
    agregarEfectoHover(jButtonSalir, colorSecundario, new Color(44, 62, 80));
}

private void configurarTextField(JTextField textField, Color colorBorde) {
    textField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
    textField.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(colorBorde, 2),
        BorderFactory.createEmptyBorder(5, 10, 5, 10)
    ));
}

private void configurarComboBox(JComboBox comboBox, Color colorBorde) {
    comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
    comboBox.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(colorBorde, 2),
        BorderFactory.createEmptyBorder(5, 10, 5, 10)
    ));
    comboBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
 private void inicializar() {
        detalleData = new DetalleTicketData();
        funcionData = new FuncionData();
        lugarData = new LugarData();
        
        SpinnerNumberModel nm = new SpinnerNumberModel();
        nm.setMaximum(10);
        nm.setMinimum(1);
        nm.setStepSize(1);
        nm.setValue(1);
        jSpinnerCantidad.setModel(nm);
        
        cargarFunciones();
         jComboBoxFuncion.addActionListener(e -> {
            if (jComboBoxFuncion.getSelectedIndex() >= 0) {
                cargarLugaresPorFuncion();
            }
        });
        
     
        jSpinnerCantidad.addChangeListener(e -> calcularSubtotal());
    }
    
  
    private void cargarFunciones() {
        jComboBoxFuncion.removeAllItems();
        funciones = funcionData.listarFuncion();
        
        for (Funcion f : funciones) {
            String texto = f.getPelicula().getTitulo() + " - " + 
                          f.getHoraInicio().toLocalDate() + " " + 
                          f.getHoraInicio().toLocalTime();
            jComboBoxFuncion.addItem(texto);
        }
    }
    
  
    private void cargarLugaresPorFuncion() {
        jComboBoxLugar.removeAllItems();
        
        int index = jComboBoxFuncion.getSelectedIndex();
        if (index < 0 || index >= funciones.size()) {
            return;
        }
        
        funcionSeleccionada = funciones.get(index);
        lugares = lugarData.buscarLugaresPorFuncion(funcionSeleccionada.getIdFuncion());
        
        for (Lugar l : lugares) {
            String texto = "Fila " + l.getFila() + " - Asiento " + l.getNum();
            jComboBoxLugar.addItem(texto);
        }
        
        calcularSubtotal();
    }
    
  
    private void calcularSubtotal() {
        if (funcionSeleccionada != null) {
            int cantidad = (Integer) jSpinnerCantidad.getValue();
            double precio = funcionSeleccionada.getPrecio();
            double subtotal = cantidad * precio;
            jTextFieldSubtotal.setText(String.format("%.2f", subtotal));
        }
    
        diseñodticket();
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
        jButtonSalir = new javax.swing.JButton();

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
        jButtonEliminar.setFocusTraversalPolicyProvider(true);
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

        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
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
                                        .addComponent(jComboBoxFuncion, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButtonActualizar)
                                .addGap(43, 43, 43)
                                .addComponent(jButtonGuardar)
                                .addGap(45, 45, 45)
                                .addComponent(jButtonEliminar)
                                .addGap(50, 50, 50)
                                .addComponent(jButtonSalir))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonBuscar)
                        .addGap(106, 106, 106)))
                .addGap(46, 46, 46))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jButtonNuevo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEliminar)
                    .addComponent(jButtonGuardar)
                    .addComponent(jButtonActualizar)
                    .addComponent(jButtonNuevo)
                    .addComponent(jButtonSalir))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButtonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevoActionPerformed
      limpiarCampos();
    jTextField1.setEnabled(false);
    cargarFunciones();
    JOptionPane.showMessageDialog(this,
        "Complete los campos para crear un nuevo detalle",
        "Nuevo Detalle",
        JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_jButtonNuevoActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        // TODO add your handling code here:
    try {
        if (jTextField1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un ID para buscar");
            return;
        }
        
        int id = Integer.parseInt(jTextField1.getText());
        
        Modelo.DetalleTicket detalle = detalleData.buscarDetalleTicket(id);
        
        if (detalle != null) {
        
            Modelo.Funcion funcion = funcionData.buscarFuncion(
                detalle.getFuncion().getIdFuncion()
            );
            
            if (funcion != null) {
               
                for (int i = 0; i < funciones.size(); i++) {
                    if (funciones.get(i).getIdFuncion() == funcion.getIdFuncion()) {
                        jComboBoxFuncion.setSelectedIndex(i);
                        break;
                    }
                }
            }
            
      
            Modelo.Lugar lugar = lugarData.buscarLugarPorId(
                detalle.getLugar().getIdLugar()
            );
            
            if (lugar != null) {
              
                for (int i = 0; i < lugares.size(); i++) {
                    if (lugares.get(i).getIdLugar() == lugar.getIdLugar()) {
                        jComboBoxLugar.setSelectedIndex(i);
                        break;
                    }
                }
            }
            
            jSpinnerCantidad.setValue(detalle.getCantidad());
            jTextFieldSubtotal.setText(String.format("%.2f", detalle.getSubtotal()));
            
            JOptionPane.showMessageDialog(this, 
                "Detalle ticket encontrado",
                "Éxito",
                JOptionPane.INFORMATION_MESSAGE);
            
        } else {
            JOptionPane.showMessageDialog(this, 
                "No se encontró ningún detalle con ese ID",
                "No encontrado",
                JOptionPane.WARNING_MESSAGE);
            limpiarCampos();
        }
        
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, 
            "El ID debe ser un número válido",
            "Error",
            JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, 
            "Error al buscar: " + e.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        // TODO add your handling code here:
        try {
       
        if (jComboBoxFuncion.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione una función");
            return;
        }
        
        if (jComboBoxLugar.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un lugar");
            return;
        }
        
        int cantidad = (Integer) jSpinnerCantidad.getValue();
        if (cantidad <= 0) {
            JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor a 0");
            return;
        }
        
     
        int indexFuncion = jComboBoxFuncion.getSelectedIndex();
        funcionSeleccionada = funciones.get(indexFuncion);
        
      
        int indexLugar = jComboBoxLugar.getSelectedIndex();
        lugarSeleccionado = lugares.get(indexLugar);
        
    
        if (!lugarSeleccionado.isEstado()) {
            JOptionPane.showMessageDialog(this, 
                "El lugar seleccionado ya está ocupado",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
       
        double subtotal = cantidad * funcionSeleccionada.getPrecio();
        
    
        Modelo.DetalleTicket detalle = new Modelo.DetalleTicket();
        detalle.setFuncion(funcionSeleccionada);
        detalle.setLugar(lugarSeleccionado);
        detalle.setCantidad(cantidad);
        detalle.setSubtotal(subtotal);
        
 
        detalleData.guardarDetalleTicket(detalle);
        
     
        lugarData.darBajaLugar(lugarSeleccionado.getIdLugar());
        
        limpiarCampos();
        cargarFunciones(); 
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, 
            "Error al guardar: " + e.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE);
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
        
     
        Modelo.DetalleTicket detalle = detalleData.buscarDetalleTicket(id);
        
        if (detalle == null) {
            JOptionPane.showMessageDialog(this, "No se encontró el detalle");
            return;
        }
        
      
        int nuevaCantidad = (Integer) jSpinnerCantidad.getValue();
        double nuevoSubtotal = Double.parseDouble(jTextFieldSubtotal.getText());
        
        detalle.setCantidad(nuevaCantidad);
        detalle.setSubtotal(nuevoSubtotal);
        
     
        detalleData.actualizarDetalleTicket(detalle);
        
        limpiarCampos();
        
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, 
            "Verifique que los campos numéricos sean válidos",
            "Error",
            JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, 
            "Error al actualizar: " + e.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_jButtonActualizarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
      
        
       try {
        if (jTextField1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un ID para eliminar");
            return;
        }
        
        int id = Integer.parseInt(jTextField1.getText());
        
    
        Modelo.DetalleTicket detalle = detalleData.buscarDetalleTicket(id);
        
        if (detalle == null) {
            JOptionPane.showMessageDialog(this, "No se encontró el detalle");
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this,
            "¿Está seguro de eliminar este detalle?\n" +
            "ADVERTENCIA: Esto liberará el lugar asociado.",
            "Confirmar Eliminación",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE);
        
        if (confirm == JOptionPane.YES_OPTION) {
       
            if (detalle.getLugar() != null) {
                lugarData.darAltaLugar(detalle.getLugar().getIdLugar());
            }
            
          
            detalleData.eliminarDetalleTicket(id);
            
            limpiarCampos();
            cargarFunciones(); 
        }
        
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "El ID debe ser numérico");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, 
            "Error al eliminar: " + e.getMessage());
    }

    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        // TODO add your handling code here:
         int confirm = JOptionPane.showConfirmDialog(this,
        "¿Está seguro que desea salir?",
        "Confirmar Salida",
        JOptionPane.YES_NO_OPTION);
    
    if (confirm == JOptionPane.YES_OPTION) {
        this.dispose(); 
    }
    }//GEN-LAST:event_jButtonSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonNuevo;
    private javax.swing.JButton jButtonSalir;
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
    jTextField1.setEnabled(true);
    jComboBoxFuncion.setSelectedIndex(-1);
    jComboBoxLugar.removeAllItems();
    jSpinnerCantidad.setValue(1);
    jTextFieldSubtotal.setText("");
    funcionSeleccionada = null;
    lugarSeleccionado = null;
    }

}
