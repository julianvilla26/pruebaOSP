package co.com.bancolombia.certificacion.app.questions.actualizardatos;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

import static co.com.bancolombia.certificacion.app.userinterface.pages.datosseguridad.ActualizarDatosSeguridadPage.LBL_ACTULIZACION_EXITOSA;
import static co.com.bancolombia.certificacion.app.userinterface.pages.datosseguridad.ActualizarDatosSeguridadPage.LBL_VERIFICACION_ACTUALIZACION_DATOS;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.VariablesSesionConstantes.*;

public class VerificarActualizacionDatosSeguridad implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        String correo = actor.recall(CORREO_CLAVE_DINAMICA);
        String tipoCorreo = actor.recall(TIPO_CORREO_CLAVE_DINAMICA);
        String numeroCelular = actor.recall(NUMERO_CELULAR);
        return (Visibility.of(LBL_ACTULIZACION_EXITOSA).viewedBy(actor).asBoolean() &&
                Visibility.of(LBL_VERIFICACION_ACTUALIZACION_DATOS.of(CORREO_CLAVE_DINAMICA, correo)).viewedBy(actor).asBoolean() &&
                Visibility.of(LBL_VERIFICACION_ACTUALIZACION_DATOS.of(TIPO_CORREO_CLAVE_DINAMICA, tipoCorreo)).viewedBy(actor).asBoolean() &&
                Visibility.of(LBL_VERIFICACION_ACTUALIZACION_DATOS.of(NUMERO_CELULAR, numeroCelular)).viewedBy(actor).asBoolean()
        );
    }

    public static VerificarActualizacionDatosSeguridad exitosa() {
        return new VerificarActualizacionDatosSeguridad();
    }
}