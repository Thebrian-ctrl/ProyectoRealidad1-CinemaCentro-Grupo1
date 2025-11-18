/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import javax.swing.*;
import javax.swing.border.TitledBorder;


import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;


import java.util.*;
import java.util.List;
import java.util.ArrayList;


import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


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
  
  
    Color ROJO_CINE = new Color(220, 20, 60);        
    Color NEGRO_CINE = new Color(30, 30, 30);        
    Color DORADO_CINE = new Color(255, 215, 0);     
    Color VERDE_DISPONIBLE = new Color(34, 139, 34); 
    Color GRIS_OCUPADO = new Color(128, 128, 128);   
    Color BLANCO = Color.WHITE;
    
  
    jPanel1.setBackground(BLANCO);
    jPanel1.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(ROJO_CINE, 3),
        BorderFactory.createEmptyBorder(20, 20, 20, 20)
    ));
    
 
    jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 28));
    jLabel1.setForeground(ROJO_CINE);
    jLabel1.setText("COMPRA DE ENTRADAS");
    
   
    Font fuenteLabel = new Font("Segoe UI", Font.BOLD, 15);
    jLabelPelicula.setFont(fuenteLabel);
    jLabelPelicula.setForeground(NEGRO_CINE);
    jLabelPelicula.setText(" Seleccione Película:");
    
    jLabelFuncion.setFont(fuenteLabel);
    jLabelFuncion.setForeground(NEGRO_CINE);
    jLabelFuncion.setText("Seleccione Función:");
    
    jLabel2.setFont(new Font("Segoe UI", Font.BOLD, 18));
    jLabel2.setForeground(ROJO_CINE);
    jLabel2.setText(" INFORMACIÓN DE LA FUNCIÓN");
    
    jLabelCantEntradas.setFont(fuenteLabel);
    jLabelCantEntradas.setForeground(NEGRO_CINE);
    jLabelCantEntradas.setText(" Cantidad de Entradas:");
    
    jLabelSelecAsientos.setFont(fuenteLabel);
    jLabelSelecAsientos.setForeground(NEGRO_CINE);
    jLabelSelecAsientos.setText("Selección de Asientos:");
    
    jLabel3.setFont(new Font("Segoe UI", Font.ITALIC, 12));
    jLabel3.setForeground(new Color(100, 100, 100));
    jLabel3.setText(" Mantenga presionada CTRL para seleccionar múltiples asientos");
    
    
    jLabelPrecio.setFont(new Font("Segoe UI", Font.BOLD, 16));
    jLabelPrecio.setForeground(NEGRO_CINE);
    
    jLabelTotal.setFont(new Font("Segoe UI", Font.BOLD, 24));
    jLabelTotal.setForeground(ROJO_CINE);
    jLabelTotal.setText(" TOTAL: $0.00");
    
   
    Font fuenteCombo = new Font("Segoe UI", Font.PLAIN, 14);
    jComboBox1.setFont(fuenteCombo);
    jComboBox1.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(ROJO_CINE, 2),
        BorderFactory.createEmptyBorder(5, 10, 5, 10)
    ));
    
    jComboBox2.setFont(fuenteCombo);
    jComboBox2.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(ROJO_CINE, 2),
        BorderFactory.createEmptyBorder(5, 10, 5, 10)
    ));
    
   
    jList2.setFont(fuenteCombo);
    jList2.setSelectionBackground(DORADO_CINE);
    jList2.setSelectionForeground(NEGRO_CINE);
    jList2.setBorder(BorderFactory.createLineBorder(ROJO_CINE, 2));
    
   
    jSpinField1.setFont(fuenteCombo);
    
 
    configurarBoton(BtnComprar, VERDE_DISPONIBLE, BLANCO, new Font("Segoe UI", Font.BOLD, 15));
    BtnComprar.setText(" COMPRAR");
    
    configurarBoton(BtnCancelar, ROJO_CINE, BLANCO, new Font("Segoe UI", Font.BOLD, 15));
    BtnCancelar.setText(" CANCELAR");
    
    configurarBoton(BtnLimpiar, new Color(52, 152, 219), BLANCO, new Font("Segoe UI", Font.BOLD, 15));
    BtnLimpiar.setText(" LIMPIAR");
    
   configurarBoton(jButtonSalir, GRIS_OCUPADO, BLANCO, new Font("Segoe UI", Font.BOLD, 15));
