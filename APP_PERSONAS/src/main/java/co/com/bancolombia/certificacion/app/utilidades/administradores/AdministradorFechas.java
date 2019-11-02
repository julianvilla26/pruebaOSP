package co.com.bancolombia.certificacion.app.utilidades.administradores;

import co.com.bancolombia.backend.utilidades.enums.CodigosExcepciones;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AdministradorFechas {

    private static final Logger LOGGER = LogManager.getLogger(AdministradorFechas.class.getName());

    private AdministradorFechas() {
        throw new IllegalStateException(CodigosExcepciones.UTILITY_CLASS.getMsg());
    }

    public static String obtenerFechaSistema(String strFormat) {
        SimpleDateFormat fechaActual = new SimpleDateFormat(strFormat);
        return fechaActual.format(new Date());
    }

    public static Date stringToDate(String strFormat, String strDate) {
        Date resultDate = null;
        SimpleDateFormat formatter = new SimpleDateFormat(strFormat);
        try {
            resultDate = formatter.parse(strDate);
        } catch (ParseException e) {
            LOGGER.error(CodigosExcepciones.BAD_FORMAT.getMsg());
        }
        return resultDate;
    }

    public static String obtenerFechaAnterior(String strFormat) {
        SimpleDateFormat currentDateWithoutFormat = new SimpleDateFormat(strFormat);
        Calendar calendar = Calendar.getInstance();

        calendar.add(Calendar.YEAR, -1900);
        calendar.add(Calendar.MONTH, 0);
        calendar.add(Calendar.DATE, -1);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DATE);

        return currentDateWithoutFormat.format(new GregorianCalendar(year, month, date));
    }

    public static String obtenerFechaAntes(String strFormat, int intMes, int intDia) {
        String result = null;
        SimpleDateFormat currentDateWithoutFormat = new SimpleDateFormat(strFormat);
        Calendar calendar = Calendar.getInstance();

        calendar.add(Calendar.YEAR, -1900);
        calendar.add(Calendar.MONTH, intMes);
        calendar.add(Calendar.DATE, intDia);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DATE);

        result = currentDateWithoutFormat.format(new GregorianCalendar(year, month, date));
        return result;
    }

}