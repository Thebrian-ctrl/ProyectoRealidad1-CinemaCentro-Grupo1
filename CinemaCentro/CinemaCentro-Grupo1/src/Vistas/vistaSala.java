/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelo.Funcion;
import Modelo.Sala;
import Persistencia.FuncionData;
import Persistencia.SalaData;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author paula
 */
public class vistaSala extends javax.swing.JInternalFrame {

 
    public vistaSala() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jBuscar = new javax.swing.JButton();
        jTextID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextNroSala = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jRadio3d = new javax.swing.JRadioButton();
        jCapacidad = new javax.swing.JSpinner();
        jRadioEstado = new javax.swing.JRadioButton();
        jBCrear = new javax.swing.JButton();
        jBActualizar = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Salas");

        jLabel2.setText("ID Sala: ");

        jBuscar.setText("Buscar");
        jBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBuscarActionPerformed(evt);
            }
        });

        jLabel3.setText("Numero de Sala:");

        jLabel4.setText("Apta para 3D:");

        jLabel5.setText("Capacidad:");

        jLabel6.setText("Estado:");

        jRadio3d.setText("SI");

        jRadioEstado.setText("Activo");

        jBCrear.setText("Crear");
        jBCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCrearActionPerformed(evt);
            }
        });

        jBActualizar.setText("Actualizar");
        jBActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActualizarActionPerformed(evt);
            }
        });

        jBEliminar.setText("Eliminar");
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });

        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextID, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextNroSala)
                                    .addComponent(jCapacidad)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jRadio3d)
                                            .addComponent(jRadioEstado))
                                        .addGap(0, 51, Short.MAX_VALUE)))))
                        .addGap(18, 18, 18)
                        .addComponent(jBuscar)
                        .addGap(37, 37, 37))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBCrear)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jBActualizar)
                                .addGap(34, 34, 34)))
                        .addComponent(jBEliminar)
                        .addGap(66, 66, 66))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBSalir)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jBuscar)
                    .addComponent(jTextID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextNroSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jRadio3d))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jRadioEstado))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBCrear)
                    .addComponent(jBActualizar)
                    .addComponent(jBEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jBSalir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBuscarActionPerformed
    try {
       
        if (jTextID.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Ingrese el ID de la sala a buscar", 
                "Campo vacío", 
                JOptionPane.WARNING_MESSAGE);
            jTextID.requestFocus();
            return;
        }
        
   
        int id;
        try {
            id = Integer.parseInt(jTextID.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "El ID debe ser un número válido", 
                "ID inválido", 
                JOptionPane.ERROR_MESSAGE);
            jTextID.requestFocus();
            jTextID.selectAll();
            return;
        }
        
        if (id <= 0) {
            JOptionPane.showMessageDialog(this, 
                "El ID debe ser un número positivo", 
                "ID inválido", 
                JOptionPane.ERROR_MESSAGE);
            jTextID.requestFocus();
            jTextID.selectAll();
            return;
        }
        
     
        SalaData salaData = new SalaData();
        Sala sala = salaData.buscarSala(id);
        
        if (sala == null) {
            JOptionPane.showMessageDialog(this, 
                "No se encontró ninguna sala con el ID: " + id, 
                "Sala no encontrada", 
                JOptionPane.INFORMATION_MESSAGE);
            return;
        }
     
        jTextNroSala.setText(String.valueOf(sala.getNroSala()));
        jCapacidad.setValue(sala.getCapacidad());
        jRadio3d.setSelected(sala.isApto3d());
        jRadioEstado.setSelected(sala.isEstado());
        
        JOptionPane.showMessageDialog(this, 
            "Sala encontrada:\n\n" +
            "Sala #" + sala.getNroSala() + "\n" +
            "Capacidad: " + sala.getCapacidad() + " asientos\n" +
            "3D: " + (sala.isApto3d() ? "Sí" : "No") + "\n" +
            "Estado: " + (sala.isEstado() ? "Activa" : "Inactiva"), 
            "Sala encontrada", 
            JOptionPane.INFORMATION_MESSAGE);
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, 
            "Error al buscar la sala:\n" + e.getMessage(), 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }

         
    }//GEN-LAST:event_jBuscarActionPerformed

    private void jBCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCrearActionPerformed
       
   try {
     
        if (jTextNroSala.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Debe ingresar el número de sala", 
                "Campo obligatorio", 
                JOptionPane.WARNING_MESSAGE);
            jTextNroSala.requestFocus();
            return;
        }
        
     
        int numero;
        try {
            numero = Integer.parseInt(jTextNroSala.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "El número de sala debe ser un número válido", 
                "Número inválido", 
                JOptionPane.ERROR_MESSAGE);
            jTextNroSala.requestFocus();
            jTextNroSala.selectAll();
            return;
        }
        
        if (numero <= 0) {
            JOptionPane.showMessageDialog(this, 
                "El número de sala debe ser mayor a 0", 
                "Número inválido", 
                JOptionPane.ERROR_MESSAGE);
            jTextNroSala.requestFocus();
            jTextNroSala.selectAll();
            return;
        }
        
        if (numero > 50) {
            JOptionPane.showMessageDialog(this, 
                "El número de sala no puede ser mayor a 50", 
                "Número muy alto", 
                JOptionPane.WARNING_MESSAGE);
            jTextNroSala.requestFocus();
            jTextNroSala.selectAll();
            return;
        }
        
       
        SalaData salaData = new SalaData();
        
        if (salaData.existeNumeroSala(numero)) {
            JOptionPane.showMessageDialog(this, 
                "Ya existe una sala con el número " + numero + "\n\n" +
                "Por favor, elija otro número", 
                "Sala duplicada", 
                JOptionPane.ERROR_MESSAGE);
            jTextNroSala.requestFocus();
            jTextNroSala.selectAll();
            return;
        }
        
     
        int capacidad = (Integer) jCapacidad.getValue();
        
        if (capacidad <= 0) {
            JOptionPane.showMessageDialog(this, 
                "La capacidad debe ser mayor a 0", 
                "Capacidad inválida", 
                JOptionPane.ERROR_MESSAGE);
            jCapacidad.requestFocus();
            return;
        }
        
        if (capacidad < 10) {
            int confirmacion = JOptionPane.showConfirmDialog(this, 
                "La capacidad es muy baja (" + capacidad + " asientos)\n" +
                "¿Está seguro de continuar?", 
                "Capacidad baja", 
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
            
            if (confirmacion != JOptionPane.YES_OPTION) {
                jCapacidad.requestFocus();
                return;
            }
        }
        
        if (capacidad > 500) {
            int confirmacion = JOptionPane.showConfirmDialog(this, 
                "La capacidad es muy alta (" + capacidad + " asientos)\n" +
                "¿Está seguro de continuar?", 
                "Capacidad alta", 
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
            
            if (confirmacion != JOptionPane.YES_OPTION) {
                jCapacidad.requestFocus();
                return;
            }
        }
        

        boolean apto3D = jRadio3d.isSelected();
        
        if (apto3D && capacidad < 50) {
            int confirmacion = JOptionPane.showConfirmDialog(this, 
                "Las salas 3D generalmente tienen mayor capacidad\n" +
                "Capacidad actual: " + capacidad + " asientos\n\n" +
                "¿Desea continuar de todos modos?", 
                "Advertencia 3D", 
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
            
            if (confirmacion != JOptionPane.YES_OPTION) {
                return;
            }
        }
        
  
        boolean estado = jRadioEstado.isSelected();
        
        int confirmacion = JOptionPane.showConfirmDialog(this, 
            "¿Confirmar creación de sala?\n\n" +
            "Número de sala: " + numero + "\n" +
            "Capacidad: " + capacidad + " asientos\n" +
            "Apta para 3D: " + (apto3D ? "Sí" : "No") + "\n" +
            "Estado: " + (estado ? "Activa" : "Inactiva"), 
            "Confirmar creación", 
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        
        if (confirmacion != JOptionPane.YES_OPTION) {
            return;
        }
        
     
        Sala nuevaSala = new Sala();
        nuevaSala.setNroSala(numero);
        nuevaSala.setApto3d(apto3D);
        nuevaSala.setCapacidad(capacidad);
        nuevaSala.setEstado(estado);
        
        salaData.guardarSala(nuevaSala);
        
        JOptionPane.showMessageDialog(this, 
            "Sala creada exitosamente\n\n" +
            "Sala #" + numero + "\n" +
            "Capacidad: " + capacidad + " asientos\n" +
            "3D: " + (apto3D ? "Sí" : "No"), 
            "Éxito", 
            JOptionPane.INFORMATION_MESSAGE);
        
        limpiarCampos();
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, 
            "Error al crear la sala:\n" + e.getMessage(), 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
    }//GEN-LAST:event_jBCrearActionPerformed

    private void jBActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActualizarActionPerformed
       
       try {
        // ========== VALIDACIÓN 1: Sala buscada ==========
        if (jTextID.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Primero debe buscar una sala por ID", 
                "Búsqueda requerida", 
                JOptionPane.WARNING_MESSAGE);
            jTextID.requestFocus();
            return;
        }
        
        int id = Integer.parseInt(jTextID.getText().trim());
        

        if (jTextNroSala.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "El número de sala es obligatorio", 
                "Campo vacío", 
                JOptionPane.WARNING_MESSAGE);
            jTextNroSala.requestFocus();
            return;
        }
        
        int numero = Integer.parseInt(jTextNroSala.getText().trim());
        
        if (numero <= 0) {
            JOptionPane.showMessageDialog(this, 
                "El número de sala debe ser mayor a 0", 
                "Número inválido", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
     
        SalaData salaData = new SalaData();
        
        if (salaData.existeNumeroSalaExcluyendoId(numero, id)) {
            JOptionPane.showMessageDialog(this, 
                "Ya existe otra sala con el número " + numero, 
                "Número duplicado", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
   
        int capacidad = (Integer) jCapacidad.getValue();
        
        if (capacidad <= 0) {
            JOptionPane.showMessageDialog(this, 
                "La capacidad debe ser mayor a 0", 
                "Capacidad inválida", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
  
        Sala salaActual = salaData.buscarSala(id);
        if (salaActual != null && salaActual.getCapacidad() != capacidad) {
            int confirmacion = JOptionPane.showConfirmDialog(this, 
                " ADVERTENCIA \n\n" +
                "Está cambiando la capacidad de la sala\n" +
                "Capacidad anterior: " + salaActual.getCapacidad() + " asientos\n" +
                "Capacidad nueva: " + capacidad + " asientos\n\n" +
                "Esto podría afectar las funciones ya programadas.\n" +
                "¿Desea continuar?", 
                "Cambio de capacidad", 
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
            
            if (confirmacion != JOptionPane.YES_OPTION) {
                return;
            }
        }
        
     
        boolean apto3D = jRadio3d.isSelected();
        boolean estado = jRadioEstado.isSelected();
        
        int confirmacion = JOptionPane.showConfirmDialog(this, 
            "¿Está seguro de actualizar la sala #" + id + "?\n\n" +
            "Número: " + numero + "\n" +
            "Capacidad: " + capacidad + "\n" +
            "3D: " + (apto3D ? "Sí" : "No") + "\n" +
            "Estado: " + (estado ? "Activa" : "Inactiva"), 
            "Confirmar actualización", 
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        
        if (confirmacion != JOptionPane.YES_OPTION) {
            return;
        }
        
    
        Sala sala = new Sala();
        sala.setIdSala(id);
        sala.setNroSala(numero);
        sala.setApto3d(apto3D);
        sala.setCapacidad(capacidad);
        sala.setEstado(estado);
        
        salaData.actualizarSala(sala);
        
        JOptionPane.showMessageDialog(this, 
            "Sala actualizada exitosamente", 
            "Éxito", 
            JOptionPane.INFORMATION_MESSAGE);
        
        limpiarCampos();
        
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, 
            "Verifique que todos los campos numéricos sean válidos", 
            "Error de formato", 
            JOptionPane.ERROR_MESSAGE);
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, 
            "Error al actualizar la sala:\n" + e.getMessage(), 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
    }//GEN-LAST:event_jBActualizarActionPerformed

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        
      try {
    
        if (jTextID.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Ingrese el ID de la sala a eliminar", 
                "Campo vacío", 
                JOptionPane.WARNING_MESSAGE);
            jTextID.requestFocus();
            return;
        }
        
        int id = Integer.parseInt(jTextID.getText().trim());
        
    
        SalaData salaData = new SalaData();
        Sala sala = salaData.buscarSala(id);
        
        if (sala == null) {
            JOptionPane.showMessageDialog(this, 
                "No se encontró ninguna sala con el ID: " + id, 
                "Sala no encontrada", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
    
        FuncionData funcionData = new FuncionData();
        List<Funcion> funciones = funcionData.listarFuncion();
        
        int funcionesEnSala = 0;
        for (Funcion f : funciones) {
            if (f.getSalaProyeccion().getIdSala() == id) {
                funcionesEnSala++;
            }
        }
        
        if (funcionesEnSala > 0) {
            JOptionPane.showMessageDialog(this, 
                "ADVERTENCIA \n\n" +
                "No se puede eliminar la sala porque tiene\n" +
                funcionesEnSala + " función(es) programada(s)\n\n" +
                "Primero debe eliminar las funciones asociadas\n" +
                "o puede dar de baja la sala en su lugar.", 
                "Sala en uso", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
   
        int confirmacion = JOptionPane.showConfirmDialog(this, 
            " ADVERTENCIA \n\n" +
            "¿Está seguro de eliminar la Sala #" + sala.getNroSala() + "?\n\n" +
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
        
    
        salaData.eliminarSala(id);
        
        JOptionPane.showMessageDialog(this, 
            "Sala eliminada correctamente", 
            "Éxito", 
            JOptionPane.INFORMATION_MESSAGE);
        
        limpiarCampos();
        
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, 
            "El ID debe ser un número válido", 
            "Error de formato", 
            JOptionPane.ERROR_MESSAGE);
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, 
            "Error al eliminar la sala:\n" + e.getMessage(), 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
    }//GEN-LAST:event_jBEliminarActionPerformed

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBActualizar;
    private javax.swing.JButton jBCrear;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBSalir;
    private javax.swing.JButton jBuscar;
    private javax.swing.JSpinner jCapacidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JRadioButton jRadio3d;
    private javax.swing.JRadioButton jRadioEstado;
    private javax.swing.JTextField jTextID;
    private javax.swing.JTextField jTextNroSala;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
    jTextID.setText("");
    jTextNroSala.setText("");
    jRadio3d.setSelected(false);
    jCapacidad.setValue(0); 
    jRadioEstado.setSelected(false);
    
}



}
