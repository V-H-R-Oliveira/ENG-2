package Controller;

import Model.Titulo;
import dao.DaoTitulo;

public class ControleTitulo {

    private DaoTitulo dao;

    public ControleTitulo() {
        dao = new DaoTitulo();
    }

    public void inserirTitulo(Titulo titulo) {
        dao.inserir(titulo);
    }

    public boolean excluirTitulo(Titulo titulo) {
        Titulo tmp = dao.searchByIsbn(titulo.getIsbn());

        if (tmp != null) {
            if (dao.excluir(tmp.getId())) {
                System.out.println("O titulo foi excluído com sucesso");
                return true;
            }
            System.out.println("O título não foi excluído");
            return false;
        }

        System.out.println("O titulo não existe");
        return false;
    }

    public boolean verificarTitulo(Titulo titulo) {
        Titulo tmp = dao.searchByIsbn(titulo.getIsbn());

        if (tmp != null) {
            System.out.println("O titulo se encontra cadastrado");
            return true;
        }

        System.out.println("O titulo não encontra-se cadastrado");
        return false;
    }
}
