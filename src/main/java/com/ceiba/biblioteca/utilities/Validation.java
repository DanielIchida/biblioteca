package com.ceiba.biblioteca.utilities;

import java.util.regex.Pattern;

public class Validation {

    public static boolean validateIsbn(String isbn){
        boolean alfanumerico = Pattern.matches("^[0-9a-zA-Z]+$",isbn);
        int isbnSize = isbn.length();
        return alfanumerico && isbnSize <= 10;
    }

    public static boolean validateIdUser(String identificacion){
        boolean numerico = Pattern.matches("^[0-9]+$",identificacion);
        int sizeIdent = identificacion.length();
        return numerico && sizeIdent <= 10;
    }

}
