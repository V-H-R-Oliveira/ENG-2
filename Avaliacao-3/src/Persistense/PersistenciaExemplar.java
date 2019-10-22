package Persistense;

import Model.Exemplar;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PersistenciaExemplar {

    private final ArrayList<Exemplar> exemplares;

    public PersistenciaExemplar() {
        exemplares = new ArrayList<>();
    }

    public boolean persistirExemplar(Exemplar exemplar) {
        if (exemplares.isEmpty()) {
            exemplares.add(exemplar);
            JOptionPane.showMessageDialog(null, "O Exemplar foi cadastrado com sucesso");
            return true;
        } else {
            for (int i = 0; i < exemplares.size(); i++) {
                if (exemplares.get(i).getCodigoExemplar().equals(exemplar.getCodigoExemplar())) {
                    JOptionPane.showMessageDialog(null, "O Exemplar já se encontra cadastrado");
                    return false;
                }
            }

            exemplares.add(exemplar);
            JOptionPane.showMessageDialog(null, "O Exemplar foi cadastrado com sucesso");
            return true;
        }
    }
}
