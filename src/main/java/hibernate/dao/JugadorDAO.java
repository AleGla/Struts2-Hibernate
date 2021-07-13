package hibernate.dao;

import hibernate.domain.Jugador;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JugadorDAO {

    EntityManagerFactory emf;
    EntityManager em;
    
    public JugadorDAO(){
        emf=Persistence.createEntityManagerFactory("Futbol");
        em=emf.createEntityManager();
    }
    
    public List<Jugador> listar(){
        String hql="SELECT p FROM Jugador p";
        Query query=em.createQuery(hql);
        List<Jugador> lista=query.getResultList();
        return lista;
    }
    
    public void agregar(Jugador j){
        try{
            em.getTransaction().begin();
            em.persist(j);
            em.getTransaction().commit();
            System.out.println("SE HA AGREGADO UN REGISTRO");
        }catch(Exception ex){
            em.getTransaction().rollback();
            ex.printStackTrace(System.out);
        }
    }
    
    public void modificar(Jugador j){
        try{
            em.getTransaction().begin();
            em.merge(j);
            em.getTransaction().commit();
            System.out.println("SE HA MODIFICADO UN REGISTRO");
        }catch(Exception ex){
            em.getTransaction().rollback();
            ex.printStackTrace(System.out);
        }
    }
    
    public void eliminar(Jugador j){
        try{
            em.getTransaction().begin();
            em.remove(em.merge(em.find(Jugador.class, j.getIdJugador())));
            em.getTransaction().commit();
            System.out.println("SE HA ELIMINADO UN REGISTRO");
        }catch(Exception ex){
            em.getTransaction().rollback();
            ex.printStackTrace(System.out);
        }
    }
    
    public Jugador buscar(Jugador j){
       return em.find(Jugador.class, j.getIdJugador());
    }

    
}
