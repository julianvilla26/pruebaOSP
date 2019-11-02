package co.com.bancolombia.certificacion.app.tasks.cargadatos;

import co.com.bancolombia.certificacion.app.models.builders.ConfiguracionTransaccionBuilder;
import co.com.bancolombia.certificacion.app.models.transaccion.ConfiguracionTransaccion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_DATOS_TRANSACCION;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CargarDatos implements Task {

    private ConfiguracionTransaccion configuracionTransaccion;

    public CargarDatos(ConfiguracionTransaccion configuracionTransaccion) {
        this.configuracionTransaccion = configuracionTransaccion;
    }

    public static CargarDatos transaccionCon(ConfiguracionTransaccionBuilder configuracionTransaccionBuilder) {
        return instrumented(CargarDatos.class, configuracionTransaccionBuilder.build());
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.remember(MODELO_DATOS_TRANSACCION, configuracionTransaccion);
    }
}
