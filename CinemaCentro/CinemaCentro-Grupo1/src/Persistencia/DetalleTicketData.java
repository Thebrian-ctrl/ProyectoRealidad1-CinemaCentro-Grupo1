/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.DetalleTicket;
import Modelo.Funcion;
import Modelo.Lugar;
import Modelo.MyConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        String query = "INSERT INTO DetalleTicket (idFuncion, idLugar, cantidad, subtotal)"
                + " VALUES(?, ?, ?, ?)";

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
        String query = "UPDATE detalleticket SET idFuncion = ?, idLugar = ?, cantidad = ?, subtotal = ? WHERE idDetalleTicket = ?";
        
        

        try {
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, d.getFuncion().getIdFuncion());
            ps.setInt(2, d.getLugar().getIdLugar());
            ps.setInt(3, d.getCantidad());
            ps.setDouble(4, d.getSubtotal());
            ps.setInt(5, d.getIdDetalleTicket());

            int actualizado = ps.executeUpdate();

            if (actualizado == 1) {
                JOptionPane.showMessageDialog(null, "Datos del detalleticket actualizados correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar el detalleticket");
            }
            ps.close();

        } catch (Exception e) {
           e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al actualizar el detalleticket ");
            
        }

    }

    public void eliminarDetalleTicket(int idDetalleTicket) {
      String queryVerificar = "SELECT COUNT(*) as total FROM ticketcompra WHERE idDetalleTicket = ?";
    
    try {
        PreparedStatement psVerificar = conn.prepareStatement(queryVerificar);
        psVerificar.setInt(1, idDetalleTicket);
        ResultSet rs = psVerificar.executeQuery();
        
        int ticketsAsociados = 0;
        if (rs.next()) {
            ticketsAsociados = rs.getInt("total");
        }
        
        rs.close();
        psVerificar.close();
        
   
        if (ticketsAsociados > 0) {
            JOptionPane.showMessageDialog(null,
                "⚠️ NO SE PUEDE ELIMINAR\n\n" +
                "Este detalle tiene " + ticketsAsociados + " ticket(s) asociado(s).\n\n" +
                "Primero debe anular los tickets correspondientes.",
                "Eliminación Bloqueada",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, 
            "Error al verificar tickets asociados: " + e.getMessage());
        e.printStackTrace();
        return;
    }
    
 
    String queryBuscarLugar = "SELECT idLugar FROM detalleticket WHERE idDetalleTicket = ?";
    Integer idLugar = null;
    
    try {
        PreparedStatement psLugar = conn.prepareStatement(queryBuscarLugar);
        psLugar.setInt(1, idDetalleTicket);
        ResultSet rsLugar = psLugar.executeQuery();
        
        if (rsLugar.next()) {
            idLugar = rsLugar.getInt("idLugar");
        }
        
        rsLugar.close();
        psLugar.close();
        
    } catch (SQLException e) {
        System.out.println(" No se pudo buscar el lugar: " + e.getMessage());
    }
    

    if (idLugar != null) {
        String queryLiberarLugar = "UPDATE lugar SET estado = true WHERE idLugar = ?";
        
        try {
            PreparedStatement psLiberar = conn.prepareStatement(queryLiberarLugar);
            psLiberar.setInt(1, idLugar);
            psLiberar.executeUpdate();
            psLiberar.close();
            
            System.out.println(" Lugar liberado: ID " + idLugar);
            
        } catch (SQLException e) {
            System.out.println(" No se pudo liberar el lugar: " + e.getMessage());
        }
    }
    

    String queryEliminar = "DELETE FROM detalleticket WHERE idDetalleTicket = ?";
    
    try {
        PreparedStatement psEliminar = conn.prepareStatement(queryEliminar);
        psEliminar.setInt(1, idDetalleTicket);
        
        int resultado = psEliminar.executeUpdate();
        
        if (resultado > 0) {
            System.out.println(" DetalleTicket eliminado: ID " + idDetalleTicket);
            
            String mensaje = " DetalleTicket eliminado exitosamente";
            if (idLugar != null) {
                mensaje += "\n\nEl asiento ha sido liberado";
            }
            
            JOptionPane.showMessageDialog(null, mensaje, 
                "Eliminación Exitosa", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, 
                "No se encontró el DetalleTicket con ID " + idDetalleTicket);
        }
        
        psEliminar.close();
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, 
            "Error al eliminar el DetalleTicket: " + e.getMessage());
        e.printStackTrace();
    }

    }

    public DetalleTicket buscarDetalleTicket(int id) {
        String query = "SELECT * FROM detalleticket WHERE idDetalleTicket = ?";

        DetalleTicket detalle = null;

        try {
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                detalle = new DetalleTicket();

                detalle.setIdDetalleTicket(rs.getInt("idDetalleTicket"));
                detalle.setCantidad(rs.getInt("cantidad"));
                detalle.setSubtotal(rs.getDouble("subtotal"));
                Funcion funcion = new Funcion();
                funcion.setIdFuncion(rs.getInt("idFuncion"));
                detalle.setFuncion(funcion);

                Lugar lugar = new Lugar();
                lugar.setIdLugar(rs.getInt("idLugar"));
                detalle.setLugar(lugar);
                
          
                
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro el detalleticket");
            }
            ps.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar el detalleticket");
        }
        return detalle;
    }

 
}
