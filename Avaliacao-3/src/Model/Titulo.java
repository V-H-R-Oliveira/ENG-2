package Model;

import Persistense.PersistenciaTitulo;

public class Titulo 
{
    private String isbn;
    private String nome;
    private String autor;
    
    private PersistenciaTitulo persistenciaT;

    public Titulo(String isbn, String nome, String autor, PersistenciaTitulo persistenciaT) {
        this.isbn = isbn;
        this.nome = nome;
        this.autor = autor;
        this.persistenciaT = persistenciaT;
    }

    public boolean verficaTitulo() {
        return persistenciaT.persistirTitulo(this);
    }
    
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
