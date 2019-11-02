package co.com.bancolombia.certificacion.app.exceptions.comunes;

public class MensajeCuentaSinSaldoException extends AssertionError {
    public static final String MENSAJE_CUENTA_SIN_SALDO_NO_PRESENTADO= "El mensaje de cuenta sin saldo no fue presentado";

    public MensajeCuentaSinSaldoException(String mensaje) {
        super(mensaje);
    }
}
