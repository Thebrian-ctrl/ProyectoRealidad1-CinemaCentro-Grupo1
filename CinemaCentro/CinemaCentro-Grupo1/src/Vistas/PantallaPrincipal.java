package Vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import Persistencia.*;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author franco
 */
public class PantallaPrincipal extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName());

    public PantallaPrincipal() {
        initComponents();
        diseñoPrincipal();
        PeliculaData peliData = new PeliculaData();
        peliData.actualizarCarteleraPorFecha();
        jmenuBar.setVisible(false);
        btnAdministrar.setText("Activar Administración");
    }

    private void diseñoPrincipal() {

        jDesktopPane1.setBackground(Color.WHITE);

        estilizarBoton(btnComprar, new Color(40, 167, 69));

        estilizarBoton(btnAdministrar, new Color(110, 110, 110));

    }

    private void estilizarBoton(javax.swing.JButton boton, Color colorBase) {
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

        jDesktopPane1 = new javax.swing.JDesktopPane();
        btnComprar = new javax.swing.JButton();
        btnAdministrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButtonProximosEstrenos = new javax.swing.JButton();
        jButtonConsultas = new javax.swing.JButton();
        jmenuBar = new javax.swing.JMenuBar();
        jmPeliculas = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuListaPelis = new javax.swing.JMenuItem();
        jMenuItemActualizarCartelera = new javax.swing.JMenuItem();
        jmFunciones = new javax.swing.JMenu();
        jMenuFuncion = new javax.swing.JMenuItem();
        jMenuSala = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnComprar.setText("Comprar Entrada");
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });

        btnAdministrar.setText("Administración");
        btnAdministrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministrarActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/unnamed.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");

        jButtonProximosEstrenos.setText("Proximos Estrenos");
        jButtonProximosEstrenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProximosEstrenosActionPerformed(evt);
            }
        });

        jButtonConsultas.setText("Consultas");
        jButtonConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultasActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(btnComprar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnAdministrar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButtonProximosEstrenos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButtonConsultas, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jButtonProximosEstrenos))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jButtonConsultas)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(191, 191, 191)
                .addComponent(btnAdministrar)
                .addGap(14, 14, 14))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 948, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdministrar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnComprar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jButtonConsultas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonProximosEstrenos)))
                .addGap(24, 24, 24))
        );

        jmenuBar.setEnabled(false);

        jmPeliculas.setText("Peliculas");

        jMenuItem1.setText("Agregar peliculas");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jmPeliculas.add(jMenuItem1);

        menuListaPelis.setText("Lista de peliculas");
        menuListaPelis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListaPelisActionPerformed(evt);
            }
        });
        jmPeliculas.add(menuListaPelis);

        jMenuItemActualizarCartelera.setText("Actualizar Cartelera");
        jMenuItemActualizarCartelera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemActualizarCarteleraActionPerformed(evt);
            }
        });
        jmPeliculas.add(jMenuItemActualizarCartelera);

        jmenuBar.add(jmPeliculas);

        jmFunciones.setText("Funciones");

        jMenuFuncion.setText("Funciones");
        jMenuFuncion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuFuncionActionPerformed(evt);
            }
        });
        jmFunciones.add(jMenuFuncion);

        jMenuSala.setText("Sala");
        jMenuSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSalaActionPerformed(evt);
            }
        });
        jmFunciones.add(jMenuSala);

        jmenuBar.add(jmFunciones);

        jMenu1.setText("Tickets");

        jMenuItem2.setText("Detalle Ticket");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem5.setText("Modificar Ticket");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem6.setText("Anular Ticket");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem4.setText("Actualizar Precios");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jmenuBar.add(jMenu1);

        jMenu2.setText("Informes");

        jMenuItem3.setText("Ver informes");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jmenuBar.add(jMenu2);

        setJMenuBar(jmenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        InicioDeSesion sesion = new InicioDeSesion();
        jDesktopPane1.add(sesion);
        sesion.setVisible(true);
        sesion.toFront();

    }//GEN-LAST:event_btnComprarActionPerformed

    private void btnAdministrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministrarActionPerformed
        // TODO add your handling code here:
        if (jmenuBar.isVisible()) {
            jmenuBar.setVisible(false);
            btnAdministrar.setText("Activar Administración");
        } else {
            jmenuBar.setVisible(true);
            btnAdministrar.setText("Ocultar Administración");
        }
    }//GEN-LAST:event_btnAdministrarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        PantallaPeliculas pelis = new PantallaPeliculas();
        pelis.setVisible(true);
        jDesktopPane1.add(pelis);

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void menuListaPelisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListaPelisActionPerformed
        // TODO add your handling code here:
        ListarPeliculas list = new ListarPeliculas();
        list.setVisible(true);
        jDesktopPane1.add(list);
    }//GEN-LAST:event_menuListaPelisActionPerformed

    private void jMenuFuncionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuFuncionActionPerformed
        // TODO add your handling code here:
        VistaFuncion fun = new VistaFuncion();
        fun.setVisible(true);
        jDesktopPane1.add(fun);
    }//GEN-LAST:event_jMenuFuncionActionPerformed

    private void jMenuSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSalaActionPerformed
        // TODO add your handling code here:
        vistaSala sala = new vistaSala();
        sala.setVisible(true);
        jDesktopPane1.add(sala);
    }//GEN-LAST:event_jMenuSalaActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        VistaDetalleTicket dticket = new VistaDetalleTicket();
        dticket.setVisible(true);
        jDesktopPane1.add(dticket);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        VistaInformes informes = new VistaInformes();
        informes.setVisible(true);
        jDesktopPane1.add(informes);

        try {
            informes.setMaximum(true);
        } catch (Exception e) {

        }


    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        ModificarTicket modificar = new ModificarTicket();
        modificar.setVisible(true);
        jDesktopPane1.add(modificar);

        try {
            modificar.setMaximum(true);
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItemActualizarCarteleraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemActualizarCarteleraActionPerformed
        jMenuItemActualizarCartelera.setText("Actualizar Cartelera");
        jMenuItemActualizarCartelera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarCartelera(evt);
            }
        });
        jmPeliculas.add(jMenuItemActualizarCartelera);

        jmenuBar.add(jmPeliculas);
    }//GEN-LAST:event_jMenuItemActualizarCarteleraActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        AnularTicket anularTicket = new AnularTicket();
        anularTicket.setVisible(true);
        jDesktopPane1.add(anularTicket);

        try {
            anularTicket.setMaximum(true);
        } catch (Exception e) {

        }

    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jButtonProximosEstrenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProximosEstrenosActionPerformed
        // TODO add your handling code here:
        PróximosEstrenos pe = new PróximosEstrenos();
        pe.setVisible(true);
        jDesktopPane1.add(pe);
    }//GEN-LAST:event_jButtonProximosEstrenosActionPerformed

    private void jButtonConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultasActionPerformed
        VistaConsultas vistaConsultas = new VistaConsultas();
        jDesktopPane1.add(vistaConsultas);
        vistaConsultas.setVisible(true);

        try {
            vistaConsultas.setMaximum(true);
        } catch (java.beans.PropertyVetoException e) {

        }
    }//GEN-LAST:event_jButtonConsultasActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        VistaActualizarPrecios vistaPrecios = new VistaActualizarPrecios();
        jDesktopPane1.add(vistaPrecios);
        vistaPrecios.setVisible(true);

        try {
            vistaPrecios.setMaximum(true);
        } catch (java.beans.PropertyVetoException e) {

        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new PantallaPrincipal().setVisible(true));
    }

    private void actualizarCartelera(java.awt.event.ActionEvent evt) {
        try {
            JOptionPane.showMessageDialog(this,
                    "Actualizando cartelera...\n\n"
                    + "Se marcarán como 'En Cartelera' todas las películas\n"
                    + "cuya fecha de estreno ya llegó.",
                    "Actualizar Cartelera",
                    JOptionPane.INFORMATION_MESSAGE);

            PeliculaData peliData = new PeliculaData();
            int actualizadas = peliData.actualizarCarteleraPorFecha();

            if (actualizadas > 0) {
                JOptionPane.showMessageDialog(this,
                        "Cartelera actualizada exitosamente!\n\n"
                        + "Se actualizaron " + actualizadas + " película(s)\n"
                        + "Fecha: " + java.time.LocalDate.now().format(
                                java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                        "Actualización Exitosa",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "La cartelera ya está actualizada\n\n"
                        + "No hay películas nuevas para agregar a cartelera.",
                        "Sin Cambios",
                        JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    " Error al actualizar cartelera:\n" + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdministrar;
    private javax.swing.JButton btnComprar;
    private javax.swing.JButton jButtonConsultas;
    private javax.swing.JButton jButtonProximosEstrenos;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuFuncion;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItemActualizarCartelera;
    private javax.swing.JMenuItem jMenuSala;
    private javax.swing.JMenu jmFunciones;
    private javax.swing.JMenu jmPeliculas;
    private javax.swing.JMenuBar jmenuBar;
    private javax.swing.JMenuItem menuListaPelis;
    // End of variables declaration//GEN-END:variables
}
