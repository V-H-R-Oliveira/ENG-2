import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Emprestimo {

	Date dataEmprestimo = new Date();
	/*metodo para gegar a variavel dataEmprestimo*/
	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	/*metodo para setar a variavel dataEmprestimo*/
	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	/*utilize essas váriaveis para calcular a data final de devolução*/
    Date dataPrevista = new Date();
	Date data_aux = new Date();
	List<Item> items = new ArrayList<Item>();
	
        //Metodo responsável por calcular a data de devolução
	public Date calculaDataDevolucao()
	{   
	 	Calendar calendar = Calendar.getInstance();	
		int prazo, maior = 0, acrescimo = 0;

		if(items.size() > 3)
			acrescimo = 2;

		for(Item item : items)
		{
			prazo = item.getLivro().verPrazo() + acrescimo;
			calendar.setTime(data_aux);
			calendar.add(Calendar.DAY_OF_WEEK, prazo);
			item.setDataDevolucao(calendar.getTime());

			System.out.println("Empréstimo para o item:  "+ item.getDataDevolucao());

			if(prazo > maior)
			{
				maior = prazo;
				dataPrevista = calendar.getTime();
			}
		}

		return dataPrevista;
	}
}