package dao;

import Model.Aluno;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import util.JPAUtil;

public class DaoAluno extends AbstractDAO {

    private EntityManager manager;

    public DaoAluno() {
        super(Aluno.class);
        this.manager = this.getManager();
    }

    public Aluno searchByRA(String ra) {
        Aluno aux;
        manager = JPAUtil.getEntityManager();
        String sql = "SELECT a FROM Aluno a WHERE a.ra = :n";
        TypedQuery<Aluno> query = manager.createQuery(sql, Aluno.class);
        query.setParameter("n", ra);

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
        List<Aluno> tmp = new ArrayList<Aluno>();
        manager = JPAUtil.getEntityManager();
        String sql = "SELECT a FROM Aluno a";
        TypedQuery<Aluno> query = manager.createQuery(sql, Aluno.class);

        try {
            tmp = query.getResultList();
            manager.close();

            for (Aluno i : tmp) {
                aux.add(i.getRa());
            }
            return aux;
        } catch (Exception e) {
            manager.close();

            return null;
        }

    }
}
