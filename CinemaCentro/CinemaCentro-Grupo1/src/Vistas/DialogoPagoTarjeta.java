/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DialogoPagoTarjeta extends JDialog {
    
    private JTextField txtNumeroTarjeta;
    private JTextField txtTitular;
    private JTextField txtFechaVenc;
    private JTextField txtCVV;
    private boolean pagoAceptado = false;
    
    public DialogoPagoTarjeta(Frame parent, String tipoTarjeta, double monto) {
        super(parent, "Pago con " + tipoTarjeta, true);
        
        initComponents(tipoTarjeta, monto);
        
        setSize(450, 400);
        setLocationRelativeTo(parent);
        setResizable(false);
    }
    
    private void initComponents(String tipoTarjeta, double monto) {
        setLayout(new BorderLayout(10, 10));
        
       
        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(220, 20, 60));
        JLabel lblTitulo = new JLabel(" " + tipoTarjeta);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitulo.setForeground(Color.WHITE);
        panelTitulo.add(lblTitulo);
        add(panelTitulo, BorderLayout.NORTH);
        
       
        JPanel panelForm = new JPanel();
        panelForm.setLayout(new GridBagLayout());
        panelForm.setBackground(Color.WHITE);
        panelForm.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(8, 5, 8, 5);
        
        Font fuenteLabel = new Font("Segoe UI", Font.BOLD, 14);
        Font fuenteInput = new Font("Segoe UI", Font.PLAIN, 14);
        
  
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        JLabel lblMonto = new JLabel(String.format("Monto a pagar: $%.2f", monto));
        lblMonto.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblMonto.setForeground(new Color(220, 20, 60));
        lblMonto.setHorizontalAlignment(SwingConstants.CENTER);
        panelForm.add(lblMonto, gbc);
        
      
        gbc.gridwidth = 1; gbc.gridy = 1;
        JLabel lblNumero = new JLabel("Número de tarjeta:");
        lblNumero.setFont(fuenteLabel);
        panelForm.add(lblNumero, gbc);
        
        gbc.gridx = 1;
        txtNumeroTarjeta = new JTextField(16);
        txtNumeroTarjeta.setFont(fuenteInput);
        txtNumeroTarjeta.setToolTipText("16 dígitos");
        panelForm.add(txtNumeroTarjeta, gbc);
        
     
        gbc.gridx = 0; gbc.gridy = 2;
        JLabel lblTitular = new JLabel("Titular:");
        lblTitular.setFont(fuenteLabel);
        panelForm.add(lblTitular, gbc);
        
        gbc.gridx = 1;
        txtTitular = new JTextField(20);
        txtTitular.setFont(fuenteInput);
        panelForm.add(txtTitular, gbc);
        
      
        gbc.gridx = 0; gbc.gridy = 3;
        JLabel lblFecha = new JLabel("Vencimiento (MM/AA):");
        lblFecha.setFont(fuenteLabel);
        panelForm.add(lblFecha, gbc);
        
        gbc.gridx = 1;
        txtFechaVenc = new JTextField(5);
        txtFechaVenc.setFont(fuenteInput);
        txtFechaVenc.setToolTipText("Ej: 12/25");
        panelForm.add(txtFechaVenc, gbc);
        

        gbc.gridx = 0; gbc.gridy = 4;
        JLabel lblCVV = new JLabel("Código CVV:");
        lblCVV.setFont(fuenteLabel);
        panelForm.add(lblCVV, gbc);
        
        gbc.gridx = 1;
        txtCVV = new JPasswordField(3);
        txtCVV.setFont(fuenteInput);
        txtCVV.setToolTipText("3 dígitos");
        panelForm.add(txtCVV, gbc);
        
        add(panelForm, BorderLayout.CENTER);
        
       
        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(Color.WHITE);
        panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
        
        JButton btnPagar = new JButton(" PAGAR");
        btnPagar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnPagar.setBackground(new Color(34, 139, 34));
        btnPagar.setForeground(Color.WHITE);
        btnPagar.setFocusPainted(false);
        btnPagar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnPagar.setPreferredSize(new Dimension(140, 40));
        
        JButton btnCancelar = new JButton(" CANCELAR");
        btnCancelar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnCancelar.setBackground(new Color(220, 20, 60));
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setFocusPainted(false);
        btnCancelar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCancelar.setPreferredSize(new Dimension(140, 40));
        
        btnPagar.addActionListener(e -> procesarPago());
        btnCancelar.addActionListener(e -> {
            pagoAceptado = false;
            dispose();
        });
        
        panelBotones.add(btnPagar);
        panelBotones.add(Box.createHorizontalStrut(10));
        panelBotones.add(btnCancelar);
        
        add(panelBotones, BorderLayout.SOUTH);
    }
    
    private void procesarPago() {
    
        String numero = txtNumeroTarjeta.getText().replaceAll("\\s", "");
        String titular = txtTitular.getText().trim();
        String fecha = txtFechaVenc.getText().trim();
        String cvv = txtCVV.getText().trim();
        
     
        if (numero.isEmpty() || titular.isEmpty() || fecha.isEmpty() || cvv.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Por favor complete todos los campos",
                "Datos Incompletos",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
    
        if (!numero.matches("\\d{16}")) {
            JOptionPane.showMessageDialog(this,
                "El número de tarjeta debe tener 16 dígitos",
                "Número Inválido",
                JOptionPane.ERROR_MESSAGE);
            txtNumeroTarjeta.requestFocus();
            return;
        }
        
     
        if (!fecha.matches("\\d{2}/\\d{2}")) {
            JOptionPane.showMessageDialog(this,
                "La fecha debe tener formato MM/AA (Ej: 12/25)",
                "Fecha Inválida",
                JOptionPane.ERROR_MESSAGE);
            txtFechaVenc.requestFocus();
            return;
        }
        
     
        if (!cvv.matches("\\d{3}")) {
            JOptionPane.showMessageDialog(this,
                "El CVV debe tener 3 dígitos",
                "CVV Inválido",
                JOptionPane.ERROR_MESSAGE);
            txtCVV.requestFocus();
            return;
        }
        
      
        JOptionPane.showMessageDialog(this,
            " Procesando pago...\n\n" +
            "Tarjeta: **** **** **** " + numero.substring(12) + "\n" +
            "Titular: " + titular,
            "Procesando",
            JOptionPane.INFORMATION_MESSAGE);
        
      
        pagoAceptado = true;
        dispose();
    }
    
    public boolean isPagoAceptado() {
        return pagoAceptado;
    }
}