/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;

import Modelo.Comprador;
import Persistencia.CompradorData;
import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;



/**
 *
 * @author franco
 */
public class InicioDeSesion extends javax.swing.JInternalFrame {


  
    public InicioDeSesion() {
        initComponents();
         diseño();
    }

    private void diseño() {
       
        getContentPane().setBackground(new Color(245, 245, 245));

      
        jPanel1.setBackground(Color.WHITE);
        jPanel1.setBorder(new CompoundBorder(
                new EmptyBorder(20, 25, 20, 25),
                new LineBorder(new Color(230, 230, 230), 1, true)
        ));
        jPanel1.setOpaque(true);

      
        Font fuenteBase = new Font("Segoe UI", Font.PLAIN, 14);

        jtfDNI.setFont(fuenteBase);
        jtfContraseña.setFont(fuenteBase);
        jRadioButton1.setFont(fuenteBase);
        jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 22));
        jLabel1.setForeground(new Color(45, 120, 220));

        jLabel2.setFont(fuenteBase);
        jLabel3.setFont(fuenteBase);
        jLabel4.setFont(fuenteBase);
        jLabel5.setFont(fuenteBase);

       
        jtfDNI.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(210, 210, 210), 1, true),
                new EmptyBorder(8, 8, 8, 8)
        ));
        jtfContraseña.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(210, 210, 210), 1, true),
                new EmptyBorder(8, 8, 8, 8)
        ));

       
        estilizarBoton(jButtonEstilo(btnIngresar, new Color(77, 163, 255), "Ingresar"));
        estilizarBoton(jButtonEstilo(btnRegistrarse, new Color(85, 200, 120), "Registrarse"));
        estilizarBoton(jButtonEstilo(btnSalir, new Color(255, 99, 99), "Salir"));

        
        jRadioButton1.setBackground(Color.WHITE);
        jRadioButton1.setFocusPainted(false);
        jRadioButton1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private JButton jButtonEstilo(JButton boton, Color color, String texto) {
        boton.setBackground(color);
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        boton.setText(texto);
        boton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        boton.setOpaque(true);

     
        boton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boton.setBackground(color.darker());
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton.setBackground(color);
            }
        });

        return boton;
    }

    private void estilizarBoton(JButton boton) {
      
    }
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnIngresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jtfDNI = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        btnSalir = new javax.swing.JButton();
        btnRegistrarse = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jtfContraseña = new javax.swing.JPasswordField();

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Iniciar sesión:");

        jtfDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDNIActionPerformed(evt);
            }
        });

        jLabel2.setText("DNI:");
        jLabel2.setToolTipText("");

        jLabel3.setText("Contraseña:");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconUsuarios.gif"))); // NOI18N

        jRadioButton1.setText("Mostrar Contraseña");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.setToolTipText("");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnRegistrarse.setText("Registrarse");
        btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarseActionPerformed(evt);
            }
        });

        jLabel5.setText("Si no tiene cuenta");

        jtfContraseña.setText("jPasswordField1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 89, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnIngresar)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(btnRegistrarse))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(37, 37, 37)
                                        .addComponent(jtfDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jtfContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(22, 22, 22)
                                .addComponent(jRadioButton1)))
                        .addGap(75, 75, 75))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSalir)
                        .addGap(44, 44, 44))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtfContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton1))
                        .addGap(96, 96, 96))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnIngresar)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegistrarse))))
                .addGap(61, 61, 61)
                .addComponent(btnSalir)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDNIActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
       
          int confirm = JOptionPane.showConfirmDialog(this,
        "¿Está seguro que desea salir?",
        "Confirmar Salida",
        JOptionPane.YES_NO_OPTION);
    
    if (confirm == JOptionPane.YES_OPTION) {
        this.dispose(); 
    }

    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed
          // TODO add your handling code here:
    try {
     
        javax.swing.JDesktopPane escritorio = this.getDesktopPane();
        
        if (escritorio == null) {
            JOptionPane.showMessageDialog(this, "Error: No se puede acceder al escritorio");
            return;
        }
        
       
        this.dispose();
        
     
        PantallaRegistro registro = new PantallaRegistro();
        registro.setVisible(true);
        escritorio.add(registro);
        
       
        try {
            registro.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
         
        }
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al abrir registro: " + e.getMessage());
    }

    }//GEN-LAST:event_btnRegistrarseActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        // TODO add your handling code here:
 try {
    
        if (jtfDNI.getText().isEmpty() || jtfContraseña.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos");
            return;
        }
        
        int dni = Integer.parseInt(jtfDNI.getText());
        String password = new String(jtfContraseña.getPassword());
        
      
        CompradorData compradorData = new CompradorData();
        Comprador comprador = compradorData.buscarComprador(dni);
        
  
        if (comprador != null && comprador.getPassword().equals(password)) {
            JOptionPane.showMessageDialog(this, "¡Bienvenido " + comprador.getNombre() + "!");
            
         
            javax.swing.JDesktopPane escritorio = this.getDesktopPane();
            
            if (escritorio == null) {
                JOptionPane.showMessageDialog(this, "Error: No se puede acceder al escritorio");
                return;
            }
            
            this.dispose();
            
         
            CompraTicket compraTicket = new CompraTicket(comprador);
            compraTicket.setVisible(true);
            escritorio.add(compraTicket);
            
       
            try {
                compraTicket.setMaximum(true);
            } catch (java.beans.PropertyVetoException e) {
          
                compraTicket.setSelected(true);
            }
            
        } else {
            JOptionPane.showMessageDialog(this, 
                "DNI o contraseña incorrectos", 
                "Error de autenticación", 
                JOptionPane.ERROR_MESSAGE);
            jtfContraseña.setText("");
        }
        
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "El DNI debe ser un número válido");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al iniciar sesión: " + e.getMessage());
        e.printStackTrace();
    }
    


    }//GEN-LAST:event_btnIngresarActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        
         if (jRadioButton1.isSelected()) {
        jtfContraseña.setEchoChar((char)0); 
    } else {
        jtfContraseña.setEchoChar('•');
    }
    }//GEN-LAST:event_jRadioButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnRegistrarse;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JPasswordField jtfContraseña;
    private javax.swing.JTextField jtfDNI;
    // End of variables declaration//GEN-END:variables
}
