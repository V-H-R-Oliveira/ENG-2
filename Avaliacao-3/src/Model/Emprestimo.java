package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Emprestimo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "emprestimo")
    private ArrayList<Item> items;

    @ManyToOne
    @JoinColumn(name = "aluno")
    private Aluno aluno;

    @Column()
    private Date dataDevolucao;

    @Column()
    private Date dataEmprestimo;

    public Emprestimo() {
    }

    public Emprestimo(Aluno aluno, Date dataEmprestimo) {
        this.items = new ArrayList<>();
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
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
        int hash = 7;
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
