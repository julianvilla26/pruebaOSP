package co.com.bancolombia.certificacion.app.exceptions.consultas.saldos;

public class ConsultaCrediagilNoEsCorrectaException extends AssertionError {
    public static final String CONSULTA_CREDIAGIL_NO_ES_CORRECTA = "No se encontró algún dato de la consulta del crediágil";

    public ConsultaCrediagilNoEsCorrectaException(String mensaje, Throwable causa){
        super(mensaje, causa);
    }
}