jButtonSalir.setText(" FINALIZAR");
    
    
    agregarEfectoHover(BtnComprar, VERDE_DISPONIBLE, new Color(46, 204, 113));
    agregarEfectoHover(BtnCancelar, ROJO_CINE, new Color(255, 50, 90));
    agregarEfectoHover(BtnLimpiar, new Color(52, 152, 219), new Color(41, 128, 185));
    agregarEfectoHover(jButtonSalir, GRIS_OCUPADO, new Color(90, 90, 90));
   
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
        jLabelTotal = new javax.swing.JLabel();
        BtnCancelar = new javax.swing.JButton();
        BtnComprar = new javax.swing.JButton();
        BtnLimpiar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButtonSalir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jComboMedioPago = new javax.swing.JComboBox<>();
        jLabelPrecio = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("COMPRA DE ENTRADAS");

        jLabelPelicula.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelPelicula.setText("Seleccione Pelicula:");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabelFuncion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelFuncion.setText("Seleccione Funcion:");

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("INFORMACION DE LA FUNCION ");

        jLabelCantEntradas.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelCantEntradas.setText("Cantidad de Entradas");

        jLabelSelecAsientos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelSelecAsientos.setText("Seleccion de Asientos");

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

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Medio de pago:");

        jComboMedioPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione medio de pago", "Efectivo", "Tarjeta de Debito", "Tarjeta de Credito", "Mercado Pago" }));
        jComboMedioPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboMedioPagoActionPerformed(evt);
            }
        });

        jLabelPrecio.setText("PRECIO");

        jScrollPane1.setViewportView(jList2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(190, 190, 190)
                                .addComponent(BtnCancelar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(157, 157, 157)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelSelecAsientos)
                                    .addComponent(jLabelCantEntradas)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(149, 149, 149)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelPelicula)
                                            .addComponent(jLabelFuncion))
                                        .addGap(58, 58, 58))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(60, 60, 60)))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(BtnComprar)
                                .addGap(92, 92, 92)
                                .addComponent(BtnLimpiar)
                                .addGap(80, 80, 80)
                                .addComponent(jButtonSalir))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jComboMedioPago, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jComboBox1, 0, 268, Short.MAX_VALUE)
                                        .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel2)
                                    .addComponent(jSpinField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelTotal)
                                    .addComponent(jLabelPrecio))))))
                .addContainerGap(64, Short.MAX_VALUE))
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
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCantEntradas))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelSelecAsientos)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel3)
                        .addGap(45, 45, 45)
                        .addComponent(jLabelPrecio)))
                .addGap(6, 6, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboMedioPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(26, 26, 26)
                .addComponent(jLabelTotal)
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnCancelar)
                    .addComponent(BtnComprar)
                    .addComponent(BtnLimpiar)
                    .addComponent(jButtonSalir))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
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
   if (jComboMedioPago.getSelectedIndex() <= 0) {
    JOptionPane.showMessageDialog(this,
            "Por favor seleccione un medio de pago",
            "Medio de pago no seleccionado",
            JOptionPane.WARNING_MESSAGE);
    return;
}

String medioPago = jComboMedioPago.getSelectedItem().toString();


