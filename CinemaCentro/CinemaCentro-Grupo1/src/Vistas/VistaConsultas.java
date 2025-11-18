/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelo.Funcion;
import Modelo.Lugar;
import Modelo.Pelicula;
import Modelo.Sala;
import Persistencia.FuncionData;
import Persistencia.LugarData;
import Persistencia.PeliculaData;
import Persistencia.SalaData;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.BorderFactory;
import javax.swing.JButton;



public class VistaConsultas extends javax.swing.JInternalFrame {
private FuncionData funcionData;
private PeliculaData peliculaData;
private SalaData salaData;
private LugarData lugarData;
  
    public VistaConsultas() {
        initComponents();
    inicializar();
    aplicarEstilos ();
}

private void inicializar() {
    funcionData = new FuncionData();
    peliculaData = new PeliculaData();
    salaData = new SalaData();
    lugarData = new LugarData();
    
    setClosable(true);
    setIconifiable(true);
    setMaximizable(true);
    setResizable(true);
    
    txtResultado.setEditable(false);
    txtResultado.setText("Seleccione una opción de consulta...");

    }
private void aplicarEstilos() {
    // Colores
    Color colorPrimario = new Color(41, 128, 185);      
    Color colorSecundario = new Color(52, 73, 94);      
    Color colorExito = new Color(39, 174, 96);          
    Color colorInfo = new Color(52, 152, 219);          
    Color colorAdvertencia = new Color(243, 156, 18);   
    

    jPanel1.setBackground(Color.WHITE);
    jPanel1.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(colorPrimario, 2),
        BorderFactory.createEmptyBorder(20, 20, 20, 20)
    ));
    
   
    jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 24));
    jLabel1.setForeground(colorPrimario);
    
  
    jLabel2.setFont(new Font("Segoe UI", Font.BOLD, 16));
    jLabel2.setForeground(colorSecundario);
    

    txtResultado.setFont(new Font("Consolas", Font.PLAIN, 12));
    txtResultado.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(colorPrimario, 1),
        BorderFactory.createEmptyBorder(10, 10, 10, 10)
    ));
    
  
    configurarBoton(btnDisponibilidad, colorInfo, Color.WHITE);
    configurarBoton(btnSalasPorPelicula, colorExito, Color.WHITE);
    configurarBoton(btnPeliculasPorSala, colorAdvertencia, Color.WHITE);
    configurarBoton(btnFuncionesPorPelicula, new Color(155, 89, 182), Color.WHITE);
    

    configurarBoton(btnLimpiar, colorSecundario, Color.WHITE);
    configurarBoton(btnCerrar, new Color(231, 76, 60), Color.WHITE);
    
  
    agregarEfectoHover(btnDisponibilidad, colorInfo, new Color(41, 128, 185));
    agregarEfectoHover(btnSalasPorPelicula, colorExito, new Color(46, 204, 113));
    agregarEfectoHover(btnPeliculasPorSala, colorAdvertencia, new Color(211, 84, 0));
    agregarEfectoHover(btnFuncionesPorPelicula, new Color(155, 89, 182), new Color(142, 68, 173));
    agregarEfectoHover(btnLimpiar, colorSecundario, new Color(44, 62, 80));
    agregarEfectoHover(btnCerrar, new Color(231, 76, 60), new Color(192, 57, 43));
}

