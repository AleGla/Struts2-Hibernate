package beans.action;

import com.opensymphony.xwork2.ActionSupport;
import hibernate.dao.ClubDAO;
import hibernate.domain.Club;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Results({
    @Result(name="lista", location="/WEB-INF/content/listarJugadores.jsp"),
    @Result(name="modifica", location="/WEB-INF/content/modificarJugador.jsp"),
    @Result(name="elimina", location="/WEB-INF/content/listarJugadores.jsp")
})
public class indexAgregarAction extends ActionSupport{

    private Club club;
    private ClubDAO clubDAO;
    private List<Club> lista;
    private int idRemove;
    private HttpServletRequest r;
    private String borrar=null;
    Logger log= LogManager.getLogger(this);
    private String borrarM=null;  
      
    @Override
    @Action("listar")
    public String execute(){
    
        borrar=getBorrar();
        borrarM=getBorrarM();
        
        if(borrar==null && borrarM==null){
            clubDAO=new ClubDAO();
            lista=clubDAO.listar();
            return "lista";
        }else if(borrar!=null){
            club=new Club(Integer.parseInt(borrar));
            clubDAO=new ClubDAO();
            clubDAO.eliminar(club);
            lista=clubDAO.listar();
            return "elimina";
        }else if(borrarM!=null){
            borrarM=getBorrarM();            
            return "modifica";   
        }else{
            return ERROR;
        }
    }

    public String getBorrarM() {
        return borrarM;
    }

    public void setBorrarM(String borrarM) {
        this.borrarM = borrarM;
    }
    
    

    public String getBorrar() {
        return borrar;
    }

    public void setBorrar(String borrar) {
        this.borrar = borrar;
    }
    
    
    public int getIdRemove() {
        return idRemove;
    }

    public void setIdRemove(int idRemove) {
        this.idRemove = idRemove;
    }

    public HttpServletRequest getR() {
        return r;
    }

    public void setR(HttpServletRequest r) {
        this.r = r;
    }

    public String getRemove() {
        return borrar;
    }

    public void setRemove(String remove) {
        this.borrar = remove;
    }
    
        
    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public ClubDAO getClubDAO() {
        return clubDAO;
    }

    public void setClubDAO(ClubDAO clubDAO) {
        this.clubDAO = clubDAO;
    }

    public List<Club> getLista() {
        return lista;
    }

    public void setLista(List<Club> lista) {
        this.lista = lista;
    }
    
    
    
}
