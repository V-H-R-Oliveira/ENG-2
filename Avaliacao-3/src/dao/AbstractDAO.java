package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaQuery;
import util.JPAUtil;

public abstract class AbstractDAO<T> implements Serializable {

    private final Class<T> classe;
    private EntityManager manager;

    public AbstractDAO(Class<T> classe) {
        this.classe = classe;
    }

    public void inserir(T objeto) {
        manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        try {
            tx.begin();
            if (!manager.contains(objeto)) {
                manager.persist(objeto);
                tx.commit();
                manager.close();
            } else {
                manager.close();
            }

        } catch (Exception e) {
            manager.close();
        }
    }

    public void update(Long id, T toUpdate) {
        manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        System.out.println("Id: " + id);
        T objeto = manager.find(classe, id);
        System.out.println("Objeto: " + objeto == null);
        try {
            tx.begin();
            objeto = toUpdate;
            manager.merge(objeto);
            tx.commit();
            manager.close();
        } catch (Exception e) {
            manager.close();
        }
    }

    public boolean excluir(Long id) {
        manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        T objeto = manager.find(classe, id);
        try {
            tx.begin();
            manager.remove(objeto);
            tx.commit();
            manager.close();
            return true;
        } catch (Exception e) {
            manager.close();
            return false;
        }
    }

    public List<T> listarObjetos() {
        manager = JPAUtil.getEntityManager();
        CriteriaQuery<T> query = manager.getCriteriaBuilder().createQuery(classe);
        query.select(query.from(classe));
        List<T> lista = manager.createQuery(query).getResultList();
        manager.close();
        return lista;
    }

    public EntityManager getManager() {
        return manager;
    }

    public void setManager(EntityManager manager) {
        this.manager = manager;
    }
}
