/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Comprador;
import Modelo.DetalleTicket;
import Modelo.MyConexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class DetalleTicketData {

    private final Connection conn;

    public DetalleTicketData() {
        conn = MyConexion.buscarConexion();
    }

    public void guardarDetalleTicket(DetalleTicket detalle) {
        String query = "INSERT INTO DetalleTicket (idFuncion, idLugar, cantidad, subtotal) VALUES(?, ?, ?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setInt(1, detalle.getFuncion().getIdFuncion());
            ps.setInt(2, detalle.getLugar().getIdLugar());
            ps.setInt(3, detalle.getCantidad());
            ps.setDouble(4, detalle.getSubtotal());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                detalle.setIdDetalleTicket(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "DetalleTicket guardado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar el DetalleTicket");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla: " + e.getMessage());
        }

    }

    public void actualizarDetalleTicket(DetalleTicket d) {
        String query = "UPDATE DetalleTicket SET idFuncion = ?, idLugar = ?, cantidad = ?, subtotal = ? WHERE idDetalleTicket = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setInt(1, d.getFuncion().getIdFuncion());
            ps.setInt(2, d.getLugar().getIdLugar());
            ps.setInt(3, d.getCantidad());
            ps.setDouble(4, d.getSubtotal());

            int actualizado = ps.executeUpdate();

            if (actualizado == 1) {
                JOptionPane.showMessageDialog(null, "Datos del detalleticket actualizados correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar el detalleticket");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el detalleticket ");
        }

    }
    
    public void eliminarDetalleTicket(int idDetalleTicket){
       String query = "DELETE FROM detalleticket WHERE idDetalleTicket = ?";
       
       
        try {
            PreparedStatement ps= conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, idDetalleTicket);
            int eliminado = ps.executeUpdate();
            
            
            if(eliminado == 1) {
                JOptionPane.showMessageDialog(null, "DetalleTicket eliminado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el detalleticket con ese ID");
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar el detalleticket");
        }
      
  }
}
