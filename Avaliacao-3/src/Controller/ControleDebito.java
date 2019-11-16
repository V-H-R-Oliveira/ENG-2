package Controller;

import Model.Aluno;
import Model.Debito;
import dao.DaoDebito;

public class ControleDebito {

    private DaoDebito dao;

    public ControleDebito() {
        dao = new DaoDebito();
    }

    public void inserirDebito(Debito debito) {
        dao.inserir(debito);
    }

    public boolean excluirDebito(Aluno aluno) {
        Debito tmp = dao.searchByAluno(aluno);

        if (tmp != null) {
            if (dao.excluir(tmp.getId())) {
                System.out.println("O débito foi excluído com sucesso");
                return true;
            }

            System.out.println("O débito não foi excluído");
            return false;
        } else {
            System.out.println("Nenhum débito está cadastrado no sistema");
            return false;
        }
    }

    public boolean verificarDebito(Aluno aluno) {
        Debito tmp = dao.searchByAluno(aluno);
        if (tmp != null) {
            System.out.println("O aluno possui débito");
            return true;
        }

        System.out.println("O aluno não possui débito");
        return false;
    }
}
