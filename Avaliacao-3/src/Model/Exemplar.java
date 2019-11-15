package Model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Exemplar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false)
    private boolean exemplar;

    @ManyToOne
    @JoinColumn(name = "titulo")
    private Titulo titulo;

    @Column(length = 10, unique = true, nullable=false)
    private String codigoExemplar;

    @Column(nullable=false)
    private boolean isDisponivel;

    @Column(length = 40, nullable=false)
    private String editora;

    public Exemplar() {
    }

    public Exemplar(String codigoExemplar, Titulo titulo, String editora, boolean exemplar) {
        this.exemplar = exemplar;
        this.titulo = titulo;
        this.codigoExemplar = codigoExemplar;
        this.editora = editora;
        this.isDisponivel = true;
    }


    public boolean isExemplar() {
        return exemplar;
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

    public boolean isDisponivel() {
        return isDisponivel;
    }

    public void setIsDisponivel(boolean isDisponivel) {
        this.isDisponivel = isDisponivel;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public void setExemplar(boolean exemplar) {
        this.exemplar = exemplar;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + (this.exemplar ? 1 : 0);
        hash = 17 * hash + Objects.hashCode(this.titulo);
        hash = 17 * hash + Objects.hashCode(this.codigoExemplar);
        hash = 17 * hash + (this.isDisponivel ? 1 : 0);
        hash = 17 * hash + Objects.hashCode(this.editora);
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
        if (this.isDisponivel != other.isDisponivel) {
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

}
