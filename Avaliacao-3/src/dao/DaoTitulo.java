package dao;

import Model.Aluno;
import Model.Debito;
import Model.Titulo;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import util.JPAUtil;

public class DaoTitulo extends AbstractDAO {

    private EntityManager manager;

    public DaoTitulo() {
        super(Titulo.class);
        this.manager = this.getManager();
    }

    public Titulo searchByIsbn(String isbn) {
        Titulo aux;
        manager = JPAUtil.getEntityManager();
        String sql = "SELECT t FROM Titulo t WHERE t.isbn = :n";
        TypedQuery<Titulo> query = manager.createQuery(sql, Titulo.class);
        query.setParameter("n", isbn);

        try {
            aux = query.getSingleResult();
            manager.close();
            return aux;
        } catch (Exception e) {
            manager.close();
            return null;
        }
    }

    public Titulo searchByIsbn(Long id) {
        Titulo aux;
        manager = JPAUtil.getEntityManager();
        String sql = "SELECT t FROM Titulo t WHERE t.id = :n";
        TypedQuery<Titulo> query = manager.createQuery(sql, Titulo.class);
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

    public Vector<Titulo> searchByISBN(String ra) {
        Vector<Titulo> aux = new Vector<Titulo>();
        manager = JPAUtil.getEntityManager();
        String sql = "SELECT d FROM Debito d WHERE d.aluno.ra = :n";
        TypedQuery<Titulo> query = manager.createQuery(sql, Titulo.class);
        query.setParameter("n", ra);

        try {
            aux = (Vector<Titulo>) query.getResultList();
            manager.close();
            return aux;
        } catch (Exception e) {
            manager.close();
            return null;
        }
    }

    public Vector<String> listAll() {
        Vector<String> aux = new Vector<String>();
        List<Titulo> tmp = new ArrayList<Titulo>();
        manager = JPAUtil.getEntityManager();
        String sql = "SELECT a FROM Titulo a";
        TypedQuery<Titulo> query = manager.createQuery(sql, Titulo.class);

        try {
            tmp = query.getResultList();
            manager.close();

            for (Titulo i : tmp) {
                aux.add(i.getIsbn());
            }
            return aux;
        } catch (Exception e) {
            manager.close();

            return null;
        }

    }
    
        public Vector<Titulo> listAllT() {
        Vector<Titulo> aux = new Vector<Titulo>();
        List<Titulo> tmp = new ArrayList<Titulo>();
        manager = JPAUtil.getEntityManager();
        String sql = "SELECT a FROM Titulo a";
        TypedQuery<Titulo> query = manager.createQuery(sql, Titulo.class);

        try {
            tmp = query.getResultList();
            manager.close();

            for (Titulo i : tmp) {
                aux.add(i);
            }
            return aux;
        } catch (Exception e) {
            manager.close();

            return null;
        }

    }
}
