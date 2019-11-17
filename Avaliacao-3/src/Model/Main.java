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
        Titulo titulo = new Titulo("978-85-333-0227-3", "As crônicas de um Português", "Vitor Oliveira V");
        Emprestimo emprestimo = new Emprestimo("1234", aluno, hoje);

        Exemplar exemplar1 = new Exemplar("1234t", titulo, "teste", true);
        Exemplar exemplar2 = new Exemplar("0000x", titulo, "nova", true);
        Exemplar exemplar3 = new Exemplar("6666a", titulo, "era", true);

        controleAluno.inserirAluno(aluno);
        controleTitulo.inserirTitulo(titulo);
        controleExemplar.inserirExemplar(exemplar1);
        controleExemplar.inserirExemplar(exemplar2);
        controleExemplar.inserirExemplar(exemplar3);
        controleEmprestimo.inserirEmprestimo(emprestimo);

        Item item1 = new Item("abcd", exemplar1, emprestimo);
        Item item2 = new Item("xyzw", exemplar2, emprestimo);
        Item item3 = new Item("1245", exemplar3, emprestimo);
        Item item4 = new Item("fuck", exemplar1, emprestimo);
       
        controleItem.inserirItem(item1);
        controleItem.inserirItem(item2);
        controleItem.inserirItem(item3);
        controleItem.inserirItem(item4);
        
        List<Item> items = controleItem.listarItems();
        controleEmprestimo.emprestar(emprestimo, items);
    }
}
