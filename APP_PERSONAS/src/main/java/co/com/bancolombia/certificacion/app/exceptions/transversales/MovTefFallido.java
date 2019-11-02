package co.com.bancolombia.certificacion.app.exceptions.transversales;

public class MovTefFallido extends AssertionError {

    public static final String MOV_TEF_FALLIDO = "Los valores obtenidos en el Mov Tef no son iguales a los valores esperados";

    public MovTefFallido(String mensaje) {
        super(mensaje);
    }

    public MovTefFallido(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

}
