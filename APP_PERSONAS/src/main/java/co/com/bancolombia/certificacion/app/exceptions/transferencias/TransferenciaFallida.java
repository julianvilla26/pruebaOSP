package co.com.bancolombia.certificacion.app.exceptions.transferencias;

public class TransferenciaFallida extends AssertionError {

    public static final String TRANSFERENCIA_FALLIDA = "El monto pagado no fue deducido de la cuenta origen";
    public static final String CASO_ALTERNO_FALLIDO = "El caso alterno no pudo ser verificado para la transferencia";

    public TransferenciaFallida(String mensaje) {super(mensaje);
    }

    public TransferenciaFallida(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
