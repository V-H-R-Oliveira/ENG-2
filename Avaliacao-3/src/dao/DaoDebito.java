package dao;

import Model.Aluno;
import Model.Debito;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import util.JPAUtil;

public class DaoDebito extends AbstractDAO {

    private EntityManager manager;

    public DaoDebito() {
        super(Debito.class);
        this.manager = this.getManager();
    }

    public boolean verificaDebito(Aluno aluno) {
        Debito aux;
        manager = JPAUtil.getEntityManager();
        String sql = "SELECT d FROM Debito d WHERE d.aluno.ra = :n";
        TypedQuery<Debito> query = manager.createQuery(sql, Debito.class);
        query.setParameter("n", aluno.getRa());

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
