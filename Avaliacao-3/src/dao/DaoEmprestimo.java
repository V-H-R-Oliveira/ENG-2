package dao;

import Model.Emprestimo;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import util.JPAUtil;

public class DaoEmprestimo extends AbstractDAO {

    private EntityManager manager;

    public DaoEmprestimo() {
        super(Emprestimo.class);
        this.manager = this.getManager();
    }

    public Emprestimo searchByCodigoEmp(String codigoEmprestimo) {
        Emprestimo aux;

        manager = JPAUtil.getEntityManager();
        String sql = "SELECT e FROM Emprestimo e WHERE e.codigoEmprestimo = :n";
        TypedQuery<Emprestimo> query = manager.createQuery(sql, Emprestimo.class);
        query.setParameter("n", codigoEmprestimo);

        try {
            aux = query.getSingleResult();
            manager.close();
            return aux;
        } catch (Exception e) {
            manager.close();
            return null;
        }
    }
}
