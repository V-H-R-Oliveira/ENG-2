package Controller;

import Model.Titulo;
import dao.DaoTitulo;
import java.util.Vector;

public class ControleTitulo {

    private DaoTitulo dao;

    public ControleTitulo() {
        dao = new DaoTitulo();
    }

    public void inserirTitulo(Titulo titulo) {
        dao.inserir(titulo);
    }

    public boolean excluirTitulo(Long id) {
        Titulo tmp = dao.searchByIsbn(id);

        if (tmp != null) {
            if (dao.excluir(tmp.getId())) {
                System.out.println("O título foi excluído com sucesso");
                return true;
            }

            System.out.println("O título não foi excluído");
            return false;
        } else {
            System.out.println("Nenhum título está cadastrado no sistema");
            return false;
        }
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

    public Vector<Model.Titulo> listAllT() {
        return dao.listAllT();
    }

    public Vector<String> listAll() {
        return dao.listAll();
    }

    public Titulo searchByIsbn(String isbn) {
        return dao.searchByIsbn(isbn);
    }

    public Titulo searchByIsbn(Long id) {
        return dao.searchByIsbn(id);
    }

}
