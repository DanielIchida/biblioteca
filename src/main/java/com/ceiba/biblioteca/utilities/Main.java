package com.ceiba.biblioteca.utilities;

import java.text.ParseException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws ParseException {
        LocalDate fechaPrestamo = LocalDate.now();
        LocalDate d = DateUtil.sumarFecha(fechaPrestamo,8);
        System.out.println(DateUtil.formatFecha(d));

        System.out.println(TypeUserEnum.AFILIADO.ordinal());
    }
}
