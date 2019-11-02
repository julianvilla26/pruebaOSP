package co.com.bancolombia.certificacion.app.exceptions.consultas.saldos;

public class NoPoseeSoloCuentasDepositoException extends AssertionError{
    public static final String MENSAJE_NO_TIENE_UNICAMENTE_CUENTAS_DEPOSITO = "El usuario consultado posee mas de un producto diferente a Cuentas deposito (Ahorro - Corrinente)";

    public NoPoseeSoloCuentasDepositoException (String mensaje, Throwable causa){
        super(mensaje,causa);
    }
}
