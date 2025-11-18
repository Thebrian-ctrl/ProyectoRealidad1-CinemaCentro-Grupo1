/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.MyConexion;
import Modelo.Pelicula;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class PeliculaData {
    
     private final Connection conn;
    
    public PeliculaData (){
        conn = MyConexion.buscarConexion();
    
    }
    
    public void guardarPelicula(Pelicula p){
        String query = "INSERT INTO pelicula(titulo, director, actores, origen, genero, estreno, cartelera, rutaImagen)"
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps= conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, p.getTitulo());
            ps.setString(2, p.getDirector());
            ps.setString(3, p.getActores());
            ps.setString(4, p.getOrigen());
            ps.setString(5, p.getGenero());
            ps.setDate(6, Date.valueOf(p.getEstreno()));
            ps.setBoolean(7, p.isCartelera());
            ps.setString(8, p.getRutaImagen());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if(rs.next()) {
                p.setIdPelicula(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Pelicula guardada correctamente");
            
            }else{
                JOptionPane.showMessageDialog(null, "Error al guardar la pelicula");
            }
            ps.close();
            System.out.println("Guardado");
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla" + e.getMessage());
        }
    
    }      
    
    public Pelicula buscarPelicula (String titulo){
    
        String query = "SELECT * FROM pelicula WHERE titulo = ?";
        
        Pelicula peli = null;
        
        try{
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, titulo);
        
        ResultSet rs = ps.executeQuery();
        
        
            if(rs.next()){
              peli = new Pelicula();
              peli.setIdPelicula(rs.getInt("idPelicula"));
              peli.setTitulo(rs.getString("titulo"));
              peli.setDirector(rs.getString("director"));
              peli.setActores(rs.getString("actores"));
              peli.setOrigen(rs.getString("origen"));
              peli.setGenero(rs.getString("genero"));
              peli.setEstreno(rs.getDate("estreno").toLocalDate());
              peli.setCartelera(rs.getBoolean("cartelera"));
              peli.setRutaImagen(rs.getString("rutaImagen"));
        
        
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro la pelicula " + titulo + " en la base de datos");
            }
            ps.close();
    
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "Error al buscar la pelicula solicitada: " + e.getMessage());
        
        }
        
        return peli;
    }
    
    public List<Pelicula> listarPeliculasCartelera(){
        String query = "SELECT * FROM pelicula WHERE cartelera = true";
        
        List<Pelicula> peliculas = new ArrayList<>();
        
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                
                while(rs.next()){
                    
                    Pelicula peli = new Pelicula();
                    
                    peli.setIdPelicula(rs.getInt("idPelicula"));
                    peli.setTitulo(rs.getString("titulo"));
                    peli.setDirector(rs.getString("director"));
                    peli.setActores(rs.getString("actores"));
                    peli.setOrigen(rs.getString("origen"));
                    peli.setGenero(rs.getString("genero"));
                    peli.setEstreno(rs.getDate("estreno").toLocalDate());
                    peli.setCartelera(rs.getBoolean("cartelera"));
                    peli.setRutaImagen(rs.getString("rutaImagen"));
                    
                    peliculas.add(peli);
                
                
                }
                
                ps.close();
                
                
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar las peliculas en cartelera: " + e.getMessage());
            
        }
            return peliculas;
    }
    
    public void darBajaCartelera(int idPelicula){
        String query = "UPDATE pelicula SET cartelera = false WHERE idPelicula = ?";
        
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, idPelicula);
                
                int actualizado = ps.executeUpdate();
                
                if(actualizado == 1){
                    JOptionPane.showMessageDialog(null, "Pelicula dada de baja correctamente");                           
                }else{
                    JOptionPane.showMessageDialog(null, "No se encontro pelicula con el id especificado");                    
                }
                ps.close();                                            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al dar de baja a la pelicula: " + e.getMessage());
        }   
    }
    
    
    public void darAltaCartelera(int idPelicula){
        String query = "UPDATE pelicula SET cartelera = true WHERE idPelicula = ?";
        
            try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idPelicula);
             
            int actualizado = ps.executeUpdate();
            
            if(actualizado == 1){
                JOptionPane.showMessageDialog(null, "Pelicula dada de alta correctamente");           
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro pelicula con el id especificado");
            }
                ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al dar de alta a la pelicula: " + e.getMessage());
            
        }
    
    
    }
    
    public void eliminarPelicula(int idPelicula){
        String query = "DELETE FROM pelicula WHERE idPelicula = ?";
        
            try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idPelicula);
            
            int eliminado = ps.executeUpdate();
                if(eliminado == 1){
                    JOptionPane.showMessageDialog(null, "Pelicula eliminada correctamente de la base de datos");                
                }else{
                JOptionPane.showInternalMessageDialog(null, "No se encontro pelicula con ese id");
                }
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la pelicula especificada" + e.getMessage());
        }
    
    
    }
    
    public void actualizarPelicula(Pelicula p){
        String query = "UPDATE pelicula SET titulo = ?, director = ?, actores = ?, origen = ?, genero = ?, estreno = ?, cartelera = ?, rutaImagen = ?"
                + "WHERE idPelicula = ?";
    
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, p.getTitulo());
            ps.setString(2, p.getDirector());
            ps.setString(3, p.getActores());
            ps.setString(4, p.getOrigen());
            ps.setString(5, p.getGenero());
            ps.setDate(6, Date.valueOf(p.getEstreno()));
            ps.setBoolean(7, p.isCartelera());
            ps.setString(8, p.getRutaImagen());
            
            ps.setInt(9, p.getIdPelicula());
            
            int actualizado = ps.executeUpdate();
            
            if(actualizado == 1){
                JOptionPane.showMessageDialog(null, "Datos de la pelicula actualizados correctamente");
            }else{
                JOptionPane.showMessageDialog(null, "Error al actualizar los datos de la pelicula");
            }
       
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla" + e.getMessage());
        }
    }
    
   public int actualizarCarteleraPorFecha() {
    String query = "UPDATE pelicula SET cartelera = true " +
                   "WHERE estreno <= CURDATE() AND cartelera = false";
    
    try {
        PreparedStatement ps = conn.prepareStatement(query);
        int actualizadas = ps.executeUpdate();
        ps.close();
        
        return actualizadas; 
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, 
            "Error al actualizar cartelera: " + e.getMessage());
        return 0;
    }
   }
    public Pelicula buscarPeliculaPorId(int idPelicula) {
    
    String query = "SELECT * FROM pelicula WHERE idPelicula = ?";
    Pelicula peli = null;
    
    try {
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, idPelicula);
        
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            peli = new Pelicula();
            peli.setIdPelicula(rs.getInt("idPelicula"));
            peli.setTitulo(rs.getString("titulo"));
            peli.setDirector(rs.getString("director"));
            peli.setActores(rs.getString("actores"));
            peli.setOrigen(rs.getString("origen"));
            peli.setGenero(rs.getString("genero"));
            peli.setEstreno(rs.getDate("estreno").toLocalDate());
            peli.setCartelera(rs.getBoolean("cartelera"));
            peli.setRutaImagen(rs.getString("rutaImagen"));
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró la película con ID " + idPelicula);
        }
        
        ps.close();
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al buscar la película por ID: " + e.getMessage());
    }
    
    return peli;
}
    public List<Pelicula> listarProximosEstrenos() {
    List<Pelicula> peliculas = new ArrayList<>();
    String query = "SELECT * FROM pelicula WHERE estreno > CURDATE() AND cartelera = false ORDER BY estreno ASC";
    
    try {
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()) {
            Pelicula peli = new Pelicula();
            peli.setIdPelicula(rs.getInt("idPelicula"));
            peli.setTitulo(rs.getString("titulo"));
            peli.setDirector(rs.getString("director"));
            peli.setActores(rs.getString("actores"));
            peli.setOrigen(rs.getString("origen"));
            peli.setGenero(rs.getString("genero"));
            peli.setEstreno(rs.getDate("estreno").toLocalDate());
            peli.setCartelera(rs.getBoolean("cartelera"));
            peli.setRutaImagen(rs.getString("rutaImagen"));
            
            peliculas.add(peli);
        }
        ps.close();
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al listar próximos estrenos: " + e.getMessage());
    }
    
    return peliculas;
}
   
 
   public List<Object[]> obtenerPeliculasMasVistas(int limite) {
       List<Object[]> estadisticas = new ArrayList<>();
       
       String query = "SELECT p.idPelicula, p.titulo, p.genero, p.rutaImagen, " +
                      "COUNT(DISTINCT t.idTicket) as totalTickets, " +
                      "SUM(dt.cantidad) as totalEntradas, " +
                      "SUM(dt.subtotal) as recaudacion " +
                      "FROM pelicula p " +
                      "INNER JOIN funcion f ON p.idPelicula = f.idPelicula " +
                      "INNER JOIN detalleticket dt ON f.idFuncion = dt.idFuncion " +
                      "INNER JOIN ticketcompra t ON dt.idDetalleTicket = t.idDetalleTicket " +
                      "WHERE p.cartelera = true " +
                      "GROUP BY p.idPelicula, p.titulo, p.genero, p.rutaImagen " +
                      "ORDER BY totalEntradas DESC " +
                      "LIMIT ?";
       
       try {
           PreparedStatement ps = conn.prepareStatement(query);
           ps.setInt(1, limite);
           
           ResultSet rs = ps.executeQuery();
           
           while(rs.next()) {
               Object[] fila = new Object[7];
               fila[0] = rs.getInt("idPelicula");
               fila[1] = rs.getString("titulo");
               fila[2] = rs.getString("genero");
               fila[3] = rs.getString("rutaImagen");
               fila[4] = rs.getInt("totalTickets");
               fila[5] = rs.getInt("totalEntradas");
               fila[6] = rs.getDouble("recaudacion");
               
               estadisticas.add(fila);
           }
           
           ps.close();
           rs.close();
           
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, 
               "Error al obtener películas más vistas: " + e.getMessage());
       }
       
       return estadisticas;
   }
   
  
   public List<Pelicula> listarTodasPeliculas() {
       List<Pelicula> peliculas = new ArrayList<>();
       String query = "SELECT * FROM pelicula ORDER BY titulo";
       
       try {
           PreparedStatement ps = conn.prepareStatement(query);
           ResultSet rs = ps.executeQuery();
           
           while(rs.next()) {
               Pelicula peli = new Pelicula();
               peli.setIdPelicula(rs.getInt("idPelicula"));
               peli.setTitulo(rs.getString("titulo"));
               peli.setDirector(rs.getString("director"));
               peli.setActores(rs.getString("actores"));
               peli.setOrigen(rs.getString("origen"));
               peli.setGenero(rs.getString("genero"));
               peli.setEstreno(rs.getDate("estreno").toLocalDate());
               peli.setCartelera(rs.getBoolean("cartelera"));
               peli.setRutaImagen(rs.getString("rutaImagen"));
               
               peliculas.add(peli);
           }
           
           ps.close();
           rs.close();
           
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, 
               "Error al listar todas las películas: " + e.getMessage());
       }
       
       return peliculas;
   }
   
    
    
    
}
