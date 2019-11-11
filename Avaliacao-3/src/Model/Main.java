package Model;

import Persistense.PersistenciaAluno;
import Persistense.PersistenciaExemplar;
import Persistense.PersistenciaTitulo;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        PersistenciaAluno a = new PersistenciaAluno();
        PersistenciaTitulo pt = new PersistenciaTitulo();
        PersistenciaExemplar pe = new PersistenciaExemplar();
        ArrayList<Item> items = new ArrayList<>();
        Aluno aluno = new Aluno("12345", "hiena", "1234", a);
        Titulo t = new Titulo("Clandestino", "Null-sense", "Tatu", pt);
        Titulo t2 = new Titulo("Abnt", "HOLLA", "Chapa", pt);
        Exemplar e = new Exemplar(true, t, "1234", "jay", pe);
        Exemplar e2 = new Exemplar(true, t2, "12345", "jayz", pe);
        Exemplar e3 = new Exemplar(true, t2, "123456", "jayz", pe);
        Exemplar e4 = new Exemplar(true, t2, "1234567", "jayz", pe);
        Item i = new Item(e);
        Item i2 = new Item(e2);
        Item i3 = new Item(e3);
        Item i4 = new Item(e4);
        i.calculaDataDevolucao();
        i2.calculaDataDevolucao();
        i3.calculaDataDevolucao();
        i4.calculaDataDevolucao();
        Emprestimo emp = new Emprestimo(aluno);
        items.add(i);
        items.add(i2);
        items.add(i3);
        items.add(i4);
        emp.setItems(items);
        emp.calculaDataDevolucao();
    }
}
