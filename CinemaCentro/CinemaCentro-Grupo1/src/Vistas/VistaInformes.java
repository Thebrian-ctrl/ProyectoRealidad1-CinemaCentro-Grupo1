package Vistas;

import Modelo.*;
import Persistencia.*;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class VistaInformes extends javax.swing.JInternalFrame {

    private TicketCompraData ticketData;
    private PeliculaData peliculaData;
    private CompradorData compradorData;
    private DateTimeFormatter formatter;

    public VistaInformes() {
        initComponents();
        inicializar();
        aplicarEstilos();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
    }
 
private void aplicarEstilos() {
    Color ROJO_CINE = new Color(220, 20, 60);
    Color NEGRO_CINE = new Color(30, 30, 30);
    Color DORADO_CINE = new Color(255, 215, 0);
    Color VERDE = new Color(34, 139, 34);
    Color AZUL = new Color(52, 152, 219);
    
    jPanel1.setBackground(Color.WHITE);
    jPanel1.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(ROJO_CINE, 3),
        BorderFactory.createEmptyBorder(15, 15, 15, 15)
    ));
    
    jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 28));
    jLabel1.setForeground(ROJO_CINE);
    jLabel1.setText(" INFORMES Y REPORTES");
    
    TextoArea.setFont(new Font("Consolas", Font.PLAIN, 13));
    TextoArea.setBackground(new Color(245, 245, 245));
    TextoArea.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(ROJO_CINE, 2),
        BorderFactory.createEmptyBorder(5, 10, 5, 10)
    ));
    TextoArea.setEditable(false);
    
    configurarBoton(jButtonFecha, AZUL, Color.WHITE);
    jButtonFecha.setText(" Por Fecha");
    configurarBoton(jButtonPelicula, VERDE, Color.WHITE);
    jButtonPelicula.setText(" Por Película");
    configurarBoton(jButtonCompradores, new Color(156, 39, 176), Color.WHITE);
    jButtonCompradores.setText(" Compradores");
    configurarBoton(jButtonEstadisticas, DORADO_CINE, NEGRO_CINE);
    jButtonEstadisticas.setText(" Estadísticas");
    configurarBoton(jButtonLimpiar, new Color(128, 128, 128), Color.WHITE);
    jButtonLimpiar.setText(" Limpiar");
    configurarBoton(jButtonCerrar, ROJO_CINE, Color.WHITE);
    jButtonCerrar.setText(" Cerrar");
    
    agregarEfectoHover(jButtonFecha, AZUL, new Color(41, 128, 185));
    agregarEfectoHover(jButtonPelicula, VERDE, new Color(46, 204, 113));
    agregarEfectoHover(jButtonCompradores, new Color(156, 39, 176), new Color(142, 68, 173));
    agregarEfectoHover(jButtonEstadisticas, DORADO_CINE, new Color(255, 235, 59));
    agregarEfectoHover(jButtonLimpiar, new Color(128, 128, 128), new Color(90, 90, 90));
    agregarEfectoHover(jButtonCerrar, ROJO_CINE, new Color(255, 50, 90));
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

    
   


    private void inicializar() {
        ticketData = new TicketCompraData();
        peliculaData = new PeliculaData();
        compradorData = new CompradorData();
        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        TextoArea.setEditable(false);
        TextoArea.setText("Seleccione un tipo de informe usando los botones de arriba.");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonFecha = new javax.swing.JButton();
        jButtonPelicula = new javax.swing.JButton();
        jButtonCompradores = new javax.swing.JButton();
        jButtonEstadisticas = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextoArea = new javax.swing.JTextField();
        jButtonLimpiar = new javax.swing.JButton();
        jButtonCerrar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("INFORMES");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("SELECCIONE EL TIPO DE INFORME");

        jButtonFecha.setText("TICKETS POR FECHA");
        jButtonFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFechaActionPerformed(evt);
            }
        });

        jButtonPelicula.setText("TICKETS POR PELICULA");
        jButtonPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPeliculaActionPerformed(evt);
            }
        });

        jButtonCompradores.setText("COMPRADORES");
        jButtonCompradores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCompradoresActionPerformed(evt);
            }
        });

        jButtonEstadisticas.setText("ESTADISTICAS");
        jButtonEstadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEstadisticasActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(TextoArea);

        jButtonLimpiar.setText("Limpiar");
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });

        jButtonCerrar.setText("Cerrar");
        jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jButtonCompradores, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(129, 129, 129)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonEstadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(284, 284, 284)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jButtonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(198, 198, 198))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(364, 364, 364)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCompradores, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEstadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(155, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCompradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCompradoresActionPerformed
        com.toedter.calendar.JDateChooser dateChooser = new com.toedter.calendar.JDateChooser();

        int option = JOptionPane.showConfirmDialog(this,
                dateChooser,
                "Seleccione una fecha",
                JOptionPane.OK_CANCEL_OPTION);

        if (option != JOptionPane.OK_OPTION || dateChooser.getDate() == null) {
            return;
        }

        LocalDate fecha = dateChooser.getDate().toInstant()
                .atZone(ZoneId.systemDefault()).toLocalDate();

        generarInformeCompradores(fecha);
    }

    private void generarInformeCompradores(LocalDate fecha) {
        List<TicketCompra> tickets = ticketData.listarTicketsPorFecha(fecha);

        StringBuilder reporte = new StringBuilder();
        reporte.append("         COMPRADORES QUE ASISTIERON\n");        
        reporte.append(" Fecha: ").append(fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))).append("\n");
        reporte.append(" Total de compradores: ").append(tickets.size()).append("\n\n");

        if (tickets.isEmpty()) {
            reporte.append(" No hubo compradores en esta fecha.\n");
        } else {
            int contador = 1;

            for (TicketCompra ticket : tickets) {
                Comprador comp = compradorData.buscarComprador(
                        ticket.getComprador().getIdComprador()
                );

                if (comp != null) {
                    reporte.append("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
                    reporte.append(contador).append(". ").append(comp.getNombre()).append("\n");
                    reporte.append("   DNI: ").append(comp.getDni()).append("\n");
                    reporte.append("   Ticket: #").append(ticket.getIdTicket()).append("\n");
                    reporte.append("   Función: ").append(ticket.getFechaFuncion().format(formatter)).append("\n");
                    reporte.append("   Monto Pagado: $").append(String.format("%.2f", ticket.getMonto())).append("\n");

                    contador++;
                }
            }
        }

        TextoArea.setText(reporte.toString());
        TextoArea.setCaretPosition(0);

    }//GEN-LAST:event_jButtonCompradoresActionPerformed

    private void jButtonEstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEstadisticasActionPerformed
        generarEstadisticas();
    }

   private void generarEstadisticas() {
    List<TicketCompra> todosTickets = ticketData.listarTodosTickets();

    if (todosTickets.isEmpty()) {
        TextoArea.setText("No hay datos suficientes para generar estadísticas.");
        return;
    }

    Map<String, Integer> ticketsPorPeli = new HashMap<>();
    Map<String, Double> recaudacionPorPeli = new HashMap<>();

    for (TicketCompra ticket : todosTickets) {
   
        if (ticket.getDetalleticket() != null
                && ticket.getDetalleticket().getFuncion() != null
                && ticket.getDetalleticket().getFuncion().getPelicula() != null) {

            String titulo = ticket.getDetalleticket().getFuncion().getPelicula().getTitulo();

            ticketsPorPeli.put(titulo,
                    ticketsPorPeli.getOrDefault(titulo, 0) + 1);

            recaudacionPorPeli.put(titulo,
                    recaudacionPorPeli.getOrDefault(titulo, 0.0) + ticket.getMonto());
        }
    }


    if (ticketsPorPeli.isEmpty()) {
        TextoArea.setText("No hay datos suficientes para generar estadísticas.\n\n" +
                "Los tickets no tienen información completa de películas.");
        return;
    }

    List<Map.Entry<String, Integer>> ranking = new java.util.ArrayList<>(ticketsPorPeli.entrySet());
    ranking.sort((a, b) -> b.getValue().compareTo(a.getValue()));

    StringBuilder reporte = new StringBuilder();
    reporte.append("══════════════════════════════════════════\n");
    reporte.append("        PELÍCULAS MÁS VISTAS\n");
    reporte.append("══════════════════════════════════════════\n\n");

    int posicion = 1;
    for (Map.Entry<String, Integer> entry : ranking) {
        String titulo = entry.getKey();
        int cantTickets = entry.getValue();
        double recaudacion = recaudacionPorPeli.get(titulo);

        String medalla = "";
        if (posicion == 1) {
            medalla = "";
        } else if (posicion == 2) {
            medalla = "";
        } else if (posicion == 3) {
            medalla = "";
        } else {
            medalla = "  ";
        }

        reporte.append(medalla).append(" #").append(posicion).append(" - ").append(titulo).append("\n");
        reporte.append("    Tickets vendidos: ").append(cantTickets).append("\n");
        reporte.append("    Recaudado: $").append(String.format("%.2f", recaudacion)).append("\n\n");

        posicion++;
    }


    reporte.append("         TOTALES GENERALES\n");
    reporte.append("══════════════════════════════════════════\n");
    reporte.append("   Total Tickets: ").append(todosTickets.size()).append("\n");

    double totalRecaudado = todosTickets.stream()
            .mapToDouble(TicketCompra::getMonto)
            .sum();
    reporte.append("   Total Recaudado: $").append(String.format("%.2f", totalRecaudado)).append("\n");
    reporte.append("══════════════════════════════════════════\n");

    TextoArea.setText(reporte.toString());
    TextoArea.setCaretPosition(0);

    }//GEN-LAST:event_jButtonEstadisticasActionPerformed

    private void jButtonPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPeliculaActionPerformed
        String titulo = JOptionPane.showInputDialog(this,
                "Ingrese el título de la película:",
                "Buscar Película",
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

        generarInformePorPelicula(peli);
    }

    private void generarInformePorPelicula(Pelicula peli) {
        List<TicketCompra> tickets = ticketData.ListarTicketsPorPelicula(peli.getIdPelicula());

        StringBuilder reporte = new StringBuilder();
        reporte.append("       INFORME DE TICKETS POR PELÍCULA\n");
        reporte.append("Película: ").append(peli.getTitulo()).append("\n");
        reporte.append("   Director: ").append(peli.getDirector()).append("\n");
        reporte.append("   Género: ").append(peli.getGenero()).append("\n");
        reporte.append("   Estreno: ").append(peli.getEstreno()).append("\n\n");
        reporte.append(" Total de tickets vendidos: ").append(tickets.size()).append("\n\n");

        if (tickets.isEmpty()) {
            reporte.append(" No se han vendido tickets para esta película.\n");
        } else {
            double montoTotal = 0;
            int contador = 1;

            for (TicketCompra ticket : tickets) {
                Comprador comp = compradorData.buscarComprador(
                        ticket.getComprador().getIdComprador()
                );

                reporte.append("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
                reporte.append(contador).append(". Ticket #").append(ticket.getIdTicket()).append("\n");
                reporte.append("   Comprador: ").append(comp != null ? comp.getNombre() : "N/A").append("\n");
                reporte.append("   Fecha Compra: ").append(ticket.getFechaCompra()).append("\n");
                reporte.append("   Monto: $").append(String.format("%.2f", ticket.getMonto())).append("\n");

                montoTotal += ticket.getMonto();
                contador++;
            }

            reporte.append(" TOTAL RECAUDADO: $").append(String.format("%.2f", montoTotal)).append("\n");
            reporte.append("═══════════════════════════════════════════════════\n");
        }

        TextoArea.setText(reporte.toString());
        TextoArea.setCaretPosition(0);

    }//GEN-LAST:event_jButtonPeliculaActionPerformed

    private void jButtonFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFechaActionPerformed
        com.toedter.calendar.JDateChooser dateChooser = new com.toedter.calendar.JDateChooser();

        int option = JOptionPane.showConfirmDialog(this,
                dateChooser,
                "Seleccione una fecha",
                JOptionPane.OK_CANCEL_OPTION);

        if (option != JOptionPane.OK_OPTION || dateChooser.getDate() == null) {
            return;
        }

        LocalDate fecha = dateChooser.getDate().toInstant()
                .atZone(ZoneId.systemDefault()).toLocalDate();

        generarInformePorFecha(fecha);
    }

    private void generarInformePorFecha(LocalDate fecha) {
        List<TicketCompra> tickets = ticketData.listarTicketsPorFecha(fecha);

        StringBuilder reporte = new StringBuilder();
        reporte.append("         INFORME DE TICKETS POR FECHA\n");
        reporte.append("Fecha: ").append(fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))).append("\n");
        reporte.append("Total de tickets: ").append(tickets.size()).append("\n\n");

        if (tickets.isEmpty()) {
            reporte.append(" No se encontraron tickets para esta fecha.\n");
        } else {
            double montoTotal = 0;
            int contador = 1;

            for (TicketCompra ticket : tickets) {
                Comprador comp = compradorData.buscarComprador(
                        ticket.getComprador().getIdComprador()
                );

                reporte.append("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
                reporte.append(contador).append(". Ticket #").append(ticket.getIdTicket()).append("\n");
                reporte.append("   Comprador: ").append(comp != null ? comp.getNombre() : "N/A").append("\n");
                reporte.append("   DNI: ").append(comp != null ? comp.getDni() : "N/A").append("\n");
                reporte.append("   Función: ").append(ticket.getFechaFuncion().format(formatter)).append("\n");
                reporte.append("   Monto: $").append(String.format("%.2f", ticket.getMonto())).append("\n");

                montoTotal += ticket.getMonto();
                contador++;
            }

            reporte.append(" TOTAL RECAUDADO: $").append(String.format("%.2f", montoTotal)).append("\n");
            reporte.append("═══════════════════════════════════════════════════\n");
        }

        TextoArea.setText(reporte.toString());
        TextoArea.setCaretPosition(0);

    }//GEN-LAST:event_jButtonFechaActionPerformed

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        TextoArea.setText("Seleccione un tipo de informe usando los botones de arriba.");
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCerrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TextoArea;
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JButton jButtonCompradores;
    private javax.swing.JButton jButtonEstadisticas;
    private javax.swing.JButton jButtonFecha;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JButton jButtonPelicula;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
