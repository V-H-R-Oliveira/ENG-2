package Persistense;

import Model.Titulo;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PersistenciaTitulo {

    private final ArrayList<Titulo> titulos;

    public PersistenciaTitulo() {
        titulos = new ArrayList<>();
    }

    public boolean persistirTitulo(Titulo titulo) {
        if (titulos.isEmpty()) {
            titulos.add(titulo);
            JOptionPane.showMessageDialog(null, "O Titulo foi cadastrado com sucesso");
            return true;
        } else {
            for (int i = 0; i < titulos.size(); i++) {
                if (titulos.get(i).getIsbn().equals(titulo.getIsbn())) {
                    JOptionPane.showMessageDialog(null, "O Titulo já se encontra cadastrado");
                    return false;
                }
            }

            titulos.add(titulo);
            JOptionPane.showMessageDialog(null, "O Titulo foi cadastrado com sucesso");
            return true;
        }
    }
}
