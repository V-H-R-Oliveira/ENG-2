package dao;

import Model.Aluno;
import Model.Debito;
import Model.Exemplar;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import util.JPAUtil;

public class DaoExemplar extends AbstractDAO {

    private EntityManager manager;

    public DaoExemplar() {
        super(Exemplar.class);
        this.manager = this.getManager();
    }

    public Exemplar searchByExemplar(Long id) {
        Exemplar aux;
        manager = JPAUtil.getEntityManager();
        String sql = "SELECT e FROM Exemplar e WHERE e.id = :n";
        TypedQuery<Exemplar> query = manager.createQuery(sql, Exemplar.class);
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
    
    public Vector<Exemplar> searchByISBN(String ra) {
        Vector<Exemplar> aux = new Vector<Exemplar>();
        manager = JPAUtil.getEntityManager();
        String sql = "SELECT d FROM Exemplar d WHERE d.titulo.isbn = :n";
        TypedQuery<Exemplar> query = manager.createQuery(sql, Exemplar.class);
        query.setParameter("n", ra);

        try {
            aux = (Vector<Exemplar>) query.getResultList();
            manager.close();
            return aux;
        } catch (Exception e) {
            manager.close();
            return null;
        }
    }
    
        public Vector<String> listAll() {
        Vector<String> aux = new Vector<String>();
        List<Exemplar> tmp = new ArrayList<Exemplar>();
        manager = JPAUtil.getEntityManager();
        String sql = "SELECT a FROM Exemplar a";
        TypedQuery<Exemplar> query = manager.createQuery(sql, Exemplar.class);

        try {
            tmp = query.getResultList();
            manager.close();

            for (Exemplar i : tmp) {
                aux.add(i.getTitulo().getIsbn());
            }
            return aux;
        } catch (Exception e) {
            manager.close();

            return null;
        }

    }
}
