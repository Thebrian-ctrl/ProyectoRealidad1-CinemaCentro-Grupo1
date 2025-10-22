/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;



import Modelo.Comprador;
import Modelo.Funcion;
import Modelo.MyConexion;
import Modelo.Pelicula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class FuncionData {
    
    private final Connection conn;

    public FuncionData() {
        conn = MyConexion.buscarConexion();
    }
    
     public void guardarFuncion(Funcion funcion) {
        String query = "INSERT INTO Funcion (idPelicula, idioma, es3d, subtitulado, horainicio, horafin, lugardisponible, idSala, precio) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setInt(1, funcion.getPelicula().getIdPelicula());
            ps.setString(2, funcion.getIdioma());
            ps.setBoolean(3, funcion.isEs3d());
            ps.setBoolean(4, funcion.isSubtitulado());
            ps.setTime(5, Time.valueOf(funcion.getHoraInicio()));
            ps.setTime(6, Time.valueOf(funcion.getHoraFin()));
            ps.setInt(7, funcion.getListaLugaresDisp());
            ps.setInt(8, funcion.getSalaProyeccion().getIdSala());
            ps.setDouble(9, funcion.getPrecio());
            

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                funcion.setIdFuncion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Funcion guardado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar la funcion");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla: " + e.getMessage());
        }

    }
     
     public void actualizarFuncion(Funcion f) {
        String query = "UPDATE funcion SET idPelicula = ?, idioma = ?, es3d = ?, subtitulado = ?, horainicio = ?, horafin = ?, lugardisponible = ?, idSala = ?, precio = ? WHERE idFuncion = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setInt(1, f.getPelicula().getIdPelicula());
            ps.setString(2, f.getIdioma());
            ps.setBoolean(3, f.isEs3d());
            ps.setBoolean(4, f.isSubtitulado());
            ps.setTime(5, Time.valueOf(f.getHoraInicio()));
            ps.setTime(6, Time.valueOf(f.getHoraFin()));
            ps.setInt(7, f.getListaLugaresDisp());
            ps.setInt(8, f.getSalaProyeccion().getIdSala());
            ps.setDouble(9, f.getPrecio());

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
    
    public void eliminarFuncion(int idFuncion){
       String query = "DELETE FROM funcion WHERE idFuncion = ?";
       
       
        try {
            PreparedStatement ps= conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, idFuncion);
            int eliminado = ps.executeUpdate();
            
            
            if(eliminado == 1) {
                JOptionPane.showMessageDialog(null, "Funcion eliminado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la funcion con ese ID");
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar la funcion");
        }
      
  }
    
    public List<Funcion> listarFuncion() {
        List<Funcion> funcion = new ArrayList<>();
        String query = "SELECT * FROM funcion";
         try {
            PreparedStatement ps= conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            
            
            
            while(rs.next()) {
                Funcion f = new Funcion();
                Pelicula p = new Pelicula();
                f.setIdFuncion(rs.getInt("idFuncion"));
                p.setIdPelicula(rs.getInt("idPelicula"));
                f.setIdioma(rs.getString("idioma"));
                f.setEs3d(rs.getBoolean("es3d"));
                f.setSubtitulado(rs.getBoolean("subtitulado"));
                f.setHoraInicio(rs.getTime("horainicio").toLocalTime());
                f.setHoraFin(rs.getTime("horafin").toLocalTime());
                f.setListaLugaresDisp(rs.getInt("lugardisponible"));
             // f.setSalaProyeccion(rs.getInt("idSala"));
                f.setPrecio(rs.getDouble("precio"));
                
                funcion.add(f);
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar funcion: " + e.getMessage());
        }
        return funcion;
    }
}
