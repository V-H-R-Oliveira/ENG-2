package dao;

import Model.Item;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import util.JPAUtil;

public class DaoItem extends AbstractDAO {

    private EntityManager manager;

    public DaoItem() {
        super(Item.class);
        this.manager = this.getManager();
    }
    
    public Item searchByCodigoItem(String codigoItem)
    {
        Item aux;
        
        manager = JPAUtil.getEntityManager();
        String sql = "SELECT i FROM Item i WHERE i.codigoItem = :n";
        TypedQuery<Item> query = manager.createQuery(sql, Item.class);
        query.setParameter("n", codigoItem);

        try {
            aux = query.getSingleResult();
            manager.close();
            return aux;
        } catch (Exception e) {
            manager.close();
            return null;
        }
    }
    
    public List<Item> listarItems() {
        manager = JPAUtil.getEntityManager();
        CriteriaQuery<Item> query = manager.getCriteriaBuilder().createQuery(Item.class);
        query.select(query.from(Item.class));
        List<Item> lista = manager.createQuery(query).getResultList();
        manager.close();
        return lista;
    }

}
