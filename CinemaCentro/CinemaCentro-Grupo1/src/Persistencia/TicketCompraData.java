
package Persistencia;

import Modelo.Comprador;
import Modelo.DetalleTicket;
import Modelo.MyConexion;
import Modelo.TicketCompra;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
/**
 *
 * @author camila biarnes
 */
public class TicketCompraData {
    
    private final Connection conn;
    
    public TicketCompraData() {
        conn = MyConexion.buscarConexion();
    }
    

    public void guardarTicketCompra(TicketCompra ticket) {
        String query = "INSERT INTO ticketcompra (fechaCompra, fechaFuncion, monto, idComprador, idDetalleTicket) "
                + "VALUES(?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setDate(1, Date.valueOf(ticket.getFechaCompra()));
            ps.setTimestamp(2, java.sql.Timestamp.valueOf(ticket.getFechaFuncion()));
            ps.setDouble(3, ticket.getMonto());
            ps.setInt(4, ticket.getComprador().getIdComprador());
            
            if (ticket.getDetalleticket() != null) {
                ps.setInt(5, ticket.getDetalleticket().getIdDetalleTicket());
            } else {
                ps.setNull(5, java.sql.Types.INTEGER);
            }
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
                ticket.setIdTicket(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Ticket de compra guardado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar el ticket de compra");
            }
            
            rs.close();
            ps.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla: " + e.getMessage());
        }
    }
    
 
    public TicketCompra buscarTicketPorId(int idTicket) {
        TicketCompra ticket = null;
        String query = "SELECT * FROM ticketcompra WHERE idTicket = ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idTicket);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                ticket = new TicketCompra();
                ticket.setIdTicket(rs.getInt("idTicket"));
                ticket.setFechaCompra(rs.getDate("fechaCompra").toLocalDate());
                ticket.setFechaFuncion(rs.getTimestamp("fechaFuncion").toLocalDateTime());
                ticket.setMonto(rs.getDouble("monto"));
                
               
                Comprador comprador = new Comprador();
                comprador.setIdComprador(rs.getInt("idComprador"));
                ticket.setComprador(comprador);
                
             
                int idDetalle = rs.getInt("idDetalleTicket");
                if (!rs.wasNull()) {
                    DetalleTicket detalle = new DetalleTicket();
                    detalle.setIdDetalleTicket(idDetalle);
                    ticket.setDetalleticket(detalle);
                }
                
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ticket con ID: " + idTicket);
            }
            
            rs.close();
            ps.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar el ticket: " + e.getMessage());
        }
        
        return ticket;
    }
    

    public void actualizarTicket(TicketCompra ticket) {
        String query = "UPDATE ticketcompra SET fechaCompra = ?, fechaFuncion = ?, monto = ?, "
                + "idComprador = ?, idDetalleTicket = ? WHERE idTicket = ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setDate(1, Date.valueOf(ticket.getFechaCompra()));
            ps.setTimestamp(2, java.sql.Timestamp.valueOf(ticket.getFechaFuncion()));
            ps.setDouble(3, ticket.getMonto());
            ps.setInt(4, ticket.getComprador().getIdComprador());
            
            if (ticket.getDetalleticket() != null) {
                ps.setInt(5, ticket.getDetalleticket().getIdDetalleTicket());
            } else {
                ps.setNull(5, java.sql.Types.INTEGER);
            }
            
            ps.setInt(6, ticket.getIdTicket());
            
            int actualizado = ps.executeUpdate();
            
            if (actualizado == 1) {
                JOptionPane.showMessageDialog(null, "Ticket actualizado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar el ticket");
            }
            
            ps.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el ticket: " + e.getMessage());
        }
    }
    
  //seguir con anular los tickets y dsp listar 
  
}