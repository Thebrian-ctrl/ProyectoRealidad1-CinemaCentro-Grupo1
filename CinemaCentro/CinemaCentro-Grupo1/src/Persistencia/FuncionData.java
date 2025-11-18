/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;



import Modelo.Comprador;
import Modelo.Funcion;
import Modelo.Lugar;
import Modelo.MyConexion;
import Modelo.Pelicula;
import Modelo.Sala;
import java.awt.geom.Ellipse2D;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class FuncionData {
    
      private final Connection conn;
    
    private LugarData lugarData;

    public FuncionData() {
        conn = MyConexion.buscarConexion();
        this.lugarData = new LugarData();
    }
    
     public void guardarFuncion(Funcion funcion) {
        String query = "INSERT INTO Funcion (idPelicula, idioma, es3d, subtitulado, horarioInicio, horarioFin, idSala, precio)"
            + " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

    try {
        PreparedStatement ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

        ps.setInt(1, funcion.getPelicula().getIdPelicula());
        ps.setString(2, funcion.getIdioma());
        ps.setBoolean(3, funcion.isEs3d());
        ps.setBoolean(4, funcion.isSubtitulado());
        ps.setTimestamp(5, java.sql.Timestamp.valueOf(funcion.getHoraInicio()));
        ps.setTimestamp(6, java.sql.Timestamp.valueOf(funcion.getHoraFin()));
        ps.setInt(7, funcion.getSalaProyeccion().getIdSala());
        ps.setDouble(8, funcion.getPrecio());

        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();

        if (rs.next()) {
           
            funcion.setIdFuncion(rs.getInt(1));
            
     
            crearLugaresParaFuncion(funcion);
            
            JOptionPane.showMessageDialog(null, "Función guardada correctamente");
            
            ps.close();
            rs.close();
        } else {
            JOptionPane.showMessageDialog(null, "Error al guardar la funcion");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla: " + e.getMessage());
        e.printStackTrace();
    }

    }
     
     public void actualizarFuncion(Funcion f) {
        String query = "UPDATE funcion SET idPelicula= ?, idioma = ?, es3d = ?, subtitulado = ?, horarioInicio = ?, horarioFin = ?, idSala = ?, precio = ? WHERE idFuncion = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, f.getPelicula().getIdPelicula());
            ps.setString(2, f.getIdioma());
            ps.setBoolean(3, f.isEs3d());
            ps.setBoolean(4, f.isSubtitulado());
            ps.setTimestamp(5, java.sql.Timestamp.valueOf(f.getHoraInicio()));
            ps.setTimestamp(6, java.sql.Timestamp.valueOf(f.getHoraFin()));        
            ps.setInt(7, f.getSalaProyeccion().getIdSala());
            ps.setDouble(8, f.getPrecio());
            
            ps.setInt(9, f.getIdFuncion());

            int actualizado = ps.executeUpdate();

            if (actualizado == 1) {
                JOptionPane.showMessageDialog(null, "Funcion actualizada correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar la funcion");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la funcion ");
        }

    }
    
    public void eliminarFuncion(int idFuncion){
        
       String query = "DELETE FROM funcion WHERE idFuncion = ?";
       String deleteLugares = "DELETE FROM lugar WHERE idFuncion = ?";
       
        try {
   
            PreparedStatement ps1 = conn.prepareStatement(deleteLugares);
            ps1.setInt(1, idFuncion);
            ps1.executeUpdate();
            ps1.close();
            
            
            PreparedStatement ps= conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, idFuncion);
            int eliminado = ps.executeUpdate();
            
            
            if(eliminado > 1) {
                JOptionPane.showMessageDialog(null, "Funcion eliminado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la funcion con ese ID");
            }
            ps.close();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar la funcion");
        }
      
  }
    
    public List<Funcion> listarFuncion() {
        List<Funcion> funcion = new ArrayList<>();
        
 
        String query = "SELECT f.idFuncion, f.idioma, f.es3d, f.subtitulado, f.horarioInicio, f.horarioFin, f.precio, "
                + "p.idPelicula, p.titulo, p.director, p.actores, p.origen, p.genero, p.estreno, p.cartelera, "
                + "s.idSala, s.nroSala, s.apta3d, s.capacidad, s.estado "
                + "FROM funcion f "
                + "LEFT JOIN pelicula p ON (f.idPelicula = p.idPelicula)"
                + "LEFT JOIN sala s ON (f.idSala = s.idSala)";
         try {
            PreparedStatement ps= conn.prepareStatement(query);
            
            
            
            ResultSet rs = ps.executeQuery();
            
            
            
            while(rs.next()) {
                Pelicula p = new Pelicula();
                p.setIdPelicula(rs.getInt("idPelicula"));
                p.setTitulo(rs.getString("titulo"));
                p.setDirector(rs.getString("director"));
                p.setActores(rs.getString("actores"));
                p.setOrigen(rs.getString("origen"));
                p.setGenero(rs.getString("genero"));
                p.setEstreno(rs.getDate("estreno").toLocalDate());
                p.setCartelera(rs.getBoolean("cartelera"));
                
                Sala s = new Sala();
                s.setIdSala(rs.getInt("idSala"));
                s.setNroSala(rs.getInt("nroSala"));
                s.setApto3d(rs.getBoolean("apta3d"));
                s.setCapacidad(rs.getInt("capacidad"));
                s.setEstado(rs.getBoolean("estado"));
                
                Funcion f = new Funcion();
                f.setIdFuncion(rs.getInt("idFuncion"));
                f.setIdioma(rs.getString("idioma"));
                f.setEs3d(rs.getBoolean("es3d"));
                f.setSubtitulado(rs.getBoolean("subtitulado"));
                f.setHoraInicio(rs.getTimestamp("horarioinicio").toLocalDateTime());
                f.setHoraFin(rs.getTimestamp("horariofin").toLocalDateTime());
                f.setPrecio(rs.getDouble("precio"));
                
            
                f.setPelicula(p);
                f.setSalaProyeccion(s);                           
                
             
                List<Lugar> lugaresDisponibles = lugarData.buscarLugaresPorFuncion(f.getIdFuncion());
             
                for (Lugar lugar : lugaresDisponibles) {
                    lugar.setFuncion(f);
                }
                
             
                f.setListaLugaresDisp(lugaresDisponibles);
                
                funcion.add(f);
            }
            
            ps.close();
            rs.close();
            
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "error de tabla");
        }
        return funcion;
    }
    
    public Funcion buscarFuncion(int idFuncion){
        Funcion funcion = null;
        
        String query = "SELECT * FROM funcion WHERE idFuncion = ?";
        
        try {
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setInt(1, idFuncion);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                funcion = new Funcion();
                
                funcion.setIdFuncion(rs.getInt("idFuncion"));
                
                int idPelicula = rs.getInt("idPelicula");
                PeliculaData peliculaData = new PeliculaData();
                Pelicula pelicula = peliculaData.buscarPeliculaPorId(idPelicula);
                funcion.setPelicula(pelicula);
                
                funcion.setIdioma(rs.getString("idioma"));
                funcion.setEs3d(rs.getBoolean("es3d"));
                funcion.setSubtitulado(rs.getBoolean("subtitulado"));
                funcion.setHoraInicio(rs.getTimestamp("horarioInicio").toLocalDateTime());
                funcion.setHoraFin(rs.getTimestamp("horarioFin").toLocalDateTime());
                funcion.setPrecio(rs.getDouble("precio"));
                
                int idSala = rs.getInt("idSala");
                SalaData salaData = new SalaData();
                 Sala sala = salaData.buscarSala(idSala);
                funcion.setSalaProyeccion(sala);
                
               String query2 = "SELECT * FROM lugar WHERE idFuncion = ?";
               PreparedStatement ps2 = conn.prepareStatement(query2);
               
               ps2.setInt(1, idFuncion);
               
               ResultSet rs2 = ps2.executeQuery();
               List<Lugar> lugares = new ArrayList();
               
               while(rs2.next()){
                   Lugar l1 = new Lugar();
                   
                   l1.setIdLugar(rs2.getInt("idLugar"));                  
                   l1.setFila(rs2.getString("fila").charAt(0));
                   l1.setNum(rs2.getInt("num"));
                   l1.setEstado(rs2.getBoolean("estado"));
                   
                   lugares.add(l1);
                   
               }
               funcion.setListaLugaresDisp(lugares);
               rs2.close();
               ps2.close();
            }
            
            rs.close();
            ps.close();
            
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR");
        }
        
        return funcion;
    }
    
    
    public void actualizarPrecio2D(double nuevoPrecio) {
    String query = "UPDATE funcion SET precio = ? WHERE es3d = false";
    
    try {
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setDouble(1, nuevoPrecio);
        
        int actualizados = ps.executeUpdate();
        JOptionPane.showMessageDialog(null, 
            "Se actualizaron " + actualizados + " funciones 2D con el nuevo precio");
        
        ps.close();
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al actualizar precios 2D: " + e.getMessage());
    }
}

