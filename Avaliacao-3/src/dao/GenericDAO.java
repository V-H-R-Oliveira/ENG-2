package dao;

import Model.Aluno;
import Model.Debito;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import util.JPAUtil;

public class GenericDAO<T> implements Serializable {

    private final Class<T> classe;
    EntityManager manager;

    public GenericDAO(Class<T> classe) {
        this.classe = classe;
    }

    public void inserir(T objeto) {
        manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(objeto);
        tx.commit();
        return;
    }

    public boolean searchByRA(String ra) {
        Aluno temp;
        manager = JPAUtil.getEntityManager();
        String sql = "SELECT a FROM Aluno a WHERE a.ra = :n";
        TypedQuery<Aluno> query = manager.createQuery(sql, Aluno.class);
        query.setParameter("n", ra);

        try {
            temp = query.getSingleResult();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            manager.close();
        }
    }

    public boolean verificaDebito(String ra) {
        Debito temp = null;
        manager = JPAUtil.getEntityManager();
        String sql = "SELECT d FROM Debito d WHERE d.aluno.ra = :n";
        TypedQuery<Debito> query = manager.createQuery(sql, Debito.class);
        query.setParameter("n", ra);

        try {
            temp = query.getSingleResult();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            manager.close();
        }

    }

    public boolean excluir(Integer id) {
        manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
            T temp = manager.find(classe, id);
            manager.remove(temp);
            tx.commit();
            manager.close();
            return true;
        } catch (Exception e) {
            manager.close();
            return false;
        }
    }

    public List<Aluno> listarAluno(Class objeto) {
        manager = JPAUtil.getEntityManager();
        CriteriaQuery<Aluno> query = manager.getCriteriaBuilder().createQuery(objeto);
        query.select(query.from(objeto));
        List<Aluno> lista = manager.createQuery(query).getResultList();
        manager.close();
        return lista;
    }
}
