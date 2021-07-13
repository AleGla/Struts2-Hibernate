package beans.action;

import com.opensymphony.xwork2.ActionSupport;
import hibernate.dao.ClubDAO;
import hibernate.domain.Club;
import hibernate.domain.Jugador;
import java.util.List;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Results({
    @Result(name="forma", location="/WEB-INF/content/agregarjugador.jsp"),
    @Result(name="success", location = "/WEB-INF/content/okagregarjugador.jsp")

})
public class AgregarJugadorAction extends ActionSupport{
    
    Club club=new Club();
    Jugador jugador=new Jugador();
    ClubDAO clubDAO=new ClubDAO();
    
    private String nombre, apellido, altura, nombreClub, categoria, pais;
    private int edad, peso;
    
    @Override
    @Action("agregar")
    public String execute(){
        
        nombre=getNombre();
        apellido=getApellido();
        altura=getAltura();
        nombreClub=getNombreClub();
        categoria=getCategoria();
        pais=getPais();
        edad=getEdad();
        peso=getPeso();
        
        if(jugadorIs() && clubIs()){  

            return "forma";
        
        }else{
            
            jugador.setNombre(nombre);
            jugador.setApellido(apellido);
            jugador.setEdad(edad);
            jugador.setAltura(altura);
            jugador.setPeso(peso);
            club.setNombreClub(nombreClub);
            club.setCategoria(categoria);
            club.setPais(pais);
            club.setJugador(jugador);
            
            clubDAO.agregar(club);
         
            return SUCCESS;            
        }
        
    }

    public ClubDAO getClubDAO() {
        return clubDAO;
    }

    public void setClubDAO(ClubDAO clubDAO) {
        this.clubDAO = clubDAO;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
    
    public boolean jugadorIs(){
        if(nombre==null || "".equalsIgnoreCase(nombre) || apellido==null || "".equalsIgnoreCase(apellido) || 
           edad==0 || altura==null || "".equalsIgnoreCase(altura) || peso==0 ){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean clubIs(){
        if(nombreClub==null || "".equalsIgnoreCase(nombreClub) || categoria==null || "".equalsIgnoreCase(categoria) || 
           pais==null || "".equalsIgnoreCase(pais)){
            return true;
        }else{
            return false;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getNombreClub() {
        return nombreClub;
    }

    public void setNombreClub(String nombreClub) {
        this.nombreClub = nombreClub;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    
    
}
