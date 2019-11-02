package co.com.bancolombia.certificacion.app.utilidades.administradores;

import co.com.bancolombia.backend.utilidades.enums.CodigosExcepciones;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Clase para manejar las funciones asociadas con la fecha.
 *
 * @author david.c.gonzalez
 */
public class DateManager {

    /**
     * The Constant LOGGER.
     */
    private static final Logger LOGGER = LogManager.getLogger(DateManager.class.getName());

    private DateManager() {
        throw new IllegalStateException(CodigosExcepciones.UTILITY_CLASS.getMsg());
    }

    /**
     * Este m&eacutetodo para obtener la fecha del sistema como una cadena de caracteres, de
     * acuerdo a un formato especifico.
     *
     * @param strFormat Formato de la fecha.
     * @return Devuelve la fecha actual con el formato deseado
     */
    public static String obtenerFechaSistema(String strFormat) {
        SimpleDateFormat fechaActual = new SimpleDateFormat(strFormat);
        return fechaActual.format(new Date());
    }

    /**
     * Metodo para convertir un fecha de tipo Date a String.
     *
     * @param strFormat El formato de la fecha
     * @param strDate   La fecha para formatear
     * @return String Devuelve la fecha recibida en el formato indicado.
     */
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

    /**
     * Obtener fecha anterior.
     *
     * @param strFormat the str format
     * @return the string
     */
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

    /**
     * Descripci&oacute;n  Componente generico encargado de sumar o restar meses o
     * dias a la fecha actual.
     *
     * @param strFormat - se espera el siguiente formato ej "yyyyMMdd"
     * @param intMes    - No sumar, no restar ej cero(0), para restar ej (-n), para            sumar ej (+n).
     * @param intDia    - No sumar, no restar ej cero(0), para restar ej (-n), para            sumar ej (+n).
     * @return retorna la siguiente variable (result), la cual contiene la fecha         calculada.
     */
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