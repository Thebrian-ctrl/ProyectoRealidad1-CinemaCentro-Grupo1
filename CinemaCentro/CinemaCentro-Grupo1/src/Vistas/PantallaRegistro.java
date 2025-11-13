
package Vistas;

import Modelo.Comprador;
import Persistencia.CompradorData;
import java.time.LocalDate;
import java.time.ZoneId;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import com.toedter.calendar.JDateChooser;
import java.time.Period;
/**
 *
 * @author franco
 */
public class PantallaRegistro extends javax.swing.JInternalFrame {

  

    public PantallaRegistro() {
        initComponents();
        cargarMediosDePago();
          diseñoRegistro();
        
    }


    private void diseñoRegistro() {

        getContentPane().setBackground(new Color(245, 245, 245));

      
        JPanel panelPrincipal = (JPanel) getContentPane(); 
    

        panelPrincipal.setBackground(Color.WHITE);
        panelPrincipal.setBorder(new CompoundBorder(
                new EmptyBorder(25, 25, 25, 25),
                new LineBorder(new Color(230, 230, 230), 1, true)
        ));

        Font fuenteBase = new Font("Segoe UI", Font.PLAIN, 14);
        Font fuenteTitulo = new Font("Segoe UI", Font.BOLD, 22);

        jLabel1.setFont(fuenteTitulo);
        jLabel1.setForeground(new Color(45, 120, 220));

        jLabel2.setFont(fuenteBase);
        jLabel3.setFont(fuenteBase);
        jLabel4.setFont(fuenteBase);
        jLabel5.setFont(fuenteBase);
        jLabel6.setFont(fuenteBase);

        jTextNombre.setFont(fuenteBase);
        jTextDni.setFont(fuenteBase);
        jContrasenia.setFont(fuenteBase);
        jComboMedioDePago.setFont(fuenteBase);
        jDateNacimiento.setFont(fuenteBase);

        estilizarCampo(jTextNombre);
        estilizarCampo(jTextDni);
        estilizarCampo(jContrasenia);

        jComboMedioDePago.setBackground(Color.WHITE);
        jComboMedioDePago.setBorder(new LineBorder(new Color(210, 210, 210), 1, true));
        jComboMedioDePago.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        jDateNacimiento.setBackground(Color.WHITE);
        jDateNacimiento.getDateEditor().getUiComponent().setFont(fuenteBase);
        ((JTextField) jDateNacimiento.getDateEditor().getUiComponent())
                .setBorder(new LineBorder(new Color(210, 210, 210), 1, true));

        estilizarBoton(jBIniciar, new Color(77, 163, 255));
        estilizarBoton(jBatras, new Color(200, 200, 200));
    }

  
    private void estilizarCampo(JTextField campo) {
        campo.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(210, 210, 210), 1, true),
                new EmptyBorder(8, 8, 8, 8)
        ));
        campo.setOpaque(true);
        campo.setBackground(Color.WHITE);
    }

    private void estilizarBoton(JButton boton, Color colorBase) {
        boton.setBackground(colorBase);
        boton.setForeground(colorBase.equals(new Color(200, 200, 200)) ? Color.BLACK : Color.WHITE);
        boton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        boton.setBorderPainted(false);
        boton.setFocusPainted(false);
        boton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        boton.setOpaque(true);

        boton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boton.setBackground(colorBase.darker());
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
        jTextDni = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jDateNacimiento = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jContrasenia = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jBIniciar = new javax.swing.JButton();
        jBatras = new javax.swing.JButton();
        jComboMedioDePago = new javax.swing.JComboBox<>();

        jLabel1.setText("Registrarse");

        jLabel2.setText("DNI:");

        jLabel3.setText("Nombre y apellido:");

        jLabel4.setText("Fecha de nacimiento:");

        jLabel5.setText("Contraseña:");

        jContrasenia.setText("jPasswordField1");

        jLabel6.setText("Medio de pago:");

        jBIniciar.setText("INICIAR SESION");
        jBIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBIniciarActionPerformed(evt);
            }
        });

        jBatras.setText("ATRAS");
        jBatras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBatrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextDni, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                                .addComponent(jTextNombre, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jDateNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboMedioDePago, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jBatras)
                        .addGap(133, 133, 133)
                        .addComponent(jBIniciar)))
                .addContainerGap(190, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(7, 7, 7)
                .addComponent(jTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboMedioDePago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBatras)
                    .addComponent(jBIniciar))
                .addContainerGap(143, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBIniciarActionPerformed
        try {
       
        if (jTextNombre.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "El campo Nombre es obligatorio", 
                "Campo vacío", 
                JOptionPane.WARNING_MESSAGE);
            jTextNombre.requestFocus();
            return;
        }
        
        if (jTextDni.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "El campo DNI es obligatorio", 
                "Campo vacío", 
                JOptionPane.WARNING_MESSAGE);
            jTextDni.requestFocus();
            return;
        }
        
        if (jDateNacimiento.getDate() == null) {
            JOptionPane.showMessageDialog(this, 
                "Debe seleccionar una fecha de nacimiento", 
                "Campo vacío", 
                JOptionPane.WARNING_MESSAGE);
            jDateNacimiento.requestFocus();
            return;
        }
        
        if (jContrasenia.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, 
                "El campo Contraseña es obligatorio", 
                "Campo vacío", 
                JOptionPane.WARNING_MESSAGE);
            jContrasenia.requestFocus();
            return;
        }
        
        if (jComboMedioDePago.getSelectedIndex() == 0 || jComboMedioDePago.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, 
                "Debe seleccionar un medio de pago", 
                "Campo vacío", 
                JOptionPane.WARNING_MESSAGE);
            jComboMedioDePago.requestFocus();
            return;
        }
        
       
        String dniTexto = jTextDni.getText().trim();
        
        if (!dniTexto.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, 
                "El DNI solo puede contener números", 
                "DNI inválido", 
                JOptionPane.ERROR_MESSAGE);
            jTextDni.requestFocus();
            jTextDni.selectAll();
            return;
        }
        
        int dni = Integer.parseInt(dniTexto);
        
        if (dni < 1000000 || dni > 99999999) {
            JOptionPane.showMessageDialog(this, 
                "El DNI debe tener entre 7 y 8 dígitos", 
                "DNI inválido", 
                JOptionPane.ERROR_MESSAGE);
            jTextDni.requestFocus();
            jTextDni.selectAll();
            return;
        }
        
    
        CompradorData compraData = new CompradorData();
        Comprador existe = compraData.buscarComprador(dni);
        
        if (existe != null) {
            JOptionPane.showMessageDialog(this, 
                "Ya existe un comprador registrado con el DNI " + dni, 
                "DNI duplicado", 
                JOptionPane.ERROR_MESSAGE);
            jTextDni.requestFocus();
            jTextDni.selectAll();
            return;
        }
        
    
        String nombre = jTextNombre.getText().trim();
        
        if (nombre.length() < 3) {
            JOptionPane.showMessageDialog(this, 
                "El nombre debe tener al menos 3 caracteres", 
                "Nombre inválido", 
                JOptionPane.WARNING_MESSAGE);
            jTextNombre.requestFocus();
            return;
        }
        
        if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
            JOptionPane.showMessageDialog(this, 
                "El nombre solo puede contener letras y espacios", 
                "Nombre inválido", 
                JOptionPane.ERROR_MESSAGE);
            jTextNombre.requestFocus();
            return;
        }
        
     
        LocalDate fechaNac = jDateNacimiento.getDate()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        
        LocalDate hoy = LocalDate.now();
        int edad = Period.between(fechaNac, hoy).getYears();
        
        if (fechaNac.isAfter(hoy)) {
            JOptionPane.showMessageDialog(this, 
                "La fecha de nacimiento no puede ser futura", 
                "Fecha inválida", 
                JOptionPane.ERROR_MESSAGE);
            jDateNacimiento.requestFocus();
            return;
        }
        
        if (edad < 13) {
            JOptionPane.showMessageDialog(this, 
                "Debe tener al menos 13 años para registrarse", 
                "Edad insuficiente", 
                JOptionPane.WARNING_MESSAGE);
            jDateNacimiento.requestFocus();
            return;
        }
        
        if (edad > 120) {
            JOptionPane.showMessageDialog(this, 
                "La fecha de nacimiento no es válida", 
                "Fecha inválida", 
                JOptionPane.ERROR_MESSAGE);
            jDateNacimiento.requestFocus();
            return;
        }
        
     
        String password = new String(jContrasenia.getPassword());
        
        if (password.length() < 3) {
            JOptionPane.showMessageDialog(this, 
                "La contraseña debe tener al menos 3 caracteres", 
                "Contraseña débil", 
                JOptionPane.WARNING_MESSAGE);
            jContrasenia.requestFocus();
            return;
        }
        
     
        Comprador comprador = new Comprador();
        comprador.setNombre(nombre);
        comprador.setDni(dni);
        comprador.setFechaNac(fechaNac);
        comprador.setPassword(password);
        comprador.setMedioDePago((String) jComboMedioDePago.getSelectedItem());
        
        compraData.guardarComprador(comprador);
        
        JOptionPane.showMessageDialog(this, 
            "¡Registro exitoso!\n\n" +
            "Bienvenido " + nombre + "\n" +
            "Ya puede iniciar sesión con su DNI: " + dni, 
            "Registro completado", 
            JOptionPane.INFORMATION_MESSAGE);
        
        limpiarCampos();
        
     
        javax.swing.JDesktopPane escritorio = this.getDesktopPane();
        if (escritorio != null) {
            this.dispose();
            InicioDeSesion inicioSesion = new InicioDeSesion();
            inicioSesion.setVisible(true);
            escritorio.add(inicioSesion);
            try {
                inicioSesion.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
             
            }
        }
        
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, 
            "El DNI debe ser un número válido", 
            "Error de formato", 
            JOptionPane.ERROR_MESSAGE);
        jTextDni.requestFocus();
        jTextDni.selectAll();
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, 
            "Error al registrar el comprador:\n" + e.getMessage(), 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }

    

    }//GEN-LAST:event_jBIniciarActionPerformed

    private void jBatrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBatrasActionPerformed
     try {
 
        javax.swing.JDesktopPane escritorio = this.getDesktopPane();
        
        if (escritorio == null) {
            JOptionPane.showMessageDialog(this, "Error: No se puede acceder al escritorio");
            return;
        }
        
  
        this.dispose();
        
  
        InicioDeSesion inicioSesion = new InicioDeSesion();
        inicioSesion.setVisible(true);
        escritorio.add(inicioSesion);
        
      
        try {
            inicioSesion.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
         
        }
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al volver: " + e.getMessage());
    }

        
        
         
         
    }//GEN-LAST:event_jBatrasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBIniciar;
    private javax.swing.JButton jBatras;
    private javax.swing.JComboBox<String> jComboMedioDePago;
    private javax.swing.JPasswordField jContrasenia;
    private com.toedter.calendar.JDateChooser jDateNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextDni;
    private javax.swing.JTextField jTextNombre;
    // End of variables declaration//GEN-END:variables


    private void cargarMediosDePago(){
        jComboMedioDePago.addItem("Efectivo");
        jComboMedioDePago.addItem("Tarjeta de Debito");
        jComboMedioDePago.addItem("Tarjeta de Credito");
        jComboMedioDePago.addItem("Mercado Pago");
        jComboMedioDePago.addItem("Transferencia");
        
    }
    
    private void limpiarCampos(){
        jTextNombre.setText("");
        jTextDni.setText("");
        jDateNacimiento.setDate(null);
        jContrasenia.setText("");
        jComboMedioDePago.setSelectedIndex(0);
    }





}
