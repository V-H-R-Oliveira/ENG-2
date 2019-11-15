package Controller;

import Model.Aluno;
import Model.Debito;
import dao.DaoDebito;


public class ControleDebito {
    private DaoDebito dao;
    
    public ControleDebito()
    {
        dao = new DaoDebito();
    }
    
    public void inserirDebito(Debito debito) {
        dao.inserir(debito);
    }

//    public boolean excluirDebito(Debito debito) {
//        System.out.println("Ia: " + debito.getId());
//        if (dao.excluir(debito.getId())) {
//            System.out.println("O aluno foi excluído com sucesso");
//            return true;
//        }
//
//        System.out.println("O aluno não foi excluído");
//        return false;
//    }

    public boolean verificarDebito(Aluno aluno) {
        if (dao.verificaDebito(aluno)) {
            System.out.println("O aluno possui débito");
            return true;
        }

        System.out.println("O aluno não possui débito");
        return false;
    }

    public DaoDebito getDao() {
        return dao;
    }

    public void setDao(DaoDebito dao) {
        this.dao = dao;
    }
}
