package co.com.bancolombia.certificacion.app.exceptions.comunes;

public class BusquedaFallida extends AssertionError {

    public BusquedaFallida(String mensaje) {
        super(mensaje);
    }
}
