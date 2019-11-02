package co.com.bancolombia.certificacion.app.exceptions.codigoqr;

public class InformacionCodigoQrException extends AssertionError {
    public static final String INFORMACION_CONFIRMACION_INCORRECTA =
            "El codigo QR no fue presentado o la información no corresponde con la diligenciada";

    public InformacionCodigoQrException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
