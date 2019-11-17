package Controller;

import Model.Item;
import dao.DaoItem;
import java.util.List;

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
    
    public List listarItems()
    {
        List<Item> items = dao.listarItems();
        return items;
    }
}
