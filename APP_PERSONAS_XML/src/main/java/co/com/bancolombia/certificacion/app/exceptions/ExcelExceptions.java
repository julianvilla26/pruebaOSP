package co.com.bancolombia.certificacion.app.exceptions;

//
// Clase de excepciones personalziadas de tipo RunTime
//
// @author Oscar Armando Vallejo Tovar
//
public class ExcelExceptions extends RuntimeException {

    /**
     * Instantiates a new Back end exceptions.
     */
    public ExcelExceptions() {
        super();
    }

    /**
     * Instantiates a new Back end exceptions.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public ExcelExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * Instantiates a new Back end exceptions.
     *
     * @param message the message
     * @param cause   the cause
     */
    public ExcelExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Back end exceptions.
     *
     * @param message the message
     */
    public ExcelExceptions(String message) {
        super(message);
    }

    /**
     * Instantiates a new Back end exceptions.
     *
     * @param cause the cause
     */
    public ExcelExceptions(Throwable cause) {
        super(cause);
    }


}
