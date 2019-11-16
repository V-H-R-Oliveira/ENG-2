package dao;

import Model.Titulo;
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
}
