package com.ceiba.biblioteca.utilities;
import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class DateUtil {

    public static LocalDate sumarFecha(LocalDate localDate, int dias) throws ParseException {
        LocalDate result = localDate;
        int addedDays = 0;
        while (addedDays < dias) {
            result = result.plusDays(1);
            if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                ++addedDays;
            }
        }
        return result;
    }

    public static String formatFecha(LocalDate fecha){
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return fecha.format(dft);
    }


    public static String fechaActual(){
        Calendar calendar = Calendar.getInstance();
        LocalDate currentDate = LocalDate.of(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) + 1,
                calendar.get(Calendar.DAY_OF_MONTH));
        return formatFecha(currentDate);
    }




}
