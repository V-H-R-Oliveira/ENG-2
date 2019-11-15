package Controller;

import dao.DaoAluno;
import Model.Aluno;

public class ControleAluno {

    private DaoAluno dao;

    public ControleAluno() {
        dao = new DaoAluno();
    }

    public void inserirAluno(Aluno aluno) {
        dao.inserir(aluno);
    }

    public boolean excluirAluno(Aluno aluno) {
        System.out.println("Ia: " + aluno.getId());
        if (dao.excluir(aluno.getId())) {
            System.out.println("O aluno foi excluído com sucesso");
            return true;
        }

        System.out.println("O aluno não foi excluído");
        return false;
    }

    public boolean verificarAluno(Aluno aluno) {
        if (dao.searchByRA(aluno.getRa())) {
            System.out.println("O aluno se encontra cadastrado");
            return true;
        }

        System.out.println("O aluno não se encontra cadastrado");
        return false;
    }

    public DaoAluno getDao() {
        return dao;
    }

    public void setDao(DaoAluno dao) {
        this.dao = dao;
    }

}
