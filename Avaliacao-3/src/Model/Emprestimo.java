package Model;

import java.io.Serializable;
import java.util.List;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "emprestimo")
public class Emprestimo implements Serializable {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "emprestimo")
    private List<Item> items;

    @ManyToOne
    private Aluno aluno;

    @Column()
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDevolucao;

    @Column()
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataEmprestimo;

    public Emprestimo() {
    }

    public Emprestimo(Aluno aluno, Date dataEmprestimo) {
        this.aluno = aluno;
        this.dataEmprestimo = dataEmprestimo;
    }

    public void emprestar() {
        // metodo emprestar aqui
    }

    // private
    public void calculaDataDevolucao() {
        Date maior = new Date();
        Date aux;
        Item item;
        Integer cont = 0;
        Calendar tmp = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));

        if (items.size() < 3) {
            for (Item i : items) {
                aux = i.getDataDevolucao().getTime();
                if (aux.compareTo(maior) > 0) {
                    maior = aux;
                }
            }
        } else {
            for (int i = 0; i < items.size(); i++) {
                item = items.get(i);

                if (i > 1) {
                    cont++;
                }

                aux = item.getDataDevolucao().getTime();
                if (aux.compareTo(maior) > 0) {
                    maior = aux;

                }
            }
            maior.setDate((maior.getDate() + cont * 2));
        }

        tmp.setTime(maior);

        for (Item i : items) {
            i.setDataDevolucao(tmp);
        }

        System.out.println("Maior: " + maior);
        this.dataDevolucao = maior;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.items);
        hash = 97 * hash + Objects.hashCode(this.aluno);
        hash = 97 * hash + Objects.hashCode(this.dataDevolucao);
        hash = 97 * hash + Objects.hashCode(this.dataEmprestimo);
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
        final Emprestimo other = (Emprestimo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.items, other.items)) {
            return false;
        }
        if (!Objects.equals(this.aluno, other.aluno)) {
            return false;
        }
        if (!Objects.equals(this.dataDevolucao, other.dataDevolucao)) {
            return false;
        }
        if (!Objects.equals(this.dataEmprestimo, other.dataEmprestimo)) {
            return false;
        }
        return true;
    }

}
