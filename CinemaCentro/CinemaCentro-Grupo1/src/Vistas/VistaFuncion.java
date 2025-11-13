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

/**
 *
 * @author arceb
 */
public class VistaFuncion extends javax.swing.JInternalFrame {

  
    FuncionData funcionData = new FuncionData();
    
    PeliculaData peliData = new PeliculaData();
    List<Pelicula> listaPelicula = peliData.listarPeliculasCartelera();
    SalaData salaData = new SalaData();
    List<Sala> listaSalas = salaData.listarSalas();
    
     
    
    
    public VistaFuncion() {
        initComponents();
        cargarPeliculas();
        cargarSalas();
       limpiarCampos();
        jButtonActualizar.setEnabled(false);
        jButtonEliminar.setEnabled(false);
        
        SpinnerNumberModel  horaModel = new SpinnerNumberModel(12, 0, 23, 1);
        jSpinnerHora.setModel(horaModel); 
        SpinnerNumberModel minutosModel = new SpinnerNumberModel(0, 0, 59, 1);
        jSpinnerMinutos.setModel(minutosModel);
        
        JSpinner.NumberEditor numEditor = new JSpinner.NumberEditor(jSpinnerMinutos, "00");
        jSpinnerMinutos.setEditor(numEditor);  
        JSpinner.NumberEditor numEditorHora = new JSpinner.NumberEditor(jSpinnerHora, "00");
        jSpinnerHora.setEditor(numEditorHora);
        
        //---------------------Spinner de horario fin----------------
        
        SpinnerNumberModel  horaModel2 = new SpinnerNumberModel(12, 0, 23, 1);
        jSpinnerHoraFin.setModel(horaModel2);      
         SpinnerNumberModel minutosModel2 = new SpinnerNumberModel(0, 0, 59, 1);
        jSpinnerMinutosFin.setModel(minutosModel2);
        
        
        JSpinner.NumberEditor numEditor2 = new JSpinner.NumberEditor(jSpinnerMinutosFin, "00");
        jSpinnerMinutosFin.setEditor(numEditor2);  
        JSpinner.NumberEditor numEditorHora2 = new JSpinner.NumberEditor(jSpinnerHoraFin, "00");
        jSpinnerHoraFin.setEditor(numEditorHora2);
        
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

        jLabel1.setText("Seleccionar pelicula");

        jLabel2.setText("Idioma:");

        jLabel3.setText("3d:");

        jLabel4.setText("Subtitulado:");

        jLabel5.setText("Horario de inicio:");

        jLabel6.setText("Horario de fin");

        jLabel7.setText("Sala:");

        jLabel8.setText("Precio:");

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

        jLabel9.setText("Id Funcion");

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
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel7))
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
                                .addComponent(jButtonEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)))
                        .addGap(77, 77, 77))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtoncerrar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                .addComponent(jButtonBuscar)))
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
            "Función encontrada:\n\n" +
            "Película: " + funcion.getPelicula().getTitulo() + "\n" +
            "Fecha: " + fecha + "\n" +
            "Sala: " + funcion.getSalaProyeccion().getNroSala(), 
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
   
        if (jComboPeliculas.getSelectedItem() == null || jComboPeliculas.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(this, 
                "Debe seleccionar una película", 
                "Campo obligatorio", 
                JOptionPane.WARNING_MESSAGE);
            jComboPeliculas.requestFocus();
            return;
        }
        
    
        if (jtfIdioma.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Debe ingresar el idioma", 
                "Campo obligatorio", 
                JOptionPane.WARNING_MESSAGE);
            jtfIdioma.requestFocus();
            return;
        }
        
        String idioma = jtfIdioma.getText().trim();
        if (!idioma.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
            JOptionPane.showMessageDialog(this, 
                "El idioma solo puede contener letras", 
                "Idioma inválido", 
                JOptionPane.ERROR_MESSAGE);
            jtfIdioma.requestFocus();
            return;
        }
        
     
        if (jdcHoraInicio.getDate() == null) {
            JOptionPane.showMessageDialog(this, 
                "Debe seleccionar una fecha para la función", 
                "Campo obligatorio", 
                JOptionPane.WARNING_MESSAGE);
            jdcHoraInicio.requestFocus();
            return;
        }
        
    
        if (jComboBoxSala.getSelectedItem() == null || jComboBoxSala.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(this, 
                "Debe seleccionar una sala", 
                "Campo obligatorio", 
                JOptionPane.WARNING_MESSAGE);
            jComboBoxSala.requestFocus();
            return;
        }
        
   
        if (jTextFieldPrecio.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Debe ingresar el precio", 
                "Campo obligatorio", 
                JOptionPane.WARNING_MESSAGE);
            jTextFieldPrecio.requestFocus();
            return;
        }
        
        double precio;
        try {
            precio = Double.parseDouble(jTextFieldPrecio.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "El precio debe ser un número válido", 
                "Precio inválido", 
                JOptionPane.ERROR_MESSAGE);
            jTextFieldPrecio.requestFocus();
            jTextFieldPrecio.selectAll();
            return;
        }
        
        if (precio <= 0) {
            JOptionPane.showMessageDialog(this, 
                "El precio debe ser mayor a cero", 
                "Precio inválido", 
                JOptionPane.ERROR_MESSAGE);
            jTextFieldPrecio.requestFocus();
            jTextFieldPrecio.selectAll();
            return;
        }
        
        if (precio > 100000) {
            JOptionPane.showMessageDialog(this, 
                "El precio parece demasiado alto\n" +
                "¿Está seguro del valor ingresado?", 
                "Verificar precio", 
                JOptionPane.WARNING_MESSAGE);
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
        
    
        if (inicio.isBefore(LocalDateTime.now())) {
            JOptionPane.showMessageDialog(this, 
                "No puede crear funciones en el pasado", 
                "Fecha inválida", 
                JOptionPane.ERROR_MESSAGE);
            jdcHoraInicio.requestFocus();
            return;
        }
        
       
        if (fin.isBefore(inicio) || fin.equals(inicio)) {
            JOptionPane.showMessageDialog(this, 
                "La hora de fin debe ser posterior a la hora de inicio", 
                "Horarios inválidos", 
                JOptionPane.ERROR_MESSAGE);
            jSpinnerHoraFin.requestFocus();
            return;
        }
        
   
        long minutos = java.time.Duration.between(inicio, fin).toMinutes();
        if (minutos < 30) {
            JOptionPane.showMessageDialog(this, 
                "La función debe durar al menos 30 minutos", 
                "Duración muy corta", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (minutos > 300) { 
            int confirmacion = JOptionPane.showConfirmDialog(this, 
                "La función dura " + minutos + " minutos (" + (minutos/60) + " horas)\n" +
                "¿Está seguro de esta duración?", 
                "Duración muy larga", 
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
            
            if (confirmacion != JOptionPane.YES_OPTION) {
                return;
            }
        }
        
      
        Sala sala = (Sala) jComboBoxSala.getSelectedItem();
        boolean es3d = jRadioButton3d.isSelected();
        
        if (es3d && !sala.isApto3d()) {
            JOptionPane.showMessageDialog(this, 
                "La sala seleccionada no está habilitada para 3D\n\n" +
                "Sala: " + sala.getNroSala() + " - No apta para 3D", 
                "Sala incompatible", 
                JOptionPane.ERROR_MESSAGE);
            jRadioButton3d.setSelected(false);
            return;
        }
        
    
        FuncionData funcionData = new FuncionData();
        List<Funcion> funcionesExistentes = funcionData.listarFuncionesPorFecha(fecha);
        
        for (Funcion f : funcionesExistentes) {
            if (f.getSalaProyeccion().getIdSala() == sala.getIdSala()) {
            
                if ((inicio.isBefore(f.getHoraFin()) && fin.isAfter(f.getHoraInicio()))) {
                    JOptionPane.showMessageDialog(this, 
                        "Conflicto de horarios detectado:\n\n" +
                        "Ya existe una función de \"" + f.getPelicula().getTitulo() + "\"\n" +
                        "en la Sala " + sala.getNroSala() + "\n" +
                        "Horario: " + f.getHoraInicio().format(DateTimeFormatter.ofPattern("HH:mm")) + 
                        " - " + f.getHoraFin().format(DateTimeFormatter.ofPattern("HH:mm")), 
                        "Conflicto de horarios", 
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }
        
 
        Pelicula pelicula = (Pelicula) jComboPeliculas.getSelectedItem();
        
        int confirmacion = JOptionPane.showConfirmDialog(this, 
            "¿Confirmar creación de función?\n\n" +
            "Película: " + pelicula.getTitulo() + "\n" +
            "Fecha: " + fecha + "\n" +
            "Horario: " + horaInicio + ":" + String.format("%02d", minutoInicio) + 
            " - " + horaFin + ":" + String.format("%02d", minutoFin) + "\n" +
            "Sala: " + sala.getNroSala() + "\n" +
            "Formato: " + (es3d ? "3D" : "2D") + "\n" +
            "Idioma: " + idioma + "\n" +
            "Precio: $" + precio, 
            "Confirmar creación", 
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        
        if (confirmacion != JOptionPane.YES_OPTION) {
            return;
        }
        
     
        Funcion funcion = new Funcion();
        funcion.setPelicula(pelicula);
        funcion.setIdioma(idioma);
        funcion.setEs3d(es3d);
        funcion.setSubtitulado(jRadioButtonSub.isSelected());
        funcion.setHoraInicio(inicio);
        funcion.setHoraFin(fin);
        funcion.setSalaProyeccion(sala);
        funcion.setPrecio(precio);
        
        funcionData.guardarFuncion(funcion);
        
        JOptionPane.showMessageDialog(this, 
            "Función creada exitosamente\n\n" +
            "Se crearon automáticamente los lugares disponibles", 
            "Éxito", 
            JOptionPane.INFORMATION_MESSAGE);
        
        limpiarCampos();
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, 
            "Error al crear la función:\n" + e.getMessage(), 
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
        
   
        if (jComboPeliculas.getSelectedItem() == null || 
            jtfIdioma.getText().trim().isEmpty() ||
            jdcHoraInicio.getDate() == null ||
            jComboBoxSala.getSelectedItem() == null ||
            jTextFieldPrecio.getText().trim().isEmpty()) {
            
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
            " ADVERTENCIA \n\n" +
            "¿Está seguro de eliminar la función #" + id + "?\n\n" +
            "Esta acción también eliminará:\n" +
            " Todos los lugares asociados\n" +
            " Los tickets vendidos para esta función\n\n" +
            "Esta acción NO se puede deshacer.", 
            "Confirmar eliminación", 
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE);
        
        if (confirmacion != JOptionPane.YES_OPTION) {
            return;
        }
        

        confirmacion = JOptionPane.showConfirmDialog(this, 
            "¿Está COMPLETAMENTE seguro?\n\n" +
            "Esta es su última oportunidad para cancelar.", 
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

    private void cargarPeliculas(){
        for (Pelicula peli : listaPelicula) {
            jComboPeliculas.addItem(peli);
        }
    
        
        
    }

    private void cargarSalas(){
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
