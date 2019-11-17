package dao;

import Model.Debito;
import java.util.Vector;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import util.JPAUtil;

public class DaoDebito extends AbstractDAO {

    private EntityManager manager;

    public DaoDebito() {
        super(Debito.class);
        this.manager = this.getManager();
    }

  

    public Debito searchByID(Long id) {
        Debito aux;
        manager = JPAUtil.getEntityManager();
        String sql = "SELECT d FROM Debito d WHERE d.id = :n";
        TypedQuery<Debito> query = manager.createQuery(sql, Debito.class);
        query.setParameter("n", id);

        try {
            aux = query.getSingleResult();
            manager.close();
            return aux;
        } catch (Exception e) {
            manager.close();
            return null;
        }
    }

    public Vector<Debito> searchByAluno(String ra) {
        Vector<Debito> aux = new Vector<Debito>();
        manager = JPAUtil.getEntityManager();
        String sql = "SELECT d FROM Debito d WHERE d.aluno.ra = :n";
        TypedQuery<Debito> query = manager.createQuery(sql, Debito.class);
        query.setParameter("n", ra);

        try {
            aux = (Vector<Debito>) query.getResultList();
            manager.close();
            return aux;
        } catch (Exception e) {
            manager.close();
            return null;
        }
    }
}
