package aplicacao;

import java.net.URI;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Aplicacao {
	public static void main (String args[]) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		RequestEntity<Void> request = RequestEntity
				.get(URI.create("http://localhost:8080/livros"))
				.header("Authorization", "Basic YXJpZWw6czNuaDQ=").build();
			
		ResponseEntity<Livros[]> response = restTemplate.exchange(request, Livros[].class);
		
		for(Livros livro : response.getBody()) {
			System.out.print("LIVROS: " + livro.getNome());
		}
	}

}
