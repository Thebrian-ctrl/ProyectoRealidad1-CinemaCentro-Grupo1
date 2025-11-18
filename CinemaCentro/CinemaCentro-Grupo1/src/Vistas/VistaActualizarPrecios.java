/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;
import Persistencia.FuncionData;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;


public class VistaActualizarPrecios extends javax.swing.JInternalFrame {

    private FuncionData funcionData;
    public VistaActualizarPrecios() {
        initComponents();
        
      inicializar();
      aplicarEstilos();
}

private void inicializar() {
    funcionData = new FuncionData();
    
    setClosable(true);
    setIconifiable(true);
    setMaximizable(true);
    setResizable(true);
    
    txtInfo.setEditable(false);
    txtInfo.setText("Ingrese los nuevos precios y presione el botón correspondiente.\n" +
                    "Los cambios se aplicarán inmediatamente a todas las funciones.");
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
    
  
    jLabel2.setFont(new Font("Segoe UI", Font.BOLD, 14));
    jLabel2.setForeground(colorSecundario);
    
  
    Font fuenteLabel = new Font("Segoe UI", Font.PLAIN, 14);
    jLabel3.setFont(fuenteLabel);
    jLabel4.setFont(fuenteLabel);
    jLabelInfo.setFont(new Font("Segoe UI", Font.ITALIC, 12));
    jLabelInfo.setForeground(colorAdvertencia);
    
 
    configurarTextField(txtPrecio2D, colorPrimario);
    configurarTextField(txtPrecio3D, colorPrimario);
    
   
    txtInfo.setFont(new Font("Consolas", Font.PLAIN, 12));
    txtInfo.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(colorPrimario, 1),
        BorderFactory.createEmptyBorder(10, 10, 10, 10)
    ));
    

    configurarBoton(btnActualizar2D, new Color(52, 152, 219), Color.WHITE);
    configurarBoton(btnActualizar3D, new Color(155, 89, 182), Color.WHITE);
    configurarBoton(btnActualizarAmbos, colorExito, Color.WHITE);
    configurarBoton(BtnCerrar, colorPeligro, Color.WHITE);
    
  
    agregarEfectoHover(btnActualizar2D, new Color(52, 152, 219), new Color(41, 128, 185));
    agregarEfectoHover(btnActualizar3D, new Color(155, 89, 182), new Color(142, 68, 173));
    agregarEfectoHover(btnActualizarAmbos, colorExito, new Color(46, 204, 113));
    agregarEfectoHover(BtnCerrar, colorPeligro, new Color(192, 57, 43));
}

private void configurarTextField(JTextField textField, Color colorBorde) {
    textField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
    textField.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(colorBorde, 2),
        BorderFactory.createEmptyBorder(5, 10, 5, 10)
    ));
}

