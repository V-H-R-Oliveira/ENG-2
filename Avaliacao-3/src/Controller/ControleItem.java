package Controller;

import Model.Emprestimo;
import Model.Item;
import dao.DaoEmprestimo;
import dao.DaoItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ControleItem {

    private DaoItem dao;

    public ControleItem() {
        dao = new DaoItem();
    }

    private void dataDevolucao(Item item) {
        item.calculaDataDevolucao();
    }

    public void inserirItem(Item item) {
        dataDevolucao(item);
        dao.inserir(item);
    }

    public List listarItems(Emprestimo emprestimo) {
        List<Item> items = dao.listarObjetos();
        ArrayList<Item> tmp = new ArrayList<>();
        DaoEmprestimo cEmprestimo = new DaoEmprestimo();
        Emprestimo aux = cEmprestimo.searchByCodigoEmp(emprestimo.getCodigoEmprestimo());
        Long emprestimoId;
        
        if (aux != null) {
            emprestimoId = aux.getId();
            for (Item i : items) {
                if(Objects.equals(emprestimoId, i.getEmprestimo().getId()))
                {
                    tmp.add(i);
                }
            }
            
            return tmp;
        }

        return null;
    }
}
