package dao;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
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
        tx.begin();
        manager.persist(objeto);
        tx.commit();
    }

    public boolean excluir(Integer id) {
        manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
            T objeto = manager.find(classe, id);
            System.out.println("Iddd: " + id);
            manager.remove(objeto);
            tx.commit();
            manager.close();
            return true;
        } catch (Exception e) {
            manager.close();
            return false;
        }
    }

    public EntityManager getManager() {
        return manager;
    }

    public void setManager(EntityManager manager) {
        this.manager = manager;
    }
}
