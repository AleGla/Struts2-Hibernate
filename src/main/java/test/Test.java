package test;

import hibernate.dao.ClubDAO;
import hibernate.dao.JugadorDAO;
import hibernate.domain.Club;
import hibernate.domain.Jugador;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        
        Jugador j=new Jugador();
        Club c=new Club();
        ClubDAO club=new ClubDAO();
        
        /*j.setNombre("Franco");
        j.setApellido("Armani");
        j.setAltura("1.90 Mts");
        j.setPeso(88);
        j.setEdad(34);
        
        c.setNombre("River Plata");
        c.setCategoria("A");
        c.setPais("Argentina");
        c.setJugador(j);
        
        
        club.agregar(c);*/
        
       /* c.setIdClub(4);
        c.setNombre("River Plate");
        
        club.modificar(c);*/
       
      /* c.setIdClub(2);
       club.buscar(c);*/
        
        List<Club> lista=club.listar();
        
        for(Club list:lista){
            System.out.println(list);
        }
        
    }
    
}
