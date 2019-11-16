package Controller;

import Model.Emprestimo;
import dao.DaoEmprestimo;

public class ControleEmprestimo {

    private DaoEmprestimo dao;
    
    public ControleEmprestimo() {
        dao = new DaoEmprestimo();
    }
    
    public void inserirEmprestimo(Emprestimo emprestimo) {        
        dao.inserir(emprestimo);
    }
}
