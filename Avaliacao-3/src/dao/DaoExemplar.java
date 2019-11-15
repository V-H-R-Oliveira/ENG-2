package dao;

import Model.Exemplar;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import util.JPAUtil;

public class DaoExemplar extends AbstractDAO {

    private EntityManager manager;

    public DaoExemplar() {
        super(Exemplar.class);
        this.manager = this.getManager();
    }

    public boolean searchByExemplar(String codigoExemplar) {
        Exemplar aux;
        manager = JPAUtil.getEntityManager();
        String sql = "SELECT e FROM Exemplar e WHERE e.codigoExemplar = :n AND e.isDisponivel = :x";
        TypedQuery<Exemplar> query = manager.createQuery(sql, Exemplar.class);
        query.setParameter("n", codigoExemplar);
        query.setParameter("x", true);

        try {
            aux = query.getSingleResult();
            return aux != null;
        } catch (Exception e) {
            return false;
        } finally {
            manager.close();
        }
    }
}
