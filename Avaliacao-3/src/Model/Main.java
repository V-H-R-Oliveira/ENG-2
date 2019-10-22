package Model;

import Controller.Controle;
import Persistense.PersistenciaAluno;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {

        Scanner entrada = new Scanner(System.in);
        PersistenciaAluno pa = new PersistenciaAluno();
        int[] codigos = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.print("Digite o RA do Aluno: ");
        String aluno = entrada.nextLine();
        System.out.print("Digite o numero de Livros a ser Emprestado: ");
        int num = entrada.nextInt();
        int aux;
        for (int i = 0; i < num; i++) {
            System.out.print("Digite o codigo do livro " + (i + 1) + ": ");
            aux = entrada.nextInt();
            codigos[i] = aux;
        }

        Controle c = new Controle();
        //c.emprestar(aluno, codigos, num, pa);

    }

}
