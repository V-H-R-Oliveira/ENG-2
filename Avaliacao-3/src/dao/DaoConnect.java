package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import util.JPAUtil;

public class DaoConnect extends AbstractDAO {

    private EntityManager manager;

    public DaoConnect() {
        super(Model.Conexao.class);
        this.manager = this.getManager();
    }

    public void Connect() {
        manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        manager.close();
    }

}
