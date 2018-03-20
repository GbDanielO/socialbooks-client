package com.algaworks.socialbooks.utils;

import java.util.Base64;

public class Utils {

    public static String getCredencialEncoded( String nome, String password ) {
        return Base64.getEncoder().encodeToString( ( nome + ":" + password ).getBytes() );
    }
}
