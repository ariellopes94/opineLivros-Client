package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import aplicacao.client.LivrosClient;
import aplicacao.domain.Livros;

public class Aplicacao {
	public static void main (String args[]) throws ParseException {
		
		LivrosClient cliente = new LivrosClient();
		
		List<Livros> listarLivros = cliente.listar();
		
		for(Livros livro : listarLivros) {
			System.out.println("");
			System.out.print("LIVROS: " + livro.getNome());
		}
		
		Livros livro = new Livros();
		livro.setNome("Aprenda String Boot");
		livro.setEditora("Ariel Lopes S.A");
		SimpleDateFormat publicacao = new SimpleDateFormat("dd/MM/yyyy");
		livro.setPublicacao(publicacao.parse("01/02/2020"));
		
		livro.setResumo("Este livro aborda tecnicas de desenvolvimento de APIs.");
		
		String localizacao = cliente.salvar(livro);
		System.out.println("");
		System.out.println("URI do livro salvo " + localizacao );
	}

}
