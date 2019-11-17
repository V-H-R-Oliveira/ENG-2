package Controller;

import Model.Emprestimo;
import Model.Item;
import dao.DaoEmprestimo;
import java.util.List;

public class ControleEmprestimo {

    private DaoEmprestimo dao;

    public ControleEmprestimo() {
        dao = new DaoEmprestimo();
    }

    public void inserirEmprestimo(Emprestimo emprestimo) {
        dao.inserir(emprestimo);
    }

    public void emprestar(Emprestimo emprestimo, List<Item> items) {

        emprestimo.emprestar(items);
        for (Item i : items) {

            System.out.println("Item: " + i.getCodigoItem() + " Id: " + i.getId() + "data de devolução: " + i.getDataDevolucao().getTime());
            dao.update(i.getId(), i);
        }

    }
}
