package co.com.bancolombia.certificacion.app.tasks.autenticacion;

import co.com.bancolombia.certificacion.app.models.builders.ConfiguracionTransaccionBuilder;
import co.com.bancolombia.certificacion.app.models.builders.UsuarioBuilder;
import net.serenitybdd.screenplay.Performable;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante.CLASE_TASK;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IniciarSesion {

    public static Performable con(UsuarioBuilder usuarioBuilder) {
        return instrumented(ConCredenciales.class, usuarioBuilder.build());
    }

    public static Performable con(ConfiguracionTransaccionBuilder configuracionTransaccionBuilder) {
        return instrumented(ConDatosTransaccion.class, configuracionTransaccionBuilder.build());
    }

    public static Performable con(String usuario, String clave) {
        return instrumented(ConDatos.class, usuario, clave);
    }

    private IniciarSesion() {
        throw new IllegalStateException(CLASE_TASK);
    }
}