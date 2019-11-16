package Controller;

import Model.Item;
import dao.DaoItem;

public class ControleItem {
    private DaoItem dao;
    
    public ControleItem()
    {
        dao = new DaoItem();
    }
    
    public void inserirItem(Item item)
    {
        dao.inserir(item);
    }
}
