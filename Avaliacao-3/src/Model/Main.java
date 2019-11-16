package Model;

import Controller.ControleAluno;
import Controller.ControleEmprestimo;
import Controller.ControleExemplar;
import Controller.ControleItem;
import Controller.ControleTitulo;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        // arrumar calculaDataDevolução de Item e de Empréstimo
        Date hoje = new Date();
        ControleAluno controleAluno = new ControleAluno();
        ControleTitulo controleTitulo = new ControleTitulo();
        ControleExemplar controleExemplar = new ControleExemplar();
        ControleItem controleItem = new ControleItem();
        ControleEmprestimo controleEmprestimo = new ControleEmprestimo();

        Aluno aluno = new Aluno("Thiago Fernandes Ribeiro", "120160", "08462311900", "43996069321", "Av dos Pinheiros, 220");
        Titulo titulo = new Titulo("978-85-333-0227-3", "As crônicas de um Português", "Vitor Oliveira V");
        Emprestimo emprestimo = new Emprestimo(aluno, hoje);

        Exemplar exemplar1 = new Exemplar("1234t", titulo, "teste", true);
        Exemplar exemplar2 = new Exemplar("0000x", titulo, "nova", true);
        Exemplar exemplar3 = new Exemplar("6666a", titulo, "era", true);

        controleAluno.inserirAluno(aluno);
        controleTitulo.inserirTitulo(titulo);
        controleExemplar.inserirExemplar(exemplar1);
        controleExemplar.inserirExemplar(exemplar2);
        controleExemplar.inserirExemplar(exemplar3);

        Item item1 = new Item(exemplar1, emprestimo);
        controleEmprestimo.inserirEmprestimo(emprestimo);
        controleItem.inserirItem(item1);
        Item item2 = new Item(exemplar2, emprestimo);
        Item item3 = new Item(exemplar3, emprestimo);
        Item item4 = new Item(exemplar1, emprestimo);

        item1.calculaDataDevolucao();
        item2.calculaDataDevolucao();
        item3.calculaDataDevolucao();
        item4.calculaDataDevolucao();

    }
}
