package com.algaworks.socialbooks.aplicacao;

import java.net.URI;
import java.util.Date;
import java.util.List;

import com.algaworks.socialbooks.client.LivrosClient;
import com.algaworks.socialbooks.model.Livro;

public class Aplicacao {

    public static void main( String[] args ) {

        String login = "algaworks";

        String password = "s3nh4";

        Livro livroNovo = new Livro( "How to says every things in English" );
        livroNovo.setEditora( "Campus" );
        livroNovo.setPublicacao( new Date() );
        livroNovo.setResumo( "Várias conversações para diferentes situações" );

        LivrosClient livrosClient = new LivrosClient();

        String localizacao =
                livrosClient.salvarLivro( livroNovo, URI.create( "http://localhost:8080/livros" ), login, password );

        List<Livro> livros =
                livrosClient.getListLivros( URI.create( "http://localhost:8080/livros" ), login, password );

        for ( Livro livro : livros ) {
            System.out.println( livro.getNome() );
        }

        System.out.println( localizacao );

        Livro livroRetornado = livrosClient.buscarPeloId( URI.create( localizacao ), login, password );

        System.out.println( livroRetornado.getNome() + ": " + livroRetornado.getResumo() );
    }

}
