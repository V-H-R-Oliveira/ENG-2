package Model;

import dao.GenericDAO;

public class Titulo {

    private String isbn;
    private String nome;
    private String autor;
    private GenericDAO dao;

    public Titulo(String isbn, String nome, String autor, GenericDAO d) {
        this.isbn = isbn;
        this.nome = nome;
        this.autor = autor;
        this.dao = d;
    }
/*
    public boolean verficaTitulo() {   //Se o RA � null � retorna erro - m�todo aleat�rio
        if (d.persistirTitulo(this)) {
            return true;
        }
        return false;
    }
*/
    public String getTitulo() {
        return isbn;
    }

    public void setTitulo(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
