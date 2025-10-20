/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinemacentro.grupo1;

import Modelo.Comprador;
import Modelo.Pelicula;
import Modelo.Sala;
import Persistencia.CompradorData;
import Persistencia.PeliculaData;
import Persistencia.SalaData;
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






//-------------------------------<<======COMPRADOR DATA=====>>!!---------------

//
//    CompradorData compradorData = new CompradorData();
//    
//----------------creo comprador -----------------
//    
//    Comprador compra1 = new Comprador (41221751, "Gimenez Paula" , "123", "Mercado Pago", LocalDate.of(1998,06,06));
//    
//    compradorData.guardarComprador(compra1);
    
    
//    Comprador compra2 = new Comprador (42278291,"Arce Brayan", "231","Efectivo",LocalDate.of(1999,12,16));
//    
//    compradorData.guardarComprador(compra2);
//    
//    
//      Comprador compra3 = new Comprador (39092552,"Aguero Jonatan", "789","Tarjeta",LocalDate.of(1995,9,10));
//    compradorData.guardarComprador(compra3);
//    
//    
//    //---------------buscar comprador por dni
//    
//    Comprador compraBuscar= compradorData.buscarComprador(41221751);
//    
//    System.out.println("Comprador Buscado: "+ compraBuscar);
//    
//    
//    //buscamos uno q no este 
//    
//    Comprador BUSCAR = compradorData.buscarComprador(123456);
//    
//    
//    
//    //----------------------LISTAR COMPRADORES -----------
//     List <Comprador> lista = compradorData.listarCompradores();
//     
//     System.out.println("Listado de compradores");
//     
//     
//     for(Comprador c: lista){
//         System.out.println(c);
//     }
    
    //----------------ACTUALIZAR COMPRADOR--------------
//    Comprador compraBuscar= compradorData.buscarComprador(41221751);
//    
//    compraBuscar.setMedioDePago("Debito");
//    compradorData.actualizarComprador(compraBuscar);
//    
//     System.out.println("Comprador Actualizado "+ compraBuscar);
//     
//     
//     
//     compradorData.eliminarComprador(compraBuscar.getIdComprador());
//    
//    
//      List <Comprador> lista = compradorData.listarCompradores();
//     
//     System.out.println("Listado de compradores");
//     
//     
//     for(Comprador c: lista){
//         System.out.println(c);
//     }  





       SalaData salaData = new SalaData();

//        // -----------Guardar nueva sala--------
//       Sala sala1 = new Sala(1, true, 200, true); 
//       salaData.guardarSala(sala1);
//       System.out.println("Sala guardada: " + sala1);
//       Sala sala2 = new Sala(2, true, 180, true); 
//       salaData.guardarSala(sala2);
//       Sala sala3 = new Sala(3, true, 400, true); 
//       salaData.guardarSala(sala3);

       // ----- Buscar sala por ID-------------
       Sala salaBuscada = salaData.buscarSala(4);
       if (salaBuscada != null) {
            System.out.println("Sala encontrada: " + salaBuscada);
        }
         Sala salaBuscada2 = salaData.buscarSala(8);
         
         
       // ---------------- Listar todas las salas-----------------
       List<Sala> todasSalas = salaData.listarSalas();
       System.out.println("Listado de todas las salas:");
       for (Sala s : todasSalas) {
            System.out.println(s);
       }

        // ---------------Actualizar sala----------------
        salaBuscada.setCapacidad(220);
        salaBuscada.setApto3d(false);
        salaData.actualizarSala(salaBuscada);
        System.out.println("Sala actualizada: " + salaData.buscarSala(salaBuscada.getIdSala()));

        // -----------------Eliminar sala -----------------
        salaData.eliminarSala(salaBuscada.getIdSala());
        
        System.out.println("Sala eliminada");
        
         List<Sala> todasSalas2 = salaData.listarSalas();
       System.out.println("Listado de todas las salas:");
       for (Sala s : todasSalas2) {
            System.out.println(s);
       }
    }    
}
