package aplicacao.client;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import aplicacao.domain.Livros;

public class LivrosClient {
	
	public List<Livros> listar(){
		RestTemplate restTemplate = new RestTemplate();
		
		RequestEntity<Void> request = RequestEntity
				.get(URI.create("http://localhost:8080/livros"))
				.header("Authorization", "Basic YXJpZWw6czNuaDQ=").build();
			
		ResponseEntity<Livros[]> response = restTemplate.exchange(request, Livros[].class);
		
		return Arrays.asList(response.getBody());
	}
	
	public String salvar(Livros livro) {
		RestTemplate restTemplate = new RestTemplate();
		
		
		RequestEntity<Livros> request = RequestEntity
				                        .post(URI.create("http://localhost:8080/livros"))
				                        .header("Authorization", "Basic YXJpZWw6czNuaDQ=")
				                        .body(livro);
		
		ResponseEntity<Void> response = restTemplate.exchange(request, Void.class);
		return response.getHeaders().getLocation().toString();
	}

}
