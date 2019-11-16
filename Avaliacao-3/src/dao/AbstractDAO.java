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

        try {
            tx.begin();
            if (!manager.contains(objeto)) {
                manager.persist(objeto);
                tx.commit();
                manager.close();
            } else {
                System.out.println("Error ao inserir");
                manager.close();
            }

        } catch (Exception e) {
            System.out.println("O item não foi inserido");
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

    public EntityManager getManager() {
        return manager;
    }

    public void setManager(EntityManager manager) {
        this.manager = manager;
    }
}
