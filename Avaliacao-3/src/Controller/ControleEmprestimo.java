package Controller;

import Model.Emprestimo;
import Model.Item;
import Model.Debito;
import dao.DaoEmprestimo;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.Vector;

public class ControleEmprestimo {

    private DaoEmprestimo dao;

    public ControleEmprestimo() {
        dao = new DaoEmprestimo();
    }

    public void inserirEmprestimo(Emprestimo emprestimo) {
        dao.inserir(emprestimo);
    }

    public void emprestar(Emprestimo emprestimo, List<Item> items) {
        Emprestimo aux = dao.searchByCodigoEmp(emprestimo.getCodigoEmprestimo());
        if (aux != null) {
            aux.emprestar(items);
            for (Item i : items) {
                System.out.println("Item: " + i.getCodigoItem() + " Id: " + i.getId() + "data de devolução: " + i.getDataDevolucao().getTime());
                dao.update(i.getId(), i);
            }
            dao.update(aux.getId(), aux);
        }
    }

    public Vector<Emprestimo> searchByAluno(String ra) {
        return dao.searchByAluno(ra);
    }

    public Emprestimo searchByID(Long id) {
        return dao.searchByID(id);
    }

 public void devolucao(Emprestimo emprestimo) {
        Emprestimo aux = dao.searchByCodigoEmp(emprestimo.getCodigoEmprestimo());
        ControleItem cItem = new ControleItem();
        ControleDebito cDebito = new ControleDebito();
        ControleExemplar cExemplar = new ControleExemplar();
        Debito debito;
        List<Item> items;
        Date dataDevolucao;
        Date hoje = new Date();
        Calendar tmp, tmp2;

        // hoje.compareTo(dataDevolucao) <= 0
        // dataDevolucao.compareTo(hoje) <= 0
        if (aux != null) {
   
            cItem = new ControleItem();
            items = cItem.listarItems(emprestimo);

            System.out.println("Devolução:");
            dataDevolucao = aux.getDataDevolucao();
            if (hoje.compareTo(dataDevolucao) <= 0) // data de devolucao é menor ou igual à data de hoje
            {
                for (Item i : items) {
                    System.out.println("ITEM a ser devolvido: " + i.getCodigoItem() + " " + i.getDataDevolucao().getTime() + " Emp data dev: " + dataDevolucao);
                    cExemplar.updateDisponibilidade(i.getExemplar().getId(), true);
                    cItem.excluirItem(i);
                }

                dao.excluir(aux.getId());
            } else {
                System.out.println("Uma multa será aplicada .... TODO");
                tmp = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
                tmp2 = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));

                tmp.setTime(dataDevolucao);
                tmp2.setTime(hoje);

                int dias = Math.abs(tmp.get(Calendar.DAY_OF_MONTH) - tmp2.get(Calendar.DAY_OF_MONTH));
                debito = new Debito();
                debito.setAluno(aux.getAluno());
                cDebito = new ControleDebito();
                cDebito.calculaDebito(debito, dias);
                System.out.println(debito.getAluno().getNome() + " " + debito.getValor());
                cDebito.inserirDebito(debito);
            }
        }
    }
}
