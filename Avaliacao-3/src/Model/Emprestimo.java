package Model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Emprestimo {

    private ArrayList<Item> items;
    private Aluno aluno;
    private Date dataDevolucao;

    public Emprestimo(Aluno aluno) {
        this.items = new ArrayList<>();
        this.aluno = aluno;
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

}
