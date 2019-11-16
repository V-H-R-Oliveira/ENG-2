package Controller;

import Model.Exemplar;
import dao.DaoExemplar;

public class ControleExemplar {

    private DaoExemplar dao;

    public ControleExemplar() {
        this.dao = new DaoExemplar();
    }

    public void inserirExemplar(Exemplar exemplar) {
        dao.inserir(exemplar);
    }

    public boolean excluiExemplar(Exemplar exemplar) {
        Exemplar tmp = dao.searchByExemplar(exemplar.getCodigoExemplar());
        
        if(tmp != null)
        {
            if(dao.excluir(tmp.getId()))
            {
                System.out.println("O exemplar foi excluído com sucesso");
                return true;
            }else {
                System.out.println("O exemplar não foi excluído");
                return false;
            }
        }else {
            System.out.println("O exemplar não encontra-se cadastrado");
            return false;
        }
    }

    public boolean verificaExemplar(Exemplar exemplar) {
        Exemplar tmp = dao.searchByExemplar(exemplar.getCodigoExemplar());

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
}
