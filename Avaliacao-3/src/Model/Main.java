package Model;

import dao.GenericDAO;


public class Main {

    public static void main(String[] args) throws Exception  {
        GenericDAO<Aluno> daoAluno = new GenericDAO<>(Aluno.class);
        GenericDAO<Debito> daoDebito = new GenericDAO<>(Debito.class);
        Aluno a1 = new Aluno("Vitor Oliveira", "120151", "12345678910", "99999999999", "Rua das couves, 220");
        Aluno a2 = new Aluno("Thiago Ribeiro", "120160", "12345678910", "99999999999", "Avenida dos loucos, 151");
        Debito d1 = new Debito(a1, 20.50, true);
        
//        daoAluno.inserir(a1);
//        daoAluno.inserir(a2);
//        daoDebito.inserir(d1);
        
        
        if(a1.verificaAluno()) System.out.println("Aluno " + a1.getNome() + " Cadastrado");
        else System.out.println("Aluno " + a1.getNome() + " Não cadastrado");
        
        if(a2.verificaAluno()) System.out.println("Aluno " + a2.getNome() + " Cadastrado");
        else System.out.println("Aluno " + a2.getNome() + " Não cadastrado");
               
        if(d1.verificaDebito()) System.out.println("Aluno " + d1.getAluno().getNome() + " possui " + d1.getValor() + " em debitos");
        else System.out.println("Aluno " + d1.getAluno().getNome() + " não possui debitos");
    }
}