package Model;

import dao.GenericDAO;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.ThreadLocalRandom;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "exemplar")
    private Exemplar exemplar;

    @Column
    private Calendar dataDevolucao;

    @Transient
    private GenericDAO<Item> dao;

    public Item() {
        dao = new GenericDAO<>(Item.class);
    }

    public Item(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.exemplar);
        hash = 59 * hash + Objects.hashCode(this.dataDevolucao);
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
        final Item other = (Item) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.exemplar, other.exemplar)) {
            return false;
        }
        if (!Objects.equals(this.dataDevolucao, other.dataDevolucao)) {
            return false;
        }
        return true;
    }


    
    public void calculaDataDevolucao() {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));

        if (exemplar.verficaExemplar()) // JPA
        {
            if (exemplar.getCodigoExemplar().equals("reservado")) {
                System.out.println("O exemplar não pode ser emprestado - Apenas de Leitura");
            } else {
                int day = ThreadLocalRandom.current().nextInt(1, 8);
                cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH) + day);
                this.dataDevolucao = cal;
            }
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public Calendar getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Calendar dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}
