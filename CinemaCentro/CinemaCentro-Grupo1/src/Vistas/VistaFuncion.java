/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelo.Funcion;
import Modelo.Pelicula;
import Modelo.Sala;
import Persistencia.FuncionData;
import Persistencia.PeliculaData;
import Persistencia.SalaData;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JSpinner;

/**
 *
 * @author arceb
 */
public class VistaFuncion extends javax.swing.JInternalFrame {

    private Color COLOR_PRIMARIO = new Color(52, 152, 219);
    private Color COLOR_PRIMARIO_HOVER = new Color(41, 128, 185);
    private Color COLOR_EXITO = new Color(46, 204, 113);
    private Color COLOR_EXITO_HOVER = new Color(39, 174, 96);
    private Color COLOR_PELIGRO = new Color(231, 76, 60);
    private Color COLOR_PELIGRO_HOVER = new Color(192, 57, 43);
    private Color COLOR_SECUNDARIO = new Color(149, 165, 166);
    private Color COLOR_SECUNDARIO_HOVER = new Color(127, 140, 141);
    private Color COLOR_FONDO = new Color(236, 240, 241);

    FuncionData funcionData = new FuncionData();
  

    PeliculaData peliData = new PeliculaData();
    List<Pelicula> listaPelicula = peliData.listarPeliculasCartelera();
    SalaData salaData = new SalaData();
    List<Sala> listaSalas = salaData.listarSalas();

    public VistaFuncion() {
        initComponents();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        cargarPeliculas();
        cargarSalas();
        limpiarCampos();
        aplicarEstilos();
        jButtonActualizar.setEnabled(false);
        jButtonEliminar.setEnabled(false);

        SpinnerNumberModel horaModel = new SpinnerNumberModel(12, 0, 23, 1);
        jSpinnerHora.setModel(horaModel);
        SpinnerNumberModel minutosModel = new SpinnerNumberModel(0, 0, 59, 1);
        jSpinnerMinutos.setModel(minutosModel);

        JSpinner.NumberEditor numEditor = new JSpinner.NumberEditor(jSpinnerMinutos, "00");
        jSpinnerMinutos.setEditor(numEditor);
        JSpinner.NumberEditor numEditorHora = new JSpinner.NumberEditor(jSpinnerHora, "00");
        jSpinnerHora.setEditor(numEditorHora);

        //---------------------Spinner de horario fin----------------
        SpinnerNumberModel horaModel2 = new SpinnerNumberModel(12, 0, 23, 1);
        jSpinnerHoraFin.setModel(horaModel2);
        SpinnerNumberModel minutosModel2 = new SpinnerNumberModel(0, 0, 59, 1);
        jSpinnerMinutosFin.setModel(minutosModel2);

        JSpinner.NumberEditor numEditor2 = new JSpinner.NumberEditor(jSpinnerMinutosFin, "00");
        jSpinnerMinutosFin.setEditor(numEditor2);
        JSpinner.NumberEditor numEditorHora2 = new JSpinner.NumberEditor(jSpinnerHoraFin, "00");
        jSpinnerHoraFin.setEditor(numEditorHora2);

    }

