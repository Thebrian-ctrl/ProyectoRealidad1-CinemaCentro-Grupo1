/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelo.Pelicula;
import Persistencia.PeliculaData;
import java.awt.Image;
import java.io.File;
import static java.lang.System.out;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author arceb
 */
public class PantallaPeliculas extends javax.swing.JInternalFrame {

    PeliculaData peliData = new PeliculaData();

    private String rutaImagenSelec;

    public PantallaPeliculas() {
        initComponents();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitulo = new javax.swing.JLabel();
        jbSeleccionarArchivo = new javax.swing.JButton();
        jlabelTitulo = new javax.swing.JLabel();
        jtfTitulo = new javax.swing.JTextField();
        jlabelDirector = new javax.swing.JLabel();
        jtfDirector = new javax.swing.JTextField();
        jLabelGenero = new javax.swing.JLabel();
        jtfGenero = new javax.swing.JTextField();
        jLabelOrigen = new javax.swing.JLabel();
        jtfOrigen = new javax.swing.JTextField();
        jLabelActores = new javax.swing.JLabel();
        jtfActores = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jdchooseEstreno = new com.toedter.calendar.JDateChooser();
        jbActualizar = new javax.swing.JButton();
        jbGuardar2 = new javax.swing.JButton();
        jLabelCartelera = new javax.swing.JLabel();
        jRadioButtonCartelera = new javax.swing.JRadioButton();
        jLabelImagen = new javax.swing.JLabel();
        jButtonBuscar = new javax.swing.JButton();
        jButtonCerrar = new javax.swing.JButton();

        labelTitulo.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        labelTitulo.setText("Administracion de Peliculas");

        jbSeleccionarArchivo.setText("Seleccionar archivo");
        jbSeleccionarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSeleccionarArchivoActionPerformed(evt);
            }
        });

        jlabelTitulo.setText("Titulo:");

        jtfTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfTituloActionPerformed(evt);
            }
        });

        jlabelDirector.setText("Director:");

        jLabelGenero.setText("Genero:");

        jLabelOrigen.setText("Origen:");

        jLabelActores.setText("Actores:");

        jLabel1.setText("Estreno:");

        jbActualizar.setText("Actualizar");
        jbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarActionPerformed(evt);
            }
        });

        jbGuardar2.setText("Guardar");
        jbGuardar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardar2ActionPerformed(evt);
            }
        });

        jLabelCartelera.setText("En cartelera?:");

        jRadioButtonCartelera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCarteleraActionPerformed(evt);
            }
        });

        jLabelImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jButtonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa.png"))); // NOI18N
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jButtonCerrar.setText("Cerrar");
        jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbSeleccionarArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(jLabelImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlabelDirector)
                            .addComponent(jLabelGenero)
                            .addComponent(jLabelOrigen)
                            .addComponent(jLabel1)
                            .addComponent(jLabelActores)
                            .addComponent(jlabelTitulo)
                            .addComponent(jLabelCartelera))
                        .addGap(89, 89, 89))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbGuardar2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtfActores)
                            .addComponent(jdchooseEstreno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(14, 14, 14))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfDirector, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jRadioButtonCartelera)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelTitulo)
                .addGap(93, 93, 93))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfDirector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlabelDirector, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelGenero))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelOrigen))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfActores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelActores))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jdchooseEstreno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCartelera, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jRadioButtonCartelera, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jbSeleccionarArchivo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbGuardar2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(63, 63, 63))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfTituloActionPerformed

    private void jbGuardar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardar2ActionPerformed
        // TODO add your handling code here:

        try {

            if (jtfTitulo.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "El título es obligatorio",
                        "Campo vacío",
                        JOptionPane.WARNING_MESSAGE);
                jtfTitulo.requestFocus();
                return;
            }

            if (jtfDirector.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "El director es obligatorio",
                        "Campo vacío",
                        JOptionPane.WARNING_MESSAGE);
                jtfDirector.requestFocus();
                return;
            }

            if (jtfGenero.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "El género es obligatorio",
                        "Campo vacío",
                        JOptionPane.WARNING_MESSAGE);
                jtfGenero.requestFocus();
                return;
            }

            if (jtfOrigen.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "El origen es obligatorio",
                        "Campo vacío",
                        JOptionPane.WARNING_MESSAGE);
                jtfOrigen.requestFocus();
                return;
            }

            if (jtfActores.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Los actores son obligatorios",
                        "Campo vacío",
                        JOptionPane.WARNING_MESSAGE);
                jtfActores.requestFocus();
                return;
            }

            if (jdchooseEstreno.getDate() == null) {
                JOptionPane.showMessageDialog(this,
                        "Debe seleccionar una fecha de estreno",
                        "Campo vacío",
                        JOptionPane.WARNING_MESSAGE);
                jdchooseEstreno.requestFocus();
                return;
            }

            String titulo = jtfTitulo.getText().trim();
            if (titulo.length() < 2) {
                JOptionPane.showMessageDialog(this,
                        "El título debe tener al menos 2 caracteres",
                        "Título inválido",
                        JOptionPane.WARNING_MESSAGE);
                jtfTitulo.requestFocus();
                return;
            }

            if (titulo.length() > 70) {
                JOptionPane.showMessageDialog(this,
                        "El título no puede superar los 70 caracteres",
                        "Título muy largo",
                        JOptionPane.WARNING_MESSAGE);
                jtfTitulo.requestFocus();
                return;
            }

            PeliculaData peliData = new PeliculaData();
            Pelicula existe = peliData.buscarPelicula(titulo);

            if (existe != null) {
                JOptionPane.showMessageDialog(this,
                        "Ya existe una película con el título: " + titulo,
                        "Película duplicada",
                        JOptionPane.ERROR_MESSAGE);
                jtfTitulo.requestFocus();
                return;
            }

            LocalDate fechaEstreno = jdchooseEstreno.getDate()
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();

            LocalDate hoy = LocalDate.now();
            LocalDate hace100anios = hoy.minusYears(100);
            LocalDate en2anios = hoy.plusYears(2);

            if (fechaEstreno.isBefore(hace100anios)) {
                JOptionPane.showMessageDialog(this,
                        "La fecha de estreno no puede ser tan antigua",
                        "Fecha inválida",
                        JOptionPane.ERROR_MESSAGE);
                jdchooseEstreno.requestFocus();
                return;
            }

            if (fechaEstreno.isAfter(en2anios)) {
                JOptionPane.showMessageDialog(this,
                        "Solo se pueden registrar películas con hasta 2 años de anticipación",
                        "Fecha muy lejana",
                        JOptionPane.WARNING_MESSAGE);
                jdchooseEstreno.requestFocus();
                return;
            }

            if (this.rutaImagenSelec == null || this.rutaImagenSelec.isEmpty()) {
                int opcion = JOptionPane.showConfirmDialog(this,
                        "No ha seleccionado ninguna imagen.\n"
                        + "¿Desea continuar sin imagen?",
                        "Sin imagen",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);

                if (opcion == JOptionPane.NO_OPTION) {
                    jbSeleccionarArchivo.requestFocus();
                    return;
                }

                this.rutaImagenSelec = "src/img/default.jpg";
            }

            String director = jtfDirector.getText().trim();
            String genero = jtfGenero.getText().trim();
            String origen = jtfOrigen.getText().trim();
            String actores = jtfActores.getText().trim();
            Boolean cartelera = jRadioButtonCartelera.isSelected();

            Pelicula peli = new Pelicula(
                    titulo,
                    director,
                    actores,
                    origen,
                    genero,
                    fechaEstreno,
                    cartelera,
                    rutaImagenSelec
            );

            peliData.guardarPelicula(peli);

            JOptionPane.showMessageDialog(this,
                    "Película guardada exitosamente:\n\n"
                    + "Título: " + titulo + "\n"
                    + "Director: " + director + "\n"
                    + "Estreno: " + fechaEstreno + "\n"
                    + "En cartelera: " + (cartelera ? "Sí" : "No"),
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);

            limpiarCampos();
            this.rutaImagenSelec = null;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error al guardar la película:\n" + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }


    }//GEN-LAST:event_jbGuardar2ActionPerformed

    private void jRadioButtonCarteleraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCarteleraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonCarteleraActionPerformed

    private void jbSeleccionarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSeleccionarArchivoActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagenes (jpg, png, jpeg)", "jpg", "png", "jpeg");
        fileChooser.setFileFilter(filter);

        int resultado = fileChooser.showOpenDialog(this);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            try {
                File archivoOriginal = fileChooser.getSelectedFile();

                Path destino = Paths.get("src/img/" + archivoOriginal.getName());

                Files.copy(archivoOriginal.toPath(), destino, StandardCopyOption.REPLACE_EXISTING);

                this.rutaImagenSelec = "src/img/" + archivoOriginal.getName();

                JOptionPane.showMessageDialog(this, "Imagen seleccionada y copiada");

                ImageIcon icon = new ImageIcon(destino.toString());
                Image img = icon.getImage().getScaledInstance(jLabelImagen.getWidth(), jLabelImagen.getHeight(), Image.SCALE_SMOOTH);
                jLabelImagen.setIcon(new ImageIcon(img));

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al copiar la imagen" + e.getMessage());

            }
        }
    }//GEN-LAST:event_jbSeleccionarArchivoActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        // TODO add your handling code here:
        try {

            if (jtfTitulo.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Ingrese el título de la película a buscar",
                        "Campo vacío",
                        JOptionPane.WARNING_MESSAGE);
                jtfTitulo.requestFocus();
                return;
            }

            String titulo = jtfTitulo.getText().trim();

            PeliculaData peliData = new PeliculaData();
            Pelicula pelicula = peliData.buscarPelicula(titulo);

            if (pelicula == null) {
                JOptionPane.showMessageDialog(this,
                        "No se encontró ninguna película con el título:\n" + titulo,
                        "Película no encontrada",
                        JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
                jtfTitulo.setText(titulo);
                jtfTitulo.requestFocus();
                return;
            }

            jtfDirector.setText(pelicula.getDirector());
            jtfGenero.setText(pelicula.getGenero());
            jtfOrigen.setText(pelicula.getOrigen());
            jtfActores.setText(pelicula.getActores());
            jdchooseEstreno.setDate(java.sql.Date.valueOf(pelicula.getEstreno()));
            jRadioButtonCartelera.setSelected(pelicula.isCartelera());

            if (pelicula.getRutaImagen() != null && !pelicula.getRutaImagen().isEmpty()) {
                try {
                    ImageIcon icon = new ImageIcon(pelicula.getRutaImagen());
                    Image img = icon.getImage().getScaledInstance(
                            jLabelImagen.getWidth(),
                            jLabelImagen.getHeight(),
                            Image.SCALE_SMOOTH
                    );
                    jLabelImagen.setIcon(new ImageIcon(img));
                    this.rutaImagenSelec = pelicula.getRutaImagen();
                } catch (Exception e) {
                    System.out.println("No se pudo cargar la imagen");
                }
            }

            JOptionPane.showMessageDialog(this,
                    "Película encontrada:\n\n"
                    + "Título: " + pelicula.getTitulo() + "\n"
                    + "Director: " + pelicula.getDirector() + "\n"
                    + "Estreno: " + pelicula.getEstreno(),
                    "Película encontrada",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error al buscar la película:\n" + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        // TODO add your handling code here:
        try {

            if (jtfTitulo.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Primero debe buscar una película",
                        "Búsqueda requerida",
                        JOptionPane.WARNING_MESSAGE);
                jtfTitulo.requestFocus();
                return;
            }

            String titulo = jtfTitulo.getText().trim();

            PeliculaData peliData = new PeliculaData();
            Pelicula p = peliData.buscarPelicula(titulo);

            if (p == null) {
                JOptionPane.showMessageDialog(this,
                        "No se encontró la película: " + titulo + "\n\n"
                        + "Use el botón Buscar primero",
                        "Película no encontrada",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (jtfDirector.getText().trim().isEmpty()
                    || jtfGenero.getText().trim().isEmpty()
                    || jtfOrigen.getText().trim().isEmpty()
                    || jtfActores.getText().trim().isEmpty()
                    || jdchooseEstreno.getDate() == null) {

                JOptionPane.showMessageDialog(this,
                        "Todos los campos son obligatorios",
                        "Campos incompletos",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            int confirmacion = JOptionPane.showConfirmDialog(this,
                    "¿Está seguro de actualizar la película?\n\n"
                    + "Título: " + titulo,
                    "Confirmar actualización",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

            if (confirmacion != JOptionPane.YES_OPTION) {
                return;
            }

            p.setTitulo(jtfTitulo.getText().trim());
            p.setDirector(jtfDirector.getText().trim());
            p.setGenero(jtfGenero.getText().trim());
            p.setOrigen(jtfOrigen.getText().trim());
            p.setActores(jtfActores.getText().trim());

            LocalDate fechaEstreno = jdchooseEstreno.getDate()
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
            p.setEstreno(fechaEstreno);
            p.setCartelera(jRadioButtonCartelera.isSelected());

            if (rutaImagenSelec != null && !rutaImagenSelec.isEmpty()) {
                p.setRutaImagen(rutaImagenSelec);
            }

            peliData.actualizarPelicula(p);

            JOptionPane.showMessageDialog(this,
                    "Película actualizada exitosamente",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);

            limpiarCampos();
            this.rutaImagenSelec = null;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error al actualizar la película:\n" + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }


    }//GEN-LAST:event_jbActualizarActionPerformed

    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCerrarActionPerformed

    private void limpiarCampos() {
        jtfTitulo.setText("");
        jtfDirector.setText("");
        jtfGenero.setText("");
        jtfOrigen.setText("");
        jtfActores.setText("");
        jdchooseEstreno.setDate(null);
        jRadioButtonCartelera.setSelected(false);
        jLabelImagen.setIcon(null);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelActores;
    private javax.swing.JLabel jLabelCartelera;
    private javax.swing.JLabel jLabelGenero;
    private javax.swing.JLabel jLabelImagen;
    private javax.swing.JLabel jLabelOrigen;
    private javax.swing.JRadioButton jRadioButtonCartelera;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbGuardar2;
    private javax.swing.JButton jbSeleccionarArchivo;
    private com.toedter.calendar.JDateChooser jdchooseEstreno;
    private javax.swing.JLabel jlabelDirector;
    private javax.swing.JLabel jlabelTitulo;
    private javax.swing.JTextField jtfActores;
    private javax.swing.JTextField jtfDirector;
    private javax.swing.JTextField jtfGenero;
    private javax.swing.JTextField jtfOrigen;
    private javax.swing.JTextField jtfTitulo;
    private javax.swing.JLabel labelTitulo;
    // End of variables declaration//GEN-END:variables
}
