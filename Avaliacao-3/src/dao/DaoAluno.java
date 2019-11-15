/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this auxlate file, choose Tools | Templates
 * and open the auxlate in the editor.
 */
package dao;

import Model.Aluno;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import util.JPAUtil;

public class DaoAluno extends AbstractDAO {

    private EntityManager manager;

    public DaoAluno() {
        super(Aluno.class);
        this.manager = this.getManager();
    }

    public boolean searchByRA(String ra) {
        Aluno aux;
        manager = JPAUtil.getEntityManager();
        String sql = "SELECT a FROM Aluno a WHERE a.ra = :n";
        TypedQuery<Aluno> query = manager.createQuery(sql, Aluno.class);
        query.setParameter("n", ra);

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
