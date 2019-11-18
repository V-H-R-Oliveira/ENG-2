package Controller;

import dao.DaoAluno;
import Model.Aluno;
import java.util.Vector;

public class ControleAluno {

    private DaoAluno dao;

    public ControleAluno() {
        dao = new DaoAluno();
    }

    public void inserirAluno(Aluno aluno) {
        dao.inserir(aluno);
    }

    public boolean excluirAluno(Aluno aluno) {
        Aluno tmp = dao.searchByRA(aluno.getRa());

        if (tmp != null) {
            if (dao.excluir(tmp.getId())) {
                System.out.println("O aluno foi excluído com sucesso");
                return true;
            } else {
                System.out.println("O aluno não foi excluído");
                return false;
            }
        } else {
            System.out.println("O aluno não existe");
            return false;
        }
    }

    public boolean verificarAluno(Aluno aluno) {
        Aluno tmp = dao.searchByRA(aluno.getRa());

        if (tmp != null) {
            System.out.println("O aluno encontra-se cadastrado");
            return true;
        }

        System.out.println("O aluno não se encontra cadastrado");
        return false;
    }

    public Aluno BuscaPorRA(String ra) {
        Aluno tmp = dao.searchByRA(ra);

        if (tmp != null) {
            System.out.println("O aluno encontra-se cadastrado");
            return tmp;
        }

        System.out.println("O aluno não se encontra cadastrado");
        return null;
    }

    public Vector<String> listAll() {
        return dao.listAll();
    }
}
