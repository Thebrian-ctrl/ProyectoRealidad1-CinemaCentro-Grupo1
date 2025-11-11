
package Vistas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.JOptionPane;
/**
 *
 * @author franco
 */
public class PantallaPrincipal extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName());

 
    public PantallaPrincipal() {
        initComponents();
       diseñoPrincipal();
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
        jmenuBar = new javax.swing.JMenuBar();
        jmPeliculas = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuListaPelis = new javax.swing.JMenuItem();
        jmFunciones = new javax.swing.JMenu();
        jMenuFuncion = new javax.swing.JMenuItem();
        jMenuSala = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

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

        jDesktopPane1.setLayer(btnComprar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnAdministrar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(297, 297, 297)
                .addComponent(btnComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(334, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGap(35, 781, Short.MAX_VALUE)
                .addComponent(btnAdministrar)
                .addGap(14, 14, 14))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(263, Short.MAX_VALUE)
                .addComponent(btnComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(251, 251, 251)
                .addComponent(btnAdministrar)
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

        jmenuBar.add(jMenu1);

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
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        InicioDeSesion sesion = new InicioDeSesion();
        sesion.setVisible(true);
        jDesktopPane1.add(sesion);

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
    DetalleTicket dticket = new DetalleTicket();
    dticket.setVisible(true);
    jDesktopPane1.add(dticket);       
    }//GEN-LAST:event_jMenuItem2ActionPerformed


    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(() -> new PantallaPrincipal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdministrar;
    private javax.swing.JButton btnComprar;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuFuncion;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuSala;
    private javax.swing.JMenu jmFunciones;
    private javax.swing.JMenu jmPeliculas;
    private javax.swing.JMenuBar jmenuBar;
    private javax.swing.JMenuItem menuListaPelis;
    // End of variables declaration//GEN-END:variables
}