private void configurarBoton(JButton boton, Color colorFondo, Color colorTexto) {
    boton.setFont(new Font("Segoe UI", Font.BOLD, 13));
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
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnDisponibilidad = new javax.swing.JButton();
        btnSalasPorPelicula = new javax.swing.JButton();
        btnPeliculasPorSala = new javax.swing.JButton();
        btnFuncionesPorPelicula = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CONSULTAS Y BÚSQUEDAS");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Seleccione el tipo de consulta:");

        btnDisponibilidad.setText("CONSULTAR DISPONIBILIDAD");
        btnDisponibilidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisponibilidadActionPerformed(evt);
            }
        });

        btnSalasPorPelicula.setText("SALAS POR PELÍCULA");
        btnSalasPorPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalasPorPeliculaActionPerformed(evt);
            }
        });

        btnPeliculasPorSala.setText("PELÍCULAS EN SALA");
        btnPeliculasPorSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeliculasPorSalaActionPerformed(evt);
            }
        });

        btnFuncionesPorPelicula.setText("FUNCIONES DE PELÍCULA");
        btnFuncionesPorPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFuncionesPorPeliculaActionPerformed(evt);
            }
        });

        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnCerrar.setText("CERRAR");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        txtResultado.setEditable(false);
        txtResultado.setColumns(60);
        txtResultado.setRows(15);
        txtResultado.setToolTipText("");
        jScrollPane1.setViewportView(txtResultado);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btnLimpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrar)
                .addGap(47, 47, 47))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(btnDisponibilidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPeliculasPorSala)
                .addGap(173, 173, 173))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(btnSalasPorPelicula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFuncionesPorPelicula)
                .addGap(161, 161, 161))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalasPorPelicula)
                    .addComponent(btnFuncionesPorPelicula))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDisponibilidad)
                    .addComponent(btnPeliculasPorSala))
                .addGap(54, 54, 54)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar)
                    .addComponent(btnCerrar))
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDisponibilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisponibilidadActionPerformed
         String titulo = JOptionPane.showInputDialog(this,
            "Ingrese el título de la película:",
            "Consultar Disponibilidad",
            JOptionPane.QUESTION_MESSAGE);
    
    if (titulo == null || titulo.trim().isEmpty()) {
        return;
    }
    
  
    Pelicula peli = peliculaData.buscarPelicula(titulo.trim());
    
    if (peli == null) {
        JOptionPane.showMessageDialog(this,
                "No se encontró la película '" + titulo + "'",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        return;
    }
    
   
    String[] opciones = {"2D", "3D"};
    int tipo = JOptionPane.showOptionDialog(this,
            "Seleccione el tipo de función:",
            "Tipo de Función",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            opciones,
            opciones[0]);
    
    if (tipo == -1) return;
    
    boolean es3d = (tipo == 1);
    
  
    String horario = JOptionPane.showInputDialog(this,
            "Ingrese el horario (HH:mm ejemplo: 20:00):",
            "Horario",
            JOptionPane.QUESTION_MESSAGE);
    
    if (horario == null || horario.trim().isEmpty()) {
        return;
    }
    
    try {
      
        boolean hayLugares = funcionData.hayLugaresDisponibles(
                peli.getIdPelicula(), 
                es3d, 
                horario.trim() + ":00");
        
        StringBuilder resultado = new StringBuilder();
        resultado.append("═══════════════════════════════════════════════════\n");
        resultado.append("          CONSULTA DE DISPONIBILIDAD\n");
        resultado.append("═══════════════════════════════════════════════════\n\n");
        resultado.append("Película: ").append(peli.getTitulo()).append("\n");
        resultado.append("Tipo: ").append(es3d ? "3D" : "2D").append("\n");
        resultado.append("Horario: ").append(horario).append("\n\n");
        
        if (hayLugares) {
            resultado.append(" HAY LUGARES DISPONIBLES\n\n");
            
          
            List<Funcion> funciones = funcionData.buscarFuncionesPorPelicula(peli.getIdPelicula());
            
            for (Funcion f : funciones) {
                if (f.isEs3d() == es3d) {
                    int disponibles = funcionData.contarLugaresDisponibles(f.getIdFuncion());
                    resultado.append("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
                    resultado.append("Horario: ").append(f.getHoraInicio()).append("\n");
                    resultado.append("Sala: ").append(f.getSalaProyeccion().getNroSala()).append("\n");
                    resultado.append("Lugares disponibles: ").append(disponibles).append("\n");
                    resultado.append("Precio: $").append(f.getPrecio()).append("\n");
                }
            }
        } else {
            resultado.append(" NO HAY LUGARES DISPONIBLES\n");
            resultado.append("\nIntente con otro horario o tipo de función.\n");
        }
        
        resultado.append("\n═══════════════════════════════════════════════════\n");
        
        txtResultado.setText(resultado.toString());
        txtResultado.setCaretPosition(0);
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
                "Error: Formato de horario incorrecto. Use HH:mm (ejemplo: 20:00)",
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_btnDisponibilidadActionPerformed

    private void btnSalasPorPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalasPorPeliculaActionPerformed
       String titulo = JOptionPane.showInputDialog(this,
            "Ingrese el título de la película:",
            "Buscar Salas",
            JOptionPane.QUESTION_MESSAGE);
    
    if (titulo == null || titulo.trim().isEmpty()) {
        return;
    }
    
   
    Pelicula peli = peliculaData.buscarPelicula(titulo.trim());
    
    if (peli == null) {
        JOptionPane.showMessageDialog(this,
                "No se encontró la película '" + titulo + "'",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        return;
    }
    
   
    List<Sala> salas = funcionData.listarSalasPorPelicula(peli.getIdPelicula());
    
    StringBuilder resultado = new StringBuilder();
  
    resultado.append("        SALAS DONDE SE PROYECTA LA PELÍCULA\n");
    resultado.append("═══════════════════════════════════════════════════\n\n");
    resultado.append("Película: ").append(peli.getTitulo()).append("\n");
    resultado.append("Director: ").append(peli.getDirector()).append("\n");
    resultado.append("Género: ").append(peli.getGenero()).append("\n\n");
    
    if (salas.isEmpty()) {
        resultado.append(" Esta película no se proyecta en ninguna sala actualmente.\n");
    } else {
        resultado.append("Total de salas: ").append(salas.size()).append("\n\n");
        
        int contador = 1;
        for (Sala sala : salas) {
            resultado.append("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
            resultado.append(contador).append(". Sala ").append(sala.getNroSala()).append("\n");
            resultado.append("   Capacidad: ").append(sala.getCapacidad()).append(" personas\n");
            resultado.append("   Apta 3D: ").append(sala.isApto3d() ? "Sí" : "No").append("\n");
            resultado.append("   Estado: ").append(sala.isEstado() ? "Activa" : "Inactiva").append("\n");
            contador++;
        }
    }
    
    resultado.append("\n═══════════════════════════════════════════════════\n");
    
    txtResultado.setText(resultado.toString());
    txtResultado.setCaretPosition(0);

    }//GEN-LAST:event_btnSalasPorPeliculaActionPerformed

    private void btnPeliculasPorSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeliculasPorSalaActionPerformed
       List<Sala> todasSalas = salaData.listarSalas();
    
    if (todasSalas.isEmpty()) {
        JOptionPane.showMessageDialog(this,
                "No hay salas registradas en el sistema",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        return;
    }
    
 
    String[] opciones = new String[todasSalas.size()];
    for (int i = 0; i < todasSalas.size(); i++) {
        opciones[i] = "Sala " + todasSalas.get(i).getNroSala();
    }
    

    String salaSeleccionada = (String) JOptionPane.showInputDialog(this,
            "Seleccione una sala:",
            "Seleccionar Sala",
            JOptionPane.QUESTION_MESSAGE,
            null,
            opciones,
            opciones[0]);
    
    if (salaSeleccionada == null) {
        return;
    }
    
   
    int indiceSala = java.util.Arrays.asList(opciones).indexOf(salaSeleccionada);
    Sala sala = todasSalas.get(indiceSala);
    
  
    com.toedter.calendar.JDateChooser dateChooser = new com.toedter.calendar.JDateChooser();
    
    int option = JOptionPane.showConfirmDialog(this,
            dateChooser,
            "Seleccione una fecha",
            JOptionPane.OK_CANCEL_OPTION);
    
    if (option != JOptionPane.OK_OPTION || dateChooser.getDate() == null) {
        return;
    }
    
    LocalDate fecha = dateChooser.getDate().toInstant()
            .atZone(java.time.ZoneId.systemDefault()).toLocalDate();
    
 
    String horaInicio = JOptionPane.showInputDialog(this,
            "Ingrese hora de inicio (HH:mm ejemplo: 14:00):",
            "Hora Inicio",
            JOptionPane.QUESTION_MESSAGE);
    
    if (horaInicio == null || horaInicio.trim().isEmpty()) {
        return;
    }
    
    String horaFin = JOptionPane.showInputDialog(this,
            "Ingrese hora de fin (HH:mm ejemplo: 22:00):",
            "Hora Fin",
            JOptionPane.QUESTION_MESSAGE);
    
    if (horaFin == null || horaFin.trim().isEmpty()) {
        return;
    }
    
    try {
        LocalTime inicio = LocalTime.parse(horaInicio.trim());
        LocalTime fin = LocalTime.parse(horaFin.trim());
        
     
        List<Pelicula> peliculas = funcionData.listarPeliculasPorSalaYHorario(
                sala.getIdSala(), fecha, inicio, fin);
        
        StringBuilder resultado = new StringBuilder();
     
        resultado.append("      PELÍCULAS PROYECTADAS EN LA SALA\n");
        resultado.append("═══════════════════════════════════════════════════\n\n");
        resultado.append("Sala: ").append(sala.getNroSala()).append("\n");
        resultado.append("Fecha: ").append(fecha.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"))).append("\n");
        resultado.append("Horario: ").append(horaInicio).append(" - ").append(horaFin).append("\n\n");
        
        if (peliculas.isEmpty()) {
            resultado.append(" No se proyectan películas en este horario.\n");
        } else {
            resultado.append("Total de películas: ").append(peliculas.size()).append("\n\n");
            
            int contador = 1;
            for (Pelicula peli : peliculas) {
                resultado.append("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
                resultado.append(contador).append(". ").append(peli.getTitulo()).append("\n");
                resultado.append("   Director: ").append(peli.getDirector()).append("\n");
                resultado.append("   Género: ").append(peli.getGenero()).append("\n");
                resultado.append("   Origen: ").append(peli.getOrigen()).append("\n");
                contador++;
            }
        }
        
        resultado.append("\n═══════════════════════════════════════════════════\n");
        
        txtResultado.setText(resultado.toString());
        txtResultado.setCaretPosition(0);
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
                "Error: Formato de horario incorrecto. Use HH:mm (ejemplo: 14:00)",
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnPeliculasPorSalaActionPerformed

    private void btnFuncionesPorPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFuncionesPorPeliculaActionPerformed
        String titulo = JOptionPane.showInputDialog(this,
            "Ingrese el título de la película:",
            "Buscar Funciones",
            JOptionPane.QUESTION_MESSAGE);
    
    if (titulo == null || titulo.trim().isEmpty()) {
        return;
    }
    
  
    Pelicula peli = peliculaData.buscarPelicula(titulo.trim());
    
    if (peli == null) {
        JOptionPane.showMessageDialog(this,
                "No se encontró la película '" + titulo + "'",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        return;
    }
    
  
    List<Funcion> funciones = funcionData.buscarFuncionesPorPelicula(peli.getIdPelicula());
    
    StringBuilder resultado = new StringBuilder();

    resultado.append("          FUNCIONES DE LA PELÍCULA\n");
    resultado.append("═══════════════════════════════════════════════════\n\n");
    resultado.append("Película: ").append(peli.getTitulo()).append("\n");
    resultado.append("Director: ").append(peli.getDirector()).append("\n");
    resultado.append("Género: ").append(peli.getGenero()).append("\n\n");
    
    if (funciones.isEmpty()) {
        resultado.append(" No hay funciones programadas para esta película.\n");
    } else {
        resultado.append("Total de funciones: ").append(funciones.size()).append("\n\n");
        
        int contador = 1;
        for (Funcion f : funciones) {
            int disponibles = funcionData.contarLugaresDisponibles(f.getIdFuncion());
            
            resultado.append("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
            resultado.append(contador).append(". Función #").append(f.getIdFuncion()).append("\n");
            resultado.append("   Horario: ").append(f.getHoraInicio()).append("\n");
            resultado.append("   Idioma: ").append(f.getIdioma()).append("\n");
            resultado.append("   Tipo: ").append(f.isEs3d() ? "3D" : "2D").append("\n");
            resultado.append("   Subtitulada: ").append(f.isSubtitulado() ? "Sí" : "No").append("\n");
            resultado.append("   Sala: ").append(f.getSalaProyeccion().getNroSala()).append("\n");
            resultado.append("   Precio: $").append(f.getPrecio()).append("\n");
            resultado.append("   Lugares disponibles: ").append(disponibles).append("\n");
            contador++;
        }
    }
    
    resultado.append("\n═══════════════════════════════════════════════════\n");
    
    txtResultado.setText(resultado.toString());
    txtResultado.setCaretPosition(0);

    }//GEN-LAST:event_btnFuncionesPorPeliculaActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
       txtResultado.setText("Seleccione una opción de consulta...");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
 this.dispose();       
    }//GEN-LAST:event_btnCerrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnDisponibilidad;
    private javax.swing.JButton btnFuncionesPorPelicula;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnPeliculasPorSala;
    private javax.swing.JButton btnSalasPorPelicula;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtResultado;
    // End of variables declaration//GEN-END:variables
}
