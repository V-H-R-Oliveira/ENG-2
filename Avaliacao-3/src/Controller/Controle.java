package Controller;

import dao.GenericDAO;
import java.io.Serializable;
import java.util.List;
import Model.Aluno;

public class Controle implements Serializable
{
    private Aluno aluno;
    private GenericDAO<Aluno> dao;
    
    public Controle()
    {
        aluno = new Aluno();
        dao = new GenericDAO(Aluno.class);
    }
    
    public void inserirAluno()
    {
        dao.inserir(aluno);
        aluno = new Aluno();
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public GenericDAO<Aluno> getDao() {
        return dao;
    }

    public void setDao(GenericDAO<Aluno> dao) {
        this.dao = dao;
    }

}
