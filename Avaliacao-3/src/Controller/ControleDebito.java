package Controller;

import Model.Aluno;
import Model.Debito;
import dao.DaoDebito;
import java.util.List;

public class ControleDebito {

    private DaoDebito dao;
    public ControleAluno ca = new ControleAluno();

    public ControleDebito() {
        dao = new DaoDebito();
    }

    public void inserirDebito(Debito debito) {
        dao.inserir(debito);
    }

    public boolean excluirDebito(Long id) {
        Debito tmp = dao.searchByID(id);

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
        List<Debito> tmp = dao.searchByAluno(aluno.getRa());
        if (tmp != null) {
            System.out.println("O aluno possui débito");
            return true;
        }

        System.out.println("O aluno não possui débito");
        return false;
    }
}
