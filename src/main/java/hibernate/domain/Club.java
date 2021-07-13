package hibernate.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name="Club")
public class Club implements Serializable {
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_club")
    private int idClub;
    
    @Column(name="nombre")
    private String nombreClub;
    
    private String categoria;
    
    private String pais;
    
    @JoinColumn(name = "id_jugador", referencedColumnName = "id_jugador")
    @ManyToOne(cascade = CascadeType.ALL)
    private Jugador jugador;

    public Club() {
    }

    public Club(int idClub) {
        this.idClub = idClub;
    }

    public int getIdClub() {
        return idClub;
    }

    public void setIdClub(int idClub) {
        this.idClub = idClub;
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

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    @Override
    public String toString() {
        return "Club{" + "idClub=" + idClub + ", nombre=" + nombreClub + ", categoria=" + categoria + ", pais=" + pais + ", jugador=" + jugador + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.idClub;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Club other = (Club) obj;
        if (this.idClub != other.idClub) {
            return false;
        }
        return true;
    }
    
    
    
}
