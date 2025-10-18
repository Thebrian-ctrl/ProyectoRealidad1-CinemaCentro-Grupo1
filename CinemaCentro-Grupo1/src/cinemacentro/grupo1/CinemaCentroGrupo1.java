/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinemacentro.grupo1;

import Modelo.Pelicula;
import Persistencia.PeliculaData;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author arceb
 */
public class CinemaCentroGrupo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        //Pelicula peli1 = new Pelicula("El señor de los anillos", "Chritopher Nolan", "Brad pitt", "Estado Unidos", "Aventuras", LocalDate.of(2005, Month.MARCH, 15), true);
        
        PeliculaData pelidata = new PeliculaData();
        
        //pelidata.guardarPelicula(peli1);
        
        //Pelicula peli2 = new Pelicula("Troya", "Arce Brayan", "Brad pitt, Orlando blum", "Estados Unidos", "Historia", LocalDate.of(2000, Month.MARCH, 16), true);
        
        //pelidata.guardarPelicula(peli2);
        
        //-------------Probamos el metodo para buscar la pelicula por el nombre-------------------
        
//       Pelicula buscada = pelidata.buscarPelicula("El señor de los anillos");
//       
//       if(buscada != null){
//           System.out.println("Pelicula encontrada: " + buscada.toString());
//       
//       }

        //------------Probamos el metodo para listar las peliculas------------------
//        List<Pelicula> peliculaEnCartelera = pelidata.listarPeliculasCartelera();
//        
//        for (Pelicula peli : peliculaEnCartelera) {
//            System.out.println(peli);
//        }

        //---------------Prueba de dar de baja a una pelicula (cartelera)-------------
        
        //pelidata.darBajaCartelera(1);
        
//        List<Pelicula> peliculaEnCartelera = pelidata.listarPeliculasCartelera();
//        
//       for (Pelicula peli : peliculaEnCartelera) {
//            System.out.println(peli);
//        }
       
       //--------------Prueba dar de alta a una pelicula-------------
       
//       pelidata.darAltaCartelera(1);
//       List<Pelicula> peliculaEnCartelera = pelidata.listarPeliculasCartelera();
//        
//       for (Pelicula peli : peliculaEnCartelera) {
//            System.out.println(peli);
//        }

        
        //-----------------Prueba eliminar pelicula-----------------
//        pelidata.eliminarPelicula(2);
//        List<Pelicula> peliculaEnCartelera = pelidata.listarPeliculasCartelera();
//        
//       for (Pelicula peli : peliculaEnCartelera) {
//            System.out.println(peli);
//        }
    }
    
}
