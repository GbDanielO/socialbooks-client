package com.algaworks.socialbooks.client;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.algaworks.socialbooks.model.Livro;
import com.algaworks.socialbooks.utils.Utils;

public class LivrosClient {

    public List<Livro> getListLivros( URI uri, String login, String password ) {
        RestTemplate restTemplate = new RestTemplate();

        RequestEntity<Void> request = RequestEntity.get( uri )
                .header( "Authorization", "Basic " + Utils.getCredencialEncoded( login, password ) ).build();

        ResponseEntity<Livro[]> response = restTemplate.exchange( request, Livro[].class );

        return Arrays.asList( response.getBody() );
    }

    public String salvarLivro( Livro livro, URI uri, String login, String password ) {
        RestTemplate restTemplate = new RestTemplate();

        RequestEntity<Livro> request = RequestEntity.post( uri )
                .header( "Authorization", "Basic " + Utils.getCredencialEncoded( login, password ) )
                .body( livro, Livro.class );

        ResponseEntity<Void> response = restTemplate.exchange( request, Void.class );

        return response.getHeaders().getLocation().toString();
    }

    public Livro buscarPeloId( URI uri, String login, String password ) {
        RestTemplate restTemplate = new RestTemplate();

        RequestEntity<Void> request = RequestEntity.get( uri )
                .header( "Authorization", "Basic " + Utils.getCredencialEncoded( login, password ) )
                .build();

        ResponseEntity<Livro> response = restTemplate.exchange( request, Livro.class );

        return response.getBody();
    }
}
