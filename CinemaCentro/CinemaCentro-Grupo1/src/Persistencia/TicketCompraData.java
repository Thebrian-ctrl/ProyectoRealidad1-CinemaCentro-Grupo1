package Persistencia;

import Modelo.Comprador;
import Modelo.DetalleTicket;
import Modelo.MyConexion;
import Modelo.TicketCompra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class TicketCompraData {
    
    private Connection conn;
    
    public TicketCompraData() {
      conn = MyConexion.buscarConexion();
    }
    
 
    
    public void guardarTicketCompra(TicketCompra ticket) {
        String query = "INSERT INTO ticketcompra (fechaCompra, fechaFuncion, monto, idComprador, idDetalleTicket) VALUES (?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setDate(1, java.sql.Date.valueOf(ticket.getFechaCompra()));
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
                System.out.println(" TicketCompra guardado con ID: " + ticket.getIdTicket());
            }
            
            rs.close();
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error al guardar el ticket: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
   
    
    public TicketCompra buscarTickerporId(int idTicket) {
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
                
            
                int idComprador = rs.getInt("idComprador");
                CompradorData compradorData = new CompradorData();
                Comprador comprador = compradorData.buscarCompradorPorId(idComprador);
                ticket.setComprador(comprador);
                
            
                int idDetalle = rs.getInt("idDetalleTicket");
                if (!rs.wasNull()) {
                    DetalleTicketData detalleData = new DetalleTicketData();
                    DetalleTicket detalle = detalleData.buscarDetalleTicket(idDetalle);
                    ticket.setDetalleticket(detalle);
                }
            }
            
            rs.close();
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                "Error al buscar ticket: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        
        return ticket;
    }
    

    
    public void modificarTicket(int idTicket, LocalDate nuevaFecha, double nuevoMonto) {
        String query = "UPDATE ticketcompra SET fechaFuncion = ?, monto = ? WHERE idTicket = ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setTimestamp(1, java.sql.Timestamp.valueOf(nuevaFecha.atStartOfDay()));
            ps.setDouble(2, nuevoMonto);
            ps.setInt(3, idTicket);
            
            int filasAfectadas = ps.executeUpdate();
            
            if (filasAfectadas > 0) {
                System.out.println("✅ Ticket modificado: ID " + idTicket);
            } else {
                JOptionPane.showMessageDialog(null,
                    "No se encontró el ticket con ID " + idTicket);
            }
            
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                "Error al modificar ticket: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    

    
   public void anularTicket(int idTicket) {
  
    String queryBuscar = "SELECT idDetalleTicket FROM ticketcompra WHERE idTicket = ?";
    Integer idDetalleTicket = null;
    
    try {
        PreparedStatement psBuscar = conn.prepareStatement(queryBuscar);
        psBuscar.setInt(1, idTicket);
        ResultSet rs = psBuscar.executeQuery();
        
        if (rs.next()) {
            idDetalleTicket = rs.getInt("idDetalleTicket");
        }
        
        rs.close();
        psBuscar.close();
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al buscar el ticket: " + e.getMessage());
        e.printStackTrace();
        return;
    }
    
  
    if (idDetalleTicket != null) {
        String queryLugar = "SELECT idLugar FROM detalleticket WHERE idDetalleTicket = ?";
        
        try {
            PreparedStatement psLugar = conn.prepareStatement(queryLugar);
            psLugar.setInt(1, idDetalleTicket);
            ResultSet rsLugar = psLugar.executeQuery();
            
            if (rsLugar.next()) {
                int idLugar = rsLugar.getInt("idLugar");
                
             
                LugarData lugarData = new LugarData();
                lugarData.actualizarEstadoLugar(idLugar, true);
            }
            
            rsLugar.close();
            psLugar.close();
            
        } catch (SQLException e) {
            System.out.println("⚠️ No se pudo liberar el lugar: " + e.getMessage());
        }
    }
    
   
    String queryTicket = "DELETE FROM ticketcompra WHERE idTicket = ?";
    
    try {
        PreparedStatement psTicket = conn.prepareStatement(queryTicket);
        psTicket.setInt(1, idTicket);
        
        int filasAfectadas = psTicket.executeUpdate();
        
        if (filasAfectadas > 0) {
            System.out.println(" TicketCompra eliminado: ID " + idTicket);
        }
        
        psTicket.close();
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al eliminar el ticket: " + e.getMessage());
        e.printStackTrace();
        return;
    }
    
 
    if (idDetalleTicket != null) {
        String queryDetalle = "DELETE FROM detalleticket WHERE idDetalleTicket = ?";
        
        try {
            PreparedStatement psDetalle = conn.prepareStatement(queryDetalle);
            psDetalle.setInt(1, idDetalleTicket);
            
            int filasAfectadas = psDetalle.executeUpdate();
            
            if (filasAfectadas > 0) {
                System.out.println(" DetalleTicket eliminado: ID " + idDetalleTicket);
            }
            
            psDetalle.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el detalle: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    JOptionPane.showMessageDialog(null, 
        "Ticket anulado correctamente\n\nLos asientos han sido liberados.",
        "Anulación Exitosa",
        JOptionPane.INFORMATION_MESSAGE);
}
    
 
    
    public List<TicketCompra> listarTodosTickets() {
        List<TicketCompra> tickets = new ArrayList<>();
        String query = "SELECT * FROM ticketcompra ORDER BY fechaCompra DESC";
        
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                TicketCompra ticket = new TicketCompra();
                ticket.setIdTicket(rs.getInt("idTicket"));
                ticket.setFechaCompra(rs.getDate("fechaCompra").toLocalDate());
                ticket.setFechaFuncion(rs.getTimestamp("fechaFuncion").toLocalDateTime());
                ticket.setMonto(rs.getDouble("monto"));
                
              
                int idComprador = rs.getInt("idComprador");
                CompradorData compradorData = new CompradorData();
                Comprador comprador = compradorData.buscarCompradorPorId(idComprador);
                ticket.setComprador(comprador);
                
              
                int idDetalle = rs.getInt("idDetalleTicket");
                if (!rs.wasNull()) {
                    DetalleTicketData detalleData = new DetalleTicketData();
                    DetalleTicket detalle = detalleData.buscarDetalleTicket(idDetalle);
                    ticket.setDetalleticket(detalle);
                }
                
                tickets.add(ticket);
            }
            
            rs.close();
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                "Error al listar todos los tickets: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        
        return tickets;
    }
    

    
    public List<TicketCompra> listarTicketsPorFecha(LocalDate fecha) {
        List<TicketCompra> tickets = new ArrayList<>();
        String query = "SELECT * FROM ticketcompra WHERE DATE(fechaFuncion) = ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setDate(1, java.sql.Date.valueOf(fecha));
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                TicketCompra ticket = new TicketCompra();
                ticket.setIdTicket(rs.getInt("idTicket"));
                ticket.setFechaCompra(rs.getDate("fechaCompra").toLocalDate());
                ticket.setFechaFuncion(rs.getTimestamp("fechaFuncion").toLocalDateTime());
                ticket.setMonto(rs.getDouble("monto"));
                
       
                int idComprador = rs.getInt("idComprador");
                CompradorData compradorData = new CompradorData();
                Comprador comprador = compradorData.buscarCompradorPorId(idComprador);
                ticket.setComprador(comprador);
                
            
                int idDetalle = rs.getInt("idDetalleTicket");
                if (!rs.wasNull()) {
                    DetalleTicketData detalleData = new DetalleTicketData();
                    DetalleTicket detalle = detalleData.buscarDetalleTicket(idDetalle);
                    ticket.setDetalleticket(detalle);
                }
                
                tickets.add(ticket);
            }
            
            rs.close();
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                "Error al listar tickets por fecha: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        
        return tickets;
    }
    
 
    
    public List<TicketCompra> ListarTicketsPorPelicula(int idPelicula) {
       List<TicketCompra> tickets = new ArrayList<>();
        String query = "SELECT tc.* FROM ticketcompra tc " +
                       "JOIN detalleticket dt ON tc.idDetalleTicket = dt.idDetalleTicket " +
                       "JOIN funcion f ON dt.idFuncion = f.idFuncion " +
                       "WHERE f.idPelicula = ? " +
                       "ORDER BY tc.fechaCompra DESC";
        
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idPelicula);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                TicketCompra ticket = new TicketCompra();
                ticket.setIdTicket(rs.getInt("idTicket"));
                ticket.setFechaCompra(rs.getDate("fechaCompra").toLocalDate());
                ticket.setFechaFuncion(rs.getTimestamp("fechaFuncion").toLocalDateTime());
                ticket.setMonto(rs.getDouble("monto"));
                
           
                int idComprador = rs.getInt("idComprador");
                System.out.println("Cargando comprador con ID: " + idComprador);
                
                CompradorData compradorData = new CompradorData();
                Comprador comprador = compradorData.buscarCompradorPorId(idComprador);
                
                if (comprador != null) {
                    ticket.setComprador(comprador);
                } else {
                    System.out.println("⚠️ No se encontró comprador con ID " + idComprador);
                  
                    comprador = new Comprador();
                    comprador.setIdComprador(idComprador);
                    comprador.setNombre("Comprador no encontrado");
                    comprador.setDni(0);
                    ticket.setComprador(comprador);
                }
                
           
                int idDetalle = rs.getInt("idDetalleTicket");
                if (!rs.wasNull()) {
                    DetalleTicketData detalleData = new DetalleTicketData();
                    DetalleTicket detalle = detalleData.buscarDetalleTicket(idDetalle);
                    ticket.setDetalleticket(detalle);
                }
                
                tickets.add(ticket);
            }
            
            rs.close();
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                "Error al listar tickets por película: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        
        return tickets;
    }
    

    
    public List<TicketCompra> listarTicketsPorComprador(int idComprador) {
        List<TicketCompra> tickets = new ArrayList<>();
        String query = "SELECT * FROM ticketcompra WHERE idComprador = ? ORDER BY fechaCompra DESC";
        
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idComprador);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                TicketCompra ticket = new TicketCompra();
                ticket.setIdTicket(rs.getInt("idTicket"));
                ticket.setFechaCompra(rs.getDate("fechaCompra").toLocalDate());
                ticket.setFechaFuncion(rs.getTimestamp("fechaFuncion").toLocalDateTime());
                ticket.setMonto(rs.getDouble("monto"));
                
          
                CompradorData compradorData = new CompradorData();
                Comprador comprador = compradorData.buscarCompradorPorId(idComprador);
                ticket.setComprador(comprador);
                
          
                int idDetalle = rs.getInt("idDetalleTicket");
                if (!rs.wasNull()) {
                    DetalleTicketData detalleData = new DetalleTicketData();
                    DetalleTicket detalle = detalleData.buscarDetalleTicket(idDetalle);
                    ticket.setDetalleticket(detalle);
                }
                
                tickets.add(ticket);
            }
            
            rs.close();
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                "Error al listar tickets por comprador: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        
        return tickets;
    }
    

    
   public List<Comprador> listarCompradoresPorFechaFuncion(LocalDate fecha) {
    List<Comprador> compradores = new ArrayList<>();
    String query = "SELECT DISTINCT c.* FROM comprador c " +
                   "JOIN ticketcompra tc ON c.idComprador = tc.idComprador " +
                   "WHERE DATE(tc.fechaFuncion) = ? " +
                   "ORDER BY c.nombre";
    
    try {
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setDate(1, java.sql.Date.valueOf(fecha));
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Comprador comprador = new Comprador();
            comprador.setIdComprador(rs.getInt("idComprador"));
            comprador.setNombre(rs.getString("nombre"));
            comprador.setDni(rs.getInt("dni"));
            comprador.setPassword(rs.getString("password"));
            comprador.setMedioDePago(rs.getString("medioDePago"));
            
         
            java.sql.Date fechaNacSQL = rs.getDate("fechaNac");
            if (fechaNacSQL != null) {
                comprador.setFechaNac(fechaNacSQL.toLocalDate());
            }
            
            compradores.add(comprador);
        }
        
        rs.close();
        ps.close();
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null,
            "Error al listar compradores: " + e.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
    
    return compradores;
}
    

    
    public double obtenerTotalVentasPorRango(LocalDate fechaInicio, LocalDate fechaFin) {
        double total = 0.0;
        String query = "SELECT SUM(monto) as total FROM ticketcompra " +
                       "WHERE fechaCompra BETWEEN ? AND ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setDate(1, java.sql.Date.valueOf(fechaInicio));
            ps.setDate(2, java.sql.Date.valueOf(fechaFin));
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                total = rs.getDouble("total");
            }
            
            rs.close();
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                "Error al obtener total de ventas: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        
        return total;
    }
    

    
    public int contarTicketsPorPeliculaYFecha(int idPelicula, LocalDate fechaInicio, LocalDate fechaFin) {
        int cantidad = 0;
        String query = "SELECT COUNT(*) as total FROM ticketcompra tc " +
                       "JOIN detalleticket dt ON tc.idDetalleTicket = dt.idDetalleTicket " +
                       "JOIN funcion f ON dt.idFuncion = f.idFuncion " +
                       "WHERE f.idPelicula = ? AND tc.fechaCompra BETWEEN ? AND ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idPelicula);
            ps.setDate(2, java.sql.Date.valueOf(fechaInicio));
            ps.setDate(3, java.sql.Date.valueOf(fechaFin));
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                cantidad = rs.getInt("total");
            }
            
            rs.close();
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                "Error al contar tickets: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        
        return cantidad;
    }
}