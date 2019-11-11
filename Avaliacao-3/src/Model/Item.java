package Model;

import java.util.Calendar;
import java.util.TimeZone;
import java.util.concurrent.ThreadLocalRandom;

public class Item {

    private Exemplar exemplar;
    private Calendar dataDevolucao;

    public Item(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public Calendar getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Calendar dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Exemplar getItem() {
        return exemplar;
    }

    public void setItem(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public void calculaDataDevolucao() {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));

        if (exemplar.verficaExemplar()) // JPA
        {
            if (exemplar.getCodigoExemplar().equals("reservado")) {
                System.out.println("O exemplar não pode ser emprestado - Apenas de Leitura");
            } else {
                int day = ThreadLocalRandom.current().nextInt(1, 8);
                cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH) + day);
                this.dataDevolucao = cal;
            }
        }
    }
}
