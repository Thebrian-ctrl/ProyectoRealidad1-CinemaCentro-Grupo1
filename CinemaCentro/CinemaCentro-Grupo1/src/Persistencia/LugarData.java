/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Lugar;
import Modelo.MyConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class LugarData {

    private final Connection conn;

    public LugarData() {
        conn = MyConexion.buscarConexion();
    }

    public void guardarLugar(Lugar lugar) {
        String query = "INSERT INTO Lugar (fila, num, estado, idFuncion) VALUES(?, ?, ?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, String.valueOf(lugar.getFila()));
            ps.setInt(2, lugar.getNum());
            ps.setBoolean(3, lugar.isEstado());
            ps.setInt(4, lugar.getFuncion().getIdFuncion());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                lugar.setIdLugar(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Lugar guardado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar el Lugar");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla: " + e.getMessage());
        }

    }

    public void actualizarLugar(Lugar l) {
        String query = "UPDATE lugar SET fila = ?, num = ?, estado = ?, idFuncion = ? WHERE idLugar = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, String.valueOf(l.getFila()));
            ps.setInt(2, l.getNum());
            ps.setBoolean(3, l.isEstado());
            ps.setInt(4, l.getFuncion().getIdFuncion());

            int actualizado = ps.executeUpdate();

            if (actualizado == 1) {
                JOptionPane.showMessageDialog(null, "Datos del lugar actualizados correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar el lugar");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el lugar ");
        }

    }

    public void eliminarlugar(int idLugar) {
        String query = "DELETE FROM lugar WHERE idLugar = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setInt(1, idLugar);
            int eliminado = ps.executeUpdate();

            if (eliminado == 1) {
                JOptionPane.showMessageDialog(null, "Lugar eliminado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el lugar con ese ID");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el lugar");
        }

    }
    
     public void darBajaLugar(int idLugar){
        String query = "UPDATE lugar SET estado = false WHERE idLugar = ?";
        
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, idLugar);
                
                int actualizado = ps.executeUpdate();
                
                if(actualizado == 1){
                    JOptionPane.showMessageDialog(null, "Lugar dada de baja correctamente");                           
                }else{
                    JOptionPane.showMessageDialog(null, "No se encontro el lugar con el id especificado");                    
                }
                ps.close();                                            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al dar de baja a el lugar: " + e.getMessage());
        }   
    }
    
    
    public void darAltaLugar(int idLugar){
        String query = "UPDATE lugar SET estado = true WHERE idLugar = ?";
        
            try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idLugar);
             
            int actualizado = ps.executeUpdate();
            
            if(actualizado == 1){
                JOptionPane.showMessageDialog(null, "Lugar dada de alta correctamente");           
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro el lugar con el id especificado");
            }
                ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al dar de alta a el lugar: " + e.getMessage());
            
        }
    }
}