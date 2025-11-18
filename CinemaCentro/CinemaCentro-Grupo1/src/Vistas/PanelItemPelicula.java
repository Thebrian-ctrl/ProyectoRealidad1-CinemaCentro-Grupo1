
package Vistas;

import Modelo.Pelicula;
import Persistencia.PeliculaData;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class PanelItemPelicula extends JPanel {
   
    private Pelicula pelicula;
    private PeliculaData peliData;
    
    public PanelItemPelicula(Pelicula pelicula, PeliculaData peliData) {
        this.pelicula = pelicula;
        this.peliData = peliData;
        
        inicializarPanel();
    }
    
    private void inicializarPanel() {
        Color colorPrimario = new Color(41, 128, 185);
        Color colorFondo = Color.WHITE;
        
        this.setLayout(new BorderLayout(15, 15));
        this.setBackground(colorFondo);
        this.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(colorPrimario, 2),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));
        
        this.add(crearPanelImagen(), BorderLayout.WEST);
        this.add(crearPanelDatos(), BorderLayout.CENTER);
        this.add(crearPanelBotones(), BorderLayout.EAST);
    }
    
    private JPanel crearPanelImagen() {
        JPanel panelImagen = new JPanel(new BorderLayout());
        panelImagen.setBackground(Color.WHITE);
        
        JLabel labelImagen = new JLabel();
        labelImagen.setHorizontalAlignment(JLabel.CENTER);
        labelImagen.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        
        try {
            if (pelicula.getRutaImagen() != null) {
                ImageIcon icono = new ImageIcon(pelicula.getRutaImagen());
                Image img = icono.getImage().getScaledInstance(120, 180, Image.SCALE_SMOOTH);
                labelImagen.setIcon(new ImageIcon(img));
            } else {
                labelImagen.setText("Sin imagen");
                labelImagen.setPreferredSize(new Dimension(120, 180));
            }
        } catch (Exception e) {
            labelImagen.setText("Sin imagen");
            labelImagen.setPreferredSize(new Dimension(120, 180));
        }
        
        panelImagen.add(labelImagen, BorderLayout.CENTER);
        return panelImagen;
    }
    
    private JPanel crearPanelDatos() {
        JPanel panelDatos = new JPanel();
        panelDatos.setLayout(new BoxLayout(panelDatos, BoxLayout.Y_AXIS));
        panelDatos.setBackground(Color.WHITE);
        panelDatos.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        
   
        JLabel labelTitulo = new JLabel(pelicula.getTitulo());
        labelTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        labelTitulo.setForeground(new Color(41, 128, 185));
        labelTitulo.setAlignmentX(Component.LEFT_ALIGNMENT);
        
      
        JSeparator separador = new JSeparator();
        separador.setMaximumSize(new Dimension(9999, 2));
        separador.setAlignmentX(Component.LEFT_ALIGNMENT);
        
    
        JLabel labelDirector = new JLabel("Director: " + pelicula.getDirector());
        labelDirector.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        labelDirector.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JLabel labelGenero = new JLabel("Genero: " + pelicula.getGenero());
        labelGenero.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        labelGenero.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JLabel labelActores = new JLabel("Actores: " + pelicula.getActores());
        labelActores.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        labelActores.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JLabel labelOrigen = new JLabel("Origen: " + pelicula.getOrigen());
        labelOrigen.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        labelOrigen.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JLabel labelEstreno = new JLabel("Estreno: " + pelicula.getEstreno());
        labelEstreno.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        labelEstreno.setAlignmentX(Component.LEFT_ALIGNMENT);
        
    
        JLabel labelCartelera = new JLabel();
        if (pelicula.isCartelera()) {
            labelCartelera.setText("EN CARTELERA");
            labelCartelera.setForeground(new Color(39, 174, 96));
        } else {
            labelCartelera.setText("FUERA DE CARTELERA");
            labelCartelera.setForeground(new Color(231, 76, 60));
        }
        labelCartelera.setFont(new Font("Segoe UI", Font.BOLD, 12));
        labelCartelera.setAlignmentX(Component.LEFT_ALIGNMENT);
        
     
        panelDatos.add(labelTitulo);
        panelDatos.add(Box.createRigidArea(new Dimension(0, 5)));
        panelDatos.add(separador);
        panelDatos.add(Box.createRigidArea(new Dimension(0, 10)));
        panelDatos.add(labelDirector);
        panelDatos.add(Box.createRigidArea(new Dimension(0, 5)));
        panelDatos.add(labelGenero);
        panelDatos.add(Box.createRigidArea(new Dimension(0, 5)));
        panelDatos.add(labelActores);
        panelDatos.add(Box.createRigidArea(new Dimension(0, 5)));
        panelDatos.add(labelOrigen);
        panelDatos.add(Box.createRigidArea(new Dimension(0, 5)));
        panelDatos.add(labelEstreno);
        panelDatos.add(Box.createRigidArea(new Dimension(0, 10)));
        panelDatos.add(labelCartelera);
        panelDatos.add(Box.createVerticalGlue());
        
        return panelDatos;
    }
    
    private JPanel crearPanelBotones() {
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        panelBotones.setBackground(Color.WHITE);
        panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
      
        JButton botonEliminar = new JButton("Eliminar");
        botonEliminar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        botonEliminar.setBackground(new Color(231, 76, 60));
        botonEliminar.setForeground(Color.WHITE);
        botonEliminar.setFocusPainted(false);
        botonEliminar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonEliminar.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonEliminar.setMaximumSize(new Dimension(150, 40));
        botonEliminar.addActionListener(e -> eliminarPelicula());
        
      
        String textoBoton = pelicula.isCartelera() ? "Dar de Baja" : "Dar de Alta";
        Color colorBoton = pelicula.isCartelera() ? new Color(243, 156, 18) : new Color(39, 174, 96);
        
        JButton botonBaja = new JButton(textoBoton);
        botonBaja.setFont(new Font("Segoe UI", Font.BOLD, 12));
        botonBaja.setBackground(colorBoton);
        botonBaja.setForeground(Color.WHITE);
        botonBaja.setFocusPainted(false);
        botonBaja.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonBaja.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonBaja.setMaximumSize(new Dimension(150, 40));
        botonBaja.addActionListener(e -> toggleCartelera());
        
        panelBotones.add(botonEliminar);
        panelBotones.add(Box.createRigidArea(new Dimension(0, 10)));
        panelBotones.add(botonBaja);
        panelBotones.add(Box.createVerticalGlue());
        
        return panelBotones;
    }
    
    private void eliminarPelicula() {
        int opcion = JOptionPane.showConfirmDialog(this, 
            "Esta seguro que desea ELIMINAR esta pelicula?\n\nPelicula: " + pelicula.getTitulo(),
            "Confirmar Eliminacion", 
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE);
        
        if (opcion == JOptionPane.YES_OPTION) {
            peliData.eliminarPelicula(pelicula.getIdPelicula());
            JOptionPane.showMessageDialog(this, "Pelicula eliminada exitosamente");
            
            Container parent = this.getParent();
            if (parent != null) {
                parent.remove(this);
                parent.revalidate();
                parent.repaint();
            }
        }
    }
    
    private void toggleCartelera() {
        if (pelicula.isCartelera()) {
            int opcion = JOptionPane.showConfirmDialog(this, 
                "Retirar de cartelera?\n\nPelicula: " + pelicula.getTitulo(),
                "Confirmar Baja", 
                JOptionPane.YES_NO_OPTION);
            
            if (opcion == JOptionPane.YES_OPTION) {
                pelicula.setCartelera(false);
                peliData.darBajaCartelera(pelicula.getIdPelicula());
                JOptionPane.showMessageDialog(this, "Pelicula retirada de cartelera");
            }
        } else {
            int opcion = JOptionPane.showConfirmDialog(this, 
                "Agregar a cartelera?\n\nPelicula: " + pelicula.getTitulo(),
                "Confirmar Alta", 
                JOptionPane.YES_NO_OPTION);
            
            if (opcion == JOptionPane.YES_OPTION) {
                pelicula.setCartelera(true);
                peliData.darAltaCartelera(pelicula.getIdPelicula());
                JOptionPane.showMessageDialog(this, "Pelicula agregada a cartelera");
            }
        }
    
}




 
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 755, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 464, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
