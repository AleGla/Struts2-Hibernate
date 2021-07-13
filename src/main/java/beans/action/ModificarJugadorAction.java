package beans.action;

import com.opensymphony.xwork2.ActionSupport;
import hibernate.dao.ClubDAO;
import hibernate.dao.JugadorDAO;
import hibernate.domain.Club;
import hibernate.domain.Jugador;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

@Result(name="modificado", location="/WEB-INF/content/okModificacion.jsp")
public class ModificarJugadorAction extends ActionSupport{
    
    Club club=new Club();
    Jugador jugador=new Jugador();
    ClubDAO clubDAO=new ClubDAO();
    JugadorDAO dao=new JugadorDAO();
    private String nombre, apellido, altura, nombreClub, categoria, pais;
    private int edad, peso;
    private int id;
    
    @Override
    @Action("modificar")
    public String execute(){
        
         nombre=getNombre();
        apellido=getApellido();
        altura=getAltura();
        nombreClub=getNombreClub();
        categoria=getCategoria();
        pais=getPais();
        edad=getEdad();
        peso=getPeso();
        System.out.println("ID + " + id);
        
        jugador.setIdJugador(id);
       club.setIdClub(id);
       
       if("".equalsIgnoreCase(nombre)){
            nombre=dao.buscar(jugador).getNombre();
            jugador.setNombre(nombre);
        }else{
            System.out.println("NOMbre VALOR ="+nombre);
            jugador.setNombre(nombre);
        }
       
        if("".equalsIgnoreCase(apellido)){
            apellido=dao.buscar(jugador).getApellido();
            jugador.setApellido(apellido);
        }else{
            jugador.setApellido(apellido);
        }
        
        if(edad==0){
            edad=dao.buscar(jugador).getEdad();
        jugador.setEdad(edad);
        }else{
            jugador.setEdad(edad);
        }
        
        
        if("".equalsIgnoreCase(altura)){
           altura=dao.buscar(jugador).getAltura();
           jugador.setAltura(altura);
        }else{
            jugador.setAltura(altura);
        }
        
        if(peso==0){
            peso=dao.buscar(jugador).getPeso();
        jugador.setPeso(peso);
        }else{
            jugador.setPeso(peso);
        }
        
        if("".equalsIgnoreCase(nombreClub)){
            nombreClub=clubDAO.buscar(club).getNombreClub();
        club.setNombreClub(nombreClub);
        }else{
            club.setNombreClub(nombreClub);
        }
        
        if("".equalsIgnoreCase(categoria)){
            categoria=clubDAO.buscar(club).getCategoria();
        club.setCategoria(categoria);
        }else{
            club.setCategoria(categoria);
        }
        
        if("".equalsIgnoreCase(pais)){
            pais=clubDAO.buscar(club).getPais();
        club.setPais(pais);
        }else{
            club.setPais(pais);
        }
        
        if(jugador==null){
            jugador=dao.buscar(jugador);
        club.setJugador(jugador);
        }else{
            club.setJugador(jugador);
        }
        
        clubDAO.modificar(club);
        
        return "modificado";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public ClubDAO getClubDAO() {
        return clubDAO;
    }

    public void setClubDAO(ClubDAO clubDAO) {
        this.clubDAO = clubDAO;
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
    
}
