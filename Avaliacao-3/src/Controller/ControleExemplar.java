package Controller;

import Model.Exemplar;
import dao.DaoExemplar;
import java.util.Vector;

public class ControleExemplar {

    private DaoExemplar dao;

    public ControleExemplar() {
        this.dao = new DaoExemplar();
    }

    public void inserirExemplar(Exemplar exemplar) {
        dao.inserir(exemplar);
    }

    public void update(Exemplar exemplar) {
        dao.update(exemplar.getId(), exemplar);
    }

    public boolean excluiExemplar(Long id) {
        Exemplar tmp = dao.searchByExemplar(id);

        if (tmp != null) {
            if (dao.excluir(tmp.getId())) {
                System.out.println("O exemplar foi excluído com sucesso");
                return true;
            } else {
                System.out.println("O exemplar não foi excluído");
                return false;
            }
        } else {
            System.out.println("O exemplar não encontra-se cadastrado");
            return false;
        }
    }

    public boolean verificaExemplar(Exemplar exemplar) {
        Exemplar tmp = dao.searchByExemplar(exemplar.getId());

        if (tmp != null && tmp.isExemplar()) {
            System.out.println("O exemplar encontra-se disponível e pode ser emprestado");
            return true;
        } else if (tmp != null && !tmp.isExemplar()) {
            System.out.println("O exemplar encontra-se disponível, porém ele é reservado");
            return false;
        } else {
            System.out.println("O exemplar não econtra-se cadastrado");
            return false;
        }
    }

    public void updateDisponibilidade(Long id, boolean estado) {
        dao.UpdateDispo(id, estado);
    }

    public Vector<Exemplar> searchByISBN(String isbn) {
        return dao.searchByISBN(isbn);
    }

    public Exemplar searchByExemplar(Long id) {
        return dao.searchByExemplar(id);
    }

}