if (medioPago.equals("Tarjeta de Debito") || medioPago.equals("Tarjeta de Credito")) {
    double montoTotal = funcionSeleccionada.getPrecio() * lugaresSeleccionados.size();
    
    DialogoPagoTarjeta dialogo = new DialogoPagoTarjeta(null, medioPago, montoTotal);
    dialogo.setVisible(true);
    
  
    if (!dialogo.isPagoAceptado()) {
        JOptionPane.showMessageDialog(this,
                " Pago cancelado\n\nLa compra no se realizó.",
                "Pago Cancelado",
                JOptionPane.WARNING_MESSAGE);
        return; 
    }
    

    JOptionPane.showMessageDialog(this,
            " Pago procesado exitosamente\n\nProcesando su compra...",
            "Pago Exitoso",
            JOptionPane.INFORMATION_MESSAGE);
}


double subtotal = funcionSeleccionada.getPrecio() * lugaresSeleccionados.size();
int confirmacion = JOptionPane.showConfirmDialog(this,
        "¿Confirmar la compra?\n\n" +
        "Película: " + funcionSeleccionada.getPelicula().getTitulo() + "\n" +
        "Función: " + funcionSeleccionada.getHoraInicio() + "\n" +
        "Asientos: " + lugaresSeleccionados.size() + "\n" +
        "Medio de pago: " + medioPago + "\n" +
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
        resumen.append("Medio de pago: ").append(medioPago).append("\n\n");
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
            "¿Desea realizar otra compra?",
            "Nueva Compra",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
    
    if (confirmacion == JOptionPane.YES_OPTION) {
      
        limpiarFormulario();
        cargarPeliculas();
    } else {

        this.dispose();
    
    }
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jComboMedioPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboMedioPagoActionPerformed
        
    }//GEN-LAST:event_jComboMedioPagoActionPerformed

    
    private void limpiarFormulario() {
        jComboBox1.setSelectedIndex(-1);
        jComboBox2.removeAllItems();
        modeloLista.clear();
        jSpinField1.setValue(1);
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
    private javax.swing.JComboBox<String> jComboMedioPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelCantEntradas;
    private javax.swing.JLabel jLabelFuncion;
    private javax.swing.JLabel jLabelPelicula;
    private javax.swing.JLabel jLabelPrecio;
    private javax.swing.JLabel jLabelSelecAsientos;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
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
      agregarLeyendaColores();


}
private void agregarLeyendaColores() {
    JPanel panelLeyenda = new JPanel();
    panelLeyenda.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 15, 10));
    panelLeyenda.setBackground(Color.WHITE);
    panelLeyenda.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createLineBorder(new Color(220, 20, 60), 2),
        "Leyenda de Asientos",
        javax.swing.border.TitledBorder.CENTER,
        javax.swing.border.TitledBorder.DEFAULT_POSITION,
        new Font("Segoe UI", Font.BOLD, 14),
        new Color(220, 20, 60)
    ));
    
    
    JButton btnDisponible = new JButton("  Disponible  ");
    btnDisponible.setBackground(new Color(34, 139, 34));
    btnDisponible.setForeground(Color.WHITE);
    btnDisponible.setFont(new Font("Segoe UI", Font.BOLD, 12));
    btnDisponible.setEnabled(false);
    btnDisponible.setFocusPainted(false);
    

    JButton btnSeleccionado = new JButton("  ⭐ Seleccionado  ");
    btnSeleccionado.setBackground(new Color(255, 215, 0));
    btnSeleccionado.setForeground(Color.BLACK);
    btnSeleccionado.setFont(new Font("Segoe UI", Font.BOLD, 12));
    btnSeleccionado.setEnabled(false);
    btnSeleccionado.setFocusPainted(false);
    
  
    JButton btnOcupado = new JButton("   Ocupado  ");
    btnOcupado.setBackground(new Color(128, 128, 128));
    btnOcupado.setForeground(Color.WHITE);
    btnOcupado.setFont(new Font("Segoe UI", Font.BOLD, 12));
    btnOcupado.setEnabled(false);
    btnOcupado.setFocusPainted(false);
    
    panelLeyenda.add(btnDisponible);
    panelLeyenda.add(btnSeleccionado);
    panelLeyenda.add(btnOcupado);
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