private void configurarBoton(JButton boton, Color colorFondo, Color colorTexto) {
    boton.setFont(new Font("Segoe UI", Font.BOLD, 14));
    boton.setBackground(colorFondo);
    boton.setForeground(colorTexto);
    boton.setFocusPainted(false);
    boton.setBorderPainted(false);
    boton.setOpaque(true);
    boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    boton.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(colorFondo.darker(), 1),
        BorderFactory.createEmptyBorder(12, 25, 12, 25)
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelInfo = new javax.swing.JLabel();
        txtPrecio2D = new javax.swing.JTextField();
        txtPrecio3D = new javax.swing.JTextField();
        btnActualizar2D = new javax.swing.JButton();
        btnActualizar3D = new javax.swing.JButton();
        btnActualizarAmbos = new javax.swing.JButton();
        BtnCerrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtInfo = new javax.swing.JTextArea();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("ACTUALIZACION DE PRECIOS");
        jLabel1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Actualizar precios de funciones 2D y 3D");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Nuevo Precio 2D:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Nuevo Precio 3D:");

        jLabelInfo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabelInfo.setText("Los precios se aplicarán a TODAS las funciones");

        txtPrecio3D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecio3DActionPerformed(evt);
            }
        });

        btnActualizar2D.setText("ACTUALIZAR");
        btnActualizar2D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizar2DActionPerformed(evt);
            }
        });

        btnActualizar3D.setText("ACTUALIZAR");
        btnActualizar3D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizar3DActionPerformed(evt);
            }
        });

        btnActualizarAmbos.setText("ACTUALIZAR AMBOS");
        btnActualizarAmbos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarAmbosActionPerformed(evt);
            }
        });

        BtnCerrar.setText("CERRAR");
        BtnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCerrarActionPerformed(evt);
            }
        });

        txtInfo.setColumns(20);
        txtInfo.setRows(5);
        jScrollPane1.setViewportView(txtInfo);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPrecio3D, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addComponent(txtPrecio2D))
                        .addGap(75, 75, 75)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnActualizar2D)
                            .addComponent(btnActualizar3D))
                        .addGap(44, 44, 44)
                        .addComponent(btnActualizarAmbos))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jLabelInfo)))
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(BtnCerrar)
                        .addGap(74, 74, 74))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtPrecio2D, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnActualizar2D)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtPrecio3D, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizar3D)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btnActualizarAmbos)))
                .addGap(29, 29, 29)
                .addComponent(jLabelInfo)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(BtnCerrar)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPrecio3DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecio3DActionPerformed
      
    }//GEN-LAST:event_txtPrecio3DActionPerformed

    private void btnActualizar3DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizar3DActionPerformed
 try {
     
        if (txtPrecio3D.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Por favor ingrese un precio para funciones 3D",
                    "Campo vacío",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        
    
        double nuevoPrecio = Double.parseDouble(txtPrecio3D.getText().trim());
        
      
        if (nuevoPrecio <= 0) {
            JOptionPane.showMessageDialog(this,
                    "El precio debe ser mayor a cero",
                    "Precio inválido",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
      
        int confirmacion = JOptionPane.showConfirmDialog(this,
                "¿Está seguro de actualizar el precio de TODAS las funciones 3D a $" + 
                String.format("%.2f", nuevoPrecio) + "?",
                "Confirmar Actualización",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        
        if (confirmacion == JOptionPane.YES_OPTION) {
     
            funcionData.actualizarPrecio3D(nuevoPrecio);
            
        
            txtInfo.setText(" Precios 3D actualizados exitosamente!\n" +
                           "Nuevo precio: $" + String.format("%.2f", nuevoPrecio) + "\n" +
                           "Todos las funciones 3D ahora tienen este precio.");
            
     
            txtPrecio3D.setText("");
        }
        
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this,
                "Por favor ingrese un número válido",
                "Error de formato",
                JOptionPane.ERROR_MESSAGE);
    }     
    }//GEN-LAST:event_btnActualizar3DActionPerformed

    private void btnActualizar2DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizar2DActionPerformed
        try {
     
        if (txtPrecio2D.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Por favor ingrese un precio para funciones 2D",
                    "Campo vacío",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        
  
        double nuevoPrecio = Double.parseDouble(txtPrecio2D.getText().trim());
        
    
        if (nuevoPrecio <= 0) {
            JOptionPane.showMessageDialog(this,
                    "El precio debe ser mayor a cero",
                    "Precio inválido",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
    
        int confirmacion = JOptionPane.showConfirmDialog(this,
                "¿Está seguro de actualizar el precio de TODAS las funciones 2D a $" + 
                String.format("%.2f", nuevoPrecio) + "?",
                "Confirmar Actualización",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        
        if (confirmacion == JOptionPane.YES_OPTION) {
         
            funcionData.actualizarPrecio2D(nuevoPrecio);
            
          
            txtInfo.setText("Precios 2D actualizados exitosamente!\n" +
                           "Nuevo precio: $" + String.format("%.2f", nuevoPrecio) + "\n" +
                           "Todos las funciones 2D ahora tienen este precio.");
            
          
            txtPrecio2D.setText("");
        }
        
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this,
                "Por favor ingrese un número válido",
                "Error de formato",
                JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnActualizar2DActionPerformed

    private void btnActualizarAmbosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarAmbosActionPerformed
       try {
       
        if (txtPrecio2D.getText().trim().isEmpty() || 
            txtPrecio3D.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Por favor ingrese ambos precios (2D y 3D)",
                    "Campos incompletos",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        
     
        double precio2D = Double.parseDouble(txtPrecio2D.getText().trim());
        double precio3D = Double.parseDouble(txtPrecio3D.getText().trim());
        
      
        if (precio2D <= 0 || precio3D <= 0) {
            JOptionPane.showMessageDialog(this,
                    "Los precios deben ser mayores a cero",
                    "Precios inválidos",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
    
        int confirmacion = JOptionPane.showConfirmDialog(this,
                "¿Está seguro de actualizar los precios?\n\n" +
                "Funciones 2D: $" + String.format("%.2f", precio2D) + "\n" +
                "Funciones 3D: $" + String.format("%.2f", precio3D),
                "Confirmar Actualización",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        
        if (confirmacion == JOptionPane.YES_OPTION) {
         
            funcionData.actualizarPrecio2D(precio2D);
            funcionData.actualizarPrecio3D(precio3D);
            
        
            txtInfo.setText("✅ Todos los precios actualizados exitosamente!\n\n" +
                           "Funciones 2D: $" + String.format("%.2f", precio2D) + "\n" +
                           "Funciones 3D: $" + String.format("%.2f", precio3D) + "\n\n" +
                           "Los cambios se han aplicado a todas las funciones.");
            
      
            txtPrecio2D.setText("");
            txtPrecio3D.setText("");
        }
        
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this,
                "Por favor ingrese números válidos en ambos campos",
                "Error de formato",
                JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnActualizarAmbosActionPerformed

    private void BtnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_BtnCerrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCerrar;
    private javax.swing.JButton btnActualizar2D;
    private javax.swing.JButton btnActualizar3D;
    private javax.swing.JButton btnActualizarAmbos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelInfo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtInfo;
    private javax.swing.JTextField txtPrecio2D;
    private javax.swing.JTextField txtPrecio3D;
    // End of variables declaration//GEN-END:variables
}
