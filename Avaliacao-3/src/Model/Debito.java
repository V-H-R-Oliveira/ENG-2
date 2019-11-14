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
public class Debito implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "aluno")
    private Aluno aluno;

    @Column()
    private Double valor;

    @Column()
    private boolean estado;

    @Transient
    private GenericDAO<Debito> dao;

    public Debito() {
        dao = new GenericDAO<>(Debito.class);
    }

    public Debito(Aluno aluno, Double valor, boolean estado) {
        this.aluno = aluno;
        this.valor = valor;
        this.estado = estado;
        dao = new GenericDAO<>(Debito.class);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.aluno);
        hash = 47 * hash + Objects.hashCode(this.valor);
        hash = 47 * hash + (this.estado ? 1 : 0);
        hash = 47 * hash + Objects.hashCode(this.dao);
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
        final Debito other = (Debito) obj;
        if (this.estado != other.estado) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.aluno, other.aluno)) {
            return false;
        }
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        return Objects.equals(this.dao, other.dao);
    }

    public boolean verificaDebito() {
        return dao.verificaDebito(this.aluno.getRa());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public GenericDAO getDao() {
        return dao;
    }

    public void setDao(GenericDAO dao) {
        this.dao = dao;
    }

}
