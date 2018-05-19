package com.uepb.controlebiblioteca.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Util representa uma ferramenta com uma unica funcionalidade de encriptar uma senha passada
 * @author Eduardo Borba
 *
 */
public class Util {
	/**
	 * encodePassword retorna um password criptografado, usando como parametro um String password passado pelo usuario.
	 * @param password
	 * 
	 */
    public static String encodePassword(String password){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}

