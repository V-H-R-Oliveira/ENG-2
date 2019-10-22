public class Main 
{
	public static void main(String[] args) 
	{
		Emprestimo emprestimo = new Emprestimo();

		Livro l1 = new Livro(1);
		Livro l2 = new Livro(2);
		Livro l3 = new Livro(3); 
		
		Item i1 = new Item(l1);
		Item i2 = new Item(l2);
		Item i3 = new Item(l3);
		// Item i4 = new Item(l3);

		emprestimo.items.add(i1);
		emprestimo.items.add(i2);
		emprestimo.items.add(i3);
		// emprestimo.items.add(i4);

		System.out.println("Data de Empréstimo: " + emprestimo.getDataEmprestimo());
		System.out.println("Data de Devolução: " + emprestimo.calculaDataDevolucao());
	}
}