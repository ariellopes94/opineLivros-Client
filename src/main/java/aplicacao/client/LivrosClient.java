package aplicacao.client;

import java.net.URI;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import aplicacao.domain.Livros;

public class LivrosClient {
	
	private RestTemplate restTemplate;
	
	private String URI_BASE;
	
	private String URN_BASE = "/livros";
	
	private String crecencial;
	
	public LivrosClient(String url, String usuario, String senha) {
		restTemplate = new RestTemplate();
		
		URI_BASE = url.concat(URN_BASE);
		
		String credencialAux = usuario + ":" + senha;
		
		crecencial = "Basic " + Base64.getEncoder()
		             .encodeToString(credencialAux.getBytes());
	}
	
	public List<Livros> listar(){
		RequestEntity<Void> request = RequestEntity
				.get(URI.create(URI_BASE))
				.header("Authorization", crecencial).build();
			
		ResponseEntity<Livros[]> response = restTemplate.exchange(request, Livros[].class);
		
		return Arrays.asList(response.getBody());
	}
	
	public String salvar(Livros livro) {
			RequestEntity<Livros> request = RequestEntity
				                        .post(URI.create(URI_BASE))
				                        .header("Authorization", crecencial)
				                        .body(livro);
		
		ResponseEntity<Void> response = restTemplate.exchange(request, Void.class);
		return response.getHeaders().getLocation().toString();
	}
	
	public Livros buscar(String uri) {
		RequestEntity<Void> request = RequestEntity
				   .get(URI.create(uri))
				   .header("Authorization", crecencial)
				   .build();
		
		ResponseEntity<Livros> response = restTemplate.exchange(request, Livros.class);
		
		return response.getBody();
		
	}

}
