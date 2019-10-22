package Model;

import Persistense.PersistenciaAluno;

public class Aluno {

    private String nome;
    private String ra;
    private String contato;
    private PersistenciaAluno persistenciaA;

    public Aluno(String ra, String nome, String contato, PersistenciaAluno a) {
        this.nome = nome;
        this.ra = ra;
        this.contato = contato;
        this.persistenciaA = a;
    }

    public String getNome() {
        return ra;
    }

    public void setNome(String nome) {
        this.ra = nome;
    }

    public boolean verficaAluno() {   //Se o RA � null � retorna erro - m�todo aleat�rio
        if (persistenciaA.persistirAluno(this)) {
            return true;
        }
        return false;
    }

    public PersistenciaAluno getPersistenciaA() {
        return persistenciaA;
    }

    public void setPersistenciaA(PersistenciaAluno persistenciaA) {
        this.persistenciaA = persistenciaA;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

}
