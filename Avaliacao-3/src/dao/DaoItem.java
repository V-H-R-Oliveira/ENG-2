package dao;

import Model.Item;
import javax.persistence.EntityManager;

public class DaoItem extends AbstractDAO{
    
    private EntityManager manager;
    
    public DaoItem() {
        super(Item.class);
        this.manager = this.getManager();
    }
}
