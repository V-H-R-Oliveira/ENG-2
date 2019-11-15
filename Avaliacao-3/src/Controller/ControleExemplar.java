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

    public boolean verficaExemplar(Exemplar exemplar) {
        if (dao.searchByExemplar(exemplar.getCodigoExemplar()) && exemplar.isExemplar()) {
            System.out.println("O exemplar encontra-se disponível");
        } else {
            System.out.println("O exemplar não se econtra disponível");
            exemplar.setIsDisponivel(false);
        }

        return exemplar.isDisponivel();
    }

}
