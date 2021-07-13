package hibernate.dao;

import hibernate.domain.Club;
import hibernate.domain.Jugador;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ClubDAO {

    EntityManagerFactory emf;
    EntityManager em;

    public ClubDAO(){
        emf=Persistence.createEntityManagerFactory("Futbol");
        em=emf.createEntityManager();
    }
    
    
    public List<Club> listar(){
        String hql="SELECT p FROM Club p";
        Query query=em.createQuery(hql);
        List<Club> lista=query.getResultList();
        return lista;
    }
    
    public void agregar(Club j){
        try{
            em.getTransaction().begin();
            em.persist(j);
            em.getTransaction().commit();
            System.out.println("SE HA AGREGADO EL REGISTRO");
        }catch(Exception ex){
            em.getTransaction().rollback();
            ex.printStackTrace(System.out);
        }
    }
    
    public void modificar(Club j){
        try{
            em.getTransaction().begin();
            em.merge(j);
            em.getTransaction().commit();
            System.out.println("SE HA MODIFICADO EL REGISTRO");
        }catch(Exception ex){
            em.getTransaction().rollback();
            ex.printStackTrace(System.out);
        }
    }
    
    public void eliminar(Club j){
        try{
            em.getTransaction().begin();
            em.remove(em.merge(em.find(Club.class, j.getIdClub())));
            em.getTransaction().commit();
            System.out.println("SE HA ELIMINADO EL REGISTRO");
        }catch(Exception ex){
            em.getTransaction().rollback();
            ex.printStackTrace(System.out);
        }
    }
    
    public Club buscar(Club j){
        return em.find(Club.class, j.getIdClub());
    }
    
    
    
}