public void actualizarPrecio3D(double nuevoPrecio) {
    String query = "UPDATE funcion SET precio = ? WHERE es3d = true";
    
    try {
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setDouble(1, nuevoPrecio);
        
        int actualizados = ps.executeUpdate();
        JOptionPane.showMessageDialog(null, 
            "Se actualizaron " + actualizados + " funciones 3D con el nuevo precio");
        
        ps.close();
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al actualizar precios 3D: " + e.getMessage());
    }
}

public List<Sala> listarSalasPorPelicula(int idPelicula) {
    List<Sala> salas = new ArrayList<>();
    String query = "SELECT DISTINCT s.* FROM sala s " +
                   "INNER JOIN funcion f ON s.idSala = f.idSala " +
                   "WHERE f.idPelicula = ?";
    
    try {
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, idPelicula);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()) {
            Sala sala = new Sala();
            sala.setIdSala(rs.getInt("idSala"));
            sala.setNroSala(rs.getInt("nroSala"));
            sala.setApto3d(rs.getBoolean("apta3d"));
            sala.setCapacidad(rs.getInt("capacidad"));
            sala.setEstado(rs.getBoolean("estado"));
            
            salas.add(sala);
        }
        
        ps.close();
        rs.close();
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al listar salas: " + e.getMessage());
    }
    
    return salas;
}

