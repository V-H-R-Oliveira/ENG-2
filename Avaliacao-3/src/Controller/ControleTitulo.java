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

//    public boolean excluirTitulo(Titulo titulo) {
//        System.out.println("Ia: " + titulo.getId());
//        if (dao.excluir(titulo.getId())) {
//            System.out.println("O titulo foi excluído com sucesso");
//            return true;
//        }
//
//        System.out.println("O titulo não foi excluído");
//        return false;
//    }

    public boolean verificarTitulo(Titulo titulo) {
        if (dao.searchByIsbn(titulo.getIsbn())) {
            System.out.println("O titulo se encontra cadastrado");
            return true;
        }

        System.out.println("O titulo não se encontra cadastrado");
        return false;
    }
}
