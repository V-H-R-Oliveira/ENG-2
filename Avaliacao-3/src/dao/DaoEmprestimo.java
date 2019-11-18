package dao;

import Controller.ControleExemplar;
import Controller.ControleItem;
import Model.Emprestimo;
import Model.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import util.JPAUtil;

public class DaoEmprestimo extends AbstractDAO {

    private EntityManager manager;
    private ControleExemplar ce = new ControleExemplar();
    private ControleItem ci = new ControleItem();

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

    public Vector<Emprestimo> searchByAluno(String ra) {
        Vector<Emprestimo> aux = new Vector<Emprestimo>();
        manager = JPAUtil.getEntityManager();
        String sql = "SELECT d FROM Emprestimo d WHERE d.aluno.ra = :n";
        TypedQuery<Emprestimo> query = manager.createQuery(sql, Emprestimo.class);
        query.setParameter("n", ra);

        try {
            aux = (Vector<Emprestimo>) query.getResultList();
            manager.close();
            return aux;
        } catch (Exception e) {
            manager.close();
            return null;
        }
    }
    
        public Emprestimo searchByID(Long id) {
        Emprestimo aux = new Emprestimo();
        manager = JPAUtil.getEntityManager();
        String sql = "SELECT d FROM Emprestimo d WHERE d.id = :n";
        TypedQuery<Emprestimo> query = manager.createQuery(sql, Emprestimo.class);
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

}
