package co.com.bancolombia.certificacion.app.exceptions.transversales;

public class TopeBancoFallido extends AssertionError {

    public static final String TOPE_BANCO_FALLIDO = "Los topes banco no pueden ser verificados";

    public TopeBancoFallido(String mensaje) {
        super(mensaje);
    }

    public TopeBancoFallido(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

}
