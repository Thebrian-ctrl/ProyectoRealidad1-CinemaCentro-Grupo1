/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import javax.swing.*;
import java.util.*;
import javax.swing.DefaultListModel;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.BorderFactory;
import javax.swing.JButton;


import Modelo.Comprador;
import Modelo.Pelicula;
import Modelo.Funcion;
import Modelo.Lugar;
import Modelo.Sala;
import Modelo.DetalleTicket; 
import Modelo.TicketCompra;   

import Persistencia.PeliculaData;
import Persistencia.FuncionData;
import Persistencia.LugarData;
import Persistencia.CompradorData;
import Persistencia.TicketCompraData;
import Persistencia.DetalleTicketData;
/**
 *
 * @author camila biarnes
 */



public class CompraTicket extends javax.swing.JInternalFrame {
    
    private PeliculaData peliculaData;
    private FuncionData funcionData;
    private LugarData lugarData;
    private CompradorData compradorData;
    private TicketCompraData ticketData;
    private DetalleTicketData detalleData;
    
    private List<Pelicula> peliculas;
    private List<Funcion> funciones;
    private Funcion funcionSeleccionada;
    private List<Lugar> lugaresSeleccionados;
    
    private DefaultListModel<String> modeloLista;
    
    private Comprador compradorActual;

   
   
    public CompraTicket(Comprador comprador) {
        initComponents();
        this.compradorActual = comprador;
        inicializar();
        aplicarEstilos();
    
        
    
}
private void aplicarEstilos() {
  
    Color colorPrimario = new Color(41, 128, 185);      
    Color colorSecundario = new Color(52, 73, 94);      
    Color colorExito = new Color(39, 174, 96);         
    Color colorPeligro = new Color(231, 76, 60);        
    Color colorFondo = new Color(236, 240, 241);        
    
 
    jPanel1.setBackground(Color.WHITE);
    jPanel1.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(colorPrimario, 2),
        BorderFactory.createEmptyBorder(20, 20, 20, 20)
    ));
    
  
    jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 24));
    jLabel1.setForeground(colorPrimario);
    
   
    Font fuenteLabel = new Font("Segoe UI", Font.PLAIN, 14);
    jLabelPelicula.setFont(fuenteLabel);
    jLabelFuncion.setFont(fuenteLabel);
    jLabel2.setFont(new Font("Segoe UI", Font.BOLD, 16));
    jLabel2.setForeground(colorSecundario);
    jLabelCantEntradas.setFont(fuenteLabel);
    jLabelSelecAsientos.setFont(fuenteLabel);
    
  
    jLabelPrecio.setFont(new Font("Segoe UI", Font.BOLD, 16));
    jLabelPrecio.setForeground(colorPrimario);
    
    jLabelTotal.setFont(new Font("Segoe UI", Font.BOLD, 20));
    jLabelTotal.setForeground(colorExito);
    

    jComboBox1.setFont(fuenteLabel);
    jComboBox1.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(colorPrimario, 1),
        BorderFactory.createEmptyBorder(5, 10, 5, 10)
    ));
    
    jComboBox2.setFont(fuenteLabel);
    jComboBox2.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(colorPrimario, 1),
        BorderFactory.createEmptyBorder(5, 10, 5, 10)
    ));
    

    jList2.setFont(fuenteLabel);
    jList2.setSelectionBackground(colorPrimario);
    jList2.setSelectionForeground(Color.WHITE);
    jList2.setBorder(BorderFactory.createLineBorder(colorPrimario, 1));
    
  
    jSpinField1.setFont(fuenteLabel);
    
  
    configurarBoton(BtnComprar, colorExito, Color.WHITE, new Font("Segoe UI", Font.BOLD, 14));
    configurarBoton(BtnCancelar, colorPeligro, Color.WHITE, new Font("Segoe UI", Font.BOLD, 14));
    configurarBoton(BtnLimpiar, colorSecundario, Color.WHITE, new Font("Segoe UI", Font.BOLD, 14));
    
    Color colorSalir = new Color(52, 73, 94); 
    configurarBoton(jButtonSalir, colorSalir, Color.WHITE, new Font("Segoe UI", Font.BOLD, 14));
    agregarEfectoHover(jButtonSalir, colorSalir, new Color(44, 62, 80));
    

    agregarEfectoHover(BtnComprar, colorExito, new Color(46, 204, 113));
    agregarEfectoHover(BtnCancelar, colorPeligro, new Color(192, 57, 43));
    agregarEfectoHover(BtnLimpiar, colorSecundario, new Color(44, 62, 80));
}