    private void aplicarEstilos() {

        getContentPane().setBackground(COLOR_FONDO);

        Font fuenteLabel = new Font("Segoe UI", Font.BOLD, 13);
        Font fuenteTexto = new Font("Segoe UI", Font.PLAIN, 13);
        Font fuenteTitulo = new Font("Segoe UI", Font.BOLD, 14);

        estilizarLabel(jLabel1, fuenteLabel);
        estilizarLabel(jLabel2, fuenteLabel);
        estilizarLabel(jLabel3, fuenteLabel);
        estilizarLabel(jLabel4, fuenteLabel);
        estilizarLabel(jLabel5, fuenteLabel);
        estilizarLabel(jLabel6, fuenteLabel);
        estilizarLabel(jLabel7, fuenteLabel);
        estilizarLabel(jLabel8, fuenteLabel);
        estilizarLabel(jLabel9, fuenteTitulo);

        estilizarTextField(jtfIdioma, fuenteTexto);
        estilizarTextField(jTextFieldPrecio, fuenteTexto);
        estilizarTextField(jTextFieldID, fuenteTexto);

        estilizarComboBox(jComboPeliculas, fuenteTexto);
        estilizarComboBox(jComboBoxSala, fuenteTexto);

        estilizarRadioButton(jRadioButton3d, fuenteTexto);
        estilizarRadioButton(jRadioButtonSub, fuenteTexto);

        estilizarSpinner(jSpinnerHora);
        estilizarSpinner(jSpinnerMinutos);
        estilizarSpinner(jSpinnerHoraFin);
        estilizarSpinner(jSpinnerMinutosFin);

        jdcHoraInicio.setFont(fuenteTexto);
        jdcHoraInicio.setBackground(Color.WHITE);

        estilizarBotonModerno(jButtonCrear, "Crear", COLOR_EXITO, COLOR_EXITO_HOVER);
        estilizarBotonModerno(jButtonActualizar, "Actualizar", COLOR_PRIMARIO, COLOR_PRIMARIO_HOVER);
        estilizarBotonModerno(jButtonEliminar, "Eliminar", COLOR_PELIGRO, COLOR_PELIGRO_HOVER);
        estilizarBotonModerno(jButtoncerrar, "Cerrar", COLOR_SECUNDARIO, COLOR_SECUNDARIO_HOVER);

        jButtonBuscar.setBackground(COLOR_PRIMARIO);
        jButtonBuscar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButtonBuscar.setBorderPainted(false);
        jButtonBuscar.setFocusPainted(false);
        jButtonBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (jButtonBuscar.isEnabled()) {
                    jButtonBuscar.setBackground(COLOR_PRIMARIO_HOVER);
                }
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonBuscar.setBackground(COLOR_PRIMARIO);
            }
        });
    }

    private void estilizarLabel(javax.swing.JLabel label, Font fuente) {
        label.setFont(fuente);
        label.setForeground(new Color(44, 62, 80));
    }

    private void estilizarTextField(javax.swing.JTextField textField, Font fuente) {
        textField.setFont(fuente);
        textField.setForeground(new Color(44, 62, 80));
        textField.setBackground(Color.WHITE);
        textField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(189, 195, 199), 2),
                BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
        textField.setCaretColor(COLOR_PRIMARIO);
    }

    private void estilizarComboBox(javax.swing.JComboBox comboBox, Font fuente) {
        comboBox.setFont(fuente);
        comboBox.setForeground(new Color(44, 62, 80));
        comboBox.setBackground(Color.WHITE);
        comboBox.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(189, 195, 199), 2),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        comboBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void estilizarRadioButton(javax.swing.JRadioButton radioButton, Font fuente) {
        radioButton.setFont(fuente);
        radioButton.setForeground(new Color(44, 62, 80));
        radioButton.setBackground(COLOR_FONDO);
        radioButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        radioButton.setFocusPainted(false);
    }

    private void estilizarSpinner(javax.swing.JSpinner spinner) {
        spinner.setFont(new Font("Segoe UI", Font.BOLD, 14));
        JComponent editor = spinner.getEditor();
        if (editor instanceof JSpinner.DefaultEditor) {
            ((JSpinner.DefaultEditor) editor).getTextField().setFont(new Font("Segoe UI", Font.BOLD, 14));
            ((JSpinner.DefaultEditor) editor).getTextField().setForeground(new Color(44, 62, 80));
            ((JSpinner.DefaultEditor) editor).getTextField().setBackground(Color.WHITE);
            ((JSpinner.DefaultEditor) editor).getTextField().setHorizontalAlignment(javax.swing.JTextField.CENTER);
        }
        spinner.setBorder(BorderFactory.createLineBorder(new Color(189, 195, 199), 2));
        spinner.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void estilizarBotonModerno(JButton boton, String texto, Color colorNormal, Color colorHover) {
        boton.setText(texto);
        boton.setFont(new Font("Segoe UI", Font.BOLD, 12));
        boton.setForeground(Color.WHITE);
        boton.setBackground(colorNormal);
        boton.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
        boton.setBorderPainted(false);
        boton.setFocusPainted(false);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setOpaque(true);

        boton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (boton.isEnabled()) {
                    boton.setBackground(colorHover);
                }
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton.setBackground(colorNormal);
            }

            public void mousePressed(java.awt.event.MouseEvent evt) {
                if (boton.isEnabled()) {
                    boton.setBackground(colorHover.darker());
                }
            }

            public void mouseReleased(java.awt.event.MouseEvent evt) {
                if (boton.isEnabled()) {
                    boton.setBackground(colorHover);
                }
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboPeliculas = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfIdioma = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jRadioButton3d = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jRadioButtonSub = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jSpinnerHora = new javax.swing.JSpinner();
        jSpinnerMinutos = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jSpinnerHoraFin = new javax.swing.JSpinner();
        jSpinnerMinutosFin = new javax.swing.JSpinner();
        jdcHoraInicio = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxSala = new javax.swing.JComboBox<>();
        jTextFieldPrecio = new javax.swing.JTextField();
        jButtonCrear = new javax.swing.JButton();
        jButtonActualizar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jButtonBuscar = new javax.swing.JButton();
        jTextFieldID = new javax.swing.JTextField();
        jButtonEliminar = new javax.swing.JButton();
        jButtoncerrar = new javax.swing.JButton();

        jLabel1.setText("SELECCIONAR PELICULA");

        jLabel2.setText("IDIOMA");

        jLabel3.setText("3D");

        jLabel4.setText("SUBTITULADO");

        jLabel5.setText("HORARIO DE INICIO");

        jLabel6.setText("HORARIO DE FIN");

        jLabel7.setText("SALA");

        jLabel8.setText("PRECIO");

        jButtonCrear.setText("Crear");
        jButtonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearActionPerformed(evt);
            }
        });

        jButtonActualizar.setText("Actualizar");
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });

        jLabel9.setText("ID FUNCION");

        jButtonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa.png"))); // NOI18N
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jButtoncerrar.setText("Cerrar");
        jButtoncerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoncerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(76, 76, 76)
                        .addComponent(jdcHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSpinnerHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSpinnerMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBoxSala, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(jLabel6)
                                .addGap(76, 76, 76)
                                .addComponent(jSpinnerHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpinnerMinutosFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel2))
                                        .addGap(76, 76, 76)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jComboPeliculas, javax.swing.GroupLayout.Alignment.LEADING, 0, 241, Short.MAX_VALUE)
                                            .addComponent(jtfIdioma, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(317, 317, 317))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(jLabel4)
                                .addGap(76, 76, 76)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton3d, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRadioButtonSub, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonActualizar)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButtonCrear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
                            .addComponent(jButtoncerrar, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(77, 77, 77))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonBuscar)
                        .addGap(17, 17, 17))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jComboPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jRadioButton3d, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonSub, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jSpinnerHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSpinnerMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonCrear))
                    .addComponent(jdcHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jSpinnerHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinnerMinutosFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonActualizar)
                        .addGap(45, 45, 45)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBoxSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEliminar))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtoncerrar))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed

        try {

            if (jTextFieldID.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Ingrese el ID de la función a buscar",
                        "Campo vacío",
                        JOptionPane.WARNING_MESSAGE);
                jTextFieldID.requestFocus();
                return;
            }

            int id;
            try {
                id = Integer.parseInt(jTextFieldID.getText().trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this,
                        "El ID debe ser un número válido",
                        "ID inválido",
                        JOptionPane.ERROR_MESSAGE);
                jTextFieldID.requestFocus();
                jTextFieldID.selectAll();
                return;
            }

            if (id <= 0) {
                JOptionPane.showMessageDialog(this,
                        "El ID debe ser un número positivo",
                        "ID inválido",
                        JOptionPane.ERROR_MESSAGE);
                jTextFieldID.requestFocus();
                jTextFieldID.selectAll();
                return;
            }

            FuncionData funcionData = new FuncionData();
            Funcion funcion = funcionData.buscarFuncion(id);

            if (funcion == null) {
                JOptionPane.showMessageDialog(this,
                        "No se encontró ninguna función con el ID: " + id,
                        "Función no encontrada",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            jComboPeliculas.setSelectedItem(funcion.getPelicula());
            jtfIdioma.setText(funcion.getIdioma());
            jRadioButton3d.setSelected(funcion.isEs3d());
            jRadioButtonSub.setSelected(funcion.isSubtitulado());

            LocalDate fecha = funcion.getHoraInicio().toLocalDate();
            jdcHoraInicio.setDate(java.sql.Date.valueOf(fecha));

            jSpinnerHora.setValue(funcion.getHoraInicio().getHour());
            jSpinnerMinutos.setValue(funcion.getHoraInicio().getMinute());
            jSpinnerHoraFin.setValue(funcion.getHoraFin().getHour());
            jSpinnerMinutosFin.setValue(funcion.getHoraFin().getMinute());

            jComboBoxSala.setSelectedItem(funcion.getSalaProyeccion());
            jTextFieldPrecio.setText(String.valueOf(funcion.getPrecio()));

            jButtonActualizar.setEnabled(true);
            jButtonEliminar.setEnabled(true);

            JOptionPane.showMessageDialog(this,
                    "Función encontrada:\n\n"
                    + "Película: " + funcion.getPelicula().getTitulo() + "\n"
                    + "Fecha: " + fecha + "\n"
                    + "Sala: " + funcion.getSalaProyeccion().getNroSala(),
                    "Función encontrada",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error al buscar la función:\n" + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearActionPerformed
        // TODO add your handling code here:
       try {
      
        if (jComboPeliculas.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(this,
                    "Por favor seleccione una película",
                    "Película no seleccionada",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        
       
        if (jComboBoxSala.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(this,
                    "Por favor seleccione una sala",
                    "Sala no seleccionada",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        
     
        if (jtfIdioma.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Por favor ingrese el idioma de la función",
                    "Idioma vacío",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        
       
        if (jdcHoraInicio.getDate() == null) {
            JOptionPane.showMessageDialog(this,
                    "Por favor seleccione la fecha de inicio",
                    "Fecha no seleccionada",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        
     
        if (jTextFieldPrecio.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Por favor ingrese el precio",
                    "Precio vacío",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        
      
        double precio = Double.parseDouble(jTextFieldPrecio.getText().trim());
        
     
        if (precio <= 0) {
            JOptionPane.showMessageDialog(this,
                    "El precio debe ser mayor a cero",
                    "Precio inválido",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
      
        Pelicula peliculaSelec = (Pelicula) jComboPeliculas.getSelectedItem();
        Sala salaSelec = (Sala) jComboBoxSala.getSelectedItem();
        String idioma = jtfIdioma.getText().trim();
        boolean es3d = jRadioButton3d.isSelected();
        boolean subtitulado = jRadioButtonSub.isSelected();
        
     
        LocalDate fechaInicio = jdcHoraInicio.getDate().toInstant()
                .atZone(ZoneId.systemDefault()).toLocalDate();
        
        int horaInicio = (Integer) jSpinnerHora.getValue();
        int minutosInicio = (Integer) jSpinnerMinutos.getValue();
        
        LocalDateTime horaInicioCompleta = LocalDateTime.of(
                fechaInicio.getYear(),
                fechaInicio.getMonth(),
                fechaInicio.getDayOfMonth(),
                horaInicio,
                minutosInicio
        );
        
     
        int horaFin = (Integer) jSpinnerHoraFin.getValue();
        int minutosFin = (Integer) jSpinnerMinutosFin.getValue();
        
        LocalDateTime horaFinCompleta = LocalDateTime.of(
                fechaInicio.getYear(),
                fechaInicio.getMonth(),
                fechaInicio.getDayOfMonth(),
                horaFin,
                minutosFin
        );
        
      
        if (horaFinCompleta.isBefore(horaInicioCompleta)) {
            horaFinCompleta = horaFinCompleta.plusDays(1);
        }
        
     
        if (horaFinCompleta.isBefore(horaInicioCompleta) || horaFinCompleta.equals(horaInicioCompleta)) {
            JOptionPane.showMessageDialog(this,
                    "La hora de fin debe ser posterior a la hora de inicio",
                    "Horarios inválidos",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
       
        if (horaInicioCompleta.isBefore(LocalDateTime.now())) {
            int opcion = JOptionPane.showConfirmDialog(this,
                    "La fecha/hora de inicio es en el pasado.\n" +
                    "¿Está seguro de continuar?",
                    "Fecha en el pasado",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);
            
            if (opcion != JOptionPane.YES_OPTION) {
                return;
            }
        }
        
       
        if (es3d && !salaSelec.isApto3d()) {
            JOptionPane.showMessageDialog(this,
                    "La sala " + salaSelec.getNroSala() + " NO es apta para funciones 3D.\n" +
                    "Por favor seleccione otra sala o desmaque la opción 3D.",
                    "Sala no apta para 3D",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
     
        long duracionMinutos = java.time.Duration.between(horaInicioCompleta, horaFinCompleta).toMinutes();
        
        if (duracionMinutos < 30) {
            JOptionPane.showMessageDialog(this,
                    "La duración de la función debe ser al menos 30 minutos",
                    "Duración muy corta",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (duracionMinutos > 300) {
            JOptionPane.showMessageDialog(this,
                    "La duración de la función no puede superar las 5 horas",
                    "Duración muy larga",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        
    
        StringBuilder confirmacion = new StringBuilder();
        confirmacion.append("¿Confirmar creación de función?\n\n");
        confirmacion.append("═══════════════════════════════════════\n");
        confirmacion.append("Película: ").append(peliculaSelec.getTitulo()).append("\n");
        confirmacion.append("Sala: ").append(salaSelec.getNroSala()).append("\n");
        confirmacion.append("Idioma: ").append(idioma).append("\n");
        confirmacion.append("Tipo: ").append(es3d ? "3D" : "2D").append("\n");
        confirmacion.append("Subtitulada: ").append(subtitulado ? "Sí" : "No").append("\n");
        confirmacion.append("Inicio: ").append(horaInicioCompleta.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))).append("\n");
        confirmacion.append("Fin: ").append(horaFinCompleta.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))).append("\n");
        confirmacion.append("Duración: ").append(duracionMinutos).append(" minutos\n");
        confirmacion.append("Precio: $").append(String.format("%.2f", precio)).append("\n");
        confirmacion.append("═══════════════════════════════════════\n\n");
        confirmacion.append("Se crearán automáticamente ").append(salaSelec.getCapacidad()).append(" lugares.");
        
        int opcion = JOptionPane.showConfirmDialog(this,
                confirmacion.toString(),
                "Confirmar Función",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        
        if (opcion != JOptionPane.YES_OPTION) {
            return;
        }
        
      
        
        System.out.println("=== GUARDANDO NUEVA FUNCIÓN ===");
        System.out.println("Película ID: " + peliculaSelec.getIdPelicula());
        System.out.println("Sala ID: " + salaSelec.getIdSala());
        
    
        Funcion nuevaFuncion = new Funcion();
        nuevaFuncion.setPelicula(peliculaSelec);
        nuevaFuncion.setSalaProyeccion(salaSelec);
        nuevaFuncion.setIdioma(idioma);
        nuevaFuncion.setEs3d(es3d);
        nuevaFuncion.setSubtitulado(subtitulado);
        nuevaFuncion.setHoraInicio(horaInicioCompleta);
        nuevaFuncion.setHoraFin(horaFinCompleta);
        nuevaFuncion.setPrecio(precio);
        
 
        funcionData.guardarFuncion(nuevaFuncion);
        
        System.out.println("Función guardada con ID: " + nuevaFuncion.getIdFuncion());
        System.out.println("=== GUARDADO COMPLETADO ===");
        
    
        JOptionPane.showMessageDialog(this,
                " Función creada exitosamente!\n\n" +
                "ID Función: " + nuevaFuncion.getIdFuncion() + "\n" +
                "Película: " + peliculaSelec.getTitulo() + "\n" +
                "Sala: " + salaSelec.getNroSala() + "\n" +
                "Horario: " + horaInicioCompleta.format(DateTimeFormatter.ofPattern("dd/MM HH:mm")) + "\n" +
                "Lugares creados: " + salaSelec.getCapacidad(),
                "Función Guardada",
                JOptionPane.INFORMATION_MESSAGE);
        
       
        limpiarFormulario();
        
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this,
                "Error en el formato del precio.\n" +
                "Por favor ingrese solo números (ejemplo: 5000.00)",
                "Error de formato",
                JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
                "❌ Error al guardar la función:\n" + e.getMessage() + "\n\n" +
                "Por favor, intente nuevamente o contacte al administrador.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }


    }//GEN-LAST:event_jButtonCrearActionPerformed

    private void jButtoncerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoncerrarActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this,
                "¿Desea cerrar esta ventana?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_jButtoncerrarActionPerformed

    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed
        try {

            if (jTextFieldID.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Primero debe buscar una función por ID",
                        "Búsqueda requerida",
                        JOptionPane.WARNING_MESSAGE);
                jTextFieldID.requestFocus();
                return;
            }

            int id = Integer.parseInt(jTextFieldID.getText().trim());

            if (jComboPeliculas.getSelectedItem() == null
                    || jtfIdioma.getText().trim().isEmpty()
                    || jdcHoraInicio.getDate() == null
                    || jComboBoxSala.getSelectedItem() == null
                    || jTextFieldPrecio.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(this,
                        "Todos los campos son obligatorios",
                        "Campos incompletos",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            Date fechaSeleccionada = jdcHoraInicio.getDate();
            LocalDate fecha = fechaSeleccionada.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();

            int horaInicio = (Integer) jSpinnerHora.getValue();
            int minutoInicio = (Integer) jSpinnerMinutos.getValue();
            int horaFin = (Integer) jSpinnerHoraFin.getValue();
            int minutoFin = (Integer) jSpinnerMinutosFin.getValue();

            LocalDateTime inicio = LocalDateTime.of(fecha, java.time.LocalTime.of(horaInicio, minutoInicio));
            LocalDateTime fin = LocalDateTime.of(fecha, java.time.LocalTime.of(horaFin, minutoFin));

            if (fin.isBefore(inicio) || fin.equals(inicio)) {
                JOptionPane.showMessageDialog(this,
                        "La hora de fin debe ser posterior a la hora de inicio",
                        "Horarios inválidos",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            int confirmacion = JOptionPane.showConfirmDialog(this,
                    "¿Está seguro de actualizar la función #" + id + "?",
                    "Confirmar actualización",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

            if (confirmacion != JOptionPane.YES_OPTION) {
                return;
            }

            Funcion funcion = new Funcion();
            funcion.setIdFuncion(id);
            funcion.setPelicula((Pelicula) jComboPeliculas.getSelectedItem());
            funcion.setIdioma(jtfIdioma.getText().trim());
            funcion.setEs3d(jRadioButton3d.isSelected());
            funcion.setSubtitulado(jRadioButtonSub.isSelected());
            funcion.setHoraInicio(inicio);
            funcion.setHoraFin(fin);
            funcion.setSalaProyeccion((Sala) jComboBoxSala.getSelectedItem());
            funcion.setPrecio(Double.parseDouble(jTextFieldPrecio.getText().trim()));

            FuncionData funcionData = new FuncionData();
            funcionData.actualizarFuncion(funcion);

            JOptionPane.showMessageDialog(this,
                    "Función actualizada exitosamente",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);

            limpiarCampos();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error al actualizar la función:\n" + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }


    }//GEN-LAST:event_jButtonActualizarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed

        try {

            if (jTextFieldID.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Ingrese el ID de la función a eliminar",
                        "Campo vacío",
                        JOptionPane.WARNING_MESSAGE);
                jTextFieldID.requestFocus();
                return;
            }

            int id = Integer.parseInt(jTextFieldID.getText().trim());

            int confirmacion = JOptionPane.showConfirmDialog(this,
                    " ADVERTENCIA \n\n"
                    + "¿Está seguro de eliminar la función #" + id + "?\n\n"
                    + "Esta acción también eliminará:\n"
                    + " Todos los lugares asociados\n"
                    + " Los tickets vendidos para esta función\n\n"
                    + "Esta acción NO se puede deshacer.",
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);

            if (confirmacion != JOptionPane.YES_OPTION) {
                return;
            }

            confirmacion = JOptionPane.showConfirmDialog(this,
                    "¿Está COMPLETAMENTE seguro?\n\n"
                    + "Esta es su última oportunidad para cancelar.",
                    "Última confirmación",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.ERROR_MESSAGE);

            if (confirmacion != JOptionPane.YES_OPTION) {
                return;
            }

            FuncionData funcionData = new FuncionData();
            funcionData.eliminarFuncion(id);

            JOptionPane.showMessageDialog(this,
                    "Función eliminada correctamente",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);

            limpiarCampos();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error al eliminar la función:\n" + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }


    }//GEN-LAST:event_jButtonEliminarActionPerformed

private void limpiarFormulario() {
    jTextFieldID.setText("");
    jComboPeliculas.setSelectedIndex(-1);
    jComboBoxSala.setSelectedIndex(-1);
    jtfIdioma.setText("");
    jRadioButton3d.setSelected(false);
    jRadioButtonSub.setSelected(false);
    jdcHoraInicio.setDate(null);
    jSpinnerHora.setValue(0);
    jSpinnerMinutos.setValue(0);
    jSpinnerHoraFin.setValue(0);
    jSpinnerMinutosFin.setValue(0);
    jTextFieldPrecio.setText("");
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCrear;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtoncerrar;
    private javax.swing.JComboBox<Sala> jComboBoxSala;
    private javax.swing.JComboBox<Pelicula> jComboPeliculas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton3d;
    private javax.swing.JRadioButton jRadioButtonSub;
    private javax.swing.JSpinner jSpinnerHora;
    private javax.swing.JSpinner jSpinnerHoraFin;
    private javax.swing.JSpinner jSpinnerMinutos;
    private javax.swing.JSpinner jSpinnerMinutosFin;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldPrecio;
    private com.toedter.calendar.JDateChooser jdcHoraInicio;
    private javax.swing.JTextField jtfIdioma;
    // End of variables declaration//GEN-END:variables

    private void cargarPeliculas() {
        for (Pelicula peli : listaPelicula) {
            jComboPeliculas.addItem(peli);
        }

    }

    private void cargarSalas() {
        for (Sala salita : listaSalas) {
            jComboBoxSala.addItem(salita);
        }

    }

    private void limpiarCampos() {

        jTextFieldID.setText("");
        jtfIdioma.setText("");
        jTextFieldPrecio.setText("");

        jComboPeliculas.setSelectedIndex(-1);
        jComboBoxSala.setSelectedIndex(-1);

        jRadioButton3d.setSelected(false);
        jRadioButtonSub.setSelected(false);

        jdcHoraInicio.setDate(null);

        jSpinnerHora.setValue(0);
        jSpinnerMinutos.setValue(0);
        jSpinnerHoraFin.setValue(0);
        jSpinnerMinutosFin.setValue(0);
    }
}
