package Model;

import dao.GenericDAO;
import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        //DAOs
        GenericDAO<Aluno> daoAluno = new GenericDAO<Aluno>(Aluno.class);
        GenericDAO<Debito> daoDebito = new GenericDAO<Debito>(Debito.class);
        GenericDAO<Emprestimo> daoEmprestimo = new GenericDAO<Emprestimo>(Emprestimo.class);
        GenericDAO<Exemplar> daoExemplar = new GenericDAO<Exemplar>(Exemplar.class);
        GenericDAO<Item> daoItem = new GenericDAO<Item>(Item.class);
        GenericDAO<Titulo> daoTitulo = new GenericDAO<Titulo>(Titulo.class);

        //Instancias
        Date hoje = new Date();
        Aluno aluno = new Aluno("Thiago Fernandes Ribeiro", "120160", "08462311900", "43996069321", "Av dos Pinheiros, 220");
        Debito debito = new Debito(aluno, 20.5, true);
        Emprestimo emprestimo = new Emprestimo(aluno, hoje);
        Titulo titulo = new Titulo("978-85-333-0227-3", "As crônicas de um Português", "Vitor Oliveira V");
        Exemplar exemplar1 = new Exemplar(false, titulo, "Disponivel", "Novo Horizonte");
        Exemplar exemplar2 = new Exemplar(false, titulo, "Disponivel", "Velho Oeste");
        Exemplar exemplar3 = new Exemplar(false, titulo, "Disponivel", "Seta");
        Item item1 = new Item(exemplar1);
        Item item2 = new Item(exemplar2);
        Item item3 = new Item(exemplar3);
        Item item4 = new Item(exemplar1);

        ArrayList<Item> items = new ArrayList<>();

        //Inserção
        item1.calculaDataDevolucao();
        item2.calculaDataDevolucao();
        item3.calculaDataDevolucao();
        item4.calculaDataDevolucao();

        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);

        emprestimo.setItems(items);
        
        emprestimo.calculaDataDevolucao();
        
        daoAluno.inserir(aluno);
        daoTitulo.inserir(titulo);
        daoExemplar.inserir(exemplar1);
        daoExemplar.inserir(exemplar2);
        daoExemplar.inserir(exemplar3);
        daoItem.inserir(item1);
        daoItem.inserir(item2);
        daoItem.inserir(item3);
        daoItem.inserir(item4);
        daoDebito.inserir(debito);
        daoEmprestimo.inserir(emprestimo);
    }
}