private void configurarBoton(JButton boton, Color colorFondo, Color colorTexto, Font fuente) {
    boton.setFont(fuente);
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
private void cargarPeliculas() {
    jComboBox1.removeAllItems();
    peliculas = peliculaData.listarPeliculasCartelera();
    
    for (Pelicula p : peliculas) {
        jComboBox1.addItem(p.getTitulo());
    }
}
   
     private void inicializar() {
         
  peliculaData = new PeliculaData();
    funcionData = new FuncionData();
    lugarData = new LugarData();
    compradorData = new CompradorData();
    ticketData = new TicketCompraData();
    detalleData = new DetalleTicketData();
    
    lugaresSeleccionados = new ArrayList<>();
    modeloLista = new DefaultListModel<>();
    jList2.setModel(modeloLista);
    
    jSpinField1.setMinimum(1);
    jSpinField1.setMaximum(10);
    jSpinField1.setValue(1);
    
    cargarPeliculas();
    
 
    jComboBox1.addActionListener(e -> cargarFunciones());
    jComboBox2.addActionListener(e -> cargarLugares());
    jList2.addListSelectionListener(e -> {
        if (!e.getValueIsAdjusting()) {
            seleccionarLugares();
        }
    });
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelPelicula = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabelFuncion = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabelCantEntradas = new javax.swing.JLabel();
        jLabelSelecAsientos = new javax.swing.JLabel();
        jSpinField1 = new com.toedter.components.JSpinField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jLabelPrecio = new javax.swing.JLabel();
        jLabelTotal = new javax.swing.JLabel();
        BtnCancelar = new javax.swing.JButton();
        BtnComprar = new javax.swing.JButton();
        BtnLimpiar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButtonSalir = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("COMPRA DE ENTRADAS");

        jLabelPelicula.setText("Seleccione Pelicula:");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabelFuncion.setText("Seleccione Funcion:");

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel2.setText("INFORMACION DE LA FUNCION ");

        jLabelCantEntradas.setText("Cantidad de Entradas");

        jLabelSelecAsientos.setText("Seleccion de Asientos");

        jScrollPane3.setViewportView(jList2);

        jLabelPrecio.setText("Precio por entrada: $10.000");

        jLabelTotal.setText("TOTAL: ");

        BtnCancelar.setText("Cancelar");
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });

        BtnComprar.setText("Comprar");
        BtnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnComprarActionPerformed(evt);
            }
        });

        BtnLimpiar.setText("Limpiar");
        BtnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimpiarActionPerformed(evt);
            }
        });

        jLabel3.setText(" Mantenga presionada CTRL para seleccionar múltiples asientos\"");

        jButtonSalir.setText("Salir");
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelPelicula)
                            .addComponent(jLabelFuncion)
                            .addComponent(jLabel2)
                            .addComponent(jLabelCantEntradas)
                            .addComponent(jLabelSelecAsientos)
                            .addComponent(jLabelPrecio)
                            .addComponent(jLabelTotal)
                            .addComponent(BtnCancelar))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(BtnComprar)
                                .addGap(87, 87, 87)
                                .addComponent(BtnLimpiar)
                                .addGap(76, 76, 76)
                                .addComponent(jButtonSalir))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox1, 0, 194, Short.MAX_VALUE)
                                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jSpinField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPelicula)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFuncion)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelCantEntradas))
                    .addComponent(jSpinField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelSelecAsientos)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41)
                .addComponent(jLabelPrecio)
                .addGap(18, 18, 18)
                .addComponent(jLabelTotal)
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnCancelar)
                    .addComponent(BtnComprar)
                    .addComponent(BtnLimpiar)
                    .addComponent(jButtonSalir))
                .addContainerGap(98, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
   int opcion = JOptionPane.showConfirmDialog(
        this, 
        "¿Está seguro que desea cancelar la compra?", 
        "Confirmar Cancelación", 
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE
    );
    
    if (opcion == JOptionPane.YES_OPTION) {
        limpiarFormulario();
        this.dispose(); 
    }
    }//GEN-LAST:event_BtnCancelarActionPerformed

   
    
    private void BtnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnComprarActionPerformed

 if (compradorActual == null) {
        JOptionPane.showMessageDialog(this,
                "Debe iniciar sesión para realizar una compra.\n" +
                "Por favor, regístrese o inicie sesión primero.",
                "Sin Comprador",
                JOptionPane.WARNING_MESSAGE);
        return;
    }
    
   
    if (jComboBox1.getSelectedIndex() < 0) {
        JOptionPane.showMessageDialog(this,
                "Por favor seleccione una película",
                "Película no seleccionada",
                JOptionPane.WARNING_MESSAGE);
        return;
    }
    
 
    if (jComboBox2.getSelectedIndex() < 0 || funcionSeleccionada == null) {
        JOptionPane.showMessageDialog(this,
                "Por favor seleccione una función",
                "Función no seleccionada",
                JOptionPane.WARNING_MESSAGE);
        return;
    }
    
  
    if (lugaresSeleccionados.isEmpty()) {
        JOptionPane.showMessageDialog(this,
                "Por favor seleccione al menos un asiento",
                "Sin asientos seleccionados",
                JOptionPane.WARNING_MESSAGE);
        return;
    }
    

    int cantidadSpin = jSpinField1.getValue();
    if (lugaresSeleccionados.size() != cantidadSpin) {
        JOptionPane.showMessageDialog(this,
                "Debe seleccionar exactamente " + cantidadSpin + " asiento(s).\n" +
                "Actualmente tiene " + lugaresSeleccionados.size() + " seleccionado(s).",
                "Cantidad incorrecta",
                JOptionPane.WARNING_MESSAGE);
        return;
    }
    
  
    double subtotal = funcionSeleccionada.getPrecio() * lugaresSeleccionados.size();
    int confirmacion = JOptionPane.showConfirmDialog(this,
            "¿Confirmar la compra?\n\n" +
            "Película: " + funcionSeleccionada.getPelicula().getTitulo() + "\n" +
            "Función: " + funcionSeleccionada.getHoraInicio() + "\n" +
            "Asientos: " + lugaresSeleccionados.size() + "\n" +
            "Total: $" + String.format("%.2f", subtotal),
            "Confirmar Compra",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
    
    if (confirmacion != JOptionPane.YES_OPTION) {
        return;
    }
    
  
    try {
      
        DetalleTicket primerDetalle = null;
        
        for (Lugar lugar : lugaresSeleccionados) {
        
            DetalleTicket detalle = new DetalleTicket();
            detalle.setFuncion(funcionSeleccionada);
            detalle.setLugar(lugar);
            detalle.setCantidad(1); 
            detalle.setSubtotal(funcionSeleccionada.getPrecio());
            
        
            detalleData.guardarDetalleTicket(detalle);
            
          
            if (primerDetalle == null) {
                primerDetalle = detalle;
            }
            
           
            lugarData.actualizarEstadoLugar(lugar.getIdLugar(), false);
        }
        
       
        TicketCompra ticket = new TicketCompra();
        ticket.setFechaCompra(LocalDate.now());
        ticket.setFechaFuncion(funcionSeleccionada.getHoraInicio());
        ticket.setMonto(subtotal);
        ticket.setComprador(compradorActual);
        ticket.setDetalleticket(primerDetalle);
        
      
        ticketData.guardarTicketCompra(ticket);
        
      
        StringBuilder resumen = new StringBuilder();
        resumen.append("═══════════════════════════════\n");
        resumen.append("      COMPRA EXITOSA\n");
        resumen.append("═══════════════════════════════\n\n");
        resumen.append("Ticket #").append(ticket.getIdTicket()).append("\n\n");
        resumen.append("Comprador: ").append(compradorActual.getNombre()).append("\n");
        resumen.append("DNI: ").append(compradorActual.getDni()).append("\n\n");
        resumen.append("Película: ").append(funcionSeleccionada.getPelicula().getTitulo()).append("\n");
        resumen.append("Función: ").append(funcionSeleccionada.getHoraInicio()).append("\n");
        resumen.append("Sala: ").append(funcionSeleccionada.getSalaProyeccion().getNroSala()).append("\n");
        resumen.append("Tipo: ").append(funcionSeleccionada.isEs3d() ? "3D" : "2D").append("\n");
        resumen.append("Idioma: ").append(funcionSeleccionada.getIdioma()).append("\n\n");
        
        resumen.append("Asientos comprados:\n");
        for (Lugar l : lugaresSeleccionados) {
            resumen.append("  • Fila ").append(l.getFila())
                   .append(" - Asiento ").append(l.getNum()).append("\n");
        }
        
        resumen.append("\nCantidad: ").append(lugaresSeleccionados.size()).append(" entrada(s)\n");
        resumen.append("Precio unitario: $").append(String.format("%.2f", funcionSeleccionada.getPrecio())).append("\n");
        resumen.append("\n═══════════════════════════════\n");
        resumen.append("TOTAL PAGADO: $").append(String.format("%.2f", subtotal)).append("\n");
        resumen.append("═══════════════════════════════\n");
        
        JOptionPane.showMessageDialog(this, resumen.toString(), 
            "Compra Exitosa", JOptionPane.INFORMATION_MESSAGE);
        

        limpiarFormulario();
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, 
            " Error al procesar la compra: " + e.getMessage() + "\n\n" +
            "Por favor, intente nuevamente o contacte al administrador.",
            "Error en la Compra", 
            JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
    }//GEN-LAST:event_BtnComprarActionPerformed
    
    private void BtnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimpiarActionPerformed
        int opcion = JOptionPane.showConfirmDialog(
        this, 
        "¿Desea limpiar todos los campos?", 
        "Confirmar Limpieza", 
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE
    );
    
    if (opcion == JOptionPane.YES_OPTION) {
        limpiarFormulario();
        JOptionPane.showMessageDialog(this, 
            "Formulario limpiado correctamente", 
            "Información", 
            JOptionPane.INFORMATION_MESSAGE);
    }
                                     
    }//GEN-LAST:event_BtnLimpiarActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
     int confirmacion = JOptionPane.showConfirmDialog(this,
        "¿Está seguro que desea salir?\n\nSe perderán los datos no guardados.",
        "Confirmar Salida",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE);
    
    if (confirmacion == JOptionPane.YES_OPTION) {
      
        this.dispose();
    
    }
    }//GEN-LAST:event_jButtonSalirActionPerformed

    
    private void limpiarFormulario() {
        jComboBox1.setSelectedIndex(-1);
        jComboBox2.removeAllItems();
        modeloLista.clear();
        jSpinField1.setValue(1);
        jLabelPrecio.setText("Precio por entrada: $10.0000");
        jLabelTotal.setText("TOTAL: $0.00");
        lugaresSeleccionados.clear();
        funcionSeleccionada = null;
    }
  
    public void dispose() {
   
    System.out.println("=== CERRANDO COMPRA TICKET ===");
    
    try {
     
        if (jComboBox1 != null && jComboBox1.getActionListeners().length > 0) {
            for (java.awt.event.ActionListener al : jComboBox1.getActionListeners()) {
                jComboBox1.removeActionListener(al);
            }
        }
        
        if (jComboBox2 != null && jComboBox2.getActionListeners().length > 0) {
            for (java.awt.event.ActionListener al : jComboBox2.getActionListeners()) {
                jComboBox2.removeActionListener(al);
            }
        }
        
   
        if (modeloLista != null) {
            modeloLista.clear();
        }
        
        if (lugaresSeleccionados != null) {
            lugaresSeleccionados.clear();
        }
        
        funcionSeleccionada = null;
        
    } catch (Exception e) {
        System.out.println("Error al limpiar: " + e.getMessage());
    }
    
    System.out.println("=== COMPRA TICKET CERRADO ===");
    
  
    super.dispose();
}
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnComprar;
    private javax.swing.JButton BtnLimpiar;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelCantEntradas;
    private javax.swing.JLabel jLabelFuncion;
    private javax.swing.JLabel jLabelPelicula;
    private javax.swing.JLabel jLabelPrecio;
    private javax.swing.JLabel jLabelSelecAsientos;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private com.toedter.components.JSpinField jSpinField1;
    // End of variables declaration//GEN-END:variables

 private void cargarFunciones() {
     
    java.awt.event.ActionListener[] listeners = jComboBox2.getActionListeners();
    for (java.awt.event.ActionListener listener : listeners) {
        jComboBox2.removeActionListener(listener);
    }
    
  
    jComboBox2.removeAllItems();
    modeloLista.clear();
    funcionSeleccionada = null;
    
    if (jComboBox1.getSelectedIndex() < 0) {
        System.out.println("No hay película seleccionada");
        
     
        for (java.awt.event.ActionListener listener : listeners) {
            jComboBox2.addActionListener(listener);
        }
        return;
    }

    String tituloSeleccionado = (String) jComboBox1.getSelectedItem();
    
    System.out.println("=== CARGANDO FUNCIONES ===");
    System.out.println("Película seleccionada: " + tituloSeleccionado);
    
   
    funciones = funcionData.listarFuncion();
    
    System.out.println("Total de funciones en BD: " + funciones.size());
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    
    int funcionesEncontradas = 0;
    
    for (Funcion f : funciones) {
        if (f.getPelicula() != null && 
            f.getPelicula().getTitulo() != null &&
            f.getPelicula().getTitulo().equals(tituloSeleccionado)) {
            
            String formato3d = f.isEs3d() ? "3D" : "2D";
            String formatoSub = f.isSubtitulado() ? "SUB" : "DUB";
            String texto = f.getHoraInicio().format(formatter) + " - " + 
                          formato3d + " " + formatoSub + " - Sala " + 
                          f.getSalaProyeccion().getNroSala();
            
            jComboBox2.addItem(texto);
            funcionesEncontradas++;
            
            System.out.println("Función agregada: " + texto + " (ID: " + f.getIdFuncion() + ")");
        }
    }
    

    for (java.awt.event.ActionListener listener : listeners) {
        jComboBox2.addActionListener(listener);
    }
    
    System.out.println("Funciones encontradas para '" + tituloSeleccionado + "': " + funcionesEncontradas);
    
    if (funcionesEncontradas == 0) {
        JOptionPane.showMessageDialog(this,
            "No hay funciones disponibles para la película '" + tituloSeleccionado + "'",
            "Sin funciones",
            JOptionPane.WARNING_MESSAGE);
    }
    
    System.out.println("=== CARGA DE FUNCIONES COMPLETADA ===");
}

