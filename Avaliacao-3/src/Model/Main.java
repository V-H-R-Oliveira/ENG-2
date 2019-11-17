package Model;

import Controller.ControleAluno;
import Controller.ControleEmprestimo;
import Controller.ControleExemplar;
import Controller.ControleItem;
import Controller.ControleTitulo;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Date hoje = new Date();
        ControleAluno controleAluno = new ControleAluno();
        ControleTitulo controleTitulo = new ControleTitulo();
        ControleExemplar controleExemplar = new ControleExemplar();
        ControleItem controleItem = new ControleItem();
        ControleEmprestimo controleEmprestimo = new ControleEmprestimo();

        Aluno aluno = new Aluno("Thiago Fernandes Ribeiro", "120160", "08462311900", "43996069321", "Av dos Pinheiros, 220");
        Aluno aluno2 = new Aluno("Olavo Pereira", "123456", "09012411100", "43009179321", "Mendigo");
        Titulo titulo = new Titulo("978-85-333-0227-3", "As crônicas de um Português", "Vitor Oliveira V");
        Titulo titulo2 = new Titulo("444-85-66-222-5", "Teste", "John Doe");
        
        Emprestimo emprestimo = new Emprestimo("1234", aluno, hoje, hoje);
        Emprestimo emprestimo2 = new Emprestimo("4567", aluno2, hoje, hoje);

        Exemplar exemplar1 = new Exemplar("1234t", titulo, "teste", true);
        Exemplar exemplar2 = new Exemplar("0000x", titulo, "nova", true);
        Exemplar exemplar3 = new Exemplar("6666a", titulo, "era", true);
        Exemplar exemplar4 = new Exemplar("1111t", titulo2, "nada", true);
        
        controleAluno.inserirAluno(aluno);
        controleAluno.inserirAluno(aluno2);
        
        controleTitulo.inserirTitulo(titulo);
        controleTitulo.inserirTitulo(titulo2);
        
        controleExemplar.inserirExemplar(exemplar1);
        controleExemplar.inserirExemplar(exemplar2);
        controleExemplar.inserirExemplar(exemplar3);
        controleExemplar.inserirExemplar(exemplar4);
        
        controleEmprestimo.inserirEmprestimo(emprestimo);
        controleEmprestimo.inserirEmprestimo(emprestimo2);

        Item item1 = new Item("abcd", exemplar1, emprestimo);
        Item item2 = new Item("xyzw", exemplar2, emprestimo);
        Item item3 = new Item("1245", exemplar3, emprestimo);
        Item item4 = new Item("fuck", exemplar1, emprestimo);
        
        Item item5 = new Item("aaaa", exemplar1, emprestimo2);
        Item item6 = new Item("bbbb", exemplar2, emprestimo2);
        Item item7 = new Item("cccc", exemplar3, emprestimo2);
        Item item8 = new Item("dddd", exemplar4, emprestimo2);
      
        controleItem.inserirItem(item1);
        controleItem.inserirItem(item2);
        controleItem.inserirItem(item3);
        controleItem.inserirItem(item4);
        
        controleItem.inserirItem(item5);
        controleItem.inserirItem(item6);
        controleItem.inserirItem(item7);
        controleItem.inserirItem(item8);
        
        List<Item> items = controleItem.listarItems(emprestimo);
        controleEmprestimo.emprestar(emprestimo, items);
        items.clear();
        items = controleItem.listarItems(emprestimo2);
        controleEmprestimo.emprestar(emprestimo2, items);
    }
}
