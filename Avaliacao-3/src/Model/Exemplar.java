package Model;

import dao.GenericDAO;

public class Exemplar {

    private boolean exemplar;
    private Titulo titulo;
    private String codigoExemplar;
    private String editora;
    private GenericDAO dao;


    public Exemplar(boolean exemplar, Titulo titulo, String codigoExemplar, String editora, GenericDAO d) {
        this.exemplar = exemplar;
        this.titulo = titulo;
        this.codigoExemplar = codigoExemplar;
        this.editora = editora;
        this.dao = d;
    }
/*
    public boolean verficaExemplar() {   //Se o RA � null � retorna erro - m�todo aleat�rio
        if (dao.persistirExemplar(this)) {
            return true;
        }
        return false;
    }
*/
    public boolean isExemplar() {
        return exemplar;
    }

    public void setExemplar(boolean exemplar) {
        this.exemplar = exemplar;
    }

    public Titulo getTitulo() {
        return titulo;
    }

    public void setTitulo(Titulo titulo) {
        this.titulo = titulo;
    }

    public String getCodigoExemplar() {
        return codigoExemplar;
    }

    public void setCodigoExemplar(String codigoExemplar) {
        this.codigoExemplar = codigoExemplar;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }


}