private void cargarLugares() {
 
    System.out.println("=== INICIANDO CARGA DE LUGARES ===");
    modeloLista.clear();
    
    
    if (jComboBox2.getSelectedIndex() < 0) {
        System.out.println("ERROR: No hay función seleccionada en el combo");
        funcionSeleccionada = null;
        jLabelPrecio.setText("Precio por entrada: $0.00");
        jLabelTotal.setText("TOTAL: $0.00");
        return;
    }
    
 
    if (jComboBox1.getSelectedIndex() < 0) {
        System.out.println("ERROR: No hay película seleccionada");
        funcionSeleccionada = null;
        return;
    }
    
    
    if (funciones == null || funciones.isEmpty()) {
        System.out.println("ERROR: Lista de funciones vacía");
        JOptionPane.showMessageDialog(this, 
            "No hay funciones disponibles. Por favor seleccione otra película.",
            "Sin funciones",
            JOptionPane.WARNING_MESSAGE);
        funcionSeleccionada = null;
        return;
    }
    
    int indiceFuncion = jComboBox2.getSelectedIndex();
    String tituloSeleccionado = (String) jComboBox1.getSelectedItem();
    
    System.out.println("Función seleccionada (índice): " + indiceFuncion);
    System.out.println("Película: " + tituloSeleccionado);
    
 
    int contador = 0;
    funcionSeleccionada = null;
    
    for (Funcion f : funciones) {
        if (f.getPelicula() != null && 
            f.getPelicula().getTitulo() != null &&
            f.getPelicula().getTitulo().equals(tituloSeleccionado)) {
            
            if (contador == indiceFuncion) {
                funcionSeleccionada = f;
                System.out.println("✅ Función encontrada - ID: " + f.getIdFuncion());
                break;
            }
            contador++;
        }
    }
    
   
    if (funcionSeleccionada == null) {
        System.out.println(" ERROR: No se encontró la función");
        JOptionPane.showMessageDialog(this, 
            "Error al cargar la función seleccionada.\n" +
            "Por favor intente nuevamente.",
            "Error",
            JOptionPane.ERROR_MESSAGE);
        return;
    }
    
 
    if (funcionSeleccionada.getIdFuncion() <= 0) {
        System.out.println(" ERROR: La función no tiene ID válido");
        JOptionPane.showMessageDialog(this, 
            "La función seleccionada no tiene un ID válido.",
            "Error",
            JOptionPane.ERROR_MESSAGE);
        funcionSeleccionada = null;
        return;
    }
    
    try {
      
        List<Lugar> lugaresDisponibles = lugarData.buscarLugaresPorFuncion(
            funcionSeleccionada.getIdFuncion()
        );
        
        System.out.println("Lugares disponibles encontrados: " + lugaresDisponibles.size());
        
     
        if (lugaresDisponibles.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                " NO HAY LUGARES DISPONIBLES\n\n" +
                "Todos los asientos están ocupados para esta función.\n" +
                "Por favor seleccione otro horario.",
                "Sin lugares disponibles",
                JOptionPane.WARNING_MESSAGE);
            jLabelPrecio.setText("Precio: $" + String.format("%.2f", funcionSeleccionada.getPrecio()));
            jLabelTotal.setText("TOTAL: $0.00 (SIN LUGARES)");
            return;
        }
        
      
        for (Lugar lugar : lugaresDisponibles) {
            String texto = "Fila " + lugar.getFila() + " - Asiento " + lugar.getNum();
            modeloLista.addElement(texto);
            System.out.println("Lugar agregado: " + texto);
        }

  
        jLabelPrecio.setText("Precio por entrada: $" + 
            String.format("%.2f", funcionSeleccionada.getPrecio()));
        
     
        actualizarTotal();
        
        System.out.println("=== CARGA COMPLETADA EXITOSAMENTE ===");
        
    } catch (Exception e) {
        System.out.println(" ERROR en carga de lugares: " + e.getMessage());
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, 
            "Error al cargar los lugares:\n" + e.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE);
        funcionSeleccionada = null;
    }
}

private void seleccionarLugares() {
    lugaresSeleccionados.clear();
    
    if (funcionSeleccionada == null) {
        return;
    }
    
    List<String> seleccionados = jList2.getSelectedValuesList();
    List<Lugar> lugaresDisponibles = lugarData.buscarLugaresPorFuncion(
        funcionSeleccionada.getIdFuncion()
    );
    
    for (String seleccion : seleccionados) {
  
        String[] partes = seleccion.split(" - ");
        char fila = partes[0].replace("Fila ", "").charAt(0);
        int num = Integer.parseInt(partes[1].replace("Asiento ", ""));
        
    
        for (Lugar lugar : lugaresDisponibles) {
            if (lugar.getFila() == fila && lugar.getNum() == num) {
                lugaresSeleccionados.add(lugar);
                break;
            }
        }
    }
    
    actualizarTotal();
}
    
    private void actualizarTotal() {
    if (funcionSeleccionada != null) {
        int cantidad = jSpinField1.getValue();
        double precio = funcionSeleccionada.getPrecio();
        double total = cantidad * precio;
        jLabelTotal.setText("TOTAL: $" + String.format("%.2f", total));
    }
}
}

