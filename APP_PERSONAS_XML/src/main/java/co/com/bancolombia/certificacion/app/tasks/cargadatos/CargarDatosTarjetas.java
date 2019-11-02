package co.com.bancolombia.certificacion.app.tasks.cargadatos;

import co.com.bancolombia.certificacion.app.models.entidades.CargarEntidadTarjetaCredito;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * The type Transaction transaccionCon task.
 */
public class CargarDatosTarjetas implements Task {

    private final List<String> datos;

    public CargarDatosTarjetas(List<String> datos) {
        this.datos = datos;
    }

    public static CargarDatosTarjetas enApp(List<String> datos) {
        return instrumented(CargarDatosTarjetas.class, datos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        CargarEntidadTarjetaCredito.conEstos(datos);
    }
}

