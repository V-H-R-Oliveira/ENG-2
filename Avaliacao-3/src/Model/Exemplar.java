package Model;

import dao.GenericDAO;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Exemplar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private boolean exemplar;

    @ManyToOne
    @JoinColumn(name = "titulo")
    private Titulo titulo;

    @Column(length = 10)
    private String codigoExemplar;

    @Column(length = 40)
    private String editora;

    @Transient
    private GenericDAO<Exemplar> dao;

    public Exemplar() {
        dao = new GenericDAO<>(Exemplar.class);
    }

    public Exemplar(boolean exemplar, Titulo titulo, String codigoExemplar, String editora) {
        this.exemplar = exemplar;
        this.titulo = titulo;
        this.codigoExemplar = codigoExemplar;
        this.editora = editora;
    }

    
    public boolean verficaExemplar() 
    {
        return true;
    }
     
    public boolean isExemplar() {
        return exemplar;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + (this.exemplar ? 1 : 0);
        hash = 71 * hash + Objects.hashCode(this.titulo);
        hash = 71 * hash + Objects.hashCode(this.codigoExemplar);
        hash = 71 * hash + Objects.hashCode(this.editora);
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
        final Exemplar other = (Exemplar) obj;
        if (this.exemplar != other.exemplar) {
            return false;
        }
        if (!Objects.equals(this.codigoExemplar, other.codigoExemplar)) {
            return false;
        }
        if (!Objects.equals(this.editora, other.editora)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        return true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Titulo getTitulo() {
        return titulo;
    }

    public void setTitulo(Titulo titulo) {
        this.titulo = titulo;
    }

    public String getCodigoExemplar() {
        return codigoExemplar;
    }

    public void setCodigoExemplar(String codigoExemplar) {
        this.codigoExemplar = codigoExemplar;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }


}
