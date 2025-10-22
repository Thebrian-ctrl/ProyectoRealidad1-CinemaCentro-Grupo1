/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.MyConexion;
import Modelo.TicketCompra;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class TicketCompraData { 
    
    private final Connection conn;

    public TicketCompraData() {
        conn = MyConexion.buscarConexion();
    }
    
    public void guardarTicketCompra(TicketCompra t){
        String query = "INSERT INTO ticketcompra(fechaCompra, fechaFuncion, monto, Comprador comprador,  DetalleTicket detalleticket)"
                + "VALUES(?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps= conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setDate(1, Date.valueOf(t.getFechaCompra()));
            ps.setDate(2, (t.getFechaFuncion()));
            ps.setDouble(3, t.getMonto());
            ps.setInt(4, t.getComprador().getIdComprador());
            ps.setInt(5, t.getDetalleticket().getIdDetalleTicket());
           
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if(rs.next()) {
                t.setIdTicket(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "TicketCompra guardada correctamente");
            
            }else{
                JOptionPane.showMessageDialog(null, "Error al guardar la ticketcompra");
            }
            ps.close();
            System.out.println("Guardado");
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla" + e.getMessage());
        }
    
    }      
    
    public TicketCompra buscarTicketCompra (int idComprador){
    
        String query = "SELECT * FROM ticketcompra WHERE idComprador = ?";
        
        TicketCompra ticket = null;
        
        try{
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, idComprador);
        
        ResultSet rs = ps.executeQuery();
        
        
            if(rs.next()){
              ticket = new TicketCompra();
              ticket.setFechaCompra(rs.getDate("FechaCompra").toLocalDate());
          //  ticket.setFechaFuncion(rs.getDate("FechaFuncion"));
              ticket.setMonto(rs.getDouble("Monto"));
          //  ticket.setComprador(rs.getInt("idComprador"));
          //  ticket.setDetalleticket(rs.getInt("idDetalleTicket"));
        
        
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro el ticketcompra " + idComprador + " en la base de datos");
            }
            ps.close();
    
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "Error al buscar el ticketcompra solicitado: " + e.getMessage());
        
        }
        
        return ticket;
    }
    
     public void eliminarTicketCompra(int idTicket) {
        String query = "DELETE FROM ticket WHERE idTicket = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setInt(1, idTicket);
            int eliminado = ps.executeUpdate();

            if (eliminado == 1) {
                JOptionPane.showMessageDialog(null, "Ticket eliminado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el ticket con ese ID");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el ticket");
        }

    }
}