public List<Pelicula> listarPeliculasPorSalaYHorario(int idSala, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin) {
    List<Pelicula> peliculas = new ArrayList<>();
    
    String query = "SELECT DISTINCT p.* FROM pelicula p " +
                   "INNER JOIN funcion f ON p.idPelicula = f.idPelicula " +
                   "WHERE f.idSala = ? " +
                   "AND DATE(f.horarioInicio) = ? " +
                   "AND TIME(f.horarioInicio) BETWEEN ? AND ?";
    
    try {
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, idSala);
        ps.setDate(2, java.sql.Date.valueOf(fecha));
        ps.setTime(3, java.sql.Time.valueOf(horaInicio));
        ps.setTime(4, java.sql.Time.valueOf(horaFin));
        
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()) {
            Pelicula p = new Pelicula();
            p.setIdPelicula(rs.getInt("idPelicula"));
            p.setTitulo(rs.getString("titulo"));
            p.setDirector(rs.getString("director"));
            p.setActores(rs.getString("actores"));
            p.setOrigen(rs.getString("origen"));
            p.setGenero(rs.getString("genero"));
            p.setEstreno(rs.getDate("estreno").toLocalDate());
            p.setCartelera(rs.getBoolean("cartelera"));
            p.setRutaImagen(rs.getString("rutaImagen"));
            
            peliculas.add(p);
        }
        
        ps.close();
        rs.close();
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, 
            "Error al listar películas: " + e.getMessage());
    }
    
    return peliculas;

}
    public void crearLugaresParaFuncion (Funcion funcion){
      
    if (funcion.getIdFuncion() <= 0) {
        JOptionPane.showMessageDialog(null, 
            "Error: La función debe estar guardada antes de crear lugares");
        return;
    }
    
    LugarData lugarData = new LugarData();
    
    int capacidad = funcion.getSalaProyeccion().getCapacidad();
    int asientosPorFila = 4;
    int totalFilas = (int)Math.ceil((double)capacidad/asientosPorFila);
    
    char fila = 'A';
    int asientoEnFila = 1;
    
    for (int i = 1; i <= capacidad; i++) {
        Lugar lugar = new Lugar();
        lugar.setFila(fila);
        lugar.setNum(asientoEnFila);
        lugar.setEstado(true);
        lugar.setFuncion(funcion); 
        
        lugarData.guardarLugar(lugar);
        
        asientoEnFila++;
        
        if(asientoEnFila > asientosPorFila){
            fila++;
            asientoEnFila = 1;
        }
    }

    JOptionPane.showMessageDialog(null, 
        "Se crearon automáticamente " + capacidad + " lugares para la función");
    
    }

   public List<Funcion> listarFuncionesPorFecha(LocalDate fecha) {
    List<Funcion> funciones = new ArrayList<>();
    
    String query = "SELECT f.idFuncion, f.idioma, f.es3d, f.subtitulado, " +
                   "f.horarioInicio, f.horarioFin, f.precio, " +
                   "p.idPelicula, p.titulo, p.director, p.actores, p.origen, " +
                   "p.genero, p.estreno, p.cartelera, " +
                   "s.idSala, s.nroSala, s.apta3d, s.capacidad, s.estado " +
                   "FROM funcion f " +
                   "INNER JOIN pelicula p ON f.idPelicula = p.idPelicula " +
                   "INNER JOIN sala s ON f.idSala = s.idSala " +
                   "WHERE DATE(f.horarioInicio) = ?";
    
    try {
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setDate(1, java.sql.Date.valueOf(fecha));
        
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()) {
           
            Pelicula p = new Pelicula();
            p.setIdPelicula(rs.getInt("idPelicula"));
            p.setTitulo(rs.getString("titulo"));
            p.setDirector(rs.getString("director"));
            p.setActores(rs.getString("actores"));
            p.setOrigen(rs.getString("origen"));
            p.setGenero(rs.getString("genero"));
            p.setEstreno(rs.getDate("estreno").toLocalDate());
            p.setCartelera(rs.getBoolean("cartelera"));
            
        
            Sala s = new Sala();
            s.setIdSala(rs.getInt("idSala"));
            s.setNroSala(rs.getInt("nroSala"));
            s.setApto3d(rs.getBoolean("apta3d"));
            s.setCapacidad(rs.getInt("capacidad"));
            s.setEstado(rs.getBoolean("estado"));
            
          
            Funcion f = new Funcion();
            f.setIdFuncion(rs.getInt("idFuncion"));
            f.setIdioma(rs.getString("idioma"));
            f.setEs3d(rs.getBoolean("es3d"));
            f.setSubtitulado(rs.getBoolean("subtitulado"));
            f.setHoraInicio(rs.getTimestamp("horarioInicio").toLocalDateTime());
            f.setHoraFin(rs.getTimestamp("horarioFin").toLocalDateTime());
            f.setPrecio(rs.getDouble("precio"));
            f.setPelicula(p);
            f.setSalaProyeccion(s);
            
            funciones.add(f);
        }
        
        ps.close();
        rs.close();
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, 
            "Error al listar funciones por fecha: " + e.getMessage());
        e.printStackTrace();
    }
    
    return funciones;
   }
   
 
   public List<Funcion> buscarFuncionesPorPelicula(int idPelicula) {
       List<Funcion> funciones = new ArrayList<>();
       
       String query = "SELECT f.idFuncion, f.idioma, f.es3d, f.subtitulado, " +
                      "f.horarioInicio, f.horarioFin, f.precio, " +
                      "p.idPelicula, p.titulo, p.director, p.actores, p.origen, " +
                      "p.genero, p.estreno, p.cartelera, p.rutaImagen, " +
                      "s.idSala, s.nroSala, s.apta3d, s.capacidad, s.estado " +
                      "FROM funcion f " +
                      "INNER JOIN pelicula p ON f.idPelicula = p.idPelicula " +
                      "INNER JOIN sala s ON f.idSala = s.idSala " +
                      "WHERE f.idPelicula = ? " +
                      "ORDER BY f.horarioInicio";
       
       try {
           PreparedStatement ps = conn.prepareStatement(query);
           ps.setInt(1, idPelicula);
           
           ResultSet rs = ps.executeQuery();
           
           while(rs.next()) {
               Pelicula p = new Pelicula();
               p.setIdPelicula(rs.getInt("idPelicula"));
               p.setTitulo(rs.getString("titulo"));
               p.setDirector(rs.getString("director"));
               p.setActores(rs.getString("actores"));
               p.setOrigen(rs.getString("origen"));
               p.setGenero(rs.getString("genero"));
               p.setEstreno(rs.getDate("estreno").toLocalDate());
               p.setCartelera(rs.getBoolean("cartelera"));
               p.setRutaImagen(rs.getString("rutaImagen"));
               
               Sala s = new Sala();
               s.setIdSala(rs.getInt("idSala"));
               s.setNroSala(rs.getInt("nroSala"));
               s.setApto3d(rs.getBoolean("apta3d"));
               s.setCapacidad(rs.getInt("capacidad"));
               s.setEstado(rs.getBoolean("estado"));
               
               Funcion f = new Funcion();
               f.setIdFuncion(rs.getInt("idFuncion"));
               f.setIdioma(rs.getString("idioma"));
               f.setEs3d(rs.getBoolean("es3d"));
               f.setSubtitulado(rs.getBoolean("subtitulado"));
               f.setHoraInicio(rs.getTimestamp("horarioInicio").toLocalDateTime());
               f.setHoraFin(rs.getTimestamp("horarioFin").toLocalDateTime());
               f.setPrecio(rs.getDouble("precio"));
               f.setPelicula(p);
               f.setSalaProyeccion(s);
               
               List<Lugar> lugaresDisponibles = lugarData.buscarLugaresPorFuncion(f.getIdFuncion());
               f.setListaLugaresDisp(lugaresDisponibles);
               
               funciones.add(f);
           }
           
           ps.close();
           rs.close();
           
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, 
               "Error al buscar funciones por película: " + e.getMessage());
       }
       
       return funciones;
   }
   
 
   public List<Funcion> buscarFuncionesPorSala(int idSala) {
       List<Funcion> funciones = new ArrayList<>();
       
       String query = "SELECT f.idFuncion, f.idioma, f.es3d, f.subtitulado, " +
                      "f.horarioInicio, f.horarioFin, f.precio, " +
                      "p.idPelicula, p.titulo, p.director, p.actores, p.origen, " +
                      "p.genero, p.estreno, p.cartelera, p.rutaImagen, " +
                      "s.idSala, s.nroSala, s.apta3d, s.capacidad, s.estado " +
                      "FROM funcion f " +
                      "INNER JOIN pelicula p ON f.idPelicula = p.idPelicula " +
                      "INNER JOIN sala s ON f.idSala = s.idSala " +
                      "WHERE f.idSala = ? " +
                      "ORDER BY f.horarioInicio";
       
       try {
           PreparedStatement ps = conn.prepareStatement(query);
           ps.setInt(1, idSala);
           ResultSet rs = ps.executeQuery();
           
           while(rs.next()) {
               Pelicula p = new Pelicula();
               p.setIdPelicula(rs.getInt("idPelicula"));
               p.setTitulo(rs.getString("titulo"));
               p.setDirector(rs.getString("director"));
               p.setActores(rs.getString("actores"));
               p.setOrigen(rs.getString("origen"));
               p.setGenero(rs.getString("genero"));
               p.setEstreno(rs.getDate("estreno").toLocalDate());
               p.setCartelera(rs.getBoolean("cartelera"));
               p.setRutaImagen(rs.getString("rutaImagen"));
               
               Sala s = new Sala();
               s.setIdSala(rs.getInt("idSala"));
               s.setNroSala(rs.getInt("nroSala"));
               s.setApto3d(rs.getBoolean("apta3d"));
               s.setCapacidad(rs.getInt("capacidad"));
               s.setEstado(rs.getBoolean("estado"));
               
               Funcion f = new Funcion();
               f.setIdFuncion(rs.getInt("idFuncion"));
               f.setIdioma(rs.getString("idioma"));
               f.setEs3d(rs.getBoolean("es3d"));
               f.setSubtitulado(rs.getBoolean("subtitulado"));
               f.setHoraInicio(rs.getTimestamp("horarioInicio").toLocalDateTime());
               f.setHoraFin(rs.getTimestamp("horarioFin").toLocalDateTime());
               f.setPrecio(rs.getDouble("precio"));
               f.setPelicula(p);
               f.setSalaProyeccion(s);
               
               List<Lugar> lugaresDisponibles = lugarData.buscarLugaresPorFuncion(f.getIdFuncion());
               f.setListaLugaresDisp(lugaresDisponibles);
               
               funciones.add(f);
           }
           ps.close();
           rs.close();
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error al buscar funciones por sala: " + e.getMessage());
       }
       return funciones;
   }
   
 
   public int contarLugaresDisponibles(int idFuncion) {
       int cantidad = 0;
       String query = "SELECT COUNT(*) as total FROM lugar WHERE idFuncion = ? AND estado = true";
       try {
           PreparedStatement ps = conn.prepareStatement(query);
           ps.setInt(1, idFuncion);
           ResultSet rs = ps.executeQuery();
           if(rs.next()) {
               cantidad = rs.getInt("total");
           }
           ps.close();
           rs.close();
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error al contar lugares disponibles: " + e.getMessage());
       }
       return cantidad;
   }
   

   public boolean hayLugaresDisponibles(int idPelicula, boolean es3d, String horario) {
       String query = "SELECT COUNT(l.idLugar) as disponibles " +
                      "FROM lugar l INNER JOIN funcion f ON l.idFuncion = f.idFuncion " +
                      "WHERE f.idPelicula = ? AND f.es3d = ? AND TIME(f.horarioInicio) = ? AND l.estado = true";
       try {
           PreparedStatement ps = conn.prepareStatement(query);
           ps.setInt(1, idPelicula);
           ps.setBoolean(2, es3d);
           ps.setTime(3, java.sql.Time.valueOf(horario));
           ResultSet rs = ps.executeQuery();
           if(rs.next()) {
               int disponibles = rs.getInt("disponibles");
               ps.close();
               rs.close();
               return disponibles > 0;
           }
           ps.close();
           rs.close();
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error al verificar disponibilidad: " + e.getMessage());
       }
       return false;
   }
   

   public void actualizarPrecioFuncion(int idFuncion, double nuevoPrecio) {
       String query = "UPDATE funcion SET precio = ? WHERE idFuncion = ?";
       try {
           PreparedStatement ps = conn.prepareStatement(query);
           ps.setDouble(1, nuevoPrecio);
           ps.setInt(2, idFuncion);
           int actualizado = ps.executeUpdate();
           if(actualizado == 1) {
               JOptionPane.showMessageDialog(null, "Precio actualizado correctamente");
           } else {
               JOptionPane.showMessageDialog(null, "No se encontró la función");
           }
           ps.close();
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error al actualizar precio: " + e.getMessage());
       }
   }
