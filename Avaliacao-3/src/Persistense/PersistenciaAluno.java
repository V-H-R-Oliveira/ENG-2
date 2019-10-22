/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistense;

import Model.Aluno;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author cc49658458890
 */
public class PersistenciaAluno {

    private final ArrayList<Aluno> alunos;

    public PersistenciaAluno() {
        alunos = new ArrayList<>();
    }

    public boolean persistirAluno(Aluno aluno) {
        if (alunos.isEmpty()) {
            alunos.add(aluno);
            JOptionPane.showMessageDialog(null, "O aluno foi cadastrado com sucesso");
            return true;
        } else {
            for (int i = 0; i < alunos.size(); i++) {
                if (alunos.get(i).getRa().equals(aluno.getRa())) {
                    JOptionPane.showMessageDialog(null, "O aluno já se encontra cadastrado");
                    return false;
                }
            }
            alunos.add(aluno);
            JOptionPane.showMessageDialog(null, "O aluno foi cadastrado com sucesso");
            return true;
        }
    }
}
