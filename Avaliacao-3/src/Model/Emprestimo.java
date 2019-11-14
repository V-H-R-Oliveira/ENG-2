package Model;

import dao.GenericDAO;
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
import javax.persistence.Transient;


@Entity
public class Emprestimo implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @OneToMany
    @JoinColumn(name = "item")
    private ArrayList<Item> items;
    
    @ManyToOne
    @JoinColumn(name = "aluno")
    private Aluno aluno;
    
    @Column()
    private Date dataDevolucao;
    
    @Column()
    private Date dataEmprestimo;

        @Transient
    private GenericDAO<Emprestimo> dao;

    public Emprestimo() {
        dao = new GenericDAO<>(Emprestimo.class);
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
                if (aux.compareTo(maior) > 0) maior = aux;
            }
        } else {
            for (int i = 0; i < items.size(); i++) {
                item = items.get(i);
                System.out.println("Data de devolução: " + item.getDataDevolucao().getTime());

                if (i > 1) {
                    cont +=1;
//                    tmp.set(item.getDataDevolucao().get(Calendar.YEAR), item.getDataDevolucao().get(Calendar.MONTH), item.getDataDevolucao().get(Calendar.DAY_OF_MONTH) + 2);
//                    item.setDataDevolucao(tmp);
//                    System.out.println("Data + 2: " + item.getDataDevolucao().getTime());
                }

                aux = item.getDataDevolucao().getTime();
                if (aux.compareTo(maior) > 0) {
                    maior = aux;
                    
                }
            }
            maior.setDate((maior.getDate() + cont * 2));
            System.out.println("Somando dias: " + maior);
           
        }
        
        tmp.setTime(maior);

        for(Item i : items)
        {
            i.setDataDevolucao(tmp);
            System.out.println("Data depois de mudar todos para maior: " + i.getDataDevolucao().getTime());
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
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.items);
        hash = 83 * hash + Objects.hashCode(this.aluno);
        hash = 83 * hash + Objects.hashCode(this.dataDevolucao);
        hash = 83 * hash + Objects.hashCode(this.dataEmprestimo);
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