public Funcion buscarFuncionPorId(int idFuncion) {
    Funcion funcion = null;
    String query = "SELECT * FROM funcion WHERE idFuncion = ?";
    
    try {
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, idFuncion);
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            funcion = new Funcion();
            funcion.setIdFuncion(rs.getInt("idFuncion"));
            funcion.setIdioma(rs.getString("idioma"));
            funcion.setEs3d(rs.getBoolean("es3d"));
            funcion.setSubtitulado(rs.getBoolean("subtitulado"));
            funcion.setHoraInicio(rs.getTimestamp("horarioInicio").toLocalDateTime());
            funcion.setHoraFin(rs.getTimestamp("horarioFin").toLocalDateTime());
            funcion.setPrecio(rs.getDouble("precio"));
            
        
            int idPelicula = rs.getInt("idPelicula");
            PeliculaData peliculaData = new PeliculaData();
            Pelicula pelicula = peliculaData.buscarPeliculaPorId(idPelicula);
            funcion.setPelicula(pelicula);
            
          
            int idSala = rs.getInt("idSala");
            SalaData salaData = new SalaData();
            Sala sala = salaData.buscarSala(idSala);
            funcion.setSalaProyeccion(sala);
        }
        
        rs.close();
        ps.close();
        
    } catch (SQLException e) {
        System.out.println("Error al buscar función por ID: " + e.getMessage());
        e.printStackTrace();
    }
    
    return funcion;
}
}
