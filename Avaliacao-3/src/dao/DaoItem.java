package dao;

import Model.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import util.JPAUtil;

public class DaoItem extends AbstractDAO {

    private EntityManager manager;

    public DaoItem() {
        super(Item.class);
        this.manager = this.getManager();
    }

    public Item searchByCodigoItem(String codigoItem) {
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

    public Vector<String> listAll() {
        Vector<String> aux = new Vector<String>();
        List<Item> tmp = new ArrayList<Item>();
        manager = JPAUtil.getEntityManager();
        String sql = "SELECT a FROM Exemplar a";
        TypedQuery<Item> query = manager.createQuery(sql, Item.class);

        try {
            tmp = query.getResultList();
            manager.close();

            for (Item i : tmp) {
                aux.add(i.getExemplar().getTitulo().getNome());
            }
            return aux;
        } catch (Exception e) {
            manager.close();

            return null;
        }

    }

    public Vector<Item> listByEmperstimo(String ra) {
        Vector<Item> aux = new Vector<Item>();
        List<Item> tmp = new ArrayList<Item>();
        manager = JPAUtil.getEntityManager();
        String sql = "SELECT a FROM Item a";
        TypedQuery<Item> query = manager.createQuery(sql, Item.class);

        try {
            tmp = query.getResultList();
            manager.close();

            for (Item i : tmp) {
                aux.add(i);
            }
            return aux;
        } catch (Exception e) {
            manager.close();

            return null;
        }

    }

}
