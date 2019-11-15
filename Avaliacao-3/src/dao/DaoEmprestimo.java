package dao;

import Model.Emprestimo;
import javax.persistence.EntityManager;

public class DaoEmprestimo extends AbstractDAO {

    private EntityManager manager;

    public DaoEmprestimo() {
        super(Emprestimo.class);
        this.manager = this.getManager();
    }
}
