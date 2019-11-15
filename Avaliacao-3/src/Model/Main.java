package Model;

import Controller.ControleAluno;
import Controller.ControleDebito;
import Controller.ControleExemplar;
import Controller.ControleTitulo;
import java.util.Date;
//import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Date hoje = new Date();
        ControleAluno controleAluno = new ControleAluno();
        ControleTitulo controleTitulo = new ControleTitulo();
        ControleDebito controleDebito = new ControleDebito();
        ControleExemplar controleExemplar = new ControleExemplar();
        
        Aluno aluno = new Aluno("Thiago Fernandes Ribeiro", "120160", "08462311900", "43996069321", "Av dos Pinheiros, 220");
        Titulo titulo = new Titulo("978-85-333-0227-3", "As crônicas de um Português", "Vitor Oliveira V");
        
        Exemplar exemplar1 = new Exemplar("1234t", titulo, "teste", true);
        Exemplar exemplar2 = new Exemplar("0000x", titulo, "nova", true);
        Exemplar exemplar3 = new Exemplar("6666a", titulo, "era", true);
        
        controleAluno.inserirAluno(aluno);        
        controleDebito.verificarDebito(aluno);
        controleTitulo.inserirTitulo(titulo);
        controleExemplar.inserirExemplar(exemplar1);
        controleExemplar.inserirExemplar(exemplar2);
        controleExemplar.inserirExemplar(exemplar3);


//        Emprestimo emprestimo = new Emprestimo(aluno, hoje);
//        Item item1 = new Item(exemplar1, emprestimo);
//        Item item2 = new Item(exemplar2, emprestimo);
//        Item item3 = new Item(exemplar3, emprestimo);
//        Item item4 = new Item(exemplar1, emprestimo);
//
//        ArrayList<Item> items = new ArrayList<>();
//
//        //Inserção
//        item1.calculaDataDevolucao();
//        item2.calculaDataDevolucao();
//        item3.calculaDataDevolucao();
//        item4.calculaDataDevolucao();
//
//        items.add(item1);
//        items.add(item2);
//        items.add(item3);
//        items.add(item4);
//
//        emprestimo.setItems(items);
//
//        emprestimo.calculaDataDevolucao();
//
//        daoEmprestimo.inserir(emprestimo);
//        daoItem.inserir(item1);
//        daoItem.inserir(item2);
//        daoItem.inserir(item3);
//        daoItem.inserir(item4);
    }
}
